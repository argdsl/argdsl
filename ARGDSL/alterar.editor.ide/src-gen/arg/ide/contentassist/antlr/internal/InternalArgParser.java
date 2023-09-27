package arg.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import arg.services.ArgGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArgParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'E'", "'e'", "'camera'", "'drag'", "'tilt'", "'touch'", "'any'", "'horizontal'", "'vertical'", "'static'", "'dynamic'", "'kinematic'", "'start'", "'win'", "'lose'", "'none'", "'restart'", "'create'", "'edit'", "'delete'", "'front'", "'default'", "'back'", "'&'", "'|'", "'='", "'>'", "'>='", "'<'", "'<='", "'Game'", "'{'", "'elements'", "'}'", "'dependences'", "'Graphic'", "'Physics'", "'Gamelogic'", "'Display'", "'score'", "'Actions'", "'Collisions'", "'Buttons'", "'Elements'", "':'", "'['", "'..'", "']'", "'min'", "'max'", "'target'", "'containtment'", "'opposite'", "'-'", "'element'", "'versions'", "'constraints'", "'plane'", "'sizeMin'", "'sizeMax'", "'xVariation'", "'yVariation'", "'zVariation'", "'rotation'", "'.'", "'body'", "'forces'", "'contacts'", "'mass'", "'bodyType'", "'charge'", "'friction'", "'rollingFriction'", "'restitution'", "'damping'", "'angularDamping'", "'collision'", "'contact'", "'gesture'", "','", "'->'", "'finish'", "'lives'", "'action'", "'message'", "'timeEach'", "'changes'", "'to'", "'attributes'", "'rules'", "'do'", "'named'", "'in'", "'at'", "'scale'", "'stat'", "'changeStat'", "'force'", "'value'", "'if('", "')'", "'!'", "'('", "'Number'", "'abstract'", "'invisible'", "'isParam'", "'isKey'", "'readOnly'", "'overlaps'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalArgParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArgParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArgParser.tokenNames; }
    public String getGrammarFileName() { return "InternalArg.g"; }


    	private ArgGrammarAccess grammarAccess;

    	public void setGrammarAccess(ArgGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleOntological"
    // InternalArg.g:53:1: entryRuleOntological : ruleOntological EOF ;
    public final void entryRuleOntological() throws RecognitionException {
        try {
            // InternalArg.g:54:1: ( ruleOntological EOF )
            // InternalArg.g:55:1: ruleOntological EOF
            {
             before(grammarAccess.getOntologicalRule()); 
            pushFollow(FOLLOW_1);
            ruleOntological();

            state._fsp--;

             after(grammarAccess.getOntologicalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOntological"


    // $ANTLR start "ruleOntological"
    // InternalArg.g:62:1: ruleOntological : ( ( rule__Ontological__Group__0 ) ) ;
    public final void ruleOntological() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:66:2: ( ( ( rule__Ontological__Group__0 ) ) )
            // InternalArg.g:67:2: ( ( rule__Ontological__Group__0 ) )
            {
            // InternalArg.g:67:2: ( ( rule__Ontological__Group__0 ) )
            // InternalArg.g:68:3: ( rule__Ontological__Group__0 )
            {
             before(grammarAccess.getOntologicalAccess().getGroup()); 
            // InternalArg.g:69:3: ( rule__Ontological__Group__0 )
            // InternalArg.g:69:4: rule__Ontological__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOntological"


    // $ANTLR start "entryRuleCondition"
    // InternalArg.g:78:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalArg.g:79:1: ( ruleCondition EOF )
            // InternalArg.g:80:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalArg.g:87:1: ruleCondition : ( ( rule__Condition__Alternatives ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:91:2: ( ( ( rule__Condition__Alternatives ) ) )
            // InternalArg.g:92:2: ( ( rule__Condition__Alternatives ) )
            {
            // InternalArg.g:92:2: ( ( rule__Condition__Alternatives ) )
            // InternalArg.g:93:3: ( rule__Condition__Alternatives )
            {
             before(grammarAccess.getConditionAccess().getAlternatives()); 
            // InternalArg.g:94:3: ( rule__Condition__Alternatives )
            // InternalArg.g:94:4: rule__Condition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleValue"
    // InternalArg.g:103:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalArg.g:104:1: ( ruleValue EOF )
            // InternalArg.g:105:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalArg.g:112:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:116:2: ( ( ( rule__Value__Alternatives ) ) )
            // InternalArg.g:117:2: ( ( rule__Value__Alternatives ) )
            {
            // InternalArg.g:117:2: ( ( rule__Value__Alternatives ) )
            // InternalArg.g:118:3: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalArg.g:119:3: ( rule__Value__Alternatives )
            // InternalArg.g:119:4: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleEString"
    // InternalArg.g:128:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalArg.g:129:1: ( ruleEString EOF )
            // InternalArg.g:130:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalArg.g:137:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:141:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalArg.g:142:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalArg.g:142:2: ( ( rule__EString__Alternatives ) )
            // InternalArg.g:143:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalArg.g:144:3: ( rule__EString__Alternatives )
            // InternalArg.g:144:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleClass"
    // InternalArg.g:153:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalArg.g:154:1: ( ruleClass EOF )
            // InternalArg.g:155:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_1);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalArg.g:162:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:166:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalArg.g:167:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalArg.g:167:2: ( ( rule__Class__Group__0 ) )
            // InternalArg.g:168:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalArg.g:169:3: ( rule__Class__Group__0 )
            // InternalArg.g:169:4: rule__Class__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleGraphic"
    // InternalArg.g:178:1: entryRuleGraphic : ruleGraphic EOF ;
    public final void entryRuleGraphic() throws RecognitionException {
        try {
            // InternalArg.g:179:1: ( ruleGraphic EOF )
            // InternalArg.g:180:1: ruleGraphic EOF
            {
             before(grammarAccess.getGraphicRule()); 
            pushFollow(FOLLOW_1);
            ruleGraphic();

            state._fsp--;

             after(grammarAccess.getGraphicRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGraphic"


    // $ANTLR start "ruleGraphic"
    // InternalArg.g:187:1: ruleGraphic : ( ( rule__Graphic__Group__0 ) ) ;
    public final void ruleGraphic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:191:2: ( ( ( rule__Graphic__Group__0 ) ) )
            // InternalArg.g:192:2: ( ( rule__Graphic__Group__0 ) )
            {
            // InternalArg.g:192:2: ( ( rule__Graphic__Group__0 ) )
            // InternalArg.g:193:3: ( rule__Graphic__Group__0 )
            {
             before(grammarAccess.getGraphicAccess().getGroup()); 
            // InternalArg.g:194:3: ( rule__Graphic__Group__0 )
            // InternalArg.g:194:4: rule__Graphic__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Graphic__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGraphicAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraphic"


    // $ANTLR start "entryRulePhysic"
    // InternalArg.g:203:1: entryRulePhysic : rulePhysic EOF ;
    public final void entryRulePhysic() throws RecognitionException {
        try {
            // InternalArg.g:204:1: ( rulePhysic EOF )
            // InternalArg.g:205:1: rulePhysic EOF
            {
             before(grammarAccess.getPhysicRule()); 
            pushFollow(FOLLOW_1);
            rulePhysic();

            state._fsp--;

             after(grammarAccess.getPhysicRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysic"


    // $ANTLR start "rulePhysic"
    // InternalArg.g:212:1: rulePhysic : ( ( rule__Physic__Group__0 ) ) ;
    public final void rulePhysic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:216:2: ( ( ( rule__Physic__Group__0 ) ) )
            // InternalArg.g:217:2: ( ( rule__Physic__Group__0 ) )
            {
            // InternalArg.g:217:2: ( ( rule__Physic__Group__0 ) )
            // InternalArg.g:218:3: ( rule__Physic__Group__0 )
            {
             before(grammarAccess.getPhysicAccess().getGroup()); 
            // InternalArg.g:219:3: ( rule__Physic__Group__0 )
            // InternalArg.g:219:4: rule__Physic__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Physic__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysic"


    // $ANTLR start "entryRuleGame"
    // InternalArg.g:228:1: entryRuleGame : ruleGame EOF ;
    public final void entryRuleGame() throws RecognitionException {
        try {
            // InternalArg.g:229:1: ( ruleGame EOF )
            // InternalArg.g:230:1: ruleGame EOF
            {
             before(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            ruleGame();

            state._fsp--;

             after(grammarAccess.getGameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalArg.g:237:1: ruleGame : ( ( rule__Game__Group__0 ) ) ;
    public final void ruleGame() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:241:2: ( ( ( rule__Game__Group__0 ) ) )
            // InternalArg.g:242:2: ( ( rule__Game__Group__0 ) )
            {
            // InternalArg.g:242:2: ( ( rule__Game__Group__0 ) )
            // InternalArg.g:243:3: ( rule__Game__Group__0 )
            {
             before(grammarAccess.getGameAccess().getGroup()); 
            // InternalArg.g:244:3: ( rule__Game__Group__0 )
            // InternalArg.g:244:4: rule__Game__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleAttribute"
    // InternalArg.g:253:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalArg.g:254:1: ( ruleAttribute EOF )
            // InternalArg.g:255:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalArg.g:262:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:266:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalArg.g:267:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalArg.g:267:2: ( ( rule__Attribute__Group__0 ) )
            // InternalArg.g:268:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalArg.g:269:3: ( rule__Attribute__Group__0 )
            // InternalArg.g:269:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeMax"
    // InternalArg.g:278:1: entryRuleAttributeMax : ruleAttributeMax EOF ;
    public final void entryRuleAttributeMax() throws RecognitionException {
        try {
            // InternalArg.g:279:1: ( ruleAttributeMax EOF )
            // InternalArg.g:280:1: ruleAttributeMax EOF
            {
             before(grammarAccess.getAttributeMaxRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeMax();

            state._fsp--;

             after(grammarAccess.getAttributeMaxRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeMax"


    // $ANTLR start "ruleAttributeMax"
    // InternalArg.g:287:1: ruleAttributeMax : ( ( rule__AttributeMax__Alternatives ) ) ;
    public final void ruleAttributeMax() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:291:2: ( ( ( rule__AttributeMax__Alternatives ) ) )
            // InternalArg.g:292:2: ( ( rule__AttributeMax__Alternatives ) )
            {
            // InternalArg.g:292:2: ( ( rule__AttributeMax__Alternatives ) )
            // InternalArg.g:293:3: ( rule__AttributeMax__Alternatives )
            {
             before(grammarAccess.getAttributeMaxAccess().getAlternatives()); 
            // InternalArg.g:294:3: ( rule__AttributeMax__Alternatives )
            // InternalArg.g:294:4: rule__AttributeMax__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AttributeMax__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributeMaxAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeMax"


    // $ANTLR start "entryRuleReference"
    // InternalArg.g:303:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalArg.g:304:1: ( ruleReference EOF )
            // InternalArg.g:305:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalArg.g:312:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:316:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalArg.g:317:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalArg.g:317:2: ( ( rule__Reference__Group__0 ) )
            // InternalArg.g:318:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalArg.g:319:3: ( rule__Reference__Group__0 )
            // InternalArg.g:319:4: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleEInt"
    // InternalArg.g:328:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalArg.g:329:1: ( ruleEInt EOF )
            // InternalArg.g:330:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalArg.g:337:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:341:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalArg.g:342:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalArg.g:342:2: ( ( rule__EInt__Group__0 ) )
            // InternalArg.g:343:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalArg.g:344:3: ( rule__EInt__Group__0 )
            // InternalArg.g:344:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleGraphicClass"
    // InternalArg.g:353:1: entryRuleGraphicClass : ruleGraphicClass EOF ;
    public final void entryRuleGraphicClass() throws RecognitionException {
        try {
            // InternalArg.g:354:1: ( ruleGraphicClass EOF )
            // InternalArg.g:355:1: ruleGraphicClass EOF
            {
             before(grammarAccess.getGraphicClassRule()); 
            pushFollow(FOLLOW_1);
            ruleGraphicClass();

            state._fsp--;

             after(grammarAccess.getGraphicClassRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGraphicClass"


    // $ANTLR start "ruleGraphicClass"
    // InternalArg.g:362:1: ruleGraphicClass : ( ( rule__GraphicClass__Group__0 ) ) ;
    public final void ruleGraphicClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:366:2: ( ( ( rule__GraphicClass__Group__0 ) ) )
            // InternalArg.g:367:2: ( ( rule__GraphicClass__Group__0 ) )
            {
            // InternalArg.g:367:2: ( ( rule__GraphicClass__Group__0 ) )
            // InternalArg.g:368:3: ( rule__GraphicClass__Group__0 )
            {
             before(grammarAccess.getGraphicClassAccess().getGroup()); 
            // InternalArg.g:369:3: ( rule__GraphicClass__Group__0 )
            // InternalArg.g:369:4: rule__GraphicClass__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGraphicClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraphicClass"


    // $ANTLR start "entryRuleConstraints"
    // InternalArg.g:378:1: entryRuleConstraints : ruleConstraints EOF ;
    public final void entryRuleConstraints() throws RecognitionException {
        try {
            // InternalArg.g:379:1: ( ruleConstraints EOF )
            // InternalArg.g:380:1: ruleConstraints EOF
            {
             before(grammarAccess.getConstraintsRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraints();

            state._fsp--;

             after(grammarAccess.getConstraintsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraints"


    // $ANTLR start "ruleConstraints"
    // InternalArg.g:387:1: ruleConstraints : ( ( rule__Constraints__Group__0 ) ) ;
    public final void ruleConstraints() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:391:2: ( ( ( rule__Constraints__Group__0 ) ) )
            // InternalArg.g:392:2: ( ( rule__Constraints__Group__0 ) )
            {
            // InternalArg.g:392:2: ( ( rule__Constraints__Group__0 ) )
            // InternalArg.g:393:3: ( rule__Constraints__Group__0 )
            {
             before(grammarAccess.getConstraintsAccess().getGroup()); 
            // InternalArg.g:394:3: ( rule__Constraints__Group__0 )
            // InternalArg.g:394:4: rule__Constraints__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraints"


    // $ANTLR start "entryRuleVersions"
    // InternalArg.g:403:1: entryRuleVersions : ruleVersions EOF ;
    public final void entryRuleVersions() throws RecognitionException {
        try {
            // InternalArg.g:404:1: ( ruleVersions EOF )
            // InternalArg.g:405:1: ruleVersions EOF
            {
             before(grammarAccess.getVersionsRule()); 
            pushFollow(FOLLOW_1);
            ruleVersions();

            state._fsp--;

             after(grammarAccess.getVersionsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersions"


    // $ANTLR start "ruleVersions"
    // InternalArg.g:412:1: ruleVersions : ( ( rule__Versions__Group__0 ) ) ;
    public final void ruleVersions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:416:2: ( ( ( rule__Versions__Group__0 ) ) )
            // InternalArg.g:417:2: ( ( rule__Versions__Group__0 ) )
            {
            // InternalArg.g:417:2: ( ( rule__Versions__Group__0 ) )
            // InternalArg.g:418:3: ( rule__Versions__Group__0 )
            {
             before(grammarAccess.getVersionsAccess().getGroup()); 
            // InternalArg.g:419:3: ( rule__Versions__Group__0 )
            // InternalArg.g:419:4: rule__Versions__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Versions__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersions"


    // $ANTLR start "entryRuleEDouble"
    // InternalArg.g:428:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalArg.g:429:1: ( ruleEDouble EOF )
            // InternalArg.g:430:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalArg.g:437:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:441:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalArg.g:442:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalArg.g:442:2: ( ( rule__EDouble__Group__0 ) )
            // InternalArg.g:443:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalArg.g:444:3: ( rule__EDouble__Group__0 )
            // InternalArg.g:444:4: rule__EDouble__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRulePhysicClass"
    // InternalArg.g:453:1: entryRulePhysicClass : rulePhysicClass EOF ;
    public final void entryRulePhysicClass() throws RecognitionException {
        try {
            // InternalArg.g:454:1: ( rulePhysicClass EOF )
            // InternalArg.g:455:1: rulePhysicClass EOF
            {
             before(grammarAccess.getPhysicClassRule()); 
            pushFollow(FOLLOW_1);
            rulePhysicClass();

            state._fsp--;

             after(grammarAccess.getPhysicClassRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicClass"


    // $ANTLR start "rulePhysicClass"
    // InternalArg.g:462:1: rulePhysicClass : ( ( rule__PhysicClass__Group__0 ) ) ;
    public final void rulePhysicClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:466:2: ( ( ( rule__PhysicClass__Group__0 ) ) )
            // InternalArg.g:467:2: ( ( rule__PhysicClass__Group__0 ) )
            {
            // InternalArg.g:467:2: ( ( rule__PhysicClass__Group__0 ) )
            // InternalArg.g:468:3: ( rule__PhysicClass__Group__0 )
            {
             before(grammarAccess.getPhysicClassAccess().getGroup()); 
            // InternalArg.g:469:3: ( rule__PhysicClass__Group__0 )
            // InternalArg.g:469:4: rule__PhysicClass__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicClass"


    // $ANTLR start "entryRulePhysicBody"
    // InternalArg.g:478:1: entryRulePhysicBody : rulePhysicBody EOF ;
    public final void entryRulePhysicBody() throws RecognitionException {
        try {
            // InternalArg.g:479:1: ( rulePhysicBody EOF )
            // InternalArg.g:480:1: rulePhysicBody EOF
            {
             before(grammarAccess.getPhysicBodyRule()); 
            pushFollow(FOLLOW_1);
            rulePhysicBody();

            state._fsp--;

             after(grammarAccess.getPhysicBodyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicBody"


    // $ANTLR start "rulePhysicBody"
    // InternalArg.g:487:1: rulePhysicBody : ( ( rule__PhysicBody__Group__0 ) ) ;
    public final void rulePhysicBody() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:491:2: ( ( ( rule__PhysicBody__Group__0 ) ) )
            // InternalArg.g:492:2: ( ( rule__PhysicBody__Group__0 ) )
            {
            // InternalArg.g:492:2: ( ( rule__PhysicBody__Group__0 ) )
            // InternalArg.g:493:3: ( rule__PhysicBody__Group__0 )
            {
             before(grammarAccess.getPhysicBodyAccess().getGroup()); 
            // InternalArg.g:494:3: ( rule__PhysicBody__Group__0 )
            // InternalArg.g:494:4: rule__PhysicBody__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicBody"


    // $ANTLR start "entryRuleBitMasks"
    // InternalArg.g:503:1: entryRuleBitMasks : ruleBitMasks EOF ;
    public final void entryRuleBitMasks() throws RecognitionException {
        try {
            // InternalArg.g:504:1: ( ruleBitMasks EOF )
            // InternalArg.g:505:1: ruleBitMasks EOF
            {
             before(grammarAccess.getBitMasksRule()); 
            pushFollow(FOLLOW_1);
            ruleBitMasks();

            state._fsp--;

             after(grammarAccess.getBitMasksRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBitMasks"


    // $ANTLR start "ruleBitMasks"
    // InternalArg.g:512:1: ruleBitMasks : ( ( rule__BitMasks__Group__0 ) ) ;
    public final void ruleBitMasks() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:516:2: ( ( ( rule__BitMasks__Group__0 ) ) )
            // InternalArg.g:517:2: ( ( rule__BitMasks__Group__0 ) )
            {
            // InternalArg.g:517:2: ( ( rule__BitMasks__Group__0 ) )
            // InternalArg.g:518:3: ( rule__BitMasks__Group__0 )
            {
             before(grammarAccess.getBitMasksAccess().getGroup()); 
            // InternalArg.g:519:3: ( rule__BitMasks__Group__0 )
            // InternalArg.g:519:4: rule__BitMasks__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBitMasksAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBitMasks"


    // $ANTLR start "entryRuleForce"
    // InternalArg.g:528:1: entryRuleForce : ruleForce EOF ;
    public final void entryRuleForce() throws RecognitionException {
        try {
            // InternalArg.g:529:1: ( ruleForce EOF )
            // InternalArg.g:530:1: ruleForce EOF
            {
             before(grammarAccess.getForceRule()); 
            pushFollow(FOLLOW_1);
            ruleForce();

            state._fsp--;

             after(grammarAccess.getForceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForce"


    // $ANTLR start "ruleForce"
    // InternalArg.g:537:1: ruleForce : ( ( rule__Force__Group__0 ) ) ;
    public final void ruleForce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:541:2: ( ( ( rule__Force__Group__0 ) ) )
            // InternalArg.g:542:2: ( ( rule__Force__Group__0 ) )
            {
            // InternalArg.g:542:2: ( ( rule__Force__Group__0 ) )
            // InternalArg.g:543:3: ( rule__Force__Group__0 )
            {
             before(grammarAccess.getForceAccess().getGroup()); 
            // InternalArg.g:544:3: ( rule__Force__Group__0 )
            // InternalArg.g:544:4: rule__Force__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Force__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForce"


    // $ANTLR start "entryRuleGamePad"
    // InternalArg.g:553:1: entryRuleGamePad : ruleGamePad EOF ;
    public final void entryRuleGamePad() throws RecognitionException {
        try {
            // InternalArg.g:554:1: ( ruleGamePad EOF )
            // InternalArg.g:555:1: ruleGamePad EOF
            {
             before(grammarAccess.getGamePadRule()); 
            pushFollow(FOLLOW_1);
            ruleGamePad();

            state._fsp--;

             after(grammarAccess.getGamePadRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGamePad"


    // $ANTLR start "ruleGamePad"
    // InternalArg.g:562:1: ruleGamePad : ( ( rule__GamePad__Group__0 ) ) ;
    public final void ruleGamePad() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:566:2: ( ( ( rule__GamePad__Group__0 ) ) )
            // InternalArg.g:567:2: ( ( rule__GamePad__Group__0 ) )
            {
            // InternalArg.g:567:2: ( ( rule__GamePad__Group__0 ) )
            // InternalArg.g:568:3: ( rule__GamePad__Group__0 )
            {
             before(grammarAccess.getGamePadAccess().getGroup()); 
            // InternalArg.g:569:3: ( rule__GamePad__Group__0 )
            // InternalArg.g:569:4: rule__GamePad__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GamePad__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGamePadAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGamePad"


    // $ANTLR start "entryRuleScoreSystem"
    // InternalArg.g:578:1: entryRuleScoreSystem : ruleScoreSystem EOF ;
    public final void entryRuleScoreSystem() throws RecognitionException {
        try {
            // InternalArg.g:579:1: ( ruleScoreSystem EOF )
            // InternalArg.g:580:1: ruleScoreSystem EOF
            {
             before(grammarAccess.getScoreSystemRule()); 
            pushFollow(FOLLOW_1);
            ruleScoreSystem();

            state._fsp--;

             after(grammarAccess.getScoreSystemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScoreSystem"


    // $ANTLR start "ruleScoreSystem"
    // InternalArg.g:587:1: ruleScoreSystem : ( ( rule__ScoreSystem__Group__0 ) ) ;
    public final void ruleScoreSystem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:591:2: ( ( ( rule__ScoreSystem__Group__0 ) ) )
            // InternalArg.g:592:2: ( ( rule__ScoreSystem__Group__0 ) )
            {
            // InternalArg.g:592:2: ( ( rule__ScoreSystem__Group__0 ) )
            // InternalArg.g:593:3: ( rule__ScoreSystem__Group__0 )
            {
             before(grammarAccess.getScoreSystemAccess().getGroup()); 
            // InternalArg.g:594:3: ( rule__ScoreSystem__Group__0 )
            // InternalArg.g:594:4: rule__ScoreSystem__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScoreSystemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScoreSystem"


    // $ANTLR start "entryRuleNoLimit"
    // InternalArg.g:603:1: entryRuleNoLimit : ruleNoLimit EOF ;
    public final void entryRuleNoLimit() throws RecognitionException {
        try {
            // InternalArg.g:604:1: ( ruleNoLimit EOF )
            // InternalArg.g:605:1: ruleNoLimit EOF
            {
             before(grammarAccess.getNoLimitRule()); 
            pushFollow(FOLLOW_1);
            ruleNoLimit();

            state._fsp--;

             after(grammarAccess.getNoLimitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNoLimit"


    // $ANTLR start "ruleNoLimit"
    // InternalArg.g:612:1: ruleNoLimit : ( ( rule__NoLimit__Alternatives ) ) ;
    public final void ruleNoLimit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:616:2: ( ( ( rule__NoLimit__Alternatives ) ) )
            // InternalArg.g:617:2: ( ( rule__NoLimit__Alternatives ) )
            {
            // InternalArg.g:617:2: ( ( rule__NoLimit__Alternatives ) )
            // InternalArg.g:618:3: ( rule__NoLimit__Alternatives )
            {
             before(grammarAccess.getNoLimitAccess().getAlternatives()); 
            // InternalArg.g:619:3: ( rule__NoLimit__Alternatives )
            // InternalArg.g:619:4: rule__NoLimit__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NoLimit__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNoLimitAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNoLimit"


    // $ANTLR start "entryRuleTrigger"
    // InternalArg.g:628:1: entryRuleTrigger : ruleTrigger EOF ;
    public final void entryRuleTrigger() throws RecognitionException {
        try {
            // InternalArg.g:629:1: ( ruleTrigger EOF )
            // InternalArg.g:630:1: ruleTrigger EOF
            {
             before(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_1);
            ruleTrigger();

            state._fsp--;

             after(grammarAccess.getTriggerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // InternalArg.g:637:1: ruleTrigger : ( ( rule__Trigger__Group__0 ) ) ;
    public final void ruleTrigger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:641:2: ( ( ( rule__Trigger__Group__0 ) ) )
            // InternalArg.g:642:2: ( ( rule__Trigger__Group__0 ) )
            {
            // InternalArg.g:642:2: ( ( rule__Trigger__Group__0 ) )
            // InternalArg.g:643:3: ( rule__Trigger__Group__0 )
            {
             before(grammarAccess.getTriggerAccess().getGroup()); 
            // InternalArg.g:644:3: ( rule__Trigger__Group__0 )
            // InternalArg.g:644:4: rule__Trigger__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleCollision"
    // InternalArg.g:653:1: entryRuleCollision : ruleCollision EOF ;
    public final void entryRuleCollision() throws RecognitionException {
        try {
            // InternalArg.g:654:1: ( ruleCollision EOF )
            // InternalArg.g:655:1: ruleCollision EOF
            {
             before(grammarAccess.getCollisionRule()); 
            pushFollow(FOLLOW_1);
            ruleCollision();

            state._fsp--;

             after(grammarAccess.getCollisionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollision"


    // $ANTLR start "ruleCollision"
    // InternalArg.g:662:1: ruleCollision : ( ( rule__Collision__Group__0 ) ) ;
    public final void ruleCollision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:666:2: ( ( ( rule__Collision__Group__0 ) ) )
            // InternalArg.g:667:2: ( ( rule__Collision__Group__0 ) )
            {
            // InternalArg.g:667:2: ( ( rule__Collision__Group__0 ) )
            // InternalArg.g:668:3: ( rule__Collision__Group__0 )
            {
             before(grammarAccess.getCollisionAccess().getGroup()); 
            // InternalArg.g:669:3: ( rule__Collision__Group__0 )
            // InternalArg.g:669:4: rule__Collision__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Collision__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollisionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollision"


    // $ANTLR start "entryRuleObjInit"
    // InternalArg.g:678:1: entryRuleObjInit : ruleObjInit EOF ;
    public final void entryRuleObjInit() throws RecognitionException {
        try {
            // InternalArg.g:679:1: ( ruleObjInit EOF )
            // InternalArg.g:680:1: ruleObjInit EOF
            {
             before(grammarAccess.getObjInitRule()); 
            pushFollow(FOLLOW_1);
            ruleObjInit();

            state._fsp--;

             after(grammarAccess.getObjInitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjInit"


    // $ANTLR start "ruleObjInit"
    // InternalArg.g:687:1: ruleObjInit : ( ( rule__ObjInit__Group__0 ) ) ;
    public final void ruleObjInit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:691:2: ( ( ( rule__ObjInit__Group__0 ) ) )
            // InternalArg.g:692:2: ( ( rule__ObjInit__Group__0 ) )
            {
            // InternalArg.g:692:2: ( ( rule__ObjInit__Group__0 ) )
            // InternalArg.g:693:3: ( rule__ObjInit__Group__0 )
            {
             before(grammarAccess.getObjInitAccess().getGroup()); 
            // InternalArg.g:694:3: ( rule__ObjInit__Group__0 )
            // InternalArg.g:694:4: rule__ObjInit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjInit"


    // $ANTLR start "entryRulePosOrCamera"
    // InternalArg.g:703:1: entryRulePosOrCamera : rulePosOrCamera EOF ;
    public final void entryRulePosOrCamera() throws RecognitionException {
        try {
            // InternalArg.g:704:1: ( rulePosOrCamera EOF )
            // InternalArg.g:705:1: rulePosOrCamera EOF
            {
             before(grammarAccess.getPosOrCameraRule()); 
            pushFollow(FOLLOW_1);
            rulePosOrCamera();

            state._fsp--;

             after(grammarAccess.getPosOrCameraRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePosOrCamera"


    // $ANTLR start "rulePosOrCamera"
    // InternalArg.g:712:1: rulePosOrCamera : ( ( rule__PosOrCamera__Alternatives ) ) ;
    public final void rulePosOrCamera() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:716:2: ( ( ( rule__PosOrCamera__Alternatives ) ) )
            // InternalArg.g:717:2: ( ( rule__PosOrCamera__Alternatives ) )
            {
            // InternalArg.g:717:2: ( ( rule__PosOrCamera__Alternatives ) )
            // InternalArg.g:718:3: ( rule__PosOrCamera__Alternatives )
            {
             before(grammarAccess.getPosOrCameraAccess().getAlternatives()); 
            // InternalArg.g:719:3: ( rule__PosOrCamera__Alternatives )
            // InternalArg.g:719:4: rule__PosOrCamera__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PosOrCamera__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPosOrCameraAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePosOrCamera"


    // $ANTLR start "entryRulePhysicChange"
    // InternalArg.g:728:1: entryRulePhysicChange : rulePhysicChange EOF ;
    public final void entryRulePhysicChange() throws RecognitionException {
        try {
            // InternalArg.g:729:1: ( rulePhysicChange EOF )
            // InternalArg.g:730:1: rulePhysicChange EOF
            {
             before(grammarAccess.getPhysicChangeRule()); 
            pushFollow(FOLLOW_1);
            rulePhysicChange();

            state._fsp--;

             after(grammarAccess.getPhysicChangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicChange"


    // $ANTLR start "rulePhysicChange"
    // InternalArg.g:737:1: rulePhysicChange : ( ( rule__PhysicChange__Group__0 ) ) ;
    public final void rulePhysicChange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:741:2: ( ( ( rule__PhysicChange__Group__0 ) ) )
            // InternalArg.g:742:2: ( ( rule__PhysicChange__Group__0 ) )
            {
            // InternalArg.g:742:2: ( ( rule__PhysicChange__Group__0 ) )
            // InternalArg.g:743:3: ( rule__PhysicChange__Group__0 )
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup()); 
            // InternalArg.g:744:3: ( rule__PhysicChange__Group__0 )
            // InternalArg.g:744:4: rule__PhysicChange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicChange"


    // $ANTLR start "entryRuleObjAttribute"
    // InternalArg.g:753:1: entryRuleObjAttribute : ruleObjAttribute EOF ;
    public final void entryRuleObjAttribute() throws RecognitionException {
        try {
            // InternalArg.g:754:1: ( ruleObjAttribute EOF )
            // InternalArg.g:755:1: ruleObjAttribute EOF
            {
             before(grammarAccess.getObjAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleObjAttribute();

            state._fsp--;

             after(grammarAccess.getObjAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjAttribute"


    // $ANTLR start "ruleObjAttribute"
    // InternalArg.g:762:1: ruleObjAttribute : ( ( rule__ObjAttribute__Group__0 ) ) ;
    public final void ruleObjAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:766:2: ( ( ( rule__ObjAttribute__Group__0 ) ) )
            // InternalArg.g:767:2: ( ( rule__ObjAttribute__Group__0 ) )
            {
            // InternalArg.g:767:2: ( ( rule__ObjAttribute__Group__0 ) )
            // InternalArg.g:768:3: ( rule__ObjAttribute__Group__0 )
            {
             before(grammarAccess.getObjAttributeAccess().getGroup()); 
            // InternalArg.g:769:3: ( rule__ObjAttribute__Group__0 )
            // InternalArg.g:769:4: rule__ObjAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ObjAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjAttribute"


    // $ANTLR start "entryRuleRule"
    // InternalArg.g:778:1: entryRuleRule : ruleRule EOF ;
    public final void entryRuleRule() throws RecognitionException {
        try {
            // InternalArg.g:779:1: ( ruleRule EOF )
            // InternalArg.g:780:1: ruleRule EOF
            {
             before(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalArg.g:787:1: ruleRule : ( ( rule__Rule__Group__0 ) ) ;
    public final void ruleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:791:2: ( ( ( rule__Rule__Group__0 ) ) )
            // InternalArg.g:792:2: ( ( rule__Rule__Group__0 ) )
            {
            // InternalArg.g:792:2: ( ( rule__Rule__Group__0 ) )
            // InternalArg.g:793:3: ( rule__Rule__Group__0 )
            {
             before(grammarAccess.getRuleAccess().getGroup()); 
            // InternalArg.g:794:3: ( rule__Rule__Group__0 )
            // InternalArg.g:794:4: rule__Rule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleNot"
    // InternalArg.g:803:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalArg.g:804:1: ( ruleNot EOF )
            // InternalArg.g:805:1: ruleNot EOF
            {
             before(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getNotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalArg.g:812:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:816:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalArg.g:817:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalArg.g:817:2: ( ( rule__Not__Group__0 ) )
            // InternalArg.g:818:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalArg.g:819:3: ( rule__Not__Group__0 )
            // InternalArg.g:819:4: rule__Not__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleBinary"
    // InternalArg.g:828:1: entryRuleBinary : ruleBinary EOF ;
    public final void entryRuleBinary() throws RecognitionException {
        try {
            // InternalArg.g:829:1: ( ruleBinary EOF )
            // InternalArg.g:830:1: ruleBinary EOF
            {
             before(grammarAccess.getBinaryRule()); 
            pushFollow(FOLLOW_1);
            ruleBinary();

            state._fsp--;

             after(grammarAccess.getBinaryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinary"


    // $ANTLR start "ruleBinary"
    // InternalArg.g:837:1: ruleBinary : ( ( rule__Binary__Group__0 ) ) ;
    public final void ruleBinary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:841:2: ( ( ( rule__Binary__Group__0 ) ) )
            // InternalArg.g:842:2: ( ( rule__Binary__Group__0 ) )
            {
            // InternalArg.g:842:2: ( ( rule__Binary__Group__0 ) )
            // InternalArg.g:843:3: ( rule__Binary__Group__0 )
            {
             before(grammarAccess.getBinaryAccess().getGroup()); 
            // InternalArg.g:844:3: ( rule__Binary__Group__0 )
            // InternalArg.g:844:4: rule__Binary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Binary__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinary"


    // $ANTLR start "entryRuleArithmetic"
    // InternalArg.g:853:1: entryRuleArithmetic : ruleArithmetic EOF ;
    public final void entryRuleArithmetic() throws RecognitionException {
        try {
            // InternalArg.g:854:1: ( ruleArithmetic EOF )
            // InternalArg.g:855:1: ruleArithmetic EOF
            {
             before(grammarAccess.getArithmeticRule()); 
            pushFollow(FOLLOW_1);
            ruleArithmetic();

            state._fsp--;

             after(grammarAccess.getArithmeticRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArithmetic"


    // $ANTLR start "ruleArithmetic"
    // InternalArg.g:862:1: ruleArithmetic : ( ( rule__Arithmetic__Group__0 ) ) ;
    public final void ruleArithmetic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:866:2: ( ( ( rule__Arithmetic__Group__0 ) ) )
            // InternalArg.g:867:2: ( ( rule__Arithmetic__Group__0 ) )
            {
            // InternalArg.g:867:2: ( ( rule__Arithmetic__Group__0 ) )
            // InternalArg.g:868:3: ( rule__Arithmetic__Group__0 )
            {
             before(grammarAccess.getArithmeticAccess().getGroup()); 
            // InternalArg.g:869:3: ( rule__Arithmetic__Group__0 )
            // InternalArg.g:869:4: rule__Arithmetic__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Arithmetic__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArithmetic"


    // $ANTLR start "entryRuleAttributeValue"
    // InternalArg.g:878:1: entryRuleAttributeValue : ruleAttributeValue EOF ;
    public final void entryRuleAttributeValue() throws RecognitionException {
        try {
            // InternalArg.g:879:1: ( ruleAttributeValue EOF )
            // InternalArg.g:880:1: ruleAttributeValue EOF
            {
             before(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeValue();

            state._fsp--;

             after(grammarAccess.getAttributeValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // InternalArg.g:887:1: ruleAttributeValue : ( ( rule__AttributeValue__Group__0 ) ) ;
    public final void ruleAttributeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:891:2: ( ( ( rule__AttributeValue__Group__0 ) ) )
            // InternalArg.g:892:2: ( ( rule__AttributeValue__Group__0 ) )
            {
            // InternalArg.g:892:2: ( ( rule__AttributeValue__Group__0 ) )
            // InternalArg.g:893:3: ( rule__AttributeValue__Group__0 )
            {
             before(grammarAccess.getAttributeValueAccess().getGroup()); 
            // InternalArg.g:894:3: ( rule__AttributeValue__Group__0 )
            // InternalArg.g:894:4: rule__AttributeValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleConstantValue"
    // InternalArg.g:903:1: entryRuleConstantValue : ruleConstantValue EOF ;
    public final void entryRuleConstantValue() throws RecognitionException {
        try {
            // InternalArg.g:904:1: ( ruleConstantValue EOF )
            // InternalArg.g:905:1: ruleConstantValue EOF
            {
             before(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_1);
            ruleConstantValue();

            state._fsp--;

             after(grammarAccess.getConstantValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalArg.g:912:1: ruleConstantValue : ( ( rule__ConstantValue__ValueAssignment ) ) ;
    public final void ruleConstantValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:916:2: ( ( ( rule__ConstantValue__ValueAssignment ) ) )
            // InternalArg.g:917:2: ( ( rule__ConstantValue__ValueAssignment ) )
            {
            // InternalArg.g:917:2: ( ( rule__ConstantValue__ValueAssignment ) )
            // InternalArg.g:918:3: ( rule__ConstantValue__ValueAssignment )
            {
             before(grammarAccess.getConstantValueAccess().getValueAssignment()); 
            // InternalArg.g:919:3: ( rule__ConstantValue__ValueAssignment )
            // InternalArg.g:919:4: rule__ConstantValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ConstantValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getConstantValueAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleConstant"
    // InternalArg.g:928:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalArg.g:929:1: ( ruleConstant EOF )
            // InternalArg.g:930:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalArg.g:937:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:941:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalArg.g:942:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalArg.g:942:2: ( ( rule__Constant__Alternatives ) )
            // InternalArg.g:943:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalArg.g:944:3: ( rule__Constant__Alternatives )
            // InternalArg.g:944:4: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleAllInstances"
    // InternalArg.g:953:1: entryRuleAllInstances : ruleAllInstances EOF ;
    public final void entryRuleAllInstances() throws RecognitionException {
        try {
            // InternalArg.g:954:1: ( ruleAllInstances EOF )
            // InternalArg.g:955:1: ruleAllInstances EOF
            {
             before(grammarAccess.getAllInstancesRule()); 
            pushFollow(FOLLOW_1);
            ruleAllInstances();

            state._fsp--;

             after(grammarAccess.getAllInstancesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAllInstances"


    // $ANTLR start "ruleAllInstances"
    // InternalArg.g:962:1: ruleAllInstances : ( ( rule__AllInstances__Group__0 ) ) ;
    public final void ruleAllInstances() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:966:2: ( ( ( rule__AllInstances__Group__0 ) ) )
            // InternalArg.g:967:2: ( ( rule__AllInstances__Group__0 ) )
            {
            // InternalArg.g:967:2: ( ( rule__AllInstances__Group__0 ) )
            // InternalArg.g:968:3: ( rule__AllInstances__Group__0 )
            {
             before(grammarAccess.getAllInstancesAccess().getGroup()); 
            // InternalArg.g:969:3: ( rule__AllInstances__Group__0 )
            // InternalArg.g:969:4: rule__AllInstances__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AllInstances__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAllInstancesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAllInstances"


    // $ANTLR start "ruleGesture"
    // InternalArg.g:978:1: ruleGesture : ( ( rule__Gesture__Alternatives ) ) ;
    public final void ruleGesture() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:982:1: ( ( ( rule__Gesture__Alternatives ) ) )
            // InternalArg.g:983:2: ( ( rule__Gesture__Alternatives ) )
            {
            // InternalArg.g:983:2: ( ( rule__Gesture__Alternatives ) )
            // InternalArg.g:984:3: ( rule__Gesture__Alternatives )
            {
             before(grammarAccess.getGestureAccess().getAlternatives()); 
            // InternalArg.g:985:3: ( rule__Gesture__Alternatives )
            // InternalArg.g:985:4: rule__Gesture__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Gesture__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGestureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGesture"


    // $ANTLR start "rulePlanes"
    // InternalArg.g:994:1: rulePlanes : ( ( rule__Planes__Alternatives ) ) ;
    public final void rulePlanes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:998:1: ( ( ( rule__Planes__Alternatives ) ) )
            // InternalArg.g:999:2: ( ( rule__Planes__Alternatives ) )
            {
            // InternalArg.g:999:2: ( ( rule__Planes__Alternatives ) )
            // InternalArg.g:1000:3: ( rule__Planes__Alternatives )
            {
             before(grammarAccess.getPlanesAccess().getAlternatives()); 
            // InternalArg.g:1001:3: ( rule__Planes__Alternatives )
            // InternalArg.g:1001:4: rule__Planes__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Planes__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPlanesAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlanes"


    // $ANTLR start "ruleBodyType"
    // InternalArg.g:1010:1: ruleBodyType : ( ( rule__BodyType__Alternatives ) ) ;
    public final void ruleBodyType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1014:1: ( ( ( rule__BodyType__Alternatives ) ) )
            // InternalArg.g:1015:2: ( ( rule__BodyType__Alternatives ) )
            {
            // InternalArg.g:1015:2: ( ( rule__BodyType__Alternatives ) )
            // InternalArg.g:1016:3: ( rule__BodyType__Alternatives )
            {
             before(grammarAccess.getBodyTypeAccess().getAlternatives()); 
            // InternalArg.g:1017:3: ( rule__BodyType__Alternatives )
            // InternalArg.g:1017:4: rule__BodyType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BodyType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBodyTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBodyType"


    // $ANTLR start "ruleBasicActions"
    // InternalArg.g:1026:1: ruleBasicActions : ( ( rule__BasicActions__Alternatives ) ) ;
    public final void ruleBasicActions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1030:1: ( ( ( rule__BasicActions__Alternatives ) ) )
            // InternalArg.g:1031:2: ( ( rule__BasicActions__Alternatives ) )
            {
            // InternalArg.g:1031:2: ( ( rule__BasicActions__Alternatives ) )
            // InternalArg.g:1032:3: ( rule__BasicActions__Alternatives )
            {
             before(grammarAccess.getBasicActionsAccess().getAlternatives()); 
            // InternalArg.g:1033:3: ( rule__BasicActions__Alternatives )
            // InternalArg.g:1033:4: rule__BasicActions__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BasicActions__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBasicActionsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBasicActions"


    // $ANTLR start "ruleAction"
    // InternalArg.g:1042:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1046:1: ( ( ( rule__Action__Alternatives ) ) )
            // InternalArg.g:1047:2: ( ( rule__Action__Alternatives ) )
            {
            // InternalArg.g:1047:2: ( ( rule__Action__Alternatives ) )
            // InternalArg.g:1048:3: ( rule__Action__Alternatives )
            {
             before(grammarAccess.getActionAccess().getAlternatives()); 
            // InternalArg.g:1049:3: ( rule__Action__Alternatives )
            // InternalArg.g:1049:4: rule__Action__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Action__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "rulePosition"
    // InternalArg.g:1058:1: rulePosition : ( ( rule__Position__Alternatives ) ) ;
    public final void rulePosition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1062:1: ( ( ( rule__Position__Alternatives ) ) )
            // InternalArg.g:1063:2: ( ( rule__Position__Alternatives ) )
            {
            // InternalArg.g:1063:2: ( ( rule__Position__Alternatives ) )
            // InternalArg.g:1064:3: ( rule__Position__Alternatives )
            {
             before(grammarAccess.getPositionAccess().getAlternatives()); 
            // InternalArg.g:1065:3: ( rule__Position__Alternatives )
            // InternalArg.g:1065:4: rule__Position__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Position__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPositionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "ruleLogicOps"
    // InternalArg.g:1074:1: ruleLogicOps : ( ( rule__LogicOps__Alternatives ) ) ;
    public final void ruleLogicOps() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1078:1: ( ( ( rule__LogicOps__Alternatives ) ) )
            // InternalArg.g:1079:2: ( ( rule__LogicOps__Alternatives ) )
            {
            // InternalArg.g:1079:2: ( ( rule__LogicOps__Alternatives ) )
            // InternalArg.g:1080:3: ( rule__LogicOps__Alternatives )
            {
             before(grammarAccess.getLogicOpsAccess().getAlternatives()); 
            // InternalArg.g:1081:3: ( rule__LogicOps__Alternatives )
            // InternalArg.g:1081:4: rule__LogicOps__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LogicOps__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLogicOpsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicOps"


    // $ANTLR start "ruleArithmOps"
    // InternalArg.g:1090:1: ruleArithmOps : ( ( rule__ArithmOps__Alternatives ) ) ;
    public final void ruleArithmOps() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1094:1: ( ( ( rule__ArithmOps__Alternatives ) ) )
            // InternalArg.g:1095:2: ( ( rule__ArithmOps__Alternatives ) )
            {
            // InternalArg.g:1095:2: ( ( rule__ArithmOps__Alternatives ) )
            // InternalArg.g:1096:3: ( rule__ArithmOps__Alternatives )
            {
             before(grammarAccess.getArithmOpsAccess().getAlternatives()); 
            // InternalArg.g:1097:3: ( rule__ArithmOps__Alternatives )
            // InternalArg.g:1097:4: rule__ArithmOps__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ArithmOps__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getArithmOpsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArithmOps"


    // $ANTLR start "rule__Condition__Alternatives"
    // InternalArg.g:1105:1: rule__Condition__Alternatives : ( ( ruleNot ) | ( ruleBinary ) | ( ruleArithmetic ) );
    public final void rule__Condition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1109:1: ( ( ruleNot ) | ( ruleBinary ) | ( ruleArithmetic ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt1=1;
                }
                break;
            case 114:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 65:
            case 115:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalArg.g:1110:2: ( ruleNot )
                    {
                    // InternalArg.g:1110:2: ( ruleNot )
                    // InternalArg.g:1111:3: ruleNot
                    {
                     before(grammarAccess.getConditionAccess().getNotParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNot();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getNotParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1116:2: ( ruleBinary )
                    {
                    // InternalArg.g:1116:2: ( ruleBinary )
                    // InternalArg.g:1117:3: ruleBinary
                    {
                     before(grammarAccess.getConditionAccess().getBinaryParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBinary();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getBinaryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1122:2: ( ruleArithmetic )
                    {
                    // InternalArg.g:1122:2: ( ruleArithmetic )
                    // InternalArg.g:1123:3: ruleArithmetic
                    {
                     before(grammarAccess.getConditionAccess().getArithmeticParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleArithmetic();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getArithmeticParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Alternatives"


    // $ANTLR start "rule__Value__Alternatives"
    // InternalArg.g:1132:1: rule__Value__Alternatives : ( ( ruleAttributeValue ) | ( ruleConstantValue ) | ( ruleAllInstances ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1136:1: ( ( ruleAttributeValue ) | ( ruleConstantValue ) | ( ruleAllInstances ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==76) ) {
                    alt2=1;
                }
                else if ( (LA2_1==EOF||(LA2_1>=37 && LA2_1<=41)||LA2_1==112) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==76) ) {
                    alt2=1;
                }
                else if ( (LA2_2==EOF||(LA2_2>=37 && LA2_2<=41)||LA2_2==112) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case 65:
                {
                alt2=2;
                }
                break;
            case 115:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalArg.g:1137:2: ( ruleAttributeValue )
                    {
                    // InternalArg.g:1137:2: ( ruleAttributeValue )
                    // InternalArg.g:1138:3: ruleAttributeValue
                    {
                     before(grammarAccess.getValueAccess().getAttributeValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAttributeValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getAttributeValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1143:2: ( ruleConstantValue )
                    {
                    // InternalArg.g:1143:2: ( ruleConstantValue )
                    // InternalArg.g:1144:3: ruleConstantValue
                    {
                     before(grammarAccess.getValueAccess().getConstantValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleConstantValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getConstantValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1149:2: ( ruleAllInstances )
                    {
                    // InternalArg.g:1149:2: ( ruleAllInstances )
                    // InternalArg.g:1150:3: ruleAllInstances
                    {
                     before(grammarAccess.getValueAccess().getAllInstancesParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleAllInstances();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getAllInstancesParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalArg.g:1159:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1163:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalArg.g:1164:2: ( RULE_STRING )
                    {
                    // InternalArg.g:1164:2: ( RULE_STRING )
                    // InternalArg.g:1165:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1170:2: ( RULE_ID )
                    {
                    // InternalArg.g:1170:2: ( RULE_ID )
                    // InternalArg.g:1171:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__AttributeMax__Alternatives"
    // InternalArg.g:1180:1: rule__AttributeMax__Alternatives : ( ( '*' ) | ( RULE_INT ) );
    public final void rule__AttributeMax__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1184:1: ( ( '*' ) | ( RULE_INT ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalArg.g:1185:2: ( '*' )
                    {
                    // InternalArg.g:1185:2: ( '*' )
                    // InternalArg.g:1186:3: '*'
                    {
                     before(grammarAccess.getAttributeMaxAccess().getAsteriskKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getAttributeMaxAccess().getAsteriskKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1191:2: ( RULE_INT )
                    {
                    // InternalArg.g:1191:2: ( RULE_INT )
                    // InternalArg.g:1192:3: RULE_INT
                    {
                     before(grammarAccess.getAttributeMaxAccess().getINTTerminalRuleCall_1()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getAttributeMaxAccess().getINTTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeMax__Alternatives"


    // $ANTLR start "rule__EDouble__Alternatives_4_0"
    // InternalArg.g:1201:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1205:1: ( ( 'E' ) | ( 'e' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalArg.g:1206:2: ( 'E' )
                    {
                    // InternalArg.g:1206:2: ( 'E' )
                    // InternalArg.g:1207:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1212:2: ( 'e' )
                    {
                    // InternalArg.g:1212:2: ( 'e' )
                    // InternalArg.g:1213:3: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Alternatives_4_0"


    // $ANTLR start "rule__NoLimit__Alternatives"
    // InternalArg.g:1222:1: rule__NoLimit__Alternatives : ( ( '*' ) | ( RULE_INT ) );
    public final void rule__NoLimit__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1226:1: ( ( '*' ) | ( RULE_INT ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_INT) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalArg.g:1227:2: ( '*' )
                    {
                    // InternalArg.g:1227:2: ( '*' )
                    // InternalArg.g:1228:3: '*'
                    {
                     before(grammarAccess.getNoLimitAccess().getAsteriskKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getNoLimitAccess().getAsteriskKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1233:2: ( RULE_INT )
                    {
                    // InternalArg.g:1233:2: ( RULE_INT )
                    // InternalArg.g:1234:3: RULE_INT
                    {
                     before(grammarAccess.getNoLimitAccess().getINTTerminalRuleCall_1()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getNoLimitAccess().getINTTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NoLimit__Alternatives"


    // $ANTLR start "rule__PosOrCamera__Alternatives"
    // InternalArg.g:1243:1: rule__PosOrCamera__Alternatives : ( ( 'camera' ) | ( ruleEDouble ) );
    public final void rule__PosOrCamera__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1247:1: ( ( 'camera' ) | ( ruleEDouble ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT||LA7_0==65||LA7_0==76) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalArg.g:1248:2: ( 'camera' )
                    {
                    // InternalArg.g:1248:2: ( 'camera' )
                    // InternalArg.g:1249:3: 'camera'
                    {
                     before(grammarAccess.getPosOrCameraAccess().getCameraKeyword_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPosOrCameraAccess().getCameraKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1254:2: ( ruleEDouble )
                    {
                    // InternalArg.g:1254:2: ( ruleEDouble )
                    // InternalArg.g:1255:3: ruleEDouble
                    {
                     before(grammarAccess.getPosOrCameraAccess().getEDoubleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEDouble();

                    state._fsp--;

                     after(grammarAccess.getPosOrCameraAccess().getEDoubleParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PosOrCamera__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // InternalArg.g:1264:1: rule__Constant__Alternatives : ( ( ruleEInt ) | ( ruleEString ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1268:1: ( ( ruleEInt ) | ( ruleEString ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||LA8_0==65) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalArg.g:1269:2: ( ruleEInt )
                    {
                    // InternalArg.g:1269:2: ( ruleEInt )
                    // InternalArg.g:1270:3: ruleEInt
                    {
                     before(grammarAccess.getConstantAccess().getEIntParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEInt();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getEIntParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1275:2: ( ruleEString )
                    {
                    // InternalArg.g:1275:2: ( ruleEString )
                    // InternalArg.g:1276:3: ruleEString
                    {
                     before(grammarAccess.getConstantAccess().getEStringParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getEStringParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Alternatives"


    // $ANTLR start "rule__Gesture__Alternatives"
    // InternalArg.g:1285:1: rule__Gesture__Alternatives : ( ( ( 'drag' ) ) | ( ( 'tilt' ) ) | ( ( 'touch' ) ) );
    public final void rule__Gesture__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1289:1: ( ( ( 'drag' ) ) | ( ( 'tilt' ) ) | ( ( 'touch' ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                alt9=2;
                }
                break;
            case 17:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalArg.g:1290:2: ( ( 'drag' ) )
                    {
                    // InternalArg.g:1290:2: ( ( 'drag' ) )
                    // InternalArg.g:1291:3: ( 'drag' )
                    {
                     before(grammarAccess.getGestureAccess().getDragEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1292:3: ( 'drag' )
                    // InternalArg.g:1292:4: 'drag'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getGestureAccess().getDragEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1296:2: ( ( 'tilt' ) )
                    {
                    // InternalArg.g:1296:2: ( ( 'tilt' ) )
                    // InternalArg.g:1297:3: ( 'tilt' )
                    {
                     before(grammarAccess.getGestureAccess().getTiltEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1298:3: ( 'tilt' )
                    // InternalArg.g:1298:4: 'tilt'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getGestureAccess().getTiltEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1302:2: ( ( 'touch' ) )
                    {
                    // InternalArg.g:1302:2: ( ( 'touch' ) )
                    // InternalArg.g:1303:3: ( 'touch' )
                    {
                     before(grammarAccess.getGestureAccess().getTouchEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1304:3: ( 'touch' )
                    // InternalArg.g:1304:4: 'touch'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getGestureAccess().getTouchEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Gesture__Alternatives"


    // $ANTLR start "rule__Planes__Alternatives"
    // InternalArg.g:1312:1: rule__Planes__Alternatives : ( ( ( 'any' ) ) | ( ( 'horizontal' ) ) | ( ( 'vertical' ) ) );
    public final void rule__Planes__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1316:1: ( ( ( 'any' ) ) | ( ( 'horizontal' ) ) | ( ( 'vertical' ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt10=1;
                }
                break;
            case 19:
                {
                alt10=2;
                }
                break;
            case 20:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalArg.g:1317:2: ( ( 'any' ) )
                    {
                    // InternalArg.g:1317:2: ( ( 'any' ) )
                    // InternalArg.g:1318:3: ( 'any' )
                    {
                     before(grammarAccess.getPlanesAccess().getAnyEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1319:3: ( 'any' )
                    // InternalArg.g:1319:4: 'any'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getPlanesAccess().getAnyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1323:2: ( ( 'horizontal' ) )
                    {
                    // InternalArg.g:1323:2: ( ( 'horizontal' ) )
                    // InternalArg.g:1324:3: ( 'horizontal' )
                    {
                     before(grammarAccess.getPlanesAccess().getHorizontalEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1325:3: ( 'horizontal' )
                    // InternalArg.g:1325:4: 'horizontal'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getPlanesAccess().getHorizontalEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1329:2: ( ( 'vertical' ) )
                    {
                    // InternalArg.g:1329:2: ( ( 'vertical' ) )
                    // InternalArg.g:1330:3: ( 'vertical' )
                    {
                     before(grammarAccess.getPlanesAccess().getVerticalEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1331:3: ( 'vertical' )
                    // InternalArg.g:1331:4: 'vertical'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getPlanesAccess().getVerticalEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Planes__Alternatives"


    // $ANTLR start "rule__BodyType__Alternatives"
    // InternalArg.g:1339:1: rule__BodyType__Alternatives : ( ( ( 'static' ) ) | ( ( 'dynamic' ) ) | ( ( 'kinematic' ) ) );
    public final void rule__BodyType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1343:1: ( ( ( 'static' ) ) | ( ( 'dynamic' ) ) | ( ( 'kinematic' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt11=1;
                }
                break;
            case 22:
                {
                alt11=2;
                }
                break;
            case 23:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalArg.g:1344:2: ( ( 'static' ) )
                    {
                    // InternalArg.g:1344:2: ( ( 'static' ) )
                    // InternalArg.g:1345:3: ( 'static' )
                    {
                     before(grammarAccess.getBodyTypeAccess().getStaticEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1346:3: ( 'static' )
                    // InternalArg.g:1346:4: 'static'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getBodyTypeAccess().getStaticEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1350:2: ( ( 'dynamic' ) )
                    {
                    // InternalArg.g:1350:2: ( ( 'dynamic' ) )
                    // InternalArg.g:1351:3: ( 'dynamic' )
                    {
                     before(grammarAccess.getBodyTypeAccess().getDynamicEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1352:3: ( 'dynamic' )
                    // InternalArg.g:1352:4: 'dynamic'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getBodyTypeAccess().getDynamicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1356:2: ( ( 'kinematic' ) )
                    {
                    // InternalArg.g:1356:2: ( ( 'kinematic' ) )
                    // InternalArg.g:1357:3: ( 'kinematic' )
                    {
                     before(grammarAccess.getBodyTypeAccess().getKinematicEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1358:3: ( 'kinematic' )
                    // InternalArg.g:1358:4: 'kinematic'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getBodyTypeAccess().getKinematicEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BodyType__Alternatives"


    // $ANTLR start "rule__BasicActions__Alternatives"
    // InternalArg.g:1366:1: rule__BasicActions__Alternatives : ( ( ( 'start' ) ) | ( ( 'win' ) ) | ( ( 'lose' ) ) | ( ( 'none' ) ) | ( ( 'restart' ) ) );
    public final void rule__BasicActions__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1370:1: ( ( ( 'start' ) ) | ( ( 'win' ) ) | ( ( 'lose' ) ) | ( ( 'none' ) ) | ( ( 'restart' ) ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt12=1;
                }
                break;
            case 25:
                {
                alt12=2;
                }
                break;
            case 26:
                {
                alt12=3;
                }
                break;
            case 27:
                {
                alt12=4;
                }
                break;
            case 28:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalArg.g:1371:2: ( ( 'start' ) )
                    {
                    // InternalArg.g:1371:2: ( ( 'start' ) )
                    // InternalArg.g:1372:3: ( 'start' )
                    {
                     before(grammarAccess.getBasicActionsAccess().getStartEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1373:3: ( 'start' )
                    // InternalArg.g:1373:4: 'start'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getBasicActionsAccess().getStartEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1377:2: ( ( 'win' ) )
                    {
                    // InternalArg.g:1377:2: ( ( 'win' ) )
                    // InternalArg.g:1378:3: ( 'win' )
                    {
                     before(grammarAccess.getBasicActionsAccess().getWinEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1379:3: ( 'win' )
                    // InternalArg.g:1379:4: 'win'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getBasicActionsAccess().getWinEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1383:2: ( ( 'lose' ) )
                    {
                    // InternalArg.g:1383:2: ( ( 'lose' ) )
                    // InternalArg.g:1384:3: ( 'lose' )
                    {
                     before(grammarAccess.getBasicActionsAccess().getLoseEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1385:3: ( 'lose' )
                    // InternalArg.g:1385:4: 'lose'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getBasicActionsAccess().getLoseEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalArg.g:1389:2: ( ( 'none' ) )
                    {
                    // InternalArg.g:1389:2: ( ( 'none' ) )
                    // InternalArg.g:1390:3: ( 'none' )
                    {
                     before(grammarAccess.getBasicActionsAccess().getNoneEnumLiteralDeclaration_3()); 
                    // InternalArg.g:1391:3: ( 'none' )
                    // InternalArg.g:1391:4: 'none'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getBasicActionsAccess().getNoneEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalArg.g:1395:2: ( ( 'restart' ) )
                    {
                    // InternalArg.g:1395:2: ( ( 'restart' ) )
                    // InternalArg.g:1396:3: ( 'restart' )
                    {
                     before(grammarAccess.getBasicActionsAccess().getRestartEnumLiteralDeclaration_4()); 
                    // InternalArg.g:1397:3: ( 'restart' )
                    // InternalArg.g:1397:4: 'restart'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getBasicActionsAccess().getRestartEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicActions__Alternatives"


    // $ANTLR start "rule__Action__Alternatives"
    // InternalArg.g:1405:1: rule__Action__Alternatives : ( ( ( 'create' ) ) | ( ( 'edit' ) ) | ( ( 'delete' ) ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1409:1: ( ( ( 'create' ) ) | ( ( 'edit' ) ) | ( ( 'delete' ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt13=1;
                }
                break;
            case 30:
                {
                alt13=2;
                }
                break;
            case 31:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalArg.g:1410:2: ( ( 'create' ) )
                    {
                    // InternalArg.g:1410:2: ( ( 'create' ) )
                    // InternalArg.g:1411:3: ( 'create' )
                    {
                     before(grammarAccess.getActionAccess().getCreateEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1412:3: ( 'create' )
                    // InternalArg.g:1412:4: 'create'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionAccess().getCreateEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1416:2: ( ( 'edit' ) )
                    {
                    // InternalArg.g:1416:2: ( ( 'edit' ) )
                    // InternalArg.g:1417:3: ( 'edit' )
                    {
                     before(grammarAccess.getActionAccess().getEditEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1418:3: ( 'edit' )
                    // InternalArg.g:1418:4: 'edit'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionAccess().getEditEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1422:2: ( ( 'delete' ) )
                    {
                    // InternalArg.g:1422:2: ( ( 'delete' ) )
                    // InternalArg.g:1423:3: ( 'delete' )
                    {
                     before(grammarAccess.getActionAccess().getDeleteEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1424:3: ( 'delete' )
                    // InternalArg.g:1424:4: 'delete'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionAccess().getDeleteEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Alternatives"


    // $ANTLR start "rule__Position__Alternatives"
    // InternalArg.g:1432:1: rule__Position__Alternatives : ( ( ( 'front' ) ) | ( ( 'default' ) ) | ( ( 'back' ) ) );
    public final void rule__Position__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1436:1: ( ( ( 'front' ) ) | ( ( 'default' ) ) | ( ( 'back' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case 34:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalArg.g:1437:2: ( ( 'front' ) )
                    {
                    // InternalArg.g:1437:2: ( ( 'front' ) )
                    // InternalArg.g:1438:3: ( 'front' )
                    {
                     before(grammarAccess.getPositionAccess().getFrontEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1439:3: ( 'front' )
                    // InternalArg.g:1439:4: 'front'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getPositionAccess().getFrontEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1443:2: ( ( 'default' ) )
                    {
                    // InternalArg.g:1443:2: ( ( 'default' ) )
                    // InternalArg.g:1444:3: ( 'default' )
                    {
                     before(grammarAccess.getPositionAccess().getDefaultEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1445:3: ( 'default' )
                    // InternalArg.g:1445:4: 'default'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getPositionAccess().getDefaultEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1449:2: ( ( 'back' ) )
                    {
                    // InternalArg.g:1449:2: ( ( 'back' ) )
                    // InternalArg.g:1450:3: ( 'back' )
                    {
                     before(grammarAccess.getPositionAccess().getBackEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1451:3: ( 'back' )
                    // InternalArg.g:1451:4: 'back'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getPositionAccess().getBackEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__Alternatives"


    // $ANTLR start "rule__LogicOps__Alternatives"
    // InternalArg.g:1459:1: rule__LogicOps__Alternatives : ( ( ( '&' ) ) | ( ( '|' ) ) );
    public final void rule__LogicOps__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1463:1: ( ( ( '&' ) ) | ( ( '|' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            else if ( (LA15_0==36) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalArg.g:1464:2: ( ( '&' ) )
                    {
                    // InternalArg.g:1464:2: ( ( '&' ) )
                    // InternalArg.g:1465:3: ( '&' )
                    {
                     before(grammarAccess.getLogicOpsAccess().getAndEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1466:3: ( '&' )
                    // InternalArg.g:1466:4: '&'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLogicOpsAccess().getAndEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1470:2: ( ( '|' ) )
                    {
                    // InternalArg.g:1470:2: ( ( '|' ) )
                    // InternalArg.g:1471:3: ( '|' )
                    {
                     before(grammarAccess.getLogicOpsAccess().getOrEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1472:3: ( '|' )
                    // InternalArg.g:1472:4: '|'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLogicOpsAccess().getOrEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicOps__Alternatives"


    // $ANTLR start "rule__ArithmOps__Alternatives"
    // InternalArg.g:1480:1: rule__ArithmOps__Alternatives : ( ( ( '=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ArithmOps__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1484:1: ( ( ( '=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt16=1;
                }
                break;
            case 38:
                {
                alt16=2;
                }
                break;
            case 39:
                {
                alt16=3;
                }
                break;
            case 40:
                {
                alt16=4;
                }
                break;
            case 41:
                {
                alt16=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalArg.g:1485:2: ( ( '=' ) )
                    {
                    // InternalArg.g:1485:2: ( ( '=' ) )
                    // InternalArg.g:1486:3: ( '=' )
                    {
                     before(grammarAccess.getArithmOpsAccess().getEqualEnumLiteralDeclaration_0()); 
                    // InternalArg.g:1487:3: ( '=' )
                    // InternalArg.g:1487:4: '='
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getArithmOpsAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:1491:2: ( ( '>' ) )
                    {
                    // InternalArg.g:1491:2: ( ( '>' ) )
                    // InternalArg.g:1492:3: ( '>' )
                    {
                     before(grammarAccess.getArithmOpsAccess().getGreaterEnumLiteralDeclaration_1()); 
                    // InternalArg.g:1493:3: ( '>' )
                    // InternalArg.g:1493:4: '>'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getArithmOpsAccess().getGreaterEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:1497:2: ( ( '>=' ) )
                    {
                    // InternalArg.g:1497:2: ( ( '>=' ) )
                    // InternalArg.g:1498:3: ( '>=' )
                    {
                     before(grammarAccess.getArithmOpsAccess().getGreaterEqualEnumLiteralDeclaration_2()); 
                    // InternalArg.g:1499:3: ( '>=' )
                    // InternalArg.g:1499:4: '>='
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getArithmOpsAccess().getGreaterEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalArg.g:1503:2: ( ( '<' ) )
                    {
                    // InternalArg.g:1503:2: ( ( '<' ) )
                    // InternalArg.g:1504:3: ( '<' )
                    {
                     before(grammarAccess.getArithmOpsAccess().getLowerEnumLiteralDeclaration_3()); 
                    // InternalArg.g:1505:3: ( '<' )
                    // InternalArg.g:1505:4: '<'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getArithmOpsAccess().getLowerEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalArg.g:1509:2: ( ( '<=' ) )
                    {
                    // InternalArg.g:1509:2: ( ( '<=' ) )
                    // InternalArg.g:1510:3: ( '<=' )
                    {
                     before(grammarAccess.getArithmOpsAccess().getLowerEqualEnumLiteralDeclaration_4()); 
                    // InternalArg.g:1511:3: ( '<=' )
                    // InternalArg.g:1511:4: '<='
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getArithmOpsAccess().getLowerEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArithmOps__Alternatives"


    // $ANTLR start "rule__Ontological__Group__0"
    // InternalArg.g:1519:1: rule__Ontological__Group__0 : rule__Ontological__Group__0__Impl rule__Ontological__Group__1 ;
    public final void rule__Ontological__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1523:1: ( rule__Ontological__Group__0__Impl rule__Ontological__Group__1 )
            // InternalArg.g:1524:2: rule__Ontological__Group__0__Impl rule__Ontological__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Ontological__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__0"


    // $ANTLR start "rule__Ontological__Group__0__Impl"
    // InternalArg.g:1531:1: rule__Ontological__Group__0__Impl : ( 'Game' ) ;
    public final void rule__Ontological__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1535:1: ( ( 'Game' ) )
            // InternalArg.g:1536:1: ( 'Game' )
            {
            // InternalArg.g:1536:1: ( 'Game' )
            // InternalArg.g:1537:2: 'Game'
            {
             before(grammarAccess.getOntologicalAccess().getGameKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getGameKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__0__Impl"


    // $ANTLR start "rule__Ontological__Group__1"
    // InternalArg.g:1546:1: rule__Ontological__Group__1 : rule__Ontological__Group__1__Impl rule__Ontological__Group__2 ;
    public final void rule__Ontological__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1550:1: ( rule__Ontological__Group__1__Impl rule__Ontological__Group__2 )
            // InternalArg.g:1551:2: rule__Ontological__Group__1__Impl rule__Ontological__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Ontological__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__1"


    // $ANTLR start "rule__Ontological__Group__1__Impl"
    // InternalArg.g:1558:1: rule__Ontological__Group__1__Impl : ( ( rule__Ontological__NameAssignment_1 ) ) ;
    public final void rule__Ontological__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1562:1: ( ( ( rule__Ontological__NameAssignment_1 ) ) )
            // InternalArg.g:1563:1: ( ( rule__Ontological__NameAssignment_1 ) )
            {
            // InternalArg.g:1563:1: ( ( rule__Ontological__NameAssignment_1 ) )
            // InternalArg.g:1564:2: ( rule__Ontological__NameAssignment_1 )
            {
             before(grammarAccess.getOntologicalAccess().getNameAssignment_1()); 
            // InternalArg.g:1565:2: ( rule__Ontological__NameAssignment_1 )
            // InternalArg.g:1565:3: rule__Ontological__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__1__Impl"


    // $ANTLR start "rule__Ontological__Group__2"
    // InternalArg.g:1573:1: rule__Ontological__Group__2 : rule__Ontological__Group__2__Impl rule__Ontological__Group__3 ;
    public final void rule__Ontological__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1577:1: ( rule__Ontological__Group__2__Impl rule__Ontological__Group__3 )
            // InternalArg.g:1578:2: rule__Ontological__Group__2__Impl rule__Ontological__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Ontological__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__2"


    // $ANTLR start "rule__Ontological__Group__2__Impl"
    // InternalArg.g:1585:1: rule__Ontological__Group__2__Impl : ( '{' ) ;
    public final void rule__Ontological__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1589:1: ( ( '{' ) )
            // InternalArg.g:1590:1: ( '{' )
            {
            // InternalArg.g:1590:1: ( '{' )
            // InternalArg.g:1591:2: '{'
            {
             before(grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__2__Impl"


    // $ANTLR start "rule__Ontological__Group__3"
    // InternalArg.g:1600:1: rule__Ontological__Group__3 : rule__Ontological__Group__3__Impl rule__Ontological__Group__4 ;
    public final void rule__Ontological__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1604:1: ( rule__Ontological__Group__3__Impl rule__Ontological__Group__4 )
            // InternalArg.g:1605:2: rule__Ontological__Group__3__Impl rule__Ontological__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Ontological__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__3"


    // $ANTLR start "rule__Ontological__Group__3__Impl"
    // InternalArg.g:1612:1: rule__Ontological__Group__3__Impl : ( 'elements' ) ;
    public final void rule__Ontological__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1616:1: ( ( 'elements' ) )
            // InternalArg.g:1617:1: ( 'elements' )
            {
            // InternalArg.g:1617:1: ( 'elements' )
            // InternalArg.g:1618:2: 'elements'
            {
             before(grammarAccess.getOntologicalAccess().getElementsKeyword_3()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getElementsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__3__Impl"


    // $ANTLR start "rule__Ontological__Group__4"
    // InternalArg.g:1627:1: rule__Ontological__Group__4 : rule__Ontological__Group__4__Impl rule__Ontological__Group__5 ;
    public final void rule__Ontological__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1631:1: ( rule__Ontological__Group__4__Impl rule__Ontological__Group__5 )
            // InternalArg.g:1632:2: rule__Ontological__Group__4__Impl rule__Ontological__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Ontological__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__4"


    // $ANTLR start "rule__Ontological__Group__4__Impl"
    // InternalArg.g:1639:1: rule__Ontological__Group__4__Impl : ( '{' ) ;
    public final void rule__Ontological__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1643:1: ( ( '{' ) )
            // InternalArg.g:1644:1: ( '{' )
            {
            // InternalArg.g:1644:1: ( '{' )
            // InternalArg.g:1645:2: '{'
            {
             before(grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__4__Impl"


    // $ANTLR start "rule__Ontological__Group__5"
    // InternalArg.g:1654:1: rule__Ontological__Group__5 : rule__Ontological__Group__5__Impl rule__Ontological__Group__6 ;
    public final void rule__Ontological__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1658:1: ( rule__Ontological__Group__5__Impl rule__Ontological__Group__6 )
            // InternalArg.g:1659:2: rule__Ontological__Group__5__Impl rule__Ontological__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Ontological__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__5"


    // $ANTLR start "rule__Ontological__Group__5__Impl"
    // InternalArg.g:1666:1: rule__Ontological__Group__5__Impl : ( ( rule__Ontological__ClassesAssignment_5 ) ) ;
    public final void rule__Ontological__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1670:1: ( ( ( rule__Ontological__ClassesAssignment_5 ) ) )
            // InternalArg.g:1671:1: ( ( rule__Ontological__ClassesAssignment_5 ) )
            {
            // InternalArg.g:1671:1: ( ( rule__Ontological__ClassesAssignment_5 ) )
            // InternalArg.g:1672:2: ( rule__Ontological__ClassesAssignment_5 )
            {
             before(grammarAccess.getOntologicalAccess().getClassesAssignment_5()); 
            // InternalArg.g:1673:2: ( rule__Ontological__ClassesAssignment_5 )
            // InternalArg.g:1673:3: rule__Ontological__ClassesAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__ClassesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getClassesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__5__Impl"


    // $ANTLR start "rule__Ontological__Group__6"
    // InternalArg.g:1681:1: rule__Ontological__Group__6 : rule__Ontological__Group__6__Impl rule__Ontological__Group__7 ;
    public final void rule__Ontological__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1685:1: ( rule__Ontological__Group__6__Impl rule__Ontological__Group__7 )
            // InternalArg.g:1686:2: rule__Ontological__Group__6__Impl rule__Ontological__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Ontological__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__6"


    // $ANTLR start "rule__Ontological__Group__6__Impl"
    // InternalArg.g:1693:1: rule__Ontological__Group__6__Impl : ( ( rule__Ontological__ClassesAssignment_6 )* ) ;
    public final void rule__Ontological__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1697:1: ( ( ( rule__Ontological__ClassesAssignment_6 )* ) )
            // InternalArg.g:1698:1: ( ( rule__Ontological__ClassesAssignment_6 )* )
            {
            // InternalArg.g:1698:1: ( ( rule__Ontological__ClassesAssignment_6 )* )
            // InternalArg.g:1699:2: ( rule__Ontological__ClassesAssignment_6 )*
            {
             before(grammarAccess.getOntologicalAccess().getClassesAssignment_6()); 
            // InternalArg.g:1700:2: ( rule__Ontological__ClassesAssignment_6 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_ID)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalArg.g:1700:3: rule__Ontological__ClassesAssignment_6
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Ontological__ClassesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getOntologicalAccess().getClassesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__6__Impl"


    // $ANTLR start "rule__Ontological__Group__7"
    // InternalArg.g:1708:1: rule__Ontological__Group__7 : rule__Ontological__Group__7__Impl rule__Ontological__Group__8 ;
    public final void rule__Ontological__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1712:1: ( rule__Ontological__Group__7__Impl rule__Ontological__Group__8 )
            // InternalArg.g:1713:2: rule__Ontological__Group__7__Impl rule__Ontological__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__Ontological__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__7"


    // $ANTLR start "rule__Ontological__Group__7__Impl"
    // InternalArg.g:1720:1: rule__Ontological__Group__7__Impl : ( '}' ) ;
    public final void rule__Ontological__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1724:1: ( ( '}' ) )
            // InternalArg.g:1725:1: ( '}' )
            {
            // InternalArg.g:1725:1: ( '}' )
            // InternalArg.g:1726:2: '}'
            {
             before(grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__7__Impl"


    // $ANTLR start "rule__Ontological__Group__8"
    // InternalArg.g:1735:1: rule__Ontological__Group__8 : rule__Ontological__Group__8__Impl rule__Ontological__Group__9 ;
    public final void rule__Ontological__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1739:1: ( rule__Ontological__Group__8__Impl rule__Ontological__Group__9 )
            // InternalArg.g:1740:2: rule__Ontological__Group__8__Impl rule__Ontological__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__Ontological__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__8"


    // $ANTLR start "rule__Ontological__Group__8__Impl"
    // InternalArg.g:1747:1: rule__Ontological__Group__8__Impl : ( '}' ) ;
    public final void rule__Ontological__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1751:1: ( ( '}' ) )
            // InternalArg.g:1752:1: ( '}' )
            {
            // InternalArg.g:1752:1: ( '}' )
            // InternalArg.g:1753:2: '}'
            {
             before(grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_8()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__8__Impl"


    // $ANTLR start "rule__Ontological__Group__9"
    // InternalArg.g:1762:1: rule__Ontological__Group__9 : rule__Ontological__Group__9__Impl rule__Ontological__Group__10 ;
    public final void rule__Ontological__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1766:1: ( rule__Ontological__Group__9__Impl rule__Ontological__Group__10 )
            // InternalArg.g:1767:2: rule__Ontological__Group__9__Impl rule__Ontological__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__Ontological__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__9"


    // $ANTLR start "rule__Ontological__Group__9__Impl"
    // InternalArg.g:1774:1: rule__Ontological__Group__9__Impl : ( ( rule__Ontological__GraphicAssignment_9 ) ) ;
    public final void rule__Ontological__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1778:1: ( ( ( rule__Ontological__GraphicAssignment_9 ) ) )
            // InternalArg.g:1779:1: ( ( rule__Ontological__GraphicAssignment_9 ) )
            {
            // InternalArg.g:1779:1: ( ( rule__Ontological__GraphicAssignment_9 ) )
            // InternalArg.g:1780:2: ( rule__Ontological__GraphicAssignment_9 )
            {
             before(grammarAccess.getOntologicalAccess().getGraphicAssignment_9()); 
            // InternalArg.g:1781:2: ( rule__Ontological__GraphicAssignment_9 )
            // InternalArg.g:1781:3: rule__Ontological__GraphicAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__GraphicAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getGraphicAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__9__Impl"


    // $ANTLR start "rule__Ontological__Group__10"
    // InternalArg.g:1789:1: rule__Ontological__Group__10 : rule__Ontological__Group__10__Impl rule__Ontological__Group__11 ;
    public final void rule__Ontological__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1793:1: ( rule__Ontological__Group__10__Impl rule__Ontological__Group__11 )
            // InternalArg.g:1794:2: rule__Ontological__Group__10__Impl rule__Ontological__Group__11
            {
            pushFollow(FOLLOW_11);
            rule__Ontological__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ontological__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__10"


    // $ANTLR start "rule__Ontological__Group__10__Impl"
    // InternalArg.g:1801:1: rule__Ontological__Group__10__Impl : ( ( rule__Ontological__PhysicAssignment_10 ) ) ;
    public final void rule__Ontological__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1805:1: ( ( ( rule__Ontological__PhysicAssignment_10 ) ) )
            // InternalArg.g:1806:1: ( ( rule__Ontological__PhysicAssignment_10 ) )
            {
            // InternalArg.g:1806:1: ( ( rule__Ontological__PhysicAssignment_10 ) )
            // InternalArg.g:1807:2: ( rule__Ontological__PhysicAssignment_10 )
            {
             before(grammarAccess.getOntologicalAccess().getPhysicAssignment_10()); 
            // InternalArg.g:1808:2: ( rule__Ontological__PhysicAssignment_10 )
            // InternalArg.g:1808:3: rule__Ontological__PhysicAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__PhysicAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getPhysicAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__10__Impl"


    // $ANTLR start "rule__Ontological__Group__11"
    // InternalArg.g:1816:1: rule__Ontological__Group__11 : rule__Ontological__Group__11__Impl ;
    public final void rule__Ontological__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1820:1: ( rule__Ontological__Group__11__Impl )
            // InternalArg.g:1821:2: rule__Ontological__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__11"


    // $ANTLR start "rule__Ontological__Group__11__Impl"
    // InternalArg.g:1827:1: rule__Ontological__Group__11__Impl : ( ( rule__Ontological__GameAssignment_11 ) ) ;
    public final void rule__Ontological__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1831:1: ( ( ( rule__Ontological__GameAssignment_11 ) ) )
            // InternalArg.g:1832:1: ( ( rule__Ontological__GameAssignment_11 ) )
            {
            // InternalArg.g:1832:1: ( ( rule__Ontological__GameAssignment_11 ) )
            // InternalArg.g:1833:2: ( rule__Ontological__GameAssignment_11 )
            {
             before(grammarAccess.getOntologicalAccess().getGameAssignment_11()); 
            // InternalArg.g:1834:2: ( rule__Ontological__GameAssignment_11 )
            // InternalArg.g:1834:3: rule__Ontological__GameAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Ontological__GameAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getOntologicalAccess().getGameAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__Group__11__Impl"


    // $ANTLR start "rule__Class__Group__0"
    // InternalArg.g:1843:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1847:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalArg.g:1848:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // InternalArg.g:1855:1: rule__Class__Group__0__Impl : ( ( rule__Class__NameAssignment_0 ) ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1859:1: ( ( ( rule__Class__NameAssignment_0 ) ) )
            // InternalArg.g:1860:1: ( ( rule__Class__NameAssignment_0 ) )
            {
            // InternalArg.g:1860:1: ( ( rule__Class__NameAssignment_0 ) )
            // InternalArg.g:1861:2: ( rule__Class__NameAssignment_0 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_0()); 
            // InternalArg.g:1862:2: ( rule__Class__NameAssignment_0 )
            // InternalArg.g:1862:3: rule__Class__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Class__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // InternalArg.g:1870:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1874:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalArg.g:1875:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__Class__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // InternalArg.g:1882:1: rule__Class__Group__1__Impl : ( '{' ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1886:1: ( ( '{' ) )
            // InternalArg.g:1887:1: ( '{' )
            {
            // InternalArg.g:1887:1: ( '{' )
            // InternalArg.g:1888:2: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // InternalArg.g:1897:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1901:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalArg.g:1902:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Class__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // InternalArg.g:1909:1: rule__Class__Group__2__Impl : ( ( rule__Class__Group_2__0 )? ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1913:1: ( ( ( rule__Class__Group_2__0 )? ) )
            // InternalArg.g:1914:1: ( ( rule__Class__Group_2__0 )? )
            {
            // InternalArg.g:1914:1: ( ( rule__Class__Group_2__0 )? )
            // InternalArg.g:1915:2: ( rule__Class__Group_2__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_2()); 
            // InternalArg.g:1916:2: ( rule__Class__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalArg.g:1916:3: rule__Class__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // InternalArg.g:1924:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1928:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // InternalArg.g:1929:2: rule__Class__Group__3__Impl rule__Class__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Class__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // InternalArg.g:1936:1: rule__Class__Group__3__Impl : ( ( rule__Class__Group_3__0 )? ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1940:1: ( ( ( rule__Class__Group_3__0 )? ) )
            // InternalArg.g:1941:1: ( ( rule__Class__Group_3__0 )? )
            {
            // InternalArg.g:1941:1: ( ( rule__Class__Group_3__0 )? )
            // InternalArg.g:1942:2: ( rule__Class__Group_3__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_3()); 
            // InternalArg.g:1943:2: ( rule__Class__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==46) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalArg.g:1943:3: rule__Class__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group__4"
    // InternalArg.g:1951:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1955:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // InternalArg.g:1956:2: rule__Class__Group__4__Impl rule__Class__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__Class__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__4"


    // $ANTLR start "rule__Class__Group__4__Impl"
    // InternalArg.g:1963:1: rule__Class__Group__4__Impl : ( '}' ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1967:1: ( ( '}' ) )
            // InternalArg.g:1968:1: ( '}' )
            {
            // InternalArg.g:1968:1: ( '}' )
            // InternalArg.g:1969:2: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__4__Impl"


    // $ANTLR start "rule__Class__Group__5"
    // InternalArg.g:1978:1: rule__Class__Group__5 : rule__Class__Group__5__Impl rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1982:1: ( rule__Class__Group__5__Impl rule__Class__Group__6 )
            // InternalArg.g:1983:2: rule__Class__Group__5__Impl rule__Class__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Class__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__5"


    // $ANTLR start "rule__Class__Group__5__Impl"
    // InternalArg.g:1990:1: rule__Class__Group__5__Impl : ( ( rule__Class__AbstractAssignment_5 )? ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:1994:1: ( ( ( rule__Class__AbstractAssignment_5 )? ) )
            // InternalArg.g:1995:1: ( ( rule__Class__AbstractAssignment_5 )? )
            {
            // InternalArg.g:1995:1: ( ( rule__Class__AbstractAssignment_5 )? )
            // InternalArg.g:1996:2: ( rule__Class__AbstractAssignment_5 )?
            {
             before(grammarAccess.getClassAccess().getAbstractAssignment_5()); 
            // InternalArg.g:1997:2: ( rule__Class__AbstractAssignment_5 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==116) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalArg.g:1997:3: rule__Class__AbstractAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__AbstractAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getAbstractAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__5__Impl"


    // $ANTLR start "rule__Class__Group__6"
    // InternalArg.g:2005:1: rule__Class__Group__6 : rule__Class__Group__6__Impl ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2009:1: ( rule__Class__Group__6__Impl )
            // InternalArg.g:2010:2: rule__Class__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__6"


    // $ANTLR start "rule__Class__Group__6__Impl"
    // InternalArg.g:2016:1: rule__Class__Group__6__Impl : ( ( rule__Class__NoSCNAssignment_6 )? ) ;
    public final void rule__Class__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2020:1: ( ( ( rule__Class__NoSCNAssignment_6 )? ) )
            // InternalArg.g:2021:1: ( ( rule__Class__NoSCNAssignment_6 )? )
            {
            // InternalArg.g:2021:1: ( ( rule__Class__NoSCNAssignment_6 )? )
            // InternalArg.g:2022:2: ( rule__Class__NoSCNAssignment_6 )?
            {
             before(grammarAccess.getClassAccess().getNoSCNAssignment_6()); 
            // InternalArg.g:2023:2: ( rule__Class__NoSCNAssignment_6 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==117) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalArg.g:2023:3: rule__Class__NoSCNAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__NoSCNAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getNoSCNAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__6__Impl"


    // $ANTLR start "rule__Class__Group_2__0"
    // InternalArg.g:2032:1: rule__Class__Group_2__0 : rule__Class__Group_2__0__Impl rule__Class__Group_2__1 ;
    public final void rule__Class__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2036:1: ( rule__Class__Group_2__0__Impl rule__Class__Group_2__1 )
            // InternalArg.g:2037:2: rule__Class__Group_2__0__Impl rule__Class__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Class__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_2__0"


    // $ANTLR start "rule__Class__Group_2__0__Impl"
    // InternalArg.g:2044:1: rule__Class__Group_2__0__Impl : ( ( rule__Class__AttributesAssignment_2_0 ) ) ;
    public final void rule__Class__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2048:1: ( ( ( rule__Class__AttributesAssignment_2_0 ) ) )
            // InternalArg.g:2049:1: ( ( rule__Class__AttributesAssignment_2_0 ) )
            {
            // InternalArg.g:2049:1: ( ( rule__Class__AttributesAssignment_2_0 ) )
            // InternalArg.g:2050:2: ( rule__Class__AttributesAssignment_2_0 )
            {
             before(grammarAccess.getClassAccess().getAttributesAssignment_2_0()); 
            // InternalArg.g:2051:2: ( rule__Class__AttributesAssignment_2_0 )
            // InternalArg.g:2051:3: rule__Class__AttributesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Class__AttributesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getAttributesAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_2__0__Impl"


    // $ANTLR start "rule__Class__Group_2__1"
    // InternalArg.g:2059:1: rule__Class__Group_2__1 : rule__Class__Group_2__1__Impl ;
    public final void rule__Class__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2063:1: ( rule__Class__Group_2__1__Impl )
            // InternalArg.g:2064:2: rule__Class__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_2__1"


    // $ANTLR start "rule__Class__Group_2__1__Impl"
    // InternalArg.g:2070:1: rule__Class__Group_2__1__Impl : ( ( rule__Class__AttributesAssignment_2_1 )* ) ;
    public final void rule__Class__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2074:1: ( ( ( rule__Class__AttributesAssignment_2_1 )* ) )
            // InternalArg.g:2075:1: ( ( rule__Class__AttributesAssignment_2_1 )* )
            {
            // InternalArg.g:2075:1: ( ( rule__Class__AttributesAssignment_2_1 )* )
            // InternalArg.g:2076:2: ( rule__Class__AttributesAssignment_2_1 )*
            {
             before(grammarAccess.getClassAccess().getAttributesAssignment_2_1()); 
            // InternalArg.g:2077:2: ( rule__Class__AttributesAssignment_2_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalArg.g:2077:3: rule__Class__AttributesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Class__AttributesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getAttributesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_2__1__Impl"


    // $ANTLR start "rule__Class__Group_3__0"
    // InternalArg.g:2086:1: rule__Class__Group_3__0 : rule__Class__Group_3__0__Impl rule__Class__Group_3__1 ;
    public final void rule__Class__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2090:1: ( rule__Class__Group_3__0__Impl rule__Class__Group_3__1 )
            // InternalArg.g:2091:2: rule__Class__Group_3__0__Impl rule__Class__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__0"


    // $ANTLR start "rule__Class__Group_3__0__Impl"
    // InternalArg.g:2098:1: rule__Class__Group_3__0__Impl : ( 'dependences' ) ;
    public final void rule__Class__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2102:1: ( ( 'dependences' ) )
            // InternalArg.g:2103:1: ( 'dependences' )
            {
            // InternalArg.g:2103:1: ( 'dependences' )
            // InternalArg.g:2104:2: 'dependences'
            {
             before(grammarAccess.getClassAccess().getDependencesKeyword_3_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getDependencesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__0__Impl"


    // $ANTLR start "rule__Class__Group_3__1"
    // InternalArg.g:2113:1: rule__Class__Group_3__1 : rule__Class__Group_3__1__Impl rule__Class__Group_3__2 ;
    public final void rule__Class__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2117:1: ( rule__Class__Group_3__1__Impl rule__Class__Group_3__2 )
            // InternalArg.g:2118:2: rule__Class__Group_3__1__Impl rule__Class__Group_3__2
            {
            pushFollow(FOLLOW_3);
            rule__Class__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__1"


    // $ANTLR start "rule__Class__Group_3__1__Impl"
    // InternalArg.g:2125:1: rule__Class__Group_3__1__Impl : ( '{' ) ;
    public final void rule__Class__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2129:1: ( ( '{' ) )
            // InternalArg.g:2130:1: ( '{' )
            {
            // InternalArg.g:2130:1: ( '{' )
            // InternalArg.g:2131:2: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__1__Impl"


    // $ANTLR start "rule__Class__Group_3__2"
    // InternalArg.g:2140:1: rule__Class__Group_3__2 : rule__Class__Group_3__2__Impl rule__Class__Group_3__3 ;
    public final void rule__Class__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2144:1: ( rule__Class__Group_3__2__Impl rule__Class__Group_3__3 )
            // InternalArg.g:2145:2: rule__Class__Group_3__2__Impl rule__Class__Group_3__3
            {
            pushFollow(FOLLOW_6);
            rule__Class__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__2"


    // $ANTLR start "rule__Class__Group_3__2__Impl"
    // InternalArg.g:2152:1: rule__Class__Group_3__2__Impl : ( ( rule__Class__ReferencesAssignment_3_2 ) ) ;
    public final void rule__Class__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2156:1: ( ( ( rule__Class__ReferencesAssignment_3_2 ) ) )
            // InternalArg.g:2157:1: ( ( rule__Class__ReferencesAssignment_3_2 ) )
            {
            // InternalArg.g:2157:1: ( ( rule__Class__ReferencesAssignment_3_2 ) )
            // InternalArg.g:2158:2: ( rule__Class__ReferencesAssignment_3_2 )
            {
             before(grammarAccess.getClassAccess().getReferencesAssignment_3_2()); 
            // InternalArg.g:2159:2: ( rule__Class__ReferencesAssignment_3_2 )
            // InternalArg.g:2159:3: rule__Class__ReferencesAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Class__ReferencesAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getReferencesAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__2__Impl"


    // $ANTLR start "rule__Class__Group_3__3"
    // InternalArg.g:2167:1: rule__Class__Group_3__3 : rule__Class__Group_3__3__Impl rule__Class__Group_3__4 ;
    public final void rule__Class__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2171:1: ( rule__Class__Group_3__3__Impl rule__Class__Group_3__4 )
            // InternalArg.g:2172:2: rule__Class__Group_3__3__Impl rule__Class__Group_3__4
            {
            pushFollow(FOLLOW_6);
            rule__Class__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__3"


    // $ANTLR start "rule__Class__Group_3__3__Impl"
    // InternalArg.g:2179:1: rule__Class__Group_3__3__Impl : ( ( rule__Class__ReferencesAssignment_3_3 )* ) ;
    public final void rule__Class__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2183:1: ( ( ( rule__Class__ReferencesAssignment_3_3 )* ) )
            // InternalArg.g:2184:1: ( ( rule__Class__ReferencesAssignment_3_3 )* )
            {
            // InternalArg.g:2184:1: ( ( rule__Class__ReferencesAssignment_3_3 )* )
            // InternalArg.g:2185:2: ( rule__Class__ReferencesAssignment_3_3 )*
            {
             before(grammarAccess.getClassAccess().getReferencesAssignment_3_3()); 
            // InternalArg.g:2186:2: ( rule__Class__ReferencesAssignment_3_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalArg.g:2186:3: rule__Class__ReferencesAssignment_3_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Class__ReferencesAssignment_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getReferencesAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__3__Impl"


    // $ANTLR start "rule__Class__Group_3__4"
    // InternalArg.g:2194:1: rule__Class__Group_3__4 : rule__Class__Group_3__4__Impl ;
    public final void rule__Class__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2198:1: ( rule__Class__Group_3__4__Impl )
            // InternalArg.g:2199:2: rule__Class__Group_3__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__4"


    // $ANTLR start "rule__Class__Group_3__4__Impl"
    // InternalArg.g:2205:1: rule__Class__Group_3__4__Impl : ( '}' ) ;
    public final void rule__Class__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2209:1: ( ( '}' ) )
            // InternalArg.g:2210:1: ( '}' )
            {
            // InternalArg.g:2210:1: ( '}' )
            // InternalArg.g:2211:2: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_3__4__Impl"


    // $ANTLR start "rule__Graphic__Group__0"
    // InternalArg.g:2221:1: rule__Graphic__Group__0 : rule__Graphic__Group__0__Impl rule__Graphic__Group__1 ;
    public final void rule__Graphic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2225:1: ( rule__Graphic__Group__0__Impl rule__Graphic__Group__1 )
            // InternalArg.g:2226:2: rule__Graphic__Group__0__Impl rule__Graphic__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Graphic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Graphic__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__0"


    // $ANTLR start "rule__Graphic__Group__0__Impl"
    // InternalArg.g:2233:1: rule__Graphic__Group__0__Impl : ( 'Graphic' ) ;
    public final void rule__Graphic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2237:1: ( ( 'Graphic' ) )
            // InternalArg.g:2238:1: ( 'Graphic' )
            {
            // InternalArg.g:2238:1: ( 'Graphic' )
            // InternalArg.g:2239:2: 'Graphic'
            {
             before(grammarAccess.getGraphicAccess().getGraphicKeyword_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getGraphicAccess().getGraphicKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__0__Impl"


    // $ANTLR start "rule__Graphic__Group__1"
    // InternalArg.g:2248:1: rule__Graphic__Group__1 : rule__Graphic__Group__1__Impl rule__Graphic__Group__2 ;
    public final void rule__Graphic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2252:1: ( rule__Graphic__Group__1__Impl rule__Graphic__Group__2 )
            // InternalArg.g:2253:2: rule__Graphic__Group__1__Impl rule__Graphic__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Graphic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Graphic__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__1"


    // $ANTLR start "rule__Graphic__Group__1__Impl"
    // InternalArg.g:2260:1: rule__Graphic__Group__1__Impl : ( '{' ) ;
    public final void rule__Graphic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2264:1: ( ( '{' ) )
            // InternalArg.g:2265:1: ( '{' )
            {
            // InternalArg.g:2265:1: ( '{' )
            // InternalArg.g:2266:2: '{'
            {
             before(grammarAccess.getGraphicAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGraphicAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__1__Impl"


    // $ANTLR start "rule__Graphic__Group__2"
    // InternalArg.g:2275:1: rule__Graphic__Group__2 : rule__Graphic__Group__2__Impl rule__Graphic__Group__3 ;
    public final void rule__Graphic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2279:1: ( rule__Graphic__Group__2__Impl rule__Graphic__Group__3 )
            // InternalArg.g:2280:2: rule__Graphic__Group__2__Impl rule__Graphic__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Graphic__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Graphic__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__2"


    // $ANTLR start "rule__Graphic__Group__2__Impl"
    // InternalArg.g:2287:1: rule__Graphic__Group__2__Impl : ( ( rule__Graphic__ClassesAssignment_2 ) ) ;
    public final void rule__Graphic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2291:1: ( ( ( rule__Graphic__ClassesAssignment_2 ) ) )
            // InternalArg.g:2292:1: ( ( rule__Graphic__ClassesAssignment_2 ) )
            {
            // InternalArg.g:2292:1: ( ( rule__Graphic__ClassesAssignment_2 ) )
            // InternalArg.g:2293:2: ( rule__Graphic__ClassesAssignment_2 )
            {
             before(grammarAccess.getGraphicAccess().getClassesAssignment_2()); 
            // InternalArg.g:2294:2: ( rule__Graphic__ClassesAssignment_2 )
            // InternalArg.g:2294:3: rule__Graphic__ClassesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Graphic__ClassesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGraphicAccess().getClassesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__2__Impl"


    // $ANTLR start "rule__Graphic__Group__3"
    // InternalArg.g:2302:1: rule__Graphic__Group__3 : rule__Graphic__Group__3__Impl rule__Graphic__Group__4 ;
    public final void rule__Graphic__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2306:1: ( rule__Graphic__Group__3__Impl rule__Graphic__Group__4 )
            // InternalArg.g:2307:2: rule__Graphic__Group__3__Impl rule__Graphic__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__Graphic__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Graphic__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__3"


    // $ANTLR start "rule__Graphic__Group__3__Impl"
    // InternalArg.g:2314:1: rule__Graphic__Group__3__Impl : ( ( rule__Graphic__ClassesAssignment_3 )* ) ;
    public final void rule__Graphic__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2318:1: ( ( ( rule__Graphic__ClassesAssignment_3 )* ) )
            // InternalArg.g:2319:1: ( ( rule__Graphic__ClassesAssignment_3 )* )
            {
            // InternalArg.g:2319:1: ( ( rule__Graphic__ClassesAssignment_3 )* )
            // InternalArg.g:2320:2: ( rule__Graphic__ClassesAssignment_3 )*
            {
             before(grammarAccess.getGraphicAccess().getClassesAssignment_3()); 
            // InternalArg.g:2321:2: ( rule__Graphic__ClassesAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==66) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalArg.g:2321:3: rule__Graphic__ClassesAssignment_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Graphic__ClassesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getGraphicAccess().getClassesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__3__Impl"


    // $ANTLR start "rule__Graphic__Group__4"
    // InternalArg.g:2329:1: rule__Graphic__Group__4 : rule__Graphic__Group__4__Impl ;
    public final void rule__Graphic__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2333:1: ( rule__Graphic__Group__4__Impl )
            // InternalArg.g:2334:2: rule__Graphic__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Graphic__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__4"


    // $ANTLR start "rule__Graphic__Group__4__Impl"
    // InternalArg.g:2340:1: rule__Graphic__Group__4__Impl : ( '}' ) ;
    public final void rule__Graphic__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2344:1: ( ( '}' ) )
            // InternalArg.g:2345:1: ( '}' )
            {
            // InternalArg.g:2345:1: ( '}' )
            // InternalArg.g:2346:2: '}'
            {
             before(grammarAccess.getGraphicAccess().getRightCurlyBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGraphicAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__Group__4__Impl"


    // $ANTLR start "rule__Physic__Group__0"
    // InternalArg.g:2356:1: rule__Physic__Group__0 : rule__Physic__Group__0__Impl rule__Physic__Group__1 ;
    public final void rule__Physic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2360:1: ( rule__Physic__Group__0__Impl rule__Physic__Group__1 )
            // InternalArg.g:2361:2: rule__Physic__Group__0__Impl rule__Physic__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Physic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Physic__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__0"


    // $ANTLR start "rule__Physic__Group__0__Impl"
    // InternalArg.g:2368:1: rule__Physic__Group__0__Impl : ( 'Physics' ) ;
    public final void rule__Physic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2372:1: ( ( 'Physics' ) )
            // InternalArg.g:2373:1: ( 'Physics' )
            {
            // InternalArg.g:2373:1: ( 'Physics' )
            // InternalArg.g:2374:2: 'Physics'
            {
             before(grammarAccess.getPhysicAccess().getPhysicsKeyword_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getPhysicAccess().getPhysicsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__0__Impl"


    // $ANTLR start "rule__Physic__Group__1"
    // InternalArg.g:2383:1: rule__Physic__Group__1 : rule__Physic__Group__1__Impl rule__Physic__Group__2 ;
    public final void rule__Physic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2387:1: ( rule__Physic__Group__1__Impl rule__Physic__Group__2 )
            // InternalArg.g:2388:2: rule__Physic__Group__1__Impl rule__Physic__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Physic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Physic__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__1"


    // $ANTLR start "rule__Physic__Group__1__Impl"
    // InternalArg.g:2395:1: rule__Physic__Group__1__Impl : ( '{' ) ;
    public final void rule__Physic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2399:1: ( ( '{' ) )
            // InternalArg.g:2400:1: ( '{' )
            {
            // InternalArg.g:2400:1: ( '{' )
            // InternalArg.g:2401:2: '{'
            {
             before(grammarAccess.getPhysicAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPhysicAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__1__Impl"


    // $ANTLR start "rule__Physic__Group__2"
    // InternalArg.g:2410:1: rule__Physic__Group__2 : rule__Physic__Group__2__Impl rule__Physic__Group__3 ;
    public final void rule__Physic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2414:1: ( rule__Physic__Group__2__Impl rule__Physic__Group__3 )
            // InternalArg.g:2415:2: rule__Physic__Group__2__Impl rule__Physic__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Physic__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Physic__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__2"


    // $ANTLR start "rule__Physic__Group__2__Impl"
    // InternalArg.g:2422:1: rule__Physic__Group__2__Impl : ( ( rule__Physic__ClassesAssignment_2 ) ) ;
    public final void rule__Physic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2426:1: ( ( ( rule__Physic__ClassesAssignment_2 ) ) )
            // InternalArg.g:2427:1: ( ( rule__Physic__ClassesAssignment_2 ) )
            {
            // InternalArg.g:2427:1: ( ( rule__Physic__ClassesAssignment_2 ) )
            // InternalArg.g:2428:2: ( rule__Physic__ClassesAssignment_2 )
            {
             before(grammarAccess.getPhysicAccess().getClassesAssignment_2()); 
            // InternalArg.g:2429:2: ( rule__Physic__ClassesAssignment_2 )
            // InternalArg.g:2429:3: rule__Physic__ClassesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Physic__ClassesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicAccess().getClassesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__2__Impl"


    // $ANTLR start "rule__Physic__Group__3"
    // InternalArg.g:2437:1: rule__Physic__Group__3 : rule__Physic__Group__3__Impl rule__Physic__Group__4 ;
    public final void rule__Physic__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2441:1: ( rule__Physic__Group__3__Impl rule__Physic__Group__4 )
            // InternalArg.g:2442:2: rule__Physic__Group__3__Impl rule__Physic__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__Physic__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Physic__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__3"


    // $ANTLR start "rule__Physic__Group__3__Impl"
    // InternalArg.g:2449:1: rule__Physic__Group__3__Impl : ( ( rule__Physic__ClassesAssignment_3 )* ) ;
    public final void rule__Physic__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2453:1: ( ( ( rule__Physic__ClassesAssignment_3 )* ) )
            // InternalArg.g:2454:1: ( ( rule__Physic__ClassesAssignment_3 )* )
            {
            // InternalArg.g:2454:1: ( ( rule__Physic__ClassesAssignment_3 )* )
            // InternalArg.g:2455:2: ( rule__Physic__ClassesAssignment_3 )*
            {
             before(grammarAccess.getPhysicAccess().getClassesAssignment_3()); 
            // InternalArg.g:2456:2: ( rule__Physic__ClassesAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==66) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalArg.g:2456:3: rule__Physic__ClassesAssignment_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Physic__ClassesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getPhysicAccess().getClassesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__3__Impl"


    // $ANTLR start "rule__Physic__Group__4"
    // InternalArg.g:2464:1: rule__Physic__Group__4 : rule__Physic__Group__4__Impl ;
    public final void rule__Physic__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2468:1: ( rule__Physic__Group__4__Impl )
            // InternalArg.g:2469:2: rule__Physic__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Physic__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__4"


    // $ANTLR start "rule__Physic__Group__4__Impl"
    // InternalArg.g:2475:1: rule__Physic__Group__4__Impl : ( '}' ) ;
    public final void rule__Physic__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2479:1: ( ( '}' ) )
            // InternalArg.g:2480:1: ( '}' )
            {
            // InternalArg.g:2480:1: ( '}' )
            // InternalArg.g:2481:2: '}'
            {
             before(grammarAccess.getPhysicAccess().getRightCurlyBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPhysicAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__Group__4__Impl"


    // $ANTLR start "rule__Game__Group__0"
    // InternalArg.g:2491:1: rule__Game__Group__0 : rule__Game__Group__0__Impl rule__Game__Group__1 ;
    public final void rule__Game__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2495:1: ( rule__Game__Group__0__Impl rule__Game__Group__1 )
            // InternalArg.g:2496:2: rule__Game__Group__0__Impl rule__Game__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0"


    // $ANTLR start "rule__Game__Group__0__Impl"
    // InternalArg.g:2503:1: rule__Game__Group__0__Impl : ( 'Gamelogic' ) ;
    public final void rule__Game__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2507:1: ( ( 'Gamelogic' ) )
            // InternalArg.g:2508:1: ( 'Gamelogic' )
            {
            // InternalArg.g:2508:1: ( 'Gamelogic' )
            // InternalArg.g:2509:2: 'Gamelogic'
            {
             before(grammarAccess.getGameAccess().getGamelogicKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getGamelogicKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0__Impl"


    // $ANTLR start "rule__Game__Group__1"
    // InternalArg.g:2518:1: rule__Game__Group__1 : rule__Game__Group__1__Impl rule__Game__Group__2 ;
    public final void rule__Game__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2522:1: ( rule__Game__Group__1__Impl rule__Game__Group__2 )
            // InternalArg.g:2523:2: rule__Game__Group__1__Impl rule__Game__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__Game__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1"


    // $ANTLR start "rule__Game__Group__1__Impl"
    // InternalArg.g:2530:1: rule__Game__Group__1__Impl : ( '{' ) ;
    public final void rule__Game__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2534:1: ( ( '{' ) )
            // InternalArg.g:2535:1: ( '{' )
            {
            // InternalArg.g:2535:1: ( '{' )
            // InternalArg.g:2536:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1__Impl"


    // $ANTLR start "rule__Game__Group__2"
    // InternalArg.g:2545:1: rule__Game__Group__2 : rule__Game__Group__2__Impl rule__Game__Group__3 ;
    public final void rule__Game__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2549:1: ( rule__Game__Group__2__Impl rule__Game__Group__3 )
            // InternalArg.g:2550:2: rule__Game__Group__2__Impl rule__Game__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2"


    // $ANTLR start "rule__Game__Group__2__Impl"
    // InternalArg.g:2557:1: rule__Game__Group__2__Impl : ( 'Display' ) ;
    public final void rule__Game__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2561:1: ( ( 'Display' ) )
            // InternalArg.g:2562:1: ( 'Display' )
            {
            // InternalArg.g:2562:1: ( 'Display' )
            // InternalArg.g:2563:2: 'Display'
            {
             before(grammarAccess.getGameAccess().getDisplayKeyword_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getDisplayKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2__Impl"


    // $ANTLR start "rule__Game__Group__3"
    // InternalArg.g:2572:1: rule__Game__Group__3 : rule__Game__Group__3__Impl rule__Game__Group__4 ;
    public final void rule__Game__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2576:1: ( rule__Game__Group__3__Impl rule__Game__Group__4 )
            // InternalArg.g:2577:2: rule__Game__Group__3__Impl rule__Game__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Game__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3"


    // $ANTLR start "rule__Game__Group__3__Impl"
    // InternalArg.g:2584:1: rule__Game__Group__3__Impl : ( '{' ) ;
    public final void rule__Game__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2588:1: ( ( '{' ) )
            // InternalArg.g:2589:1: ( '{' )
            {
            // InternalArg.g:2589:1: ( '{' )
            // InternalArg.g:2590:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3__Impl"


    // $ANTLR start "rule__Game__Group__4"
    // InternalArg.g:2599:1: rule__Game__Group__4 : rule__Game__Group__4__Impl rule__Game__Group__5 ;
    public final void rule__Game__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2603:1: ( rule__Game__Group__4__Impl rule__Game__Group__5 )
            // InternalArg.g:2604:2: rule__Game__Group__4__Impl rule__Game__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4"


    // $ANTLR start "rule__Game__Group__4__Impl"
    // InternalArg.g:2611:1: rule__Game__Group__4__Impl : ( 'start' ) ;
    public final void rule__Game__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2615:1: ( ( 'start' ) )
            // InternalArg.g:2616:1: ( 'start' )
            {
            // InternalArg.g:2616:1: ( 'start' )
            // InternalArg.g:2617:2: 'start'
            {
             before(grammarAccess.getGameAccess().getStartKeyword_4()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getStartKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4__Impl"


    // $ANTLR start "rule__Game__Group__5"
    // InternalArg.g:2626:1: rule__Game__Group__5 : rule__Game__Group__5__Impl rule__Game__Group__6 ;
    public final void rule__Game__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2630:1: ( rule__Game__Group__5__Impl rule__Game__Group__6 )
            // InternalArg.g:2631:2: rule__Game__Group__5__Impl rule__Game__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__Game__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5"


    // $ANTLR start "rule__Game__Group__5__Impl"
    // InternalArg.g:2638:1: rule__Game__Group__5__Impl : ( ( rule__Game__StartAssignment_5 ) ) ;
    public final void rule__Game__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2642:1: ( ( ( rule__Game__StartAssignment_5 ) ) )
            // InternalArg.g:2643:1: ( ( rule__Game__StartAssignment_5 ) )
            {
            // InternalArg.g:2643:1: ( ( rule__Game__StartAssignment_5 ) )
            // InternalArg.g:2644:2: ( rule__Game__StartAssignment_5 )
            {
             before(grammarAccess.getGameAccess().getStartAssignment_5()); 
            // InternalArg.g:2645:2: ( rule__Game__StartAssignment_5 )
            // InternalArg.g:2645:3: rule__Game__StartAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Game__StartAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getStartAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5__Impl"


    // $ANTLR start "rule__Game__Group__6"
    // InternalArg.g:2653:1: rule__Game__Group__6 : rule__Game__Group__6__Impl rule__Game__Group__7 ;
    public final void rule__Game__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2657:1: ( rule__Game__Group__6__Impl rule__Game__Group__7 )
            // InternalArg.g:2658:2: rule__Game__Group__6__Impl rule__Game__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__6"


    // $ANTLR start "rule__Game__Group__6__Impl"
    // InternalArg.g:2665:1: rule__Game__Group__6__Impl : ( 'win' ) ;
    public final void rule__Game__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2669:1: ( ( 'win' ) )
            // InternalArg.g:2670:1: ( 'win' )
            {
            // InternalArg.g:2670:1: ( 'win' )
            // InternalArg.g:2671:2: 'win'
            {
             before(grammarAccess.getGameAccess().getWinKeyword_6()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getWinKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__6__Impl"


    // $ANTLR start "rule__Game__Group__7"
    // InternalArg.g:2680:1: rule__Game__Group__7 : rule__Game__Group__7__Impl rule__Game__Group__8 ;
    public final void rule__Game__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2684:1: ( rule__Game__Group__7__Impl rule__Game__Group__8 )
            // InternalArg.g:2685:2: rule__Game__Group__7__Impl rule__Game__Group__8
            {
            pushFollow(FOLLOW_20);
            rule__Game__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__7"


    // $ANTLR start "rule__Game__Group__7__Impl"
    // InternalArg.g:2692:1: rule__Game__Group__7__Impl : ( ( rule__Game__WinAssignment_7 ) ) ;
    public final void rule__Game__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2696:1: ( ( ( rule__Game__WinAssignment_7 ) ) )
            // InternalArg.g:2697:1: ( ( rule__Game__WinAssignment_7 ) )
            {
            // InternalArg.g:2697:1: ( ( rule__Game__WinAssignment_7 ) )
            // InternalArg.g:2698:2: ( rule__Game__WinAssignment_7 )
            {
             before(grammarAccess.getGameAccess().getWinAssignment_7()); 
            // InternalArg.g:2699:2: ( rule__Game__WinAssignment_7 )
            // InternalArg.g:2699:3: rule__Game__WinAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Game__WinAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getWinAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__7__Impl"


    // $ANTLR start "rule__Game__Group__8"
    // InternalArg.g:2707:1: rule__Game__Group__8 : rule__Game__Group__8__Impl rule__Game__Group__9 ;
    public final void rule__Game__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2711:1: ( rule__Game__Group__8__Impl rule__Game__Group__9 )
            // InternalArg.g:2712:2: rule__Game__Group__8__Impl rule__Game__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__8"


    // $ANTLR start "rule__Game__Group__8__Impl"
    // InternalArg.g:2719:1: rule__Game__Group__8__Impl : ( 'lose' ) ;
    public final void rule__Game__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2723:1: ( ( 'lose' ) )
            // InternalArg.g:2724:1: ( 'lose' )
            {
            // InternalArg.g:2724:1: ( 'lose' )
            // InternalArg.g:2725:2: 'lose'
            {
             before(grammarAccess.getGameAccess().getLoseKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLoseKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__8__Impl"


    // $ANTLR start "rule__Game__Group__9"
    // InternalArg.g:2734:1: rule__Game__Group__9 : rule__Game__Group__9__Impl rule__Game__Group__10 ;
    public final void rule__Game__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2738:1: ( rule__Game__Group__9__Impl rule__Game__Group__10 )
            // InternalArg.g:2739:2: rule__Game__Group__9__Impl rule__Game__Group__10
            {
            pushFollow(FOLLOW_21);
            rule__Game__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__9"


    // $ANTLR start "rule__Game__Group__9__Impl"
    // InternalArg.g:2746:1: rule__Game__Group__9__Impl : ( ( rule__Game__LoseAssignment_9 ) ) ;
    public final void rule__Game__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2750:1: ( ( ( rule__Game__LoseAssignment_9 ) ) )
            // InternalArg.g:2751:1: ( ( rule__Game__LoseAssignment_9 ) )
            {
            // InternalArg.g:2751:1: ( ( rule__Game__LoseAssignment_9 ) )
            // InternalArg.g:2752:2: ( rule__Game__LoseAssignment_9 )
            {
             before(grammarAccess.getGameAccess().getLoseAssignment_9()); 
            // InternalArg.g:2753:2: ( rule__Game__LoseAssignment_9 )
            // InternalArg.g:2753:3: rule__Game__LoseAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Game__LoseAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getLoseAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__9__Impl"


    // $ANTLR start "rule__Game__Group__10"
    // InternalArg.g:2761:1: rule__Game__Group__10 : rule__Game__Group__10__Impl rule__Game__Group__11 ;
    public final void rule__Game__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2765:1: ( rule__Game__Group__10__Impl rule__Game__Group__11 )
            // InternalArg.g:2766:2: rule__Game__Group__10__Impl rule__Game__Group__11
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__10"


    // $ANTLR start "rule__Game__Group__10__Impl"
    // InternalArg.g:2773:1: rule__Game__Group__10__Impl : ( 'score' ) ;
    public final void rule__Game__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2777:1: ( ( 'score' ) )
            // InternalArg.g:2778:1: ( 'score' )
            {
            // InternalArg.g:2778:1: ( 'score' )
            // InternalArg.g:2779:2: 'score'
            {
             before(grammarAccess.getGameAccess().getScoreKeyword_10()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getScoreKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__10__Impl"


    // $ANTLR start "rule__Game__Group__11"
    // InternalArg.g:2788:1: rule__Game__Group__11 : rule__Game__Group__11__Impl rule__Game__Group__12 ;
    public final void rule__Game__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2792:1: ( rule__Game__Group__11__Impl rule__Game__Group__12 )
            // InternalArg.g:2793:2: rule__Game__Group__11__Impl rule__Game__Group__12
            {
            pushFollow(FOLLOW_18);
            rule__Game__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__11"


    // $ANTLR start "rule__Game__Group__11__Impl"
    // InternalArg.g:2800:1: rule__Game__Group__11__Impl : ( '{' ) ;
    public final void rule__Game__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2804:1: ( ( '{' ) )
            // InternalArg.g:2805:1: ( '{' )
            {
            // InternalArg.g:2805:1: ( '{' )
            // InternalArg.g:2806:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_11()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__11__Impl"


    // $ANTLR start "rule__Game__Group__12"
    // InternalArg.g:2815:1: rule__Game__Group__12 : rule__Game__Group__12__Impl rule__Game__Group__13 ;
    public final void rule__Game__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2819:1: ( rule__Game__Group__12__Impl rule__Game__Group__13 )
            // InternalArg.g:2820:2: rule__Game__Group__12__Impl rule__Game__Group__13
            {
            pushFollow(FOLLOW_8);
            rule__Game__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__12"


    // $ANTLR start "rule__Game__Group__12__Impl"
    // InternalArg.g:2827:1: rule__Game__Group__12__Impl : ( ( rule__Game__ScoreAssignment_12 ) ) ;
    public final void rule__Game__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2831:1: ( ( ( rule__Game__ScoreAssignment_12 ) ) )
            // InternalArg.g:2832:1: ( ( rule__Game__ScoreAssignment_12 ) )
            {
            // InternalArg.g:2832:1: ( ( rule__Game__ScoreAssignment_12 ) )
            // InternalArg.g:2833:2: ( rule__Game__ScoreAssignment_12 )
            {
             before(grammarAccess.getGameAccess().getScoreAssignment_12()); 
            // InternalArg.g:2834:2: ( rule__Game__ScoreAssignment_12 )
            // InternalArg.g:2834:3: rule__Game__ScoreAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Game__ScoreAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getScoreAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__12__Impl"


    // $ANTLR start "rule__Game__Group__13"
    // InternalArg.g:2842:1: rule__Game__Group__13 : rule__Game__Group__13__Impl rule__Game__Group__14 ;
    public final void rule__Game__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2846:1: ( rule__Game__Group__13__Impl rule__Game__Group__14 )
            // InternalArg.g:2847:2: rule__Game__Group__13__Impl rule__Game__Group__14
            {
            pushFollow(FOLLOW_8);
            rule__Game__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__13"


    // $ANTLR start "rule__Game__Group__13__Impl"
    // InternalArg.g:2854:1: rule__Game__Group__13__Impl : ( '}' ) ;
    public final void rule__Game__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2858:1: ( ( '}' ) )
            // InternalArg.g:2859:1: ( '}' )
            {
            // InternalArg.g:2859:1: ( '}' )
            // InternalArg.g:2860:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_13()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__13__Impl"


    // $ANTLR start "rule__Game__Group__14"
    // InternalArg.g:2869:1: rule__Game__Group__14 : rule__Game__Group__14__Impl rule__Game__Group__15 ;
    public final void rule__Game__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2873:1: ( rule__Game__Group__14__Impl rule__Game__Group__15 )
            // InternalArg.g:2874:2: rule__Game__Group__14__Impl rule__Game__Group__15
            {
            pushFollow(FOLLOW_22);
            rule__Game__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__14"


    // $ANTLR start "rule__Game__Group__14__Impl"
    // InternalArg.g:2881:1: rule__Game__Group__14__Impl : ( '}' ) ;
    public final void rule__Game__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2885:1: ( ( '}' ) )
            // InternalArg.g:2886:1: ( '}' )
            {
            // InternalArg.g:2886:1: ( '}' )
            // InternalArg.g:2887:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_14()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__14__Impl"


    // $ANTLR start "rule__Game__Group__15"
    // InternalArg.g:2896:1: rule__Game__Group__15 : rule__Game__Group__15__Impl rule__Game__Group__16 ;
    public final void rule__Game__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2900:1: ( rule__Game__Group__15__Impl rule__Game__Group__16 )
            // InternalArg.g:2901:2: rule__Game__Group__15__Impl rule__Game__Group__16
            {
            pushFollow(FOLLOW_22);
            rule__Game__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__15"


    // $ANTLR start "rule__Game__Group__15__Impl"
    // InternalArg.g:2908:1: rule__Game__Group__15__Impl : ( ( rule__Game__Group_15__0 )? ) ;
    public final void rule__Game__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2912:1: ( ( ( rule__Game__Group_15__0 )? ) )
            // InternalArg.g:2913:1: ( ( rule__Game__Group_15__0 )? )
            {
            // InternalArg.g:2913:1: ( ( rule__Game__Group_15__0 )? )
            // InternalArg.g:2914:2: ( rule__Game__Group_15__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_15()); 
            // InternalArg.g:2915:2: ( rule__Game__Group_15__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalArg.g:2915:3: rule__Game__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__15__Impl"


    // $ANTLR start "rule__Game__Group__16"
    // InternalArg.g:2923:1: rule__Game__Group__16 : rule__Game__Group__16__Impl rule__Game__Group__17 ;
    public final void rule__Game__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2927:1: ( rule__Game__Group__16__Impl rule__Game__Group__17 )
            // InternalArg.g:2928:2: rule__Game__Group__16__Impl rule__Game__Group__17
            {
            pushFollow(FOLLOW_22);
            rule__Game__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__16"


    // $ANTLR start "rule__Game__Group__16__Impl"
    // InternalArg.g:2935:1: rule__Game__Group__16__Impl : ( ( rule__Game__Group_16__0 )? ) ;
    public final void rule__Game__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2939:1: ( ( ( rule__Game__Group_16__0 )? ) )
            // InternalArg.g:2940:1: ( ( rule__Game__Group_16__0 )? )
            {
            // InternalArg.g:2940:1: ( ( rule__Game__Group_16__0 )? )
            // InternalArg.g:2941:2: ( rule__Game__Group_16__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_16()); 
            // InternalArg.g:2942:2: ( rule__Game__Group_16__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==53) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalArg.g:2942:3: rule__Game__Group_16__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_16__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__16__Impl"


    // $ANTLR start "rule__Game__Group__17"
    // InternalArg.g:2950:1: rule__Game__Group__17 : rule__Game__Group__17__Impl rule__Game__Group__18 ;
    public final void rule__Game__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2954:1: ( rule__Game__Group__17__Impl rule__Game__Group__18 )
            // InternalArg.g:2955:2: rule__Game__Group__17__Impl rule__Game__Group__18
            {
            pushFollow(FOLLOW_22);
            rule__Game__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__17"


    // $ANTLR start "rule__Game__Group__17__Impl"
    // InternalArg.g:2962:1: rule__Game__Group__17__Impl : ( ( rule__Game__Group_17__0 )? ) ;
    public final void rule__Game__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2966:1: ( ( ( rule__Game__Group_17__0 )? ) )
            // InternalArg.g:2967:1: ( ( rule__Game__Group_17__0 )? )
            {
            // InternalArg.g:2967:1: ( ( rule__Game__Group_17__0 )? )
            // InternalArg.g:2968:2: ( rule__Game__Group_17__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_17()); 
            // InternalArg.g:2969:2: ( rule__Game__Group_17__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==54) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalArg.g:2969:3: rule__Game__Group_17__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_17__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__17__Impl"


    // $ANTLR start "rule__Game__Group__18"
    // InternalArg.g:2977:1: rule__Game__Group__18 : rule__Game__Group__18__Impl rule__Game__Group__19 ;
    public final void rule__Game__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2981:1: ( rule__Game__Group__18__Impl rule__Game__Group__19 )
            // InternalArg.g:2982:2: rule__Game__Group__18__Impl rule__Game__Group__19
            {
            pushFollow(FOLLOW_22);
            rule__Game__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__18"


    // $ANTLR start "rule__Game__Group__18__Impl"
    // InternalArg.g:2989:1: rule__Game__Group__18__Impl : ( ( rule__Game__Group_18__0 )? ) ;
    public final void rule__Game__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:2993:1: ( ( ( rule__Game__Group_18__0 )? ) )
            // InternalArg.g:2994:1: ( ( rule__Game__Group_18__0 )? )
            {
            // InternalArg.g:2994:1: ( ( rule__Game__Group_18__0 )? )
            // InternalArg.g:2995:2: ( rule__Game__Group_18__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_18()); 
            // InternalArg.g:2996:2: ( rule__Game__Group_18__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==55) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalArg.g:2996:3: rule__Game__Group_18__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_18__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__18__Impl"


    // $ANTLR start "rule__Game__Group__19"
    // InternalArg.g:3004:1: rule__Game__Group__19 : rule__Game__Group__19__Impl ;
    public final void rule__Game__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3008:1: ( rule__Game__Group__19__Impl )
            // InternalArg.g:3009:2: rule__Game__Group__19__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__19__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__19"


    // $ANTLR start "rule__Game__Group__19__Impl"
    // InternalArg.g:3015:1: rule__Game__Group__19__Impl : ( '}' ) ;
    public final void rule__Game__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3019:1: ( ( '}' ) )
            // InternalArg.g:3020:1: ( '}' )
            {
            // InternalArg.g:3020:1: ( '}' )
            // InternalArg.g:3021:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_19()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__19__Impl"


    // $ANTLR start "rule__Game__Group_15__0"
    // InternalArg.g:3031:1: rule__Game__Group_15__0 : rule__Game__Group_15__0__Impl rule__Game__Group_15__1 ;
    public final void rule__Game__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3035:1: ( rule__Game__Group_15__0__Impl rule__Game__Group_15__1 )
            // InternalArg.g:3036:2: rule__Game__Group_15__0__Impl rule__Game__Group_15__1
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__0"


    // $ANTLR start "rule__Game__Group_15__0__Impl"
    // InternalArg.g:3043:1: rule__Game__Group_15__0__Impl : ( 'Actions' ) ;
    public final void rule__Game__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3047:1: ( ( 'Actions' ) )
            // InternalArg.g:3048:1: ( 'Actions' )
            {
            // InternalArg.g:3048:1: ( 'Actions' )
            // InternalArg.g:3049:2: 'Actions'
            {
             before(grammarAccess.getGameAccess().getActionsKeyword_15_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getActionsKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__0__Impl"


    // $ANTLR start "rule__Game__Group_15__1"
    // InternalArg.g:3058:1: rule__Game__Group_15__1 : rule__Game__Group_15__1__Impl rule__Game__Group_15__2 ;
    public final void rule__Game__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3062:1: ( rule__Game__Group_15__1__Impl rule__Game__Group_15__2 )
            // InternalArg.g:3063:2: rule__Game__Group_15__1__Impl rule__Game__Group_15__2
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__1"


    // $ANTLR start "rule__Game__Group_15__1__Impl"
    // InternalArg.g:3070:1: rule__Game__Group_15__1__Impl : ( '{' ) ;
    public final void rule__Game__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3074:1: ( ( '{' ) )
            // InternalArg.g:3075:1: ( '{' )
            {
            // InternalArg.g:3075:1: ( '{' )
            // InternalArg.g:3076:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_15_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__1__Impl"


    // $ANTLR start "rule__Game__Group_15__2"
    // InternalArg.g:3085:1: rule__Game__Group_15__2 : rule__Game__Group_15__2__Impl rule__Game__Group_15__3 ;
    public final void rule__Game__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3089:1: ( rule__Game__Group_15__2__Impl rule__Game__Group_15__3 )
            // InternalArg.g:3090:2: rule__Game__Group_15__2__Impl rule__Game__Group_15__3
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__2"


    // $ANTLR start "rule__Game__Group_15__2__Impl"
    // InternalArg.g:3097:1: rule__Game__Group_15__2__Impl : ( ( rule__Game__ActionsTriggersAssignment_15_2 ) ) ;
    public final void rule__Game__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3101:1: ( ( ( rule__Game__ActionsTriggersAssignment_15_2 ) ) )
            // InternalArg.g:3102:1: ( ( rule__Game__ActionsTriggersAssignment_15_2 ) )
            {
            // InternalArg.g:3102:1: ( ( rule__Game__ActionsTriggersAssignment_15_2 ) )
            // InternalArg.g:3103:2: ( rule__Game__ActionsTriggersAssignment_15_2 )
            {
             before(grammarAccess.getGameAccess().getActionsTriggersAssignment_15_2()); 
            // InternalArg.g:3104:2: ( rule__Game__ActionsTriggersAssignment_15_2 )
            // InternalArg.g:3104:3: rule__Game__ActionsTriggersAssignment_15_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__ActionsTriggersAssignment_15_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getActionsTriggersAssignment_15_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__2__Impl"


    // $ANTLR start "rule__Game__Group_15__3"
    // InternalArg.g:3112:1: rule__Game__Group_15__3 : rule__Game__Group_15__3__Impl rule__Game__Group_15__4 ;
    public final void rule__Game__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3116:1: ( rule__Game__Group_15__3__Impl rule__Game__Group_15__4 )
            // InternalArg.g:3117:2: rule__Game__Group_15__3__Impl rule__Game__Group_15__4
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_15__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__3"


    // $ANTLR start "rule__Game__Group_15__3__Impl"
    // InternalArg.g:3124:1: rule__Game__Group_15__3__Impl : ( ( rule__Game__ActionsTriggersAssignment_15_3 )* ) ;
    public final void rule__Game__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3128:1: ( ( ( rule__Game__ActionsTriggersAssignment_15_3 )* ) )
            // InternalArg.g:3129:1: ( ( rule__Game__ActionsTriggersAssignment_15_3 )* )
            {
            // InternalArg.g:3129:1: ( ( rule__Game__ActionsTriggersAssignment_15_3 )* )
            // InternalArg.g:3130:2: ( rule__Game__ActionsTriggersAssignment_15_3 )*
            {
             before(grammarAccess.getGameAccess().getActionsTriggersAssignment_15_3()); 
            // InternalArg.g:3131:2: ( rule__Game__ActionsTriggersAssignment_15_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_ID)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalArg.g:3131:3: rule__Game__ActionsTriggersAssignment_15_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Game__ActionsTriggersAssignment_15_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getActionsTriggersAssignment_15_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__3__Impl"


    // $ANTLR start "rule__Game__Group_15__4"
    // InternalArg.g:3139:1: rule__Game__Group_15__4 : rule__Game__Group_15__4__Impl ;
    public final void rule__Game__Group_15__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3143:1: ( rule__Game__Group_15__4__Impl )
            // InternalArg.g:3144:2: rule__Game__Group_15__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_15__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__4"


    // $ANTLR start "rule__Game__Group_15__4__Impl"
    // InternalArg.g:3150:1: rule__Game__Group_15__4__Impl : ( '}' ) ;
    public final void rule__Game__Group_15__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3154:1: ( ( '}' ) )
            // InternalArg.g:3155:1: ( '}' )
            {
            // InternalArg.g:3155:1: ( '}' )
            // InternalArg.g:3156:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_15_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_15_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__4__Impl"


    // $ANTLR start "rule__Game__Group_16__0"
    // InternalArg.g:3166:1: rule__Game__Group_16__0 : rule__Game__Group_16__0__Impl rule__Game__Group_16__1 ;
    public final void rule__Game__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3170:1: ( rule__Game__Group_16__0__Impl rule__Game__Group_16__1 )
            // InternalArg.g:3171:2: rule__Game__Group_16__0__Impl rule__Game__Group_16__1
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_16__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__0"


    // $ANTLR start "rule__Game__Group_16__0__Impl"
    // InternalArg.g:3178:1: rule__Game__Group_16__0__Impl : ( 'Collisions' ) ;
    public final void rule__Game__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3182:1: ( ( 'Collisions' ) )
            // InternalArg.g:3183:1: ( 'Collisions' )
            {
            // InternalArg.g:3183:1: ( 'Collisions' )
            // InternalArg.g:3184:2: 'Collisions'
            {
             before(grammarAccess.getGameAccess().getCollisionsKeyword_16_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCollisionsKeyword_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__0__Impl"


    // $ANTLR start "rule__Game__Group_16__1"
    // InternalArg.g:3193:1: rule__Game__Group_16__1 : rule__Game__Group_16__1__Impl rule__Game__Group_16__2 ;
    public final void rule__Game__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3197:1: ( rule__Game__Group_16__1__Impl rule__Game__Group_16__2 )
            // InternalArg.g:3198:2: rule__Game__Group_16__1__Impl rule__Game__Group_16__2
            {
            pushFollow(FOLLOW_14);
            rule__Game__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_16__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__1"


    // $ANTLR start "rule__Game__Group_16__1__Impl"
    // InternalArg.g:3205:1: rule__Game__Group_16__1__Impl : ( '{' ) ;
    public final void rule__Game__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3209:1: ( ( '{' ) )
            // InternalArg.g:3210:1: ( '{' )
            {
            // InternalArg.g:3210:1: ( '{' )
            // InternalArg.g:3211:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_16_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_16_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__1__Impl"


    // $ANTLR start "rule__Game__Group_16__2"
    // InternalArg.g:3220:1: rule__Game__Group_16__2 : rule__Game__Group_16__2__Impl rule__Game__Group_16__3 ;
    public final void rule__Game__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3224:1: ( rule__Game__Group_16__2__Impl rule__Game__Group_16__3 )
            // InternalArg.g:3225:2: rule__Game__Group_16__2__Impl rule__Game__Group_16__3
            {
            pushFollow(FOLLOW_15);
            rule__Game__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_16__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__2"


    // $ANTLR start "rule__Game__Group_16__2__Impl"
    // InternalArg.g:3232:1: rule__Game__Group_16__2__Impl : ( ( rule__Game__CollisionsAssignment_16_2 ) ) ;
    public final void rule__Game__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3236:1: ( ( ( rule__Game__CollisionsAssignment_16_2 ) ) )
            // InternalArg.g:3237:1: ( ( rule__Game__CollisionsAssignment_16_2 ) )
            {
            // InternalArg.g:3237:1: ( ( rule__Game__CollisionsAssignment_16_2 ) )
            // InternalArg.g:3238:2: ( rule__Game__CollisionsAssignment_16_2 )
            {
             before(grammarAccess.getGameAccess().getCollisionsAssignment_16_2()); 
            // InternalArg.g:3239:2: ( rule__Game__CollisionsAssignment_16_2 )
            // InternalArg.g:3239:3: rule__Game__CollisionsAssignment_16_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__CollisionsAssignment_16_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getCollisionsAssignment_16_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__2__Impl"


    // $ANTLR start "rule__Game__Group_16__3"
    // InternalArg.g:3247:1: rule__Game__Group_16__3 : rule__Game__Group_16__3__Impl rule__Game__Group_16__4 ;
    public final void rule__Game__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3251:1: ( rule__Game__Group_16__3__Impl rule__Game__Group_16__4 )
            // InternalArg.g:3252:2: rule__Game__Group_16__3__Impl rule__Game__Group_16__4
            {
            pushFollow(FOLLOW_15);
            rule__Game__Group_16__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_16__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__3"


    // $ANTLR start "rule__Game__Group_16__3__Impl"
    // InternalArg.g:3259:1: rule__Game__Group_16__3__Impl : ( ( rule__Game__CollisionsAssignment_16_3 )* ) ;
    public final void rule__Game__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3263:1: ( ( ( rule__Game__CollisionsAssignment_16_3 )* ) )
            // InternalArg.g:3264:1: ( ( rule__Game__CollisionsAssignment_16_3 )* )
            {
            // InternalArg.g:3264:1: ( ( rule__Game__CollisionsAssignment_16_3 )* )
            // InternalArg.g:3265:2: ( rule__Game__CollisionsAssignment_16_3 )*
            {
             before(grammarAccess.getGameAccess().getCollisionsAssignment_16_3()); 
            // InternalArg.g:3266:2: ( rule__Game__CollisionsAssignment_16_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==66) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalArg.g:3266:3: rule__Game__CollisionsAssignment_16_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Game__CollisionsAssignment_16_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getCollisionsAssignment_16_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__3__Impl"


    // $ANTLR start "rule__Game__Group_16__4"
    // InternalArg.g:3274:1: rule__Game__Group_16__4 : rule__Game__Group_16__4__Impl ;
    public final void rule__Game__Group_16__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3278:1: ( rule__Game__Group_16__4__Impl )
            // InternalArg.g:3279:2: rule__Game__Group_16__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_16__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__4"


    // $ANTLR start "rule__Game__Group_16__4__Impl"
    // InternalArg.g:3285:1: rule__Game__Group_16__4__Impl : ( '}' ) ;
    public final void rule__Game__Group_16__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3289:1: ( ( '}' ) )
            // InternalArg.g:3290:1: ( '}' )
            {
            // InternalArg.g:3290:1: ( '}' )
            // InternalArg.g:3291:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_16_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_16_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_16__4__Impl"


    // $ANTLR start "rule__Game__Group_17__0"
    // InternalArg.g:3301:1: rule__Game__Group_17__0 : rule__Game__Group_17__0__Impl rule__Game__Group_17__1 ;
    public final void rule__Game__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3305:1: ( rule__Game__Group_17__0__Impl rule__Game__Group_17__1 )
            // InternalArg.g:3306:2: rule__Game__Group_17__0__Impl rule__Game__Group_17__1
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_17__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__0"


    // $ANTLR start "rule__Game__Group_17__0__Impl"
    // InternalArg.g:3313:1: rule__Game__Group_17__0__Impl : ( 'Buttons' ) ;
    public final void rule__Game__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3317:1: ( ( 'Buttons' ) )
            // InternalArg.g:3318:1: ( 'Buttons' )
            {
            // InternalArg.g:3318:1: ( 'Buttons' )
            // InternalArg.g:3319:2: 'Buttons'
            {
             before(grammarAccess.getGameAccess().getButtonsKeyword_17_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getButtonsKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__0__Impl"


    // $ANTLR start "rule__Game__Group_17__1"
    // InternalArg.g:3328:1: rule__Game__Group_17__1 : rule__Game__Group_17__1__Impl rule__Game__Group_17__2 ;
    public final void rule__Game__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3332:1: ( rule__Game__Group_17__1__Impl rule__Game__Group_17__2 )
            // InternalArg.g:3333:2: rule__Game__Group_17__1__Impl rule__Game__Group_17__2
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_17__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__1"


    // $ANTLR start "rule__Game__Group_17__1__Impl"
    // InternalArg.g:3340:1: rule__Game__Group_17__1__Impl : ( '{' ) ;
    public final void rule__Game__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3344:1: ( ( '{' ) )
            // InternalArg.g:3345:1: ( '{' )
            {
            // InternalArg.g:3345:1: ( '{' )
            // InternalArg.g:3346:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_17_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__1__Impl"


    // $ANTLR start "rule__Game__Group_17__2"
    // InternalArg.g:3355:1: rule__Game__Group_17__2 : rule__Game__Group_17__2__Impl rule__Game__Group_17__3 ;
    public final void rule__Game__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3359:1: ( rule__Game__Group_17__2__Impl rule__Game__Group_17__3 )
            // InternalArg.g:3360:2: rule__Game__Group_17__2__Impl rule__Game__Group_17__3
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_17__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__2"


    // $ANTLR start "rule__Game__Group_17__2__Impl"
    // InternalArg.g:3367:1: rule__Game__Group_17__2__Impl : ( ( rule__Game__GamepadAssignment_17_2 ) ) ;
    public final void rule__Game__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3371:1: ( ( ( rule__Game__GamepadAssignment_17_2 ) ) )
            // InternalArg.g:3372:1: ( ( rule__Game__GamepadAssignment_17_2 ) )
            {
            // InternalArg.g:3372:1: ( ( rule__Game__GamepadAssignment_17_2 ) )
            // InternalArg.g:3373:2: ( rule__Game__GamepadAssignment_17_2 )
            {
             before(grammarAccess.getGameAccess().getGamepadAssignment_17_2()); 
            // InternalArg.g:3374:2: ( rule__Game__GamepadAssignment_17_2 )
            // InternalArg.g:3374:3: rule__Game__GamepadAssignment_17_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__GamepadAssignment_17_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getGamepadAssignment_17_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__2__Impl"


    // $ANTLR start "rule__Game__Group_17__3"
    // InternalArg.g:3382:1: rule__Game__Group_17__3 : rule__Game__Group_17__3__Impl rule__Game__Group_17__4 ;
    public final void rule__Game__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3386:1: ( rule__Game__Group_17__3__Impl rule__Game__Group_17__4 )
            // InternalArg.g:3387:2: rule__Game__Group_17__3__Impl rule__Game__Group_17__4
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_17__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_17__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__3"


    // $ANTLR start "rule__Game__Group_17__3__Impl"
    // InternalArg.g:3394:1: rule__Game__Group_17__3__Impl : ( ( rule__Game__GamepadAssignment_17_3 )* ) ;
    public final void rule__Game__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3398:1: ( ( ( rule__Game__GamepadAssignment_17_3 )* ) )
            // InternalArg.g:3399:1: ( ( rule__Game__GamepadAssignment_17_3 )* )
            {
            // InternalArg.g:3399:1: ( ( rule__Game__GamepadAssignment_17_3 )* )
            // InternalArg.g:3400:2: ( rule__Game__GamepadAssignment_17_3 )*
            {
             before(grammarAccess.getGameAccess().getGamepadAssignment_17_3()); 
            // InternalArg.g:3401:2: ( rule__Game__GamepadAssignment_17_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalArg.g:3401:3: rule__Game__GamepadAssignment_17_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Game__GamepadAssignment_17_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGamepadAssignment_17_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__3__Impl"


    // $ANTLR start "rule__Game__Group_17__4"
    // InternalArg.g:3409:1: rule__Game__Group_17__4 : rule__Game__Group_17__4__Impl ;
    public final void rule__Game__Group_17__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3413:1: ( rule__Game__Group_17__4__Impl )
            // InternalArg.g:3414:2: rule__Game__Group_17__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_17__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__4"


    // $ANTLR start "rule__Game__Group_17__4__Impl"
    // InternalArg.g:3420:1: rule__Game__Group_17__4__Impl : ( '}' ) ;
    public final void rule__Game__Group_17__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3424:1: ( ( '}' ) )
            // InternalArg.g:3425:1: ( '}' )
            {
            // InternalArg.g:3425:1: ( '}' )
            // InternalArg.g:3426:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_17_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_17_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_17__4__Impl"


    // $ANTLR start "rule__Game__Group_18__0"
    // InternalArg.g:3436:1: rule__Game__Group_18__0 : rule__Game__Group_18__0__Impl rule__Game__Group_18__1 ;
    public final void rule__Game__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3440:1: ( rule__Game__Group_18__0__Impl rule__Game__Group_18__1 )
            // InternalArg.g:3441:2: rule__Game__Group_18__0__Impl rule__Game__Group_18__1
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_18__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__0"


    // $ANTLR start "rule__Game__Group_18__0__Impl"
    // InternalArg.g:3448:1: rule__Game__Group_18__0__Impl : ( 'Elements' ) ;
    public final void rule__Game__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3452:1: ( ( 'Elements' ) )
            // InternalArg.g:3453:1: ( 'Elements' )
            {
            // InternalArg.g:3453:1: ( 'Elements' )
            // InternalArg.g:3454:2: 'Elements'
            {
             before(grammarAccess.getGameAccess().getElementsKeyword_18_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getElementsKeyword_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__0__Impl"


    // $ANTLR start "rule__Game__Group_18__1"
    // InternalArg.g:3463:1: rule__Game__Group_18__1 : rule__Game__Group_18__1__Impl rule__Game__Group_18__2 ;
    public final void rule__Game__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3467:1: ( rule__Game__Group_18__1__Impl rule__Game__Group_18__2 )
            // InternalArg.g:3468:2: rule__Game__Group_18__1__Impl rule__Game__Group_18__2
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_18__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__1"


    // $ANTLR start "rule__Game__Group_18__1__Impl"
    // InternalArg.g:3475:1: rule__Game__Group_18__1__Impl : ( '{' ) ;
    public final void rule__Game__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3479:1: ( ( '{' ) )
            // InternalArg.g:3480:1: ( '{' )
            {
            // InternalArg.g:3480:1: ( '{' )
            // InternalArg.g:3481:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_18_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_18_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__1__Impl"


    // $ANTLR start "rule__Game__Group_18__2"
    // InternalArg.g:3490:1: rule__Game__Group_18__2 : rule__Game__Group_18__2__Impl rule__Game__Group_18__3 ;
    public final void rule__Game__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3494:1: ( rule__Game__Group_18__2__Impl rule__Game__Group_18__3 )
            // InternalArg.g:3495:2: rule__Game__Group_18__2__Impl rule__Game__Group_18__3
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_18__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__2"


    // $ANTLR start "rule__Game__Group_18__2__Impl"
    // InternalArg.g:3502:1: rule__Game__Group_18__2__Impl : ( ( rule__Game__ObjInitAssignment_18_2 ) ) ;
    public final void rule__Game__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3506:1: ( ( ( rule__Game__ObjInitAssignment_18_2 ) ) )
            // InternalArg.g:3507:1: ( ( rule__Game__ObjInitAssignment_18_2 ) )
            {
            // InternalArg.g:3507:1: ( ( rule__Game__ObjInitAssignment_18_2 ) )
            // InternalArg.g:3508:2: ( rule__Game__ObjInitAssignment_18_2 )
            {
             before(grammarAccess.getGameAccess().getObjInitAssignment_18_2()); 
            // InternalArg.g:3509:2: ( rule__Game__ObjInitAssignment_18_2 )
            // InternalArg.g:3509:3: rule__Game__ObjInitAssignment_18_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__ObjInitAssignment_18_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getObjInitAssignment_18_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__2__Impl"


    // $ANTLR start "rule__Game__Group_18__3"
    // InternalArg.g:3517:1: rule__Game__Group_18__3 : rule__Game__Group_18__3__Impl rule__Game__Group_18__4 ;
    public final void rule__Game__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3521:1: ( rule__Game__Group_18__3__Impl rule__Game__Group_18__4 )
            // InternalArg.g:3522:2: rule__Game__Group_18__3__Impl rule__Game__Group_18__4
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group_18__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_18__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__3"


    // $ANTLR start "rule__Game__Group_18__3__Impl"
    // InternalArg.g:3529:1: rule__Game__Group_18__3__Impl : ( ( rule__Game__ObjInitAssignment_18_3 )* ) ;
    public final void rule__Game__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3533:1: ( ( ( rule__Game__ObjInitAssignment_18_3 )* ) )
            // InternalArg.g:3534:1: ( ( rule__Game__ObjInitAssignment_18_3 )* )
            {
            // InternalArg.g:3534:1: ( ( rule__Game__ObjInitAssignment_18_3 )* )
            // InternalArg.g:3535:2: ( rule__Game__ObjInitAssignment_18_3 )*
            {
             before(grammarAccess.getGameAccess().getObjInitAssignment_18_3()); 
            // InternalArg.g:3536:2: ( rule__Game__ObjInitAssignment_18_3 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalArg.g:3536:3: rule__Game__ObjInitAssignment_18_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Game__ObjInitAssignment_18_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getObjInitAssignment_18_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__3__Impl"


    // $ANTLR start "rule__Game__Group_18__4"
    // InternalArg.g:3544:1: rule__Game__Group_18__4 : rule__Game__Group_18__4__Impl ;
    public final void rule__Game__Group_18__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3548:1: ( rule__Game__Group_18__4__Impl )
            // InternalArg.g:3549:2: rule__Game__Group_18__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_18__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__4"


    // $ANTLR start "rule__Game__Group_18__4__Impl"
    // InternalArg.g:3555:1: rule__Game__Group_18__4__Impl : ( '}' ) ;
    public final void rule__Game__Group_18__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3559:1: ( ( '}' ) )
            // InternalArg.g:3560:1: ( '}' )
            {
            // InternalArg.g:3560:1: ( '}' )
            // InternalArg.g:3561:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_18_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_18_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_18__4__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalArg.g:3571:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3575:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalArg.g:3576:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalArg.g:3583:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3587:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalArg.g:3588:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalArg.g:3588:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalArg.g:3589:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalArg.g:3590:2: ( rule__Attribute__NameAssignment_0 )
            // InternalArg.g:3590:3: rule__Attribute__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalArg.g:3598:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3602:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalArg.g:3603:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalArg.g:3610:1: rule__Attribute__Group__1__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3614:1: ( ( ':' ) )
            // InternalArg.g:3615:1: ( ':' )
            {
            // InternalArg.g:3615:1: ( ':' )
            // InternalArg.g:3616:2: ':'
            {
             before(grammarAccess.getAttributeAccess().getColonKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalArg.g:3625:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3629:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalArg.g:3630:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Attribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalArg.g:3637:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__TypeAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3641:1: ( ( ( rule__Attribute__TypeAssignment_2 ) ) )
            // InternalArg.g:3642:1: ( ( rule__Attribute__TypeAssignment_2 ) )
            {
            // InternalArg.g:3642:1: ( ( rule__Attribute__TypeAssignment_2 ) )
            // InternalArg.g:3643:2: ( rule__Attribute__TypeAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getTypeAssignment_2()); 
            // InternalArg.g:3644:2: ( rule__Attribute__TypeAssignment_2 )
            // InternalArg.g:3644:3: rule__Attribute__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalArg.g:3652:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3656:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalArg.g:3657:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Attribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalArg.g:3664:1: rule__Attribute__Group__3__Impl : ( '[' ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3668:1: ( ( '[' ) )
            // InternalArg.g:3669:1: ( '[' )
            {
            // InternalArg.g:3669:1: ( '[' )
            // InternalArg.g:3670:2: '['
            {
             before(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_3()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__4"
    // InternalArg.g:3679:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3683:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalArg.g:3684:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__Attribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4"


    // $ANTLR start "rule__Attribute__Group__4__Impl"
    // InternalArg.g:3691:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__MinAssignment_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3695:1: ( ( ( rule__Attribute__MinAssignment_4 ) ) )
            // InternalArg.g:3696:1: ( ( rule__Attribute__MinAssignment_4 ) )
            {
            // InternalArg.g:3696:1: ( ( rule__Attribute__MinAssignment_4 ) )
            // InternalArg.g:3697:2: ( rule__Attribute__MinAssignment_4 )
            {
             before(grammarAccess.getAttributeAccess().getMinAssignment_4()); 
            // InternalArg.g:3698:2: ( rule__Attribute__MinAssignment_4 )
            // InternalArg.g:3698:3: rule__Attribute__MinAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__MinAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getMinAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4__Impl"


    // $ANTLR start "rule__Attribute__Group__5"
    // InternalArg.g:3706:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3710:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalArg.g:3711:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__Attribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5"


    // $ANTLR start "rule__Attribute__Group__5__Impl"
    // InternalArg.g:3718:1: rule__Attribute__Group__5__Impl : ( '..' ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3722:1: ( ( '..' ) )
            // InternalArg.g:3723:1: ( '..' )
            {
            // InternalArg.g:3723:1: ( '..' )
            // InternalArg.g:3724:2: '..'
            {
             before(grammarAccess.getAttributeAccess().getFullStopFullStopKeyword_5()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getFullStopFullStopKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5__Impl"


    // $ANTLR start "rule__Attribute__Group__6"
    // InternalArg.g:3733:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3737:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalArg.g:3738:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
            {
            pushFollow(FOLLOW_28);
            rule__Attribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6"


    // $ANTLR start "rule__Attribute__Group__6__Impl"
    // InternalArg.g:3745:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__MaxAssignment_6 ) ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3749:1: ( ( ( rule__Attribute__MaxAssignment_6 ) ) )
            // InternalArg.g:3750:1: ( ( rule__Attribute__MaxAssignment_6 ) )
            {
            // InternalArg.g:3750:1: ( ( rule__Attribute__MaxAssignment_6 ) )
            // InternalArg.g:3751:2: ( rule__Attribute__MaxAssignment_6 )
            {
             before(grammarAccess.getAttributeAccess().getMaxAssignment_6()); 
            // InternalArg.g:3752:2: ( rule__Attribute__MaxAssignment_6 )
            // InternalArg.g:3752:3: rule__Attribute__MaxAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__MaxAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getMaxAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6__Impl"


    // $ANTLR start "rule__Attribute__Group__7"
    // InternalArg.g:3760:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl rule__Attribute__Group__8 ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3764:1: ( rule__Attribute__Group__7__Impl rule__Attribute__Group__8 )
            // InternalArg.g:3765:2: rule__Attribute__Group__7__Impl rule__Attribute__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__Attribute__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__7"


    // $ANTLR start "rule__Attribute__Group__7__Impl"
    // InternalArg.g:3772:1: rule__Attribute__Group__7__Impl : ( ']' ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3776:1: ( ( ']' ) )
            // InternalArg.g:3777:1: ( ']' )
            {
            // InternalArg.g:3777:1: ( ']' )
            // InternalArg.g:3778:2: ']'
            {
             before(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_7()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__7__Impl"


    // $ANTLR start "rule__Attribute__Group__8"
    // InternalArg.g:3787:1: rule__Attribute__Group__8 : rule__Attribute__Group__8__Impl rule__Attribute__Group__9 ;
    public final void rule__Attribute__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3791:1: ( rule__Attribute__Group__8__Impl rule__Attribute__Group__9 )
            // InternalArg.g:3792:2: rule__Attribute__Group__8__Impl rule__Attribute__Group__9
            {
            pushFollow(FOLLOW_30);
            rule__Attribute__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__8"


    // $ANTLR start "rule__Attribute__Group__8__Impl"
    // InternalArg.g:3799:1: rule__Attribute__Group__8__Impl : ( '=' ) ;
    public final void rule__Attribute__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3803:1: ( ( '=' ) )
            // InternalArg.g:3804:1: ( '=' )
            {
            // InternalArg.g:3804:1: ( '=' )
            // InternalArg.g:3805:2: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_8()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__8__Impl"


    // $ANTLR start "rule__Attribute__Group__9"
    // InternalArg.g:3814:1: rule__Attribute__Group__9 : rule__Attribute__Group__9__Impl rule__Attribute__Group__10 ;
    public final void rule__Attribute__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3818:1: ( rule__Attribute__Group__9__Impl rule__Attribute__Group__10 )
            // InternalArg.g:3819:2: rule__Attribute__Group__9__Impl rule__Attribute__Group__10
            {
            pushFollow(FOLLOW_31);
            rule__Attribute__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__9"


    // $ANTLR start "rule__Attribute__Group__9__Impl"
    // InternalArg.g:3826:1: rule__Attribute__Group__9__Impl : ( ( rule__Attribute__DefaultAssignment_9 ) ) ;
    public final void rule__Attribute__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3830:1: ( ( ( rule__Attribute__DefaultAssignment_9 ) ) )
            // InternalArg.g:3831:1: ( ( rule__Attribute__DefaultAssignment_9 ) )
            {
            // InternalArg.g:3831:1: ( ( rule__Attribute__DefaultAssignment_9 ) )
            // InternalArg.g:3832:2: ( rule__Attribute__DefaultAssignment_9 )
            {
             before(grammarAccess.getAttributeAccess().getDefaultAssignment_9()); 
            // InternalArg.g:3833:2: ( rule__Attribute__DefaultAssignment_9 )
            // InternalArg.g:3833:3: rule__Attribute__DefaultAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__DefaultAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getDefaultAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__9__Impl"


    // $ANTLR start "rule__Attribute__Group__10"
    // InternalArg.g:3841:1: rule__Attribute__Group__10 : rule__Attribute__Group__10__Impl rule__Attribute__Group__11 ;
    public final void rule__Attribute__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3845:1: ( rule__Attribute__Group__10__Impl rule__Attribute__Group__11 )
            // InternalArg.g:3846:2: rule__Attribute__Group__10__Impl rule__Attribute__Group__11
            {
            pushFollow(FOLLOW_31);
            rule__Attribute__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__10"


    // $ANTLR start "rule__Attribute__Group__10__Impl"
    // InternalArg.g:3853:1: rule__Attribute__Group__10__Impl : ( ( rule__Attribute__IsParamAssignment_10 )? ) ;
    public final void rule__Attribute__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3857:1: ( ( ( rule__Attribute__IsParamAssignment_10 )? ) )
            // InternalArg.g:3858:1: ( ( rule__Attribute__IsParamAssignment_10 )? )
            {
            // InternalArg.g:3858:1: ( ( rule__Attribute__IsParamAssignment_10 )? )
            // InternalArg.g:3859:2: ( rule__Attribute__IsParamAssignment_10 )?
            {
             before(grammarAccess.getAttributeAccess().getIsParamAssignment_10()); 
            // InternalArg.g:3860:2: ( rule__Attribute__IsParamAssignment_10 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==118) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalArg.g:3860:3: rule__Attribute__IsParamAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__IsParamAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getIsParamAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__10__Impl"


    // $ANTLR start "rule__Attribute__Group__11"
    // InternalArg.g:3868:1: rule__Attribute__Group__11 : rule__Attribute__Group__11__Impl rule__Attribute__Group__12 ;
    public final void rule__Attribute__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3872:1: ( rule__Attribute__Group__11__Impl rule__Attribute__Group__12 )
            // InternalArg.g:3873:2: rule__Attribute__Group__11__Impl rule__Attribute__Group__12
            {
            pushFollow(FOLLOW_31);
            rule__Attribute__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__11"


    // $ANTLR start "rule__Attribute__Group__11__Impl"
    // InternalArg.g:3880:1: rule__Attribute__Group__11__Impl : ( ( rule__Attribute__IsKeyAssignment_11 )? ) ;
    public final void rule__Attribute__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3884:1: ( ( ( rule__Attribute__IsKeyAssignment_11 )? ) )
            // InternalArg.g:3885:1: ( ( rule__Attribute__IsKeyAssignment_11 )? )
            {
            // InternalArg.g:3885:1: ( ( rule__Attribute__IsKeyAssignment_11 )? )
            // InternalArg.g:3886:2: ( rule__Attribute__IsKeyAssignment_11 )?
            {
             before(grammarAccess.getAttributeAccess().getIsKeyAssignment_11()); 
            // InternalArg.g:3887:2: ( rule__Attribute__IsKeyAssignment_11 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==119) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalArg.g:3887:3: rule__Attribute__IsKeyAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__IsKeyAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getIsKeyAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__11__Impl"


    // $ANTLR start "rule__Attribute__Group__12"
    // InternalArg.g:3895:1: rule__Attribute__Group__12 : rule__Attribute__Group__12__Impl ;
    public final void rule__Attribute__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3899:1: ( rule__Attribute__Group__12__Impl )
            // InternalArg.g:3900:2: rule__Attribute__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__12"


    // $ANTLR start "rule__Attribute__Group__12__Impl"
    // InternalArg.g:3906:1: rule__Attribute__Group__12__Impl : ( ( rule__Attribute__ReadOnlyAssignment_12 )? ) ;
    public final void rule__Attribute__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3910:1: ( ( ( rule__Attribute__ReadOnlyAssignment_12 )? ) )
            // InternalArg.g:3911:1: ( ( rule__Attribute__ReadOnlyAssignment_12 )? )
            {
            // InternalArg.g:3911:1: ( ( rule__Attribute__ReadOnlyAssignment_12 )? )
            // InternalArg.g:3912:2: ( rule__Attribute__ReadOnlyAssignment_12 )?
            {
             before(grammarAccess.getAttributeAccess().getReadOnlyAssignment_12()); 
            // InternalArg.g:3913:2: ( rule__Attribute__ReadOnlyAssignment_12 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==120) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalArg.g:3913:3: rule__Attribute__ReadOnlyAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__ReadOnlyAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getReadOnlyAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__12__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalArg.g:3922:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3926:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalArg.g:3927:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalArg.g:3934:1: rule__Reference__Group__0__Impl : ( ( rule__Reference__NameAssignment_0 ) ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3938:1: ( ( ( rule__Reference__NameAssignment_0 ) ) )
            // InternalArg.g:3939:1: ( ( rule__Reference__NameAssignment_0 ) )
            {
            // InternalArg.g:3939:1: ( ( rule__Reference__NameAssignment_0 ) )
            // InternalArg.g:3940:2: ( rule__Reference__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_0()); 
            // InternalArg.g:3941:2: ( rule__Reference__NameAssignment_0 )
            // InternalArg.g:3941:3: rule__Reference__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Reference__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalArg.g:3949:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3953:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalArg.g:3954:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalArg.g:3961:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__Group_1__0 )? ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3965:1: ( ( ( rule__Reference__Group_1__0 )? ) )
            // InternalArg.g:3966:1: ( ( rule__Reference__Group_1__0 )? )
            {
            // InternalArg.g:3966:1: ( ( rule__Reference__Group_1__0 )? )
            // InternalArg.g:3967:2: ( rule__Reference__Group_1__0 )?
            {
             before(grammarAccess.getReferenceAccess().getGroup_1()); 
            // InternalArg.g:3968:2: ( rule__Reference__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==63) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalArg.g:3968:3: rule__Reference__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Reference__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // InternalArg.g:3976:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3980:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalArg.g:3981:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // InternalArg.g:3988:1: rule__Reference__Group__2__Impl : ( 'min' ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:3992:1: ( ( 'min' ) )
            // InternalArg.g:3993:1: ( 'min' )
            {
            // InternalArg.g:3993:1: ( 'min' )
            // InternalArg.g:3994:2: 'min'
            {
             before(grammarAccess.getReferenceAccess().getMinKeyword_2()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getMinKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // InternalArg.g:4003:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4007:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // InternalArg.g:4008:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_33);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // InternalArg.g:4015:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__MinAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4019:1: ( ( ( rule__Reference__MinAssignment_3 ) ) )
            // InternalArg.g:4020:1: ( ( rule__Reference__MinAssignment_3 ) )
            {
            // InternalArg.g:4020:1: ( ( rule__Reference__MinAssignment_3 ) )
            // InternalArg.g:4021:2: ( rule__Reference__MinAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getMinAssignment_3()); 
            // InternalArg.g:4022:2: ( rule__Reference__MinAssignment_3 )
            // InternalArg.g:4022:3: rule__Reference__MinAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Reference__MinAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getMinAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // InternalArg.g:4030:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl rule__Reference__Group__5 ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4034:1: ( rule__Reference__Group__4__Impl rule__Reference__Group__5 )
            // InternalArg.g:4035:2: rule__Reference__Group__4__Impl rule__Reference__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Reference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // InternalArg.g:4042:1: rule__Reference__Group__4__Impl : ( 'max' ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4046:1: ( ( 'max' ) )
            // InternalArg.g:4047:1: ( 'max' )
            {
            // InternalArg.g:4047:1: ( 'max' )
            // InternalArg.g:4048:2: 'max'
            {
             before(grammarAccess.getReferenceAccess().getMaxKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getMaxKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group__5"
    // InternalArg.g:4057:1: rule__Reference__Group__5 : rule__Reference__Group__5__Impl rule__Reference__Group__6 ;
    public final void rule__Reference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4061:1: ( rule__Reference__Group__5__Impl rule__Reference__Group__6 )
            // InternalArg.g:4062:2: rule__Reference__Group__5__Impl rule__Reference__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__Reference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__5"


    // $ANTLR start "rule__Reference__Group__5__Impl"
    // InternalArg.g:4069:1: rule__Reference__Group__5__Impl : ( ( rule__Reference__MaxAssignment_5 ) ) ;
    public final void rule__Reference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4073:1: ( ( ( rule__Reference__MaxAssignment_5 ) ) )
            // InternalArg.g:4074:1: ( ( rule__Reference__MaxAssignment_5 ) )
            {
            // InternalArg.g:4074:1: ( ( rule__Reference__MaxAssignment_5 ) )
            // InternalArg.g:4075:2: ( rule__Reference__MaxAssignment_5 )
            {
             before(grammarAccess.getReferenceAccess().getMaxAssignment_5()); 
            // InternalArg.g:4076:2: ( rule__Reference__MaxAssignment_5 )
            // InternalArg.g:4076:3: rule__Reference__MaxAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Reference__MaxAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getMaxAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__5__Impl"


    // $ANTLR start "rule__Reference__Group__6"
    // InternalArg.g:4084:1: rule__Reference__Group__6 : rule__Reference__Group__6__Impl rule__Reference__Group__7 ;
    public final void rule__Reference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4088:1: ( rule__Reference__Group__6__Impl rule__Reference__Group__7 )
            // InternalArg.g:4089:2: rule__Reference__Group__6__Impl rule__Reference__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Reference__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__6"


    // $ANTLR start "rule__Reference__Group__6__Impl"
    // InternalArg.g:4096:1: rule__Reference__Group__6__Impl : ( 'target' ) ;
    public final void rule__Reference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4100:1: ( ( 'target' ) )
            // InternalArg.g:4101:1: ( 'target' )
            {
            // InternalArg.g:4101:1: ( 'target' )
            // InternalArg.g:4102:2: 'target'
            {
             before(grammarAccess.getReferenceAccess().getTargetKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getTargetKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__6__Impl"


    // $ANTLR start "rule__Reference__Group__7"
    // InternalArg.g:4111:1: rule__Reference__Group__7 : rule__Reference__Group__7__Impl rule__Reference__Group__8 ;
    public final void rule__Reference__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4115:1: ( rule__Reference__Group__7__Impl rule__Reference__Group__8 )
            // InternalArg.g:4116:2: rule__Reference__Group__7__Impl rule__Reference__Group__8
            {
            pushFollow(FOLLOW_35);
            rule__Reference__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__7"


    // $ANTLR start "rule__Reference__Group__7__Impl"
    // InternalArg.g:4123:1: rule__Reference__Group__7__Impl : ( ( rule__Reference__TargetAssignment_7 ) ) ;
    public final void rule__Reference__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4127:1: ( ( ( rule__Reference__TargetAssignment_7 ) ) )
            // InternalArg.g:4128:1: ( ( rule__Reference__TargetAssignment_7 ) )
            {
            // InternalArg.g:4128:1: ( ( rule__Reference__TargetAssignment_7 ) )
            // InternalArg.g:4129:2: ( rule__Reference__TargetAssignment_7 )
            {
             before(grammarAccess.getReferenceAccess().getTargetAssignment_7()); 
            // InternalArg.g:4130:2: ( rule__Reference__TargetAssignment_7 )
            // InternalArg.g:4130:3: rule__Reference__TargetAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Reference__TargetAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTargetAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__7__Impl"


    // $ANTLR start "rule__Reference__Group__8"
    // InternalArg.g:4138:1: rule__Reference__Group__8 : rule__Reference__Group__8__Impl ;
    public final void rule__Reference__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4142:1: ( rule__Reference__Group__8__Impl )
            // InternalArg.g:4143:2: rule__Reference__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__8"


    // $ANTLR start "rule__Reference__Group__8__Impl"
    // InternalArg.g:4149:1: rule__Reference__Group__8__Impl : ( ( rule__Reference__Group_8__0 )? ) ;
    public final void rule__Reference__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4153:1: ( ( ( rule__Reference__Group_8__0 )? ) )
            // InternalArg.g:4154:1: ( ( rule__Reference__Group_8__0 )? )
            {
            // InternalArg.g:4154:1: ( ( rule__Reference__Group_8__0 )? )
            // InternalArg.g:4155:2: ( rule__Reference__Group_8__0 )?
            {
             before(grammarAccess.getReferenceAccess().getGroup_8()); 
            // InternalArg.g:4156:2: ( rule__Reference__Group_8__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==64) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalArg.g:4156:3: rule__Reference__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Reference__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__8__Impl"


    // $ANTLR start "rule__Reference__Group_1__0"
    // InternalArg.g:4165:1: rule__Reference__Group_1__0 : rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1 ;
    public final void rule__Reference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4169:1: ( rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1 )
            // InternalArg.g:4170:2: rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__Reference__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__0"


    // $ANTLR start "rule__Reference__Group_1__0__Impl"
    // InternalArg.g:4177:1: rule__Reference__Group_1__0__Impl : ( 'containtment' ) ;
    public final void rule__Reference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4181:1: ( ( 'containtment' ) )
            // InternalArg.g:4182:1: ( 'containtment' )
            {
            // InternalArg.g:4182:1: ( 'containtment' )
            // InternalArg.g:4183:2: 'containtment'
            {
             before(grammarAccess.getReferenceAccess().getContaintmentKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getContaintmentKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_1__1"
    // InternalArg.g:4192:1: rule__Reference__Group_1__1 : rule__Reference__Group_1__1__Impl ;
    public final void rule__Reference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4196:1: ( rule__Reference__Group_1__1__Impl )
            // InternalArg.g:4197:2: rule__Reference__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__1"


    // $ANTLR start "rule__Reference__Group_1__1__Impl"
    // InternalArg.g:4203:1: rule__Reference__Group_1__1__Impl : ( ( rule__Reference__ContaintmentAssignment_1_1 ) ) ;
    public final void rule__Reference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4207:1: ( ( ( rule__Reference__ContaintmentAssignment_1_1 ) ) )
            // InternalArg.g:4208:1: ( ( rule__Reference__ContaintmentAssignment_1_1 ) )
            {
            // InternalArg.g:4208:1: ( ( rule__Reference__ContaintmentAssignment_1_1 ) )
            // InternalArg.g:4209:2: ( rule__Reference__ContaintmentAssignment_1_1 )
            {
             before(grammarAccess.getReferenceAccess().getContaintmentAssignment_1_1()); 
            // InternalArg.g:4210:2: ( rule__Reference__ContaintmentAssignment_1_1 )
            // InternalArg.g:4210:3: rule__Reference__ContaintmentAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Reference__ContaintmentAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getContaintmentAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_8__0"
    // InternalArg.g:4219:1: rule__Reference__Group_8__0 : rule__Reference__Group_8__0__Impl rule__Reference__Group_8__1 ;
    public final void rule__Reference__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4223:1: ( rule__Reference__Group_8__0__Impl rule__Reference__Group_8__1 )
            // InternalArg.g:4224:2: rule__Reference__Group_8__0__Impl rule__Reference__Group_8__1
            {
            pushFollow(FOLLOW_3);
            rule__Reference__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_8__0"


    // $ANTLR start "rule__Reference__Group_8__0__Impl"
    // InternalArg.g:4231:1: rule__Reference__Group_8__0__Impl : ( 'opposite' ) ;
    public final void rule__Reference__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4235:1: ( ( 'opposite' ) )
            // InternalArg.g:4236:1: ( 'opposite' )
            {
            // InternalArg.g:4236:1: ( 'opposite' )
            // InternalArg.g:4237:2: 'opposite'
            {
             before(grammarAccess.getReferenceAccess().getOppositeKeyword_8_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getOppositeKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_8__0__Impl"


    // $ANTLR start "rule__Reference__Group_8__1"
    // InternalArg.g:4246:1: rule__Reference__Group_8__1 : rule__Reference__Group_8__1__Impl ;
    public final void rule__Reference__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4250:1: ( rule__Reference__Group_8__1__Impl )
            // InternalArg.g:4251:2: rule__Reference__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_8__1"


    // $ANTLR start "rule__Reference__Group_8__1__Impl"
    // InternalArg.g:4257:1: rule__Reference__Group_8__1__Impl : ( ( rule__Reference__OppositeAssignment_8_1 ) ) ;
    public final void rule__Reference__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4261:1: ( ( ( rule__Reference__OppositeAssignment_8_1 ) ) )
            // InternalArg.g:4262:1: ( ( rule__Reference__OppositeAssignment_8_1 ) )
            {
            // InternalArg.g:4262:1: ( ( rule__Reference__OppositeAssignment_8_1 ) )
            // InternalArg.g:4263:2: ( rule__Reference__OppositeAssignment_8_1 )
            {
             before(grammarAccess.getReferenceAccess().getOppositeAssignment_8_1()); 
            // InternalArg.g:4264:2: ( rule__Reference__OppositeAssignment_8_1 )
            // InternalArg.g:4264:3: rule__Reference__OppositeAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Reference__OppositeAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getOppositeAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_8__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalArg.g:4273:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4277:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalArg.g:4278:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalArg.g:4285:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4289:1: ( ( ( '-' )? ) )
            // InternalArg.g:4290:1: ( ( '-' )? )
            {
            // InternalArg.g:4290:1: ( ( '-' )? )
            // InternalArg.g:4291:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalArg.g:4292:2: ( '-' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==65) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalArg.g:4292:3: '-'
                    {
                    match(input,65,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalArg.g:4300:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4304:1: ( rule__EInt__Group__1__Impl )
            // InternalArg.g:4305:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalArg.g:4311:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4315:1: ( ( RULE_INT ) )
            // InternalArg.g:4316:1: ( RULE_INT )
            {
            // InternalArg.g:4316:1: ( RULE_INT )
            // InternalArg.g:4317:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__GraphicClass__Group__0"
    // InternalArg.g:4327:1: rule__GraphicClass__Group__0 : rule__GraphicClass__Group__0__Impl rule__GraphicClass__Group__1 ;
    public final void rule__GraphicClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4331:1: ( rule__GraphicClass__Group__0__Impl rule__GraphicClass__Group__1 )
            // InternalArg.g:4332:2: rule__GraphicClass__Group__0__Impl rule__GraphicClass__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__GraphicClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__0"


    // $ANTLR start "rule__GraphicClass__Group__0__Impl"
    // InternalArg.g:4339:1: rule__GraphicClass__Group__0__Impl : ( 'element' ) ;
    public final void rule__GraphicClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4343:1: ( ( 'element' ) )
            // InternalArg.g:4344:1: ( 'element' )
            {
            // InternalArg.g:4344:1: ( 'element' )
            // InternalArg.g:4345:2: 'element'
            {
             before(grammarAccess.getGraphicClassAccess().getElementKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getElementKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__0__Impl"


    // $ANTLR start "rule__GraphicClass__Group__1"
    // InternalArg.g:4354:1: rule__GraphicClass__Group__1 : rule__GraphicClass__Group__1__Impl rule__GraphicClass__Group__2 ;
    public final void rule__GraphicClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4358:1: ( rule__GraphicClass__Group__1__Impl rule__GraphicClass__Group__2 )
            // InternalArg.g:4359:2: rule__GraphicClass__Group__1__Impl rule__GraphicClass__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__GraphicClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__1"


    // $ANTLR start "rule__GraphicClass__Group__1__Impl"
    // InternalArg.g:4366:1: rule__GraphicClass__Group__1__Impl : ( ( rule__GraphicClass__OntoClassAssignment_1 ) ) ;
    public final void rule__GraphicClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4370:1: ( ( ( rule__GraphicClass__OntoClassAssignment_1 ) ) )
            // InternalArg.g:4371:1: ( ( rule__GraphicClass__OntoClassAssignment_1 ) )
            {
            // InternalArg.g:4371:1: ( ( rule__GraphicClass__OntoClassAssignment_1 ) )
            // InternalArg.g:4372:2: ( rule__GraphicClass__OntoClassAssignment_1 )
            {
             before(grammarAccess.getGraphicClassAccess().getOntoClassAssignment_1()); 
            // InternalArg.g:4373:2: ( rule__GraphicClass__OntoClassAssignment_1 )
            // InternalArg.g:4373:3: rule__GraphicClass__OntoClassAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GraphicClass__OntoClassAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGraphicClassAccess().getOntoClassAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__1__Impl"


    // $ANTLR start "rule__GraphicClass__Group__2"
    // InternalArg.g:4381:1: rule__GraphicClass__Group__2 : rule__GraphicClass__Group__2__Impl rule__GraphicClass__Group__3 ;
    public final void rule__GraphicClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4385:1: ( rule__GraphicClass__Group__2__Impl rule__GraphicClass__Group__3 )
            // InternalArg.g:4386:2: rule__GraphicClass__Group__2__Impl rule__GraphicClass__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__GraphicClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__2"


    // $ANTLR start "rule__GraphicClass__Group__2__Impl"
    // InternalArg.g:4393:1: rule__GraphicClass__Group__2__Impl : ( 'versions' ) ;
    public final void rule__GraphicClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4397:1: ( ( 'versions' ) )
            // InternalArg.g:4398:1: ( 'versions' )
            {
            // InternalArg.g:4398:1: ( 'versions' )
            // InternalArg.g:4399:2: 'versions'
            {
             before(grammarAccess.getGraphicClassAccess().getVersionsKeyword_2()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getVersionsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__2__Impl"


    // $ANTLR start "rule__GraphicClass__Group__3"
    // InternalArg.g:4408:1: rule__GraphicClass__Group__3 : rule__GraphicClass__Group__3__Impl rule__GraphicClass__Group__4 ;
    public final void rule__GraphicClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4412:1: ( rule__GraphicClass__Group__3__Impl rule__GraphicClass__Group__4 )
            // InternalArg.g:4413:2: rule__GraphicClass__Group__3__Impl rule__GraphicClass__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__GraphicClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__3"


    // $ANTLR start "rule__GraphicClass__Group__3__Impl"
    // InternalArg.g:4420:1: rule__GraphicClass__Group__3__Impl : ( '{' ) ;
    public final void rule__GraphicClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4424:1: ( ( '{' ) )
            // InternalArg.g:4425:1: ( '{' )
            {
            // InternalArg.g:4425:1: ( '{' )
            // InternalArg.g:4426:2: '{'
            {
             before(grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__3__Impl"


    // $ANTLR start "rule__GraphicClass__Group__4"
    // InternalArg.g:4435:1: rule__GraphicClass__Group__4 : rule__GraphicClass__Group__4__Impl rule__GraphicClass__Group__5 ;
    public final void rule__GraphicClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4439:1: ( rule__GraphicClass__Group__4__Impl rule__GraphicClass__Group__5 )
            // InternalArg.g:4440:2: rule__GraphicClass__Group__4__Impl rule__GraphicClass__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__GraphicClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__4"


    // $ANTLR start "rule__GraphicClass__Group__4__Impl"
    // InternalArg.g:4447:1: rule__GraphicClass__Group__4__Impl : ( ( rule__GraphicClass__VersionsAssignment_4 ) ) ;
    public final void rule__GraphicClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4451:1: ( ( ( rule__GraphicClass__VersionsAssignment_4 ) ) )
            // InternalArg.g:4452:1: ( ( rule__GraphicClass__VersionsAssignment_4 ) )
            {
            // InternalArg.g:4452:1: ( ( rule__GraphicClass__VersionsAssignment_4 ) )
            // InternalArg.g:4453:2: ( rule__GraphicClass__VersionsAssignment_4 )
            {
             before(grammarAccess.getGraphicClassAccess().getVersionsAssignment_4()); 
            // InternalArg.g:4454:2: ( rule__GraphicClass__VersionsAssignment_4 )
            // InternalArg.g:4454:3: rule__GraphicClass__VersionsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__GraphicClass__VersionsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGraphicClassAccess().getVersionsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__4__Impl"


    // $ANTLR start "rule__GraphicClass__Group__5"
    // InternalArg.g:4462:1: rule__GraphicClass__Group__5 : rule__GraphicClass__Group__5__Impl rule__GraphicClass__Group__6 ;
    public final void rule__GraphicClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4466:1: ( rule__GraphicClass__Group__5__Impl rule__GraphicClass__Group__6 )
            // InternalArg.g:4467:2: rule__GraphicClass__Group__5__Impl rule__GraphicClass__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__GraphicClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__5"


    // $ANTLR start "rule__GraphicClass__Group__5__Impl"
    // InternalArg.g:4474:1: rule__GraphicClass__Group__5__Impl : ( ( rule__GraphicClass__VersionsAssignment_5 )* ) ;
    public final void rule__GraphicClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4478:1: ( ( ( rule__GraphicClass__VersionsAssignment_5 )* ) )
            // InternalArg.g:4479:1: ( ( rule__GraphicClass__VersionsAssignment_5 )* )
            {
            // InternalArg.g:4479:1: ( ( rule__GraphicClass__VersionsAssignment_5 )* )
            // InternalArg.g:4480:2: ( rule__GraphicClass__VersionsAssignment_5 )*
            {
             before(grammarAccess.getGraphicClassAccess().getVersionsAssignment_5()); 
            // InternalArg.g:4481:2: ( rule__GraphicClass__VersionsAssignment_5 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalArg.g:4481:3: rule__GraphicClass__VersionsAssignment_5
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__GraphicClass__VersionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getGraphicClassAccess().getVersionsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__5__Impl"


    // $ANTLR start "rule__GraphicClass__Group__6"
    // InternalArg.g:4489:1: rule__GraphicClass__Group__6 : rule__GraphicClass__Group__6__Impl rule__GraphicClass__Group__7 ;
    public final void rule__GraphicClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4493:1: ( rule__GraphicClass__Group__6__Impl rule__GraphicClass__Group__7 )
            // InternalArg.g:4494:2: rule__GraphicClass__Group__6__Impl rule__GraphicClass__Group__7
            {
            pushFollow(FOLLOW_37);
            rule__GraphicClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__6"


    // $ANTLR start "rule__GraphicClass__Group__6__Impl"
    // InternalArg.g:4501:1: rule__GraphicClass__Group__6__Impl : ( '}' ) ;
    public final void rule__GraphicClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4505:1: ( ( '}' ) )
            // InternalArg.g:4506:1: ( '}' )
            {
            // InternalArg.g:4506:1: ( '}' )
            // InternalArg.g:4507:2: '}'
            {
             before(grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_6()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__6__Impl"


    // $ANTLR start "rule__GraphicClass__Group__7"
    // InternalArg.g:4516:1: rule__GraphicClass__Group__7 : rule__GraphicClass__Group__7__Impl rule__GraphicClass__Group__8 ;
    public final void rule__GraphicClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4520:1: ( rule__GraphicClass__Group__7__Impl rule__GraphicClass__Group__8 )
            // InternalArg.g:4521:2: rule__GraphicClass__Group__7__Impl rule__GraphicClass__Group__8
            {
            pushFollow(FOLLOW_4);
            rule__GraphicClass__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__7"


    // $ANTLR start "rule__GraphicClass__Group__7__Impl"
    // InternalArg.g:4528:1: rule__GraphicClass__Group__7__Impl : ( 'constraints' ) ;
    public final void rule__GraphicClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4532:1: ( ( 'constraints' ) )
            // InternalArg.g:4533:1: ( 'constraints' )
            {
            // InternalArg.g:4533:1: ( 'constraints' )
            // InternalArg.g:4534:2: 'constraints'
            {
             before(grammarAccess.getGraphicClassAccess().getConstraintsKeyword_7()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getConstraintsKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__7__Impl"


    // $ANTLR start "rule__GraphicClass__Group__8"
    // InternalArg.g:4543:1: rule__GraphicClass__Group__8 : rule__GraphicClass__Group__8__Impl rule__GraphicClass__Group__9 ;
    public final void rule__GraphicClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4547:1: ( rule__GraphicClass__Group__8__Impl rule__GraphicClass__Group__9 )
            // InternalArg.g:4548:2: rule__GraphicClass__Group__8__Impl rule__GraphicClass__Group__9
            {
            pushFollow(FOLLOW_38);
            rule__GraphicClass__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__8"


    // $ANTLR start "rule__GraphicClass__Group__8__Impl"
    // InternalArg.g:4555:1: rule__GraphicClass__Group__8__Impl : ( '{' ) ;
    public final void rule__GraphicClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4559:1: ( ( '{' ) )
            // InternalArg.g:4560:1: ( '{' )
            {
            // InternalArg.g:4560:1: ( '{' )
            // InternalArg.g:4561:2: '{'
            {
             before(grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__8__Impl"


    // $ANTLR start "rule__GraphicClass__Group__9"
    // InternalArg.g:4570:1: rule__GraphicClass__Group__9 : rule__GraphicClass__Group__9__Impl rule__GraphicClass__Group__10 ;
    public final void rule__GraphicClass__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4574:1: ( rule__GraphicClass__Group__9__Impl rule__GraphicClass__Group__10 )
            // InternalArg.g:4575:2: rule__GraphicClass__Group__9__Impl rule__GraphicClass__Group__10
            {
            pushFollow(FOLLOW_8);
            rule__GraphicClass__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__9"


    // $ANTLR start "rule__GraphicClass__Group__9__Impl"
    // InternalArg.g:4582:1: rule__GraphicClass__Group__9__Impl : ( ( rule__GraphicClass__ConstraintsAssignment_9 ) ) ;
    public final void rule__GraphicClass__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4586:1: ( ( ( rule__GraphicClass__ConstraintsAssignment_9 ) ) )
            // InternalArg.g:4587:1: ( ( rule__GraphicClass__ConstraintsAssignment_9 ) )
            {
            // InternalArg.g:4587:1: ( ( rule__GraphicClass__ConstraintsAssignment_9 ) )
            // InternalArg.g:4588:2: ( rule__GraphicClass__ConstraintsAssignment_9 )
            {
             before(grammarAccess.getGraphicClassAccess().getConstraintsAssignment_9()); 
            // InternalArg.g:4589:2: ( rule__GraphicClass__ConstraintsAssignment_9 )
            // InternalArg.g:4589:3: rule__GraphicClass__ConstraintsAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__GraphicClass__ConstraintsAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getGraphicClassAccess().getConstraintsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__9__Impl"


    // $ANTLR start "rule__GraphicClass__Group__10"
    // InternalArg.g:4597:1: rule__GraphicClass__Group__10 : rule__GraphicClass__Group__10__Impl ;
    public final void rule__GraphicClass__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4601:1: ( rule__GraphicClass__Group__10__Impl )
            // InternalArg.g:4602:2: rule__GraphicClass__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GraphicClass__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__10"


    // $ANTLR start "rule__GraphicClass__Group__10__Impl"
    // InternalArg.g:4608:1: rule__GraphicClass__Group__10__Impl : ( '}' ) ;
    public final void rule__GraphicClass__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4612:1: ( ( '}' ) )
            // InternalArg.g:4613:1: ( '}' )
            {
            // InternalArg.g:4613:1: ( '}' )
            // InternalArg.g:4614:2: '}'
            {
             before(grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_10()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__Group__10__Impl"


    // $ANTLR start "rule__Constraints__Group__0"
    // InternalArg.g:4624:1: rule__Constraints__Group__0 : rule__Constraints__Group__0__Impl rule__Constraints__Group__1 ;
    public final void rule__Constraints__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4628:1: ( rule__Constraints__Group__0__Impl rule__Constraints__Group__1 )
            // InternalArg.g:4629:2: rule__Constraints__Group__0__Impl rule__Constraints__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__Constraints__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__0"


    // $ANTLR start "rule__Constraints__Group__0__Impl"
    // InternalArg.g:4636:1: rule__Constraints__Group__0__Impl : ( 'plane' ) ;
    public final void rule__Constraints__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4640:1: ( ( 'plane' ) )
            // InternalArg.g:4641:1: ( 'plane' )
            {
            // InternalArg.g:4641:1: ( 'plane' )
            // InternalArg.g:4642:2: 'plane'
            {
             before(grammarAccess.getConstraintsAccess().getPlaneKeyword_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getPlaneKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__0__Impl"


    // $ANTLR start "rule__Constraints__Group__1"
    // InternalArg.g:4651:1: rule__Constraints__Group__1 : rule__Constraints__Group__1__Impl rule__Constraints__Group__2 ;
    public final void rule__Constraints__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4655:1: ( rule__Constraints__Group__1__Impl rule__Constraints__Group__2 )
            // InternalArg.g:4656:2: rule__Constraints__Group__1__Impl rule__Constraints__Group__2
            {
            pushFollow(FOLLOW_40);
            rule__Constraints__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__1"


    // $ANTLR start "rule__Constraints__Group__1__Impl"
    // InternalArg.g:4663:1: rule__Constraints__Group__1__Impl : ( ( rule__Constraints__PlanesAssignment_1 ) ) ;
    public final void rule__Constraints__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4667:1: ( ( ( rule__Constraints__PlanesAssignment_1 ) ) )
            // InternalArg.g:4668:1: ( ( rule__Constraints__PlanesAssignment_1 ) )
            {
            // InternalArg.g:4668:1: ( ( rule__Constraints__PlanesAssignment_1 ) )
            // InternalArg.g:4669:2: ( rule__Constraints__PlanesAssignment_1 )
            {
             before(grammarAccess.getConstraintsAccess().getPlanesAssignment_1()); 
            // InternalArg.g:4670:2: ( rule__Constraints__PlanesAssignment_1 )
            // InternalArg.g:4670:3: rule__Constraints__PlanesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__PlanesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getPlanesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__1__Impl"


    // $ANTLR start "rule__Constraints__Group__2"
    // InternalArg.g:4678:1: rule__Constraints__Group__2 : rule__Constraints__Group__2__Impl rule__Constraints__Group__3 ;
    public final void rule__Constraints__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4682:1: ( rule__Constraints__Group__2__Impl rule__Constraints__Group__3 )
            // InternalArg.g:4683:2: rule__Constraints__Group__2__Impl rule__Constraints__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__Constraints__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__2"


    // $ANTLR start "rule__Constraints__Group__2__Impl"
    // InternalArg.g:4690:1: rule__Constraints__Group__2__Impl : ( ( rule__Constraints__OverlappingAssignment_2 ) ) ;
    public final void rule__Constraints__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4694:1: ( ( ( rule__Constraints__OverlappingAssignment_2 ) ) )
            // InternalArg.g:4695:1: ( ( rule__Constraints__OverlappingAssignment_2 ) )
            {
            // InternalArg.g:4695:1: ( ( rule__Constraints__OverlappingAssignment_2 ) )
            // InternalArg.g:4696:2: ( rule__Constraints__OverlappingAssignment_2 )
            {
             before(grammarAccess.getConstraintsAccess().getOverlappingAssignment_2()); 
            // InternalArg.g:4697:2: ( rule__Constraints__OverlappingAssignment_2 )
            // InternalArg.g:4697:3: rule__Constraints__OverlappingAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__OverlappingAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getOverlappingAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__2__Impl"


    // $ANTLR start "rule__Constraints__Group__3"
    // InternalArg.g:4705:1: rule__Constraints__Group__3 : rule__Constraints__Group__3__Impl rule__Constraints__Group__4 ;
    public final void rule__Constraints__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4709:1: ( rule__Constraints__Group__3__Impl rule__Constraints__Group__4 )
            // InternalArg.g:4710:2: rule__Constraints__Group__3__Impl rule__Constraints__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__Constraints__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__3"


    // $ANTLR start "rule__Constraints__Group__3__Impl"
    // InternalArg.g:4717:1: rule__Constraints__Group__3__Impl : ( 'sizeMin' ) ;
    public final void rule__Constraints__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4721:1: ( ( 'sizeMin' ) )
            // InternalArg.g:4722:1: ( 'sizeMin' )
            {
            // InternalArg.g:4722:1: ( 'sizeMin' )
            // InternalArg.g:4723:2: 'sizeMin'
            {
             before(grammarAccess.getConstraintsAccess().getSizeMinKeyword_3()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getSizeMinKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__3__Impl"


    // $ANTLR start "rule__Constraints__Group__4"
    // InternalArg.g:4732:1: rule__Constraints__Group__4 : rule__Constraints__Group__4__Impl rule__Constraints__Group__5 ;
    public final void rule__Constraints__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4736:1: ( rule__Constraints__Group__4__Impl rule__Constraints__Group__5 )
            // InternalArg.g:4737:2: rule__Constraints__Group__4__Impl rule__Constraints__Group__5
            {
            pushFollow(FOLLOW_43);
            rule__Constraints__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__4"


    // $ANTLR start "rule__Constraints__Group__4__Impl"
    // InternalArg.g:4744:1: rule__Constraints__Group__4__Impl : ( ( rule__Constraints__SizeMinAssignment_4 ) ) ;
    public final void rule__Constraints__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4748:1: ( ( ( rule__Constraints__SizeMinAssignment_4 ) ) )
            // InternalArg.g:4749:1: ( ( rule__Constraints__SizeMinAssignment_4 ) )
            {
            // InternalArg.g:4749:1: ( ( rule__Constraints__SizeMinAssignment_4 ) )
            // InternalArg.g:4750:2: ( rule__Constraints__SizeMinAssignment_4 )
            {
             before(grammarAccess.getConstraintsAccess().getSizeMinAssignment_4()); 
            // InternalArg.g:4751:2: ( rule__Constraints__SizeMinAssignment_4 )
            // InternalArg.g:4751:3: rule__Constraints__SizeMinAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__SizeMinAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getSizeMinAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__4__Impl"


    // $ANTLR start "rule__Constraints__Group__5"
    // InternalArg.g:4759:1: rule__Constraints__Group__5 : rule__Constraints__Group__5__Impl rule__Constraints__Group__6 ;
    public final void rule__Constraints__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4763:1: ( rule__Constraints__Group__5__Impl rule__Constraints__Group__6 )
            // InternalArg.g:4764:2: rule__Constraints__Group__5__Impl rule__Constraints__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__Constraints__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__5"


    // $ANTLR start "rule__Constraints__Group__5__Impl"
    // InternalArg.g:4771:1: rule__Constraints__Group__5__Impl : ( 'sizeMax' ) ;
    public final void rule__Constraints__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4775:1: ( ( 'sizeMax' ) )
            // InternalArg.g:4776:1: ( 'sizeMax' )
            {
            // InternalArg.g:4776:1: ( 'sizeMax' )
            // InternalArg.g:4777:2: 'sizeMax'
            {
             before(grammarAccess.getConstraintsAccess().getSizeMaxKeyword_5()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getSizeMaxKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__5__Impl"


    // $ANTLR start "rule__Constraints__Group__6"
    // InternalArg.g:4786:1: rule__Constraints__Group__6 : rule__Constraints__Group__6__Impl rule__Constraints__Group__7 ;
    public final void rule__Constraints__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4790:1: ( rule__Constraints__Group__6__Impl rule__Constraints__Group__7 )
            // InternalArg.g:4791:2: rule__Constraints__Group__6__Impl rule__Constraints__Group__7
            {
            pushFollow(FOLLOW_44);
            rule__Constraints__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__6"


    // $ANTLR start "rule__Constraints__Group__6__Impl"
    // InternalArg.g:4798:1: rule__Constraints__Group__6__Impl : ( ( rule__Constraints__SizeMaxAssignment_6 ) ) ;
    public final void rule__Constraints__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4802:1: ( ( ( rule__Constraints__SizeMaxAssignment_6 ) ) )
            // InternalArg.g:4803:1: ( ( rule__Constraints__SizeMaxAssignment_6 ) )
            {
            // InternalArg.g:4803:1: ( ( rule__Constraints__SizeMaxAssignment_6 ) )
            // InternalArg.g:4804:2: ( rule__Constraints__SizeMaxAssignment_6 )
            {
             before(grammarAccess.getConstraintsAccess().getSizeMaxAssignment_6()); 
            // InternalArg.g:4805:2: ( rule__Constraints__SizeMaxAssignment_6 )
            // InternalArg.g:4805:3: rule__Constraints__SizeMaxAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__SizeMaxAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getSizeMaxAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__6__Impl"


    // $ANTLR start "rule__Constraints__Group__7"
    // InternalArg.g:4813:1: rule__Constraints__Group__7 : rule__Constraints__Group__7__Impl rule__Constraints__Group__8 ;
    public final void rule__Constraints__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4817:1: ( rule__Constraints__Group__7__Impl rule__Constraints__Group__8 )
            // InternalArg.g:4818:2: rule__Constraints__Group__7__Impl rule__Constraints__Group__8
            {
            pushFollow(FOLLOW_42);
            rule__Constraints__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__7"


    // $ANTLR start "rule__Constraints__Group__7__Impl"
    // InternalArg.g:4825:1: rule__Constraints__Group__7__Impl : ( 'xVariation' ) ;
    public final void rule__Constraints__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4829:1: ( ( 'xVariation' ) )
            // InternalArg.g:4830:1: ( 'xVariation' )
            {
            // InternalArg.g:4830:1: ( 'xVariation' )
            // InternalArg.g:4831:2: 'xVariation'
            {
             before(grammarAccess.getConstraintsAccess().getXVariationKeyword_7()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getXVariationKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__7__Impl"


    // $ANTLR start "rule__Constraints__Group__8"
    // InternalArg.g:4840:1: rule__Constraints__Group__8 : rule__Constraints__Group__8__Impl rule__Constraints__Group__9 ;
    public final void rule__Constraints__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4844:1: ( rule__Constraints__Group__8__Impl rule__Constraints__Group__9 )
            // InternalArg.g:4845:2: rule__Constraints__Group__8__Impl rule__Constraints__Group__9
            {
            pushFollow(FOLLOW_45);
            rule__Constraints__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__8"


    // $ANTLR start "rule__Constraints__Group__8__Impl"
    // InternalArg.g:4852:1: rule__Constraints__Group__8__Impl : ( ( rule__Constraints__XToOriginPosAssignment_8 ) ) ;
    public final void rule__Constraints__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4856:1: ( ( ( rule__Constraints__XToOriginPosAssignment_8 ) ) )
            // InternalArg.g:4857:1: ( ( rule__Constraints__XToOriginPosAssignment_8 ) )
            {
            // InternalArg.g:4857:1: ( ( rule__Constraints__XToOriginPosAssignment_8 ) )
            // InternalArg.g:4858:2: ( rule__Constraints__XToOriginPosAssignment_8 )
            {
             before(grammarAccess.getConstraintsAccess().getXToOriginPosAssignment_8()); 
            // InternalArg.g:4859:2: ( rule__Constraints__XToOriginPosAssignment_8 )
            // InternalArg.g:4859:3: rule__Constraints__XToOriginPosAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__XToOriginPosAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getXToOriginPosAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__8__Impl"


    // $ANTLR start "rule__Constraints__Group__9"
    // InternalArg.g:4867:1: rule__Constraints__Group__9 : rule__Constraints__Group__9__Impl rule__Constraints__Group__10 ;
    public final void rule__Constraints__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4871:1: ( rule__Constraints__Group__9__Impl rule__Constraints__Group__10 )
            // InternalArg.g:4872:2: rule__Constraints__Group__9__Impl rule__Constraints__Group__10
            {
            pushFollow(FOLLOW_42);
            rule__Constraints__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__9"


    // $ANTLR start "rule__Constraints__Group__9__Impl"
    // InternalArg.g:4879:1: rule__Constraints__Group__9__Impl : ( 'yVariation' ) ;
    public final void rule__Constraints__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4883:1: ( ( 'yVariation' ) )
            // InternalArg.g:4884:1: ( 'yVariation' )
            {
            // InternalArg.g:4884:1: ( 'yVariation' )
            // InternalArg.g:4885:2: 'yVariation'
            {
             before(grammarAccess.getConstraintsAccess().getYVariationKeyword_9()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getYVariationKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__9__Impl"


    // $ANTLR start "rule__Constraints__Group__10"
    // InternalArg.g:4894:1: rule__Constraints__Group__10 : rule__Constraints__Group__10__Impl rule__Constraints__Group__11 ;
    public final void rule__Constraints__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4898:1: ( rule__Constraints__Group__10__Impl rule__Constraints__Group__11 )
            // InternalArg.g:4899:2: rule__Constraints__Group__10__Impl rule__Constraints__Group__11
            {
            pushFollow(FOLLOW_46);
            rule__Constraints__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__10"


    // $ANTLR start "rule__Constraints__Group__10__Impl"
    // InternalArg.g:4906:1: rule__Constraints__Group__10__Impl : ( ( rule__Constraints__YToOriginPosAssignment_10 ) ) ;
    public final void rule__Constraints__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4910:1: ( ( ( rule__Constraints__YToOriginPosAssignment_10 ) ) )
            // InternalArg.g:4911:1: ( ( rule__Constraints__YToOriginPosAssignment_10 ) )
            {
            // InternalArg.g:4911:1: ( ( rule__Constraints__YToOriginPosAssignment_10 ) )
            // InternalArg.g:4912:2: ( rule__Constraints__YToOriginPosAssignment_10 )
            {
             before(grammarAccess.getConstraintsAccess().getYToOriginPosAssignment_10()); 
            // InternalArg.g:4913:2: ( rule__Constraints__YToOriginPosAssignment_10 )
            // InternalArg.g:4913:3: rule__Constraints__YToOriginPosAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__YToOriginPosAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getYToOriginPosAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__10__Impl"


    // $ANTLR start "rule__Constraints__Group__11"
    // InternalArg.g:4921:1: rule__Constraints__Group__11 : rule__Constraints__Group__11__Impl rule__Constraints__Group__12 ;
    public final void rule__Constraints__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4925:1: ( rule__Constraints__Group__11__Impl rule__Constraints__Group__12 )
            // InternalArg.g:4926:2: rule__Constraints__Group__11__Impl rule__Constraints__Group__12
            {
            pushFollow(FOLLOW_42);
            rule__Constraints__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__11"


    // $ANTLR start "rule__Constraints__Group__11__Impl"
    // InternalArg.g:4933:1: rule__Constraints__Group__11__Impl : ( 'zVariation' ) ;
    public final void rule__Constraints__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4937:1: ( ( 'zVariation' ) )
            // InternalArg.g:4938:1: ( 'zVariation' )
            {
            // InternalArg.g:4938:1: ( 'zVariation' )
            // InternalArg.g:4939:2: 'zVariation'
            {
             before(grammarAccess.getConstraintsAccess().getZVariationKeyword_11()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getZVariationKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__11__Impl"


    // $ANTLR start "rule__Constraints__Group__12"
    // InternalArg.g:4948:1: rule__Constraints__Group__12 : rule__Constraints__Group__12__Impl rule__Constraints__Group__13 ;
    public final void rule__Constraints__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4952:1: ( rule__Constraints__Group__12__Impl rule__Constraints__Group__13 )
            // InternalArg.g:4953:2: rule__Constraints__Group__12__Impl rule__Constraints__Group__13
            {
            pushFollow(FOLLOW_47);
            rule__Constraints__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__12"


    // $ANTLR start "rule__Constraints__Group__12__Impl"
    // InternalArg.g:4960:1: rule__Constraints__Group__12__Impl : ( ( rule__Constraints__ZToOriginPosAssignment_12 ) ) ;
    public final void rule__Constraints__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4964:1: ( ( ( rule__Constraints__ZToOriginPosAssignment_12 ) ) )
            // InternalArg.g:4965:1: ( ( rule__Constraints__ZToOriginPosAssignment_12 ) )
            {
            // InternalArg.g:4965:1: ( ( rule__Constraints__ZToOriginPosAssignment_12 ) )
            // InternalArg.g:4966:2: ( rule__Constraints__ZToOriginPosAssignment_12 )
            {
             before(grammarAccess.getConstraintsAccess().getZToOriginPosAssignment_12()); 
            // InternalArg.g:4967:2: ( rule__Constraints__ZToOriginPosAssignment_12 )
            // InternalArg.g:4967:3: rule__Constraints__ZToOriginPosAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__ZToOriginPosAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getZToOriginPosAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__12__Impl"


    // $ANTLR start "rule__Constraints__Group__13"
    // InternalArg.g:4975:1: rule__Constraints__Group__13 : rule__Constraints__Group__13__Impl rule__Constraints__Group__14 ;
    public final void rule__Constraints__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4979:1: ( rule__Constraints__Group__13__Impl rule__Constraints__Group__14 )
            // InternalArg.g:4980:2: rule__Constraints__Group__13__Impl rule__Constraints__Group__14
            {
            pushFollow(FOLLOW_25);
            rule__Constraints__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraints__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__13"


    // $ANTLR start "rule__Constraints__Group__13__Impl"
    // InternalArg.g:4987:1: rule__Constraints__Group__13__Impl : ( 'rotation' ) ;
    public final void rule__Constraints__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:4991:1: ( ( 'rotation' ) )
            // InternalArg.g:4992:1: ( 'rotation' )
            {
            // InternalArg.g:4992:1: ( 'rotation' )
            // InternalArg.g:4993:2: 'rotation'
            {
             before(grammarAccess.getConstraintsAccess().getRotationKeyword_13()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getRotationKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__13__Impl"


    // $ANTLR start "rule__Constraints__Group__14"
    // InternalArg.g:5002:1: rule__Constraints__Group__14 : rule__Constraints__Group__14__Impl ;
    public final void rule__Constraints__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5006:1: ( rule__Constraints__Group__14__Impl )
            // InternalArg.g:5007:2: rule__Constraints__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__14"


    // $ANTLR start "rule__Constraints__Group__14__Impl"
    // InternalArg.g:5013:1: rule__Constraints__Group__14__Impl : ( ( rule__Constraints__RotationAssignment_14 ) ) ;
    public final void rule__Constraints__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5017:1: ( ( ( rule__Constraints__RotationAssignment_14 ) ) )
            // InternalArg.g:5018:1: ( ( rule__Constraints__RotationAssignment_14 ) )
            {
            // InternalArg.g:5018:1: ( ( rule__Constraints__RotationAssignment_14 ) )
            // InternalArg.g:5019:2: ( rule__Constraints__RotationAssignment_14 )
            {
             before(grammarAccess.getConstraintsAccess().getRotationAssignment_14()); 
            // InternalArg.g:5020:2: ( rule__Constraints__RotationAssignment_14 )
            // InternalArg.g:5020:3: rule__Constraints__RotationAssignment_14
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__RotationAssignment_14();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getRotationAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__Group__14__Impl"


    // $ANTLR start "rule__Versions__Group__0"
    // InternalArg.g:5029:1: rule__Versions__Group__0 : rule__Versions__Group__0__Impl rule__Versions__Group__1 ;
    public final void rule__Versions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5033:1: ( rule__Versions__Group__0__Impl rule__Versions__Group__1 )
            // InternalArg.g:5034:2: rule__Versions__Group__0__Impl rule__Versions__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__Versions__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Versions__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__0"


    // $ANTLR start "rule__Versions__Group__0__Impl"
    // InternalArg.g:5041:1: rule__Versions__Group__0__Impl : ( ( rule__Versions__NameAssignment_0 ) ) ;
    public final void rule__Versions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5045:1: ( ( ( rule__Versions__NameAssignment_0 ) ) )
            // InternalArg.g:5046:1: ( ( rule__Versions__NameAssignment_0 ) )
            {
            // InternalArg.g:5046:1: ( ( rule__Versions__NameAssignment_0 ) )
            // InternalArg.g:5047:2: ( rule__Versions__NameAssignment_0 )
            {
             before(grammarAccess.getVersionsAccess().getNameAssignment_0()); 
            // InternalArg.g:5048:2: ( rule__Versions__NameAssignment_0 )
            // InternalArg.g:5048:3: rule__Versions__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Versions__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getVersionsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__0__Impl"


    // $ANTLR start "rule__Versions__Group__1"
    // InternalArg.g:5056:1: rule__Versions__Group__1 : rule__Versions__Group__1__Impl rule__Versions__Group__2 ;
    public final void rule__Versions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5060:1: ( rule__Versions__Group__1__Impl rule__Versions__Group__2 )
            // InternalArg.g:5061:2: rule__Versions__Group__1__Impl rule__Versions__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Versions__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Versions__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__1"


    // $ANTLR start "rule__Versions__Group__1__Impl"
    // InternalArg.g:5068:1: rule__Versions__Group__1__Impl : ( '=' ) ;
    public final void rule__Versions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5072:1: ( ( '=' ) )
            // InternalArg.g:5073:1: ( '=' )
            {
            // InternalArg.g:5073:1: ( '=' )
            // InternalArg.g:5074:2: '='
            {
             before(grammarAccess.getVersionsAccess().getEqualsSignKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getVersionsAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__1__Impl"


    // $ANTLR start "rule__Versions__Group__2"
    // InternalArg.g:5083:1: rule__Versions__Group__2 : rule__Versions__Group__2__Impl ;
    public final void rule__Versions__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5087:1: ( rule__Versions__Group__2__Impl )
            // InternalArg.g:5088:2: rule__Versions__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Versions__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__2"


    // $ANTLR start "rule__Versions__Group__2__Impl"
    // InternalArg.g:5094:1: rule__Versions__Group__2__Impl : ( ( rule__Versions__URLAssignment_2 ) ) ;
    public final void rule__Versions__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5098:1: ( ( ( rule__Versions__URLAssignment_2 ) ) )
            // InternalArg.g:5099:1: ( ( rule__Versions__URLAssignment_2 ) )
            {
            // InternalArg.g:5099:1: ( ( rule__Versions__URLAssignment_2 ) )
            // InternalArg.g:5100:2: ( rule__Versions__URLAssignment_2 )
            {
             before(grammarAccess.getVersionsAccess().getURLAssignment_2()); 
            // InternalArg.g:5101:2: ( rule__Versions__URLAssignment_2 )
            // InternalArg.g:5101:3: rule__Versions__URLAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Versions__URLAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVersionsAccess().getURLAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalArg.g:5110:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5114:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalArg.g:5115:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // InternalArg.g:5122:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5126:1: ( ( ( '-' )? ) )
            // InternalArg.g:5127:1: ( ( '-' )? )
            {
            // InternalArg.g:5127:1: ( ( '-' )? )
            // InternalArg.g:5128:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalArg.g:5129:2: ( '-' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==65) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalArg.g:5129:3: '-'
                    {
                    match(input,65,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // InternalArg.g:5137:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5141:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalArg.g:5142:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_42);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // InternalArg.g:5149:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5153:1: ( ( ( RULE_INT )? ) )
            // InternalArg.g:5154:1: ( ( RULE_INT )? )
            {
            // InternalArg.g:5154:1: ( ( RULE_INT )? )
            // InternalArg.g:5155:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalArg.g:5156:2: ( RULE_INT )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_INT) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalArg.g:5156:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // InternalArg.g:5164:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5168:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalArg.g:5169:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_48);
            rule__EDouble__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // InternalArg.g:5176:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5180:1: ( ( '.' ) )
            // InternalArg.g:5181:1: ( '.' )
            {
            // InternalArg.g:5181:1: ( '.' )
            // InternalArg.g:5182:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__3"
    // InternalArg.g:5191:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5195:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalArg.g:5196:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_49);
            rule__EDouble__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__3"


    // $ANTLR start "rule__EDouble__Group__3__Impl"
    // InternalArg.g:5203:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5207:1: ( ( RULE_INT ) )
            // InternalArg.g:5208:1: ( RULE_INT )
            {
            // InternalArg.g:5208:1: ( RULE_INT )
            // InternalArg.g:5209:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__3__Impl"


    // $ANTLR start "rule__EDouble__Group__4"
    // InternalArg.g:5218:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5222:1: ( rule__EDouble__Group__4__Impl )
            // InternalArg.g:5223:2: rule__EDouble__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__4"


    // $ANTLR start "rule__EDouble__Group__4__Impl"
    // InternalArg.g:5229:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5233:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalArg.g:5234:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalArg.g:5234:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalArg.g:5235:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalArg.g:5236:2: ( rule__EDouble__Group_4__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=12 && LA43_0<=13)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalArg.g:5236:3: rule__EDouble__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__4__Impl"


    // $ANTLR start "rule__EDouble__Group_4__0"
    // InternalArg.g:5245:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5249:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalArg.g:5250:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_25);
            rule__EDouble__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__0"


    // $ANTLR start "rule__EDouble__Group_4__0__Impl"
    // InternalArg.g:5257:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5261:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalArg.g:5262:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalArg.g:5262:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalArg.g:5263:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalArg.g:5264:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalArg.g:5264:3: rule__EDouble__Alternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Alternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__0__Impl"


    // $ANTLR start "rule__EDouble__Group_4__1"
    // InternalArg.g:5272:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5276:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalArg.g:5277:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_25);
            rule__EDouble__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__1"


    // $ANTLR start "rule__EDouble__Group_4__1__Impl"
    // InternalArg.g:5284:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5288:1: ( ( ( '-' )? ) )
            // InternalArg.g:5289:1: ( ( '-' )? )
            {
            // InternalArg.g:5289:1: ( ( '-' )? )
            // InternalArg.g:5290:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalArg.g:5291:2: ( '-' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==65) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalArg.g:5291:3: '-'
                    {
                    match(input,65,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__1__Impl"


    // $ANTLR start "rule__EDouble__Group_4__2"
    // InternalArg.g:5299:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5303:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalArg.g:5304:2: rule__EDouble__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__2"


    // $ANTLR start "rule__EDouble__Group_4__2__Impl"
    // InternalArg.g:5310:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5314:1: ( ( RULE_INT ) )
            // InternalArg.g:5315:1: ( RULE_INT )
            {
            // InternalArg.g:5315:1: ( RULE_INT )
            // InternalArg.g:5316:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__2__Impl"


    // $ANTLR start "rule__PhysicClass__Group__0"
    // InternalArg.g:5326:1: rule__PhysicClass__Group__0 : rule__PhysicClass__Group__0__Impl rule__PhysicClass__Group__1 ;
    public final void rule__PhysicClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5330:1: ( rule__PhysicClass__Group__0__Impl rule__PhysicClass__Group__1 )
            // InternalArg.g:5331:2: rule__PhysicClass__Group__0__Impl rule__PhysicClass__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PhysicClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__0"


    // $ANTLR start "rule__PhysicClass__Group__0__Impl"
    // InternalArg.g:5338:1: rule__PhysicClass__Group__0__Impl : ( 'element' ) ;
    public final void rule__PhysicClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5342:1: ( ( 'element' ) )
            // InternalArg.g:5343:1: ( 'element' )
            {
            // InternalArg.g:5343:1: ( 'element' )
            // InternalArg.g:5344:2: 'element'
            {
             before(grammarAccess.getPhysicClassAccess().getElementKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getElementKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__0__Impl"


    // $ANTLR start "rule__PhysicClass__Group__1"
    // InternalArg.g:5353:1: rule__PhysicClass__Group__1 : rule__PhysicClass__Group__1__Impl rule__PhysicClass__Group__2 ;
    public final void rule__PhysicClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5357:1: ( rule__PhysicClass__Group__1__Impl rule__PhysicClass__Group__2 )
            // InternalArg.g:5358:2: rule__PhysicClass__Group__1__Impl rule__PhysicClass__Group__2
            {
            pushFollow(FOLLOW_50);
            rule__PhysicClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__1"


    // $ANTLR start "rule__PhysicClass__Group__1__Impl"
    // InternalArg.g:5365:1: rule__PhysicClass__Group__1__Impl : ( ( rule__PhysicClass__OntoClassAssignment_1 ) ) ;
    public final void rule__PhysicClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5369:1: ( ( ( rule__PhysicClass__OntoClassAssignment_1 ) ) )
            // InternalArg.g:5370:1: ( ( rule__PhysicClass__OntoClassAssignment_1 ) )
            {
            // InternalArg.g:5370:1: ( ( rule__PhysicClass__OntoClassAssignment_1 ) )
            // InternalArg.g:5371:2: ( rule__PhysicClass__OntoClassAssignment_1 )
            {
             before(grammarAccess.getPhysicClassAccess().getOntoClassAssignment_1()); 
            // InternalArg.g:5372:2: ( rule__PhysicClass__OntoClassAssignment_1 )
            // InternalArg.g:5372:3: rule__PhysicClass__OntoClassAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__OntoClassAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicClassAccess().getOntoClassAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__1__Impl"


    // $ANTLR start "rule__PhysicClass__Group__2"
    // InternalArg.g:5380:1: rule__PhysicClass__Group__2 : rule__PhysicClass__Group__2__Impl rule__PhysicClass__Group__3 ;
    public final void rule__PhysicClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5384:1: ( rule__PhysicClass__Group__2__Impl rule__PhysicClass__Group__3 )
            // InternalArg.g:5385:2: rule__PhysicClass__Group__2__Impl rule__PhysicClass__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__PhysicClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__2"


    // $ANTLR start "rule__PhysicClass__Group__2__Impl"
    // InternalArg.g:5392:1: rule__PhysicClass__Group__2__Impl : ( 'body' ) ;
    public final void rule__PhysicClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5396:1: ( ( 'body' ) )
            // InternalArg.g:5397:1: ( 'body' )
            {
            // InternalArg.g:5397:1: ( 'body' )
            // InternalArg.g:5398:2: 'body'
            {
             before(grammarAccess.getPhysicClassAccess().getBodyKeyword_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getBodyKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__2__Impl"


    // $ANTLR start "rule__PhysicClass__Group__3"
    // InternalArg.g:5407:1: rule__PhysicClass__Group__3 : rule__PhysicClass__Group__3__Impl rule__PhysicClass__Group__4 ;
    public final void rule__PhysicClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5411:1: ( rule__PhysicClass__Group__3__Impl rule__PhysicClass__Group__4 )
            // InternalArg.g:5412:2: rule__PhysicClass__Group__3__Impl rule__PhysicClass__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__PhysicClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__3"


    // $ANTLR start "rule__PhysicClass__Group__3__Impl"
    // InternalArg.g:5419:1: rule__PhysicClass__Group__3__Impl : ( '{' ) ;
    public final void rule__PhysicClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5423:1: ( ( '{' ) )
            // InternalArg.g:5424:1: ( '{' )
            {
            // InternalArg.g:5424:1: ( '{' )
            // InternalArg.g:5425:2: '{'
            {
             before(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__3__Impl"


    // $ANTLR start "rule__PhysicClass__Group__4"
    // InternalArg.g:5434:1: rule__PhysicClass__Group__4 : rule__PhysicClass__Group__4__Impl rule__PhysicClass__Group__5 ;
    public final void rule__PhysicClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5438:1: ( rule__PhysicClass__Group__4__Impl rule__PhysicClass__Group__5 )
            // InternalArg.g:5439:2: rule__PhysicClass__Group__4__Impl rule__PhysicClass__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__PhysicClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__4"


    // $ANTLR start "rule__PhysicClass__Group__4__Impl"
    // InternalArg.g:5446:1: rule__PhysicClass__Group__4__Impl : ( ( rule__PhysicClass__PhysicBodyAssignment_4 ) ) ;
    public final void rule__PhysicClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5450:1: ( ( ( rule__PhysicClass__PhysicBodyAssignment_4 ) ) )
            // InternalArg.g:5451:1: ( ( rule__PhysicClass__PhysicBodyAssignment_4 ) )
            {
            // InternalArg.g:5451:1: ( ( rule__PhysicClass__PhysicBodyAssignment_4 ) )
            // InternalArg.g:5452:2: ( rule__PhysicClass__PhysicBodyAssignment_4 )
            {
             before(grammarAccess.getPhysicClassAccess().getPhysicBodyAssignment_4()); 
            // InternalArg.g:5453:2: ( rule__PhysicClass__PhysicBodyAssignment_4 )
            // InternalArg.g:5453:3: rule__PhysicClass__PhysicBodyAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__PhysicBodyAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPhysicClassAccess().getPhysicBodyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__4__Impl"


    // $ANTLR start "rule__PhysicClass__Group__5"
    // InternalArg.g:5461:1: rule__PhysicClass__Group__5 : rule__PhysicClass__Group__5__Impl rule__PhysicClass__Group__6 ;
    public final void rule__PhysicClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5465:1: ( rule__PhysicClass__Group__5__Impl rule__PhysicClass__Group__6 )
            // InternalArg.g:5466:2: rule__PhysicClass__Group__5__Impl rule__PhysicClass__Group__6
            {
            pushFollow(FOLLOW_52);
            rule__PhysicClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__5"


    // $ANTLR start "rule__PhysicClass__Group__5__Impl"
    // InternalArg.g:5473:1: rule__PhysicClass__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5477:1: ( ( '}' ) )
            // InternalArg.g:5478:1: ( '}' )
            {
            // InternalArg.g:5478:1: ( '}' )
            // InternalArg.g:5479:2: '}'
            {
             before(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_5()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__5__Impl"


    // $ANTLR start "rule__PhysicClass__Group__6"
    // InternalArg.g:5488:1: rule__PhysicClass__Group__6 : rule__PhysicClass__Group__6__Impl rule__PhysicClass__Group__7 ;
    public final void rule__PhysicClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5492:1: ( rule__PhysicClass__Group__6__Impl rule__PhysicClass__Group__7 )
            // InternalArg.g:5493:2: rule__PhysicClass__Group__6__Impl rule__PhysicClass__Group__7
            {
            pushFollow(FOLLOW_52);
            rule__PhysicClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__6"


    // $ANTLR start "rule__PhysicClass__Group__6__Impl"
    // InternalArg.g:5500:1: rule__PhysicClass__Group__6__Impl : ( ( rule__PhysicClass__Group_6__0 )? ) ;
    public final void rule__PhysicClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5504:1: ( ( ( rule__PhysicClass__Group_6__0 )? ) )
            // InternalArg.g:5505:1: ( ( rule__PhysicClass__Group_6__0 )? )
            {
            // InternalArg.g:5505:1: ( ( rule__PhysicClass__Group_6__0 )? )
            // InternalArg.g:5506:2: ( rule__PhysicClass__Group_6__0 )?
            {
             before(grammarAccess.getPhysicClassAccess().getGroup_6()); 
            // InternalArg.g:5507:2: ( rule__PhysicClass__Group_6__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==78) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalArg.g:5507:3: rule__PhysicClass__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicClass__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicClassAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__6__Impl"


    // $ANTLR start "rule__PhysicClass__Group__7"
    // InternalArg.g:5515:1: rule__PhysicClass__Group__7 : rule__PhysicClass__Group__7__Impl ;
    public final void rule__PhysicClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5519:1: ( rule__PhysicClass__Group__7__Impl )
            // InternalArg.g:5520:2: rule__PhysicClass__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__7"


    // $ANTLR start "rule__PhysicClass__Group__7__Impl"
    // InternalArg.g:5526:1: rule__PhysicClass__Group__7__Impl : ( ( rule__PhysicClass__Group_7__0 )? ) ;
    public final void rule__PhysicClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5530:1: ( ( ( rule__PhysicClass__Group_7__0 )? ) )
            // InternalArg.g:5531:1: ( ( rule__PhysicClass__Group_7__0 )? )
            {
            // InternalArg.g:5531:1: ( ( rule__PhysicClass__Group_7__0 )? )
            // InternalArg.g:5532:2: ( rule__PhysicClass__Group_7__0 )?
            {
             before(grammarAccess.getPhysicClassAccess().getGroup_7()); 
            // InternalArg.g:5533:2: ( rule__PhysicClass__Group_7__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==79) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalArg.g:5533:3: rule__PhysicClass__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicClass__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicClassAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group__7__Impl"


    // $ANTLR start "rule__PhysicClass__Group_6__0"
    // InternalArg.g:5542:1: rule__PhysicClass__Group_6__0 : rule__PhysicClass__Group_6__0__Impl rule__PhysicClass__Group_6__1 ;
    public final void rule__PhysicClass__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5546:1: ( rule__PhysicClass__Group_6__0__Impl rule__PhysicClass__Group_6__1 )
            // InternalArg.g:5547:2: rule__PhysicClass__Group_6__0__Impl rule__PhysicClass__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__PhysicClass__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__0"


    // $ANTLR start "rule__PhysicClass__Group_6__0__Impl"
    // InternalArg.g:5554:1: rule__PhysicClass__Group_6__0__Impl : ( 'forces' ) ;
    public final void rule__PhysicClass__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5558:1: ( ( 'forces' ) )
            // InternalArg.g:5559:1: ( 'forces' )
            {
            // InternalArg.g:5559:1: ( 'forces' )
            // InternalArg.g:5560:2: 'forces'
            {
             before(grammarAccess.getPhysicClassAccess().getForcesKeyword_6_0()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getForcesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__0__Impl"


    // $ANTLR start "rule__PhysicClass__Group_6__1"
    // InternalArg.g:5569:1: rule__PhysicClass__Group_6__1 : rule__PhysicClass__Group_6__1__Impl rule__PhysicClass__Group_6__2 ;
    public final void rule__PhysicClass__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5573:1: ( rule__PhysicClass__Group_6__1__Impl rule__PhysicClass__Group_6__2 )
            // InternalArg.g:5574:2: rule__PhysicClass__Group_6__1__Impl rule__PhysicClass__Group_6__2
            {
            pushFollow(FOLLOW_3);
            rule__PhysicClass__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__1"


    // $ANTLR start "rule__PhysicClass__Group_6__1__Impl"
    // InternalArg.g:5581:1: rule__PhysicClass__Group_6__1__Impl : ( '{' ) ;
    public final void rule__PhysicClass__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5585:1: ( ( '{' ) )
            // InternalArg.g:5586:1: ( '{' )
            {
            // InternalArg.g:5586:1: ( '{' )
            // InternalArg.g:5587:2: '{'
            {
             before(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_6_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__1__Impl"


    // $ANTLR start "rule__PhysicClass__Group_6__2"
    // InternalArg.g:5596:1: rule__PhysicClass__Group_6__2 : rule__PhysicClass__Group_6__2__Impl rule__PhysicClass__Group_6__3 ;
    public final void rule__PhysicClass__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5600:1: ( rule__PhysicClass__Group_6__2__Impl rule__PhysicClass__Group_6__3 )
            // InternalArg.g:5601:2: rule__PhysicClass__Group_6__2__Impl rule__PhysicClass__Group_6__3
            {
            pushFollow(FOLLOW_6);
            rule__PhysicClass__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__2"


    // $ANTLR start "rule__PhysicClass__Group_6__2__Impl"
    // InternalArg.g:5608:1: rule__PhysicClass__Group_6__2__Impl : ( ( rule__PhysicClass__ForcesAssignment_6_2 ) ) ;
    public final void rule__PhysicClass__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5612:1: ( ( ( rule__PhysicClass__ForcesAssignment_6_2 ) ) )
            // InternalArg.g:5613:1: ( ( rule__PhysicClass__ForcesAssignment_6_2 ) )
            {
            // InternalArg.g:5613:1: ( ( rule__PhysicClass__ForcesAssignment_6_2 ) )
            // InternalArg.g:5614:2: ( rule__PhysicClass__ForcesAssignment_6_2 )
            {
             before(grammarAccess.getPhysicClassAccess().getForcesAssignment_6_2()); 
            // InternalArg.g:5615:2: ( rule__PhysicClass__ForcesAssignment_6_2 )
            // InternalArg.g:5615:3: rule__PhysicClass__ForcesAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__ForcesAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicClassAccess().getForcesAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__2__Impl"


    // $ANTLR start "rule__PhysicClass__Group_6__3"
    // InternalArg.g:5623:1: rule__PhysicClass__Group_6__3 : rule__PhysicClass__Group_6__3__Impl rule__PhysicClass__Group_6__4 ;
    public final void rule__PhysicClass__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5627:1: ( rule__PhysicClass__Group_6__3__Impl rule__PhysicClass__Group_6__4 )
            // InternalArg.g:5628:2: rule__PhysicClass__Group_6__3__Impl rule__PhysicClass__Group_6__4
            {
            pushFollow(FOLLOW_6);
            rule__PhysicClass__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__3"


    // $ANTLR start "rule__PhysicClass__Group_6__3__Impl"
    // InternalArg.g:5635:1: rule__PhysicClass__Group_6__3__Impl : ( ( rule__PhysicClass__ForcesAssignment_6_3 )* ) ;
    public final void rule__PhysicClass__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5639:1: ( ( ( rule__PhysicClass__ForcesAssignment_6_3 )* ) )
            // InternalArg.g:5640:1: ( ( rule__PhysicClass__ForcesAssignment_6_3 )* )
            {
            // InternalArg.g:5640:1: ( ( rule__PhysicClass__ForcesAssignment_6_3 )* )
            // InternalArg.g:5641:2: ( rule__PhysicClass__ForcesAssignment_6_3 )*
            {
             before(grammarAccess.getPhysicClassAccess().getForcesAssignment_6_3()); 
            // InternalArg.g:5642:2: ( rule__PhysicClass__ForcesAssignment_6_3 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalArg.g:5642:3: rule__PhysicClass__ForcesAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PhysicClass__ForcesAssignment_6_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getPhysicClassAccess().getForcesAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__3__Impl"


    // $ANTLR start "rule__PhysicClass__Group_6__4"
    // InternalArg.g:5650:1: rule__PhysicClass__Group_6__4 : rule__PhysicClass__Group_6__4__Impl ;
    public final void rule__PhysicClass__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5654:1: ( rule__PhysicClass__Group_6__4__Impl )
            // InternalArg.g:5655:2: rule__PhysicClass__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_6__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__4"


    // $ANTLR start "rule__PhysicClass__Group_6__4__Impl"
    // InternalArg.g:5661:1: rule__PhysicClass__Group_6__4__Impl : ( '}' ) ;
    public final void rule__PhysicClass__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5665:1: ( ( '}' ) )
            // InternalArg.g:5666:1: ( '}' )
            {
            // InternalArg.g:5666:1: ( '}' )
            // InternalArg.g:5667:2: '}'
            {
             before(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_6_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_6__4__Impl"


    // $ANTLR start "rule__PhysicClass__Group_7__0"
    // InternalArg.g:5677:1: rule__PhysicClass__Group_7__0 : rule__PhysicClass__Group_7__0__Impl rule__PhysicClass__Group_7__1 ;
    public final void rule__PhysicClass__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5681:1: ( rule__PhysicClass__Group_7__0__Impl rule__PhysicClass__Group_7__1 )
            // InternalArg.g:5682:2: rule__PhysicClass__Group_7__0__Impl rule__PhysicClass__Group_7__1
            {
            pushFollow(FOLLOW_4);
            rule__PhysicClass__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__0"


    // $ANTLR start "rule__PhysicClass__Group_7__0__Impl"
    // InternalArg.g:5689:1: rule__PhysicClass__Group_7__0__Impl : ( 'contacts' ) ;
    public final void rule__PhysicClass__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5693:1: ( ( 'contacts' ) )
            // InternalArg.g:5694:1: ( 'contacts' )
            {
            // InternalArg.g:5694:1: ( 'contacts' )
            // InternalArg.g:5695:2: 'contacts'
            {
             before(grammarAccess.getPhysicClassAccess().getContactsKeyword_7_0()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getContactsKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__0__Impl"


    // $ANTLR start "rule__PhysicClass__Group_7__1"
    // InternalArg.g:5704:1: rule__PhysicClass__Group_7__1 : rule__PhysicClass__Group_7__1__Impl rule__PhysicClass__Group_7__2 ;
    public final void rule__PhysicClass__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5708:1: ( rule__PhysicClass__Group_7__1__Impl rule__PhysicClass__Group_7__2 )
            // InternalArg.g:5709:2: rule__PhysicClass__Group_7__1__Impl rule__PhysicClass__Group_7__2
            {
            pushFollow(FOLLOW_53);
            rule__PhysicClass__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__1"


    // $ANTLR start "rule__PhysicClass__Group_7__1__Impl"
    // InternalArg.g:5716:1: rule__PhysicClass__Group_7__1__Impl : ( '{' ) ;
    public final void rule__PhysicClass__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5720:1: ( ( '{' ) )
            // InternalArg.g:5721:1: ( '{' )
            {
            // InternalArg.g:5721:1: ( '{' )
            // InternalArg.g:5722:2: '{'
            {
             before(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_7_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__1__Impl"


    // $ANTLR start "rule__PhysicClass__Group_7__2"
    // InternalArg.g:5731:1: rule__PhysicClass__Group_7__2 : rule__PhysicClass__Group_7__2__Impl rule__PhysicClass__Group_7__3 ;
    public final void rule__PhysicClass__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5735:1: ( rule__PhysicClass__Group_7__2__Impl rule__PhysicClass__Group_7__3 )
            // InternalArg.g:5736:2: rule__PhysicClass__Group_7__2__Impl rule__PhysicClass__Group_7__3
            {
            pushFollow(FOLLOW_8);
            rule__PhysicClass__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__2"


    // $ANTLR start "rule__PhysicClass__Group_7__2__Impl"
    // InternalArg.g:5743:1: rule__PhysicClass__Group_7__2__Impl : ( ( rule__PhysicClass__BitMasksAssignment_7_2 ) ) ;
    public final void rule__PhysicClass__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5747:1: ( ( ( rule__PhysicClass__BitMasksAssignment_7_2 ) ) )
            // InternalArg.g:5748:1: ( ( rule__PhysicClass__BitMasksAssignment_7_2 ) )
            {
            // InternalArg.g:5748:1: ( ( rule__PhysicClass__BitMasksAssignment_7_2 ) )
            // InternalArg.g:5749:2: ( rule__PhysicClass__BitMasksAssignment_7_2 )
            {
             before(grammarAccess.getPhysicClassAccess().getBitMasksAssignment_7_2()); 
            // InternalArg.g:5750:2: ( rule__PhysicClass__BitMasksAssignment_7_2 )
            // InternalArg.g:5750:3: rule__PhysicClass__BitMasksAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__BitMasksAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicClassAccess().getBitMasksAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__2__Impl"


    // $ANTLR start "rule__PhysicClass__Group_7__3"
    // InternalArg.g:5758:1: rule__PhysicClass__Group_7__3 : rule__PhysicClass__Group_7__3__Impl ;
    public final void rule__PhysicClass__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5762:1: ( rule__PhysicClass__Group_7__3__Impl )
            // InternalArg.g:5763:2: rule__PhysicClass__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicClass__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__3"


    // $ANTLR start "rule__PhysicClass__Group_7__3__Impl"
    // InternalArg.g:5769:1: rule__PhysicClass__Group_7__3__Impl : ( '}' ) ;
    public final void rule__PhysicClass__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5773:1: ( ( '}' ) )
            // InternalArg.g:5774:1: ( '}' )
            {
            // InternalArg.g:5774:1: ( '}' )
            // InternalArg.g:5775:2: '}'
            {
             before(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_7_3()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__Group_7__3__Impl"


    // $ANTLR start "rule__PhysicBody__Group__0"
    // InternalArg.g:5785:1: rule__PhysicBody__Group__0 : rule__PhysicBody__Group__0__Impl rule__PhysicBody__Group__1 ;
    public final void rule__PhysicBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5789:1: ( rule__PhysicBody__Group__0__Impl rule__PhysicBody__Group__1 )
            // InternalArg.g:5790:2: rule__PhysicBody__Group__0__Impl rule__PhysicBody__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__0"


    // $ANTLR start "rule__PhysicBody__Group__0__Impl"
    // InternalArg.g:5797:1: rule__PhysicBody__Group__0__Impl : ( 'mass' ) ;
    public final void rule__PhysicBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5801:1: ( ( 'mass' ) )
            // InternalArg.g:5802:1: ( 'mass' )
            {
            // InternalArg.g:5802:1: ( 'mass' )
            // InternalArg.g:5803:2: 'mass'
            {
             before(grammarAccess.getPhysicBodyAccess().getMassKeyword_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getMassKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__0__Impl"


    // $ANTLR start "rule__PhysicBody__Group__1"
    // InternalArg.g:5812:1: rule__PhysicBody__Group__1 : rule__PhysicBody__Group__1__Impl rule__PhysicBody__Group__2 ;
    public final void rule__PhysicBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5816:1: ( rule__PhysicBody__Group__1__Impl rule__PhysicBody__Group__2 )
            // InternalArg.g:5817:2: rule__PhysicBody__Group__1__Impl rule__PhysicBody__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__PhysicBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__1"


    // $ANTLR start "rule__PhysicBody__Group__1__Impl"
    // InternalArg.g:5824:1: rule__PhysicBody__Group__1__Impl : ( ( rule__PhysicBody__MassAssignment_1 ) ) ;
    public final void rule__PhysicBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5828:1: ( ( ( rule__PhysicBody__MassAssignment_1 ) ) )
            // InternalArg.g:5829:1: ( ( rule__PhysicBody__MassAssignment_1 ) )
            {
            // InternalArg.g:5829:1: ( ( rule__PhysicBody__MassAssignment_1 ) )
            // InternalArg.g:5830:2: ( rule__PhysicBody__MassAssignment_1 )
            {
             before(grammarAccess.getPhysicBodyAccess().getMassAssignment_1()); 
            // InternalArg.g:5831:2: ( rule__PhysicBody__MassAssignment_1 )
            // InternalArg.g:5831:3: rule__PhysicBody__MassAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__MassAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getMassAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__1__Impl"


    // $ANTLR start "rule__PhysicBody__Group__2"
    // InternalArg.g:5839:1: rule__PhysicBody__Group__2 : rule__PhysicBody__Group__2__Impl rule__PhysicBody__Group__3 ;
    public final void rule__PhysicBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5843:1: ( rule__PhysicBody__Group__2__Impl rule__PhysicBody__Group__3 )
            // InternalArg.g:5844:2: rule__PhysicBody__Group__2__Impl rule__PhysicBody__Group__3
            {
            pushFollow(FOLLOW_55);
            rule__PhysicBody__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__2"


    // $ANTLR start "rule__PhysicBody__Group__2__Impl"
    // InternalArg.g:5851:1: rule__PhysicBody__Group__2__Impl : ( 'bodyType' ) ;
    public final void rule__PhysicBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5855:1: ( ( 'bodyType' ) )
            // InternalArg.g:5856:1: ( 'bodyType' )
            {
            // InternalArg.g:5856:1: ( 'bodyType' )
            // InternalArg.g:5857:2: 'bodyType'
            {
             before(grammarAccess.getPhysicBodyAccess().getBodyTypeKeyword_2()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getBodyTypeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__2__Impl"


    // $ANTLR start "rule__PhysicBody__Group__3"
    // InternalArg.g:5866:1: rule__PhysicBody__Group__3 : rule__PhysicBody__Group__3__Impl rule__PhysicBody__Group__4 ;
    public final void rule__PhysicBody__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5870:1: ( rule__PhysicBody__Group__3__Impl rule__PhysicBody__Group__4 )
            // InternalArg.g:5871:2: rule__PhysicBody__Group__3__Impl rule__PhysicBody__Group__4
            {
            pushFollow(FOLLOW_56);
            rule__PhysicBody__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__3"


    // $ANTLR start "rule__PhysicBody__Group__3__Impl"
    // InternalArg.g:5878:1: rule__PhysicBody__Group__3__Impl : ( ( rule__PhysicBody__BodyTypeAssignment_3 ) ) ;
    public final void rule__PhysicBody__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5882:1: ( ( ( rule__PhysicBody__BodyTypeAssignment_3 ) ) )
            // InternalArg.g:5883:1: ( ( rule__PhysicBody__BodyTypeAssignment_3 ) )
            {
            // InternalArg.g:5883:1: ( ( rule__PhysicBody__BodyTypeAssignment_3 ) )
            // InternalArg.g:5884:2: ( rule__PhysicBody__BodyTypeAssignment_3 )
            {
             before(grammarAccess.getPhysicBodyAccess().getBodyTypeAssignment_3()); 
            // InternalArg.g:5885:2: ( rule__PhysicBody__BodyTypeAssignment_3 )
            // InternalArg.g:5885:3: rule__PhysicBody__BodyTypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__BodyTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getBodyTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__3__Impl"


    // $ANTLR start "rule__PhysicBody__Group__4"
    // InternalArg.g:5893:1: rule__PhysicBody__Group__4 : rule__PhysicBody__Group__4__Impl rule__PhysicBody__Group__5 ;
    public final void rule__PhysicBody__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5897:1: ( rule__PhysicBody__Group__4__Impl rule__PhysicBody__Group__5 )
            // InternalArg.g:5898:2: rule__PhysicBody__Group__4__Impl rule__PhysicBody__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__4"


    // $ANTLR start "rule__PhysicBody__Group__4__Impl"
    // InternalArg.g:5905:1: rule__PhysicBody__Group__4__Impl : ( 'charge' ) ;
    public final void rule__PhysicBody__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5909:1: ( ( 'charge' ) )
            // InternalArg.g:5910:1: ( 'charge' )
            {
            // InternalArg.g:5910:1: ( 'charge' )
            // InternalArg.g:5911:2: 'charge'
            {
             before(grammarAccess.getPhysicBodyAccess().getChargeKeyword_4()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getChargeKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__4__Impl"


    // $ANTLR start "rule__PhysicBody__Group__5"
    // InternalArg.g:5920:1: rule__PhysicBody__Group__5 : rule__PhysicBody__Group__5__Impl rule__PhysicBody__Group__6 ;
    public final void rule__PhysicBody__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5924:1: ( rule__PhysicBody__Group__5__Impl rule__PhysicBody__Group__6 )
            // InternalArg.g:5925:2: rule__PhysicBody__Group__5__Impl rule__PhysicBody__Group__6
            {
            pushFollow(FOLLOW_57);
            rule__PhysicBody__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__5"


    // $ANTLR start "rule__PhysicBody__Group__5__Impl"
    // InternalArg.g:5932:1: rule__PhysicBody__Group__5__Impl : ( ( rule__PhysicBody__ChargeAssignment_5 ) ) ;
    public final void rule__PhysicBody__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5936:1: ( ( ( rule__PhysicBody__ChargeAssignment_5 ) ) )
            // InternalArg.g:5937:1: ( ( rule__PhysicBody__ChargeAssignment_5 ) )
            {
            // InternalArg.g:5937:1: ( ( rule__PhysicBody__ChargeAssignment_5 ) )
            // InternalArg.g:5938:2: ( rule__PhysicBody__ChargeAssignment_5 )
            {
             before(grammarAccess.getPhysicBodyAccess().getChargeAssignment_5()); 
            // InternalArg.g:5939:2: ( rule__PhysicBody__ChargeAssignment_5 )
            // InternalArg.g:5939:3: rule__PhysicBody__ChargeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__ChargeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getChargeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__5__Impl"


    // $ANTLR start "rule__PhysicBody__Group__6"
    // InternalArg.g:5947:1: rule__PhysicBody__Group__6 : rule__PhysicBody__Group__6__Impl rule__PhysicBody__Group__7 ;
    public final void rule__PhysicBody__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5951:1: ( rule__PhysicBody__Group__6__Impl rule__PhysicBody__Group__7 )
            // InternalArg.g:5952:2: rule__PhysicBody__Group__6__Impl rule__PhysicBody__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__6"


    // $ANTLR start "rule__PhysicBody__Group__6__Impl"
    // InternalArg.g:5959:1: rule__PhysicBody__Group__6__Impl : ( 'friction' ) ;
    public final void rule__PhysicBody__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5963:1: ( ( 'friction' ) )
            // InternalArg.g:5964:1: ( 'friction' )
            {
            // InternalArg.g:5964:1: ( 'friction' )
            // InternalArg.g:5965:2: 'friction'
            {
             before(grammarAccess.getPhysicBodyAccess().getFrictionKeyword_6()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getFrictionKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__6__Impl"


    // $ANTLR start "rule__PhysicBody__Group__7"
    // InternalArg.g:5974:1: rule__PhysicBody__Group__7 : rule__PhysicBody__Group__7__Impl rule__PhysicBody__Group__8 ;
    public final void rule__PhysicBody__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5978:1: ( rule__PhysicBody__Group__7__Impl rule__PhysicBody__Group__8 )
            // InternalArg.g:5979:2: rule__PhysicBody__Group__7__Impl rule__PhysicBody__Group__8
            {
            pushFollow(FOLLOW_58);
            rule__PhysicBody__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__7"


    // $ANTLR start "rule__PhysicBody__Group__7__Impl"
    // InternalArg.g:5986:1: rule__PhysicBody__Group__7__Impl : ( ( rule__PhysicBody__FrictionAssignment_7 ) ) ;
    public final void rule__PhysicBody__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:5990:1: ( ( ( rule__PhysicBody__FrictionAssignment_7 ) ) )
            // InternalArg.g:5991:1: ( ( rule__PhysicBody__FrictionAssignment_7 ) )
            {
            // InternalArg.g:5991:1: ( ( rule__PhysicBody__FrictionAssignment_7 ) )
            // InternalArg.g:5992:2: ( rule__PhysicBody__FrictionAssignment_7 )
            {
             before(grammarAccess.getPhysicBodyAccess().getFrictionAssignment_7()); 
            // InternalArg.g:5993:2: ( rule__PhysicBody__FrictionAssignment_7 )
            // InternalArg.g:5993:3: rule__PhysicBody__FrictionAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__FrictionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getFrictionAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__7__Impl"


    // $ANTLR start "rule__PhysicBody__Group__8"
    // InternalArg.g:6001:1: rule__PhysicBody__Group__8 : rule__PhysicBody__Group__8__Impl rule__PhysicBody__Group__9 ;
    public final void rule__PhysicBody__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6005:1: ( rule__PhysicBody__Group__8__Impl rule__PhysicBody__Group__9 )
            // InternalArg.g:6006:2: rule__PhysicBody__Group__8__Impl rule__PhysicBody__Group__9
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__8"


    // $ANTLR start "rule__PhysicBody__Group__8__Impl"
    // InternalArg.g:6013:1: rule__PhysicBody__Group__8__Impl : ( 'rollingFriction' ) ;
    public final void rule__PhysicBody__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6017:1: ( ( 'rollingFriction' ) )
            // InternalArg.g:6018:1: ( 'rollingFriction' )
            {
            // InternalArg.g:6018:1: ( 'rollingFriction' )
            // InternalArg.g:6019:2: 'rollingFriction'
            {
             before(grammarAccess.getPhysicBodyAccess().getRollingFrictionKeyword_8()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getRollingFrictionKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__8__Impl"


    // $ANTLR start "rule__PhysicBody__Group__9"
    // InternalArg.g:6028:1: rule__PhysicBody__Group__9 : rule__PhysicBody__Group__9__Impl rule__PhysicBody__Group__10 ;
    public final void rule__PhysicBody__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6032:1: ( rule__PhysicBody__Group__9__Impl rule__PhysicBody__Group__10 )
            // InternalArg.g:6033:2: rule__PhysicBody__Group__9__Impl rule__PhysicBody__Group__10
            {
            pushFollow(FOLLOW_59);
            rule__PhysicBody__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__9"


    // $ANTLR start "rule__PhysicBody__Group__9__Impl"
    // InternalArg.g:6040:1: rule__PhysicBody__Group__9__Impl : ( ( rule__PhysicBody__RollingFrictionAssignment_9 ) ) ;
    public final void rule__PhysicBody__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6044:1: ( ( ( rule__PhysicBody__RollingFrictionAssignment_9 ) ) )
            // InternalArg.g:6045:1: ( ( rule__PhysicBody__RollingFrictionAssignment_9 ) )
            {
            // InternalArg.g:6045:1: ( ( rule__PhysicBody__RollingFrictionAssignment_9 ) )
            // InternalArg.g:6046:2: ( rule__PhysicBody__RollingFrictionAssignment_9 )
            {
             before(grammarAccess.getPhysicBodyAccess().getRollingFrictionAssignment_9()); 
            // InternalArg.g:6047:2: ( rule__PhysicBody__RollingFrictionAssignment_9 )
            // InternalArg.g:6047:3: rule__PhysicBody__RollingFrictionAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__RollingFrictionAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getRollingFrictionAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__9__Impl"


    // $ANTLR start "rule__PhysicBody__Group__10"
    // InternalArg.g:6055:1: rule__PhysicBody__Group__10 : rule__PhysicBody__Group__10__Impl rule__PhysicBody__Group__11 ;
    public final void rule__PhysicBody__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6059:1: ( rule__PhysicBody__Group__10__Impl rule__PhysicBody__Group__11 )
            // InternalArg.g:6060:2: rule__PhysicBody__Group__10__Impl rule__PhysicBody__Group__11
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__10"


    // $ANTLR start "rule__PhysicBody__Group__10__Impl"
    // InternalArg.g:6067:1: rule__PhysicBody__Group__10__Impl : ( 'restitution' ) ;
    public final void rule__PhysicBody__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6071:1: ( ( 'restitution' ) )
            // InternalArg.g:6072:1: ( 'restitution' )
            {
            // InternalArg.g:6072:1: ( 'restitution' )
            // InternalArg.g:6073:2: 'restitution'
            {
             before(grammarAccess.getPhysicBodyAccess().getRestitutionKeyword_10()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getRestitutionKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__10__Impl"


    // $ANTLR start "rule__PhysicBody__Group__11"
    // InternalArg.g:6082:1: rule__PhysicBody__Group__11 : rule__PhysicBody__Group__11__Impl rule__PhysicBody__Group__12 ;
    public final void rule__PhysicBody__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6086:1: ( rule__PhysicBody__Group__11__Impl rule__PhysicBody__Group__12 )
            // InternalArg.g:6087:2: rule__PhysicBody__Group__11__Impl rule__PhysicBody__Group__12
            {
            pushFollow(FOLLOW_60);
            rule__PhysicBody__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__11"


    // $ANTLR start "rule__PhysicBody__Group__11__Impl"
    // InternalArg.g:6094:1: rule__PhysicBody__Group__11__Impl : ( ( rule__PhysicBody__RestitutionAssignment_11 ) ) ;
    public final void rule__PhysicBody__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6098:1: ( ( ( rule__PhysicBody__RestitutionAssignment_11 ) ) )
            // InternalArg.g:6099:1: ( ( rule__PhysicBody__RestitutionAssignment_11 ) )
            {
            // InternalArg.g:6099:1: ( ( rule__PhysicBody__RestitutionAssignment_11 ) )
            // InternalArg.g:6100:2: ( rule__PhysicBody__RestitutionAssignment_11 )
            {
             before(grammarAccess.getPhysicBodyAccess().getRestitutionAssignment_11()); 
            // InternalArg.g:6101:2: ( rule__PhysicBody__RestitutionAssignment_11 )
            // InternalArg.g:6101:3: rule__PhysicBody__RestitutionAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__RestitutionAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getRestitutionAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__11__Impl"


    // $ANTLR start "rule__PhysicBody__Group__12"
    // InternalArg.g:6109:1: rule__PhysicBody__Group__12 : rule__PhysicBody__Group__12__Impl rule__PhysicBody__Group__13 ;
    public final void rule__PhysicBody__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6113:1: ( rule__PhysicBody__Group__12__Impl rule__PhysicBody__Group__13 )
            // InternalArg.g:6114:2: rule__PhysicBody__Group__12__Impl rule__PhysicBody__Group__13
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__12"


    // $ANTLR start "rule__PhysicBody__Group__12__Impl"
    // InternalArg.g:6121:1: rule__PhysicBody__Group__12__Impl : ( 'damping' ) ;
    public final void rule__PhysicBody__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6125:1: ( ( 'damping' ) )
            // InternalArg.g:6126:1: ( 'damping' )
            {
            // InternalArg.g:6126:1: ( 'damping' )
            // InternalArg.g:6127:2: 'damping'
            {
             before(grammarAccess.getPhysicBodyAccess().getDampingKeyword_12()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getDampingKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__12__Impl"


    // $ANTLR start "rule__PhysicBody__Group__13"
    // InternalArg.g:6136:1: rule__PhysicBody__Group__13 : rule__PhysicBody__Group__13__Impl rule__PhysicBody__Group__14 ;
    public final void rule__PhysicBody__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6140:1: ( rule__PhysicBody__Group__13__Impl rule__PhysicBody__Group__14 )
            // InternalArg.g:6141:2: rule__PhysicBody__Group__13__Impl rule__PhysicBody__Group__14
            {
            pushFollow(FOLLOW_61);
            rule__PhysicBody__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__13"


    // $ANTLR start "rule__PhysicBody__Group__13__Impl"
    // InternalArg.g:6148:1: rule__PhysicBody__Group__13__Impl : ( ( rule__PhysicBody__DampingAssignment_13 ) ) ;
    public final void rule__PhysicBody__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6152:1: ( ( ( rule__PhysicBody__DampingAssignment_13 ) ) )
            // InternalArg.g:6153:1: ( ( rule__PhysicBody__DampingAssignment_13 ) )
            {
            // InternalArg.g:6153:1: ( ( rule__PhysicBody__DampingAssignment_13 ) )
            // InternalArg.g:6154:2: ( rule__PhysicBody__DampingAssignment_13 )
            {
             before(grammarAccess.getPhysicBodyAccess().getDampingAssignment_13()); 
            // InternalArg.g:6155:2: ( rule__PhysicBody__DampingAssignment_13 )
            // InternalArg.g:6155:3: rule__PhysicBody__DampingAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__DampingAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getDampingAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__13__Impl"


    // $ANTLR start "rule__PhysicBody__Group__14"
    // InternalArg.g:6163:1: rule__PhysicBody__Group__14 : rule__PhysicBody__Group__14__Impl rule__PhysicBody__Group__15 ;
    public final void rule__PhysicBody__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6167:1: ( rule__PhysicBody__Group__14__Impl rule__PhysicBody__Group__15 )
            // InternalArg.g:6168:2: rule__PhysicBody__Group__14__Impl rule__PhysicBody__Group__15
            {
            pushFollow(FOLLOW_42);
            rule__PhysicBody__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__14"


    // $ANTLR start "rule__PhysicBody__Group__14__Impl"
    // InternalArg.g:6175:1: rule__PhysicBody__Group__14__Impl : ( 'angularDamping' ) ;
    public final void rule__PhysicBody__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6179:1: ( ( 'angularDamping' ) )
            // InternalArg.g:6180:1: ( 'angularDamping' )
            {
            // InternalArg.g:6180:1: ( 'angularDamping' )
            // InternalArg.g:6181:2: 'angularDamping'
            {
             before(grammarAccess.getPhysicBodyAccess().getAngularDampingKeyword_14()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getPhysicBodyAccess().getAngularDampingKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__14__Impl"


    // $ANTLR start "rule__PhysicBody__Group__15"
    // InternalArg.g:6190:1: rule__PhysicBody__Group__15 : rule__PhysicBody__Group__15__Impl ;
    public final void rule__PhysicBody__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6194:1: ( rule__PhysicBody__Group__15__Impl )
            // InternalArg.g:6195:2: rule__PhysicBody__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__15"


    // $ANTLR start "rule__PhysicBody__Group__15__Impl"
    // InternalArg.g:6201:1: rule__PhysicBody__Group__15__Impl : ( ( rule__PhysicBody__AngularDampingAssignment_15 ) ) ;
    public final void rule__PhysicBody__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6205:1: ( ( ( rule__PhysicBody__AngularDampingAssignment_15 ) ) )
            // InternalArg.g:6206:1: ( ( rule__PhysicBody__AngularDampingAssignment_15 ) )
            {
            // InternalArg.g:6206:1: ( ( rule__PhysicBody__AngularDampingAssignment_15 ) )
            // InternalArg.g:6207:2: ( rule__PhysicBody__AngularDampingAssignment_15 )
            {
             before(grammarAccess.getPhysicBodyAccess().getAngularDampingAssignment_15()); 
            // InternalArg.g:6208:2: ( rule__PhysicBody__AngularDampingAssignment_15 )
            // InternalArg.g:6208:3: rule__PhysicBody__AngularDampingAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__PhysicBody__AngularDampingAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getPhysicBodyAccess().getAngularDampingAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__Group__15__Impl"


    // $ANTLR start "rule__BitMasks__Group__0"
    // InternalArg.g:6217:1: rule__BitMasks__Group__0 : rule__BitMasks__Group__0__Impl rule__BitMasks__Group__1 ;
    public final void rule__BitMasks__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6221:1: ( rule__BitMasks__Group__0__Impl rule__BitMasks__Group__1 )
            // InternalArg.g:6222:2: rule__BitMasks__Group__0__Impl rule__BitMasks__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__BitMasks__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__0"


    // $ANTLR start "rule__BitMasks__Group__0__Impl"
    // InternalArg.g:6229:1: rule__BitMasks__Group__0__Impl : ( 'collision' ) ;
    public final void rule__BitMasks__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6233:1: ( ( 'collision' ) )
            // InternalArg.g:6234:1: ( 'collision' )
            {
            // InternalArg.g:6234:1: ( 'collision' )
            // InternalArg.g:6235:2: 'collision'
            {
             before(grammarAccess.getBitMasksAccess().getCollisionKeyword_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getBitMasksAccess().getCollisionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__0__Impl"


    // $ANTLR start "rule__BitMasks__Group__1"
    // InternalArg.g:6244:1: rule__BitMasks__Group__1 : rule__BitMasks__Group__1__Impl rule__BitMasks__Group__2 ;
    public final void rule__BitMasks__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6248:1: ( rule__BitMasks__Group__1__Impl rule__BitMasks__Group__2 )
            // InternalArg.g:6249:2: rule__BitMasks__Group__1__Impl rule__BitMasks__Group__2
            {
            pushFollow(FOLLOW_62);
            rule__BitMasks__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__1"


    // $ANTLR start "rule__BitMasks__Group__1__Impl"
    // InternalArg.g:6256:1: rule__BitMasks__Group__1__Impl : ( ( rule__BitMasks__CollisionAssignment_1 ) ) ;
    public final void rule__BitMasks__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6260:1: ( ( ( rule__BitMasks__CollisionAssignment_1 ) ) )
            // InternalArg.g:6261:1: ( ( rule__BitMasks__CollisionAssignment_1 ) )
            {
            // InternalArg.g:6261:1: ( ( rule__BitMasks__CollisionAssignment_1 ) )
            // InternalArg.g:6262:2: ( rule__BitMasks__CollisionAssignment_1 )
            {
             before(grammarAccess.getBitMasksAccess().getCollisionAssignment_1()); 
            // InternalArg.g:6263:2: ( rule__BitMasks__CollisionAssignment_1 )
            // InternalArg.g:6263:3: rule__BitMasks__CollisionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BitMasks__CollisionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBitMasksAccess().getCollisionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__1__Impl"


    // $ANTLR start "rule__BitMasks__Group__2"
    // InternalArg.g:6271:1: rule__BitMasks__Group__2 : rule__BitMasks__Group__2__Impl rule__BitMasks__Group__3 ;
    public final void rule__BitMasks__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6275:1: ( rule__BitMasks__Group__2__Impl rule__BitMasks__Group__3 )
            // InternalArg.g:6276:2: rule__BitMasks__Group__2__Impl rule__BitMasks__Group__3
            {
            pushFollow(FOLLOW_62);
            rule__BitMasks__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__2"


    // $ANTLR start "rule__BitMasks__Group__2__Impl"
    // InternalArg.g:6283:1: rule__BitMasks__Group__2__Impl : ( ( rule__BitMasks__CollisionAssignment_2 )* ) ;
    public final void rule__BitMasks__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6287:1: ( ( ( rule__BitMasks__CollisionAssignment_2 )* ) )
            // InternalArg.g:6288:1: ( ( rule__BitMasks__CollisionAssignment_2 )* )
            {
            // InternalArg.g:6288:1: ( ( rule__BitMasks__CollisionAssignment_2 )* )
            // InternalArg.g:6289:2: ( rule__BitMasks__CollisionAssignment_2 )*
            {
             before(grammarAccess.getBitMasksAccess().getCollisionAssignment_2()); 
            // InternalArg.g:6290:2: ( rule__BitMasks__CollisionAssignment_2 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_ID)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalArg.g:6290:3: rule__BitMasks__CollisionAssignment_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__BitMasks__CollisionAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getBitMasksAccess().getCollisionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__2__Impl"


    // $ANTLR start "rule__BitMasks__Group__3"
    // InternalArg.g:6298:1: rule__BitMasks__Group__3 : rule__BitMasks__Group__3__Impl rule__BitMasks__Group__4 ;
    public final void rule__BitMasks__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6302:1: ( rule__BitMasks__Group__3__Impl rule__BitMasks__Group__4 )
            // InternalArg.g:6303:2: rule__BitMasks__Group__3__Impl rule__BitMasks__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__BitMasks__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__3"


    // $ANTLR start "rule__BitMasks__Group__3__Impl"
    // InternalArg.g:6310:1: rule__BitMasks__Group__3__Impl : ( 'contact' ) ;
    public final void rule__BitMasks__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6314:1: ( ( 'contact' ) )
            // InternalArg.g:6315:1: ( 'contact' )
            {
            // InternalArg.g:6315:1: ( 'contact' )
            // InternalArg.g:6316:2: 'contact'
            {
             before(grammarAccess.getBitMasksAccess().getContactKeyword_3()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getBitMasksAccess().getContactKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__3__Impl"


    // $ANTLR start "rule__BitMasks__Group__4"
    // InternalArg.g:6325:1: rule__BitMasks__Group__4 : rule__BitMasks__Group__4__Impl rule__BitMasks__Group__5 ;
    public final void rule__BitMasks__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6329:1: ( rule__BitMasks__Group__4__Impl rule__BitMasks__Group__5 )
            // InternalArg.g:6330:2: rule__BitMasks__Group__4__Impl rule__BitMasks__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__BitMasks__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__4"


    // $ANTLR start "rule__BitMasks__Group__4__Impl"
    // InternalArg.g:6337:1: rule__BitMasks__Group__4__Impl : ( ( rule__BitMasks__ContactAssignment_4 ) ) ;
    public final void rule__BitMasks__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6341:1: ( ( ( rule__BitMasks__ContactAssignment_4 ) ) )
            // InternalArg.g:6342:1: ( ( rule__BitMasks__ContactAssignment_4 ) )
            {
            // InternalArg.g:6342:1: ( ( rule__BitMasks__ContactAssignment_4 ) )
            // InternalArg.g:6343:2: ( rule__BitMasks__ContactAssignment_4 )
            {
             before(grammarAccess.getBitMasksAccess().getContactAssignment_4()); 
            // InternalArg.g:6344:2: ( rule__BitMasks__ContactAssignment_4 )
            // InternalArg.g:6344:3: rule__BitMasks__ContactAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__BitMasks__ContactAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getBitMasksAccess().getContactAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__4__Impl"


    // $ANTLR start "rule__BitMasks__Group__5"
    // InternalArg.g:6352:1: rule__BitMasks__Group__5 : rule__BitMasks__Group__5__Impl ;
    public final void rule__BitMasks__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6356:1: ( rule__BitMasks__Group__5__Impl )
            // InternalArg.g:6357:2: rule__BitMasks__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BitMasks__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__5"


    // $ANTLR start "rule__BitMasks__Group__5__Impl"
    // InternalArg.g:6363:1: rule__BitMasks__Group__5__Impl : ( ( rule__BitMasks__ContactAssignment_5 )* ) ;
    public final void rule__BitMasks__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6367:1: ( ( ( rule__BitMasks__ContactAssignment_5 )* ) )
            // InternalArg.g:6368:1: ( ( rule__BitMasks__ContactAssignment_5 )* )
            {
            // InternalArg.g:6368:1: ( ( rule__BitMasks__ContactAssignment_5 )* )
            // InternalArg.g:6369:2: ( rule__BitMasks__ContactAssignment_5 )*
            {
             before(grammarAccess.getBitMasksAccess().getContactAssignment_5()); 
            // InternalArg.g:6370:2: ( rule__BitMasks__ContactAssignment_5 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalArg.g:6370:3: rule__BitMasks__ContactAssignment_5
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__BitMasks__ContactAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getBitMasksAccess().getContactAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__Group__5__Impl"


    // $ANTLR start "rule__Force__Group__0"
    // InternalArg.g:6379:1: rule__Force__Group__0 : rule__Force__Group__0__Impl rule__Force__Group__1 ;
    public final void rule__Force__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6383:1: ( rule__Force__Group__0__Impl rule__Force__Group__1 )
            // InternalArg.g:6384:2: rule__Force__Group__0__Impl rule__Force__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Force__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__0"


    // $ANTLR start "rule__Force__Group__0__Impl"
    // InternalArg.g:6391:1: rule__Force__Group__0__Impl : ( ( rule__Force__NameAssignment_0 ) ) ;
    public final void rule__Force__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6395:1: ( ( ( rule__Force__NameAssignment_0 ) ) )
            // InternalArg.g:6396:1: ( ( rule__Force__NameAssignment_0 ) )
            {
            // InternalArg.g:6396:1: ( ( rule__Force__NameAssignment_0 ) )
            // InternalArg.g:6397:2: ( rule__Force__NameAssignment_0 )
            {
             before(grammarAccess.getForceAccess().getNameAssignment_0()); 
            // InternalArg.g:6398:2: ( rule__Force__NameAssignment_0 )
            // InternalArg.g:6398:3: rule__Force__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Force__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__0__Impl"


    // $ANTLR start "rule__Force__Group__1"
    // InternalArg.g:6406:1: rule__Force__Group__1 : rule__Force__Group__1__Impl rule__Force__Group__2 ;
    public final void rule__Force__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6410:1: ( rule__Force__Group__1__Impl rule__Force__Group__2 )
            // InternalArg.g:6411:2: rule__Force__Group__1__Impl rule__Force__Group__2
            {
            pushFollow(FOLLOW_63);
            rule__Force__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__1"


    // $ANTLR start "rule__Force__Group__1__Impl"
    // InternalArg.g:6418:1: rule__Force__Group__1__Impl : ( ':' ) ;
    public final void rule__Force__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6422:1: ( ( ':' ) )
            // InternalArg.g:6423:1: ( ':' )
            {
            // InternalArg.g:6423:1: ( ':' )
            // InternalArg.g:6424:2: ':'
            {
             before(grammarAccess.getForceAccess().getColonKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__1__Impl"


    // $ANTLR start "rule__Force__Group__2"
    // InternalArg.g:6433:1: rule__Force__Group__2 : rule__Force__Group__2__Impl rule__Force__Group__3 ;
    public final void rule__Force__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6437:1: ( rule__Force__Group__2__Impl rule__Force__Group__3 )
            // InternalArg.g:6438:2: rule__Force__Group__2__Impl rule__Force__Group__3
            {
            pushFollow(FOLLOW_64);
            rule__Force__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__2"


    // $ANTLR start "rule__Force__Group__2__Impl"
    // InternalArg.g:6445:1: rule__Force__Group__2__Impl : ( 'gesture' ) ;
    public final void rule__Force__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6449:1: ( ( 'gesture' ) )
            // InternalArg.g:6450:1: ( 'gesture' )
            {
            // InternalArg.g:6450:1: ( 'gesture' )
            // InternalArg.g:6451:2: 'gesture'
            {
             before(grammarAccess.getForceAccess().getGestureKeyword_2()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getGestureKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__2__Impl"


    // $ANTLR start "rule__Force__Group__3"
    // InternalArg.g:6460:1: rule__Force__Group__3 : rule__Force__Group__3__Impl rule__Force__Group__4 ;
    public final void rule__Force__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6464:1: ( rule__Force__Group__3__Impl rule__Force__Group__4 )
            // InternalArg.g:6465:2: rule__Force__Group__3__Impl rule__Force__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__Force__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__3"


    // $ANTLR start "rule__Force__Group__3__Impl"
    // InternalArg.g:6472:1: rule__Force__Group__3__Impl : ( ( rule__Force__GestureAssignment_3 ) ) ;
    public final void rule__Force__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6476:1: ( ( ( rule__Force__GestureAssignment_3 ) ) )
            // InternalArg.g:6477:1: ( ( rule__Force__GestureAssignment_3 ) )
            {
            // InternalArg.g:6477:1: ( ( rule__Force__GestureAssignment_3 ) )
            // InternalArg.g:6478:2: ( rule__Force__GestureAssignment_3 )
            {
             before(grammarAccess.getForceAccess().getGestureAssignment_3()); 
            // InternalArg.g:6479:2: ( rule__Force__GestureAssignment_3 )
            // InternalArg.g:6479:3: rule__Force__GestureAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Force__GestureAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getGestureAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__3__Impl"


    // $ANTLR start "rule__Force__Group__4"
    // InternalArg.g:6487:1: rule__Force__Group__4 : rule__Force__Group__4__Impl ;
    public final void rule__Force__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6491:1: ( rule__Force__Group__4__Impl )
            // InternalArg.g:6492:2: rule__Force__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Force__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__4"


    // $ANTLR start "rule__Force__Group__4__Impl"
    // InternalArg.g:6498:1: rule__Force__Group__4__Impl : ( ( rule__Force__Group_4__0 )? ) ;
    public final void rule__Force__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6502:1: ( ( ( rule__Force__Group_4__0 )? ) )
            // InternalArg.g:6503:1: ( ( rule__Force__Group_4__0 )? )
            {
            // InternalArg.g:6503:1: ( ( rule__Force__Group_4__0 )? )
            // InternalArg.g:6504:2: ( rule__Force__Group_4__0 )?
            {
             before(grammarAccess.getForceAccess().getGroup_4()); 
            // InternalArg.g:6505:2: ( rule__Force__Group_4__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==57) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalArg.g:6505:3: rule__Force__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Force__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getForceAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group__4__Impl"


    // $ANTLR start "rule__Force__Group_4__0"
    // InternalArg.g:6514:1: rule__Force__Group_4__0 : rule__Force__Group_4__0__Impl rule__Force__Group_4__1 ;
    public final void rule__Force__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6518:1: ( rule__Force__Group_4__0__Impl rule__Force__Group_4__1 )
            // InternalArg.g:6519:2: rule__Force__Group_4__0__Impl rule__Force__Group_4__1
            {
            pushFollow(FOLLOW_42);
            rule__Force__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__0"


    // $ANTLR start "rule__Force__Group_4__0__Impl"
    // InternalArg.g:6526:1: rule__Force__Group_4__0__Impl : ( '[' ) ;
    public final void rule__Force__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6530:1: ( ( '[' ) )
            // InternalArg.g:6531:1: ( '[' )
            {
            // InternalArg.g:6531:1: ( '[' )
            // InternalArg.g:6532:2: '['
            {
             before(grammarAccess.getForceAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getLeftSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__0__Impl"


    // $ANTLR start "rule__Force__Group_4__1"
    // InternalArg.g:6541:1: rule__Force__Group_4__1 : rule__Force__Group_4__1__Impl rule__Force__Group_4__2 ;
    public final void rule__Force__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6545:1: ( rule__Force__Group_4__1__Impl rule__Force__Group_4__2 )
            // InternalArg.g:6546:2: rule__Force__Group_4__1__Impl rule__Force__Group_4__2
            {
            pushFollow(FOLLOW_65);
            rule__Force__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__1"


    // $ANTLR start "rule__Force__Group_4__1__Impl"
    // InternalArg.g:6553:1: rule__Force__Group_4__1__Impl : ( ( rule__Force__XVectorAssignment_4_1 ) ) ;
    public final void rule__Force__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6557:1: ( ( ( rule__Force__XVectorAssignment_4_1 ) ) )
            // InternalArg.g:6558:1: ( ( rule__Force__XVectorAssignment_4_1 ) )
            {
            // InternalArg.g:6558:1: ( ( rule__Force__XVectorAssignment_4_1 ) )
            // InternalArg.g:6559:2: ( rule__Force__XVectorAssignment_4_1 )
            {
             before(grammarAccess.getForceAccess().getXVectorAssignment_4_1()); 
            // InternalArg.g:6560:2: ( rule__Force__XVectorAssignment_4_1 )
            // InternalArg.g:6560:3: rule__Force__XVectorAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Force__XVectorAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getXVectorAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__1__Impl"


    // $ANTLR start "rule__Force__Group_4__2"
    // InternalArg.g:6568:1: rule__Force__Group_4__2 : rule__Force__Group_4__2__Impl rule__Force__Group_4__3 ;
    public final void rule__Force__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6572:1: ( rule__Force__Group_4__2__Impl rule__Force__Group_4__3 )
            // InternalArg.g:6573:2: rule__Force__Group_4__2__Impl rule__Force__Group_4__3
            {
            pushFollow(FOLLOW_42);
            rule__Force__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__2"


    // $ANTLR start "rule__Force__Group_4__2__Impl"
    // InternalArg.g:6580:1: rule__Force__Group_4__2__Impl : ( ',' ) ;
    public final void rule__Force__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6584:1: ( ( ',' ) )
            // InternalArg.g:6585:1: ( ',' )
            {
            // InternalArg.g:6585:1: ( ',' )
            // InternalArg.g:6586:2: ','
            {
             before(grammarAccess.getForceAccess().getCommaKeyword_4_2()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getCommaKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__2__Impl"


    // $ANTLR start "rule__Force__Group_4__3"
    // InternalArg.g:6595:1: rule__Force__Group_4__3 : rule__Force__Group_4__3__Impl rule__Force__Group_4__4 ;
    public final void rule__Force__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6599:1: ( rule__Force__Group_4__3__Impl rule__Force__Group_4__4 )
            // InternalArg.g:6600:2: rule__Force__Group_4__3__Impl rule__Force__Group_4__4
            {
            pushFollow(FOLLOW_65);
            rule__Force__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__3"


    // $ANTLR start "rule__Force__Group_4__3__Impl"
    // InternalArg.g:6607:1: rule__Force__Group_4__3__Impl : ( ( rule__Force__YVectorAssignment_4_3 ) ) ;
    public final void rule__Force__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6611:1: ( ( ( rule__Force__YVectorAssignment_4_3 ) ) )
            // InternalArg.g:6612:1: ( ( rule__Force__YVectorAssignment_4_3 ) )
            {
            // InternalArg.g:6612:1: ( ( rule__Force__YVectorAssignment_4_3 ) )
            // InternalArg.g:6613:2: ( rule__Force__YVectorAssignment_4_3 )
            {
             before(grammarAccess.getForceAccess().getYVectorAssignment_4_3()); 
            // InternalArg.g:6614:2: ( rule__Force__YVectorAssignment_4_3 )
            // InternalArg.g:6614:3: rule__Force__YVectorAssignment_4_3
            {
            pushFollow(FOLLOW_2);
            rule__Force__YVectorAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getYVectorAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__3__Impl"


    // $ANTLR start "rule__Force__Group_4__4"
    // InternalArg.g:6622:1: rule__Force__Group_4__4 : rule__Force__Group_4__4__Impl rule__Force__Group_4__5 ;
    public final void rule__Force__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6626:1: ( rule__Force__Group_4__4__Impl rule__Force__Group_4__5 )
            // InternalArg.g:6627:2: rule__Force__Group_4__4__Impl rule__Force__Group_4__5
            {
            pushFollow(FOLLOW_42);
            rule__Force__Group_4__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__4"


    // $ANTLR start "rule__Force__Group_4__4__Impl"
    // InternalArg.g:6634:1: rule__Force__Group_4__4__Impl : ( ',' ) ;
    public final void rule__Force__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6638:1: ( ( ',' ) )
            // InternalArg.g:6639:1: ( ',' )
            {
            // InternalArg.g:6639:1: ( ',' )
            // InternalArg.g:6640:2: ','
            {
             before(grammarAccess.getForceAccess().getCommaKeyword_4_4()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getCommaKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__4__Impl"


    // $ANTLR start "rule__Force__Group_4__5"
    // InternalArg.g:6649:1: rule__Force__Group_4__5 : rule__Force__Group_4__5__Impl rule__Force__Group_4__6 ;
    public final void rule__Force__Group_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6653:1: ( rule__Force__Group_4__5__Impl rule__Force__Group_4__6 )
            // InternalArg.g:6654:2: rule__Force__Group_4__5__Impl rule__Force__Group_4__6
            {
            pushFollow(FOLLOW_28);
            rule__Force__Group_4__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Force__Group_4__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__5"


    // $ANTLR start "rule__Force__Group_4__5__Impl"
    // InternalArg.g:6661:1: rule__Force__Group_4__5__Impl : ( ( rule__Force__ZVectorAssignment_4_5 ) ) ;
    public final void rule__Force__Group_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6665:1: ( ( ( rule__Force__ZVectorAssignment_4_5 ) ) )
            // InternalArg.g:6666:1: ( ( rule__Force__ZVectorAssignment_4_5 ) )
            {
            // InternalArg.g:6666:1: ( ( rule__Force__ZVectorAssignment_4_5 ) )
            // InternalArg.g:6667:2: ( rule__Force__ZVectorAssignment_4_5 )
            {
             before(grammarAccess.getForceAccess().getZVectorAssignment_4_5()); 
            // InternalArg.g:6668:2: ( rule__Force__ZVectorAssignment_4_5 )
            // InternalArg.g:6668:3: rule__Force__ZVectorAssignment_4_5
            {
            pushFollow(FOLLOW_2);
            rule__Force__ZVectorAssignment_4_5();

            state._fsp--;


            }

             after(grammarAccess.getForceAccess().getZVectorAssignment_4_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__5__Impl"


    // $ANTLR start "rule__Force__Group_4__6"
    // InternalArg.g:6676:1: rule__Force__Group_4__6 : rule__Force__Group_4__6__Impl ;
    public final void rule__Force__Group_4__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6680:1: ( rule__Force__Group_4__6__Impl )
            // InternalArg.g:6681:2: rule__Force__Group_4__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Force__Group_4__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__6"


    // $ANTLR start "rule__Force__Group_4__6__Impl"
    // InternalArg.g:6687:1: rule__Force__Group_4__6__Impl : ( ']' ) ;
    public final void rule__Force__Group_4__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6691:1: ( ( ']' ) )
            // InternalArg.g:6692:1: ( ']' )
            {
            // InternalArg.g:6692:1: ( ']' )
            // InternalArg.g:6693:2: ']'
            {
             before(grammarAccess.getForceAccess().getRightSquareBracketKeyword_4_6()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getForceAccess().getRightSquareBracketKeyword_4_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__Group_4__6__Impl"


    // $ANTLR start "rule__GamePad__Group__0"
    // InternalArg.g:6703:1: rule__GamePad__Group__0 : rule__GamePad__Group__0__Impl rule__GamePad__Group__1 ;
    public final void rule__GamePad__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6707:1: ( rule__GamePad__Group__0__Impl rule__GamePad__Group__1 )
            // InternalArg.g:6708:2: rule__GamePad__Group__0__Impl rule__GamePad__Group__1
            {
            pushFollow(FOLLOW_66);
            rule__GamePad__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GamePad__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__0"


    // $ANTLR start "rule__GamePad__Group__0__Impl"
    // InternalArg.g:6715:1: rule__GamePad__Group__0__Impl : ( ( rule__GamePad__NameAssignment_0 ) ) ;
    public final void rule__GamePad__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6719:1: ( ( ( rule__GamePad__NameAssignment_0 ) ) )
            // InternalArg.g:6720:1: ( ( rule__GamePad__NameAssignment_0 ) )
            {
            // InternalArg.g:6720:1: ( ( rule__GamePad__NameAssignment_0 ) )
            // InternalArg.g:6721:2: ( rule__GamePad__NameAssignment_0 )
            {
             before(grammarAccess.getGamePadAccess().getNameAssignment_0()); 
            // InternalArg.g:6722:2: ( rule__GamePad__NameAssignment_0 )
            // InternalArg.g:6722:3: rule__GamePad__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__GamePad__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getGamePadAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__0__Impl"


    // $ANTLR start "rule__GamePad__Group__1"
    // InternalArg.g:6730:1: rule__GamePad__Group__1 : rule__GamePad__Group__1__Impl rule__GamePad__Group__2 ;
    public final void rule__GamePad__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6734:1: ( rule__GamePad__Group__1__Impl rule__GamePad__Group__2 )
            // InternalArg.g:6735:2: rule__GamePad__Group__1__Impl rule__GamePad__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__GamePad__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GamePad__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__1"


    // $ANTLR start "rule__GamePad__Group__1__Impl"
    // InternalArg.g:6742:1: rule__GamePad__Group__1__Impl : ( '->' ) ;
    public final void rule__GamePad__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6746:1: ( ( '->' ) )
            // InternalArg.g:6747:1: ( '->' )
            {
            // InternalArg.g:6747:1: ( '->' )
            // InternalArg.g:6748:2: '->'
            {
             before(grammarAccess.getGamePadAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getGamePadAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__1__Impl"


    // $ANTLR start "rule__GamePad__Group__2"
    // InternalArg.g:6757:1: rule__GamePad__Group__2 : rule__GamePad__Group__2__Impl ;
    public final void rule__GamePad__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6761:1: ( rule__GamePad__Group__2__Impl )
            // InternalArg.g:6762:2: rule__GamePad__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GamePad__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__2"


    // $ANTLR start "rule__GamePad__Group__2__Impl"
    // InternalArg.g:6768:1: rule__GamePad__Group__2__Impl : ( ( rule__GamePad__TriggerAssignment_2 ) ) ;
    public final void rule__GamePad__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6772:1: ( ( ( rule__GamePad__TriggerAssignment_2 ) ) )
            // InternalArg.g:6773:1: ( ( rule__GamePad__TriggerAssignment_2 ) )
            {
            // InternalArg.g:6773:1: ( ( rule__GamePad__TriggerAssignment_2 ) )
            // InternalArg.g:6774:2: ( rule__GamePad__TriggerAssignment_2 )
            {
             before(grammarAccess.getGamePadAccess().getTriggerAssignment_2()); 
            // InternalArg.g:6775:2: ( rule__GamePad__TriggerAssignment_2 )
            // InternalArg.g:6775:3: rule__GamePad__TriggerAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GamePad__TriggerAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGamePadAccess().getTriggerAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__Group__2__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__0"
    // InternalArg.g:6784:1: rule__ScoreSystem__Group__0 : rule__ScoreSystem__Group__0__Impl rule__ScoreSystem__Group__1 ;
    public final void rule__ScoreSystem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6788:1: ( rule__ScoreSystem__Group__0__Impl rule__ScoreSystem__Group__1 )
            // InternalArg.g:6789:2: rule__ScoreSystem__Group__0__Impl rule__ScoreSystem__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__ScoreSystem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__0"


    // $ANTLR start "rule__ScoreSystem__Group__0__Impl"
    // InternalArg.g:6796:1: rule__ScoreSystem__Group__0__Impl : ( 'start' ) ;
    public final void rule__ScoreSystem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6800:1: ( ( 'start' ) )
            // InternalArg.g:6801:1: ( 'start' )
            {
            // InternalArg.g:6801:1: ( 'start' )
            // InternalArg.g:6802:2: 'start'
            {
             before(grammarAccess.getScoreSystemAccess().getStartKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getScoreSystemAccess().getStartKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__0__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__1"
    // InternalArg.g:6811:1: rule__ScoreSystem__Group__1 : rule__ScoreSystem__Group__1__Impl rule__ScoreSystem__Group__2 ;
    public final void rule__ScoreSystem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6815:1: ( rule__ScoreSystem__Group__1__Impl rule__ScoreSystem__Group__2 )
            // InternalArg.g:6816:2: rule__ScoreSystem__Group__1__Impl rule__ScoreSystem__Group__2
            {
            pushFollow(FOLLOW_67);
            rule__ScoreSystem__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__1"


    // $ANTLR start "rule__ScoreSystem__Group__1__Impl"
    // InternalArg.g:6823:1: rule__ScoreSystem__Group__1__Impl : ( ( rule__ScoreSystem__StartAssignment_1 ) ) ;
    public final void rule__ScoreSystem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6827:1: ( ( ( rule__ScoreSystem__StartAssignment_1 ) ) )
            // InternalArg.g:6828:1: ( ( rule__ScoreSystem__StartAssignment_1 ) )
            {
            // InternalArg.g:6828:1: ( ( rule__ScoreSystem__StartAssignment_1 ) )
            // InternalArg.g:6829:2: ( rule__ScoreSystem__StartAssignment_1 )
            {
             before(grammarAccess.getScoreSystemAccess().getStartAssignment_1()); 
            // InternalArg.g:6830:2: ( rule__ScoreSystem__StartAssignment_1 )
            // InternalArg.g:6830:3: rule__ScoreSystem__StartAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ScoreSystem__StartAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScoreSystemAccess().getStartAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__1__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__2"
    // InternalArg.g:6838:1: rule__ScoreSystem__Group__2 : rule__ScoreSystem__Group__2__Impl rule__ScoreSystem__Group__3 ;
    public final void rule__ScoreSystem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6842:1: ( rule__ScoreSystem__Group__2__Impl rule__ScoreSystem__Group__3 )
            // InternalArg.g:6843:2: rule__ScoreSystem__Group__2__Impl rule__ScoreSystem__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__ScoreSystem__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__2"


    // $ANTLR start "rule__ScoreSystem__Group__2__Impl"
    // InternalArg.g:6850:1: rule__ScoreSystem__Group__2__Impl : ( 'finish' ) ;
    public final void rule__ScoreSystem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6854:1: ( ( 'finish' ) )
            // InternalArg.g:6855:1: ( 'finish' )
            {
            // InternalArg.g:6855:1: ( 'finish' )
            // InternalArg.g:6856:2: 'finish'
            {
             before(grammarAccess.getScoreSystemAccess().getFinishKeyword_2()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getScoreSystemAccess().getFinishKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__2__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__3"
    // InternalArg.g:6865:1: rule__ScoreSystem__Group__3 : rule__ScoreSystem__Group__3__Impl rule__ScoreSystem__Group__4 ;
    public final void rule__ScoreSystem__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6869:1: ( rule__ScoreSystem__Group__3__Impl rule__ScoreSystem__Group__4 )
            // InternalArg.g:6870:2: rule__ScoreSystem__Group__3__Impl rule__ScoreSystem__Group__4
            {
            pushFollow(FOLLOW_68);
            rule__ScoreSystem__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__3"


    // $ANTLR start "rule__ScoreSystem__Group__3__Impl"
    // InternalArg.g:6877:1: rule__ScoreSystem__Group__3__Impl : ( ( rule__ScoreSystem__FinishAssignment_3 ) ) ;
    public final void rule__ScoreSystem__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6881:1: ( ( ( rule__ScoreSystem__FinishAssignment_3 ) ) )
            // InternalArg.g:6882:1: ( ( rule__ScoreSystem__FinishAssignment_3 ) )
            {
            // InternalArg.g:6882:1: ( ( rule__ScoreSystem__FinishAssignment_3 ) )
            // InternalArg.g:6883:2: ( rule__ScoreSystem__FinishAssignment_3 )
            {
             before(grammarAccess.getScoreSystemAccess().getFinishAssignment_3()); 
            // InternalArg.g:6884:2: ( rule__ScoreSystem__FinishAssignment_3 )
            // InternalArg.g:6884:3: rule__ScoreSystem__FinishAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ScoreSystem__FinishAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getScoreSystemAccess().getFinishAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__3__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__4"
    // InternalArg.g:6892:1: rule__ScoreSystem__Group__4 : rule__ScoreSystem__Group__4__Impl rule__ScoreSystem__Group__5 ;
    public final void rule__ScoreSystem__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6896:1: ( rule__ScoreSystem__Group__4__Impl rule__ScoreSystem__Group__5 )
            // InternalArg.g:6897:2: rule__ScoreSystem__Group__4__Impl rule__ScoreSystem__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__ScoreSystem__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__4"


    // $ANTLR start "rule__ScoreSystem__Group__4__Impl"
    // InternalArg.g:6904:1: rule__ScoreSystem__Group__4__Impl : ( 'lives' ) ;
    public final void rule__ScoreSystem__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6908:1: ( ( 'lives' ) )
            // InternalArg.g:6909:1: ( 'lives' )
            {
            // InternalArg.g:6909:1: ( 'lives' )
            // InternalArg.g:6910:2: 'lives'
            {
             before(grammarAccess.getScoreSystemAccess().getLivesKeyword_4()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getScoreSystemAccess().getLivesKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__4__Impl"


    // $ANTLR start "rule__ScoreSystem__Group__5"
    // InternalArg.g:6919:1: rule__ScoreSystem__Group__5 : rule__ScoreSystem__Group__5__Impl ;
    public final void rule__ScoreSystem__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6923:1: ( rule__ScoreSystem__Group__5__Impl )
            // InternalArg.g:6924:2: rule__ScoreSystem__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ScoreSystem__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__5"


    // $ANTLR start "rule__ScoreSystem__Group__5__Impl"
    // InternalArg.g:6930:1: rule__ScoreSystem__Group__5__Impl : ( ( rule__ScoreSystem__LivesAssignment_5 ) ) ;
    public final void rule__ScoreSystem__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6934:1: ( ( ( rule__ScoreSystem__LivesAssignment_5 ) ) )
            // InternalArg.g:6935:1: ( ( rule__ScoreSystem__LivesAssignment_5 ) )
            {
            // InternalArg.g:6935:1: ( ( rule__ScoreSystem__LivesAssignment_5 ) )
            // InternalArg.g:6936:2: ( rule__ScoreSystem__LivesAssignment_5 )
            {
             before(grammarAccess.getScoreSystemAccess().getLivesAssignment_5()); 
            // InternalArg.g:6937:2: ( rule__ScoreSystem__LivesAssignment_5 )
            // InternalArg.g:6937:3: rule__ScoreSystem__LivesAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__ScoreSystem__LivesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getScoreSystemAccess().getLivesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__Group__5__Impl"


    // $ANTLR start "rule__Trigger__Group__0"
    // InternalArg.g:6946:1: rule__Trigger__Group__0 : rule__Trigger__Group__0__Impl rule__Trigger__Group__1 ;
    public final void rule__Trigger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6950:1: ( rule__Trigger__Group__0__Impl rule__Trigger__Group__1 )
            // InternalArg.g:6951:2: rule__Trigger__Group__0__Impl rule__Trigger__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Trigger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__0"


    // $ANTLR start "rule__Trigger__Group__0__Impl"
    // InternalArg.g:6958:1: rule__Trigger__Group__0__Impl : ( ( rule__Trigger__NameAssignment_0 ) ) ;
    public final void rule__Trigger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6962:1: ( ( ( rule__Trigger__NameAssignment_0 ) ) )
            // InternalArg.g:6963:1: ( ( rule__Trigger__NameAssignment_0 ) )
            {
            // InternalArg.g:6963:1: ( ( rule__Trigger__NameAssignment_0 ) )
            // InternalArg.g:6964:2: ( rule__Trigger__NameAssignment_0 )
            {
             before(grammarAccess.getTriggerAccess().getNameAssignment_0()); 
            // InternalArg.g:6965:2: ( rule__Trigger__NameAssignment_0 )
            // InternalArg.g:6965:3: rule__Trigger__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__0__Impl"


    // $ANTLR start "rule__Trigger__Group__1"
    // InternalArg.g:6973:1: rule__Trigger__Group__1 : rule__Trigger__Group__1__Impl rule__Trigger__Group__2 ;
    public final void rule__Trigger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6977:1: ( rule__Trigger__Group__1__Impl rule__Trigger__Group__2 )
            // InternalArg.g:6978:2: rule__Trigger__Group__1__Impl rule__Trigger__Group__2
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__1"


    // $ANTLR start "rule__Trigger__Group__1__Impl"
    // InternalArg.g:6985:1: rule__Trigger__Group__1__Impl : ( '{' ) ;
    public final void rule__Trigger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:6989:1: ( ( '{' ) )
            // InternalArg.g:6990:1: ( '{' )
            {
            // InternalArg.g:6990:1: ( '{' )
            // InternalArg.g:6991:2: '{'
            {
             before(grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__1__Impl"


    // $ANTLR start "rule__Trigger__Group__2"
    // InternalArg.g:7000:1: rule__Trigger__Group__2 : rule__Trigger__Group__2__Impl rule__Trigger__Group__3 ;
    public final void rule__Trigger__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7004:1: ( rule__Trigger__Group__2__Impl rule__Trigger__Group__3 )
            // InternalArg.g:7005:2: rule__Trigger__Group__2__Impl rule__Trigger__Group__3
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__2"


    // $ANTLR start "rule__Trigger__Group__2__Impl"
    // InternalArg.g:7012:1: rule__Trigger__Group__2__Impl : ( ( rule__Trigger__Group_2__0 )? ) ;
    public final void rule__Trigger__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7016:1: ( ( ( rule__Trigger__Group_2__0 )? ) )
            // InternalArg.g:7017:1: ( ( rule__Trigger__Group_2__0 )? )
            {
            // InternalArg.g:7017:1: ( ( rule__Trigger__Group_2__0 )? )
            // InternalArg.g:7018:2: ( rule__Trigger__Group_2__0 )?
            {
             before(grammarAccess.getTriggerAccess().getGroup_2()); 
            // InternalArg.g:7019:2: ( rule__Trigger__Group_2__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==95) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalArg.g:7019:3: rule__Trigger__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trigger__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTriggerAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__2__Impl"


    // $ANTLR start "rule__Trigger__Group__3"
    // InternalArg.g:7027:1: rule__Trigger__Group__3 : rule__Trigger__Group__3__Impl rule__Trigger__Group__4 ;
    public final void rule__Trigger__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7031:1: ( rule__Trigger__Group__3__Impl rule__Trigger__Group__4 )
            // InternalArg.g:7032:2: rule__Trigger__Group__3__Impl rule__Trigger__Group__4
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__3"


    // $ANTLR start "rule__Trigger__Group__3__Impl"
    // InternalArg.g:7039:1: rule__Trigger__Group__3__Impl : ( ( rule__Trigger__Group_3__0 )? ) ;
    public final void rule__Trigger__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7043:1: ( ( ( rule__Trigger__Group_3__0 )? ) )
            // InternalArg.g:7044:1: ( ( rule__Trigger__Group_3__0 )? )
            {
            // InternalArg.g:7044:1: ( ( rule__Trigger__Group_3__0 )? )
            // InternalArg.g:7045:2: ( rule__Trigger__Group_3__0 )?
            {
             before(grammarAccess.getTriggerAccess().getGroup_3()); 
            // InternalArg.g:7046:2: ( rule__Trigger__Group_3__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==96) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalArg.g:7046:3: rule__Trigger__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trigger__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTriggerAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__3__Impl"


    // $ANTLR start "rule__Trigger__Group__4"
    // InternalArg.g:7054:1: rule__Trigger__Group__4 : rule__Trigger__Group__4__Impl rule__Trigger__Group__5 ;
    public final void rule__Trigger__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7058:1: ( rule__Trigger__Group__4__Impl rule__Trigger__Group__5 )
            // InternalArg.g:7059:2: rule__Trigger__Group__4__Impl rule__Trigger__Group__5
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__4"


    // $ANTLR start "rule__Trigger__Group__4__Impl"
    // InternalArg.g:7066:1: rule__Trigger__Group__4__Impl : ( ( rule__Trigger__Group_4__0 )? ) ;
    public final void rule__Trigger__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7070:1: ( ( ( rule__Trigger__Group_4__0 )? ) )
            // InternalArg.g:7071:1: ( ( rule__Trigger__Group_4__0 )? )
            {
            // InternalArg.g:7071:1: ( ( rule__Trigger__Group_4__0 )? )
            // InternalArg.g:7072:2: ( rule__Trigger__Group_4__0 )?
            {
             before(grammarAccess.getTriggerAccess().getGroup_4()); 
            // InternalArg.g:7073:2: ( rule__Trigger__Group_4__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==51) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalArg.g:7073:3: rule__Trigger__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trigger__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTriggerAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__4__Impl"


    // $ANTLR start "rule__Trigger__Group__5"
    // InternalArg.g:7081:1: rule__Trigger__Group__5 : rule__Trigger__Group__5__Impl rule__Trigger__Group__6 ;
    public final void rule__Trigger__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7085:1: ( rule__Trigger__Group__5__Impl rule__Trigger__Group__6 )
            // InternalArg.g:7086:2: rule__Trigger__Group__5__Impl rule__Trigger__Group__6
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__5"


    // $ANTLR start "rule__Trigger__Group__5__Impl"
    // InternalArg.g:7093:1: rule__Trigger__Group__5__Impl : ( ( rule__Trigger__Group_5__0 )? ) ;
    public final void rule__Trigger__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7097:1: ( ( ( rule__Trigger__Group_5__0 )? ) )
            // InternalArg.g:7098:1: ( ( rule__Trigger__Group_5__0 )? )
            {
            // InternalArg.g:7098:1: ( ( rule__Trigger__Group_5__0 )? )
            // InternalArg.g:7099:2: ( rule__Trigger__Group_5__0 )?
            {
             before(grammarAccess.getTriggerAccess().getGroup_5()); 
            // InternalArg.g:7100:2: ( rule__Trigger__Group_5__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==97) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalArg.g:7100:3: rule__Trigger__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trigger__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTriggerAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__5__Impl"


    // $ANTLR start "rule__Trigger__Group__6"
    // InternalArg.g:7108:1: rule__Trigger__Group__6 : rule__Trigger__Group__6__Impl rule__Trigger__Group__7 ;
    public final void rule__Trigger__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7112:1: ( rule__Trigger__Group__6__Impl rule__Trigger__Group__7 )
            // InternalArg.g:7113:2: rule__Trigger__Group__6__Impl rule__Trigger__Group__7
            {
            pushFollow(FOLLOW_69);
            rule__Trigger__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__6"


    // $ANTLR start "rule__Trigger__Group__6__Impl"
    // InternalArg.g:7120:1: rule__Trigger__Group__6__Impl : ( ( rule__Trigger__Group_6__0 )? ) ;
    public final void rule__Trigger__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7124:1: ( ( ( rule__Trigger__Group_6__0 )? ) )
            // InternalArg.g:7125:1: ( ( rule__Trigger__Group_6__0 )? )
            {
            // InternalArg.g:7125:1: ( ( rule__Trigger__Group_6__0 )? )
            // InternalArg.g:7126:2: ( rule__Trigger__Group_6__0 )?
            {
             before(grammarAccess.getTriggerAccess().getGroup_6()); 
            // InternalArg.g:7127:2: ( rule__Trigger__Group_6__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==98) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalArg.g:7127:3: rule__Trigger__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trigger__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTriggerAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__6__Impl"


    // $ANTLR start "rule__Trigger__Group__7"
    // InternalArg.g:7135:1: rule__Trigger__Group__7 : rule__Trigger__Group__7__Impl ;
    public final void rule__Trigger__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7139:1: ( rule__Trigger__Group__7__Impl )
            // InternalArg.g:7140:2: rule__Trigger__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__7"


    // $ANTLR start "rule__Trigger__Group__7__Impl"
    // InternalArg.g:7146:1: rule__Trigger__Group__7__Impl : ( '}' ) ;
    public final void rule__Trigger__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7150:1: ( ( '}' ) )
            // InternalArg.g:7151:1: ( '}' )
            {
            // InternalArg.g:7151:1: ( '}' )
            // InternalArg.g:7152:2: '}'
            {
             before(grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group__7__Impl"


    // $ANTLR start "rule__Trigger__Group_2__0"
    // InternalArg.g:7162:1: rule__Trigger__Group_2__0 : rule__Trigger__Group_2__0__Impl rule__Trigger__Group_2__1 ;
    public final void rule__Trigger__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7166:1: ( rule__Trigger__Group_2__0__Impl rule__Trigger__Group_2__1 )
            // InternalArg.g:7167:2: rule__Trigger__Group_2__0__Impl rule__Trigger__Group_2__1
            {
            pushFollow(FOLLOW_70);
            rule__Trigger__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_2__0"


    // $ANTLR start "rule__Trigger__Group_2__0__Impl"
    // InternalArg.g:7174:1: rule__Trigger__Group_2__0__Impl : ( 'action' ) ;
    public final void rule__Trigger__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7178:1: ( ( 'action' ) )
            // InternalArg.g:7179:1: ( 'action' )
            {
            // InternalArg.g:7179:1: ( 'action' )
            // InternalArg.g:7180:2: 'action'
            {
             before(grammarAccess.getTriggerAccess().getActionKeyword_2_0()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getActionKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_2__0__Impl"


    // $ANTLR start "rule__Trigger__Group_2__1"
    // InternalArg.g:7189:1: rule__Trigger__Group_2__1 : rule__Trigger__Group_2__1__Impl ;
    public final void rule__Trigger__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7193:1: ( rule__Trigger__Group_2__1__Impl )
            // InternalArg.g:7194:2: rule__Trigger__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_2__1"


    // $ANTLR start "rule__Trigger__Group_2__1__Impl"
    // InternalArg.g:7200:1: rule__Trigger__Group_2__1__Impl : ( ( rule__Trigger__ActionAssignment_2_1 ) ) ;
    public final void rule__Trigger__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7204:1: ( ( ( rule__Trigger__ActionAssignment_2_1 ) ) )
            // InternalArg.g:7205:1: ( ( rule__Trigger__ActionAssignment_2_1 ) )
            {
            // InternalArg.g:7205:1: ( ( rule__Trigger__ActionAssignment_2_1 ) )
            // InternalArg.g:7206:2: ( rule__Trigger__ActionAssignment_2_1 )
            {
             before(grammarAccess.getTriggerAccess().getActionAssignment_2_1()); 
            // InternalArg.g:7207:2: ( rule__Trigger__ActionAssignment_2_1 )
            // InternalArg.g:7207:3: rule__Trigger__ActionAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__ActionAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getActionAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_2__1__Impl"


    // $ANTLR start "rule__Trigger__Group_3__0"
    // InternalArg.g:7216:1: rule__Trigger__Group_3__0 : rule__Trigger__Group_3__0__Impl rule__Trigger__Group_3__1 ;
    public final void rule__Trigger__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7220:1: ( rule__Trigger__Group_3__0__Impl rule__Trigger__Group_3__1 )
            // InternalArg.g:7221:2: rule__Trigger__Group_3__0__Impl rule__Trigger__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Trigger__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_3__0"


    // $ANTLR start "rule__Trigger__Group_3__0__Impl"
    // InternalArg.g:7228:1: rule__Trigger__Group_3__0__Impl : ( 'message' ) ;
    public final void rule__Trigger__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7232:1: ( ( 'message' ) )
            // InternalArg.g:7233:1: ( 'message' )
            {
            // InternalArg.g:7233:1: ( 'message' )
            // InternalArg.g:7234:2: 'message'
            {
             before(grammarAccess.getTriggerAccess().getMessageKeyword_3_0()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getMessageKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_3__0__Impl"


    // $ANTLR start "rule__Trigger__Group_3__1"
    // InternalArg.g:7243:1: rule__Trigger__Group_3__1 : rule__Trigger__Group_3__1__Impl ;
    public final void rule__Trigger__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7247:1: ( rule__Trigger__Group_3__1__Impl )
            // InternalArg.g:7248:2: rule__Trigger__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_3__1"


    // $ANTLR start "rule__Trigger__Group_3__1__Impl"
    // InternalArg.g:7254:1: rule__Trigger__Group_3__1__Impl : ( ( rule__Trigger__MessageAssignment_3_1 ) ) ;
    public final void rule__Trigger__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7258:1: ( ( ( rule__Trigger__MessageAssignment_3_1 ) ) )
            // InternalArg.g:7259:1: ( ( rule__Trigger__MessageAssignment_3_1 ) )
            {
            // InternalArg.g:7259:1: ( ( rule__Trigger__MessageAssignment_3_1 ) )
            // InternalArg.g:7260:2: ( rule__Trigger__MessageAssignment_3_1 )
            {
             before(grammarAccess.getTriggerAccess().getMessageAssignment_3_1()); 
            // InternalArg.g:7261:2: ( rule__Trigger__MessageAssignment_3_1 )
            // InternalArg.g:7261:3: rule__Trigger__MessageAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__MessageAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getMessageAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_3__1__Impl"


    // $ANTLR start "rule__Trigger__Group_4__0"
    // InternalArg.g:7270:1: rule__Trigger__Group_4__0 : rule__Trigger__Group_4__0__Impl rule__Trigger__Group_4__1 ;
    public final void rule__Trigger__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7274:1: ( rule__Trigger__Group_4__0__Impl rule__Trigger__Group_4__1 )
            // InternalArg.g:7275:2: rule__Trigger__Group_4__0__Impl rule__Trigger__Group_4__1
            {
            pushFollow(FOLLOW_25);
            rule__Trigger__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_4__0"


    // $ANTLR start "rule__Trigger__Group_4__0__Impl"
    // InternalArg.g:7282:1: rule__Trigger__Group_4__0__Impl : ( 'score' ) ;
    public final void rule__Trigger__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7286:1: ( ( 'score' ) )
            // InternalArg.g:7287:1: ( 'score' )
            {
            // InternalArg.g:7287:1: ( 'score' )
            // InternalArg.g:7288:2: 'score'
            {
             before(grammarAccess.getTriggerAccess().getScoreKeyword_4_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getScoreKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_4__0__Impl"


    // $ANTLR start "rule__Trigger__Group_4__1"
    // InternalArg.g:7297:1: rule__Trigger__Group_4__1 : rule__Trigger__Group_4__1__Impl ;
    public final void rule__Trigger__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7301:1: ( rule__Trigger__Group_4__1__Impl )
            // InternalArg.g:7302:2: rule__Trigger__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_4__1"


    // $ANTLR start "rule__Trigger__Group_4__1__Impl"
    // InternalArg.g:7308:1: rule__Trigger__Group_4__1__Impl : ( ( rule__Trigger__ScoreChangeAssignment_4_1 ) ) ;
    public final void rule__Trigger__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7312:1: ( ( ( rule__Trigger__ScoreChangeAssignment_4_1 ) ) )
            // InternalArg.g:7313:1: ( ( rule__Trigger__ScoreChangeAssignment_4_1 ) )
            {
            // InternalArg.g:7313:1: ( ( rule__Trigger__ScoreChangeAssignment_4_1 ) )
            // InternalArg.g:7314:2: ( rule__Trigger__ScoreChangeAssignment_4_1 )
            {
             before(grammarAccess.getTriggerAccess().getScoreChangeAssignment_4_1()); 
            // InternalArg.g:7315:2: ( rule__Trigger__ScoreChangeAssignment_4_1 )
            // InternalArg.g:7315:3: rule__Trigger__ScoreChangeAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__ScoreChangeAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getScoreChangeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_4__1__Impl"


    // $ANTLR start "rule__Trigger__Group_5__0"
    // InternalArg.g:7324:1: rule__Trigger__Group_5__0 : rule__Trigger__Group_5__0__Impl rule__Trigger__Group_5__1 ;
    public final void rule__Trigger__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7328:1: ( rule__Trigger__Group_5__0__Impl rule__Trigger__Group_5__1 )
            // InternalArg.g:7329:2: rule__Trigger__Group_5__0__Impl rule__Trigger__Group_5__1
            {
            pushFollow(FOLLOW_25);
            rule__Trigger__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_5__0"


    // $ANTLR start "rule__Trigger__Group_5__0__Impl"
    // InternalArg.g:7336:1: rule__Trigger__Group_5__0__Impl : ( 'timeEach' ) ;
    public final void rule__Trigger__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7340:1: ( ( 'timeEach' ) )
            // InternalArg.g:7341:1: ( 'timeEach' )
            {
            // InternalArg.g:7341:1: ( 'timeEach' )
            // InternalArg.g:7342:2: 'timeEach'
            {
             before(grammarAccess.getTriggerAccess().getTimeEachKeyword_5_0()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getTimeEachKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_5__0__Impl"


    // $ANTLR start "rule__Trigger__Group_5__1"
    // InternalArg.g:7351:1: rule__Trigger__Group_5__1 : rule__Trigger__Group_5__1__Impl ;
    public final void rule__Trigger__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7355:1: ( rule__Trigger__Group_5__1__Impl )
            // InternalArg.g:7356:2: rule__Trigger__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_5__1"


    // $ANTLR start "rule__Trigger__Group_5__1__Impl"
    // InternalArg.g:7362:1: rule__Trigger__Group_5__1__Impl : ( ( rule__Trigger__TimeTriggerAssignment_5_1 ) ) ;
    public final void rule__Trigger__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7366:1: ( ( ( rule__Trigger__TimeTriggerAssignment_5_1 ) ) )
            // InternalArg.g:7367:1: ( ( rule__Trigger__TimeTriggerAssignment_5_1 ) )
            {
            // InternalArg.g:7367:1: ( ( rule__Trigger__TimeTriggerAssignment_5_1 ) )
            // InternalArg.g:7368:2: ( rule__Trigger__TimeTriggerAssignment_5_1 )
            {
             before(grammarAccess.getTriggerAccess().getTimeTriggerAssignment_5_1()); 
            // InternalArg.g:7369:2: ( rule__Trigger__TimeTriggerAssignment_5_1 )
            // InternalArg.g:7369:3: rule__Trigger__TimeTriggerAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__TimeTriggerAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getTimeTriggerAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_5__1__Impl"


    // $ANTLR start "rule__Trigger__Group_6__0"
    // InternalArg.g:7378:1: rule__Trigger__Group_6__0 : rule__Trigger__Group_6__0__Impl rule__Trigger__Group_6__1 ;
    public final void rule__Trigger__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7382:1: ( rule__Trigger__Group_6__0__Impl rule__Trigger__Group_6__1 )
            // InternalArg.g:7383:2: rule__Trigger__Group_6__0__Impl rule__Trigger__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Trigger__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__0"


    // $ANTLR start "rule__Trigger__Group_6__0__Impl"
    // InternalArg.g:7390:1: rule__Trigger__Group_6__0__Impl : ( 'changes' ) ;
    public final void rule__Trigger__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7394:1: ( ( 'changes' ) )
            // InternalArg.g:7395:1: ( 'changes' )
            {
            // InternalArg.g:7395:1: ( 'changes' )
            // InternalArg.g:7396:2: 'changes'
            {
             before(grammarAccess.getTriggerAccess().getChangesKeyword_6_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getChangesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__0__Impl"


    // $ANTLR start "rule__Trigger__Group_6__1"
    // InternalArg.g:7405:1: rule__Trigger__Group_6__1 : rule__Trigger__Group_6__1__Impl rule__Trigger__Group_6__2 ;
    public final void rule__Trigger__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7409:1: ( rule__Trigger__Group_6__1__Impl rule__Trigger__Group_6__2 )
            // InternalArg.g:7410:2: rule__Trigger__Group_6__1__Impl rule__Trigger__Group_6__2
            {
            pushFollow(FOLLOW_71);
            rule__Trigger__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__1"


    // $ANTLR start "rule__Trigger__Group_6__1__Impl"
    // InternalArg.g:7417:1: rule__Trigger__Group_6__1__Impl : ( '{' ) ;
    public final void rule__Trigger__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7421:1: ( ( '{' ) )
            // InternalArg.g:7422:1: ( '{' )
            {
            // InternalArg.g:7422:1: ( '{' )
            // InternalArg.g:7423:2: '{'
            {
             before(grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_6_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__1__Impl"


    // $ANTLR start "rule__Trigger__Group_6__2"
    // InternalArg.g:7432:1: rule__Trigger__Group_6__2 : rule__Trigger__Group_6__2__Impl rule__Trigger__Group_6__3 ;
    public final void rule__Trigger__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7436:1: ( rule__Trigger__Group_6__2__Impl rule__Trigger__Group_6__3 )
            // InternalArg.g:7437:2: rule__Trigger__Group_6__2__Impl rule__Trigger__Group_6__3
            {
            pushFollow(FOLLOW_72);
            rule__Trigger__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__2"


    // $ANTLR start "rule__Trigger__Group_6__2__Impl"
    // InternalArg.g:7444:1: rule__Trigger__Group_6__2__Impl : ( ( rule__Trigger__PhysicChangesAssignment_6_2 ) ) ;
    public final void rule__Trigger__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7448:1: ( ( ( rule__Trigger__PhysicChangesAssignment_6_2 ) ) )
            // InternalArg.g:7449:1: ( ( rule__Trigger__PhysicChangesAssignment_6_2 ) )
            {
            // InternalArg.g:7449:1: ( ( rule__Trigger__PhysicChangesAssignment_6_2 ) )
            // InternalArg.g:7450:2: ( rule__Trigger__PhysicChangesAssignment_6_2 )
            {
             before(grammarAccess.getTriggerAccess().getPhysicChangesAssignment_6_2()); 
            // InternalArg.g:7451:2: ( rule__Trigger__PhysicChangesAssignment_6_2 )
            // InternalArg.g:7451:3: rule__Trigger__PhysicChangesAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__PhysicChangesAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getTriggerAccess().getPhysicChangesAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__2__Impl"


    // $ANTLR start "rule__Trigger__Group_6__3"
    // InternalArg.g:7459:1: rule__Trigger__Group_6__3 : rule__Trigger__Group_6__3__Impl rule__Trigger__Group_6__4 ;
    public final void rule__Trigger__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7463:1: ( rule__Trigger__Group_6__3__Impl rule__Trigger__Group_6__4 )
            // InternalArg.g:7464:2: rule__Trigger__Group_6__3__Impl rule__Trigger__Group_6__4
            {
            pushFollow(FOLLOW_72);
            rule__Trigger__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trigger__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__3"


    // $ANTLR start "rule__Trigger__Group_6__3__Impl"
    // InternalArg.g:7471:1: rule__Trigger__Group_6__3__Impl : ( ( rule__Trigger__PhysicChangesAssignment_6_3 )* ) ;
    public final void rule__Trigger__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7475:1: ( ( ( rule__Trigger__PhysicChangesAssignment_6_3 )* ) )
            // InternalArg.g:7476:1: ( ( rule__Trigger__PhysicChangesAssignment_6_3 )* )
            {
            // InternalArg.g:7476:1: ( ( rule__Trigger__PhysicChangesAssignment_6_3 )* )
            // InternalArg.g:7477:2: ( rule__Trigger__PhysicChangesAssignment_6_3 )*
            {
             before(grammarAccess.getTriggerAccess().getPhysicChangesAssignment_6_3()); 
            // InternalArg.g:7478:2: ( rule__Trigger__PhysicChangesAssignment_6_3 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==102) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalArg.g:7478:3: rule__Trigger__PhysicChangesAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_73);
            	    rule__Trigger__PhysicChangesAssignment_6_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getTriggerAccess().getPhysicChangesAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__3__Impl"


    // $ANTLR start "rule__Trigger__Group_6__4"
    // InternalArg.g:7486:1: rule__Trigger__Group_6__4 : rule__Trigger__Group_6__4__Impl ;
    public final void rule__Trigger__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7490:1: ( rule__Trigger__Group_6__4__Impl )
            // InternalArg.g:7491:2: rule__Trigger__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trigger__Group_6__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__4"


    // $ANTLR start "rule__Trigger__Group_6__4__Impl"
    // InternalArg.g:7497:1: rule__Trigger__Group_6__4__Impl : ( '}' ) ;
    public final void rule__Trigger__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7501:1: ( ( '}' ) )
            // InternalArg.g:7502:1: ( '}' )
            {
            // InternalArg.g:7502:1: ( '}' )
            // InternalArg.g:7503:2: '}'
            {
             before(grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_6_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__Group_6__4__Impl"


    // $ANTLR start "rule__Collision__Group__0"
    // InternalArg.g:7513:1: rule__Collision__Group__0 : rule__Collision__Group__0__Impl rule__Collision__Group__1 ;
    public final void rule__Collision__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7517:1: ( rule__Collision__Group__0__Impl rule__Collision__Group__1 )
            // InternalArg.g:7518:2: rule__Collision__Group__0__Impl rule__Collision__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Collision__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Collision__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__0"


    // $ANTLR start "rule__Collision__Group__0__Impl"
    // InternalArg.g:7525:1: rule__Collision__Group__0__Impl : ( 'element' ) ;
    public final void rule__Collision__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7529:1: ( ( 'element' ) )
            // InternalArg.g:7530:1: ( 'element' )
            {
            // InternalArg.g:7530:1: ( 'element' )
            // InternalArg.g:7531:2: 'element'
            {
             before(grammarAccess.getCollisionAccess().getElementKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getCollisionAccess().getElementKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__0__Impl"


    // $ANTLR start "rule__Collision__Group__1"
    // InternalArg.g:7540:1: rule__Collision__Group__1 : rule__Collision__Group__1__Impl rule__Collision__Group__2 ;
    public final void rule__Collision__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7544:1: ( rule__Collision__Group__1__Impl rule__Collision__Group__2 )
            // InternalArg.g:7545:2: rule__Collision__Group__1__Impl rule__Collision__Group__2
            {
            pushFollow(FOLLOW_74);
            rule__Collision__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Collision__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__1"


    // $ANTLR start "rule__Collision__Group__1__Impl"
    // InternalArg.g:7552:1: rule__Collision__Group__1__Impl : ( ( rule__Collision__ClassAAssignment_1 ) ) ;
    public final void rule__Collision__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7556:1: ( ( ( rule__Collision__ClassAAssignment_1 ) ) )
            // InternalArg.g:7557:1: ( ( rule__Collision__ClassAAssignment_1 ) )
            {
            // InternalArg.g:7557:1: ( ( rule__Collision__ClassAAssignment_1 ) )
            // InternalArg.g:7558:2: ( rule__Collision__ClassAAssignment_1 )
            {
             before(grammarAccess.getCollisionAccess().getClassAAssignment_1()); 
            // InternalArg.g:7559:2: ( rule__Collision__ClassAAssignment_1 )
            // InternalArg.g:7559:3: rule__Collision__ClassAAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Collision__ClassAAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCollisionAccess().getClassAAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__1__Impl"


    // $ANTLR start "rule__Collision__Group__2"
    // InternalArg.g:7567:1: rule__Collision__Group__2 : rule__Collision__Group__2__Impl rule__Collision__Group__3 ;
    public final void rule__Collision__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7571:1: ( rule__Collision__Group__2__Impl rule__Collision__Group__3 )
            // InternalArg.g:7572:2: rule__Collision__Group__2__Impl rule__Collision__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Collision__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Collision__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__2"


    // $ANTLR start "rule__Collision__Group__2__Impl"
    // InternalArg.g:7579:1: rule__Collision__Group__2__Impl : ( 'to' ) ;
    public final void rule__Collision__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7583:1: ( ( 'to' ) )
            // InternalArg.g:7584:1: ( 'to' )
            {
            // InternalArg.g:7584:1: ( 'to' )
            // InternalArg.g:7585:2: 'to'
            {
             before(grammarAccess.getCollisionAccess().getToKeyword_2()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getCollisionAccess().getToKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__2__Impl"


    // $ANTLR start "rule__Collision__Group__3"
    // InternalArg.g:7594:1: rule__Collision__Group__3 : rule__Collision__Group__3__Impl rule__Collision__Group__4 ;
    public final void rule__Collision__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7598:1: ( rule__Collision__Group__3__Impl rule__Collision__Group__4 )
            // InternalArg.g:7599:2: rule__Collision__Group__3__Impl rule__Collision__Group__4
            {
            pushFollow(FOLLOW_66);
            rule__Collision__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Collision__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__3"


    // $ANTLR start "rule__Collision__Group__3__Impl"
    // InternalArg.g:7606:1: rule__Collision__Group__3__Impl : ( ( rule__Collision__ClassBAssignment_3 ) ) ;
    public final void rule__Collision__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7610:1: ( ( ( rule__Collision__ClassBAssignment_3 ) ) )
            // InternalArg.g:7611:1: ( ( rule__Collision__ClassBAssignment_3 ) )
            {
            // InternalArg.g:7611:1: ( ( rule__Collision__ClassBAssignment_3 ) )
            // InternalArg.g:7612:2: ( rule__Collision__ClassBAssignment_3 )
            {
             before(grammarAccess.getCollisionAccess().getClassBAssignment_3()); 
            // InternalArg.g:7613:2: ( rule__Collision__ClassBAssignment_3 )
            // InternalArg.g:7613:3: rule__Collision__ClassBAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Collision__ClassBAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCollisionAccess().getClassBAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__3__Impl"


    // $ANTLR start "rule__Collision__Group__4"
    // InternalArg.g:7621:1: rule__Collision__Group__4 : rule__Collision__Group__4__Impl rule__Collision__Group__5 ;
    public final void rule__Collision__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7625:1: ( rule__Collision__Group__4__Impl rule__Collision__Group__5 )
            // InternalArg.g:7626:2: rule__Collision__Group__4__Impl rule__Collision__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Collision__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Collision__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__4"


    // $ANTLR start "rule__Collision__Group__4__Impl"
    // InternalArg.g:7633:1: rule__Collision__Group__4__Impl : ( '->' ) ;
    public final void rule__Collision__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7637:1: ( ( '->' ) )
            // InternalArg.g:7638:1: ( '->' )
            {
            // InternalArg.g:7638:1: ( '->' )
            // InternalArg.g:7639:2: '->'
            {
             before(grammarAccess.getCollisionAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getCollisionAccess().getHyphenMinusGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__4__Impl"


    // $ANTLR start "rule__Collision__Group__5"
    // InternalArg.g:7648:1: rule__Collision__Group__5 : rule__Collision__Group__5__Impl ;
    public final void rule__Collision__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7652:1: ( rule__Collision__Group__5__Impl )
            // InternalArg.g:7653:2: rule__Collision__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Collision__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__5"


    // $ANTLR start "rule__Collision__Group__5__Impl"
    // InternalArg.g:7659:1: rule__Collision__Group__5__Impl : ( ( rule__Collision__ActionAssignment_5 ) ) ;
    public final void rule__Collision__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7663:1: ( ( ( rule__Collision__ActionAssignment_5 ) ) )
            // InternalArg.g:7664:1: ( ( rule__Collision__ActionAssignment_5 ) )
            {
            // InternalArg.g:7664:1: ( ( rule__Collision__ActionAssignment_5 ) )
            // InternalArg.g:7665:2: ( rule__Collision__ActionAssignment_5 )
            {
             before(grammarAccess.getCollisionAccess().getActionAssignment_5()); 
            // InternalArg.g:7666:2: ( rule__Collision__ActionAssignment_5 )
            // InternalArg.g:7666:3: rule__Collision__ActionAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Collision__ActionAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCollisionAccess().getActionAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__Group__5__Impl"


    // $ANTLR start "rule__ObjInit__Group__0"
    // InternalArg.g:7675:1: rule__ObjInit__Group__0 : rule__ObjInit__Group__0__Impl rule__ObjInit__Group__1 ;
    public final void rule__ObjInit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7679:1: ( rule__ObjInit__Group__0__Impl rule__ObjInit__Group__1 )
            // InternalArg.g:7680:2: rule__ObjInit__Group__0__Impl rule__ObjInit__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__ObjInit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__0"


    // $ANTLR start "rule__ObjInit__Group__0__Impl"
    // InternalArg.g:7687:1: rule__ObjInit__Group__0__Impl : ( ( rule__ObjInit__NameAssignment_0 ) ) ;
    public final void rule__ObjInit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7691:1: ( ( ( rule__ObjInit__NameAssignment_0 ) ) )
            // InternalArg.g:7692:1: ( ( rule__ObjInit__NameAssignment_0 ) )
            {
            // InternalArg.g:7692:1: ( ( rule__ObjInit__NameAssignment_0 ) )
            // InternalArg.g:7693:2: ( rule__ObjInit__NameAssignment_0 )
            {
             before(grammarAccess.getObjInitAccess().getNameAssignment_0()); 
            // InternalArg.g:7694:2: ( rule__ObjInit__NameAssignment_0 )
            // InternalArg.g:7694:3: rule__ObjInit__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__0__Impl"


    // $ANTLR start "rule__ObjInit__Group__1"
    // InternalArg.g:7702:1: rule__ObjInit__Group__1 : rule__ObjInit__Group__1__Impl rule__ObjInit__Group__2 ;
    public final void rule__ObjInit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7706:1: ( rule__ObjInit__Group__1__Impl rule__ObjInit__Group__2 )
            // InternalArg.g:7707:2: rule__ObjInit__Group__1__Impl rule__ObjInit__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__ObjInit__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__1"


    // $ANTLR start "rule__ObjInit__Group__1__Impl"
    // InternalArg.g:7714:1: rule__ObjInit__Group__1__Impl : ( ':' ) ;
    public final void rule__ObjInit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7718:1: ( ( ':' ) )
            // InternalArg.g:7719:1: ( ':' )
            {
            // InternalArg.g:7719:1: ( ':' )
            // InternalArg.g:7720:2: ':'
            {
             before(grammarAccess.getObjInitAccess().getColonKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__1__Impl"


    // $ANTLR start "rule__ObjInit__Group__2"
    // InternalArg.g:7729:1: rule__ObjInit__Group__2 : rule__ObjInit__Group__2__Impl rule__ObjInit__Group__3 ;
    public final void rule__ObjInit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7733:1: ( rule__ObjInit__Group__2__Impl rule__ObjInit__Group__3 )
            // InternalArg.g:7734:2: rule__ObjInit__Group__2__Impl rule__ObjInit__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__ObjInit__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__2"


    // $ANTLR start "rule__ObjInit__Group__2__Impl"
    // InternalArg.g:7741:1: rule__ObjInit__Group__2__Impl : ( ( rule__ObjInit__ClassAssignment_2 ) ) ;
    public final void rule__ObjInit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7745:1: ( ( ( rule__ObjInit__ClassAssignment_2 ) ) )
            // InternalArg.g:7746:1: ( ( rule__ObjInit__ClassAssignment_2 ) )
            {
            // InternalArg.g:7746:1: ( ( rule__ObjInit__ClassAssignment_2 ) )
            // InternalArg.g:7747:2: ( rule__ObjInit__ClassAssignment_2 )
            {
             before(grammarAccess.getObjInitAccess().getClassAssignment_2()); 
            // InternalArg.g:7748:2: ( rule__ObjInit__ClassAssignment_2 )
            // InternalArg.g:7748:3: rule__ObjInit__ClassAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__ClassAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getClassAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__2__Impl"


    // $ANTLR start "rule__ObjInit__Group__3"
    // InternalArg.g:7756:1: rule__ObjInit__Group__3 : rule__ObjInit__Group__3__Impl rule__ObjInit__Group__4 ;
    public final void rule__ObjInit__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7760:1: ( rule__ObjInit__Group__3__Impl rule__ObjInit__Group__4 )
            // InternalArg.g:7761:2: rule__ObjInit__Group__3__Impl rule__ObjInit__Group__4
            {
            pushFollow(FOLLOW_75);
            rule__ObjInit__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__3"


    // $ANTLR start "rule__ObjInit__Group__3__Impl"
    // InternalArg.g:7768:1: rule__ObjInit__Group__3__Impl : ( '[' ) ;
    public final void rule__ObjInit__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7772:1: ( ( '[' ) )
            // InternalArg.g:7773:1: ( '[' )
            {
            // InternalArg.g:7773:1: ( '[' )
            // InternalArg.g:7774:2: '['
            {
             before(grammarAccess.getObjInitAccess().getLeftSquareBracketKeyword_3()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__3__Impl"


    // $ANTLR start "rule__ObjInit__Group__4"
    // InternalArg.g:7783:1: rule__ObjInit__Group__4 : rule__ObjInit__Group__4__Impl rule__ObjInit__Group__5 ;
    public final void rule__ObjInit__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7787:1: ( rule__ObjInit__Group__4__Impl rule__ObjInit__Group__5 )
            // InternalArg.g:7788:2: rule__ObjInit__Group__4__Impl rule__ObjInit__Group__5
            {
            pushFollow(FOLLOW_65);
            rule__ObjInit__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__4"


    // $ANTLR start "rule__ObjInit__Group__4__Impl"
    // InternalArg.g:7795:1: rule__ObjInit__Group__4__Impl : ( ( rule__ObjInit__PosXAssignment_4 ) ) ;
    public final void rule__ObjInit__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7799:1: ( ( ( rule__ObjInit__PosXAssignment_4 ) ) )
            // InternalArg.g:7800:1: ( ( rule__ObjInit__PosXAssignment_4 ) )
            {
            // InternalArg.g:7800:1: ( ( rule__ObjInit__PosXAssignment_4 ) )
            // InternalArg.g:7801:2: ( rule__ObjInit__PosXAssignment_4 )
            {
             before(grammarAccess.getObjInitAccess().getPosXAssignment_4()); 
            // InternalArg.g:7802:2: ( rule__ObjInit__PosXAssignment_4 )
            // InternalArg.g:7802:3: rule__ObjInit__PosXAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__PosXAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getPosXAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__4__Impl"


    // $ANTLR start "rule__ObjInit__Group__5"
    // InternalArg.g:7810:1: rule__ObjInit__Group__5 : rule__ObjInit__Group__5__Impl rule__ObjInit__Group__6 ;
    public final void rule__ObjInit__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7814:1: ( rule__ObjInit__Group__5__Impl rule__ObjInit__Group__6 )
            // InternalArg.g:7815:2: rule__ObjInit__Group__5__Impl rule__ObjInit__Group__6
            {
            pushFollow(FOLLOW_75);
            rule__ObjInit__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__5"


    // $ANTLR start "rule__ObjInit__Group__5__Impl"
    // InternalArg.g:7822:1: rule__ObjInit__Group__5__Impl : ( ',' ) ;
    public final void rule__ObjInit__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7826:1: ( ( ',' ) )
            // InternalArg.g:7827:1: ( ',' )
            {
            // InternalArg.g:7827:1: ( ',' )
            // InternalArg.g:7828:2: ','
            {
             before(grammarAccess.getObjInitAccess().getCommaKeyword_5()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__5__Impl"


    // $ANTLR start "rule__ObjInit__Group__6"
    // InternalArg.g:7837:1: rule__ObjInit__Group__6 : rule__ObjInit__Group__6__Impl rule__ObjInit__Group__7 ;
    public final void rule__ObjInit__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7841:1: ( rule__ObjInit__Group__6__Impl rule__ObjInit__Group__7 )
            // InternalArg.g:7842:2: rule__ObjInit__Group__6__Impl rule__ObjInit__Group__7
            {
            pushFollow(FOLLOW_65);
            rule__ObjInit__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__6"


    // $ANTLR start "rule__ObjInit__Group__6__Impl"
    // InternalArg.g:7849:1: rule__ObjInit__Group__6__Impl : ( ( rule__ObjInit__PosYAssignment_6 ) ) ;
    public final void rule__ObjInit__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7853:1: ( ( ( rule__ObjInit__PosYAssignment_6 ) ) )
            // InternalArg.g:7854:1: ( ( rule__ObjInit__PosYAssignment_6 ) )
            {
            // InternalArg.g:7854:1: ( ( rule__ObjInit__PosYAssignment_6 ) )
            // InternalArg.g:7855:2: ( rule__ObjInit__PosYAssignment_6 )
            {
             before(grammarAccess.getObjInitAccess().getPosYAssignment_6()); 
            // InternalArg.g:7856:2: ( rule__ObjInit__PosYAssignment_6 )
            // InternalArg.g:7856:3: rule__ObjInit__PosYAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__PosYAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getPosYAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__6__Impl"


    // $ANTLR start "rule__ObjInit__Group__7"
    // InternalArg.g:7864:1: rule__ObjInit__Group__7 : rule__ObjInit__Group__7__Impl rule__ObjInit__Group__8 ;
    public final void rule__ObjInit__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7868:1: ( rule__ObjInit__Group__7__Impl rule__ObjInit__Group__8 )
            // InternalArg.g:7869:2: rule__ObjInit__Group__7__Impl rule__ObjInit__Group__8
            {
            pushFollow(FOLLOW_75);
            rule__ObjInit__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__7"


    // $ANTLR start "rule__ObjInit__Group__7__Impl"
    // InternalArg.g:7876:1: rule__ObjInit__Group__7__Impl : ( ',' ) ;
    public final void rule__ObjInit__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7880:1: ( ( ',' ) )
            // InternalArg.g:7881:1: ( ',' )
            {
            // InternalArg.g:7881:1: ( ',' )
            // InternalArg.g:7882:2: ','
            {
             before(grammarAccess.getObjInitAccess().getCommaKeyword_7()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getCommaKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__7__Impl"


    // $ANTLR start "rule__ObjInit__Group__8"
    // InternalArg.g:7891:1: rule__ObjInit__Group__8 : rule__ObjInit__Group__8__Impl rule__ObjInit__Group__9 ;
    public final void rule__ObjInit__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7895:1: ( rule__ObjInit__Group__8__Impl rule__ObjInit__Group__9 )
            // InternalArg.g:7896:2: rule__ObjInit__Group__8__Impl rule__ObjInit__Group__9
            {
            pushFollow(FOLLOW_76);
            rule__ObjInit__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__8"


    // $ANTLR start "rule__ObjInit__Group__8__Impl"
    // InternalArg.g:7903:1: rule__ObjInit__Group__8__Impl : ( ( rule__ObjInit__PosZAssignment_8 ) ) ;
    public final void rule__ObjInit__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7907:1: ( ( ( rule__ObjInit__PosZAssignment_8 ) ) )
            // InternalArg.g:7908:1: ( ( rule__ObjInit__PosZAssignment_8 ) )
            {
            // InternalArg.g:7908:1: ( ( rule__ObjInit__PosZAssignment_8 ) )
            // InternalArg.g:7909:2: ( rule__ObjInit__PosZAssignment_8 )
            {
             before(grammarAccess.getObjInitAccess().getPosZAssignment_8()); 
            // InternalArg.g:7910:2: ( rule__ObjInit__PosZAssignment_8 )
            // InternalArg.g:7910:3: rule__ObjInit__PosZAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__PosZAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getPosZAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__8__Impl"


    // $ANTLR start "rule__ObjInit__Group__9"
    // InternalArg.g:7918:1: rule__ObjInit__Group__9 : rule__ObjInit__Group__9__Impl rule__ObjInit__Group__10 ;
    public final void rule__ObjInit__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7922:1: ( rule__ObjInit__Group__9__Impl rule__ObjInit__Group__10 )
            // InternalArg.g:7923:2: rule__ObjInit__Group__9__Impl rule__ObjInit__Group__10
            {
            pushFollow(FOLLOW_76);
            rule__ObjInit__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__9"


    // $ANTLR start "rule__ObjInit__Group__9__Impl"
    // InternalArg.g:7930:1: rule__ObjInit__Group__9__Impl : ( ( rule__ObjInit__Group_9__0 )? ) ;
    public final void rule__ObjInit__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7934:1: ( ( ( rule__ObjInit__Group_9__0 )? ) )
            // InternalArg.g:7935:1: ( ( rule__ObjInit__Group_9__0 )? )
            {
            // InternalArg.g:7935:1: ( ( rule__ObjInit__Group_9__0 )? )
            // InternalArg.g:7936:2: ( rule__ObjInit__Group_9__0 )?
            {
             before(grammarAccess.getObjInitAccess().getGroup_9()); 
            // InternalArg.g:7937:2: ( rule__ObjInit__Group_9__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==91) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalArg.g:7937:3: rule__ObjInit__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ObjInit__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjInitAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__9__Impl"


    // $ANTLR start "rule__ObjInit__Group__10"
    // InternalArg.g:7945:1: rule__ObjInit__Group__10 : rule__ObjInit__Group__10__Impl rule__ObjInit__Group__11 ;
    public final void rule__ObjInit__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7949:1: ( rule__ObjInit__Group__10__Impl rule__ObjInit__Group__11 )
            // InternalArg.g:7950:2: rule__ObjInit__Group__10__Impl rule__ObjInit__Group__11
            {
            pushFollow(FOLLOW_77);
            rule__ObjInit__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__10"


    // $ANTLR start "rule__ObjInit__Group__10__Impl"
    // InternalArg.g:7957:1: rule__ObjInit__Group__10__Impl : ( ']' ) ;
    public final void rule__ObjInit__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7961:1: ( ( ']' ) )
            // InternalArg.g:7962:1: ( ']' )
            {
            // InternalArg.g:7962:1: ( ']' )
            // InternalArg.g:7963:2: ']'
            {
             before(grammarAccess.getObjInitAccess().getRightSquareBracketKeyword_10()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__10__Impl"


    // $ANTLR start "rule__ObjInit__Group__11"
    // InternalArg.g:7972:1: rule__ObjInit__Group__11 : rule__ObjInit__Group__11__Impl rule__ObjInit__Group__12 ;
    public final void rule__ObjInit__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7976:1: ( rule__ObjInit__Group__11__Impl rule__ObjInit__Group__12 )
            // InternalArg.g:7977:2: rule__ObjInit__Group__11__Impl rule__ObjInit__Group__12
            {
            pushFollow(FOLLOW_77);
            rule__ObjInit__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__11"


    // $ANTLR start "rule__ObjInit__Group__11__Impl"
    // InternalArg.g:7984:1: rule__ObjInit__Group__11__Impl : ( ( rule__ObjInit__Group_11__0 )? ) ;
    public final void rule__ObjInit__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:7988:1: ( ( ( rule__ObjInit__Group_11__0 )? ) )
            // InternalArg.g:7989:1: ( ( rule__ObjInit__Group_11__0 )? )
            {
            // InternalArg.g:7989:1: ( ( rule__ObjInit__Group_11__0 )? )
            // InternalArg.g:7990:2: ( rule__ObjInit__Group_11__0 )?
            {
             before(grammarAccess.getObjInitAccess().getGroup_11()); 
            // InternalArg.g:7991:2: ( rule__ObjInit__Group_11__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==100) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalArg.g:7991:3: rule__ObjInit__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ObjInit__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjInitAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__11__Impl"


    // $ANTLR start "rule__ObjInit__Group__12"
    // InternalArg.g:7999:1: rule__ObjInit__Group__12 : rule__ObjInit__Group__12__Impl ;
    public final void rule__ObjInit__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8003:1: ( rule__ObjInit__Group__12__Impl )
            // InternalArg.g:8004:2: rule__ObjInit__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__12"


    // $ANTLR start "rule__ObjInit__Group__12__Impl"
    // InternalArg.g:8010:1: rule__ObjInit__Group__12__Impl : ( ( rule__ObjInit__Group_12__0 )? ) ;
    public final void rule__ObjInit__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8014:1: ( ( ( rule__ObjInit__Group_12__0 )? ) )
            // InternalArg.g:8015:1: ( ( rule__ObjInit__Group_12__0 )? )
            {
            // InternalArg.g:8015:1: ( ( rule__ObjInit__Group_12__0 )? )
            // InternalArg.g:8016:2: ( rule__ObjInit__Group_12__0 )?
            {
             before(grammarAccess.getObjInitAccess().getGroup_12()); 
            // InternalArg.g:8017:2: ( rule__ObjInit__Group_12__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==101) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalArg.g:8017:3: rule__ObjInit__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ObjInit__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjInitAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group__12__Impl"


    // $ANTLR start "rule__ObjInit__Group_9__0"
    // InternalArg.g:8026:1: rule__ObjInit__Group_9__0 : rule__ObjInit__Group_9__0__Impl rule__ObjInit__Group_9__1 ;
    public final void rule__ObjInit__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8030:1: ( rule__ObjInit__Group_9__0__Impl rule__ObjInit__Group_9__1 )
            // InternalArg.g:8031:2: rule__ObjInit__Group_9__0__Impl rule__ObjInit__Group_9__1
            {
            pushFollow(FOLLOW_25);
            rule__ObjInit__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_9__0"


    // $ANTLR start "rule__ObjInit__Group_9__0__Impl"
    // InternalArg.g:8038:1: rule__ObjInit__Group_9__0__Impl : ( ',' ) ;
    public final void rule__ObjInit__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8042:1: ( ( ',' ) )
            // InternalArg.g:8043:1: ( ',' )
            {
            // InternalArg.g:8043:1: ( ',' )
            // InternalArg.g:8044:2: ','
            {
             before(grammarAccess.getObjInitAccess().getCommaKeyword_9_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_9__0__Impl"


    // $ANTLR start "rule__ObjInit__Group_9__1"
    // InternalArg.g:8053:1: rule__ObjInit__Group_9__1 : rule__ObjInit__Group_9__1__Impl ;
    public final void rule__ObjInit__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8057:1: ( rule__ObjInit__Group_9__1__Impl )
            // InternalArg.g:8058:2: rule__ObjInit__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_9__1"


    // $ANTLR start "rule__ObjInit__Group_9__1__Impl"
    // InternalArg.g:8064:1: rule__ObjInit__Group_9__1__Impl : ( ( rule__ObjInit__RotationAssignment_9_1 ) ) ;
    public final void rule__ObjInit__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8068:1: ( ( ( rule__ObjInit__RotationAssignment_9_1 ) ) )
            // InternalArg.g:8069:1: ( ( rule__ObjInit__RotationAssignment_9_1 ) )
            {
            // InternalArg.g:8069:1: ( ( rule__ObjInit__RotationAssignment_9_1 ) )
            // InternalArg.g:8070:2: ( rule__ObjInit__RotationAssignment_9_1 )
            {
             before(grammarAccess.getObjInitAccess().getRotationAssignment_9_1()); 
            // InternalArg.g:8071:2: ( rule__ObjInit__RotationAssignment_9_1 )
            // InternalArg.g:8071:3: rule__ObjInit__RotationAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__RotationAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getRotationAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_9__1__Impl"


    // $ANTLR start "rule__ObjInit__Group_11__0"
    // InternalArg.g:8080:1: rule__ObjInit__Group_11__0 : rule__ObjInit__Group_11__0__Impl rule__ObjInit__Group_11__1 ;
    public final void rule__ObjInit__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8084:1: ( rule__ObjInit__Group_11__0__Impl rule__ObjInit__Group_11__1 )
            // InternalArg.g:8085:2: rule__ObjInit__Group_11__0__Impl rule__ObjInit__Group_11__1
            {
            pushFollow(FOLLOW_4);
            rule__ObjInit__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__0"


    // $ANTLR start "rule__ObjInit__Group_11__0__Impl"
    // InternalArg.g:8092:1: rule__ObjInit__Group_11__0__Impl : ( 'attributes' ) ;
    public final void rule__ObjInit__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8096:1: ( ( 'attributes' ) )
            // InternalArg.g:8097:1: ( 'attributes' )
            {
            // InternalArg.g:8097:1: ( 'attributes' )
            // InternalArg.g:8098:2: 'attributes'
            {
             before(grammarAccess.getObjInitAccess().getAttributesKeyword_11_0()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getAttributesKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__0__Impl"


    // $ANTLR start "rule__ObjInit__Group_11__1"
    // InternalArg.g:8107:1: rule__ObjInit__Group_11__1 : rule__ObjInit__Group_11__1__Impl rule__ObjInit__Group_11__2 ;
    public final void rule__ObjInit__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8111:1: ( rule__ObjInit__Group_11__1__Impl rule__ObjInit__Group_11__2 )
            // InternalArg.g:8112:2: rule__ObjInit__Group_11__1__Impl rule__ObjInit__Group_11__2
            {
            pushFollow(FOLLOW_3);
            rule__ObjInit__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__1"


    // $ANTLR start "rule__ObjInit__Group_11__1__Impl"
    // InternalArg.g:8119:1: rule__ObjInit__Group_11__1__Impl : ( '{' ) ;
    public final void rule__ObjInit__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8123:1: ( ( '{' ) )
            // InternalArg.g:8124:1: ( '{' )
            {
            // InternalArg.g:8124:1: ( '{' )
            // InternalArg.g:8125:2: '{'
            {
             before(grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_11_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__1__Impl"


    // $ANTLR start "rule__ObjInit__Group_11__2"
    // InternalArg.g:8134:1: rule__ObjInit__Group_11__2 : rule__ObjInit__Group_11__2__Impl rule__ObjInit__Group_11__3 ;
    public final void rule__ObjInit__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8138:1: ( rule__ObjInit__Group_11__2__Impl rule__ObjInit__Group_11__3 )
            // InternalArg.g:8139:2: rule__ObjInit__Group_11__2__Impl rule__ObjInit__Group_11__3
            {
            pushFollow(FOLLOW_78);
            rule__ObjInit__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__2"


    // $ANTLR start "rule__ObjInit__Group_11__2__Impl"
    // InternalArg.g:8146:1: rule__ObjInit__Group_11__2__Impl : ( ( rule__ObjInit__AttributeAssignment_11_2 ) ) ;
    public final void rule__ObjInit__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8150:1: ( ( ( rule__ObjInit__AttributeAssignment_11_2 ) ) )
            // InternalArg.g:8151:1: ( ( rule__ObjInit__AttributeAssignment_11_2 ) )
            {
            // InternalArg.g:8151:1: ( ( rule__ObjInit__AttributeAssignment_11_2 ) )
            // InternalArg.g:8152:2: ( rule__ObjInit__AttributeAssignment_11_2 )
            {
             before(grammarAccess.getObjInitAccess().getAttributeAssignment_11_2()); 
            // InternalArg.g:8153:2: ( rule__ObjInit__AttributeAssignment_11_2 )
            // InternalArg.g:8153:3: rule__ObjInit__AttributeAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__AttributeAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getAttributeAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__2__Impl"


    // $ANTLR start "rule__ObjInit__Group_11__3"
    // InternalArg.g:8161:1: rule__ObjInit__Group_11__3 : rule__ObjInit__Group_11__3__Impl rule__ObjInit__Group_11__4 ;
    public final void rule__ObjInit__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8165:1: ( rule__ObjInit__Group_11__3__Impl rule__ObjInit__Group_11__4 )
            // InternalArg.g:8166:2: rule__ObjInit__Group_11__3__Impl rule__ObjInit__Group_11__4
            {
            pushFollow(FOLLOW_78);
            rule__ObjInit__Group_11__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__3"


    // $ANTLR start "rule__ObjInit__Group_11__3__Impl"
    // InternalArg.g:8173:1: rule__ObjInit__Group_11__3__Impl : ( ( rule__ObjInit__Group_11_3__0 )* ) ;
    public final void rule__ObjInit__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8177:1: ( ( ( rule__ObjInit__Group_11_3__0 )* ) )
            // InternalArg.g:8178:1: ( ( rule__ObjInit__Group_11_3__0 )* )
            {
            // InternalArg.g:8178:1: ( ( rule__ObjInit__Group_11_3__0 )* )
            // InternalArg.g:8179:2: ( rule__ObjInit__Group_11_3__0 )*
            {
             before(grammarAccess.getObjInitAccess().getGroup_11_3()); 
            // InternalArg.g:8180:2: ( rule__ObjInit__Group_11_3__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==91) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalArg.g:8180:3: rule__ObjInit__Group_11_3__0
            	    {
            	    pushFollow(FOLLOW_79);
            	    rule__ObjInit__Group_11_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getObjInitAccess().getGroup_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__3__Impl"


    // $ANTLR start "rule__ObjInit__Group_11__4"
    // InternalArg.g:8188:1: rule__ObjInit__Group_11__4 : rule__ObjInit__Group_11__4__Impl ;
    public final void rule__ObjInit__Group_11__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8192:1: ( rule__ObjInit__Group_11__4__Impl )
            // InternalArg.g:8193:2: rule__ObjInit__Group_11__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__4"


    // $ANTLR start "rule__ObjInit__Group_11__4__Impl"
    // InternalArg.g:8199:1: rule__ObjInit__Group_11__4__Impl : ( '}' ) ;
    public final void rule__ObjInit__Group_11__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8203:1: ( ( '}' ) )
            // InternalArg.g:8204:1: ( '}' )
            {
            // InternalArg.g:8204:1: ( '}' )
            // InternalArg.g:8205:2: '}'
            {
             before(grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_11_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_11_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11__4__Impl"


    // $ANTLR start "rule__ObjInit__Group_11_3__0"
    // InternalArg.g:8215:1: rule__ObjInit__Group_11_3__0 : rule__ObjInit__Group_11_3__0__Impl rule__ObjInit__Group_11_3__1 ;
    public final void rule__ObjInit__Group_11_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8219:1: ( rule__ObjInit__Group_11_3__0__Impl rule__ObjInit__Group_11_3__1 )
            // InternalArg.g:8220:2: rule__ObjInit__Group_11_3__0__Impl rule__ObjInit__Group_11_3__1
            {
            pushFollow(FOLLOW_3);
            rule__ObjInit__Group_11_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11_3__0"


    // $ANTLR start "rule__ObjInit__Group_11_3__0__Impl"
    // InternalArg.g:8227:1: rule__ObjInit__Group_11_3__0__Impl : ( ',' ) ;
    public final void rule__ObjInit__Group_11_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8231:1: ( ( ',' ) )
            // InternalArg.g:8232:1: ( ',' )
            {
            // InternalArg.g:8232:1: ( ',' )
            // InternalArg.g:8233:2: ','
            {
             before(grammarAccess.getObjInitAccess().getCommaKeyword_11_3_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getCommaKeyword_11_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11_3__0__Impl"


    // $ANTLR start "rule__ObjInit__Group_11_3__1"
    // InternalArg.g:8242:1: rule__ObjInit__Group_11_3__1 : rule__ObjInit__Group_11_3__1__Impl ;
    public final void rule__ObjInit__Group_11_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8246:1: ( rule__ObjInit__Group_11_3__1__Impl )
            // InternalArg.g:8247:2: rule__ObjInit__Group_11_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_11_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11_3__1"


    // $ANTLR start "rule__ObjInit__Group_11_3__1__Impl"
    // InternalArg.g:8253:1: rule__ObjInit__Group_11_3__1__Impl : ( ( rule__ObjInit__AttributeAssignment_11_3_1 ) ) ;
    public final void rule__ObjInit__Group_11_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8257:1: ( ( ( rule__ObjInit__AttributeAssignment_11_3_1 ) ) )
            // InternalArg.g:8258:1: ( ( rule__ObjInit__AttributeAssignment_11_3_1 ) )
            {
            // InternalArg.g:8258:1: ( ( rule__ObjInit__AttributeAssignment_11_3_1 ) )
            // InternalArg.g:8259:2: ( rule__ObjInit__AttributeAssignment_11_3_1 )
            {
             before(grammarAccess.getObjInitAccess().getAttributeAssignment_11_3_1()); 
            // InternalArg.g:8260:2: ( rule__ObjInit__AttributeAssignment_11_3_1 )
            // InternalArg.g:8260:3: rule__ObjInit__AttributeAssignment_11_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__AttributeAssignment_11_3_1();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getAttributeAssignment_11_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_11_3__1__Impl"


    // $ANTLR start "rule__ObjInit__Group_12__0"
    // InternalArg.g:8269:1: rule__ObjInit__Group_12__0 : rule__ObjInit__Group_12__0__Impl rule__ObjInit__Group_12__1 ;
    public final void rule__ObjInit__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8273:1: ( rule__ObjInit__Group_12__0__Impl rule__ObjInit__Group_12__1 )
            // InternalArg.g:8274:2: rule__ObjInit__Group_12__0__Impl rule__ObjInit__Group_12__1
            {
            pushFollow(FOLLOW_4);
            rule__ObjInit__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__0"


    // $ANTLR start "rule__ObjInit__Group_12__0__Impl"
    // InternalArg.g:8281:1: rule__ObjInit__Group_12__0__Impl : ( 'rules' ) ;
    public final void rule__ObjInit__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8285:1: ( ( 'rules' ) )
            // InternalArg.g:8286:1: ( 'rules' )
            {
            // InternalArg.g:8286:1: ( 'rules' )
            // InternalArg.g:8287:2: 'rules'
            {
             before(grammarAccess.getObjInitAccess().getRulesKeyword_12_0()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getRulesKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__0__Impl"


    // $ANTLR start "rule__ObjInit__Group_12__1"
    // InternalArg.g:8296:1: rule__ObjInit__Group_12__1 : rule__ObjInit__Group_12__1__Impl rule__ObjInit__Group_12__2 ;
    public final void rule__ObjInit__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8300:1: ( rule__ObjInit__Group_12__1__Impl rule__ObjInit__Group_12__2 )
            // InternalArg.g:8301:2: rule__ObjInit__Group_12__1__Impl rule__ObjInit__Group_12__2
            {
            pushFollow(FOLLOW_71);
            rule__ObjInit__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__1"


    // $ANTLR start "rule__ObjInit__Group_12__1__Impl"
    // InternalArg.g:8308:1: rule__ObjInit__Group_12__1__Impl : ( '{' ) ;
    public final void rule__ObjInit__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8312:1: ( ( '{' ) )
            // InternalArg.g:8313:1: ( '{' )
            {
            // InternalArg.g:8313:1: ( '{' )
            // InternalArg.g:8314:2: '{'
            {
             before(grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_12_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__1__Impl"


    // $ANTLR start "rule__ObjInit__Group_12__2"
    // InternalArg.g:8323:1: rule__ObjInit__Group_12__2 : rule__ObjInit__Group_12__2__Impl rule__ObjInit__Group_12__3 ;
    public final void rule__ObjInit__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8327:1: ( rule__ObjInit__Group_12__2__Impl rule__ObjInit__Group_12__3 )
            // InternalArg.g:8328:2: rule__ObjInit__Group_12__2__Impl rule__ObjInit__Group_12__3
            {
            pushFollow(FOLLOW_78);
            rule__ObjInit__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__2"


    // $ANTLR start "rule__ObjInit__Group_12__2__Impl"
    // InternalArg.g:8335:1: rule__ObjInit__Group_12__2__Impl : ( ( rule__ObjInit__RulesAssignment_12_2 ) ) ;
    public final void rule__ObjInit__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8339:1: ( ( ( rule__ObjInit__RulesAssignment_12_2 ) ) )
            // InternalArg.g:8340:1: ( ( rule__ObjInit__RulesAssignment_12_2 ) )
            {
            // InternalArg.g:8340:1: ( ( rule__ObjInit__RulesAssignment_12_2 ) )
            // InternalArg.g:8341:2: ( rule__ObjInit__RulesAssignment_12_2 )
            {
             before(grammarAccess.getObjInitAccess().getRulesAssignment_12_2()); 
            // InternalArg.g:8342:2: ( rule__ObjInit__RulesAssignment_12_2 )
            // InternalArg.g:8342:3: rule__ObjInit__RulesAssignment_12_2
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__RulesAssignment_12_2();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getRulesAssignment_12_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__2__Impl"


    // $ANTLR start "rule__ObjInit__Group_12__3"
    // InternalArg.g:8350:1: rule__ObjInit__Group_12__3 : rule__ObjInit__Group_12__3__Impl rule__ObjInit__Group_12__4 ;
    public final void rule__ObjInit__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8354:1: ( rule__ObjInit__Group_12__3__Impl rule__ObjInit__Group_12__4 )
            // InternalArg.g:8355:2: rule__ObjInit__Group_12__3__Impl rule__ObjInit__Group_12__4
            {
            pushFollow(FOLLOW_78);
            rule__ObjInit__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__3"


    // $ANTLR start "rule__ObjInit__Group_12__3__Impl"
    // InternalArg.g:8362:1: rule__ObjInit__Group_12__3__Impl : ( ( rule__ObjInit__Group_12_3__0 )* ) ;
    public final void rule__ObjInit__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8366:1: ( ( ( rule__ObjInit__Group_12_3__0 )* ) )
            // InternalArg.g:8367:1: ( ( rule__ObjInit__Group_12_3__0 )* )
            {
            // InternalArg.g:8367:1: ( ( rule__ObjInit__Group_12_3__0 )* )
            // InternalArg.g:8368:2: ( rule__ObjInit__Group_12_3__0 )*
            {
             before(grammarAccess.getObjInitAccess().getGroup_12_3()); 
            // InternalArg.g:8369:2: ( rule__ObjInit__Group_12_3__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==91) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalArg.g:8369:3: rule__ObjInit__Group_12_3__0
            	    {
            	    pushFollow(FOLLOW_79);
            	    rule__ObjInit__Group_12_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getObjInitAccess().getGroup_12_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__3__Impl"


    // $ANTLR start "rule__ObjInit__Group_12__4"
    // InternalArg.g:8377:1: rule__ObjInit__Group_12__4 : rule__ObjInit__Group_12__4__Impl ;
    public final void rule__ObjInit__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8381:1: ( rule__ObjInit__Group_12__4__Impl )
            // InternalArg.g:8382:2: rule__ObjInit__Group_12__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__4"


    // $ANTLR start "rule__ObjInit__Group_12__4__Impl"
    // InternalArg.g:8388:1: rule__ObjInit__Group_12__4__Impl : ( '}' ) ;
    public final void rule__ObjInit__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8392:1: ( ( '}' ) )
            // InternalArg.g:8393:1: ( '}' )
            {
            // InternalArg.g:8393:1: ( '}' )
            // InternalArg.g:8394:2: '}'
            {
             before(grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_12_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_12_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12__4__Impl"


    // $ANTLR start "rule__ObjInit__Group_12_3__0"
    // InternalArg.g:8404:1: rule__ObjInit__Group_12_3__0 : rule__ObjInit__Group_12_3__0__Impl rule__ObjInit__Group_12_3__1 ;
    public final void rule__ObjInit__Group_12_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8408:1: ( rule__ObjInit__Group_12_3__0__Impl rule__ObjInit__Group_12_3__1 )
            // InternalArg.g:8409:2: rule__ObjInit__Group_12_3__0__Impl rule__ObjInit__Group_12_3__1
            {
            pushFollow(FOLLOW_71);
            rule__ObjInit__Group_12_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12_3__0"


    // $ANTLR start "rule__ObjInit__Group_12_3__0__Impl"
    // InternalArg.g:8416:1: rule__ObjInit__Group_12_3__0__Impl : ( ',' ) ;
    public final void rule__ObjInit__Group_12_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8420:1: ( ( ',' ) )
            // InternalArg.g:8421:1: ( ',' )
            {
            // InternalArg.g:8421:1: ( ',' )
            // InternalArg.g:8422:2: ','
            {
             before(grammarAccess.getObjInitAccess().getCommaKeyword_12_3_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObjInitAccess().getCommaKeyword_12_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12_3__0__Impl"


    // $ANTLR start "rule__ObjInit__Group_12_3__1"
    // InternalArg.g:8431:1: rule__ObjInit__Group_12_3__1 : rule__ObjInit__Group_12_3__1__Impl ;
    public final void rule__ObjInit__Group_12_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8435:1: ( rule__ObjInit__Group_12_3__1__Impl )
            // InternalArg.g:8436:2: rule__ObjInit__Group_12_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__Group_12_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12_3__1"


    // $ANTLR start "rule__ObjInit__Group_12_3__1__Impl"
    // InternalArg.g:8442:1: rule__ObjInit__Group_12_3__1__Impl : ( ( rule__ObjInit__RulesAssignment_12_3_1 ) ) ;
    public final void rule__ObjInit__Group_12_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8446:1: ( ( ( rule__ObjInit__RulesAssignment_12_3_1 ) ) )
            // InternalArg.g:8447:1: ( ( rule__ObjInit__RulesAssignment_12_3_1 ) )
            {
            // InternalArg.g:8447:1: ( ( rule__ObjInit__RulesAssignment_12_3_1 ) )
            // InternalArg.g:8448:2: ( rule__ObjInit__RulesAssignment_12_3_1 )
            {
             before(grammarAccess.getObjInitAccess().getRulesAssignment_12_3_1()); 
            // InternalArg.g:8449:2: ( rule__ObjInit__RulesAssignment_12_3_1 )
            // InternalArg.g:8449:3: rule__ObjInit__RulesAssignment_12_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ObjInit__RulesAssignment_12_3_1();

            state._fsp--;


            }

             after(grammarAccess.getObjInitAccess().getRulesAssignment_12_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__Group_12_3__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group__0"
    // InternalArg.g:8458:1: rule__PhysicChange__Group__0 : rule__PhysicChange__Group__0__Impl rule__PhysicChange__Group__1 ;
    public final void rule__PhysicChange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8462:1: ( rule__PhysicChange__Group__0__Impl rule__PhysicChange__Group__1 )
            // InternalArg.g:8463:2: rule__PhysicChange__Group__0__Impl rule__PhysicChange__Group__1
            {
            pushFollow(FOLLOW_80);
            rule__PhysicChange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__0"


    // $ANTLR start "rule__PhysicChange__Group__0__Impl"
    // InternalArg.g:8470:1: rule__PhysicChange__Group__0__Impl : ( 'do' ) ;
    public final void rule__PhysicChange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8474:1: ( ( 'do' ) )
            // InternalArg.g:8475:1: ( 'do' )
            {
            // InternalArg.g:8475:1: ( 'do' )
            // InternalArg.g:8476:2: 'do'
            {
             before(grammarAccess.getPhysicChangeAccess().getDoKeyword_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getDoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group__1"
    // InternalArg.g:8485:1: rule__PhysicChange__Group__1 : rule__PhysicChange__Group__1__Impl rule__PhysicChange__Group__2 ;
    public final void rule__PhysicChange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8489:1: ( rule__PhysicChange__Group__1__Impl rule__PhysicChange__Group__2 )
            // InternalArg.g:8490:2: rule__PhysicChange__Group__1__Impl rule__PhysicChange__Group__2
            {
            pushFollow(FOLLOW_81);
            rule__PhysicChange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__1"


    // $ANTLR start "rule__PhysicChange__Group__1__Impl"
    // InternalArg.g:8497:1: rule__PhysicChange__Group__1__Impl : ( ( rule__PhysicChange__ActionAssignment_1 ) ) ;
    public final void rule__PhysicChange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8501:1: ( ( ( rule__PhysicChange__ActionAssignment_1 ) ) )
            // InternalArg.g:8502:1: ( ( rule__PhysicChange__ActionAssignment_1 ) )
            {
            // InternalArg.g:8502:1: ( ( rule__PhysicChange__ActionAssignment_1 ) )
            // InternalArg.g:8503:2: ( rule__PhysicChange__ActionAssignment_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getActionAssignment_1()); 
            // InternalArg.g:8504:2: ( rule__PhysicChange__ActionAssignment_1 )
            // InternalArg.g:8504:3: rule__PhysicChange__ActionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ActionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getActionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group__2"
    // InternalArg.g:8512:1: rule__PhysicChange__Group__2 : rule__PhysicChange__Group__2__Impl rule__PhysicChange__Group__3 ;
    public final void rule__PhysicChange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8516:1: ( rule__PhysicChange__Group__2__Impl rule__PhysicChange__Group__3 )
            // InternalArg.g:8517:2: rule__PhysicChange__Group__2__Impl rule__PhysicChange__Group__3
            {
            pushFollow(FOLLOW_81);
            rule__PhysicChange__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__2"


    // $ANTLR start "rule__PhysicChange__Group__2__Impl"
    // InternalArg.g:8524:1: rule__PhysicChange__Group__2__Impl : ( ( rule__PhysicChange__Group_2__0 )? ) ;
    public final void rule__PhysicChange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8528:1: ( ( ( rule__PhysicChange__Group_2__0 )? ) )
            // InternalArg.g:8529:1: ( ( rule__PhysicChange__Group_2__0 )? )
            {
            // InternalArg.g:8529:1: ( ( rule__PhysicChange__Group_2__0 )? )
            // InternalArg.g:8530:2: ( rule__PhysicChange__Group_2__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_2()); 
            // InternalArg.g:8531:2: ( rule__PhysicChange__Group_2__0 )?
            int alt62=2;
            switch ( input.LA(1) ) {
                case 104:
                    {
                    alt62=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    int LA62_2 = input.LA(2);

                    if ( ((LA62_2>=RULE_STRING && LA62_2<=RULE_ID)||LA62_2==103) ) {
                        alt62=1;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA62_3 = input.LA(2);

                    if ( ((LA62_3>=RULE_STRING && LA62_3<=RULE_ID)||LA62_3==103) ) {
                        alt62=1;
                    }
                    }
                    break;
            }

            switch (alt62) {
                case 1 :
                    // InternalArg.g:8531:3: rule__PhysicChange__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__2__Impl"


    // $ANTLR start "rule__PhysicChange__Group__3"
    // InternalArg.g:8539:1: rule__PhysicChange__Group__3 : rule__PhysicChange__Group__3__Impl rule__PhysicChange__Group__4 ;
    public final void rule__PhysicChange__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8543:1: ( rule__PhysicChange__Group__3__Impl rule__PhysicChange__Group__4 )
            // InternalArg.g:8544:2: rule__PhysicChange__Group__3__Impl rule__PhysicChange__Group__4
            {
            pushFollow(FOLLOW_81);
            rule__PhysicChange__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__3"


    // $ANTLR start "rule__PhysicChange__Group__3__Impl"
    // InternalArg.g:8551:1: rule__PhysicChange__Group__3__Impl : ( ( 'named' )? ) ;
    public final void rule__PhysicChange__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8555:1: ( ( ( 'named' )? ) )
            // InternalArg.g:8556:1: ( ( 'named' )? )
            {
            // InternalArg.g:8556:1: ( ( 'named' )? )
            // InternalArg.g:8557:2: ( 'named' )?
            {
             before(grammarAccess.getPhysicChangeAccess().getNamedKeyword_3()); 
            // InternalArg.g:8558:2: ( 'named' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==103) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalArg.g:8558:3: 'named'
                    {
                    match(input,103,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getNamedKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__3__Impl"


    // $ANTLR start "rule__PhysicChange__Group__4"
    // InternalArg.g:8566:1: rule__PhysicChange__Group__4 : rule__PhysicChange__Group__4__Impl rule__PhysicChange__Group__5 ;
    public final void rule__PhysicChange__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8570:1: ( rule__PhysicChange__Group__4__Impl rule__PhysicChange__Group__5 )
            // InternalArg.g:8571:2: rule__PhysicChange__Group__4__Impl rule__PhysicChange__Group__5
            {
            pushFollow(FOLLOW_82);
            rule__PhysicChange__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__4"


    // $ANTLR start "rule__PhysicChange__Group__4__Impl"
    // InternalArg.g:8578:1: rule__PhysicChange__Group__4__Impl : ( ( rule__PhysicChange__ObjectAssignment_4 ) ) ;
    public final void rule__PhysicChange__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8582:1: ( ( ( rule__PhysicChange__ObjectAssignment_4 ) ) )
            // InternalArg.g:8583:1: ( ( rule__PhysicChange__ObjectAssignment_4 ) )
            {
            // InternalArg.g:8583:1: ( ( rule__PhysicChange__ObjectAssignment_4 ) )
            // InternalArg.g:8584:2: ( rule__PhysicChange__ObjectAssignment_4 )
            {
             before(grammarAccess.getPhysicChangeAccess().getObjectAssignment_4()); 
            // InternalArg.g:8585:2: ( rule__PhysicChange__ObjectAssignment_4 )
            // InternalArg.g:8585:3: rule__PhysicChange__ObjectAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ObjectAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getObjectAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__4__Impl"


    // $ANTLR start "rule__PhysicChange__Group__5"
    // InternalArg.g:8593:1: rule__PhysicChange__Group__5 : rule__PhysicChange__Group__5__Impl rule__PhysicChange__Group__6 ;
    public final void rule__PhysicChange__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8597:1: ( rule__PhysicChange__Group__5__Impl rule__PhysicChange__Group__6 )
            // InternalArg.g:8598:2: rule__PhysicChange__Group__5__Impl rule__PhysicChange__Group__6
            {
            pushFollow(FOLLOW_82);
            rule__PhysicChange__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__5"


    // $ANTLR start "rule__PhysicChange__Group__5__Impl"
    // InternalArg.g:8605:1: rule__PhysicChange__Group__5__Impl : ( ( rule__PhysicChange__Group_5__0 )? ) ;
    public final void rule__PhysicChange__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8609:1: ( ( ( rule__PhysicChange__Group_5__0 )? ) )
            // InternalArg.g:8610:1: ( ( rule__PhysicChange__Group_5__0 )? )
            {
            // InternalArg.g:8610:1: ( ( rule__PhysicChange__Group_5__0 )? )
            // InternalArg.g:8611:2: ( rule__PhysicChange__Group_5__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_5()); 
            // InternalArg.g:8612:2: ( rule__PhysicChange__Group_5__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==105) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalArg.g:8612:3: rule__PhysicChange__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__5__Impl"


    // $ANTLR start "rule__PhysicChange__Group__6"
    // InternalArg.g:8620:1: rule__PhysicChange__Group__6 : rule__PhysicChange__Group__6__Impl rule__PhysicChange__Group__7 ;
    public final void rule__PhysicChange__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8624:1: ( rule__PhysicChange__Group__6__Impl rule__PhysicChange__Group__7 )
            // InternalArg.g:8625:2: rule__PhysicChange__Group__6__Impl rule__PhysicChange__Group__7
            {
            pushFollow(FOLLOW_82);
            rule__PhysicChange__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__6"


    // $ANTLR start "rule__PhysicChange__Group__6__Impl"
    // InternalArg.g:8632:1: rule__PhysicChange__Group__6__Impl : ( ( rule__PhysicChange__Group_6__0 )? ) ;
    public final void rule__PhysicChange__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8636:1: ( ( ( rule__PhysicChange__Group_6__0 )? ) )
            // InternalArg.g:8637:1: ( ( rule__PhysicChange__Group_6__0 )? )
            {
            // InternalArg.g:8637:1: ( ( rule__PhysicChange__Group_6__0 )? )
            // InternalArg.g:8638:2: ( rule__PhysicChange__Group_6__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_6()); 
            // InternalArg.g:8639:2: ( rule__PhysicChange__Group_6__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==106) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalArg.g:8639:3: rule__PhysicChange__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__6__Impl"


    // $ANTLR start "rule__PhysicChange__Group__7"
    // InternalArg.g:8647:1: rule__PhysicChange__Group__7 : rule__PhysicChange__Group__7__Impl rule__PhysicChange__Group__8 ;
    public final void rule__PhysicChange__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8651:1: ( rule__PhysicChange__Group__7__Impl rule__PhysicChange__Group__8 )
            // InternalArg.g:8652:2: rule__PhysicChange__Group__7__Impl rule__PhysicChange__Group__8
            {
            pushFollow(FOLLOW_82);
            rule__PhysicChange__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__7"


    // $ANTLR start "rule__PhysicChange__Group__7__Impl"
    // InternalArg.g:8659:1: rule__PhysicChange__Group__7__Impl : ( ( rule__PhysicChange__Group_7__0 )? ) ;
    public final void rule__PhysicChange__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8663:1: ( ( ( rule__PhysicChange__Group_7__0 )? ) )
            // InternalArg.g:8664:1: ( ( rule__PhysicChange__Group_7__0 )? )
            {
            // InternalArg.g:8664:1: ( ( rule__PhysicChange__Group_7__0 )? )
            // InternalArg.g:8665:2: ( rule__PhysicChange__Group_7__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_7()); 
            // InternalArg.g:8666:2: ( rule__PhysicChange__Group_7__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==107) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalArg.g:8666:3: rule__PhysicChange__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__7__Impl"


    // $ANTLR start "rule__PhysicChange__Group__8"
    // InternalArg.g:8674:1: rule__PhysicChange__Group__8 : rule__PhysicChange__Group__8__Impl rule__PhysicChange__Group__9 ;
    public final void rule__PhysicChange__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8678:1: ( rule__PhysicChange__Group__8__Impl rule__PhysicChange__Group__9 )
            // InternalArg.g:8679:2: rule__PhysicChange__Group__8__Impl rule__PhysicChange__Group__9
            {
            pushFollow(FOLLOW_82);
            rule__PhysicChange__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__8"


    // $ANTLR start "rule__PhysicChange__Group__8__Impl"
    // InternalArg.g:8686:1: rule__PhysicChange__Group__8__Impl : ( ( rule__PhysicChange__Group_8__0 )? ) ;
    public final void rule__PhysicChange__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8690:1: ( ( ( rule__PhysicChange__Group_8__0 )? ) )
            // InternalArg.g:8691:1: ( ( rule__PhysicChange__Group_8__0 )? )
            {
            // InternalArg.g:8691:1: ( ( rule__PhysicChange__Group_8__0 )? )
            // InternalArg.g:8692:2: ( rule__PhysicChange__Group_8__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_8()); 
            // InternalArg.g:8693:2: ( rule__PhysicChange__Group_8__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==108) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalArg.g:8693:3: rule__PhysicChange__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__8__Impl"


    // $ANTLR start "rule__PhysicChange__Group__9"
    // InternalArg.g:8701:1: rule__PhysicChange__Group__9 : rule__PhysicChange__Group__9__Impl ;
    public final void rule__PhysicChange__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8705:1: ( rule__PhysicChange__Group__9__Impl )
            // InternalArg.g:8706:2: rule__PhysicChange__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__9"


    // $ANTLR start "rule__PhysicChange__Group__9__Impl"
    // InternalArg.g:8712:1: rule__PhysicChange__Group__9__Impl : ( ( rule__PhysicChange__Group_9__0 )? ) ;
    public final void rule__PhysicChange__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8716:1: ( ( ( rule__PhysicChange__Group_9__0 )? ) )
            // InternalArg.g:8717:1: ( ( rule__PhysicChange__Group_9__0 )? )
            {
            // InternalArg.g:8717:1: ( ( rule__PhysicChange__Group_9__0 )? )
            // InternalArg.g:8718:2: ( rule__PhysicChange__Group_9__0 )?
            {
             before(grammarAccess.getPhysicChangeAccess().getGroup_9()); 
            // InternalArg.g:8719:2: ( rule__PhysicChange__Group_9__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==109) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalArg.g:8719:3: rule__PhysicChange__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhysicChange__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group__9__Impl"


    // $ANTLR start "rule__PhysicChange__Group_2__0"
    // InternalArg.g:8728:1: rule__PhysicChange__Group_2__0 : rule__PhysicChange__Group_2__0__Impl rule__PhysicChange__Group_2__1 ;
    public final void rule__PhysicChange__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8732:1: ( rule__PhysicChange__Group_2__0__Impl rule__PhysicChange__Group_2__1 )
            // InternalArg.g:8733:2: rule__PhysicChange__Group_2__0__Impl rule__PhysicChange__Group_2__1
            {
            pushFollow(FOLLOW_83);
            rule__PhysicChange__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_2__0"


    // $ANTLR start "rule__PhysicChange__Group_2__0__Impl"
    // InternalArg.g:8740:1: rule__PhysicChange__Group_2__0__Impl : ( ( 'in' )? ) ;
    public final void rule__PhysicChange__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8744:1: ( ( ( 'in' )? ) )
            // InternalArg.g:8745:1: ( ( 'in' )? )
            {
            // InternalArg.g:8745:1: ( ( 'in' )? )
            // InternalArg.g:8746:2: ( 'in' )?
            {
             before(grammarAccess.getPhysicChangeAccess().getInKeyword_2_0()); 
            // InternalArg.g:8747:2: ( 'in' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==104) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalArg.g:8747:3: 'in'
                    {
                    match(input,104,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPhysicChangeAccess().getInKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_2__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_2__1"
    // InternalArg.g:8755:1: rule__PhysicChange__Group_2__1 : rule__PhysicChange__Group_2__1__Impl ;
    public final void rule__PhysicChange__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8759:1: ( rule__PhysicChange__Group_2__1__Impl )
            // InternalArg.g:8760:2: rule__PhysicChange__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_2__1"


    // $ANTLR start "rule__PhysicChange__Group_2__1__Impl"
    // InternalArg.g:8766:1: rule__PhysicChange__Group_2__1__Impl : ( ( rule__PhysicChange__ClassAssignment_2_1 ) ) ;
    public final void rule__PhysicChange__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8770:1: ( ( ( rule__PhysicChange__ClassAssignment_2_1 ) ) )
            // InternalArg.g:8771:1: ( ( rule__PhysicChange__ClassAssignment_2_1 ) )
            {
            // InternalArg.g:8771:1: ( ( rule__PhysicChange__ClassAssignment_2_1 ) )
            // InternalArg.g:8772:2: ( rule__PhysicChange__ClassAssignment_2_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getClassAssignment_2_1()); 
            // InternalArg.g:8773:2: ( rule__PhysicChange__ClassAssignment_2_1 )
            // InternalArg.g:8773:3: rule__PhysicChange__ClassAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ClassAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getClassAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_2__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group_5__0"
    // InternalArg.g:8782:1: rule__PhysicChange__Group_5__0 : rule__PhysicChange__Group_5__0__Impl rule__PhysicChange__Group_5__1 ;
    public final void rule__PhysicChange__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8786:1: ( rule__PhysicChange__Group_5__0__Impl rule__PhysicChange__Group_5__1 )
            // InternalArg.g:8787:2: rule__PhysicChange__Group_5__0__Impl rule__PhysicChange__Group_5__1
            {
            pushFollow(FOLLOW_84);
            rule__PhysicChange__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_5__0"


    // $ANTLR start "rule__PhysicChange__Group_5__0__Impl"
    // InternalArg.g:8794:1: rule__PhysicChange__Group_5__0__Impl : ( 'at' ) ;
    public final void rule__PhysicChange__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8798:1: ( ( 'at' ) )
            // InternalArg.g:8799:1: ( 'at' )
            {
            // InternalArg.g:8799:1: ( 'at' )
            // InternalArg.g:8800:2: 'at'
            {
             before(grammarAccess.getPhysicChangeAccess().getAtKeyword_5_0()); 
            match(input,105,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getAtKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_5__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_5__1"
    // InternalArg.g:8809:1: rule__PhysicChange__Group_5__1 : rule__PhysicChange__Group_5__1__Impl ;
    public final void rule__PhysicChange__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8813:1: ( rule__PhysicChange__Group_5__1__Impl )
            // InternalArg.g:8814:2: rule__PhysicChange__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_5__1"


    // $ANTLR start "rule__PhysicChange__Group_5__1__Impl"
    // InternalArg.g:8820:1: rule__PhysicChange__Group_5__1__Impl : ( ( rule__PhysicChange__PositionAssignment_5_1 ) ) ;
    public final void rule__PhysicChange__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8824:1: ( ( ( rule__PhysicChange__PositionAssignment_5_1 ) ) )
            // InternalArg.g:8825:1: ( ( rule__PhysicChange__PositionAssignment_5_1 ) )
            {
            // InternalArg.g:8825:1: ( ( rule__PhysicChange__PositionAssignment_5_1 ) )
            // InternalArg.g:8826:2: ( rule__PhysicChange__PositionAssignment_5_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getPositionAssignment_5_1()); 
            // InternalArg.g:8827:2: ( rule__PhysicChange__PositionAssignment_5_1 )
            // InternalArg.g:8827:3: rule__PhysicChange__PositionAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__PositionAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getPositionAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_5__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group_6__0"
    // InternalArg.g:8836:1: rule__PhysicChange__Group_6__0 : rule__PhysicChange__Group_6__0__Impl rule__PhysicChange__Group_6__1 ;
    public final void rule__PhysicChange__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8840:1: ( rule__PhysicChange__Group_6__0__Impl rule__PhysicChange__Group_6__1 )
            // InternalArg.g:8841:2: rule__PhysicChange__Group_6__0__Impl rule__PhysicChange__Group_6__1
            {
            pushFollow(FOLLOW_42);
            rule__PhysicChange__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_6__0"


    // $ANTLR start "rule__PhysicChange__Group_6__0__Impl"
    // InternalArg.g:8848:1: rule__PhysicChange__Group_6__0__Impl : ( 'scale' ) ;
    public final void rule__PhysicChange__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8852:1: ( ( 'scale' ) )
            // InternalArg.g:8853:1: ( 'scale' )
            {
            // InternalArg.g:8853:1: ( 'scale' )
            // InternalArg.g:8854:2: 'scale'
            {
             before(grammarAccess.getPhysicChangeAccess().getScaleKeyword_6_0()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getScaleKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_6__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_6__1"
    // InternalArg.g:8863:1: rule__PhysicChange__Group_6__1 : rule__PhysicChange__Group_6__1__Impl ;
    public final void rule__PhysicChange__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8867:1: ( rule__PhysicChange__Group_6__1__Impl )
            // InternalArg.g:8868:2: rule__PhysicChange__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_6__1"


    // $ANTLR start "rule__PhysicChange__Group_6__1__Impl"
    // InternalArg.g:8874:1: rule__PhysicChange__Group_6__1__Impl : ( ( rule__PhysicChange__ScaleAssignment_6_1 ) ) ;
    public final void rule__PhysicChange__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8878:1: ( ( ( rule__PhysicChange__ScaleAssignment_6_1 ) ) )
            // InternalArg.g:8879:1: ( ( rule__PhysicChange__ScaleAssignment_6_1 ) )
            {
            // InternalArg.g:8879:1: ( ( rule__PhysicChange__ScaleAssignment_6_1 ) )
            // InternalArg.g:8880:2: ( rule__PhysicChange__ScaleAssignment_6_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getScaleAssignment_6_1()); 
            // InternalArg.g:8881:2: ( rule__PhysicChange__ScaleAssignment_6_1 )
            // InternalArg.g:8881:3: rule__PhysicChange__ScaleAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ScaleAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getScaleAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_6__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group_7__0"
    // InternalArg.g:8890:1: rule__PhysicChange__Group_7__0 : rule__PhysicChange__Group_7__0__Impl rule__PhysicChange__Group_7__1 ;
    public final void rule__PhysicChange__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8894:1: ( rule__PhysicChange__Group_7__0__Impl rule__PhysicChange__Group_7__1 )
            // InternalArg.g:8895:2: rule__PhysicChange__Group_7__0__Impl rule__PhysicChange__Group_7__1
            {
            pushFollow(FOLLOW_3);
            rule__PhysicChange__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_7__0"


    // $ANTLR start "rule__PhysicChange__Group_7__0__Impl"
    // InternalArg.g:8902:1: rule__PhysicChange__Group_7__0__Impl : ( 'stat' ) ;
    public final void rule__PhysicChange__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8906:1: ( ( 'stat' ) )
            // InternalArg.g:8907:1: ( 'stat' )
            {
            // InternalArg.g:8907:1: ( 'stat' )
            // InternalArg.g:8908:2: 'stat'
            {
             before(grammarAccess.getPhysicChangeAccess().getStatKeyword_7_0()); 
            match(input,107,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getStatKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_7__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_7__1"
    // InternalArg.g:8917:1: rule__PhysicChange__Group_7__1 : rule__PhysicChange__Group_7__1__Impl ;
    public final void rule__PhysicChange__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8921:1: ( rule__PhysicChange__Group_7__1__Impl )
            // InternalArg.g:8922:2: rule__PhysicChange__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_7__1"


    // $ANTLR start "rule__PhysicChange__Group_7__1__Impl"
    // InternalArg.g:8928:1: rule__PhysicChange__Group_7__1__Impl : ( ( rule__PhysicChange__AttributeAssignment_7_1 ) ) ;
    public final void rule__PhysicChange__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8932:1: ( ( ( rule__PhysicChange__AttributeAssignment_7_1 ) ) )
            // InternalArg.g:8933:1: ( ( rule__PhysicChange__AttributeAssignment_7_1 ) )
            {
            // InternalArg.g:8933:1: ( ( rule__PhysicChange__AttributeAssignment_7_1 ) )
            // InternalArg.g:8934:2: ( rule__PhysicChange__AttributeAssignment_7_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getAttributeAssignment_7_1()); 
            // InternalArg.g:8935:2: ( rule__PhysicChange__AttributeAssignment_7_1 )
            // InternalArg.g:8935:3: rule__PhysicChange__AttributeAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__AttributeAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getAttributeAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_7__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group_8__0"
    // InternalArg.g:8944:1: rule__PhysicChange__Group_8__0 : rule__PhysicChange__Group_8__0__Impl rule__PhysicChange__Group_8__1 ;
    public final void rule__PhysicChange__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8948:1: ( rule__PhysicChange__Group_8__0__Impl rule__PhysicChange__Group_8__1 )
            // InternalArg.g:8949:2: rule__PhysicChange__Group_8__0__Impl rule__PhysicChange__Group_8__1
            {
            pushFollow(FOLLOW_25);
            rule__PhysicChange__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_8__0"


    // $ANTLR start "rule__PhysicChange__Group_8__0__Impl"
    // InternalArg.g:8956:1: rule__PhysicChange__Group_8__0__Impl : ( 'changeStat' ) ;
    public final void rule__PhysicChange__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8960:1: ( ( 'changeStat' ) )
            // InternalArg.g:8961:1: ( 'changeStat' )
            {
            // InternalArg.g:8961:1: ( 'changeStat' )
            // InternalArg.g:8962:2: 'changeStat'
            {
             before(grammarAccess.getPhysicChangeAccess().getChangeStatKeyword_8_0()); 
            match(input,108,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getChangeStatKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_8__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_8__1"
    // InternalArg.g:8971:1: rule__PhysicChange__Group_8__1 : rule__PhysicChange__Group_8__1__Impl ;
    public final void rule__PhysicChange__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8975:1: ( rule__PhysicChange__Group_8__1__Impl )
            // InternalArg.g:8976:2: rule__PhysicChange__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_8__1"


    // $ANTLR start "rule__PhysicChange__Group_8__1__Impl"
    // InternalArg.g:8982:1: rule__PhysicChange__Group_8__1__Impl : ( ( rule__PhysicChange__ChangeValueAssignment_8_1 ) ) ;
    public final void rule__PhysicChange__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:8986:1: ( ( ( rule__PhysicChange__ChangeValueAssignment_8_1 ) ) )
            // InternalArg.g:8987:1: ( ( rule__PhysicChange__ChangeValueAssignment_8_1 ) )
            {
            // InternalArg.g:8987:1: ( ( rule__PhysicChange__ChangeValueAssignment_8_1 ) )
            // InternalArg.g:8988:2: ( rule__PhysicChange__ChangeValueAssignment_8_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getChangeValueAssignment_8_1()); 
            // InternalArg.g:8989:2: ( rule__PhysicChange__ChangeValueAssignment_8_1 )
            // InternalArg.g:8989:3: rule__PhysicChange__ChangeValueAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ChangeValueAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getChangeValueAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_8__1__Impl"


    // $ANTLR start "rule__PhysicChange__Group_9__0"
    // InternalArg.g:8998:1: rule__PhysicChange__Group_9__0 : rule__PhysicChange__Group_9__0__Impl rule__PhysicChange__Group_9__1 ;
    public final void rule__PhysicChange__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9002:1: ( rule__PhysicChange__Group_9__0__Impl rule__PhysicChange__Group_9__1 )
            // InternalArg.g:9003:2: rule__PhysicChange__Group_9__0__Impl rule__PhysicChange__Group_9__1
            {
            pushFollow(FOLLOW_3);
            rule__PhysicChange__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_9__0"


    // $ANTLR start "rule__PhysicChange__Group_9__0__Impl"
    // InternalArg.g:9010:1: rule__PhysicChange__Group_9__0__Impl : ( 'force' ) ;
    public final void rule__PhysicChange__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9014:1: ( ( 'force' ) )
            // InternalArg.g:9015:1: ( 'force' )
            {
            // InternalArg.g:9015:1: ( 'force' )
            // InternalArg.g:9016:2: 'force'
            {
             before(grammarAccess.getPhysicChangeAccess().getForceKeyword_9_0()); 
            match(input,109,FOLLOW_2); 
             after(grammarAccess.getPhysicChangeAccess().getForceKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_9__0__Impl"


    // $ANTLR start "rule__PhysicChange__Group_9__1"
    // InternalArg.g:9025:1: rule__PhysicChange__Group_9__1 : rule__PhysicChange__Group_9__1__Impl ;
    public final void rule__PhysicChange__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9029:1: ( rule__PhysicChange__Group_9__1__Impl )
            // InternalArg.g:9030:2: rule__PhysicChange__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_9__1"


    // $ANTLR start "rule__PhysicChange__Group_9__1__Impl"
    // InternalArg.g:9036:1: rule__PhysicChange__Group_9__1__Impl : ( ( rule__PhysicChange__ForceAssignment_9_1 ) ) ;
    public final void rule__PhysicChange__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9040:1: ( ( ( rule__PhysicChange__ForceAssignment_9_1 ) ) )
            // InternalArg.g:9041:1: ( ( rule__PhysicChange__ForceAssignment_9_1 ) )
            {
            // InternalArg.g:9041:1: ( ( rule__PhysicChange__ForceAssignment_9_1 ) )
            // InternalArg.g:9042:2: ( rule__PhysicChange__ForceAssignment_9_1 )
            {
             before(grammarAccess.getPhysicChangeAccess().getForceAssignment_9_1()); 
            // InternalArg.g:9043:2: ( rule__PhysicChange__ForceAssignment_9_1 )
            // InternalArg.g:9043:3: rule__PhysicChange__ForceAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__PhysicChange__ForceAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicChangeAccess().getForceAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__Group_9__1__Impl"


    // $ANTLR start "rule__ObjAttribute__Group__0"
    // InternalArg.g:9052:1: rule__ObjAttribute__Group__0 : rule__ObjAttribute__Group__0__Impl rule__ObjAttribute__Group__1 ;
    public final void rule__ObjAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9056:1: ( rule__ObjAttribute__Group__0__Impl rule__ObjAttribute__Group__1 )
            // InternalArg.g:9057:2: rule__ObjAttribute__Group__0__Impl rule__ObjAttribute__Group__1
            {
            pushFollow(FOLLOW_85);
            rule__ObjAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__0"


    // $ANTLR start "rule__ObjAttribute__Group__0__Impl"
    // InternalArg.g:9064:1: rule__ObjAttribute__Group__0__Impl : ( ( rule__ObjAttribute__AttributeAssignment_0 ) ) ;
    public final void rule__ObjAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9068:1: ( ( ( rule__ObjAttribute__AttributeAssignment_0 ) ) )
            // InternalArg.g:9069:1: ( ( rule__ObjAttribute__AttributeAssignment_0 ) )
            {
            // InternalArg.g:9069:1: ( ( rule__ObjAttribute__AttributeAssignment_0 ) )
            // InternalArg.g:9070:2: ( rule__ObjAttribute__AttributeAssignment_0 )
            {
             before(grammarAccess.getObjAttributeAccess().getAttributeAssignment_0()); 
            // InternalArg.g:9071:2: ( rule__ObjAttribute__AttributeAssignment_0 )
            // InternalArg.g:9071:3: rule__ObjAttribute__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ObjAttribute__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getObjAttributeAccess().getAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__0__Impl"


    // $ANTLR start "rule__ObjAttribute__Group__1"
    // InternalArg.g:9079:1: rule__ObjAttribute__Group__1 : rule__ObjAttribute__Group__1__Impl rule__ObjAttribute__Group__2 ;
    public final void rule__ObjAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9083:1: ( rule__ObjAttribute__Group__1__Impl rule__ObjAttribute__Group__2 )
            // InternalArg.g:9084:2: rule__ObjAttribute__Group__1__Impl rule__ObjAttribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__ObjAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__1"


    // $ANTLR start "rule__ObjAttribute__Group__1__Impl"
    // InternalArg.g:9091:1: rule__ObjAttribute__Group__1__Impl : ( 'value' ) ;
    public final void rule__ObjAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9095:1: ( ( 'value' ) )
            // InternalArg.g:9096:1: ( 'value' )
            {
            // InternalArg.g:9096:1: ( 'value' )
            // InternalArg.g:9097:2: 'value'
            {
             before(grammarAccess.getObjAttributeAccess().getValueKeyword_1()); 
            match(input,110,FOLLOW_2); 
             after(grammarAccess.getObjAttributeAccess().getValueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__1__Impl"


    // $ANTLR start "rule__ObjAttribute__Group__2"
    // InternalArg.g:9106:1: rule__ObjAttribute__Group__2 : rule__ObjAttribute__Group__2__Impl ;
    public final void rule__ObjAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9110:1: ( rule__ObjAttribute__Group__2__Impl )
            // InternalArg.g:9111:2: rule__ObjAttribute__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjAttribute__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__2"


    // $ANTLR start "rule__ObjAttribute__Group__2__Impl"
    // InternalArg.g:9117:1: rule__ObjAttribute__Group__2__Impl : ( ( rule__ObjAttribute__ValueAssignment_2 ) ) ;
    public final void rule__ObjAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9121:1: ( ( ( rule__ObjAttribute__ValueAssignment_2 ) ) )
            // InternalArg.g:9122:1: ( ( rule__ObjAttribute__ValueAssignment_2 ) )
            {
            // InternalArg.g:9122:1: ( ( rule__ObjAttribute__ValueAssignment_2 ) )
            // InternalArg.g:9123:2: ( rule__ObjAttribute__ValueAssignment_2 )
            {
             before(grammarAccess.getObjAttributeAccess().getValueAssignment_2()); 
            // InternalArg.g:9124:2: ( rule__ObjAttribute__ValueAssignment_2 )
            // InternalArg.g:9124:3: rule__ObjAttribute__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ObjAttribute__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getObjAttributeAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__0"
    // InternalArg.g:9133:1: rule__Rule__Group__0 : rule__Rule__Group__0__Impl rule__Rule__Group__1 ;
    public final void rule__Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9137:1: ( rule__Rule__Group__0__Impl rule__Rule__Group__1 )
            // InternalArg.g:9138:2: rule__Rule__Group__0__Impl rule__Rule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Rule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0"


    // $ANTLR start "rule__Rule__Group__0__Impl"
    // InternalArg.g:9145:1: rule__Rule__Group__0__Impl : ( 'do' ) ;
    public final void rule__Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9149:1: ( ( 'do' ) )
            // InternalArg.g:9150:1: ( 'do' )
            {
            // InternalArg.g:9150:1: ( 'do' )
            // InternalArg.g:9151:2: 'do'
            {
             before(grammarAccess.getRuleAccess().getDoKeyword_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getDoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0__Impl"


    // $ANTLR start "rule__Rule__Group__1"
    // InternalArg.g:9160:1: rule__Rule__Group__1 : rule__Rule__Group__1__Impl rule__Rule__Group__2 ;
    public final void rule__Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9164:1: ( rule__Rule__Group__1__Impl rule__Rule__Group__2 )
            // InternalArg.g:9165:2: rule__Rule__Group__1__Impl rule__Rule__Group__2
            {
            pushFollow(FOLLOW_86);
            rule__Rule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1"


    // $ANTLR start "rule__Rule__Group__1__Impl"
    // InternalArg.g:9172:1: rule__Rule__Group__1__Impl : ( ( rule__Rule__ActionAssignment_1 ) ) ;
    public final void rule__Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9176:1: ( ( ( rule__Rule__ActionAssignment_1 ) ) )
            // InternalArg.g:9177:1: ( ( rule__Rule__ActionAssignment_1 ) )
            {
            // InternalArg.g:9177:1: ( ( rule__Rule__ActionAssignment_1 ) )
            // InternalArg.g:9178:2: ( rule__Rule__ActionAssignment_1 )
            {
             before(grammarAccess.getRuleAccess().getActionAssignment_1()); 
            // InternalArg.g:9179:2: ( rule__Rule__ActionAssignment_1 )
            // InternalArg.g:9179:3: rule__Rule__ActionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Rule__ActionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getActionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1__Impl"


    // $ANTLR start "rule__Rule__Group__2"
    // InternalArg.g:9187:1: rule__Rule__Group__2 : rule__Rule__Group__2__Impl rule__Rule__Group__3 ;
    public final void rule__Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9191:1: ( rule__Rule__Group__2__Impl rule__Rule__Group__3 )
            // InternalArg.g:9192:2: rule__Rule__Group__2__Impl rule__Rule__Group__3
            {
            pushFollow(FOLLOW_87);
            rule__Rule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2"


    // $ANTLR start "rule__Rule__Group__2__Impl"
    // InternalArg.g:9199:1: rule__Rule__Group__2__Impl : ( 'if(' ) ;
    public final void rule__Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9203:1: ( ( 'if(' ) )
            // InternalArg.g:9204:1: ( 'if(' )
            {
            // InternalArg.g:9204:1: ( 'if(' )
            // InternalArg.g:9205:2: 'if('
            {
             before(grammarAccess.getRuleAccess().getIfKeyword_2()); 
            match(input,111,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getIfKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__3"
    // InternalArg.g:9214:1: rule__Rule__Group__3 : rule__Rule__Group__3__Impl rule__Rule__Group__4 ;
    public final void rule__Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9218:1: ( rule__Rule__Group__3__Impl rule__Rule__Group__4 )
            // InternalArg.g:9219:2: rule__Rule__Group__3__Impl rule__Rule__Group__4
            {
            pushFollow(FOLLOW_88);
            rule__Rule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3"


    // $ANTLR start "rule__Rule__Group__3__Impl"
    // InternalArg.g:9226:1: rule__Rule__Group__3__Impl : ( ( rule__Rule__ConditionAssignment_3 ) ) ;
    public final void rule__Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9230:1: ( ( ( rule__Rule__ConditionAssignment_3 ) ) )
            // InternalArg.g:9231:1: ( ( rule__Rule__ConditionAssignment_3 ) )
            {
            // InternalArg.g:9231:1: ( ( rule__Rule__ConditionAssignment_3 ) )
            // InternalArg.g:9232:2: ( rule__Rule__ConditionAssignment_3 )
            {
             before(grammarAccess.getRuleAccess().getConditionAssignment_3()); 
            // InternalArg.g:9233:2: ( rule__Rule__ConditionAssignment_3 )
            // InternalArg.g:9233:3: rule__Rule__ConditionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Rule__ConditionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getConditionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3__Impl"


    // $ANTLR start "rule__Rule__Group__4"
    // InternalArg.g:9241:1: rule__Rule__Group__4 : rule__Rule__Group__4__Impl ;
    public final void rule__Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9245:1: ( rule__Rule__Group__4__Impl )
            // InternalArg.g:9246:2: rule__Rule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4"


    // $ANTLR start "rule__Rule__Group__4__Impl"
    // InternalArg.g:9252:1: rule__Rule__Group__4__Impl : ( ')' ) ;
    public final void rule__Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9256:1: ( ( ')' ) )
            // InternalArg.g:9257:1: ( ')' )
            {
            // InternalArg.g:9257:1: ( ')' )
            // InternalArg.g:9258:2: ')'
            {
             before(grammarAccess.getRuleAccess().getRightParenthesisKeyword_4()); 
            match(input,112,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4__Impl"


    // $ANTLR start "rule__Not__Group__0"
    // InternalArg.g:9268:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9272:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalArg.g:9273:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_87);
            rule__Not__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0"


    // $ANTLR start "rule__Not__Group__0__Impl"
    // InternalArg.g:9280:1: rule__Not__Group__0__Impl : ( '!' ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9284:1: ( ( '!' ) )
            // InternalArg.g:9285:1: ( '!' )
            {
            // InternalArg.g:9285:1: ( '!' )
            // InternalArg.g:9286:2: '!'
            {
             before(grammarAccess.getNotAccess().getExclamationMarkKeyword_0()); 
            match(input,113,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getExclamationMarkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0__Impl"


    // $ANTLR start "rule__Not__Group__1"
    // InternalArg.g:9295:1: rule__Not__Group__1 : rule__Not__Group__1__Impl ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9299:1: ( rule__Not__Group__1__Impl )
            // InternalArg.g:9300:2: rule__Not__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1"


    // $ANTLR start "rule__Not__Group__1__Impl"
    // InternalArg.g:9306:1: rule__Not__Group__1__Impl : ( ( rule__Not__LeftAssignment_1 ) ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9310:1: ( ( ( rule__Not__LeftAssignment_1 ) ) )
            // InternalArg.g:9311:1: ( ( rule__Not__LeftAssignment_1 ) )
            {
            // InternalArg.g:9311:1: ( ( rule__Not__LeftAssignment_1 ) )
            // InternalArg.g:9312:2: ( rule__Not__LeftAssignment_1 )
            {
             before(grammarAccess.getNotAccess().getLeftAssignment_1()); 
            // InternalArg.g:9313:2: ( rule__Not__LeftAssignment_1 )
            // InternalArg.g:9313:3: rule__Not__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Not__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1__Impl"


    // $ANTLR start "rule__Binary__Group__0"
    // InternalArg.g:9322:1: rule__Binary__Group__0 : rule__Binary__Group__0__Impl rule__Binary__Group__1 ;
    public final void rule__Binary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9326:1: ( rule__Binary__Group__0__Impl rule__Binary__Group__1 )
            // InternalArg.g:9327:2: rule__Binary__Group__0__Impl rule__Binary__Group__1
            {
            pushFollow(FOLLOW_87);
            rule__Binary__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__0"


    // $ANTLR start "rule__Binary__Group__0__Impl"
    // InternalArg.g:9334:1: rule__Binary__Group__0__Impl : ( '(' ) ;
    public final void rule__Binary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9338:1: ( ( '(' ) )
            // InternalArg.g:9339:1: ( '(' )
            {
            // InternalArg.g:9339:1: ( '(' )
            // InternalArg.g:9340:2: '('
            {
             before(grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_0()); 
            match(input,114,FOLLOW_2); 
             after(grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__0__Impl"


    // $ANTLR start "rule__Binary__Group__1"
    // InternalArg.g:9349:1: rule__Binary__Group__1 : rule__Binary__Group__1__Impl rule__Binary__Group__2 ;
    public final void rule__Binary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9353:1: ( rule__Binary__Group__1__Impl rule__Binary__Group__2 )
            // InternalArg.g:9354:2: rule__Binary__Group__1__Impl rule__Binary__Group__2
            {
            pushFollow(FOLLOW_88);
            rule__Binary__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__1"


    // $ANTLR start "rule__Binary__Group__1__Impl"
    // InternalArg.g:9361:1: rule__Binary__Group__1__Impl : ( ( rule__Binary__LeftAssignment_1 ) ) ;
    public final void rule__Binary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9365:1: ( ( ( rule__Binary__LeftAssignment_1 ) ) )
            // InternalArg.g:9366:1: ( ( rule__Binary__LeftAssignment_1 ) )
            {
            // InternalArg.g:9366:1: ( ( rule__Binary__LeftAssignment_1 ) )
            // InternalArg.g:9367:2: ( rule__Binary__LeftAssignment_1 )
            {
             before(grammarAccess.getBinaryAccess().getLeftAssignment_1()); 
            // InternalArg.g:9368:2: ( rule__Binary__LeftAssignment_1 )
            // InternalArg.g:9368:3: rule__Binary__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Binary__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__1__Impl"


    // $ANTLR start "rule__Binary__Group__2"
    // InternalArg.g:9376:1: rule__Binary__Group__2 : rule__Binary__Group__2__Impl rule__Binary__Group__3 ;
    public final void rule__Binary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9380:1: ( rule__Binary__Group__2__Impl rule__Binary__Group__3 )
            // InternalArg.g:9381:2: rule__Binary__Group__2__Impl rule__Binary__Group__3
            {
            pushFollow(FOLLOW_89);
            rule__Binary__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__2"


    // $ANTLR start "rule__Binary__Group__2__Impl"
    // InternalArg.g:9388:1: rule__Binary__Group__2__Impl : ( ')' ) ;
    public final void rule__Binary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9392:1: ( ( ')' ) )
            // InternalArg.g:9393:1: ( ')' )
            {
            // InternalArg.g:9393:1: ( ')' )
            // InternalArg.g:9394:2: ')'
            {
             before(grammarAccess.getBinaryAccess().getRightParenthesisKeyword_2()); 
            match(input,112,FOLLOW_2); 
             after(grammarAccess.getBinaryAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__2__Impl"


    // $ANTLR start "rule__Binary__Group__3"
    // InternalArg.g:9403:1: rule__Binary__Group__3 : rule__Binary__Group__3__Impl rule__Binary__Group__4 ;
    public final void rule__Binary__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9407:1: ( rule__Binary__Group__3__Impl rule__Binary__Group__4 )
            // InternalArg.g:9408:2: rule__Binary__Group__3__Impl rule__Binary__Group__4
            {
            pushFollow(FOLLOW_90);
            rule__Binary__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__3"


    // $ANTLR start "rule__Binary__Group__3__Impl"
    // InternalArg.g:9415:1: rule__Binary__Group__3__Impl : ( ( rule__Binary__OpAssignment_3 ) ) ;
    public final void rule__Binary__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9419:1: ( ( ( rule__Binary__OpAssignment_3 ) ) )
            // InternalArg.g:9420:1: ( ( rule__Binary__OpAssignment_3 ) )
            {
            // InternalArg.g:9420:1: ( ( rule__Binary__OpAssignment_3 ) )
            // InternalArg.g:9421:2: ( rule__Binary__OpAssignment_3 )
            {
             before(grammarAccess.getBinaryAccess().getOpAssignment_3()); 
            // InternalArg.g:9422:2: ( rule__Binary__OpAssignment_3 )
            // InternalArg.g:9422:3: rule__Binary__OpAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Binary__OpAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBinaryAccess().getOpAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__3__Impl"


    // $ANTLR start "rule__Binary__Group__4"
    // InternalArg.g:9430:1: rule__Binary__Group__4 : rule__Binary__Group__4__Impl rule__Binary__Group__5 ;
    public final void rule__Binary__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9434:1: ( rule__Binary__Group__4__Impl rule__Binary__Group__5 )
            // InternalArg.g:9435:2: rule__Binary__Group__4__Impl rule__Binary__Group__5
            {
            pushFollow(FOLLOW_87);
            rule__Binary__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__4"


    // $ANTLR start "rule__Binary__Group__4__Impl"
    // InternalArg.g:9442:1: rule__Binary__Group__4__Impl : ( '(' ) ;
    public final void rule__Binary__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9446:1: ( ( '(' ) )
            // InternalArg.g:9447:1: ( '(' )
            {
            // InternalArg.g:9447:1: ( '(' )
            // InternalArg.g:9448:2: '('
            {
             before(grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_4()); 
            match(input,114,FOLLOW_2); 
             after(grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__4__Impl"


    // $ANTLR start "rule__Binary__Group__5"
    // InternalArg.g:9457:1: rule__Binary__Group__5 : rule__Binary__Group__5__Impl rule__Binary__Group__6 ;
    public final void rule__Binary__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9461:1: ( rule__Binary__Group__5__Impl rule__Binary__Group__6 )
            // InternalArg.g:9462:2: rule__Binary__Group__5__Impl rule__Binary__Group__6
            {
            pushFollow(FOLLOW_88);
            rule__Binary__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Binary__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__5"


    // $ANTLR start "rule__Binary__Group__5__Impl"
    // InternalArg.g:9469:1: rule__Binary__Group__5__Impl : ( ( rule__Binary__RightAssignment_5 ) ) ;
    public final void rule__Binary__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9473:1: ( ( ( rule__Binary__RightAssignment_5 ) ) )
            // InternalArg.g:9474:1: ( ( rule__Binary__RightAssignment_5 ) )
            {
            // InternalArg.g:9474:1: ( ( rule__Binary__RightAssignment_5 ) )
            // InternalArg.g:9475:2: ( rule__Binary__RightAssignment_5 )
            {
             before(grammarAccess.getBinaryAccess().getRightAssignment_5()); 
            // InternalArg.g:9476:2: ( rule__Binary__RightAssignment_5 )
            // InternalArg.g:9476:3: rule__Binary__RightAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Binary__RightAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getBinaryAccess().getRightAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__5__Impl"


    // $ANTLR start "rule__Binary__Group__6"
    // InternalArg.g:9484:1: rule__Binary__Group__6 : rule__Binary__Group__6__Impl ;
    public final void rule__Binary__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9488:1: ( rule__Binary__Group__6__Impl )
            // InternalArg.g:9489:2: rule__Binary__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Binary__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__6"


    // $ANTLR start "rule__Binary__Group__6__Impl"
    // InternalArg.g:9495:1: rule__Binary__Group__6__Impl : ( ')' ) ;
    public final void rule__Binary__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9499:1: ( ( ')' ) )
            // InternalArg.g:9500:1: ( ')' )
            {
            // InternalArg.g:9500:1: ( ')' )
            // InternalArg.g:9501:2: ')'
            {
             before(grammarAccess.getBinaryAccess().getRightParenthesisKeyword_6()); 
            match(input,112,FOLLOW_2); 
             after(grammarAccess.getBinaryAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__Group__6__Impl"


    // $ANTLR start "rule__Arithmetic__Group__0"
    // InternalArg.g:9511:1: rule__Arithmetic__Group__0 : rule__Arithmetic__Group__0__Impl rule__Arithmetic__Group__1 ;
    public final void rule__Arithmetic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9515:1: ( rule__Arithmetic__Group__0__Impl rule__Arithmetic__Group__1 )
            // InternalArg.g:9516:2: rule__Arithmetic__Group__0__Impl rule__Arithmetic__Group__1
            {
            pushFollow(FOLLOW_91);
            rule__Arithmetic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Arithmetic__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__0"


    // $ANTLR start "rule__Arithmetic__Group__0__Impl"
    // InternalArg.g:9523:1: rule__Arithmetic__Group__0__Impl : ( ( rule__Arithmetic__LeftAssignment_0 ) ) ;
    public final void rule__Arithmetic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9527:1: ( ( ( rule__Arithmetic__LeftAssignment_0 ) ) )
            // InternalArg.g:9528:1: ( ( rule__Arithmetic__LeftAssignment_0 ) )
            {
            // InternalArg.g:9528:1: ( ( rule__Arithmetic__LeftAssignment_0 ) )
            // InternalArg.g:9529:2: ( rule__Arithmetic__LeftAssignment_0 )
            {
             before(grammarAccess.getArithmeticAccess().getLeftAssignment_0()); 
            // InternalArg.g:9530:2: ( rule__Arithmetic__LeftAssignment_0 )
            // InternalArg.g:9530:3: rule__Arithmetic__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Arithmetic__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__0__Impl"


    // $ANTLR start "rule__Arithmetic__Group__1"
    // InternalArg.g:9538:1: rule__Arithmetic__Group__1 : rule__Arithmetic__Group__1__Impl rule__Arithmetic__Group__2 ;
    public final void rule__Arithmetic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9542:1: ( rule__Arithmetic__Group__1__Impl rule__Arithmetic__Group__2 )
            // InternalArg.g:9543:2: rule__Arithmetic__Group__1__Impl rule__Arithmetic__Group__2
            {
            pushFollow(FOLLOW_87);
            rule__Arithmetic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Arithmetic__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__1"


    // $ANTLR start "rule__Arithmetic__Group__1__Impl"
    // InternalArg.g:9550:1: rule__Arithmetic__Group__1__Impl : ( ( rule__Arithmetic__OpAssignment_1 ) ) ;
    public final void rule__Arithmetic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9554:1: ( ( ( rule__Arithmetic__OpAssignment_1 ) ) )
            // InternalArg.g:9555:1: ( ( rule__Arithmetic__OpAssignment_1 ) )
            {
            // InternalArg.g:9555:1: ( ( rule__Arithmetic__OpAssignment_1 ) )
            // InternalArg.g:9556:2: ( rule__Arithmetic__OpAssignment_1 )
            {
             before(grammarAccess.getArithmeticAccess().getOpAssignment_1()); 
            // InternalArg.g:9557:2: ( rule__Arithmetic__OpAssignment_1 )
            // InternalArg.g:9557:3: rule__Arithmetic__OpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Arithmetic__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticAccess().getOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__1__Impl"


    // $ANTLR start "rule__Arithmetic__Group__2"
    // InternalArg.g:9565:1: rule__Arithmetic__Group__2 : rule__Arithmetic__Group__2__Impl ;
    public final void rule__Arithmetic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9569:1: ( rule__Arithmetic__Group__2__Impl )
            // InternalArg.g:9570:2: rule__Arithmetic__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Arithmetic__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__2"


    // $ANTLR start "rule__Arithmetic__Group__2__Impl"
    // InternalArg.g:9576:1: rule__Arithmetic__Group__2__Impl : ( ( rule__Arithmetic__RightAssignment_2 ) ) ;
    public final void rule__Arithmetic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9580:1: ( ( ( rule__Arithmetic__RightAssignment_2 ) ) )
            // InternalArg.g:9581:1: ( ( rule__Arithmetic__RightAssignment_2 ) )
            {
            // InternalArg.g:9581:1: ( ( rule__Arithmetic__RightAssignment_2 ) )
            // InternalArg.g:9582:2: ( rule__Arithmetic__RightAssignment_2 )
            {
             before(grammarAccess.getArithmeticAccess().getRightAssignment_2()); 
            // InternalArg.g:9583:2: ( rule__Arithmetic__RightAssignment_2 )
            // InternalArg.g:9583:3: rule__Arithmetic__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Arithmetic__RightAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticAccess().getRightAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__Group__2__Impl"


    // $ANTLR start "rule__AttributeValue__Group__0"
    // InternalArg.g:9592:1: rule__AttributeValue__Group__0 : rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 ;
    public final void rule__AttributeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9596:1: ( rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 )
            // InternalArg.g:9597:2: rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1
            {
            pushFollow(FOLLOW_92);
            rule__AttributeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__0"


    // $ANTLR start "rule__AttributeValue__Group__0__Impl"
    // InternalArg.g:9604:1: rule__AttributeValue__Group__0__Impl : ( ( rule__AttributeValue__ClassAssignment_0 ) ) ;
    public final void rule__AttributeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9608:1: ( ( ( rule__AttributeValue__ClassAssignment_0 ) ) )
            // InternalArg.g:9609:1: ( ( rule__AttributeValue__ClassAssignment_0 ) )
            {
            // InternalArg.g:9609:1: ( ( rule__AttributeValue__ClassAssignment_0 ) )
            // InternalArg.g:9610:2: ( rule__AttributeValue__ClassAssignment_0 )
            {
             before(grammarAccess.getAttributeValueAccess().getClassAssignment_0()); 
            // InternalArg.g:9611:2: ( rule__AttributeValue__ClassAssignment_0 )
            // InternalArg.g:9611:3: rule__AttributeValue__ClassAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeValue__ClassAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeValueAccess().getClassAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__0__Impl"


    // $ANTLR start "rule__AttributeValue__Group__1"
    // InternalArg.g:9619:1: rule__AttributeValue__Group__1 : rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 ;
    public final void rule__AttributeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9623:1: ( rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 )
            // InternalArg.g:9624:2: rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__AttributeValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__1"


    // $ANTLR start "rule__AttributeValue__Group__1__Impl"
    // InternalArg.g:9631:1: rule__AttributeValue__Group__1__Impl : ( '.' ) ;
    public final void rule__AttributeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9635:1: ( ( '.' ) )
            // InternalArg.g:9636:1: ( '.' )
            {
            // InternalArg.g:9636:1: ( '.' )
            // InternalArg.g:9637:2: '.'
            {
             before(grammarAccess.getAttributeValueAccess().getFullStopKeyword_1()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getAttributeValueAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__1__Impl"


    // $ANTLR start "rule__AttributeValue__Group__2"
    // InternalArg.g:9646:1: rule__AttributeValue__Group__2 : rule__AttributeValue__Group__2__Impl ;
    public final void rule__AttributeValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9650:1: ( rule__AttributeValue__Group__2__Impl )
            // InternalArg.g:9651:2: rule__AttributeValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__2"


    // $ANTLR start "rule__AttributeValue__Group__2__Impl"
    // InternalArg.g:9657:1: rule__AttributeValue__Group__2__Impl : ( ( rule__AttributeValue__AttributeAssignment_2 ) ) ;
    public final void rule__AttributeValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9661:1: ( ( ( rule__AttributeValue__AttributeAssignment_2 ) ) )
            // InternalArg.g:9662:1: ( ( rule__AttributeValue__AttributeAssignment_2 ) )
            {
            // InternalArg.g:9662:1: ( ( rule__AttributeValue__AttributeAssignment_2 ) )
            // InternalArg.g:9663:2: ( rule__AttributeValue__AttributeAssignment_2 )
            {
             before(grammarAccess.getAttributeValueAccess().getAttributeAssignment_2()); 
            // InternalArg.g:9664:2: ( rule__AttributeValue__AttributeAssignment_2 )
            // InternalArg.g:9664:3: rule__AttributeValue__AttributeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeValue__AttributeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeValueAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__2__Impl"


    // $ANTLR start "rule__AllInstances__Group__0"
    // InternalArg.g:9673:1: rule__AllInstances__Group__0 : rule__AllInstances__Group__0__Impl rule__AllInstances__Group__1 ;
    public final void rule__AllInstances__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9677:1: ( rule__AllInstances__Group__0__Impl rule__AllInstances__Group__1 )
            // InternalArg.g:9678:2: rule__AllInstances__Group__0__Impl rule__AllInstances__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__AllInstances__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllInstances__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstances__Group__0"


    // $ANTLR start "rule__AllInstances__Group__0__Impl"
    // InternalArg.g:9685:1: rule__AllInstances__Group__0__Impl : ( 'Number' ) ;
    public final void rule__AllInstances__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9689:1: ( ( 'Number' ) )
            // InternalArg.g:9690:1: ( 'Number' )
            {
            // InternalArg.g:9690:1: ( 'Number' )
            // InternalArg.g:9691:2: 'Number'
            {
             before(grammarAccess.getAllInstancesAccess().getNumberKeyword_0()); 
            match(input,115,FOLLOW_2); 
             after(grammarAccess.getAllInstancesAccess().getNumberKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstances__Group__0__Impl"


    // $ANTLR start "rule__AllInstances__Group__1"
    // InternalArg.g:9700:1: rule__AllInstances__Group__1 : rule__AllInstances__Group__1__Impl ;
    public final void rule__AllInstances__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9704:1: ( rule__AllInstances__Group__1__Impl )
            // InternalArg.g:9705:2: rule__AllInstances__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllInstances__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstances__Group__1"


    // $ANTLR start "rule__AllInstances__Group__1__Impl"
    // InternalArg.g:9711:1: rule__AllInstances__Group__1__Impl : ( ( rule__AllInstances__TypeAssignment_1 ) ) ;
    public final void rule__AllInstances__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9715:1: ( ( ( rule__AllInstances__TypeAssignment_1 ) ) )
            // InternalArg.g:9716:1: ( ( rule__AllInstances__TypeAssignment_1 ) )
            {
            // InternalArg.g:9716:1: ( ( rule__AllInstances__TypeAssignment_1 ) )
            // InternalArg.g:9717:2: ( rule__AllInstances__TypeAssignment_1 )
            {
             before(grammarAccess.getAllInstancesAccess().getTypeAssignment_1()); 
            // InternalArg.g:9718:2: ( rule__AllInstances__TypeAssignment_1 )
            // InternalArg.g:9718:3: rule__AllInstances__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AllInstances__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAllInstancesAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstances__Group__1__Impl"


    // $ANTLR start "rule__Ontological__NameAssignment_1"
    // InternalArg.g:9727:1: rule__Ontological__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Ontological__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9731:1: ( ( ruleEString ) )
            // InternalArg.g:9732:2: ( ruleEString )
            {
            // InternalArg.g:9732:2: ( ruleEString )
            // InternalArg.g:9733:3: ruleEString
            {
             before(grammarAccess.getOntologicalAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__NameAssignment_1"


    // $ANTLR start "rule__Ontological__ClassesAssignment_5"
    // InternalArg.g:9742:1: rule__Ontological__ClassesAssignment_5 : ( ruleClass ) ;
    public final void rule__Ontological__ClassesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9746:1: ( ( ruleClass ) )
            // InternalArg.g:9747:2: ( ruleClass )
            {
            // InternalArg.g:9747:2: ( ruleClass )
            // InternalArg.g:9748:3: ruleClass
            {
             before(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__ClassesAssignment_5"


    // $ANTLR start "rule__Ontological__ClassesAssignment_6"
    // InternalArg.g:9757:1: rule__Ontological__ClassesAssignment_6 : ( ruleClass ) ;
    public final void rule__Ontological__ClassesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9761:1: ( ( ruleClass ) )
            // InternalArg.g:9762:2: ( ruleClass )
            {
            // InternalArg.g:9762:2: ( ruleClass )
            // InternalArg.g:9763:3: ruleClass
            {
             before(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__ClassesAssignment_6"


    // $ANTLR start "rule__Ontological__GraphicAssignment_9"
    // InternalArg.g:9772:1: rule__Ontological__GraphicAssignment_9 : ( ruleGraphic ) ;
    public final void rule__Ontological__GraphicAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9776:1: ( ( ruleGraphic ) )
            // InternalArg.g:9777:2: ( ruleGraphic )
            {
            // InternalArg.g:9777:2: ( ruleGraphic )
            // InternalArg.g:9778:3: ruleGraphic
            {
             before(grammarAccess.getOntologicalAccess().getGraphicGraphicParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphic();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getGraphicGraphicParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__GraphicAssignment_9"


    // $ANTLR start "rule__Ontological__PhysicAssignment_10"
    // InternalArg.g:9787:1: rule__Ontological__PhysicAssignment_10 : ( rulePhysic ) ;
    public final void rule__Ontological__PhysicAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9791:1: ( ( rulePhysic ) )
            // InternalArg.g:9792:2: ( rulePhysic )
            {
            // InternalArg.g:9792:2: ( rulePhysic )
            // InternalArg.g:9793:3: rulePhysic
            {
             before(grammarAccess.getOntologicalAccess().getPhysicPhysicParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            rulePhysic();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getPhysicPhysicParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__PhysicAssignment_10"


    // $ANTLR start "rule__Ontological__GameAssignment_11"
    // InternalArg.g:9802:1: rule__Ontological__GameAssignment_11 : ( ruleGame ) ;
    public final void rule__Ontological__GameAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9806:1: ( ( ruleGame ) )
            // InternalArg.g:9807:2: ( ruleGame )
            {
            // InternalArg.g:9807:2: ( ruleGame )
            // InternalArg.g:9808:3: ruleGame
            {
             before(grammarAccess.getOntologicalAccess().getGameGameParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleGame();

            state._fsp--;

             after(grammarAccess.getOntologicalAccess().getGameGameParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ontological__GameAssignment_11"


    // $ANTLR start "rule__Class__NameAssignment_0"
    // InternalArg.g:9817:1: rule__Class__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Class__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9821:1: ( ( ruleEString ) )
            // InternalArg.g:9822:2: ( ruleEString )
            {
            // InternalArg.g:9822:2: ( ruleEString )
            // InternalArg.g:9823:3: ruleEString
            {
             before(grammarAccess.getClassAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClassAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__NameAssignment_0"


    // $ANTLR start "rule__Class__AttributesAssignment_2_0"
    // InternalArg.g:9832:1: rule__Class__AttributesAssignment_2_0 : ( ruleAttribute ) ;
    public final void rule__Class__AttributesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9836:1: ( ( ruleAttribute ) )
            // InternalArg.g:9837:2: ( ruleAttribute )
            {
            // InternalArg.g:9837:2: ( ruleAttribute )
            // InternalArg.g:9838:3: ruleAttribute
            {
             before(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__AttributesAssignment_2_0"


    // $ANTLR start "rule__Class__AttributesAssignment_2_1"
    // InternalArg.g:9847:1: rule__Class__AttributesAssignment_2_1 : ( ruleAttribute ) ;
    public final void rule__Class__AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9851:1: ( ( ruleAttribute ) )
            // InternalArg.g:9852:2: ( ruleAttribute )
            {
            // InternalArg.g:9852:2: ( ruleAttribute )
            // InternalArg.g:9853:3: ruleAttribute
            {
             before(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__AttributesAssignment_2_1"


    // $ANTLR start "rule__Class__ReferencesAssignment_3_2"
    // InternalArg.g:9862:1: rule__Class__ReferencesAssignment_3_2 : ( ruleReference ) ;
    public final void rule__Class__ReferencesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9866:1: ( ( ruleReference ) )
            // InternalArg.g:9867:2: ( ruleReference )
            {
            // InternalArg.g:9867:2: ( ruleReference )
            // InternalArg.g:9868:3: ruleReference
            {
             before(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ReferencesAssignment_3_2"


    // $ANTLR start "rule__Class__ReferencesAssignment_3_3"
    // InternalArg.g:9877:1: rule__Class__ReferencesAssignment_3_3 : ( ruleReference ) ;
    public final void rule__Class__ReferencesAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9881:1: ( ( ruleReference ) )
            // InternalArg.g:9882:2: ( ruleReference )
            {
            // InternalArg.g:9882:2: ( ruleReference )
            // InternalArg.g:9883:3: ruleReference
            {
             before(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ReferencesAssignment_3_3"


    // $ANTLR start "rule__Class__AbstractAssignment_5"
    // InternalArg.g:9892:1: rule__Class__AbstractAssignment_5 : ( ( 'abstract' ) ) ;
    public final void rule__Class__AbstractAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9896:1: ( ( ( 'abstract' ) ) )
            // InternalArg.g:9897:2: ( ( 'abstract' ) )
            {
            // InternalArg.g:9897:2: ( ( 'abstract' ) )
            // InternalArg.g:9898:3: ( 'abstract' )
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_5_0()); 
            // InternalArg.g:9899:3: ( 'abstract' )
            // InternalArg.g:9900:4: 'abstract'
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_5_0()); 
            match(input,116,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getAbstractAbstractKeyword_5_0()); 

            }

             after(grammarAccess.getClassAccess().getAbstractAbstractKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__AbstractAssignment_5"


    // $ANTLR start "rule__Class__NoSCNAssignment_6"
    // InternalArg.g:9911:1: rule__Class__NoSCNAssignment_6 : ( ( 'invisible' ) ) ;
    public final void rule__Class__NoSCNAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9915:1: ( ( ( 'invisible' ) ) )
            // InternalArg.g:9916:2: ( ( 'invisible' ) )
            {
            // InternalArg.g:9916:2: ( ( 'invisible' ) )
            // InternalArg.g:9917:3: ( 'invisible' )
            {
             before(grammarAccess.getClassAccess().getNoSCNInvisibleKeyword_6_0()); 
            // InternalArg.g:9918:3: ( 'invisible' )
            // InternalArg.g:9919:4: 'invisible'
            {
             before(grammarAccess.getClassAccess().getNoSCNInvisibleKeyword_6_0()); 
            match(input,117,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getNoSCNInvisibleKeyword_6_0()); 

            }

             after(grammarAccess.getClassAccess().getNoSCNInvisibleKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__NoSCNAssignment_6"


    // $ANTLR start "rule__Graphic__ClassesAssignment_2"
    // InternalArg.g:9930:1: rule__Graphic__ClassesAssignment_2 : ( ruleGraphicClass ) ;
    public final void rule__Graphic__ClassesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9934:1: ( ( ruleGraphicClass ) )
            // InternalArg.g:9935:2: ( ruleGraphicClass )
            {
            // InternalArg.g:9935:2: ( ruleGraphicClass )
            // InternalArg.g:9936:3: ruleGraphicClass
            {
             before(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphicClass();

            state._fsp--;

             after(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__ClassesAssignment_2"


    // $ANTLR start "rule__Graphic__ClassesAssignment_3"
    // InternalArg.g:9945:1: rule__Graphic__ClassesAssignment_3 : ( ruleGraphicClass ) ;
    public final void rule__Graphic__ClassesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9949:1: ( ( ruleGraphicClass ) )
            // InternalArg.g:9950:2: ( ruleGraphicClass )
            {
            // InternalArg.g:9950:2: ( ruleGraphicClass )
            // InternalArg.g:9951:3: ruleGraphicClass
            {
             before(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphicClass();

            state._fsp--;

             after(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graphic__ClassesAssignment_3"


    // $ANTLR start "rule__Physic__ClassesAssignment_2"
    // InternalArg.g:9960:1: rule__Physic__ClassesAssignment_2 : ( rulePhysicClass ) ;
    public final void rule__Physic__ClassesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9964:1: ( ( rulePhysicClass ) )
            // InternalArg.g:9965:2: ( rulePhysicClass )
            {
            // InternalArg.g:9965:2: ( rulePhysicClass )
            // InternalArg.g:9966:3: rulePhysicClass
            {
             before(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePhysicClass();

            state._fsp--;

             after(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__ClassesAssignment_2"


    // $ANTLR start "rule__Physic__ClassesAssignment_3"
    // InternalArg.g:9975:1: rule__Physic__ClassesAssignment_3 : ( rulePhysicClass ) ;
    public final void rule__Physic__ClassesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9979:1: ( ( rulePhysicClass ) )
            // InternalArg.g:9980:2: ( rulePhysicClass )
            {
            // InternalArg.g:9980:2: ( rulePhysicClass )
            // InternalArg.g:9981:3: rulePhysicClass
            {
             before(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePhysicClass();

            state._fsp--;

             after(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Physic__ClassesAssignment_3"


    // $ANTLR start "rule__Game__StartAssignment_5"
    // InternalArg.g:9990:1: rule__Game__StartAssignment_5 : ( ruleEString ) ;
    public final void rule__Game__StartAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:9994:1: ( ( ruleEString ) )
            // InternalArg.g:9995:2: ( ruleEString )
            {
            // InternalArg.g:9995:2: ( ruleEString )
            // InternalArg.g:9996:3: ruleEString
            {
             before(grammarAccess.getGameAccess().getStartEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGameAccess().getStartEStringParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__StartAssignment_5"


    // $ANTLR start "rule__Game__WinAssignment_7"
    // InternalArg.g:10005:1: rule__Game__WinAssignment_7 : ( ruleEString ) ;
    public final void rule__Game__WinAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10009:1: ( ( ruleEString ) )
            // InternalArg.g:10010:2: ( ruleEString )
            {
            // InternalArg.g:10010:2: ( ruleEString )
            // InternalArg.g:10011:3: ruleEString
            {
             before(grammarAccess.getGameAccess().getWinEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGameAccess().getWinEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__WinAssignment_7"


    // $ANTLR start "rule__Game__LoseAssignment_9"
    // InternalArg.g:10020:1: rule__Game__LoseAssignment_9 : ( ruleEString ) ;
    public final void rule__Game__LoseAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10024:1: ( ( ruleEString ) )
            // InternalArg.g:10025:2: ( ruleEString )
            {
            // InternalArg.g:10025:2: ( ruleEString )
            // InternalArg.g:10026:3: ruleEString
            {
             before(grammarAccess.getGameAccess().getLoseEStringParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGameAccess().getLoseEStringParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__LoseAssignment_9"


    // $ANTLR start "rule__Game__ScoreAssignment_12"
    // InternalArg.g:10035:1: rule__Game__ScoreAssignment_12 : ( ruleScoreSystem ) ;
    public final void rule__Game__ScoreAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10039:1: ( ( ruleScoreSystem ) )
            // InternalArg.g:10040:2: ( ruleScoreSystem )
            {
            // InternalArg.g:10040:2: ( ruleScoreSystem )
            // InternalArg.g:10041:3: ruleScoreSystem
            {
             before(grammarAccess.getGameAccess().getScoreScoreSystemParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleScoreSystem();

            state._fsp--;

             after(grammarAccess.getGameAccess().getScoreScoreSystemParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ScoreAssignment_12"


    // $ANTLR start "rule__Game__ActionsTriggersAssignment_15_2"
    // InternalArg.g:10050:1: rule__Game__ActionsTriggersAssignment_15_2 : ( ruleTrigger ) ;
    public final void rule__Game__ActionsTriggersAssignment_15_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10054:1: ( ( ruleTrigger ) )
            // InternalArg.g:10055:2: ( ruleTrigger )
            {
            // InternalArg.g:10055:2: ( ruleTrigger )
            // InternalArg.g:10056:3: ruleTrigger
            {
             before(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTrigger();

            state._fsp--;

             after(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ActionsTriggersAssignment_15_2"


    // $ANTLR start "rule__Game__ActionsTriggersAssignment_15_3"
    // InternalArg.g:10065:1: rule__Game__ActionsTriggersAssignment_15_3 : ( ruleTrigger ) ;
    public final void rule__Game__ActionsTriggersAssignment_15_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10069:1: ( ( ruleTrigger ) )
            // InternalArg.g:10070:2: ( ruleTrigger )
            {
            // InternalArg.g:10070:2: ( ruleTrigger )
            // InternalArg.g:10071:3: ruleTrigger
            {
             before(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTrigger();

            state._fsp--;

             after(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ActionsTriggersAssignment_15_3"


    // $ANTLR start "rule__Game__CollisionsAssignment_16_2"
    // InternalArg.g:10080:1: rule__Game__CollisionsAssignment_16_2 : ( ruleCollision ) ;
    public final void rule__Game__CollisionsAssignment_16_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10084:1: ( ( ruleCollision ) )
            // InternalArg.g:10085:2: ( ruleCollision )
            {
            // InternalArg.g:10085:2: ( ruleCollision )
            // InternalArg.g:10086:3: ruleCollision
            {
             before(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCollision();

            state._fsp--;

             after(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__CollisionsAssignment_16_2"


    // $ANTLR start "rule__Game__CollisionsAssignment_16_3"
    // InternalArg.g:10095:1: rule__Game__CollisionsAssignment_16_3 : ( ruleCollision ) ;
    public final void rule__Game__CollisionsAssignment_16_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10099:1: ( ( ruleCollision ) )
            // InternalArg.g:10100:2: ( ruleCollision )
            {
            // InternalArg.g:10100:2: ( ruleCollision )
            // InternalArg.g:10101:3: ruleCollision
            {
             before(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCollision();

            state._fsp--;

             after(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__CollisionsAssignment_16_3"


    // $ANTLR start "rule__Game__GamepadAssignment_17_2"
    // InternalArg.g:10110:1: rule__Game__GamepadAssignment_17_2 : ( ruleGamePad ) ;
    public final void rule__Game__GamepadAssignment_17_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10114:1: ( ( ruleGamePad ) )
            // InternalArg.g:10115:2: ( ruleGamePad )
            {
            // InternalArg.g:10115:2: ( ruleGamePad )
            // InternalArg.g:10116:3: ruleGamePad
            {
             before(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGamePad();

            state._fsp--;

             after(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__GamepadAssignment_17_2"


    // $ANTLR start "rule__Game__GamepadAssignment_17_3"
    // InternalArg.g:10125:1: rule__Game__GamepadAssignment_17_3 : ( ruleGamePad ) ;
    public final void rule__Game__GamepadAssignment_17_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10129:1: ( ( ruleGamePad ) )
            // InternalArg.g:10130:2: ( ruleGamePad )
            {
            // InternalArg.g:10130:2: ( ruleGamePad )
            // InternalArg.g:10131:3: ruleGamePad
            {
             before(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGamePad();

            state._fsp--;

             after(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__GamepadAssignment_17_3"


    // $ANTLR start "rule__Game__ObjInitAssignment_18_2"
    // InternalArg.g:10140:1: rule__Game__ObjInitAssignment_18_2 : ( ruleObjInit ) ;
    public final void rule__Game__ObjInitAssignment_18_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10144:1: ( ( ruleObjInit ) )
            // InternalArg.g:10145:2: ( ruleObjInit )
            {
            // InternalArg.g:10145:2: ( ruleObjInit )
            // InternalArg.g:10146:3: ruleObjInit
            {
             before(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_2_0()); 
            pushFollow(FOLLOW_2);
            ruleObjInit();

            state._fsp--;

             after(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ObjInitAssignment_18_2"


    // $ANTLR start "rule__Game__ObjInitAssignment_18_3"
    // InternalArg.g:10155:1: rule__Game__ObjInitAssignment_18_3 : ( ruleObjInit ) ;
    public final void rule__Game__ObjInitAssignment_18_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10159:1: ( ( ruleObjInit ) )
            // InternalArg.g:10160:2: ( ruleObjInit )
            {
            // InternalArg.g:10160:2: ( ruleObjInit )
            // InternalArg.g:10161:3: ruleObjInit
            {
             before(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_3_0()); 
            pushFollow(FOLLOW_2);
            ruleObjInit();

            state._fsp--;

             after(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ObjInitAssignment_18_3"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // InternalArg.g:10170:1: rule__Attribute__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10174:1: ( ( ruleEString ) )
            // InternalArg.g:10175:2: ( ruleEString )
            {
            // InternalArg.g:10175:2: ( ruleEString )
            // InternalArg.g:10176:3: ruleEString
            {
             before(grammarAccess.getAttributeAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__TypeAssignment_2"
    // InternalArg.g:10185:1: rule__Attribute__TypeAssignment_2 : ( ruleEString ) ;
    public final void rule__Attribute__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10189:1: ( ( ruleEString ) )
            // InternalArg.g:10190:2: ( ruleEString )
            {
            // InternalArg.g:10190:2: ( ruleEString )
            // InternalArg.g:10191:3: ruleEString
            {
             before(grammarAccess.getAttributeAccess().getTypeEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getTypeEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__TypeAssignment_2"


    // $ANTLR start "rule__Attribute__MinAssignment_4"
    // InternalArg.g:10200:1: rule__Attribute__MinAssignment_4 : ( ruleEInt ) ;
    public final void rule__Attribute__MinAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10204:1: ( ( ruleEInt ) )
            // InternalArg.g:10205:2: ( ruleEInt )
            {
            // InternalArg.g:10205:2: ( ruleEInt )
            // InternalArg.g:10206:3: ruleEInt
            {
             before(grammarAccess.getAttributeAccess().getMinEIntParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getMinEIntParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__MinAssignment_4"


    // $ANTLR start "rule__Attribute__MaxAssignment_6"
    // InternalArg.g:10215:1: rule__Attribute__MaxAssignment_6 : ( ruleAttributeMax ) ;
    public final void rule__Attribute__MaxAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10219:1: ( ( ruleAttributeMax ) )
            // InternalArg.g:10220:2: ( ruleAttributeMax )
            {
            // InternalArg.g:10220:2: ( ruleAttributeMax )
            // InternalArg.g:10221:3: ruleAttributeMax
            {
             before(grammarAccess.getAttributeAccess().getMaxAttributeMaxParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeMax();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getMaxAttributeMaxParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__MaxAssignment_6"


    // $ANTLR start "rule__Attribute__DefaultAssignment_9"
    // InternalArg.g:10230:1: rule__Attribute__DefaultAssignment_9 : ( ruleConstant ) ;
    public final void rule__Attribute__DefaultAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10234:1: ( ( ruleConstant ) )
            // InternalArg.g:10235:2: ( ruleConstant )
            {
            // InternalArg.g:10235:2: ( ruleConstant )
            // InternalArg.g:10236:3: ruleConstant
            {
             before(grammarAccess.getAttributeAccess().getDefaultConstantParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getDefaultConstantParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__DefaultAssignment_9"


    // $ANTLR start "rule__Attribute__IsParamAssignment_10"
    // InternalArg.g:10245:1: rule__Attribute__IsParamAssignment_10 : ( ( 'isParam' ) ) ;
    public final void rule__Attribute__IsParamAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10249:1: ( ( ( 'isParam' ) ) )
            // InternalArg.g:10250:2: ( ( 'isParam' ) )
            {
            // InternalArg.g:10250:2: ( ( 'isParam' ) )
            // InternalArg.g:10251:3: ( 'isParam' )
            {
             before(grammarAccess.getAttributeAccess().getIsParamIsParamKeyword_10_0()); 
            // InternalArg.g:10252:3: ( 'isParam' )
            // InternalArg.g:10253:4: 'isParam'
            {
             before(grammarAccess.getAttributeAccess().getIsParamIsParamKeyword_10_0()); 
            match(input,118,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getIsParamIsParamKeyword_10_0()); 

            }

             after(grammarAccess.getAttributeAccess().getIsParamIsParamKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__IsParamAssignment_10"


    // $ANTLR start "rule__Attribute__IsKeyAssignment_11"
    // InternalArg.g:10264:1: rule__Attribute__IsKeyAssignment_11 : ( ( 'isKey' ) ) ;
    public final void rule__Attribute__IsKeyAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10268:1: ( ( ( 'isKey' ) ) )
            // InternalArg.g:10269:2: ( ( 'isKey' ) )
            {
            // InternalArg.g:10269:2: ( ( 'isKey' ) )
            // InternalArg.g:10270:3: ( 'isKey' )
            {
             before(grammarAccess.getAttributeAccess().getIsKeyIsKeyKeyword_11_0()); 
            // InternalArg.g:10271:3: ( 'isKey' )
            // InternalArg.g:10272:4: 'isKey'
            {
             before(grammarAccess.getAttributeAccess().getIsKeyIsKeyKeyword_11_0()); 
            match(input,119,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getIsKeyIsKeyKeyword_11_0()); 

            }

             after(grammarAccess.getAttributeAccess().getIsKeyIsKeyKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__IsKeyAssignment_11"


    // $ANTLR start "rule__Attribute__ReadOnlyAssignment_12"
    // InternalArg.g:10283:1: rule__Attribute__ReadOnlyAssignment_12 : ( ( 'readOnly' ) ) ;
    public final void rule__Attribute__ReadOnlyAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10287:1: ( ( ( 'readOnly' ) ) )
            // InternalArg.g:10288:2: ( ( 'readOnly' ) )
            {
            // InternalArg.g:10288:2: ( ( 'readOnly' ) )
            // InternalArg.g:10289:3: ( 'readOnly' )
            {
             before(grammarAccess.getAttributeAccess().getReadOnlyReadOnlyKeyword_12_0()); 
            // InternalArg.g:10290:3: ( 'readOnly' )
            // InternalArg.g:10291:4: 'readOnly'
            {
             before(grammarAccess.getAttributeAccess().getReadOnlyReadOnlyKeyword_12_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getReadOnlyReadOnlyKeyword_12_0()); 

            }

             after(grammarAccess.getAttributeAccess().getReadOnlyReadOnlyKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ReadOnlyAssignment_12"


    // $ANTLR start "rule__Reference__NameAssignment_0"
    // InternalArg.g:10302:1: rule__Reference__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Reference__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10306:1: ( ( ruleEString ) )
            // InternalArg.g:10307:2: ( ruleEString )
            {
            // InternalArg.g:10307:2: ( ruleEString )
            // InternalArg.g:10308:3: ruleEString
            {
             before(grammarAccess.getReferenceAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NameAssignment_0"


    // $ANTLR start "rule__Reference__ContaintmentAssignment_1_1"
    // InternalArg.g:10317:1: rule__Reference__ContaintmentAssignment_1_1 : ( ruleEString ) ;
    public final void rule__Reference__ContaintmentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10321:1: ( ( ruleEString ) )
            // InternalArg.g:10322:2: ( ruleEString )
            {
            // InternalArg.g:10322:2: ( ruleEString )
            // InternalArg.g:10323:3: ruleEString
            {
             before(grammarAccess.getReferenceAccess().getContaintmentEStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getContaintmentEStringParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__ContaintmentAssignment_1_1"


    // $ANTLR start "rule__Reference__MinAssignment_3"
    // InternalArg.g:10332:1: rule__Reference__MinAssignment_3 : ( ruleEInt ) ;
    public final void rule__Reference__MinAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10336:1: ( ( ruleEInt ) )
            // InternalArg.g:10337:2: ( ruleEInt )
            {
            // InternalArg.g:10337:2: ( ruleEInt )
            // InternalArg.g:10338:3: ruleEInt
            {
             before(grammarAccess.getReferenceAccess().getMinEIntParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getMinEIntParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__MinAssignment_3"


    // $ANTLR start "rule__Reference__MaxAssignment_5"
    // InternalArg.g:10347:1: rule__Reference__MaxAssignment_5 : ( ruleEInt ) ;
    public final void rule__Reference__MaxAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10351:1: ( ( ruleEInt ) )
            // InternalArg.g:10352:2: ( ruleEInt )
            {
            // InternalArg.g:10352:2: ( ruleEInt )
            // InternalArg.g:10353:3: ruleEInt
            {
             before(grammarAccess.getReferenceAccess().getMaxEIntParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getMaxEIntParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__MaxAssignment_5"


    // $ANTLR start "rule__Reference__TargetAssignment_7"
    // InternalArg.g:10362:1: rule__Reference__TargetAssignment_7 : ( ruleEString ) ;
    public final void rule__Reference__TargetAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10366:1: ( ( ruleEString ) )
            // InternalArg.g:10367:2: ( ruleEString )
            {
            // InternalArg.g:10367:2: ( ruleEString )
            // InternalArg.g:10368:3: ruleEString
            {
             before(grammarAccess.getReferenceAccess().getTargetEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getTargetEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__TargetAssignment_7"


    // $ANTLR start "rule__Reference__OppositeAssignment_8_1"
    // InternalArg.g:10377:1: rule__Reference__OppositeAssignment_8_1 : ( ruleEString ) ;
    public final void rule__Reference__OppositeAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10381:1: ( ( ruleEString ) )
            // InternalArg.g:10382:2: ( ruleEString )
            {
            // InternalArg.g:10382:2: ( ruleEString )
            // InternalArg.g:10383:3: ruleEString
            {
             before(grammarAccess.getReferenceAccess().getOppositeEStringParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getOppositeEStringParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__OppositeAssignment_8_1"


    // $ANTLR start "rule__GraphicClass__OntoClassAssignment_1"
    // InternalArg.g:10392:1: rule__GraphicClass__OntoClassAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__GraphicClass__OntoClassAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10396:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10397:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10397:2: ( ( ruleEString ) )
            // InternalArg.g:10398:3: ( ruleEString )
            {
             before(grammarAccess.getGraphicClassAccess().getOntoClassClassCrossReference_1_0()); 
            // InternalArg.g:10399:3: ( ruleEString )
            // InternalArg.g:10400:4: ruleEString
            {
             before(grammarAccess.getGraphicClassAccess().getOntoClassClassEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGraphicClassAccess().getOntoClassClassEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getGraphicClassAccess().getOntoClassClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__OntoClassAssignment_1"


    // $ANTLR start "rule__GraphicClass__VersionsAssignment_4"
    // InternalArg.g:10411:1: rule__GraphicClass__VersionsAssignment_4 : ( ruleVersions ) ;
    public final void rule__GraphicClass__VersionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10415:1: ( ( ruleVersions ) )
            // InternalArg.g:10416:2: ( ruleVersions )
            {
            // InternalArg.g:10416:2: ( ruleVersions )
            // InternalArg.g:10417:3: ruleVersions
            {
             before(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVersions();

            state._fsp--;

             after(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__VersionsAssignment_4"


    // $ANTLR start "rule__GraphicClass__VersionsAssignment_5"
    // InternalArg.g:10426:1: rule__GraphicClass__VersionsAssignment_5 : ( ruleVersions ) ;
    public final void rule__GraphicClass__VersionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10430:1: ( ( ruleVersions ) )
            // InternalArg.g:10431:2: ( ruleVersions )
            {
            // InternalArg.g:10431:2: ( ruleVersions )
            // InternalArg.g:10432:3: ruleVersions
            {
             before(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleVersions();

            state._fsp--;

             after(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__VersionsAssignment_5"


    // $ANTLR start "rule__GraphicClass__ConstraintsAssignment_9"
    // InternalArg.g:10441:1: rule__GraphicClass__ConstraintsAssignment_9 : ( ruleConstraints ) ;
    public final void rule__GraphicClass__ConstraintsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10445:1: ( ( ruleConstraints ) )
            // InternalArg.g:10446:2: ( ruleConstraints )
            {
            // InternalArg.g:10446:2: ( ruleConstraints )
            // InternalArg.g:10447:3: ruleConstraints
            {
             before(grammarAccess.getGraphicClassAccess().getConstraintsConstraintsParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraints();

            state._fsp--;

             after(grammarAccess.getGraphicClassAccess().getConstraintsConstraintsParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicClass__ConstraintsAssignment_9"


    // $ANTLR start "rule__Constraints__PlanesAssignment_1"
    // InternalArg.g:10456:1: rule__Constraints__PlanesAssignment_1 : ( rulePlanes ) ;
    public final void rule__Constraints__PlanesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10460:1: ( ( rulePlanes ) )
            // InternalArg.g:10461:2: ( rulePlanes )
            {
            // InternalArg.g:10461:2: ( rulePlanes )
            // InternalArg.g:10462:3: rulePlanes
            {
             before(grammarAccess.getConstraintsAccess().getPlanesPlanesEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePlanes();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getPlanesPlanesEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__PlanesAssignment_1"


    // $ANTLR start "rule__Constraints__OverlappingAssignment_2"
    // InternalArg.g:10471:1: rule__Constraints__OverlappingAssignment_2 : ( ( 'overlaps' ) ) ;
    public final void rule__Constraints__OverlappingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10475:1: ( ( ( 'overlaps' ) ) )
            // InternalArg.g:10476:2: ( ( 'overlaps' ) )
            {
            // InternalArg.g:10476:2: ( ( 'overlaps' ) )
            // InternalArg.g:10477:3: ( 'overlaps' )
            {
             before(grammarAccess.getConstraintsAccess().getOverlappingOverlapsKeyword_2_0()); 
            // InternalArg.g:10478:3: ( 'overlaps' )
            // InternalArg.g:10479:4: 'overlaps'
            {
             before(grammarAccess.getConstraintsAccess().getOverlappingOverlapsKeyword_2_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getConstraintsAccess().getOverlappingOverlapsKeyword_2_0()); 

            }

             after(grammarAccess.getConstraintsAccess().getOverlappingOverlapsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__OverlappingAssignment_2"


    // $ANTLR start "rule__Constraints__SizeMinAssignment_4"
    // InternalArg.g:10490:1: rule__Constraints__SizeMinAssignment_4 : ( ruleEDouble ) ;
    public final void rule__Constraints__SizeMinAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10494:1: ( ( ruleEDouble ) )
            // InternalArg.g:10495:2: ( ruleEDouble )
            {
            // InternalArg.g:10495:2: ( ruleEDouble )
            // InternalArg.g:10496:3: ruleEDouble
            {
             before(grammarAccess.getConstraintsAccess().getSizeMinEDoubleParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getSizeMinEDoubleParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__SizeMinAssignment_4"


    // $ANTLR start "rule__Constraints__SizeMaxAssignment_6"
    // InternalArg.g:10505:1: rule__Constraints__SizeMaxAssignment_6 : ( ruleEDouble ) ;
    public final void rule__Constraints__SizeMaxAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10509:1: ( ( ruleEDouble ) )
            // InternalArg.g:10510:2: ( ruleEDouble )
            {
            // InternalArg.g:10510:2: ( ruleEDouble )
            // InternalArg.g:10511:3: ruleEDouble
            {
             before(grammarAccess.getConstraintsAccess().getSizeMaxEDoubleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getSizeMaxEDoubleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__SizeMaxAssignment_6"


    // $ANTLR start "rule__Constraints__XToOriginPosAssignment_8"
    // InternalArg.g:10520:1: rule__Constraints__XToOriginPosAssignment_8 : ( ruleEDouble ) ;
    public final void rule__Constraints__XToOriginPosAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10524:1: ( ( ruleEDouble ) )
            // InternalArg.g:10525:2: ( ruleEDouble )
            {
            // InternalArg.g:10525:2: ( ruleEDouble )
            // InternalArg.g:10526:3: ruleEDouble
            {
             before(grammarAccess.getConstraintsAccess().getXToOriginPosEDoubleParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getXToOriginPosEDoubleParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__XToOriginPosAssignment_8"


    // $ANTLR start "rule__Constraints__YToOriginPosAssignment_10"
    // InternalArg.g:10535:1: rule__Constraints__YToOriginPosAssignment_10 : ( ruleEDouble ) ;
    public final void rule__Constraints__YToOriginPosAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10539:1: ( ( ruleEDouble ) )
            // InternalArg.g:10540:2: ( ruleEDouble )
            {
            // InternalArg.g:10540:2: ( ruleEDouble )
            // InternalArg.g:10541:3: ruleEDouble
            {
             before(grammarAccess.getConstraintsAccess().getYToOriginPosEDoubleParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getYToOriginPosEDoubleParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__YToOriginPosAssignment_10"


    // $ANTLR start "rule__Constraints__ZToOriginPosAssignment_12"
    // InternalArg.g:10550:1: rule__Constraints__ZToOriginPosAssignment_12 : ( ruleEDouble ) ;
    public final void rule__Constraints__ZToOriginPosAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10554:1: ( ( ruleEDouble ) )
            // InternalArg.g:10555:2: ( ruleEDouble )
            {
            // InternalArg.g:10555:2: ( ruleEDouble )
            // InternalArg.g:10556:3: ruleEDouble
            {
             before(grammarAccess.getConstraintsAccess().getZToOriginPosEDoubleParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getZToOriginPosEDoubleParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__ZToOriginPosAssignment_12"


    // $ANTLR start "rule__Constraints__RotationAssignment_14"
    // InternalArg.g:10565:1: rule__Constraints__RotationAssignment_14 : ( ruleEInt ) ;
    public final void rule__Constraints__RotationAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10569:1: ( ( ruleEInt ) )
            // InternalArg.g:10570:2: ( ruleEInt )
            {
            // InternalArg.g:10570:2: ( ruleEInt )
            // InternalArg.g:10571:3: ruleEInt
            {
             before(grammarAccess.getConstraintsAccess().getRotationEIntParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getConstraintsAccess().getRotationEIntParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraints__RotationAssignment_14"


    // $ANTLR start "rule__Versions__NameAssignment_0"
    // InternalArg.g:10580:1: rule__Versions__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Versions__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10584:1: ( ( ruleEString ) )
            // InternalArg.g:10585:2: ( ruleEString )
            {
            // InternalArg.g:10585:2: ( ruleEString )
            // InternalArg.g:10586:3: ruleEString
            {
             before(grammarAccess.getVersionsAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getVersionsAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__NameAssignment_0"


    // $ANTLR start "rule__Versions__URLAssignment_2"
    // InternalArg.g:10595:1: rule__Versions__URLAssignment_2 : ( ruleEString ) ;
    public final void rule__Versions__URLAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10599:1: ( ( ruleEString ) )
            // InternalArg.g:10600:2: ( ruleEString )
            {
            // InternalArg.g:10600:2: ( ruleEString )
            // InternalArg.g:10601:3: ruleEString
            {
             before(grammarAccess.getVersionsAccess().getURLEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getVersionsAccess().getURLEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Versions__URLAssignment_2"


    // $ANTLR start "rule__PhysicClass__OntoClassAssignment_1"
    // InternalArg.g:10610:1: rule__PhysicClass__OntoClassAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__PhysicClass__OntoClassAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10614:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10615:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10615:2: ( ( ruleEString ) )
            // InternalArg.g:10616:3: ( ruleEString )
            {
             before(grammarAccess.getPhysicClassAccess().getOntoClassClassCrossReference_1_0()); 
            // InternalArg.g:10617:3: ( ruleEString )
            // InternalArg.g:10618:4: ruleEString
            {
             before(grammarAccess.getPhysicClassAccess().getOntoClassClassEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhysicClassAccess().getOntoClassClassEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPhysicClassAccess().getOntoClassClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__OntoClassAssignment_1"


    // $ANTLR start "rule__PhysicClass__PhysicBodyAssignment_4"
    // InternalArg.g:10629:1: rule__PhysicClass__PhysicBodyAssignment_4 : ( rulePhysicBody ) ;
    public final void rule__PhysicClass__PhysicBodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10633:1: ( ( rulePhysicBody ) )
            // InternalArg.g:10634:2: ( rulePhysicBody )
            {
            // InternalArg.g:10634:2: ( rulePhysicBody )
            // InternalArg.g:10635:3: rulePhysicBody
            {
             before(grammarAccess.getPhysicClassAccess().getPhysicBodyPhysicBodyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            rulePhysicBody();

            state._fsp--;

             after(grammarAccess.getPhysicClassAccess().getPhysicBodyPhysicBodyParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__PhysicBodyAssignment_4"


    // $ANTLR start "rule__PhysicClass__ForcesAssignment_6_2"
    // InternalArg.g:10644:1: rule__PhysicClass__ForcesAssignment_6_2 : ( ruleForce ) ;
    public final void rule__PhysicClass__ForcesAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10648:1: ( ( ruleForce ) )
            // InternalArg.g:10649:2: ( ruleForce )
            {
            // InternalArg.g:10649:2: ( ruleForce )
            // InternalArg.g:10650:3: ruleForce
            {
             before(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleForce();

            state._fsp--;

             after(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__ForcesAssignment_6_2"


    // $ANTLR start "rule__PhysicClass__ForcesAssignment_6_3"
    // InternalArg.g:10659:1: rule__PhysicClass__ForcesAssignment_6_3 : ( ruleForce ) ;
    public final void rule__PhysicClass__ForcesAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10663:1: ( ( ruleForce ) )
            // InternalArg.g:10664:2: ( ruleForce )
            {
            // InternalArg.g:10664:2: ( ruleForce )
            // InternalArg.g:10665:3: ruleForce
            {
             before(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_3_0()); 
            pushFollow(FOLLOW_2);
            ruleForce();

            state._fsp--;

             after(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__ForcesAssignment_6_3"


    // $ANTLR start "rule__PhysicClass__BitMasksAssignment_7_2"
    // InternalArg.g:10674:1: rule__PhysicClass__BitMasksAssignment_7_2 : ( ruleBitMasks ) ;
    public final void rule__PhysicClass__BitMasksAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10678:1: ( ( ruleBitMasks ) )
            // InternalArg.g:10679:2: ( ruleBitMasks )
            {
            // InternalArg.g:10679:2: ( ruleBitMasks )
            // InternalArg.g:10680:3: ruleBitMasks
            {
             before(grammarAccess.getPhysicClassAccess().getBitMasksBitMasksParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBitMasks();

            state._fsp--;

             after(grammarAccess.getPhysicClassAccess().getBitMasksBitMasksParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicClass__BitMasksAssignment_7_2"


    // $ANTLR start "rule__PhysicBody__MassAssignment_1"
    // InternalArg.g:10689:1: rule__PhysicBody__MassAssignment_1 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__MassAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10693:1: ( ( ruleEDouble ) )
            // InternalArg.g:10694:2: ( ruleEDouble )
            {
            // InternalArg.g:10694:2: ( ruleEDouble )
            // InternalArg.g:10695:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getMassEDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getMassEDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__MassAssignment_1"


    // $ANTLR start "rule__PhysicBody__BodyTypeAssignment_3"
    // InternalArg.g:10704:1: rule__PhysicBody__BodyTypeAssignment_3 : ( ruleBodyType ) ;
    public final void rule__PhysicBody__BodyTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10708:1: ( ( ruleBodyType ) )
            // InternalArg.g:10709:2: ( ruleBodyType )
            {
            // InternalArg.g:10709:2: ( ruleBodyType )
            // InternalArg.g:10710:3: ruleBodyType
            {
             before(grammarAccess.getPhysicBodyAccess().getBodyTypeBodyTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleBodyType();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getBodyTypeBodyTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__BodyTypeAssignment_3"


    // $ANTLR start "rule__PhysicBody__ChargeAssignment_5"
    // InternalArg.g:10719:1: rule__PhysicBody__ChargeAssignment_5 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__ChargeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10723:1: ( ( ruleEDouble ) )
            // InternalArg.g:10724:2: ( ruleEDouble )
            {
            // InternalArg.g:10724:2: ( ruleEDouble )
            // InternalArg.g:10725:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getChargeEDoubleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getChargeEDoubleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__ChargeAssignment_5"


    // $ANTLR start "rule__PhysicBody__FrictionAssignment_7"
    // InternalArg.g:10734:1: rule__PhysicBody__FrictionAssignment_7 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__FrictionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10738:1: ( ( ruleEDouble ) )
            // InternalArg.g:10739:2: ( ruleEDouble )
            {
            // InternalArg.g:10739:2: ( ruleEDouble )
            // InternalArg.g:10740:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getFrictionEDoubleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getFrictionEDoubleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__FrictionAssignment_7"


    // $ANTLR start "rule__PhysicBody__RollingFrictionAssignment_9"
    // InternalArg.g:10749:1: rule__PhysicBody__RollingFrictionAssignment_9 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__RollingFrictionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10753:1: ( ( ruleEDouble ) )
            // InternalArg.g:10754:2: ( ruleEDouble )
            {
            // InternalArg.g:10754:2: ( ruleEDouble )
            // InternalArg.g:10755:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getRollingFrictionEDoubleParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getRollingFrictionEDoubleParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__RollingFrictionAssignment_9"


    // $ANTLR start "rule__PhysicBody__RestitutionAssignment_11"
    // InternalArg.g:10764:1: rule__PhysicBody__RestitutionAssignment_11 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__RestitutionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10768:1: ( ( ruleEDouble ) )
            // InternalArg.g:10769:2: ( ruleEDouble )
            {
            // InternalArg.g:10769:2: ( ruleEDouble )
            // InternalArg.g:10770:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getRestitutionEDoubleParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getRestitutionEDoubleParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__RestitutionAssignment_11"


    // $ANTLR start "rule__PhysicBody__DampingAssignment_13"
    // InternalArg.g:10779:1: rule__PhysicBody__DampingAssignment_13 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__DampingAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10783:1: ( ( ruleEDouble ) )
            // InternalArg.g:10784:2: ( ruleEDouble )
            {
            // InternalArg.g:10784:2: ( ruleEDouble )
            // InternalArg.g:10785:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getDampingEDoubleParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getDampingEDoubleParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__DampingAssignment_13"


    // $ANTLR start "rule__PhysicBody__AngularDampingAssignment_15"
    // InternalArg.g:10794:1: rule__PhysicBody__AngularDampingAssignment_15 : ( ruleEDouble ) ;
    public final void rule__PhysicBody__AngularDampingAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10798:1: ( ( ruleEDouble ) )
            // InternalArg.g:10799:2: ( ruleEDouble )
            {
            // InternalArg.g:10799:2: ( ruleEDouble )
            // InternalArg.g:10800:3: ruleEDouble
            {
             before(grammarAccess.getPhysicBodyAccess().getAngularDampingEDoubleParserRuleCall_15_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicBodyAccess().getAngularDampingEDoubleParserRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicBody__AngularDampingAssignment_15"


    // $ANTLR start "rule__BitMasks__CollisionAssignment_1"
    // InternalArg.g:10809:1: rule__BitMasks__CollisionAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__BitMasks__CollisionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10813:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10814:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10814:2: ( ( ruleEString ) )
            // InternalArg.g:10815:3: ( ruleEString )
            {
             before(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_1_0()); 
            // InternalArg.g:10816:3: ( ruleEString )
            // InternalArg.g:10817:4: ruleEString
            {
             before(grammarAccess.getBitMasksAccess().getCollisionClassEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBitMasksAccess().getCollisionClassEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__CollisionAssignment_1"


    // $ANTLR start "rule__BitMasks__CollisionAssignment_2"
    // InternalArg.g:10828:1: rule__BitMasks__CollisionAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__BitMasks__CollisionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10832:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10833:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10833:2: ( ( ruleEString ) )
            // InternalArg.g:10834:3: ( ruleEString )
            {
             before(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_2_0()); 
            // InternalArg.g:10835:3: ( ruleEString )
            // InternalArg.g:10836:4: ruleEString
            {
             before(grammarAccess.getBitMasksAccess().getCollisionClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBitMasksAccess().getCollisionClassEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__CollisionAssignment_2"


    // $ANTLR start "rule__BitMasks__ContactAssignment_4"
    // InternalArg.g:10847:1: rule__BitMasks__ContactAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__BitMasks__ContactAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10851:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10852:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10852:2: ( ( ruleEString ) )
            // InternalArg.g:10853:3: ( ruleEString )
            {
             before(grammarAccess.getBitMasksAccess().getContactClassCrossReference_4_0()); 
            // InternalArg.g:10854:3: ( ruleEString )
            // InternalArg.g:10855:4: ruleEString
            {
             before(grammarAccess.getBitMasksAccess().getContactClassEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBitMasksAccess().getContactClassEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getBitMasksAccess().getContactClassCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__ContactAssignment_4"


    // $ANTLR start "rule__BitMasks__ContactAssignment_5"
    // InternalArg.g:10866:1: rule__BitMasks__ContactAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__BitMasks__ContactAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10870:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10871:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10871:2: ( ( ruleEString ) )
            // InternalArg.g:10872:3: ( ruleEString )
            {
             before(grammarAccess.getBitMasksAccess().getContactClassCrossReference_5_0()); 
            // InternalArg.g:10873:3: ( ruleEString )
            // InternalArg.g:10874:4: ruleEString
            {
             before(grammarAccess.getBitMasksAccess().getContactClassEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBitMasksAccess().getContactClassEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getBitMasksAccess().getContactClassCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitMasks__ContactAssignment_5"


    // $ANTLR start "rule__Force__NameAssignment_0"
    // InternalArg.g:10885:1: rule__Force__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Force__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10889:1: ( ( ruleEString ) )
            // InternalArg.g:10890:2: ( ruleEString )
            {
            // InternalArg.g:10890:2: ( ruleEString )
            // InternalArg.g:10891:3: ruleEString
            {
             before(grammarAccess.getForceAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getForceAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__NameAssignment_0"


    // $ANTLR start "rule__Force__GestureAssignment_3"
    // InternalArg.g:10900:1: rule__Force__GestureAssignment_3 : ( ruleGesture ) ;
    public final void rule__Force__GestureAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10904:1: ( ( ruleGesture ) )
            // InternalArg.g:10905:2: ( ruleGesture )
            {
            // InternalArg.g:10905:2: ( ruleGesture )
            // InternalArg.g:10906:3: ruleGesture
            {
             before(grammarAccess.getForceAccess().getGestureGestureEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGesture();

            state._fsp--;

             after(grammarAccess.getForceAccess().getGestureGestureEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__GestureAssignment_3"


    // $ANTLR start "rule__Force__XVectorAssignment_4_1"
    // InternalArg.g:10915:1: rule__Force__XVectorAssignment_4_1 : ( ruleEDouble ) ;
    public final void rule__Force__XVectorAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10919:1: ( ( ruleEDouble ) )
            // InternalArg.g:10920:2: ( ruleEDouble )
            {
            // InternalArg.g:10920:2: ( ruleEDouble )
            // InternalArg.g:10921:3: ruleEDouble
            {
             before(grammarAccess.getForceAccess().getXVectorEDoubleParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getForceAccess().getXVectorEDoubleParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__XVectorAssignment_4_1"


    // $ANTLR start "rule__Force__YVectorAssignment_4_3"
    // InternalArg.g:10930:1: rule__Force__YVectorAssignment_4_3 : ( ruleEDouble ) ;
    public final void rule__Force__YVectorAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10934:1: ( ( ruleEDouble ) )
            // InternalArg.g:10935:2: ( ruleEDouble )
            {
            // InternalArg.g:10935:2: ( ruleEDouble )
            // InternalArg.g:10936:3: ruleEDouble
            {
             before(grammarAccess.getForceAccess().getYVectorEDoubleParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getForceAccess().getYVectorEDoubleParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__YVectorAssignment_4_3"


    // $ANTLR start "rule__Force__ZVectorAssignment_4_5"
    // InternalArg.g:10945:1: rule__Force__ZVectorAssignment_4_5 : ( ruleEDouble ) ;
    public final void rule__Force__ZVectorAssignment_4_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10949:1: ( ( ruleEDouble ) )
            // InternalArg.g:10950:2: ( ruleEDouble )
            {
            // InternalArg.g:10950:2: ( ruleEDouble )
            // InternalArg.g:10951:3: ruleEDouble
            {
             before(grammarAccess.getForceAccess().getZVectorEDoubleParserRuleCall_4_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getForceAccess().getZVectorEDoubleParserRuleCall_4_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Force__ZVectorAssignment_4_5"


    // $ANTLR start "rule__GamePad__NameAssignment_0"
    // InternalArg.g:10960:1: rule__GamePad__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__GamePad__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10964:1: ( ( ruleEString ) )
            // InternalArg.g:10965:2: ( ruleEString )
            {
            // InternalArg.g:10965:2: ( ruleEString )
            // InternalArg.g:10966:3: ruleEString
            {
             before(grammarAccess.getGamePadAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGamePadAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__NameAssignment_0"


    // $ANTLR start "rule__GamePad__TriggerAssignment_2"
    // InternalArg.g:10975:1: rule__GamePad__TriggerAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__GamePad__TriggerAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10979:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:10980:2: ( ( ruleEString ) )
            {
            // InternalArg.g:10980:2: ( ( ruleEString ) )
            // InternalArg.g:10981:3: ( ruleEString )
            {
             before(grammarAccess.getGamePadAccess().getTriggerTriggerCrossReference_2_0()); 
            // InternalArg.g:10982:3: ( ruleEString )
            // InternalArg.g:10983:4: ruleEString
            {
             before(grammarAccess.getGamePadAccess().getTriggerTriggerEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGamePadAccess().getTriggerTriggerEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGamePadAccess().getTriggerTriggerCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GamePad__TriggerAssignment_2"


    // $ANTLR start "rule__ScoreSystem__StartAssignment_1"
    // InternalArg.g:10994:1: rule__ScoreSystem__StartAssignment_1 : ( ruleEInt ) ;
    public final void rule__ScoreSystem__StartAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:10998:1: ( ( ruleEInt ) )
            // InternalArg.g:10999:2: ( ruleEInt )
            {
            // InternalArg.g:10999:2: ( ruleEInt )
            // InternalArg.g:11000:3: ruleEInt
            {
             before(grammarAccess.getScoreSystemAccess().getStartEIntParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getScoreSystemAccess().getStartEIntParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__StartAssignment_1"


    // $ANTLR start "rule__ScoreSystem__FinishAssignment_3"
    // InternalArg.g:11009:1: rule__ScoreSystem__FinishAssignment_3 : ( ruleNoLimit ) ;
    public final void rule__ScoreSystem__FinishAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11013:1: ( ( ruleNoLimit ) )
            // InternalArg.g:11014:2: ( ruleNoLimit )
            {
            // InternalArg.g:11014:2: ( ruleNoLimit )
            // InternalArg.g:11015:3: ruleNoLimit
            {
             before(grammarAccess.getScoreSystemAccess().getFinishNoLimitParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleNoLimit();

            state._fsp--;

             after(grammarAccess.getScoreSystemAccess().getFinishNoLimitParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__FinishAssignment_3"


    // $ANTLR start "rule__ScoreSystem__LivesAssignment_5"
    // InternalArg.g:11024:1: rule__ScoreSystem__LivesAssignment_5 : ( ruleEInt ) ;
    public final void rule__ScoreSystem__LivesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11028:1: ( ( ruleEInt ) )
            // InternalArg.g:11029:2: ( ruleEInt )
            {
            // InternalArg.g:11029:2: ( ruleEInt )
            // InternalArg.g:11030:3: ruleEInt
            {
             before(grammarAccess.getScoreSystemAccess().getLivesEIntParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getScoreSystemAccess().getLivesEIntParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScoreSystem__LivesAssignment_5"


    // $ANTLR start "rule__Trigger__NameAssignment_0"
    // InternalArg.g:11039:1: rule__Trigger__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Trigger__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11043:1: ( ( ruleEString ) )
            // InternalArg.g:11044:2: ( ruleEString )
            {
            // InternalArg.g:11044:2: ( ruleEString )
            // InternalArg.g:11045:3: ruleEString
            {
             before(grammarAccess.getTriggerAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__NameAssignment_0"


    // $ANTLR start "rule__Trigger__ActionAssignment_2_1"
    // InternalArg.g:11054:1: rule__Trigger__ActionAssignment_2_1 : ( ruleBasicActions ) ;
    public final void rule__Trigger__ActionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11058:1: ( ( ruleBasicActions ) )
            // InternalArg.g:11059:2: ( ruleBasicActions )
            {
            // InternalArg.g:11059:2: ( ruleBasicActions )
            // InternalArg.g:11060:3: ruleBasicActions
            {
             before(grammarAccess.getTriggerAccess().getActionBasicActionsEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBasicActions();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getActionBasicActionsEnumRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__ActionAssignment_2_1"


    // $ANTLR start "rule__Trigger__MessageAssignment_3_1"
    // InternalArg.g:11069:1: rule__Trigger__MessageAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Trigger__MessageAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11073:1: ( ( ruleEString ) )
            // InternalArg.g:11074:2: ( ruleEString )
            {
            // InternalArg.g:11074:2: ( ruleEString )
            // InternalArg.g:11075:3: ruleEString
            {
             before(grammarAccess.getTriggerAccess().getMessageEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getMessageEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__MessageAssignment_3_1"


    // $ANTLR start "rule__Trigger__ScoreChangeAssignment_4_1"
    // InternalArg.g:11084:1: rule__Trigger__ScoreChangeAssignment_4_1 : ( ruleEInt ) ;
    public final void rule__Trigger__ScoreChangeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11088:1: ( ( ruleEInt ) )
            // InternalArg.g:11089:2: ( ruleEInt )
            {
            // InternalArg.g:11089:2: ( ruleEInt )
            // InternalArg.g:11090:3: ruleEInt
            {
             before(grammarAccess.getTriggerAccess().getScoreChangeEIntParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getScoreChangeEIntParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__ScoreChangeAssignment_4_1"


    // $ANTLR start "rule__Trigger__TimeTriggerAssignment_5_1"
    // InternalArg.g:11099:1: rule__Trigger__TimeTriggerAssignment_5_1 : ( ruleEInt ) ;
    public final void rule__Trigger__TimeTriggerAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11103:1: ( ( ruleEInt ) )
            // InternalArg.g:11104:2: ( ruleEInt )
            {
            // InternalArg.g:11104:2: ( ruleEInt )
            // InternalArg.g:11105:3: ruleEInt
            {
             before(grammarAccess.getTriggerAccess().getTimeTriggerEIntParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getTimeTriggerEIntParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__TimeTriggerAssignment_5_1"


    // $ANTLR start "rule__Trigger__PhysicChangesAssignment_6_2"
    // InternalArg.g:11114:1: rule__Trigger__PhysicChangesAssignment_6_2 : ( rulePhysicChange ) ;
    public final void rule__Trigger__PhysicChangesAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11118:1: ( ( rulePhysicChange ) )
            // InternalArg.g:11119:2: ( rulePhysicChange )
            {
            // InternalArg.g:11119:2: ( rulePhysicChange )
            // InternalArg.g:11120:3: rulePhysicChange
            {
             before(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            rulePhysicChange();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__PhysicChangesAssignment_6_2"


    // $ANTLR start "rule__Trigger__PhysicChangesAssignment_6_3"
    // InternalArg.g:11129:1: rule__Trigger__PhysicChangesAssignment_6_3 : ( rulePhysicChange ) ;
    public final void rule__Trigger__PhysicChangesAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11133:1: ( ( rulePhysicChange ) )
            // InternalArg.g:11134:2: ( rulePhysicChange )
            {
            // InternalArg.g:11134:2: ( rulePhysicChange )
            // InternalArg.g:11135:3: rulePhysicChange
            {
             before(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_3_0()); 
            pushFollow(FOLLOW_2);
            rulePhysicChange();

            state._fsp--;

             after(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trigger__PhysicChangesAssignment_6_3"


    // $ANTLR start "rule__Collision__ClassAAssignment_1"
    // InternalArg.g:11144:1: rule__Collision__ClassAAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Collision__ClassAAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11148:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11149:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11149:2: ( ( ruleEString ) )
            // InternalArg.g:11150:3: ( ruleEString )
            {
             before(grammarAccess.getCollisionAccess().getClassAClassCrossReference_1_0()); 
            // InternalArg.g:11151:3: ( ruleEString )
            // InternalArg.g:11152:4: ruleEString
            {
             before(grammarAccess.getCollisionAccess().getClassAClassEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCollisionAccess().getClassAClassEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getCollisionAccess().getClassAClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__ClassAAssignment_1"


    // $ANTLR start "rule__Collision__ClassBAssignment_3"
    // InternalArg.g:11163:1: rule__Collision__ClassBAssignment_3 : ( ( ruleEString ) ) ;
    public final void rule__Collision__ClassBAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11167:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11168:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11168:2: ( ( ruleEString ) )
            // InternalArg.g:11169:3: ( ruleEString )
            {
             before(grammarAccess.getCollisionAccess().getClassBClassCrossReference_3_0()); 
            // InternalArg.g:11170:3: ( ruleEString )
            // InternalArg.g:11171:4: ruleEString
            {
             before(grammarAccess.getCollisionAccess().getClassBClassEStringParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCollisionAccess().getClassBClassEStringParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getCollisionAccess().getClassBClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__ClassBAssignment_3"


    // $ANTLR start "rule__Collision__ActionAssignment_5"
    // InternalArg.g:11182:1: rule__Collision__ActionAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Collision__ActionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11186:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11187:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11187:2: ( ( ruleEString ) )
            // InternalArg.g:11188:3: ( ruleEString )
            {
             before(grammarAccess.getCollisionAccess().getActionTriggerCrossReference_5_0()); 
            // InternalArg.g:11189:3: ( ruleEString )
            // InternalArg.g:11190:4: ruleEString
            {
             before(grammarAccess.getCollisionAccess().getActionTriggerEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCollisionAccess().getActionTriggerEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getCollisionAccess().getActionTriggerCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collision__ActionAssignment_5"


    // $ANTLR start "rule__ObjInit__NameAssignment_0"
    // InternalArg.g:11201:1: rule__ObjInit__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__ObjInit__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11205:1: ( ( ruleEString ) )
            // InternalArg.g:11206:2: ( ruleEString )
            {
            // InternalArg.g:11206:2: ( ruleEString )
            // InternalArg.g:11207:3: ruleEString
            {
             before(grammarAccess.getObjInitAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__NameAssignment_0"


    // $ANTLR start "rule__ObjInit__ClassAssignment_2"
    // InternalArg.g:11216:1: rule__ObjInit__ClassAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__ObjInit__ClassAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11220:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11221:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11221:2: ( ( ruleEString ) )
            // InternalArg.g:11222:3: ( ruleEString )
            {
             before(grammarAccess.getObjInitAccess().getClassClassCrossReference_2_0()); 
            // InternalArg.g:11223:3: ( ruleEString )
            // InternalArg.g:11224:4: ruleEString
            {
             before(grammarAccess.getObjInitAccess().getClassClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getClassClassEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getObjInitAccess().getClassClassCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__ClassAssignment_2"


    // $ANTLR start "rule__ObjInit__PosXAssignment_4"
    // InternalArg.g:11235:1: rule__ObjInit__PosXAssignment_4 : ( rulePosOrCamera ) ;
    public final void rule__ObjInit__PosXAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11239:1: ( ( rulePosOrCamera ) )
            // InternalArg.g:11240:2: ( rulePosOrCamera )
            {
            // InternalArg.g:11240:2: ( rulePosOrCamera )
            // InternalArg.g:11241:3: rulePosOrCamera
            {
             before(grammarAccess.getObjInitAccess().getPosXPosOrCameraParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            rulePosOrCamera();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getPosXPosOrCameraParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__PosXAssignment_4"


    // $ANTLR start "rule__ObjInit__PosYAssignment_6"
    // InternalArg.g:11250:1: rule__ObjInit__PosYAssignment_6 : ( rulePosOrCamera ) ;
    public final void rule__ObjInit__PosYAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11254:1: ( ( rulePosOrCamera ) )
            // InternalArg.g:11255:2: ( rulePosOrCamera )
            {
            // InternalArg.g:11255:2: ( rulePosOrCamera )
            // InternalArg.g:11256:3: rulePosOrCamera
            {
             before(grammarAccess.getObjInitAccess().getPosYPosOrCameraParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePosOrCamera();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getPosYPosOrCameraParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__PosYAssignment_6"


    // $ANTLR start "rule__ObjInit__PosZAssignment_8"
    // InternalArg.g:11265:1: rule__ObjInit__PosZAssignment_8 : ( rulePosOrCamera ) ;
    public final void rule__ObjInit__PosZAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11269:1: ( ( rulePosOrCamera ) )
            // InternalArg.g:11270:2: ( rulePosOrCamera )
            {
            // InternalArg.g:11270:2: ( rulePosOrCamera )
            // InternalArg.g:11271:3: rulePosOrCamera
            {
             before(grammarAccess.getObjInitAccess().getPosZPosOrCameraParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            rulePosOrCamera();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getPosZPosOrCameraParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__PosZAssignment_8"


    // $ANTLR start "rule__ObjInit__RotationAssignment_9_1"
    // InternalArg.g:11280:1: rule__ObjInit__RotationAssignment_9_1 : ( ruleEInt ) ;
    public final void rule__ObjInit__RotationAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11284:1: ( ( ruleEInt ) )
            // InternalArg.g:11285:2: ( ruleEInt )
            {
            // InternalArg.g:11285:2: ( ruleEInt )
            // InternalArg.g:11286:3: ruleEInt
            {
             before(grammarAccess.getObjInitAccess().getRotationEIntParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getRotationEIntParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__RotationAssignment_9_1"


    // $ANTLR start "rule__ObjInit__AttributeAssignment_11_2"
    // InternalArg.g:11295:1: rule__ObjInit__AttributeAssignment_11_2 : ( ruleObjAttribute ) ;
    public final void rule__ObjInit__AttributeAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11299:1: ( ( ruleObjAttribute ) )
            // InternalArg.g:11300:2: ( ruleObjAttribute )
            {
            // InternalArg.g:11300:2: ( ruleObjAttribute )
            // InternalArg.g:11301:3: ruleObjAttribute
            {
             before(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleObjAttribute();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__AttributeAssignment_11_2"


    // $ANTLR start "rule__ObjInit__AttributeAssignment_11_3_1"
    // InternalArg.g:11310:1: rule__ObjInit__AttributeAssignment_11_3_1 : ( ruleObjAttribute ) ;
    public final void rule__ObjInit__AttributeAssignment_11_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11314:1: ( ( ruleObjAttribute ) )
            // InternalArg.g:11315:2: ( ruleObjAttribute )
            {
            // InternalArg.g:11315:2: ( ruleObjAttribute )
            // InternalArg.g:11316:3: ruleObjAttribute
            {
             before(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleObjAttribute();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__AttributeAssignment_11_3_1"


    // $ANTLR start "rule__ObjInit__RulesAssignment_12_2"
    // InternalArg.g:11325:1: rule__ObjInit__RulesAssignment_12_2 : ( ruleRule ) ;
    public final void rule__ObjInit__RulesAssignment_12_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11329:1: ( ( ruleRule ) )
            // InternalArg.g:11330:2: ( ruleRule )
            {
            // InternalArg.g:11330:2: ( ruleRule )
            // InternalArg.g:11331:3: ruleRule
            {
             before(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__RulesAssignment_12_2"


    // $ANTLR start "rule__ObjInit__RulesAssignment_12_3_1"
    // InternalArg.g:11340:1: rule__ObjInit__RulesAssignment_12_3_1 : ( ruleRule ) ;
    public final void rule__ObjInit__RulesAssignment_12_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11344:1: ( ( ruleRule ) )
            // InternalArg.g:11345:2: ( ruleRule )
            {
            // InternalArg.g:11345:2: ( ruleRule )
            // InternalArg.g:11346:3: ruleRule
            {
             before(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjInit__RulesAssignment_12_3_1"


    // $ANTLR start "rule__PhysicChange__ActionAssignment_1"
    // InternalArg.g:11355:1: rule__PhysicChange__ActionAssignment_1 : ( ruleAction ) ;
    public final void rule__PhysicChange__ActionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11359:1: ( ( ruleAction ) )
            // InternalArg.g:11360:2: ( ruleAction )
            {
            // InternalArg.g:11360:2: ( ruleAction )
            // InternalArg.g:11361:3: ruleAction
            {
             before(grammarAccess.getPhysicChangeAccess().getActionActionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getActionActionEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ActionAssignment_1"


    // $ANTLR start "rule__PhysicChange__ClassAssignment_2_1"
    // InternalArg.g:11370:1: rule__PhysicChange__ClassAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__PhysicChange__ClassAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11374:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11375:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11375:2: ( ( ruleEString ) )
            // InternalArg.g:11376:3: ( ruleEString )
            {
             before(grammarAccess.getPhysicChangeAccess().getClassClassCrossReference_2_1_0()); 
            // InternalArg.g:11377:3: ( ruleEString )
            // InternalArg.g:11378:4: ruleEString
            {
             before(grammarAccess.getPhysicChangeAccess().getClassClassEStringParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getClassClassEStringParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getPhysicChangeAccess().getClassClassCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ClassAssignment_2_1"


    // $ANTLR start "rule__PhysicChange__ObjectAssignment_4"
    // InternalArg.g:11389:1: rule__PhysicChange__ObjectAssignment_4 : ( ruleEString ) ;
    public final void rule__PhysicChange__ObjectAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11393:1: ( ( ruleEString ) )
            // InternalArg.g:11394:2: ( ruleEString )
            {
            // InternalArg.g:11394:2: ( ruleEString )
            // InternalArg.g:11395:3: ruleEString
            {
             before(grammarAccess.getPhysicChangeAccess().getObjectEStringParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getObjectEStringParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ObjectAssignment_4"


    // $ANTLR start "rule__PhysicChange__PositionAssignment_5_1"
    // InternalArg.g:11404:1: rule__PhysicChange__PositionAssignment_5_1 : ( rulePosition ) ;
    public final void rule__PhysicChange__PositionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11408:1: ( ( rulePosition ) )
            // InternalArg.g:11409:2: ( rulePosition )
            {
            // InternalArg.g:11409:2: ( rulePosition )
            // InternalArg.g:11410:3: rulePosition
            {
             before(grammarAccess.getPhysicChangeAccess().getPositionPositionEnumRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getPositionPositionEnumRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__PositionAssignment_5_1"


    // $ANTLR start "rule__PhysicChange__ScaleAssignment_6_1"
    // InternalArg.g:11419:1: rule__PhysicChange__ScaleAssignment_6_1 : ( ruleEDouble ) ;
    public final void rule__PhysicChange__ScaleAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11423:1: ( ( ruleEDouble ) )
            // InternalArg.g:11424:2: ( ruleEDouble )
            {
            // InternalArg.g:11424:2: ( ruleEDouble )
            // InternalArg.g:11425:3: ruleEDouble
            {
             before(grammarAccess.getPhysicChangeAccess().getScaleEDoubleParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getScaleEDoubleParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ScaleAssignment_6_1"


    // $ANTLR start "rule__PhysicChange__AttributeAssignment_7_1"
    // InternalArg.g:11434:1: rule__PhysicChange__AttributeAssignment_7_1 : ( ruleEString ) ;
    public final void rule__PhysicChange__AttributeAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11438:1: ( ( ruleEString ) )
            // InternalArg.g:11439:2: ( ruleEString )
            {
            // InternalArg.g:11439:2: ( ruleEString )
            // InternalArg.g:11440:3: ruleEString
            {
             before(grammarAccess.getPhysicChangeAccess().getAttributeEStringParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getAttributeEStringParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__AttributeAssignment_7_1"


    // $ANTLR start "rule__PhysicChange__ChangeValueAssignment_8_1"
    // InternalArg.g:11449:1: rule__PhysicChange__ChangeValueAssignment_8_1 : ( ruleEInt ) ;
    public final void rule__PhysicChange__ChangeValueAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11453:1: ( ( ruleEInt ) )
            // InternalArg.g:11454:2: ( ruleEInt )
            {
            // InternalArg.g:11454:2: ( ruleEInt )
            // InternalArg.g:11455:3: ruleEInt
            {
             before(grammarAccess.getPhysicChangeAccess().getChangeValueEIntParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getChangeValueEIntParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ChangeValueAssignment_8_1"


    // $ANTLR start "rule__PhysicChange__ForceAssignment_9_1"
    // InternalArg.g:11464:1: rule__PhysicChange__ForceAssignment_9_1 : ( ( ruleEString ) ) ;
    public final void rule__PhysicChange__ForceAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11468:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11469:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11469:2: ( ( ruleEString ) )
            // InternalArg.g:11470:3: ( ruleEString )
            {
             before(grammarAccess.getPhysicChangeAccess().getForceForceCrossReference_9_1_0()); 
            // InternalArg.g:11471:3: ( ruleEString )
            // InternalArg.g:11472:4: ruleEString
            {
             before(grammarAccess.getPhysicChangeAccess().getForceForceEStringParserRuleCall_9_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhysicChangeAccess().getForceForceEStringParserRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getPhysicChangeAccess().getForceForceCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicChange__ForceAssignment_9_1"


    // $ANTLR start "rule__ObjAttribute__AttributeAssignment_0"
    // InternalArg.g:11483:1: rule__ObjAttribute__AttributeAssignment_0 : ( ( ruleEString ) ) ;
    public final void rule__ObjAttribute__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11487:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11488:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11488:2: ( ( ruleEString ) )
            // InternalArg.g:11489:3: ( ruleEString )
            {
             before(grammarAccess.getObjAttributeAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalArg.g:11490:3: ( ruleEString )
            // InternalArg.g:11491:4: ruleEString
            {
             before(grammarAccess.getObjAttributeAccess().getAttributeAttributeEStringParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getObjAttributeAccess().getAttributeAttributeEStringParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getObjAttributeAccess().getAttributeAttributeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__AttributeAssignment_0"


    // $ANTLR start "rule__ObjAttribute__ValueAssignment_2"
    // InternalArg.g:11502:1: rule__ObjAttribute__ValueAssignment_2 : ( ruleEString ) ;
    public final void rule__ObjAttribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11506:1: ( ( ruleEString ) )
            // InternalArg.g:11507:2: ( ruleEString )
            {
            // InternalArg.g:11507:2: ( ruleEString )
            // InternalArg.g:11508:3: ruleEString
            {
             before(grammarAccess.getObjAttributeAccess().getValueEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getObjAttributeAccess().getValueEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjAttribute__ValueAssignment_2"


    // $ANTLR start "rule__Rule__ActionAssignment_1"
    // InternalArg.g:11517:1: rule__Rule__ActionAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Rule__ActionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11521:1: ( ( ( ruleEString ) ) )
            // InternalArg.g:11522:2: ( ( ruleEString ) )
            {
            // InternalArg.g:11522:2: ( ( ruleEString ) )
            // InternalArg.g:11523:3: ( ruleEString )
            {
             before(grammarAccess.getRuleAccess().getActionTriggerCrossReference_1_0()); 
            // InternalArg.g:11524:3: ( ruleEString )
            // InternalArg.g:11525:4: ruleEString
            {
             before(grammarAccess.getRuleAccess().getActionTriggerEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getActionTriggerEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getActionTriggerCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__ActionAssignment_1"


    // $ANTLR start "rule__Rule__ConditionAssignment_3"
    // InternalArg.g:11536:1: rule__Rule__ConditionAssignment_3 : ( ruleCondition ) ;
    public final void rule__Rule__ConditionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11540:1: ( ( ruleCondition ) )
            // InternalArg.g:11541:2: ( ruleCondition )
            {
            // InternalArg.g:11541:2: ( ruleCondition )
            // InternalArg.g:11542:3: ruleCondition
            {
             before(grammarAccess.getRuleAccess().getConditionConditionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getConditionConditionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__ConditionAssignment_3"


    // $ANTLR start "rule__Not__LeftAssignment_1"
    // InternalArg.g:11551:1: rule__Not__LeftAssignment_1 : ( ruleCondition ) ;
    public final void rule__Not__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11555:1: ( ( ruleCondition ) )
            // InternalArg.g:11556:2: ( ruleCondition )
            {
            // InternalArg.g:11556:2: ( ruleCondition )
            // InternalArg.g:11557:3: ruleCondition
            {
             before(grammarAccess.getNotAccess().getLeftConditionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getNotAccess().getLeftConditionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__LeftAssignment_1"


    // $ANTLR start "rule__Binary__LeftAssignment_1"
    // InternalArg.g:11566:1: rule__Binary__LeftAssignment_1 : ( ruleCondition ) ;
    public final void rule__Binary__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11570:1: ( ( ruleCondition ) )
            // InternalArg.g:11571:2: ( ruleCondition )
            {
            // InternalArg.g:11571:2: ( ruleCondition )
            // InternalArg.g:11572:3: ruleCondition
            {
             before(grammarAccess.getBinaryAccess().getLeftConditionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getBinaryAccess().getLeftConditionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__LeftAssignment_1"


    // $ANTLR start "rule__Binary__OpAssignment_3"
    // InternalArg.g:11581:1: rule__Binary__OpAssignment_3 : ( ruleLogicOps ) ;
    public final void rule__Binary__OpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11585:1: ( ( ruleLogicOps ) )
            // InternalArg.g:11586:2: ( ruleLogicOps )
            {
            // InternalArg.g:11586:2: ( ruleLogicOps )
            // InternalArg.g:11587:3: ruleLogicOps
            {
             before(grammarAccess.getBinaryAccess().getOpLogicOpsEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLogicOps();

            state._fsp--;

             after(grammarAccess.getBinaryAccess().getOpLogicOpsEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__OpAssignment_3"


    // $ANTLR start "rule__Binary__RightAssignment_5"
    // InternalArg.g:11596:1: rule__Binary__RightAssignment_5 : ( ruleCondition ) ;
    public final void rule__Binary__RightAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11600:1: ( ( ruleCondition ) )
            // InternalArg.g:11601:2: ( ruleCondition )
            {
            // InternalArg.g:11601:2: ( ruleCondition )
            // InternalArg.g:11602:3: ruleCondition
            {
             before(grammarAccess.getBinaryAccess().getRightConditionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getBinaryAccess().getRightConditionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binary__RightAssignment_5"


    // $ANTLR start "rule__Arithmetic__LeftAssignment_0"
    // InternalArg.g:11611:1: rule__Arithmetic__LeftAssignment_0 : ( ruleValue ) ;
    public final void rule__Arithmetic__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11615:1: ( ( ruleValue ) )
            // InternalArg.g:11616:2: ( ruleValue )
            {
            // InternalArg.g:11616:2: ( ruleValue )
            // InternalArg.g:11617:3: ruleValue
            {
             before(grammarAccess.getArithmeticAccess().getLeftValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getArithmeticAccess().getLeftValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__LeftAssignment_0"


    // $ANTLR start "rule__Arithmetic__OpAssignment_1"
    // InternalArg.g:11626:1: rule__Arithmetic__OpAssignment_1 : ( ruleArithmOps ) ;
    public final void rule__Arithmetic__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11630:1: ( ( ruleArithmOps ) )
            // InternalArg.g:11631:2: ( ruleArithmOps )
            {
            // InternalArg.g:11631:2: ( ruleArithmOps )
            // InternalArg.g:11632:3: ruleArithmOps
            {
             before(grammarAccess.getArithmeticAccess().getOpArithmOpsEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmOps();

            state._fsp--;

             after(grammarAccess.getArithmeticAccess().getOpArithmOpsEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__OpAssignment_1"


    // $ANTLR start "rule__Arithmetic__RightAssignment_2"
    // InternalArg.g:11641:1: rule__Arithmetic__RightAssignment_2 : ( ruleValue ) ;
    public final void rule__Arithmetic__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11645:1: ( ( ruleValue ) )
            // InternalArg.g:11646:2: ( ruleValue )
            {
            // InternalArg.g:11646:2: ( ruleValue )
            // InternalArg.g:11647:3: ruleValue
            {
             before(grammarAccess.getArithmeticAccess().getRightValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getArithmeticAccess().getRightValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arithmetic__RightAssignment_2"


    // $ANTLR start "rule__AttributeValue__ClassAssignment_0"
    // InternalArg.g:11656:1: rule__AttributeValue__ClassAssignment_0 : ( ruleEString ) ;
    public final void rule__AttributeValue__ClassAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11660:1: ( ( ruleEString ) )
            // InternalArg.g:11661:2: ( ruleEString )
            {
            // InternalArg.g:11661:2: ( ruleEString )
            // InternalArg.g:11662:3: ruleEString
            {
             before(grammarAccess.getAttributeValueAccess().getClassEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAttributeValueAccess().getClassEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__ClassAssignment_0"


    // $ANTLR start "rule__AttributeValue__AttributeAssignment_2"
    // InternalArg.g:11671:1: rule__AttributeValue__AttributeAssignment_2 : ( ruleEString ) ;
    public final void rule__AttributeValue__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11675:1: ( ( ruleEString ) )
            // InternalArg.g:11676:2: ( ruleEString )
            {
            // InternalArg.g:11676:2: ( ruleEString )
            // InternalArg.g:11677:3: ruleEString
            {
             before(grammarAccess.getAttributeValueAccess().getAttributeEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAttributeValueAccess().getAttributeEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__AttributeAssignment_2"


    // $ANTLR start "rule__ConstantValue__ValueAssignment"
    // InternalArg.g:11686:1: rule__ConstantValue__ValueAssignment : ( ruleConstant ) ;
    public final void rule__ConstantValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11690:1: ( ( ruleConstant ) )
            // InternalArg.g:11691:2: ( ruleConstant )
            {
            // InternalArg.g:11691:2: ( ruleConstant )
            // InternalArg.g:11692:3: ruleConstant
            {
             before(grammarAccess.getConstantValueAccess().getValueConstantParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantValueAccess().getValueConstantParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantValue__ValueAssignment"


    // $ANTLR start "rule__AllInstances__TypeAssignment_1"
    // InternalArg.g:11701:1: rule__AllInstances__TypeAssignment_1 : ( ruleEString ) ;
    public final void rule__AllInstances__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArg.g:11705:1: ( ( ruleEString ) )
            // InternalArg.g:11706:2: ( ruleEString )
            {
            // InternalArg.g:11706:2: ( ruleEString )
            // InternalArg.g:11707:3: ruleEString
            {
             before(grammarAccess.getAllInstancesAccess().getTypeEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAllInstancesAccess().getTypeEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstances__TypeAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000200000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000600000000030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0030000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00F0200000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x01C0000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x9000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000040L,0x0000000000001002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000030L,0x0000000002000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0008200000000000L,0x0000000780000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000200000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000004040L,0x0000000000001002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0800000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000003000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000200000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000030L,0x0000018000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x00003E0000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000030L,0x0000010000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000070L,0x000E000000000002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x000003E000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});

}