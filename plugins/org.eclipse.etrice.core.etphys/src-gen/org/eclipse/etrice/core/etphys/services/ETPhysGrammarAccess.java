/*
* generated by Xtext
*/

package org.eclipse.etrice.core.etphys.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ETPhysGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class PhysicalModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PhysicalModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPhysicalModelKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameFQNParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cImportsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cImportsImportParserRuleCall_3_0 = (RuleCall)cImportsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cSystemsAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cSystemsPhysicalSystemParserRuleCall_4_0_0 = (RuleCall)cSystemsAssignment_4_0.eContents().get(0);
		private final Assignment cNodeClassesAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cNodeClassesNodeClassParserRuleCall_4_1_0 = (RuleCall)cNodeClassesAssignment_4_1.eContents().get(0);
		private final Assignment cRuntimeClassesAssignment_4_2 = (Assignment)cAlternatives_4.eContents().get(2);
		private final RuleCall cRuntimeClassesRuntimeClassParserRuleCall_4_2_0 = (RuleCall)cRuntimeClassesAssignment_4_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//PhysicalModel:
		//
		//	"PhysicalModel" name=FQN "{" imports+=Import* (systems+=PhysicalSystem | nodeClasses+=NodeClass |
		//
		//	runtimeClasses+=RuntimeClass)* "}";
		public ParserRule getRule() { return rule; }

		//"PhysicalModel" name=FQN "{" imports+=Import* (systems+=PhysicalSystem | nodeClasses+=NodeClass |
		//
		//runtimeClasses+=RuntimeClass)* "}"
		public Group getGroup() { return cGroup; }

		//"PhysicalModel"
		public Keyword getPhysicalModelKeyword_0() { return cPhysicalModelKeyword_0; }

		//name=FQN
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//FQN
		public RuleCall getNameFQNParserRuleCall_1_0() { return cNameFQNParserRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//imports+=Import*
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }

		//Import
		public RuleCall getImportsImportParserRuleCall_3_0() { return cImportsImportParserRuleCall_3_0; }

		//(systems+=PhysicalSystem | nodeClasses+=NodeClass | runtimeClasses+=RuntimeClass)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//systems+=PhysicalSystem
		public Assignment getSystemsAssignment_4_0() { return cSystemsAssignment_4_0; }

		//PhysicalSystem
		public RuleCall getSystemsPhysicalSystemParserRuleCall_4_0_0() { return cSystemsPhysicalSystemParserRuleCall_4_0_0; }

		//nodeClasses+=NodeClass
		public Assignment getNodeClassesAssignment_4_1() { return cNodeClassesAssignment_4_1; }

		//NodeClass
		public RuleCall getNodeClassesNodeClassParserRuleCall_4_1_0() { return cNodeClassesNodeClassParserRuleCall_4_1_0; }

		//runtimeClasses+=RuntimeClass
		public Assignment getRuntimeClassesAssignment_4_2() { return cRuntimeClassesAssignment_4_2; }

		//RuntimeClass
		public RuleCall getRuntimeClassesRuntimeClassParserRuleCall_4_2_0() { return cRuntimeClassesRuntimeClassParserRuleCall_4_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class PhysicalSystemElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PhysicalSystem");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPhysicalSystemKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cDocuAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDocuDocumentationParserRuleCall_2_0 = (RuleCall)cDocuAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cNodeRefsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNodeRefsNodeRefParserRuleCall_4_0 = (RuleCall)cNodeRefsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//PhysicalSystem:
		//
		//	"PhysicalSystem" name=ID docu=Documentation? "{" nodeRefs+=NodeRef* "}";
		public ParserRule getRule() { return rule; }

		//"PhysicalSystem" name=ID docu=Documentation? "{" nodeRefs+=NodeRef* "}"
		public Group getGroup() { return cGroup; }

		//"PhysicalSystem"
		public Keyword getPhysicalSystemKeyword_0() { return cPhysicalSystemKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//docu=Documentation?
		public Assignment getDocuAssignment_2() { return cDocuAssignment_2; }

		//Documentation
		public RuleCall getDocuDocumentationParserRuleCall_2_0() { return cDocuDocumentationParserRuleCall_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//nodeRefs+=NodeRef*
		public Assignment getNodeRefsAssignment_4() { return cNodeRefsAssignment_4; }

		//NodeRef
		public RuleCall getNodeRefsNodeRefParserRuleCall_4_0() { return cNodeRefsNodeRefParserRuleCall_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class NodeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NodeRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNodeRefKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeNodeClassCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeNodeClassFQNParserRuleCall_3_0_1 = (RuleCall)cTypeNodeClassCrossReference_3_0.eContents().get(1);
		private final Assignment cDocuAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cDocuDocumentationParserRuleCall_4_0 = (RuleCall)cDocuAssignment_4.eContents().get(0);
		
		//NodeRef:
		//
		//	"NodeRef" name=ID ":" type=[NodeClass|FQN] docu=Documentation?;
		public ParserRule getRule() { return rule; }

		//"NodeRef" name=ID ":" type=[NodeClass|FQN] docu=Documentation?
		public Group getGroup() { return cGroup; }

		//"NodeRef"
		public Keyword getNodeRefKeyword_0() { return cNodeRefKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//type=[NodeClass|FQN]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }

		//[NodeClass|FQN]
		public CrossReference getTypeNodeClassCrossReference_3_0() { return cTypeNodeClassCrossReference_3_0; }

		//FQN
		public RuleCall getTypeNodeClassFQNParserRuleCall_3_0_1() { return cTypeNodeClassFQNParserRuleCall_3_0_1; }

		//docu=Documentation?
		public Assignment getDocuAssignment_4() { return cDocuAssignment_4; }

		//Documentation
		public RuleCall getDocuDocumentationParserRuleCall_4_0() { return cDocuDocumentationParserRuleCall_4_0; }
	}

	public class NodeClassElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NodeClass");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNodeClassKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cDocuAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDocuDocumentationParserRuleCall_2_0 = (RuleCall)cDocuAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRuntimeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRuntimeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRuntimeRuntimeClassCrossReference_6_0 = (CrossReference)cRuntimeAssignment_6.eContents().get(0);
		private final RuleCall cRuntimeRuntimeClassFQNParserRuleCall_6_0_1 = (RuleCall)cRuntimeRuntimeClassCrossReference_6_0.eContents().get(1);
		private final Keyword cPriominKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cEqualsSignKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cPriominAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cPriominPRIOParserRuleCall_9_0 = (RuleCall)cPriominAssignment_9.eContents().get(0);
		private final Keyword cPriomaxKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Keyword cEqualsSignKeyword_11 = (Keyword)cGroup.eContents().get(11);
		private final Assignment cPriomaxAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cPriomaxPRIOParserRuleCall_12_0 = (RuleCall)cPriomaxAssignment_12.eContents().get(0);
		private final Assignment cThreadsAssignment_13 = (Assignment)cGroup.eContents().get(13);
		private final RuleCall cThreadsPhysicalThreadParserRuleCall_13_0 = (RuleCall)cThreadsAssignment_13.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_14 = (Keyword)cGroup.eContents().get(14);
		
		//NodeClass:
		//
		//	"NodeClass" name=ID docu=Documentation? "{" "runtime" "=" runtime=[RuntimeClass|FQN] "priomin" "=" priomin=PRIO
		//
		//	"priomax" "=" priomax=PRIO threads+=PhysicalThread* "}";
		public ParserRule getRule() { return rule; }

		//"NodeClass" name=ID docu=Documentation? "{" "runtime" "=" runtime=[RuntimeClass|FQN] "priomin" "=" priomin=PRIO
		//
		//"priomax" "=" priomax=PRIO threads+=PhysicalThread* "}"
		public Group getGroup() { return cGroup; }

		//"NodeClass"
		public Keyword getNodeClassKeyword_0() { return cNodeClassKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//docu=Documentation?
		public Assignment getDocuAssignment_2() { return cDocuAssignment_2; }

		//Documentation
		public RuleCall getDocuDocumentationParserRuleCall_2_0() { return cDocuDocumentationParserRuleCall_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//"runtime"
		public Keyword getRuntimeKeyword_4() { return cRuntimeKeyword_4; }

		//"="
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }

		//runtime=[RuntimeClass|FQN]
		public Assignment getRuntimeAssignment_6() { return cRuntimeAssignment_6; }

		//[RuntimeClass|FQN]
		public CrossReference getRuntimeRuntimeClassCrossReference_6_0() { return cRuntimeRuntimeClassCrossReference_6_0; }

		//FQN
		public RuleCall getRuntimeRuntimeClassFQNParserRuleCall_6_0_1() { return cRuntimeRuntimeClassFQNParserRuleCall_6_0_1; }

		//"priomin"
		public Keyword getPriominKeyword_7() { return cPriominKeyword_7; }

		//"="
		public Keyword getEqualsSignKeyword_8() { return cEqualsSignKeyword_8; }

		//priomin=PRIO
		public Assignment getPriominAssignment_9() { return cPriominAssignment_9; }

		//PRIO
		public RuleCall getPriominPRIOParserRuleCall_9_0() { return cPriominPRIOParserRuleCall_9_0; }

		//"priomax"
		public Keyword getPriomaxKeyword_10() { return cPriomaxKeyword_10; }

		//"="
		public Keyword getEqualsSignKeyword_11() { return cEqualsSignKeyword_11; }

		//priomax=PRIO
		public Assignment getPriomaxAssignment_12() { return cPriomaxAssignment_12; }

		//PRIO
		public RuleCall getPriomaxPRIOParserRuleCall_12_0() { return cPriomaxPRIOParserRuleCall_12_0; }

		//threads+=PhysicalThread*
		public Assignment getThreadsAssignment_13() { return cThreadsAssignment_13; }

		//PhysicalThread
		public RuleCall getThreadsPhysicalThreadParserRuleCall_13_0() { return cThreadsPhysicalThreadParserRuleCall_13_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_14() { return cRightCurlyBracketKeyword_14; }
	}

	public class PhysicalThreadElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PhysicalThread");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cDefaultAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cDefaultDefaultThreadKeyword_0_0_0 = (Keyword)cDefaultAssignment_0_0.eContents().get(0);
		private final Keyword cThreadKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cExecmodeKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cExecmodeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cExecmodeExecModeEnumRuleCall_5_0 = (RuleCall)cExecmodeAssignment_5.eContents().get(0);
		private final Keyword cPrioKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cEqualsSignKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cPrioAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cPrioPRIOParserRuleCall_8_0 = (RuleCall)cPrioAssignment_8.eContents().get(0);
		private final Keyword cStacksizeKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cEqualsSignKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Assignment cStacksizeAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final RuleCall cStacksizeINTTerminalRuleCall_11_0 = (RuleCall)cStacksizeAssignment_11.eContents().get(0);
		private final Keyword cMsgblocksizeKeyword_12 = (Keyword)cGroup.eContents().get(12);
		private final Keyword cEqualsSignKeyword_13 = (Keyword)cGroup.eContents().get(13);
		private final Assignment cMsgblocksizeAssignment_14 = (Assignment)cGroup.eContents().get(14);
		private final RuleCall cMsgblocksizeINTTerminalRuleCall_14_0 = (RuleCall)cMsgblocksizeAssignment_14.eContents().get(0);
		private final Keyword cMsgpoolsizeKeyword_15 = (Keyword)cGroup.eContents().get(15);
		private final Keyword cEqualsSignKeyword_16 = (Keyword)cGroup.eContents().get(16);
		private final Assignment cMsgpoolsizeAssignment_17 = (Assignment)cGroup.eContents().get(17);
		private final RuleCall cMsgpoolsizeINTTerminalRuleCall_17_0 = (RuleCall)cMsgpoolsizeAssignment_17.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_18 = (Keyword)cGroup.eContents().get(18);
		
		//PhysicalThread:
		//
		//	(default?="DefaultThread" | "Thread") name=ID "{" "execmode" "=" execmode=ExecMode "prio" "=" prio=PRIO "stacksize"
		//
		//	"=" stacksize=INT "msgblocksize" "=" msgblocksize=INT "msgpoolsize" "=" msgpoolsize=INT "}";
		public ParserRule getRule() { return rule; }

		//(default?="DefaultThread" | "Thread") name=ID "{" "execmode" "=" execmode=ExecMode "prio" "=" prio=PRIO "stacksize" "="
		//
		//stacksize=INT "msgblocksize" "=" msgblocksize=INT "msgpoolsize" "=" msgpoolsize=INT "}"
		public Group getGroup() { return cGroup; }

		//default?="DefaultThread" | "Thread"
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//default?="DefaultThread"
		public Assignment getDefaultAssignment_0_0() { return cDefaultAssignment_0_0; }

		//"DefaultThread"
		public Keyword getDefaultDefaultThreadKeyword_0_0_0() { return cDefaultDefaultThreadKeyword_0_0_0; }

		//"Thread"
		public Keyword getThreadKeyword_0_1() { return cThreadKeyword_0_1; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//"execmode"
		public Keyword getExecmodeKeyword_3() { return cExecmodeKeyword_3; }

		//"="
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }

		//execmode=ExecMode
		public Assignment getExecmodeAssignment_5() { return cExecmodeAssignment_5; }

		//ExecMode
		public RuleCall getExecmodeExecModeEnumRuleCall_5_0() { return cExecmodeExecModeEnumRuleCall_5_0; }

		//"prio"
		public Keyword getPrioKeyword_6() { return cPrioKeyword_6; }

		//"="
		public Keyword getEqualsSignKeyword_7() { return cEqualsSignKeyword_7; }

		//prio=PRIO
		public Assignment getPrioAssignment_8() { return cPrioAssignment_8; }

		//PRIO
		public RuleCall getPrioPRIOParserRuleCall_8_0() { return cPrioPRIOParserRuleCall_8_0; }

		//"stacksize"
		public Keyword getStacksizeKeyword_9() { return cStacksizeKeyword_9; }

		//"="
		public Keyword getEqualsSignKeyword_10() { return cEqualsSignKeyword_10; }

		//stacksize=INT
		public Assignment getStacksizeAssignment_11() { return cStacksizeAssignment_11; }

		//INT
		public RuleCall getStacksizeINTTerminalRuleCall_11_0() { return cStacksizeINTTerminalRuleCall_11_0; }

		//"msgblocksize"
		public Keyword getMsgblocksizeKeyword_12() { return cMsgblocksizeKeyword_12; }

		//"="
		public Keyword getEqualsSignKeyword_13() { return cEqualsSignKeyword_13; }

		//msgblocksize=INT
		public Assignment getMsgblocksizeAssignment_14() { return cMsgblocksizeAssignment_14; }

		//INT
		public RuleCall getMsgblocksizeINTTerminalRuleCall_14_0() { return cMsgblocksizeINTTerminalRuleCall_14_0; }

		//"msgpoolsize"
		public Keyword getMsgpoolsizeKeyword_15() { return cMsgpoolsizeKeyword_15; }

		//"="
		public Keyword getEqualsSignKeyword_16() { return cEqualsSignKeyword_16; }

		//msgpoolsize=INT
		public Assignment getMsgpoolsizeAssignment_17() { return cMsgpoolsizeAssignment_17; }

		//INT
		public RuleCall getMsgpoolsizeINTTerminalRuleCall_17_0() { return cMsgpoolsizeINTTerminalRuleCall_17_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_18() { return cRightCurlyBracketKeyword_18; }
	}

	public class RuntimeClassElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RuntimeClass");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRuntimeClassKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cDocuAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDocuDocumentationParserRuleCall_2_0 = (RuleCall)cDocuAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cModelKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cThreadModelAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cThreadModelThreadModelEnumRuleCall_6_0 = (RuleCall)cThreadModelAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//RuntimeClass:
		//
		//	"RuntimeClass" name=ID docu=Documentation? "{" "model" "=" threadModel=ThreadModel "}";
		public ParserRule getRule() { return rule; }

		//"RuntimeClass" name=ID docu=Documentation? "{" "model" "=" threadModel=ThreadModel "}"
		public Group getGroup() { return cGroup; }

		//"RuntimeClass"
		public Keyword getRuntimeClassKeyword_0() { return cRuntimeClassKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//docu=Documentation?
		public Assignment getDocuAssignment_2() { return cDocuAssignment_2; }

		//Documentation
		public RuleCall getDocuDocumentationParserRuleCall_2_0() { return cDocuDocumentationParserRuleCall_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//"model"
		public Keyword getModelKeyword_4() { return cModelKeyword_4; }

		//"="
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }

		//threadModel=ThreadModel
		public Assignment getThreadModelAssignment_6() { return cThreadModelAssignment_6; }

		//ThreadModel
		public RuleCall getThreadModelThreadModelEnumRuleCall_6_0() { return cThreadModelThreadModelEnumRuleCall_6_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}

	public class DocumentationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Documentation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTextAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTextSTRINGTerminalRuleCall_1_0 = (RuleCall)cTextAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Documentation:
		//
		//	"[" text+=STRING+ "]";
		public ParserRule getRule() { return rule; }

		//"[" text+=STRING+ "]"
		public Group getGroup() { return cGroup; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//text+=STRING+
		public Assignment getTextAssignment_1() { return cTextAssignment_1; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_1_0() { return cTextSTRINGTerminalRuleCall_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}

	public class PRIOElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PRIO");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//PRIO returns ecore::EInt hidden():
		//
		//	("+" | "-")? INT;
		public ParserRule getRule() { return rule; }

		//("+" | "-")? INT
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}

	public class ImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cImportedNamespaceAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final RuleCall cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0 = (RuleCall)cImportedNamespaceAssignment_1_0_0.eContents().get(0);
		private final Keyword cFromKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Keyword cModelKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Assignment cImportURIAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cImportURISTRINGTerminalRuleCall_2_0 = (RuleCall)cImportURIAssignment_2.eContents().get(0);
		
		//Import:
		//
		//	"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING;
		public ParserRule getRule() { return rule; }

		//"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING
		public Group getGroup() { return cGroup; }

		//"import"
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//importedNamespace=ImportedFQN "from" | "model"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//importedNamespace=ImportedFQN "from"
		public Group getGroup_1_0() { return cGroup_1_0; }

		//importedNamespace=ImportedFQN
		public Assignment getImportedNamespaceAssignment_1_0_0() { return cImportedNamespaceAssignment_1_0_0; }

		//ImportedFQN
		public RuleCall getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0() { return cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0; }

		//"from"
		public Keyword getFromKeyword_1_0_1() { return cFromKeyword_1_0_1; }

		//"model"
		public Keyword getModelKeyword_1_1() { return cModelKeyword_1_1; }

		//importURI=STRING
		public Assignment getImportURIAssignment_2() { return cImportURIAssignment_2; }

		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_2_0() { return cImportURISTRINGTerminalRuleCall_2_0; }
	}

	public class ImportedFQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImportedFQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cFQNParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopAsteriskKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ImportedFQN:
		//
		//	FQN ".*"?;
		public ParserRule getRule() { return rule; }

		//FQN ".*"?
		public Group getGroup() { return cGroup; }

		//FQN
		public RuleCall getFQNParserRuleCall_0() { return cFQNParserRuleCall_0; }

		//".*"?
		public Keyword getFullStopAsteriskKeyword_1() { return cFullStopAsteriskKeyword_1; }
	}

	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN:
		//
		//	ID ("." ID)*;
		public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	public class ExecModeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ExecMode");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPOLLEDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPOLLEDPolledKeyword_0_0 = (Keyword)cPOLLEDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cBLOCKEDEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cBLOCKEDBlockedKeyword_1_0 = (Keyword)cBLOCKEDEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cMIXEDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cMIXEDMixedKeyword_2_0 = (Keyword)cMIXEDEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum ExecMode:
		//
		//	POLLED="polled" | BLOCKED="blocked" | MIXED="mixed";
		public EnumRule getRule() { return rule; }

		//POLLED="polled" | BLOCKED="blocked" | MIXED="mixed"
		public Alternatives getAlternatives() { return cAlternatives; }

		//POLLED="polled"
		public EnumLiteralDeclaration getPOLLEDEnumLiteralDeclaration_0() { return cPOLLEDEnumLiteralDeclaration_0; }

		//"polled"
		public Keyword getPOLLEDPolledKeyword_0_0() { return cPOLLEDPolledKeyword_0_0; }

		//BLOCKED="blocked"
		public EnumLiteralDeclaration getBLOCKEDEnumLiteralDeclaration_1() { return cBLOCKEDEnumLiteralDeclaration_1; }

		//"blocked"
		public Keyword getBLOCKEDBlockedKeyword_1_0() { return cBLOCKEDBlockedKeyword_1_0; }

		//MIXED="mixed"
		public EnumLiteralDeclaration getMIXEDEnumLiteralDeclaration_2() { return cMIXEDEnumLiteralDeclaration_2; }

		//"mixed"
		public Keyword getMIXEDMixedKeyword_2_0() { return cMIXEDMixedKeyword_2_0; }
	}

	public class ThreadModelElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ThreadModel");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cSINGLE_THREADEDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cSINGLE_THREADEDSingleThreadedKeyword_0_0 = (Keyword)cSINGLE_THREADEDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cMULTI_THREADEDEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cMULTI_THREADEDMultiThreadedKeyword_1_0 = (Keyword)cMULTI_THREADEDEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum ThreadModel:
		//
		//	SINGLE_THREADED="singleThreaded" | MULTI_THREADED="multiThreaded";
		public EnumRule getRule() { return rule; }

		//SINGLE_THREADED="singleThreaded" | MULTI_THREADED="multiThreaded"
		public Alternatives getAlternatives() { return cAlternatives; }

		//SINGLE_THREADED="singleThreaded"
		public EnumLiteralDeclaration getSINGLE_THREADEDEnumLiteralDeclaration_0() { return cSINGLE_THREADEDEnumLiteralDeclaration_0; }

		//"singleThreaded"
		public Keyword getSINGLE_THREADEDSingleThreadedKeyword_0_0() { return cSINGLE_THREADEDSingleThreadedKeyword_0_0; }

		//MULTI_THREADED="multiThreaded"
		public EnumLiteralDeclaration getMULTI_THREADEDEnumLiteralDeclaration_1() { return cMULTI_THREADEDEnumLiteralDeclaration_1; }

		//"multiThreaded"
		public Keyword getMULTI_THREADEDMultiThreadedKeyword_1_0() { return cMULTI_THREADEDMultiThreadedKeyword_1_0; }
	}
	
	private PhysicalModelElements pPhysicalModel;
	private PhysicalSystemElements pPhysicalSystem;
	private NodeRefElements pNodeRef;
	private NodeClassElements pNodeClass;
	private PhysicalThreadElements pPhysicalThread;
	private ExecModeElements unknownRuleExecMode;
	private RuntimeClassElements pRuntimeClass;
	private ThreadModelElements unknownRuleThreadModel;
	private DocumentationElements pDocumentation;
	private PRIOElements pPRIO;
	private ImportElements pImport;
	private ImportedFQNElements pImportedFQN;
	private FQNElements pFQN;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public ETPhysGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.etrice.core.etphys.ETPhys".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//PhysicalModel:
	//
	//	"PhysicalModel" name=FQN "{" imports+=Import* (systems+=PhysicalSystem | nodeClasses+=NodeClass |
	//
	//	runtimeClasses+=RuntimeClass)* "}";
	public PhysicalModelElements getPhysicalModelAccess() {
		return (pPhysicalModel != null) ? pPhysicalModel : (pPhysicalModel = new PhysicalModelElements());
	}
	
	public ParserRule getPhysicalModelRule() {
		return getPhysicalModelAccess().getRule();
	}

	//PhysicalSystem:
	//
	//	"PhysicalSystem" name=ID docu=Documentation? "{" nodeRefs+=NodeRef* "}";
	public PhysicalSystemElements getPhysicalSystemAccess() {
		return (pPhysicalSystem != null) ? pPhysicalSystem : (pPhysicalSystem = new PhysicalSystemElements());
	}
	
	public ParserRule getPhysicalSystemRule() {
		return getPhysicalSystemAccess().getRule();
	}

	//NodeRef:
	//
	//	"NodeRef" name=ID ":" type=[NodeClass|FQN] docu=Documentation?;
	public NodeRefElements getNodeRefAccess() {
		return (pNodeRef != null) ? pNodeRef : (pNodeRef = new NodeRefElements());
	}
	
	public ParserRule getNodeRefRule() {
		return getNodeRefAccess().getRule();
	}

	//NodeClass:
	//
	//	"NodeClass" name=ID docu=Documentation? "{" "runtime" "=" runtime=[RuntimeClass|FQN] "priomin" "=" priomin=PRIO
	//
	//	"priomax" "=" priomax=PRIO threads+=PhysicalThread* "}";
	public NodeClassElements getNodeClassAccess() {
		return (pNodeClass != null) ? pNodeClass : (pNodeClass = new NodeClassElements());
	}
	
	public ParserRule getNodeClassRule() {
		return getNodeClassAccess().getRule();
	}

	//PhysicalThread:
	//
	//	(default?="DefaultThread" | "Thread") name=ID "{" "execmode" "=" execmode=ExecMode "prio" "=" prio=PRIO "stacksize"
	//
	//	"=" stacksize=INT "msgblocksize" "=" msgblocksize=INT "msgpoolsize" "=" msgpoolsize=INT "}";
	public PhysicalThreadElements getPhysicalThreadAccess() {
		return (pPhysicalThread != null) ? pPhysicalThread : (pPhysicalThread = new PhysicalThreadElements());
	}
	
	public ParserRule getPhysicalThreadRule() {
		return getPhysicalThreadAccess().getRule();
	}

	//enum ExecMode:
	//
	//	POLLED="polled" | BLOCKED="blocked" | MIXED="mixed";
	public ExecModeElements getExecModeAccess() {
		return (unknownRuleExecMode != null) ? unknownRuleExecMode : (unknownRuleExecMode = new ExecModeElements());
	}
	
	public EnumRule getExecModeRule() {
		return getExecModeAccess().getRule();
	}

	//RuntimeClass:
	//
	//	"RuntimeClass" name=ID docu=Documentation? "{" "model" "=" threadModel=ThreadModel "}";
	public RuntimeClassElements getRuntimeClassAccess() {
		return (pRuntimeClass != null) ? pRuntimeClass : (pRuntimeClass = new RuntimeClassElements());
	}
	
	public ParserRule getRuntimeClassRule() {
		return getRuntimeClassAccess().getRule();
	}

	//enum ThreadModel:
	//
	//	SINGLE_THREADED="singleThreaded" | MULTI_THREADED="multiThreaded";
	public ThreadModelElements getThreadModelAccess() {
		return (unknownRuleThreadModel != null) ? unknownRuleThreadModel : (unknownRuleThreadModel = new ThreadModelElements());
	}
	
	public EnumRule getThreadModelRule() {
		return getThreadModelAccess().getRule();
	}

	//Documentation:
	//
	//	"[" text+=STRING+ "]";
	public DocumentationElements getDocumentationAccess() {
		return (pDocumentation != null) ? pDocumentation : (pDocumentation = new DocumentationElements());
	}
	
	public ParserRule getDocumentationRule() {
		return getDocumentationAccess().getRule();
	}

	//PRIO returns ecore::EInt hidden():
	//
	//	("+" | "-")? INT;
	public PRIOElements getPRIOAccess() {
		return (pPRIO != null) ? pPRIO : (pPRIO = new PRIOElements());
	}
	
	public ParserRule getPRIORule() {
		return getPRIOAccess().getRule();
	}

	//Import:
	//
	//	"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING;
	public ImportElements getImportAccess() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//ImportedFQN:
	//
	//	FQN ".*"?;
	public ImportedFQNElements getImportedFQNAccess() {
		return (pImportedFQN != null) ? pImportedFQN : (pImportedFQN = new ImportedFQNElements());
	}
	
	public ParserRule getImportedFQNRule() {
		return getImportedFQNAccess().getRule();
	}

	//FQN:
	//
	//	ID ("." ID)*;
	public FQNElements getFQNAccess() {
		return (pFQN != null) ? pFQN : (pFQN = new FQNElements());
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}

	//terminal ID:
	//
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
