/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import com.google.inject.Inject

import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import static extension org.eclipse.xtext.xtend2.lib.*

import org.eclipse.etrice.core.room.*
import org.eclipse.etrice.generator.etricegen.*

class SubSystemRunnerGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension StdExtensions stdExt
	
	def doGenerate(Root root) {
		for (sc: root.subSystemInstances) {
			fileAccess.setOutputPath(sc.subSystemClass.generationTargetPath+sc.subSystemClass.getPath)
			fileAccess.generateFile( sc.name+"Runner.java", root.generate(sc, sc.subSystemClass))
		}
	}
	
	def generate(Root root, SubSystemInstance ssc, SubSystemClass cc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * this class contains the main function running component �ssc.name�
		 * it instantiates �ssc.name� and starts and ends the lifecycle
		 */
		
		package �cc.getPackage()�;
		
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemRunnerBase;
		
		class �ssc.name+"Runner"� extends SubSystemRunnerBase {
		
			static �ssc.name� main_component = new �ssc.name�(null, "�ssc.name�");
		
			/**
		     * main function
		     * creates component and starts and stops the lifecycle
		     */
			public static void main(String[] args) {
		
				System.out.println("***   T H E   B E G I N   ***");
				
				main_component.init(); // lifecycle init
				main_component.start(); // lifecycle start
		
				// application runs until quit 
				waitForQuit();
				
				// end the lifecycle
				main_component.stop(); // lifecycle stop
				main_component.destroy(); // lifecycle destroy
		
				System.out.println("***   T H E   E N D   ***");
			}
		};
	'''
	}	
}