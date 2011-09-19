package org.eclipse.etrice.integration.tests;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.tests.p_HFSM.*;

//--------------------- begin user code
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
	//--------------------- end user code


public class a_HFSM_Tester extends ActorClassBase {

	
	//--------------------- ports
	protected p_HFSMConjPort testee = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_testee = 1;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public a_HFSM_Tester(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("a_HFSM_Tester");
		
		// initialize attributes

		// own ports
		testee = new p_HFSMConjPort(this, "testee", IFITEM_testee, 0, port_addr[IFITEM_testee][0], peer_addr[IFITEM_testee][0]); 
		// own saps
		// own service implementations
	}
	

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
		destroyUser();
	}	

	//******************************************
	// START of generated code for FSM
	//******************************************
	
	// State IDs for FSM
	protected static final int STATE_State1 = 2;
	protected static final int STATE_State2 = 3;
	protected static final int STATE_State3 = 4;
	protected static final int STATE_State4 = 5;
	protected static final int STATE_State5 = 6;
	protected static final int STATE_State6 = 7;
	protected static final int STATE_State7 = 8;
	protected static final int STATE_TestPass = 9;
		protected static final String stateStrings[] = {"<no state>","<top>","State1",
			"State2",
			"State3",
			"State4",
			"State5",
			"State6",
			"State7",
			"TestPass"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_TRANS_INITIAL_TO__State1 = 1;
	protected static final int CHAIN_TRANS_State1_TO_State2_BY_init_actiontestee = 2;
	protected static final int CHAIN_TRANS_State2_TO_State3_BY_s1_entrytestee = 3;
	protected static final int CHAIN_TRANS_State3_TO_State4_BY_s1_exittestee = 4;
	protected static final int CHAIN_TRANS_State4_TO_State5_BY_s1_m1_s2_actiontestee = 5;
	protected static final int CHAIN_TRANS_State5_TO_State6_BY_s2_entrytestee = 6;
	protected static final int CHAIN_TRANS_State6_TO_State7_BY_s2_m1_s2s1_actiontestee = 7;
	protected static final int CHAIN_TRANS_State7_TO_TestPass_BY_s2s1_entrytestee = 8;
	
	// triggers for FSM
	protected static final int TRIG_testee__init_action = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_init_action;
	protected static final int TRIG_testee__s1_entry = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s1_entry;
	protected static final int TRIG_testee__s1_exit = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s1_exit;
	protected static final int TRIG_testee__s1_m1_s2_action = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s1_m1_s2_action;
	protected static final int TRIG_testee__s2_entry = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s2_entry;
	protected static final int TRIG_testee__s2_m1_s2s1_action = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s2_m1_s2s1_action;
	protected static final int TRIG_testee__s2s1_entry = IFITEM_testee + EVT_SHIFT*p_HFSM.OUT_s2s1_entry;
	
	// receiveEvent contains the main implementation of the FSM
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (state) {
				case STATE_State1:
					switch(trigger) {
					case TRIG_testee__init_action:
						{
							chain = CHAIN_TRANS_State1_TO_State2_BY_init_actiontestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State2:
					switch(trigger) {
					case TRIG_testee__s1_entry:
						{
							chain = CHAIN_TRANS_State2_TO_State3_BY_s1_entrytestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State3:
					switch(trigger) {
					case TRIG_testee__s1_exit:
						{
							chain = CHAIN_TRANS_State3_TO_State4_BY_s1_exittestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State4:
					switch(trigger) {
					case TRIG_testee__s1_m1_s2_action:
						{
							chain = CHAIN_TRANS_State4_TO_State5_BY_s1_m1_s2_actiontestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State5:
					switch(trigger) {
					case TRIG_testee__s2_entry:
						{
							chain = CHAIN_TRANS_State5_TO_State6_BY_s2_entrytestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State6:
					switch(trigger) {
					case TRIG_testee__s2_m1_s2s1_action:
						{
							chain = CHAIN_TRANS_State6_TO_State7_BY_s2_m1_s2s1_actiontestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_State7:
					switch(trigger) {
					case TRIG_testee__s2s1_entry:
						{
							chain = CHAIN_TRANS_State7_TO_TestPass_BY_s2s1_entrytestee;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_TestPass:
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			// TODOTS: model switch for activation
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	@Override
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__State1;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_State1:
					history[STATE_TOP] = STATE_State1;
					current = STATE_TOP;
					break;
				case STATE_State2:
					history[STATE_TOP] = STATE_State2;
					current = STATE_TOP;
					break;
				case STATE_State3:
					history[STATE_TOP] = STATE_State3;
					current = STATE_TOP;
					break;
				case STATE_State4:
					history[STATE_TOP] = STATE_State4;
					current = STATE_TOP;
					break;
				case STATE_State5:
					history[STATE_TOP] = STATE_State5;
					current = STATE_TOP;
					break;
				case STATE_State6:
					history[STATE_TOP] = STATE_State6;
					current = STATE_TOP;
					break;
				case STATE_State7:
					history[STATE_TOP] = STATE_State7;
					current = STATE_TOP;
					break;
				case STATE_TestPass:
					history[STATE_TOP] = STATE_TestPass;
					current = STATE_TOP;
					break;
			}
		}
	}
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__State1:
			{
				return STATE_State1;
			}
			case CHAIN_TRANS_State1_TO_State2_BY_init_actiontestee:
			{
				return STATE_State2;
			}
			case CHAIN_TRANS_State2_TO_State3_BY_s1_entrytestee:
			{
				action_TRANS_State2_TO_State3_BY_s1_entrytestee(ifitem);
				return STATE_State3;
			}
			case CHAIN_TRANS_State3_TO_State4_BY_s1_exittestee:
			{
				return STATE_State4;
			}
			case CHAIN_TRANS_State4_TO_State5_BY_s1_m1_s2_actiontestee:
			{
				return STATE_State5;
			}
			case CHAIN_TRANS_State5_TO_State6_BY_s2_entrytestee:
			{
				return STATE_State6;
			}
			case CHAIN_TRANS_State6_TO_State7_BY_s2_m1_s2s1_actiontestee:
			{
				return STATE_State7;
			}
			case CHAIN_TRANS_State7_TO_TestPass_BY_s2s1_entrytestee:
			{
				return STATE_TestPass;
			}
		}
		return NO_STATE;
	}
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_State1:
					// in leaf state: return state id
					return STATE_State1;
				case STATE_State2:
					// in leaf state: return state id
					return STATE_State2;
				case STATE_State3:
					// in leaf state: return state id
					return STATE_State3;
				case STATE_State4:
					// in leaf state: return state id
					return STATE_State4;
				case STATE_State5:
					// in leaf state: return state id
					return STATE_State5;
				case STATE_State6:
					// in leaf state: return state id
					return STATE_State6;
				case STATE_State7:
					// in leaf state: return state id
					return STATE_State7;
				case STATE_TestPass:
					if (!(skip_entry || handler)) entry_TestPass();
					// in leaf state: return state id
					return STATE_TestPass;
				case STATE_TOP:
					state = history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	//*** Entry and Exit Codes
	protected void entry_TestPass() {
		RTServices.getInstance().getSubSystem().testFinished(0);
	}
	
	//*** Action Codes
	protected void action_TRANS_State2_TO_State3_BY_s1_entrytestee(InterfaceItemBase ifitem) {
		testee.m1();
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};