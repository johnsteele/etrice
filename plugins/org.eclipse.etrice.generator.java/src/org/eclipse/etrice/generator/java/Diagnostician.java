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

package org.eclipse.etrice.generator.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.generator.etricegen.IDiagnostician;

/**
 * @author hrentz
 *
 */
public class Diagnostician implements IDiagnostician {

	private boolean validationFailed = false;

	public void warning(String msg, EObject source, EStructuralFeature feature) {
		System.out.println("Validation warning: " + msg + " " + source.toString() + " " + feature.toString());
	}

	public void warning(String msg, EObject source, EStructuralFeature feature, int idx) {
		System.out.println("Validation warning: " + msg + " " + source.toString() + " " + feature.toString());
	}

	public void error(String msg, EObject source, EStructuralFeature feature) {
		validationFailed = true;
		System.out.println("Validation error: " + msg + " " + source.toString() + " " + feature.toString());
	}

	public void error(String msg, EObject source, EStructuralFeature feature, int idx) {
		validationFailed = true;
		System.out.println("Validation error: " + msg + " " + source.toString() + " " + feature.toString());
	}

	public boolean isFailed() {
		return validationFailed;
	}

}
