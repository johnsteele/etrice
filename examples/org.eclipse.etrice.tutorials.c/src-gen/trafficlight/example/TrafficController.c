/**
 * @author generated by eTrice
 *
 * Source File of ActorClass TrafficController
 * 
 */

#include "TrafficController.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "etUnit/etUnit.h"
#include "osal/etMemory.h"

#include "room/basic/service/timing/PTimer.h"
#include "trafficlight/example/PTrafficLight.h"


/* interface item IDs */
enum interface_items {
	IFITEM_light1 = 1,
	IFITEM_light2 = 2,
	IFITEM_timeout = 3
};

/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_Idle = 2,
	STATE_Light1GreenForCars = 3,
	STATE_SwitchToLight1GreenForCars = 4,
	STATE_state0 = 5,
	STATE_state1 = 6,
	STATE_SwitchToLight2GreenForCars = 7,
	STATE_state2 = 8,
	STATE_state3 = 9,
	STATE_Light2GreenForCars = 10,
	STATE_MAX = 11
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__Idle = 1,
	CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout = 2,
	CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1 = 3,
	CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2 = 4,
	CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1 = 5,
	CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2 = 6,
	CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout = 7,
	CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1 = 8,
	CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2 = 9,
	CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2 = 10,
	CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1 = 11,
	CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout = 12
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_light1__greenForCarDone = IFITEM_light1 + EVT_SHIFT*PTrafficLight_OUT_greenForCarDone,
	TRIG_light2__greenForCarDone = IFITEM_light2 + EVT_SHIFT*PTrafficLight_OUT_greenForCarDone,
	TRIG_timeout__timeout = IFITEM_timeout + EVT_SHIFT*PTimer_OUT_timeout,
	TRIG_light2__greenForPedDone = IFITEM_light2 + EVT_SHIFT*PTrafficLight_OUT_greenForPedDone,
	TRIG_light1__greenForPedDone = IFITEM_light1 + EVT_SHIFT*PTrafficLight_OUT_greenForPedDone
};


static void setState(TrafficController* self, etInt16 new_state) {
	self->state = new_state;
}

static etInt16 getState(TrafficController* self) {
	return self->state;
}

/* Entry and Exit Codes */
static void entry_Idle(TrafficController* self) {
	PTimerConjPort_startTimeout(&self->constData->timeout, 3000) /* ORIG: timeout.startTimeout(3000) */;
}
static void entry_Light1GreenForCars(TrafficController* self) {
	PTimerConjPort_startTimeout(&self->constData->timeout, 10000) /* ORIG: timeout.startTimeout(10000) */;
}
static void entry_SwitchToLight1GreenForCars(TrafficController* self) {
	PTrafficLightConjPort_greenForCar(&self->constData->light1) /* ORIG: light1.greenForCar() */;
	PTrafficLightConjPort_greenForPed(&self->constData->light2) /* ORIG: light2.greenForPed() */;
}
static void entry_SwitchToLight2GreenForCars(TrafficController* self) {
	PTrafficLightConjPort_greenForPed(&self->constData->light1) /* ORIG: light1.greenForPed() */;
	PTrafficLightConjPort_greenForCar(&self->constData->light2) /* ORIG: light2.greenForCar() */;
}
static void entry_Light2GreenForCars(TrafficController* self) {
	PTimerConjPort_startTimeout(&self->constData->timeout, 10000) /* ORIG: timeout.startTimeout(10000) */;
}

/* Action Codes */

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 */
static void exitTo(TrafficController* self, etInt16 current, etInt16 to) {
	while (current!=to) {
		switch (current) {
			case STATE_Idle:
				self->history[STATE_TOP] = STATE_Idle;
				current = STATE_TOP;
				break;
			case STATE_Light1GreenForCars:
				self->history[STATE_TOP] = STATE_Light1GreenForCars;
				current = STATE_TOP;
				break;
			case STATE_SwitchToLight1GreenForCars:
				self->history[STATE_TOP] = STATE_SwitchToLight1GreenForCars;
				current = STATE_TOP;
				break;
			case STATE_state0:
				self->history[STATE_TOP] = STATE_state0;
				current = STATE_TOP;
				break;
			case STATE_state1:
				self->history[STATE_TOP] = STATE_state1;
				current = STATE_TOP;
				break;
			case STATE_SwitchToLight2GreenForCars:
				self->history[STATE_TOP] = STATE_SwitchToLight2GreenForCars;
				current = STATE_TOP;
				break;
			case STATE_state2:
				self->history[STATE_TOP] = STATE_state2;
				current = STATE_TOP;
				break;
			case STATE_state3:
				self->history[STATE_TOP] = STATE_state3;
				current = STATE_TOP;
				break;
			case STATE_Light2GreenForCars:
				self->history[STATE_TOP] = STATE_Light2GreenForCars;
				current = STATE_TOP;
				break;
			default:
				/* should not occur */
				break;
		}
	}
}

