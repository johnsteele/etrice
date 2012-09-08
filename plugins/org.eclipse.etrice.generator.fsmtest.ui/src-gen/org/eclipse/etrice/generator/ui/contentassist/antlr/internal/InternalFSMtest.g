/*
* generated by Xtext
*/
grammar InternalFSMtest;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.eclipse.etrice.generator.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.etrice.generator.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.etrice.generator.services.FSMtestGrammarAccess;

}

@parser::members {
 
 	private FSMtestGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(FSMtestGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleModel
entryRuleModel 
:
{ before(grammarAccess.getModelRule()); }
	 ruleModel
{ after(grammarAccess.getModelRule()); } 
	 EOF 
;

// Rule Model
ruleModel
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModelAccess().getTestscriptsAssignment()); }
(rule__Model__TestscriptsAssignment)*
{ after(grammarAccess.getModelAccess().getTestscriptsAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTestscript
entryRuleTestscript 
:
{ before(grammarAccess.getTestscriptRule()); }
	 ruleTestscript
{ after(grammarAccess.getTestscriptRule()); } 
	 EOF 
;

// Rule Testscript
ruleTestscript
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTestscriptAccess().getGroup()); }
(rule__Testscript__Group__0)
{ after(grammarAccess.getTestscriptAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleState
entryRuleState 
:
{ before(grammarAccess.getStateRule()); }
	 ruleState
{ after(grammarAccess.getStateRule()); } 
	 EOF 
;

// Rule State
ruleState
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStateAccess().getNameAssignment()); }
(rule__State__NameAssignment)
{ after(grammarAccess.getStateAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStateDeclaration
entryRuleStateDeclaration 
:
{ before(grammarAccess.getStateDeclarationRule()); }
	 ruleStateDeclaration
{ after(grammarAccess.getStateDeclarationRule()); } 
	 EOF 
;

// Rule StateDeclaration
ruleStateDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStateDeclarationAccess().getGroup()); }
(rule__StateDeclaration__Group__0)
{ after(grammarAccess.getStateDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInitialDeclaration
entryRuleInitialDeclaration 
:
{ before(grammarAccess.getInitialDeclarationRule()); }
	 ruleInitialDeclaration
{ after(grammarAccess.getInitialDeclarationRule()); } 
	 EOF 
;

// Rule InitialDeclaration
ruleInitialDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInitialDeclarationAccess().getGroup()); }
(rule__InitialDeclaration__Group__0)
{ after(grammarAccess.getInitialDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLoopsDeclaration
entryRuleLoopsDeclaration 
:
{ before(grammarAccess.getLoopsDeclarationRule()); }
	 ruleLoopsDeclaration
{ after(grammarAccess.getLoopsDeclarationRule()); } 
	 EOF 
;

// Rule LoopsDeclaration
ruleLoopsDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLoopsDeclarationAccess().getGroup()); }
(rule__LoopsDeclaration__Group__0)
{ after(grammarAccess.getLoopsDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSeedDeclaration
entryRuleSeedDeclaration 
:
{ before(grammarAccess.getSeedDeclarationRule()); }
	 ruleSeedDeclaration
{ after(grammarAccess.getSeedDeclarationRule()); } 
	 EOF 
;

// Rule SeedDeclaration
ruleSeedDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSeedDeclarationAccess().getGroup()); }
(rule__SeedDeclaration__Group__0)
{ after(grammarAccess.getSeedDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSignalDeclaration
entryRuleSignalDeclaration 
:
{ before(grammarAccess.getSignalDeclarationRule()); }
	 ruleSignalDeclaration
{ after(grammarAccess.getSignalDeclarationRule()); } 
	 EOF 
;

// Rule SignalDeclaration
ruleSignalDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSignalDeclarationAccess().getGroup()); }
(rule__SignalDeclaration__Group__0)
{ after(grammarAccess.getSignalDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSourceDeclaration
entryRuleSourceDeclaration 
:
{ before(grammarAccess.getSourceDeclarationRule()); }
	 ruleSourceDeclaration
{ after(grammarAccess.getSourceDeclarationRule()); } 
	 EOF 
;

// Rule SourceDeclaration
ruleSourceDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSourceDeclarationAccess().getGroup()); }
(rule__SourceDeclaration__Group__0)
{ after(grammarAccess.getSourceDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDestinationDeclaration
entryRuleDestinationDeclaration 
:
{ before(grammarAccess.getDestinationDeclarationRule()); }
	 ruleDestinationDeclaration
{ after(grammarAccess.getDestinationDeclarationRule()); } 
	 EOF 
;

// Rule DestinationDeclaration
ruleDestinationDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDestinationDeclarationAccess().getGroup()); }
(rule__DestinationDeclaration__Group__0)
{ after(grammarAccess.getDestinationDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTransitionDeclaration
entryRuleTransitionDeclaration 
:
{ before(grammarAccess.getTransitionDeclarationRule()); }
	 ruleTransitionDeclaration
{ after(grammarAccess.getTransitionDeclarationRule()); } 
	 EOF 
;

// Rule TransitionDeclaration
ruleTransitionDeclaration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getGroup()); }
(rule__TransitionDeclaration__Group__0)
{ after(grammarAccess.getTransitionDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__SignalDeclaration__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getGroup_2_0()); }
(rule__SignalDeclaration__Group_2_0__0)
{ after(grammarAccess.getSignalDeclarationAccess().getGroup_2_0()); }
)

    |(
{ before(grammarAccess.getSignalDeclarationAccess().getGroup_2_1()); }
(rule__SignalDeclaration__Group_2_1__0)
{ after(grammarAccess.getSignalDeclarationAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Testscript__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__0__Impl
	rule__Testscript__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getFsmtestKeyword_0()); }

	'fsmtest' 

{ after(grammarAccess.getTestscriptAccess().getFsmtestKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__1__Impl
	rule__Testscript__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getNameAssignment_1()); }
(rule__Testscript__NameAssignment_1)
{ after(grammarAccess.getTestscriptAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__2__Impl
	rule__Testscript__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getStateDeclarationAssignment_2()); }
(rule__Testscript__StateDeclarationAssignment_2)
{ after(grammarAccess.getTestscriptAccess().getStateDeclarationAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__3__Impl
	rule__Testscript__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getInitialDeclarationAssignment_3()); }
(rule__Testscript__InitialDeclarationAssignment_3)
{ after(grammarAccess.getTestscriptAccess().getInitialDeclarationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__4__Impl
	rule__Testscript__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getLoopsDeclarationAssignment_4()); }
(rule__Testscript__LoopsDeclarationAssignment_4)
{ after(grammarAccess.getTestscriptAccess().getLoopsDeclarationAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__5__Impl
	rule__Testscript__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getSeedDeclarationAssignment_5()); }
(rule__Testscript__SeedDeclarationAssignment_5)?
{ after(grammarAccess.getTestscriptAccess().getSeedDeclarationAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__6__Impl
	rule__Testscript__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getTransitionDeclarationsAssignment_6()); }
(rule__Testscript__TransitionDeclarationsAssignment_6)*
{ after(grammarAccess.getTestscriptAccess().getTransitionDeclarationsAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Testscript__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Testscript__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getSemicolonKeyword_7()); }

	';' 

{ after(grammarAccess.getTestscriptAccess().getSemicolonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__StateDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StateDeclaration__Group__0__Impl
	rule__StateDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getStatesKeyword_0()); }

	'states:' 

{ after(grammarAccess.getStateDeclarationAccess().getStatesKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StateDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StateDeclaration__Group__1__Impl
	rule__StateDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getStatesAssignment_1()); }
(rule__StateDeclaration__StatesAssignment_1)
{ after(grammarAccess.getStateDeclarationAccess().getStatesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StateDeclaration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StateDeclaration__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getGroup_2()); }
(rule__StateDeclaration__Group_2__0)*
{ after(grammarAccess.getStateDeclarationAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StateDeclaration__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StateDeclaration__Group_2__0__Impl
	rule__StateDeclaration__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getCommaKeyword_2_0()); }

	',' 

{ after(grammarAccess.getStateDeclarationAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StateDeclaration__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StateDeclaration__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getStatesAssignment_2_1()); }
(rule__StateDeclaration__StatesAssignment_2_1)
{ after(grammarAccess.getStateDeclarationAccess().getStatesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InitialDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InitialDeclaration__Group__0__Impl
	rule__InitialDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InitialDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInitialDeclarationAccess().getInitialKeyword_0()); }

	'initial:' 

{ after(grammarAccess.getInitialDeclarationAccess().getInitialKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InitialDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InitialDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InitialDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInitialDeclarationAccess().getInitialAssignment_1()); }
(rule__InitialDeclaration__InitialAssignment_1)
{ after(grammarAccess.getInitialDeclarationAccess().getInitialAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LoopsDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LoopsDeclaration__Group__0__Impl
	rule__LoopsDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LoopsDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLoopsDeclarationAccess().getLoopsKeyword_0()); }

	'loops:' 

{ after(grammarAccess.getLoopsDeclarationAccess().getLoopsKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LoopsDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LoopsDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LoopsDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLoopsDeclarationAccess().getValAssignment_1()); }
(rule__LoopsDeclaration__ValAssignment_1)
{ after(grammarAccess.getLoopsDeclarationAccess().getValAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SeedDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SeedDeclaration__Group__0__Impl
	rule__SeedDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SeedDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSeedDeclarationAccess().getRandseedKeyword_0()); }

	'randseed:' 

{ after(grammarAccess.getSeedDeclarationAccess().getRandseedKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SeedDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SeedDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SeedDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSeedDeclarationAccess().getValAssignment_1()); }
(rule__SeedDeclaration__ValAssignment_1)
{ after(grammarAccess.getSeedDeclarationAccess().getValAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignalDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group__0__Impl
	rule__SignalDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getGroup_0()); }
(rule__SignalDeclaration__Group_0__0)?
{ after(grammarAccess.getSignalDeclarationAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignalDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group__1__Impl
	rule__SignalDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getSignameAssignment_1()); }
(rule__SignalDeclaration__SignameAssignment_1)
{ after(grammarAccess.getSignalDeclarationAccess().getSignameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignalDeclaration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getAlternatives_2()); }
(rule__SignalDeclaration__Alternatives_2)?
{ after(grammarAccess.getSignalDeclarationAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SignalDeclaration__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_0__0__Impl
	rule__SignalDeclaration__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getPortAssignment_0_0()); }
(rule__SignalDeclaration__PortAssignment_0_0)
{ after(grammarAccess.getSignalDeclarationAccess().getPortAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignalDeclaration__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getFullStopKeyword_0_1()); }

	'.' 

{ after(grammarAccess.getSignalDeclarationAccess().getFullStopKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignalDeclaration__Group_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_2_0__0__Impl
	rule__SignalDeclaration__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_0_0()); }

	'=' 

{ after(grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignalDeclaration__Group_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getIntValAssignment_2_0_1()); }
(rule__SignalDeclaration__IntValAssignment_2_0_1)
{ after(grammarAccess.getSignalDeclarationAccess().getIntValAssignment_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignalDeclaration__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_2_1__0__Impl
	rule__SignalDeclaration__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_1_0()); }

	'=' 

{ after(grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignalDeclaration__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignalDeclaration__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getStrValAssignment_2_1_1()); }
(rule__SignalDeclaration__StrValAssignment_2_1_1)
{ after(grammarAccess.getSignalDeclarationAccess().getStrValAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SourceDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SourceDeclaration__Group__0__Impl
	rule__SourceDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SourceDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSourceDeclarationAccess().getRefAssignment_0()); }
(rule__SourceDeclaration__RefAssignment_0)
{ after(grammarAccess.getSourceDeclarationAccess().getRefAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SourceDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SourceDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SourceDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSourceDeclarationAccess().getColonKeyword_1()); }

	':' 

{ after(grammarAccess.getSourceDeclarationAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DestinationDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DestinationDeclaration__Group__0__Impl
	rule__DestinationDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DestinationDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDestinationDeclarationAccess().getHyphenMinusGreaterThanSignSpaceKeyword_0()); }

	'-> ' 

{ after(grammarAccess.getDestinationDeclarationAccess().getHyphenMinusGreaterThanSignSpaceKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DestinationDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DestinationDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DestinationDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDestinationDeclarationAccess().getRefAssignment_1()); }
(rule__DestinationDeclaration__RefAssignment_1)
{ after(grammarAccess.getDestinationDeclarationAccess().getRefAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TransitionDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__0__Impl
	rule__TransitionDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getSourceAssignment_0()); }
(rule__TransitionDeclaration__SourceAssignment_0)
{ after(grammarAccess.getTransitionDeclarationAccess().getSourceAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__1__Impl
	rule__TransitionDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getInKeyword_1()); }

	'in:' 

{ after(grammarAccess.getTransitionDeclarationAccess().getInKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionDeclaration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__2__Impl
	rule__TransitionDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getInAssignment_2()); }
(rule__TransitionDeclaration__InAssignment_2)*
{ after(grammarAccess.getTransitionDeclarationAccess().getInAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionDeclaration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__3__Impl
	rule__TransitionDeclaration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getOutKeyword_3()); }

	'out:' 

{ after(grammarAccess.getTransitionDeclarationAccess().getOutKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionDeclaration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__4__Impl
	rule__TransitionDeclaration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getOutAssignment_4()); }
(rule__TransitionDeclaration__OutAssignment_4)*
{ after(grammarAccess.getTransitionDeclarationAccess().getOutAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionDeclaration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionDeclaration__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getDestinationAssignment_5()); }
(rule__TransitionDeclaration__DestinationAssignment_5)
{ after(grammarAccess.getTransitionDeclarationAccess().getDestinationAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}















rule__Model__TestscriptsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelAccess().getTestscriptsTestscriptParserRuleCall_0()); }
	ruleTestscript{ after(grammarAccess.getModelAccess().getTestscriptsTestscriptParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getTestscriptAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__StateDeclarationAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getStateDeclarationStateDeclarationParserRuleCall_2_0()); }
	ruleStateDeclaration{ after(grammarAccess.getTestscriptAccess().getStateDeclarationStateDeclarationParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__InitialDeclarationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getInitialDeclarationInitialDeclarationParserRuleCall_3_0()); }
	ruleInitialDeclaration{ after(grammarAccess.getTestscriptAccess().getInitialDeclarationInitialDeclarationParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__LoopsDeclarationAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getLoopsDeclarationLoopsDeclarationParserRuleCall_4_0()); }
	ruleLoopsDeclaration{ after(grammarAccess.getTestscriptAccess().getLoopsDeclarationLoopsDeclarationParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__SeedDeclarationAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getSeedDeclarationSeedDeclarationParserRuleCall_5_0()); }
	ruleSeedDeclaration{ after(grammarAccess.getTestscriptAccess().getSeedDeclarationSeedDeclarationParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Testscript__TransitionDeclarationsAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTestscriptAccess().getTransitionDeclarationsTransitionDeclarationParserRuleCall_6_0()); }
	ruleTransitionDeclaration{ after(grammarAccess.getTestscriptAccess().getTransitionDeclarationsTransitionDeclarationParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0()); }
	RULE_ID{ after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__StatesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_1_0()); }
	ruleState{ after(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StateDeclaration__StatesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_2_1_0()); }
	ruleState{ after(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InitialDeclaration__InitialAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInitialDeclarationAccess().getInitialStateCrossReference_1_0()); }
