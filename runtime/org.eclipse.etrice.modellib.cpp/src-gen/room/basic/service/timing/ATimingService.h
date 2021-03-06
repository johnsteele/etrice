	/**
	 * @author generated by eTrice
	 *
	 * Header File of ActorClass ATimingService
	 * 
	 */

	#ifndef _ATIMINGSERVICE_H_
	#define _ATIMINGSERVICE_H_

	#include "platforms/generic/etDatatypes.h"
	#include "common/messaging/IRTObject.h"
	#include "common/modelbase/PortBase.h"
	#include "common/modelbase/InterfaceItemBase.h"
	#include "common/modelbase/ActorClassBase.h"
	#include "common/modelbase/SubSystemClassBase.h"
	#include "common/messaging/Address.h"
	#include "common/messaging/IMessageReceiver.h"
	#include "common/debugging/DebuggingService.h"
	#include <string>
	#include <vector>
	
	
	#include "room/basic/service/timing/PTimer.h"

	
	/*--------------------- begin user code ---------------------*/
	
				#include "common/platform/etTimer.h" 
				#define ET_NB_OF_TCBS 10
				typedef struct etTCB etTimerControlBlock; 
				struct etTCB {
					etTargetTime_t expTime;
					etTargetTime_t pTime;
					int32 portIdx;
					etTimerControlBlock* next;
					};
				
	/*--------------------- end user code ---------------------*/
	
	
	class ATimingService : public etRuntime::ActorClassBase {
	
		
		protected:
			//--------------------- ports
			//--------------------- saps
			//--------------------- services
			PTimerReplPort timer;
		
			//--------------------- interface item IDs
			typedef enum {
			IFITEM_timer = 1,
			} interface_items;
				
			/*--------------------- attributes ---------------------*/
			etTimerControlBlock tcbs[10];
			etTimerControlBlock* usedTcbsRoot;
			etTimerControlBlock* freeTcbsRoot;

			/*--------------------- operations ---------------------*/
			etTimerControlBlock* getTcb() {
				
							etTimerControlBlock* temp = freeTcbsRoot;
							
							if(freeTcbsRoot!=0) {
								freeTcbsRoot=freeTcbsRoot->next;
								temp->next=0;
								}
							return temp;
			}
			void returnTcb(etTimerControlBlock* block) {
				
							block->next=freeTcbsRoot;
							freeTcbsRoot=block;
			}
			void removeTcbFromUsedList(int32 idx) {
				
							etTimerControlBlock* temp=usedTcbsRoot;
							etTimerControlBlock* temp2=usedTcbsRoot;
							
							if (temp==0) return;
				
							if (usedTcbsRoot->portIdx == idx){
								// element found, the first one
								usedTcbsRoot = usedTcbsRoot->next;
								returnTcb(temp);
								return;
								}
				
							temp=temp->next;
							while(temp!=0){
								if(temp->portIdx==idx){
									temp2->next=temp->next;
									returnTcb(temp);
									return;			
								}else{
									// try next
									temp2=temp;
									temp=temp->next;
									}
								}
			}
			void putTcbToUsedList(etTimerControlBlock* block) {
				
							etTimerControlBlock* temp=usedTcbsRoot;
							etTimerControlBlock* temp2=usedTcbsRoot;
				
							if (temp==0){
								// list empty put new block to root
								block->next=0;
								usedTcbsRoot=block;
								return;
								}
							
							while(1){
								if (temp != 0){
									if (isTimeGreater(&block->expTime,&temp->expTime)){
										//try next position
										temp2=temp;	
										temp=temp->next;
										}else{
										// right position found
										block->next=temp;
										if(temp==usedTcbsRoot){
											usedTcbsRoot=block;
											}else{
											temp2->next=block;
											}
										return;
										}
									}else{
									// end of list reached
									block->next=0;
									temp2->next=block;
									return;
								}
							}
			}
			bool isTimeGreater(etTargetTime_t* t1, etTargetTime_t* t2) {
				
								if (t1->sec > t2->sec) return TRUE;
								if (t1->sec < t2->sec) return FALSE;
								if (t1->nSec > t2->nSec) return TRUE;
								return FALSE;
			}
			void addTime(etTargetTime_t* t1, etTargetTime_t* t2) {
				
								t1->sec += t2->sec;
								t1->nSec += t2->nSec;
								while(t1->nSec >= 1000000000L){
									t1->sec++;
									t1->nSec-=1000000000L;
									}
			}
			void printList() {
				
							etTimerControlBlock* temp=usedTcbsRoot;
								printf("list: ");
								while (temp!=0){
									printf("(%ld,%ld),",temp->expTime.sec,temp->expTime.nSec);
									temp=temp->next;
								}
								printf("\n");
			}
	
		public:
			//--------------------- construction
			ATimingService(etRuntime::IRTObject* parent, std::string name, const std::vector<std::vector<etRuntime::Address> >& port_addr, 
																	  const std::vector<std::vector<etRuntime::Address> >& peer_addr);

			//--------------------- port getters
		PTimerReplPort getTimer (){
			return this->timer;
		}
	
		//--------------------- lifecycle functions
			virtual void init();
			virtual void start();
		virtual void stop();
			virtual void destroy();			
		
		/* state IDs */
		typedef enum {
		STATE_Operational = 2,
		} state_ids;
		
		/* transition chains */
		typedef enum {
		CHAIN_TRANS_INITIAL_TO__Operational = 1,
		CHAIN_TRANS_tr1_FROM_Operational_TO_Operational_BY_startTimeouttimer_tr1 = 2,
		CHAIN_TRANS_tr3_FROM_Operational_TO_Operational_BY_startTimertimer_tr3 = 3,
		CHAIN_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4 = 4,
		} chain_ids;
		
		/* triggers */
		typedef enum {
		POLLING = 0,
		TRIG_timer__kill = IFITEM_timer + EVT_SHIFT*PTimer::IN_kill,
		TRIG_timer__startTimeout = IFITEM_timer + EVT_SHIFT*PTimer::IN_startTimeout,
		TRIG_timer__startTimer = IFITEM_timer + EVT_SHIFT*PTimer::IN_startTimer,
		} triggers;
		
		protected:
		 	static std::string s_stateStrings[];
		 	static const int s_numberOfStates;
		
		private:
			 void setState(int new_state);
		
		/* Entry and Exit Codes */
		void entry_Operational();
		void do_Operational();
		
		/* Action Codes */
		void action_TRANS_INITIAL_TO__Operational();
		void action_TRANS_tr1_FROM_Operational_TO_Operational_BY_startTimeouttimer_tr1(const etRuntime::InterfaceItemBase* ifitem, uint32 time);
		void action_TRANS_tr3_FROM_Operational_TO_Operational_BY_startTimertimer_tr3(const etRuntime::InterfaceItemBase* ifitem, uint32 time);
		void action_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4(const etRuntime::InterfaceItemBase* ifitem);
		
		private:
			/**
			 * calls exit codes while exiting from the current state to one of its
			 * parent states while remembering the history
			 * @param current - the current state
			 * @param to - the final parent state
			 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
			 */
			void exitTo(int current, int to, bool handler);
			
			/**
			 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
			 * matching the trigger of this chain. The ID of the final state is returned
			 * @param chain - the chain ID
			 * @param generic_data - the generic data pointer
			 * @return the ID of the final state
			 */
			int executeTransitionChain(int chain, const etRuntime::InterfaceItemBase* ifitem, void* generic_data);
			
			/**
			 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
			 * @param state - the state which is entered
			 * @param handler - entry code is executed if not handler
			 * @return - the ID of the final leaf state
			 */
			int enterHistory(int state, bool handler, bool skip_entry);
		
		public:
		
			void executeInitTransition();
			
			/* receiveEvent contains the main implementation of the FSM */
			void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* generic_data);

		/*--------------------- begin user code ---------------------*/
		//uc2
		/*--------------------- end user code ---------------------*/

	};
	
	
	#endif /* _ATIMINGSERVICE_H_ */
