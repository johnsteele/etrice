package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;



public class Node_nodeRef1_main extends SubSystemClassBase {
	
	public static final int THREAD_PHYSICALTHREAD1 = 0;

	
	public Node_nodeRef1_main(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		IMessageService msgService;
		msgService = new MessageService(this, MessageService.ExecMode.MIXED, 100000000, 0, THREAD_PHYSICALTHREAD1, "MessageService_PhysicalThread1" /*, thread_prio */);
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);
	}

	@Override
	public void instantiateActors() {
		
		// thread mappings
		addPathToThread("/LogSys1/main/main", THREAD_PHYSICALTHREAD1);
		addPathToThread("/LogSys1/main/main/cont", THREAD_PHYSICALTHREAD1);
		
		// port to peer port mappings
		addPathToPeers("/LogSys1/main/main/cont/op", "/LogSys1/main/main/cont/opt/fct");
		addPathToPeers("/LogSys1/main/main/cont/opa", "/LogSys1/main/main/cont/optarr/fct");
		addPathToPeers("/LogSys1/main/main/cont/opt/fct", "/LogSys1/main/main/cont/op");
		addPathToPeers("/LogSys1/main/main/cont/optarr/fct", "/LogSys1/main/main/cont/opa");

		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "main");
		new Appl(this, "main"); 
		
		// apply instance attribute configurations
	}
	
	@Override
	public void init(){
		DebuggingService.getInstance().addVisibleComment("begin sub system initialization");
		super.init();
		DebuggingService.getInstance().addVisibleComment("done sub system initialization");
	}
		
	@Override
	public void stop(){
		super.stop();
	}
	
	@Override
	public void destroy() {
		DebuggingService.getInstance().addVisibleComment("begin sub system destruction");
		super.destroy();
		DebuggingService.getInstance().addVisibleComment("done sub system destruction");
	}
	
	public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {
		if (optionalActorClass.equals("Optional")) {
			if ("Optional1".equals(actorClass)) {
				return new Optional1Factory();
			}
			else if ("Optional2".equals(actorClass)) {
				return new Optional2Factory();
			}
		}
		
		return null;
	}
};
