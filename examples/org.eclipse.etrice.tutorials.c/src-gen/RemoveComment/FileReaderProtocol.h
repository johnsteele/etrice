/**
 * @author generated by eTrice
 *
 * Header File of ProtocolClass FileReaderProtocol
 * 
 */

#ifndef _FILEREADERPROTOCOL_H_
#define _FILEREADERPROTOCOL_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"




/* message IDs */
enum FileReaderProtocol_msg_ids {
	FileReaderProtocol_MSG_MIN = 0,
	FileReaderProtocol_OUT_nextChar = 1,
	FileReaderProtocol_IN_getNextChar = 2,
	FileReaderProtocol_MSG_MAX = 3
};

/*--------------------- port structs and methods */
typedef etPort FileReaderProtocolPort;
typedef etReplPort FileReaderProtocolReplPort;


void FileReaderProtocolPort_nextChar(const FileReaderProtocolPort* self, char data);
void FileReaderProtocolReplPort_nextChar_broadcast(const FileReaderProtocolReplPort* self, char data);
void FileReaderProtocolReplPort_nextChar(const FileReaderProtocolReplPort* self, int idx, char data);


etInt32 FileReaderProtocolReplPort_getReplication(const FileReaderProtocolReplPort* self);
typedef etPort FileReaderProtocolConjPort;
typedef etReplPort FileReaderProtocolConjReplPort;


void FileReaderProtocolConjPort_getNextChar(const FileReaderProtocolConjPort* self);
void FileReaderProtocolConjReplPort_getNextChar_broadcast(const FileReaderProtocolConjReplPort* self);
void FileReaderProtocolConjReplPort_getNextChar(const FileReaderProtocolConjReplPort* self, int idx);


etInt32 FileReaderProtocolConjReplPort_getReplication(const FileReaderProtocolConjReplPort* self);

/*--------------------- debug helpers */

/* get message string for message id */
const char* FileReaderProtocol_getMessageString(int msg_id);


#endif /* _FILEREADERPROTOCOL_H_ */

