/**
 * @author generated by eTrice
 *
 * Source File of ActorClass TrafficLight
 * 
 */

#include "TrafficLight.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "etUnit/etUnit.h"
#include "platform/etMemory.h"

#include "room/basic/service/tcp/PTcpControl.h"
#include "room/basic/service/tcp/PTcpPayload.h"
#include "room/basic/service/timing/PTimer.h"
#include "trafficlight/example/PTrafficLight.h"


/* interface item IDs */
enum interface_items {
	IFITEM_controller = 1,
	IFITEM_tcpCtrl = 2,
	IFITEM_tcpPayload = 3,
	IFITEM_timeout = 4,
	IFITEM_blinkerTimeout = 5
};

/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_Off_Blinking = 2,
	STATE_OpenSocket = 3,
	STATE_CarYellow = 4,
	STATE_PedRed = 5,
	STATE_CarGreen = 6,
	STATE_Off_Blinking_On = 7,
	STATE_Off_Blinking_Off = 8,
	STATE_CarYellow2 = 9,
	STATE_CarRed = 10,
	STATE_PedGreen = 11,
	STATE_MAX = 12
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__OpenSocket = 1,
	CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl = 2,
	CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller = 3,
	CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout = 4,
	CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout = 5,
	CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller = 6,
	CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout = 7,
	CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout = 8,
	CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller = 9,
	CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller = 10,
	CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout = 11,
	CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout = 12
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_controller__greenForCar = IFITEM_controller + EVT_SHIFT*PTrafficLight_IN_greenForCar,
	TRIG_timeout__timeout = IFITEM_timeout + EVT_SHIFT*PTimer_OUT_timeout,
	TRIG_blinkerTimeout__timeout = IFITEM_blinkerTimeout + EVT_SHIFT*PTimer_OUT_timeout,
	TRIG_controller__greenForPed = IFITEM_controller + EVT_SHIFT*PTrafficLight_IN_greenForPed,
	TRIG_tcpCtrl__established = IFITEM_tcpCtrl + EVT_SHIFT*PTcpControl_OUT_established
};


static void setState(TrafficLight* self, int new_state) {
	self->state = new_state;
}

static int getState(TrafficLight* self) {
	return self->state;
}

/* Entry and Exit Codes */
static void entry_OpenSocket(TrafficLight* self) {
	PTcpControlConjPort_open(&self->constData->tcpCtrl, &(self->ipConfig /* ORIG: ipConfig */)) /* ORIG: tcpCtrl.open(&(ipConfig)) */;
}
static void entry_CarYellow(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=yellow\n") /* ORIG: sendString("carLights=yellow\n") */;
	PTimerConjPort_startTimeout(&self->constData->timeout, 1000) /* ORIG: timeout.startTimeout(1000) */;
}
static void entry_PedRed(TrafficLight* self) {
	TrafficLight_sendString(self, "pedLights=red\n") /* ORIG: sendString("pedLights=red\n") */;
	TrafficLight_sendString(self, "carLights=red\n") /* ORIG: sendString("carLights=red\n") */;
	PTimerConjPort_startTimeout(&self->constData->timeout, 1000) /* ORIG: timeout.startTimeout(1000) */;
}
static void entry_CarGreen(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=green\n") /* ORIG: sendString("carLights=green\n") */;
	PTrafficLightPort_greenForCarDone(&self->constData->controller) /* ORIG: controller.greenForCarDone() */;
}
static void entry_Off_Blinking_On(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=red\n") /* ORIG: sendString("carLights=red\n") */;
	TrafficLight_sendString(self, "pedLights=red\n") /* ORIG: sendString("pedLights=red\n") */;
	PTimerConjPort_startTimeout(&self->constData->blinkerTimeout, 500) /* ORIG: blinkerTimeout.startTimeout(500) */;
}
static void exit_Off_Blinking_On(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=off\n") /* ORIG: sendString("carLights=off\n") */;
	TrafficLight_sendString(self, "pedLights=off\n") /* ORIG: sendString("pedLights=off\n") */;
}
static void entry_Off_Blinking_Off(TrafficLight* self) {
	PTimerConjPort_startTimeout(&self->constData->blinkerTimeout, 500) /* ORIG: blinkerTimeout.startTimeout(500) */;
}
static void entry_CarYellow2(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=yellow\n") /* ORIG: sendString("carLights=yellow\n") */;
	PTimerConjPort_startTimeout(&self->constData->timeout, 1000) /* ORIG: timeout.startTimeout(1000) */;
}
static void entry_CarRed(TrafficLight* self) {
	TrafficLight_sendString(self, "carLights=red\n") /* ORIG: sendString("carLights=red\n") */;
	PTimerConjPort_startTimeout(&self->constData->timeout, 1000) /* ORIG: timeout.startTimeout(1000) */;
}
static void entry_PedGreen(TrafficLight* self) {
	TrafficLight_sendString(self, "pedLights=green\n") /* ORIG: sendString("pedLights=green\n") */;
	PTrafficLightPort_greenForPedDone(&self->constData->controller) /* ORIG: controller.greenForPedDone() */;
}

