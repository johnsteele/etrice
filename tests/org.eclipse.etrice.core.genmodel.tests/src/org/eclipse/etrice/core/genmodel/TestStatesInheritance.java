/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;

public class TestStatesInheritance extends TestInstanceModelBuilderBase {
	
	private Root root;
	private ExpandedActorClass xpac;

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("states_inheritance.room");
		xpac = getTestee();
		instances = collectInstances(xpac);
	}

	private ExpandedActorClass getTestee() {
		for (ExpandedActorClass xpac : root.getXpActorClasses()) {
			if (xpac.getActorClass().getName().equals("ADerived"))
				return xpac;
		}
		return null;
	}

//	private void assertEquals(String msg, int exp, int is) {
//		LogicalSystem.out.println(msg+" exp:"+exp+" is:"+is);
//	}
//
//	private void assertEquals(String msg, String exp, String is) {
//		LogicalSystem.out.println(msg+" exp:"+exp+" is:"+is);
//	}
//
//	private void assertEquals(String msg, EObject exp, EObject is) {
//		LogicalSystem.out.println(msg+" exp:"+exp+" is:"+is);
//	}
	
	@Test
	public void testNumbers() {
		checkSize(9, RoomPackage.eINSTANCE.getSimpleState());
		checkSize(1, RoomPackage.eINSTANCE.getChoicePoint());
		checkSize(5, RoomPackage.eINSTANCE.getTransitionPoint());
		checkSize(2, RoomPackage.eINSTANCE.getEntryPoint());
		checkSize(1, RoomPackage.eINSTANCE.getExitPoint());
		checkSize(3, RoomPackage.eINSTANCE.getInitialTransition());
		checkSize(17, RoomPackage.eINSTANCE.getTriggeredTransition());
		checkSize(4, RoomPackage.eINSTANCE.getContinuationTransition());
		checkSize(3, RoomPackage.eINSTANCE.getCPBranchTransition());
	}
	
	@Test
	public void testXPACGeneral() {
		EList<TransitionChain> chains = xpac.getTransitionChains();
		assertEquals("number of chains", 20, chains.size());
		assertEquals("numer of triggers", 8, xpac.getTriggers().size());
	}
	
	@Test
	public void testGraph() {
		ArrayList<EObject> states = instances.get(RoomPackage.eINSTANCE.getSimpleState());
//		for (EObject obj : states) {
//			LogicalSystem.out.println("state "+RoomNameProvider.getFullPath((StateGraphItem) obj));
//		}

		State s = (State) getStateGraphItem(states, "State3_State3");
		assertNotNull("state exists", s);
		assertEquals("number of incoming transitions", 3, xpac.getIncomingTransitions(s).size());
		assertEquals("number of outgoing transitions", 2, xpac.getOutgoingTransitions(s).size());
		
		assertEquals("active triggers", 6, xpac.getActiveTriggers(s).size());
		
		s = (State) getStateGraphItem(states, "State2");
		assertNotNull("state exists", s);
		assertEquals("number of incoming transitions", 4, xpac.getIncomingTransitions(s).size());
		assertEquals("number of outgoing transitions", 1, xpac.getOutgoingTransitions(s).size());
		
		assertEquals("active triggers", 3, xpac.getActiveTriggers(s).size());

		ArrayList<EObject> cps = instances.get(RoomPackage.eINSTANCE.getChoicePoint());
		
		ChoicePoint cp = (ChoicePoint) cps.get(0);
		assertEquals("choicepoint name", "CP1", RoomNameProvider.getFullPath(cp));
		assertEquals("number of incoming transitions", 1, xpac.getIncomingTransitions(cp).size());
		assertEquals("number of outgoing transitions", 4, xpac.getOutgoingTransitions(cp).size());
		
		ContinuationTransition dflt = xpac.getDefaultBranch(xpac.getOutgoingTransitions(cp));
		assertNotNull("default branch", dflt);
	}
	
	@Test
	public void testChains() {
		ArrayList<EObject> cts = instances.get(RoomPackage.eINSTANCE.getContinuationTransition());
//		for (EObject obj : cts) {
//			LogicalSystem.out.println("ct "+RoomNameProvider.getFullPath((StateGraphItem) obj));
//		}
		
		Transition t = (Transition) getStateGraphItem(cts, "State3_TRANS_tr1_FROM_tp1_TO_State3");
		assertNotNull("transition", t);

		TransitionChain chain = xpac.getChain(t);
		assertNotNull("chain", chain);
		assertEquals("chain name", "TRANS_tr5_FROM_tp0_TO_State3_tp1_BY_afct", RoomNameProvider.getFullPath(chain.getTransition()));
		
		t = (Transition) getStateGraphItem(cts, "State3_TRANS_tr8_FROM_tp6_TO_State2");
		assertNotNull("transition", t);

		chain = xpac.getChain(t);
		assertNotNull("chain", chain);
		assertEquals("chain name", "TRANS_tr12_FROM_State5_TO_State3_tp6_BY_aport", RoomNameProvider.getFullPath(chain.getTransition()));
	}
}
