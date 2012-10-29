/**
 * @author generated by eTrice
 *
 * Header File of SubSystemClass RemoveCommentSubSys
 * 
 */

#ifndef _REMOVECOMMENTSUBSYS_H_
#define _REMOVECOMMENTSUBSYS_H_



/* lifecycle functions
 * init -> start -> run (loop) -> stop -> destroy
 */

void RemoveCommentSubSys_init(void);		/* lifecycle init  	 */
void RemoveCommentSubSys_start(void);	/* lifecycle start 	 */

void RemoveCommentSubSys_run(void);		/* lifecycle run 	 */

void RemoveCommentSubSys_stop(void); 	/* lifecycle stop	 */
void RemoveCommentSubSys_destroy(void); 	/* lifecycle destroy */

void SubSysClass_shutdown(void);  /* shutdown the dispatcher loop */


#endif /* _REMOVECOMMENTSUBSYS_H_ */


