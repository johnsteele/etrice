/**
 * @author generated by eTrice
 *
 * Source File of ActorClass Testee
 * 
 */

#include "Testee.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "platform/etMemory.h"

#include "PTestTrigger.h"

/*--------------------- begin user code ---------------------*/
	#include "etUnit/etUnit.h"
/*--------------------- end user code ---------------------*/

/* interface item IDs */
enum interface_items {
	IFITEM_tester = 1
};


/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_State1 = 2,
	STATE_State1_State1 = 3,
	STATE_State1_Done = 4
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__State1_tp0 = 1,
	CHAIN_State1_TRANS_State1_TO_Done_BY_triggertester = 2
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_tester__trigger = IFITEM_tester + EVT_SHIFT*PTestTrigger_IN_trigger
};


static void setState(Testee* self, int new_state) {
	self->state = new_state;
}

/* Entry and Exit Codes */
static void entry_State1(Testee* self) {
	EXPECT_ORDER("state State1 entry code\\n", 2);
}
static void entry_State1_State1(Testee* self) {
	EXPECT_ORDER("state State1_State1 entry code\\n", 4);
}
static void exit_State1_State1(Testee* self) {
	EXPECT_ORDER("state State1_State1 exit code\\n", 5);
}
static void entry_State1_Done(Testee* self) {
	EXPECT_ORDER_END("state State1_Done entry code\\n", 7);
	etUnit_closeAll();
}

/* Action Codes */
static void action_TRANS_INITIAL_TO__State1_tp0(Testee* self) {
	etUnit_openAll("tmp/testlog","GeneratorTest1", "GeneratorTest1", "GeneratorTest1");
	static etInt16 resultlist[] = {1,2,3,4,5,6,7};
	EXPECT_ORDER_START(resultlist, 7);
	EXPECT_ORDER("transition init: TRANS_INITIAL_TO__State1_tp0 action code\\n", 1);
}
static void action_State1_TRANS_tp0_TO_State1(Testee* self) {
	EXPECT_ORDER("transition tr0: TRANS_tp0_TO_State1 action code\\n", 3);
}
static void action_State1_TRANS_State1_TO_Done_BY_triggertester(Testee* self, InterfaceItemBase ifitem) {
	EXPECT_ORDER("transition tr1: TRANS_State1_TO_Done_BY_triggertester action code\\n", 6);
	PTestTriggerPort_done(&self->constData->tester) /* tester.done() */;
}

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
 */
static void exitTo(Testee* self, int current, int to, boolean handler) {
	while (current!=to) {
		switch (current) {
			case STATE_State1:
				self->history[STATE_TOP] = STATE_State1;
				current = STATE_TOP;
				break;
			case STATE_State1_State1:
				if (!handler) exit_State1_State1(self);
				self->history[STATE_State1] = STATE_State1_State1;
				current = STATE_State1;
				break;
			case STATE_State1_Done:
				self->history[STATE_State1] = STATE_State1_Done;
				current = STATE_State1;
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
static int executeTransitionChain(Testee* self, int chain, InterfaceItemBase ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__State1_tp0:
		{
			action_TRANS_INITIAL_TO__State1_tp0(self);
			entry_State1(self);
			action_State1_TRANS_tp0_TO_State1(self);
			return STATE_State1_State1;
		}
		case CHAIN_State1_TRANS_State1_TO_Done_BY_triggertester:
		{
			action_State1_TRANS_State1_TO_Done_BY_triggertester(self, ifitem);
			return STATE_State1_Done;
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
static int enterHistory(Testee* self, int state, boolean handler, boolean skip_entry) {
	while (TRUE) {
		switch (state) {
			case STATE_State1:
				if (!(skip_entry || handler)) entry_State1(self);
				// state has a sub graph
				// without init transition
				state = self->history[STATE_State1];
				break;
			case STATE_State1_State1:
				if (!(skip_entry || handler)) entry_State1_State1(self);
				// in leaf state: return state id
				return STATE_State1_State1;
			case STATE_State1_Done:
				if (!(skip_entry || handler)) entry_State1_Done(self);
				// in leaf state: return state id
				return STATE_State1_Done;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
		}
		skip_entry = FALSE;
	}
	//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
}

static void executeInitTransition(Testee* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__State1_tp0;
	int next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next, FALSE, FALSE);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void receiveEvent(Testee* self, InterfaceItemBase ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	int catching_state = NO_STATE;
	boolean is_handler = FALSE;
	boolean skip_entry = FALSE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (self->state) {
			case STATE_State1_State1:
				switch(trigger) {
					case TRIG_tester__trigger:
						{
							chain = CHAIN_State1_TRANS_State1_TO_Done_BY_triggertester;
							catching_state = STATE_State1;
						}
					break;
				}
				break;
			case STATE_State1_Done:
				break;
		}
	}
	if (chain != NOT_CAUGHT) {
		exitTo(self, self->state, catching_state, is_handler);
		int next = executeTransitionChain(self, chain, ifitem, generic_data);
		next = enterHistory(self, next, is_handler, skip_entry);
		setState(self, next);
	}
}
	 
//******************************************
// END of generated code for FSM
//******************************************

void Testee_init(Testee* self){
	ET_MSC_LOGGER_SYNC_ENTRY("Testee", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<TESTEE_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void Testee_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("Testee", "_receiveMessage")
	
	receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/

