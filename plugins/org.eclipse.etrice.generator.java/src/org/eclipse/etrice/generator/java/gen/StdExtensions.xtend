/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.FreeType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.Type
import org.eclipse.etrice.core.room.TypedID
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain
import org.eclipse.etrice.generator.extensions.RoomExtensions


@Singleton
class StdExtensions extends RoomExtensions {

	@Inject JavaGenerator javaGen
	
	//-------------------------------------------------------
	// packages and pathes
	
	def String getPackage(RoomClass rc) {
		return (rc.eContainer as RoomModel).name
	}
	
	def String getPathFromPackage(String packageName) {
		return packageName.replaceAll("\\.", "/") + "/"
	}
	
	def String getPath(RoomClass rc) {
		getPathFromPackage(getPackage(rc))
	}

	def String getFileName(RoomClass rc) {
		return rc.name+".java";
	}
	
	//-------------------------------------------------------
	// Java types
	
	// type names for Type class (distinguish Primitive and DataClass)
	def String toJavaType(PrimitiveType prim) {
		return switch(prim.toString()) {
			case 'uint8': 'undefined_type'
			case 'uint16': 'undefined_type'
			case 'uint32': 'undefined_type'
			case 'int8': 'byte'
			case 'int16': 'short'
			case 'int32': 'int'
			case 'float32': 'float'
			case 'float64': 'double'
			case 'string' : 'String'
			default: prim.toString()
		}
	}
	def String toJavaObjectType(PrimitiveType prim) {
		return switch(prim.toString()) {
			case 'uint8': 'undefined_type'
			case 'uint16': 'undefined_type'
			case 'uint32': 'undefined_type'
			case 'int8': 'Byte'
			case 'int16': 'Short'
			case 'int32': 'Integer'
			case 'float32': 'Float'
			case 'float64': 'Double'
			case 'string': 'String'
			default: prim.toString()
		}
	}
	def String typeName(Type type) {
		if (type.type!=null)
			return type.type.name
		else
			type.prim.toJavaType
	}
	def String freeTypeName(FreeType type) {
		if (type.type!=null)
			return type.type
		else
			type.prim.toJavaType
	}
	def String typeObjectName(Type type) {
		if (type.type!=null)
			return type.type.name
		else
			type.prim.toJavaObjectType()
	}

	// default values for data
	def String defaultValue(PrimitiveType prim) {
		return switch(prim.toString()) {
			case 'uint8': '0'
			case 'uint16': '0'
			case 'uint32': '0'
			case 'int8': '0'
			case 'int16': '0'
			case 'int32': '0'
			case 'float32': '0.0'
			case 'float64': '0.0'
			case 'string': '""'
			default: prim.toString()
		};
	}
	def String defaultValue(TypedID a) {
		if (a.type.type!=null)
			return "new "+a.type.type.name+"()"
		else
			return a.type.prim.defaultValue
	}

	def String getTypedDataDefinition(Message m) {
		return javaGen.getTypedData(m)
	}

	//-------------------------------------------------------
	// transition chain visitor
		
	def String getExecuteChainCode(ExpandedActorClass ac, TransitionChain tc) {
		return javaGen.getExecuteChain(ac, tc)
	}
}