/* Action Codes */

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 */
static void exitTo(TrafficLight* self, etInt16 current, etInt16 to) {
	while (current!=to) {
		switch (current) {
			case STATE_OpenSocket:
				self->history[STATE_TOP] = STATE_OpenSocket;
				current = STATE_TOP;
				break;
			case STATE_CarYellow:
				self->history[STATE_TOP] = STATE_CarYellow;
				current = STATE_TOP;
				break;
			case STATE_PedRed:
				self->history[STATE_TOP] = STATE_PedRed;
				current = STATE_TOP;
				break;
			case STATE_CarGreen:
				self->history[STATE_TOP] = STATE_CarGreen;
				current = STATE_TOP;
				break;
			case STATE_Off_Blinking:
				self->history[STATE_TOP] = STATE_Off_Blinking;
				current = STATE_TOP;
				break;
			case STATE_Off_Blinking_On:
				exit_Off_Blinking_On(self);
				self->history[STATE_Off_Blinking] = STATE_Off_Blinking_On;
				current = STATE_Off_Blinking;
				break;
			case STATE_Off_Blinking_Off:
				self->history[STATE_Off_Blinking] = STATE_Off_Blinking_Off;
				current = STATE_Off_Blinking;
				break;
			case STATE_CarYellow2:
				self->history[STATE_TOP] = STATE_CarYellow2;
				current = STATE_TOP;
				break;
			case STATE_CarRed:
				self->history[STATE_TOP] = STATE_CarRed;
				current = STATE_TOP;
				break;
			case STATE_PedGreen:
				self->history[STATE_TOP] = STATE_PedGreen;
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
static etInt16 executeTransitionChain(TrafficLight* self, int chain, const InterfaceItemBase* ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__OpenSocket:
		{
			return STATE_OpenSocket;
		}
		case CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl:
		{
			return STATE_Off_Blinking_On;
		}
		case CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller:
		{
			return STATE_PedRed;
		}
		case CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout:
		{
			return STATE_CarYellow;
		}
		case CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout:
		{
			return STATE_CarGreen;
		}
		case CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller:
		{
			return STATE_CarYellow2;
		}
		case CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout:
		{
			return STATE_CarRed;
		}
		case CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout:
		{
			return STATE_PedGreen;
		}
		case CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller:
		{
			return STATE_PedRed;
		}
		case CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller:
		{
			return STATE_CarYellow2;
		}
		case CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout:
		{
			return STATE_Off_Blinking_Off;
		}
		case CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout:
		{
			return STATE_Off_Blinking_On;
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
static etInt16 enterHistory(TrafficLight* self, etInt16 state) {
	boolean skip_entry = FALSE;
	if (state >= STATE_MAX) {
		state = state - STATE_MAX;
		skip_entry = TRUE;
	}
	while (TRUE) {
		switch (state) {
			case STATE_OpenSocket:
				if (!(skip_entry)) entry_OpenSocket(self);
				/* in leaf state: return state id */
				return STATE_OpenSocket;
			case STATE_CarYellow:
				if (!(skip_entry)) entry_CarYellow(self);
				/* in leaf state: return state id */
				return STATE_CarYellow;
			case STATE_PedRed:
				if (!(skip_entry)) entry_PedRed(self);
				/* in leaf state: return state id */
				return STATE_PedRed;
			case STATE_CarGreen:
				if (!(skip_entry)) entry_CarGreen(self);
				/* in leaf state: return state id */
				return STATE_CarGreen;
			case STATE_Off_Blinking:
				/* state has a sub graph */
				/* without init transition */
				state = self->history[STATE_Off_Blinking];
				break;
			case STATE_Off_Blinking_On:
				if (!(skip_entry)) entry_Off_Blinking_On(self);
				/* in leaf state: return state id */
				return STATE_Off_Blinking_On;
			case STATE_Off_Blinking_Off:
				if (!(skip_entry)) entry_Off_Blinking_Off(self);
				/* in leaf state: return state id */
				return STATE_Off_Blinking_Off;
			case STATE_CarYellow2:
				if (!(skip_entry)) entry_CarYellow2(self);
				/* in leaf state: return state id */
				return STATE_CarYellow2;
			case STATE_CarRed:
				if (!(skip_entry)) entry_CarRed(self);
				/* in leaf state: return state id */
				return STATE_CarRed;
			case STATE_PedGreen:
				if (!(skip_entry)) entry_PedGreen(self);
				/* in leaf state: return state id */
				return STATE_PedGreen;
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

static void TrafficLight_executeInitTransition(TrafficLight* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__OpenSocket;
	etInt16 next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void TrafficLight_receiveEvent(TrafficLight* self, InterfaceItemBase* ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	etInt16 catching_state = NO_STATE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (getState(self)) {
			case STATE_OpenSocket:
				switch(trigger) {
						case TRIG_tcpCtrl__established:
							{
								chain = CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_CarYellow:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_PedRed:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_CarGreen:
				switch(trigger) {
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_Off_Blinking_On:
				switch(trigger) {
						case TRIG_blinkerTimeout__timeout:
							{
								chain = CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout;
								catching_state = STATE_Off_Blinking;
							}
						break;
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_Off_Blinking_Off:
				switch(trigger) {
						case TRIG_blinkerTimeout__timeout:
							{
								chain = CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout;
								catching_state = STATE_Off_Blinking;
							}
						break;
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_CarYellow2:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_CarRed:
				switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_PedGreen:
				switch(trigger) {
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller;
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

void TrafficLight_init(TrafficLight* self){
	ET_MSC_LOGGER_SYNC_ENTRY("TrafficLight", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<TRAFFICLIGHT_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	TrafficLight_executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void TrafficLight_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("TrafficLight", "_receiveMessage")
	
	TrafficLight_receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/
void TrafficLight_sendString(TrafficLight* self, charPtr text) {
	
					static DTcpPayload pl;
					strcpy(pl.data, text);
					pl.length = strlen(text);
					PTcpPayloadConjPort_send(&self->constData->tcpPayload, &pl) /* ORIG: tcpPayload.send(&pl) */;
}
