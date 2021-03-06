package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.examples.dynamicactors8.Optional1;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;

public class Optional1Factory implements IOptionalActorFactory {
	
	private PathToPeers path2peers = new PathToPeers();
	
	public Optional1 create(OptionalActorInterfaceBase ai, String name) {
		// set port mappings of this sub tree
		path2peers.put("/sub/fct", "/fct");
		path2peers.put("/sub/dp", "/sub/deep/fct");
		path2peers.put("/sub/deep/fct", "/sub/dp");
		ai.setPath2peers(path2peers);
		
		// instantiate sub tree
		Optional1 actor = new Optional1(ai, name);
		
		ai.setPath2peers(null);
		
		return actor;
	}
}
