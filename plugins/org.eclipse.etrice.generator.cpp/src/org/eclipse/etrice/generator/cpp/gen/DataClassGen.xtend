/*******************************************************************************
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.cpp.gen.Initialization
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.cpp.GeneratorOptions

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*

/**
 * @author Peter Karlitschek
 *
 */
@Singleton
class DataClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension CppExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers typeHelpers
	@Inject extension Initialization
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		logger.logInfo("generating code")
		for (dc: root.usedDataClasses) {
			var path = dc.generationTargetPath + dc.getPath

			// header file
			logger.logInfo("generating DataClass header '"+dc.getCppHeaderFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(dc.getCppHeaderFileName, root.generateHeaderFile(dc))
			
			// source file
			logger.logInfo("generating DataClass source '"+dc.getCppSourceFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(dc.getCppSourceFileName, root.generateSourceFile(dc))
			
		}
		
	}
	
	def generateHeaderFile(Root root, DataClass dc) {
		val ctor = dc.operations.filter(op|op.constructor).head
		val dtor = dc.operations.filter(op|op.destructor).head
		//TODO: getReferencedDataClasses does not contain a base class of the own package
	'''
		�generateIncludeGuardBegin(dc.path + dc.name)�
		
		�IF dc.base!=null�
		#include "�dc.base.path��dc.base.name�.h"
		�ENDIF�
		�FOR classes : root.getReferencedDataClasses(dc)�
		#include "�classes.path��classes.name�.h"
		�ENDFOR�
		�var models = root.getReferencedModels(dc)�
		�FOR model : models�
		�FOR classes : model.dataClasses�
		#include "�classes.path��classes.name�.h"
		�ENDFOR�
		�ENDFOR�
		
		�helpers.userCode(dc.userCode1)�
		
		
		class �dc.name��IF dc.base!=null� : public �dc.base.name��ENDIF� {
			
		public:
			�helpers.userCode(dc.userCode2)�
			
			�helpers.attributes(dc.attributes)�
			
			�helpers.attributeSettersGettersImplementation(dc.attributes, dc.name)�
			
			�helpers.operationsDeclaration(dc.operations, dc.name)�
			
			// default constructor, copy constructor and assignment operator
			�dc.name�();
			�dc.name�(const �dc.name�& rhs);
			�dc.name�& operator=(const �dc.name�& rhs);
			
			// constructor using fields
			�dc.name�(�dc.argList�);
			
			�IF dc.base!=null�
			// constructor using base class constructor
			�dc.name�(�dc.base.name� _super, �dc.attributes.argListConstructor.toString�);
			�ENDIF�
			
		};
		
		�generateIncludeGuardEnd(dc.name)�
		
	'''
	}
	
	def generateSourceFile(Root root, DataClass dc) {
		val ctor = dc.operations.filter(op|op.constructor).head
		val dtor = dc.operations.filter(op|op.destructor).head	
		
		'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of DataClass �dc.name�
		 */

		#include "�dc.getCppHeaderFileName�"
		�IF GeneratorOptions::useEtUnit�
			extern "C" {
				#include "etUnit.h"
			}
		�ENDIF�
		
		�helpers.userCode(dc.userCode3)�
		

		// default constructor
		�dc.name�::�dc.name�() 
			�IF dc.base!=null�
			:�dc.base.name�()
			�ENDIF�
		{
			�dc.attributes.attributeInitialization(false)�
			�IF ctor!=null�
			{
				// user defined constructor body
				�FOR l : ctor.detailCode.lines�
					�l�
				�ENDFOR�
			}
			�ENDIF�
		}
			
		// copy constructor
		�dc.name�::�dc.name�(const �dc.name�& rhs)
			:
			�IF dc.base!=null�
			�dc.base.name�(rhs),
			�ENDIF�
			�FOR a : dc.attributes SEPARATOR ","�
			�a.name�(rhs.�a.name�)
			�ENDFOR�
		{
		}

		// constructor using fields
		�dc.name�::�dc.name�(�dc.argList�) 
			:
			�IF dc.base!=null�
			�dc.base.name�(�dc.base.paramList�),
			�ENDIF�
			�FOR a : dc.attributes SEPARATOR ","�
			�a.name�(�a.name�_)
			�ENDFOR�
		{
		}
		
		�IF dc.base!=null�
		// constructor using base class constructor
		�dc.name�::�dc.name�(�dc.base.name� _super, �dc.attributes.argListConstructor.toString�)
			:
			�dc.base.name�(_super),
			�FOR a : dc.attributes SEPARATOR ","�
			�a.name�(�a.name�_)
			�ENDFOR�
		{
		}
		�ENDIF�
		
		// assignment operator
		�dc.name�& �dc.name�::operator=(const �dc.name�& rhs)
		{		
			if (this == &rhs) { return *this; };
			�IF dc.base!=null�
			�dc.base.name�::operator=(rhs);
			�ENDIF�
			�FOR a : dc.attributes�
			�a.name�= rhs.�a.name�;
			�ENDFOR�
			return *this;
		}			
		
		�helpers.operationsImplementation(dc.operations, dc.name)�
		
	'''}
	
	def paramList(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = dc.attributes.paramList.toString + result
			dc = dc.base
			if (dc!=null)
				result = ", "+result
		}
		return result
	}
	
	def paramList(List<Attribute> attributes) {
		'''�FOR a: attributes SEPARATOR ", "��a.name�_�ENDFOR�'''
	}
	
	def argList(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = dc.attributes.argListConstructor.toString + result
			dc = dc.base
			if (dc!=null)
				result = ", "+result
		}
		return result
	}
	
	def argListConstructor(List<Attribute> attributes) {
		'''�FOR a : attributes SEPARATOR ", "��a.type.type.typeName��IF a.size>1�[]�ENDIF� �a.name�_�ENDFOR�'''
	}

	
	
	def deepCopy(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = deepCopy(dc.attributes).toString + result
			dc = dc.base
		}
		return result
	}
	
	def deepCopy(List<Attribute> attributes) {
		'''
		�FOR a : attributes�
			�IF a.type.type instanceof ComplexType�
				if (�a.name�!=null) {
					�IF a.size==0�
						copy.�a.name� = �a.name�.deepCopy();
					�ELSE�
						for (int i=0;i<�a.name�.length;i++){
							copy.�a.name�[i] = �a.name�[i].deepCopy();
						}
					�ENDIF�
				}
			�ELSE�
				�IF a.size==0�
					copy.�a.name� = �a.name�;
				�ELSE�
					for (int i=0;i<�a.name�.length;i++){
						copy.�a.name�[i] = �a.name�[i];
					}
				�ENDIF�
			�ENDIF�
		�ENDFOR�
		'''
	}

}
