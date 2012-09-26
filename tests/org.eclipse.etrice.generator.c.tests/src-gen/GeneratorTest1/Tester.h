/**
 * @author generated by eTrice
 *
 * Header File of ActorClass Tester
 * 
 */

#ifndef _TESTER_H_
#define _TESTER_H_

#include "etDatatypes.h"
#include "messaging/etMessage.h"

#include "PTestTrigger.h"


typedef struct Tester Tester;

/* const part of ActorClass (ROM) */
typedef struct Tester_const {
	/* simple ports */
	const PTestTriggerConjPort testee;
	
	/* data receive ports */

	/* saps */
	
	/* replicated ports */
	
	/* services */
} Tester_const;


/* constant for state machine data */
#define TESTER_HISTORY_SIZE 2

/* variable part of ActorClass (RAM) */
struct Tester {
	const Tester_const* const constData;
	
	/* data send ports */

	/*--------------------- attributes ---------------------*/
	
	
		/* state machine variables */
		etInt16 state;
		etInt16 history[TESTER_HISTORY_SIZE];
};

void Tester_init(Tester* self);

void Tester_receiveMessage(void* self, void* ifitem, const etMessage* msg);

void Tester_execute(Tester* self);

/*--------------------- operations ---------------------*/


#endif /* _TESTER_H_ */
