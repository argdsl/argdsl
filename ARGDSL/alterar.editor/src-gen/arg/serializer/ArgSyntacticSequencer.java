/*
 * generated by Xtext 2.28.0
 */
package arg.serializer;

import arg.services.ArgGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ArgSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ArgGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PhysicChange_InKeyword_2_0_q;
	protected AbstractElementAlias match_PhysicChange_NamedKeyword_3_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ArgGrammarAccess) access;
		match_PhysicChange_InKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getPhysicChangeAccess().getInKeyword_2_0());
		match_PhysicChange_NamedKeyword_3_q = new TokenAlias(false, true, grammarAccess.getPhysicChangeAccess().getNamedKeyword_3());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_PhysicChange_InKeyword_2_0_q.equals(syntax))
				emit_PhysicChange_InKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PhysicChange_NamedKeyword_3_q.equals(syntax))
				emit_PhysicChange_NamedKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'in'?
	 *
	 * This ambiguous syntax occurs at:
	 *     action=Action (ambiguity) class=[Class|EString]
	 
	 * </pre>
	 */
	protected void emit_PhysicChange_InKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'named'?
	 *
	 * This ambiguous syntax occurs at:
	 *     action=Action (ambiguity) object=EString
	 *     class=[Class|EString] (ambiguity) object=EString
	 
	 * </pre>
	 */
	protected void emit_PhysicChange_NamedKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}