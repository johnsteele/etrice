/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "TestRMessageQueue.h"
#include "RUnit.h"
#include "RMessageQueue.h"

void testPushPop(void){
	RMessage msg1 = {NULL, 123, 456};
	RMessage msg2 = {NULL, 222, 333};

	RMessageQueue queue1;
	RMessageQueue_init(&queue1);

	RMessageQueue_push(&queue1, &msg1);
	RMessageQueue_push(&queue1, &msg2);

	EXPECT_EQUAL_INT("RMessageQueue.size before", 2,queue1.size);
	EXPECT_EQUAL_INT("RMessageQueue.highWaterMark before", 2,queue1.highWaterMark);

	RMessage* rcvMsg1 = RMessageQueue_pop(&queue1);
	RMessage* rcvMsg2 = RMessageQueue_pop(&queue1);

	EXPECT_EQUAL_INT("RMessageQueue.size after", 0,queue1.size);
	EXPECT_EQUAL_INT("RMessageQueue.highWaterMark after", 2,queue1.highWaterMark);

	EXPECT_EQUAL_INT("rcvMsg1->address", 123, rcvMsg1->address);
	EXPECT_EQUAL_INT("rcvMsg1->evtID", 456, rcvMsg1->evtID);
	EXPECT_EQUAL_INT("rcvMsg1->next", NULL, rcvMsg1->next);

	EXPECT_EQUAL_INT("rcvMsg2->address", 222, rcvMsg2->address);
	EXPECT_EQUAL_INT("rcvMsg2->evtID", 333, rcvMsg2->evtID);
	EXPECT_EQUAL_INT("rcvMsg2->next", NULL, rcvMsg2->next);

	EXPECT_EQUAL_INT("RMessageQueue->first", NULL, queue1.first);
	EXPECT_EQUAL_INT("RMessageQueue->last", NULL, queue1.last);

	RMessage* rcvMsg3 = RMessageQueue_pop(&queue1);
	EXPECT_EQUAL_INT("RMessageQueue_pop if empty", NULL, rcvMsg3);

}

#define MAX 1000

void testMassiveMessaging(void){
	RMessage msgArray[MAX];
	printf("sizeof(RMessage):%d\n", sizeof(RMessage));
	printf("size(msgArray):%d\n", sizeof(msgArray));

	RMessageQueue queue1;
	RMessageQueue_init(&queue1);

	int i;
	for(i=0; i<MAX; i++){
		//RMessage_init(&msgArray[i]);
		msgArray[i].address = i;
		msgArray[i].evtID = i;
	}

	int j;
	for(j=0; j<3; j++){
		for (i=0; i<MAX; i++){
			RMessageQueue_push(&queue1, &(msgArray[i]));
		}
		for (i=0; i<MAX; i++){
			RMessage* msg = RMessageQueue_pop(&queue1);
			// EXPECTS are hidden to avoid too many testcases in log
			if (msg == NULL){
				EXPECT_FALSE("msg == NULL", TRUE);
				break;
			}
			if (msg->address != msg->evtID){
				EXPECT_FALSE("msg->address != msg->evtID", TRUE);
				break;
			}
			if (msg->address != i){
				EXPECT_FALSE("msg->address != i", TRUE);
				break;
			}
		}
		EXPECT_EQUAL_INT("i==MAX", MAX, i);
	}
}

void TestMessageQueue_runSuite(void){
	RUnit_open("TestRMessageQueue");
	testPushPop();
	testMassiveMessaging();
	RUnit_close();
}