/**
 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
 * matching the trigger of this chain. The ID of the final state is returned
 * @param chain - the chain ID
 * @param generic_data - the generic data pointer
 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
 */
static etInt16 executeTransitionChain(TrafficController* self, int chain, const InterfaceItemBase* ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__Idle:
		{
			return STATE_Idle;
		}
		case CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout:
		{
			return STATE_SwitchToLight1GreenForCars;
		}
		case CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1:
		{
			return STATE_state0;
		}
		case CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2:
		{
			return STATE_state1;
		}
		case CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1:
		{
			return STATE_Light1GreenForCars;
		}
		case CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2:
		{
			return STATE_Light1GreenForCars;
		}
		case CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout:
		{
			return STATE_SwitchToLight2GreenForCars;
		}
		case CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1:
		{
			return STATE_state2;
		}
		case CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2:
		{
			return STATE_state3;
		}
		case CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2:
		{
			return STATE_Light2GreenForCars;
		}
		case CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1:
		{
			return STATE_Light2GreenForCars;
		}
		case CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout:
		{
			return STATE_SwitchToLight1GreenForCars;
		}
			default:
				/* should not occur */
				break;
	}
	return NO_STATE;
}

/**
 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
 * @param state - the state which is entered
 * @return - the ID of the final leaf state
 */
static etInt16 enterHistory(TrafficController* self, etInt16 state) {
	boolean skip_entry = FALSE;
	if (state >= STATE_MAX) {
		state = (etInt16) (state - STATE_MAX);
		skip_entry = TRUE;
	}
	while (TRUE) {
		switch (state) {
			case STATE_Idle:
				if (!(skip_entry)) entry_Idle(self);
				/* in leaf state: return state id */
				return STATE_Idle;
			case STATE_Light1GreenForCars:
				if (!(skip_entry)) entry_Light1GreenForCars(self);
				/* in leaf state: return state id */
				return STATE_Light1GreenForCars;
			case STATE_SwitchToLight1GreenForCars:
				if (!(skip_entry)) entry_SwitchToLight1GreenForCars(self);
				/* in leaf state: return state id */
				return STATE_SwitchToLight1GreenForCars;
			case STATE_state0:
				/* in leaf state: return state id */
				return STATE_state0;
			case STATE_state1:
				/* in leaf state: return state id */
				return STATE_state1;
			case STATE_SwitchToLight2GreenForCars:
				if (!(skip_entry)) entry_SwitchToLight2GreenForCars(self);
				/* in leaf state: return state id */
				return STATE_SwitchToLight2GreenForCars;
			case STATE_state2:
				/* in leaf state: return state id */
				return STATE_state2;
			case STATE_state3:
				/* in leaf state: return state id */
				return STATE_state3;
			case STATE_Light2GreenForCars:
				if (!(skip_entry)) entry_Light2GreenForCars(self);
				/* in leaf state: return state id */
				return STATE_Light2GreenForCars;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
			default:
				/* should not occur */
				break;
		}
		skip_entry = FALSE;
	}
	/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
}

static void TrafficController_executeInitTransition(TrafficController* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__Idle;
	etInt16 next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void TrafficController_receiveEvent(TrafficController* self, InterfaceItemBase* ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	etInt16 catching_state = NO_STATE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (getState(self)) {
			case STATE_Idle:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_Light1GreenForCars:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_SwitchToLight1GreenForCars:
				switch(trigger) {
						case TRIG_light1__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_light2__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_state0:
				switch(trigger) {
						case TRIG_light2__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_state1:
				switch(trigger) {
						case TRIG_light1__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_SwitchToLight2GreenForCars:
				switch(trigger) {
						case TRIG_light1__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_light2__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_state2:
				switch(trigger) {
						case TRIG_light2__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_state3:
				switch(trigger) {
						case TRIG_light1__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_Light2GreenForCars:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			default:
				/* should not occur */
				break;
		}
	}
	if (chain != NOT_CAUGHT) {
		exitTo(self, getState(self), catching_state);
		{
			etInt16 next = executeTransitionChain(self, chain, ifitem, generic_data);
			next = enterHistory(self, next);
			setState(self, next);
		}
	}
}

void TrafficController_init(TrafficController* self){
	ET_MSC_LOGGER_SYNC_ENTRY("TrafficController", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<TRAFFICCONTROLLER_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	TrafficController_executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void TrafficController_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("TrafficController", "_receiveMessage")
	
	TrafficController_receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/
void TrafficController_ctor(TrafficController* self) {
	etInitSockets();
}
void TrafficController_dtor(TrafficController* self) {
	etCleanupSockets();
}

