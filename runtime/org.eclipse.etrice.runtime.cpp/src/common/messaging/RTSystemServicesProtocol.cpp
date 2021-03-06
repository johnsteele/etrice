/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "RTSystemServicesProtocol.h"
#include "common/debugging/DebuggingService.h"

namespace etRuntime {

std::string RTSystemServicesProtocol::s_messageStrings[] =
	{	"MIN",
		"dummy",
		"executeInitialTransition",
		"startDebugging",
		"stopDebugging",
		"MAX"};

std::string RTSystemServicesProtocol::getMessageString(int msg_id) {
	if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {
		return s_messageStrings[msg_id];
	} else {
		// id out of range
		return "Message ID out of range";
	}
}

//------------------------------------------------------------------
// RTSystemServicesProtocol: surrounding class
//------------------------------------------------------------------


RTSystemServicesProtocol::RTSystemServicesProtocol() {
}

RTSystemServicesProtocol::~RTSystemServicesProtocol() {
}


//------------------------------------------------------------------
// RTSystemServicesProtocolPort
//------------------------------------------------------------------

RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
		int localId, Address addr, Address peerAddress, bool doRegistration)
:PortBase(actor, parent, name, localId, 0, addr, peerAddress)
{
	if (doRegistration) {
		DebuggingService::getInstance().addPortInstance(*this);
	}
};

RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
		int localId, int idx, Address addr, Address peerAddress, bool doRegistration)
: PortBase(actor, parent, name, localId, idx, addr, peerAddress)
{
	if (doRegistration) {
		DebuggingService::getInstance().addPortInstance(*this);
	}
};

void RTSystemServicesProtocolPort::receive(Message* msg) {
	if (! RTSystemServicesProtocol::isValidIncomingEvtID(msg->getEvtId())) {
		std::cout << "unknown" << std::endl;
	}
	else {
		if (msg->hasDebugFlagSet()) {			// TODO: model switch for activation of this flag
			DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), RTSystemServicesProtocol::getMessageString(msg->getEvtId()));
		}
		getEventReceiver().receiveEvent(this, msg->getEvtId(),	msg->getData());
	}
};

// sent messages

void RTSystemServicesProtocolPort::dummy() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::OUT_dummy));
	PortBase::send(RTSystemServicesProtocol::OUT_dummy);
};

//------------------------------------------------------------------
// RTSystemServicesProtocolPortRepl
//------------------------------------------------------------------


RTSystemServicesProtocolPortRepl::
RTSystemServicesProtocolPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address> peerAddress)
: m_replication(addr.size()),
  m_ports()
{
	char numstr[10]; // enough to hold all numbers up to 32-bits

	//m_ports.reserve(m_replication);
	m_ports = reinterpret_cast<RTSystemServicesProtocolPort*> (new char[sizeof(RTSystemServicesProtocolPort) * addr.size()]);

	for (int i = 0; i < m_replication; ++i) {
		snprintf(numstr, sizeof(numstr), "%d", i);
		new  (&m_ports[i]) RTSystemServicesProtocolPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]);

		//m_ports.push_back(std::auto_ptr_ref<RTSystemServicesProtocolPort>(new RTSystemServicesProtocolPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i], false)));
		//m_ports[i] = std::auto_ptr<RTSystemServicesProtocolPort>(new RTSystemServicesProtocolPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]));
	}
//	for (int i = 0; i < m_replication; ++i) {
//		DebuggingService::getInstance().addPortInstance(m_ports.at(i));
//	}

};

// outgoing messages

void RTSystemServicesProtocolPortRepl::dummy() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports[i].dummy();
	}
};

//------------------------------------------------------------------
// RTSystemServicesProtocolConjPort
//------------------------------------------------------------------

RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
		std::string name, int localId, Address addr, Address peerAddress, bool doRegistration)
			: PortBase(actor, parent, name, localId, 0, addr, peerAddress)
{
	if (doRegistration) {
		DebuggingService::getInstance().addPortInstance(*this);
	}
}
RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
		std::string name, int localId, int idx, Address addr,
		Address peerAddress, bool doRegistration)
: PortBase(actor, parent, name, localId, idx, addr, peerAddress)
{
	if (doRegistration) {
		DebuggingService::getInstance().addPortInstance(*this);
	}
}

void RTSystemServicesProtocolConjPort::receive(Message* msg) {
	if (! RTSystemServicesProtocol::isValidOutgoingEvtID(msg->getEvtId())) {  //conjugated port receives out-messages
		std::cout << "unknown" << std::endl;
	}
	else {
		if (msg->hasDebugFlagSet()) {			// TODO: model switch for activation of this flag
			DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), RTSystemServicesProtocol::getMessageString(msg->getEvtId()));
		}
		getEventReceiver().receiveEvent(this, msg->getEvtId(),	msg->getData());
	}
}

// sent messages

void RTSystemServicesProtocolConjPort::executeInitialTransition() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_executeInitialTransition));
	PortBase::send(RTSystemServicesProtocol::IN_executeInitialTransition);
}

void RTSystemServicesProtocolConjPort::startDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_startDebugging));
	PortBase::send(RTSystemServicesProtocol::IN_startDebugging);
}

void RTSystemServicesProtocolConjPort::stopDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_stopDebugging));
	PortBase::send(RTSystemServicesProtocol::IN_stopDebugging);
}

//------------------------------------------------------------------
// RTSystemServicesProtocolConjPortRepl
//------------------------------------------------------------------

RTSystemServicesProtocolConjPortRepl::
RTSystemServicesProtocolConjPortRepl(IEventReceiver& actor,	IRTObject* parent, std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address>& peerAddress)
: m_replication(addr.size()),
  m_ports()
{
	char numstr[10]; // enough to hold all numbers up to 32-bits
	m_ports = reinterpret_cast<RTSystemServicesProtocolConjPort*> (new char[sizeof(RTSystemServicesProtocolConjPort) * addr.size()]);
	for (int i = 0; i < m_replication; ++i) {
		snprintf(numstr, sizeof(numstr), "%d", i);
		//placement new to avoid copy construction, therefore no vector is used
		new  (&m_ports[i]) RTSystemServicesProtocolConjPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]);
	}

};

// sent messages

void RTSystemServicesProtocolConjPortRepl::executeInitialTransition() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports[i].executeInitialTransition();
	}
}

void RTSystemServicesProtocolConjPortRepl::startDebugging() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports[i].startDebugging();
	}
}

void RTSystemServicesProtocolConjPortRepl::stopDebugging() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports[i].stopDebugging();
	}
}


} /* namespace etRuntime */
