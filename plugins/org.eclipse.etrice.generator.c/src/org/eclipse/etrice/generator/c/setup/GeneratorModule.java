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

package org.eclipse.etrice.generator.c.setup;

import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.AbstractGeneratorBaseModule;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.c.gen.CTranslationProvider;
import org.eclipse.etrice.generator.c.gen.MainGen;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.config.DataConfiguration;
import com.google.inject.Binder;

public class GeneratorModule extends AbstractGeneratorBaseModule {

//	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
		binder.bind(AbstractGenerator.class).to(Main.class);
		binder.bind(IGenerator.class).to(MainGen.class);
	}

	@Override
	public Class<? extends ILanguageExtension> bindILanguageExtension() {
		return CExtensions.class;
	}

	@Override
	public Class<? extends ITranslationProvider> bindITranslationProvider() {
		return CTranslationProvider.class;
	}

	@Override
	public Class<? extends IDataConfiguration> bindIDataConfiguration() {
		return DataConfiguration.class;
	}

}
