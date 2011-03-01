/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.ui.internal;

import static com.google.inject.util.Modules.override;
import static com.google.inject.Guice.createInjector;

import org.apache.log4j.Logger;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;

import java.net.URL;
import java.util.Map;
import java.util.HashMap;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class RoomActivator extends AbstractUIPlugin {

	private Map<String,Injector> injectors = new HashMap<String,Injector>();
	private static RoomActivator INSTANCE;

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		declareRegistryImage("defaultoutlinenode.gif", "icons/defaultoutlinenode.gif");

		INSTANCE = this;
		try {
			registerInjectorFor("org.eclipse.etrice.core.Room");
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	protected void registerInjectorFor(String language) throws Exception {
		injectors.put(language, createInjector(
		  override(override(getRuntimeModule(language)).with(getSharedStateModule())).with(getUiModule(language))));
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		injectors.clear();
		getImageRegistry().dispose();
		INSTANCE = null;
		super.stop(context);
	}
	
	public static RoomActivator getInstance() {
		return INSTANCE;
	}
	
	protected Module getRuntimeModule(String grammar) {
		if ("org.eclipse.etrice.core.Room".equals(grammar)) {
		  return new org.eclipse.etrice.core.RoomRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getUiModule(String grammar) {
		if ("org.eclipse.etrice.core.Room".equals(grammar)) {
		  return new org.eclipse.etrice.core.ui.RoomUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}
	
	private void declareRegistryImage(String key, String path) {
		ImageDescriptor desc= ImageDescriptor.getMissingImageDescriptor();
		Bundle bundle= getBundle();
		URL url= null;
		if (bundle != null) {
			url= FileLocator.find(bundle, new Path(path), null);
			desc= ImageDescriptor.createFromURL(url);
		}
		getImageRegistry().put(key, desc);
	}
	
}