(
{ before(grammarAccess.getInitialDeclarationAccess().getInitialStateIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getInitialDeclarationAccess().getInitialStateIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getInitialDeclarationAccess().getInitialStateCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LoopsDeclaration__ValAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLoopsDeclarationAccess().getValINTTerminalRuleCall_1_0()); }
	RULE_INT{ after(grammarAccess.getLoopsDeclarationAccess().getValINTTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SeedDeclaration__ValAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSeedDeclarationAccess().getValINTTerminalRuleCall_1_0()); }
	RULE_INT{ after(grammarAccess.getSeedDeclarationAccess().getValINTTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__PortAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getPortIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getSignalDeclarationAccess().getPortIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__SignameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getSignameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSignalDeclarationAccess().getSignameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__IntValAssignment_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getIntValINTTerminalRuleCall_2_0_1_0()); }
	RULE_INT{ after(grammarAccess.getSignalDeclarationAccess().getIntValINTTerminalRuleCall_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignalDeclaration__StrValAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalDeclarationAccess().getStrValSTRINGTerminalRuleCall_2_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getSignalDeclarationAccess().getStrValSTRINGTerminalRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SourceDeclaration__RefAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSourceDeclarationAccess().getRefStateCrossReference_0_0()); }
(
{ before(grammarAccess.getSourceDeclarationAccess().getRefStateIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getSourceDeclarationAccess().getRefStateIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getSourceDeclarationAccess().getRefStateCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DestinationDeclaration__RefAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDestinationDeclarationAccess().getRefStateCrossReference_1_0()); }
(
{ before(grammarAccess.getDestinationDeclarationAccess().getRefStateIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getDestinationDeclarationAccess().getRefStateIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getDestinationDeclarationAccess().getRefStateCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__SourceAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getSourceSourceDeclarationParserRuleCall_0_0()); }
	ruleSourceDeclaration{ after(grammarAccess.getTransitionDeclarationAccess().getSourceSourceDeclarationParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__InAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getInSignalDeclarationParserRuleCall_2_0()); }
	ruleSignalDeclaration{ after(grammarAccess.getTransitionDeclarationAccess().getInSignalDeclarationParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__OutAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getOutSignalDeclarationParserRuleCall_4_0()); }
	ruleSignalDeclaration{ after(grammarAccess.getTransitionDeclarationAccess().getOutSignalDeclarationParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionDeclaration__DestinationAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionDeclarationAccess().getDestinationDestinationDeclarationParserRuleCall_5_0()); }
	ruleDestinationDeclaration{ after(grammarAccess.getTransitionDeclarationAccess().getDestinationDestinationDeclarationParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

