package arg.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import arg.services.ArgGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArgParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Game'", "'{'", "'elements'", "'}'", "'dependences'", "'abstract'", "'invisible'", "'Graphic'", "'Physics'", "'Gamelogic'", "'Display'", "'start'", "'win'", "'lose'", "'score'", "'Actions'", "'Collisions'", "'Buttons'", "'Elements'", "':'", "'['", "'..'", "']'", "'='", "'isParam'", "'isKey'", "'readOnly'", "'*'", "'containtment'", "'min'", "'max'", "'target'", "'opposite'", "'-'", "'element'", "'versions'", "'constraints'", "'plane'", "'overlaps'", "'sizeMin'", "'sizeMax'", "'xVariation'", "'yVariation'", "'zVariation'", "'rotation'", "'.'", "'E'", "'e'", "'body'", "'forces'", "'contacts'", "'mass'", "'bodyType'", "'charge'", "'friction'", "'rollingFriction'", "'restitution'", "'damping'", "'angularDamping'", "'collision'", "'contact'", "'gesture'", "','", "'->'", "'finish'", "'lives'", "'action'", "'message'", "'timeEach'", "'changes'", "'to'", "'attributes'", "'rules'", "'camera'", "'do'", "'in'", "'named'", "'at'", "'scale'", "'stat'", "'changeStat'", "'force'", "'value'", "'if('", "')'", "'!'", "'('", "'Number'", "'drag'", "'tilt'", "'touch'", "'any'", "'horizontal'", "'vertical'", "'static'", "'dynamic'", "'kinematic'", "'none'", "'restart'", "'create'", "'edit'", "'delete'", "'front'", "'default'", "'back'", "'&'", "'|'", "'>'", "'>='", "'<'", "'<='"
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

        public InternalArgParser(TokenStream input, ArgGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Ontological";
       	}

       	@Override
       	protected ArgGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleOntological"
    // InternalArg.g:65:1: entryRuleOntological returns [EObject current=null] : iv_ruleOntological= ruleOntological EOF ;
    public final EObject entryRuleOntological() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOntological = null;


        try {
            // InternalArg.g:65:52: (iv_ruleOntological= ruleOntological EOF )
            // InternalArg.g:66:2: iv_ruleOntological= ruleOntological EOF
            {
             newCompositeNode(grammarAccess.getOntologicalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOntological=ruleOntological();

            state._fsp--;

             current =iv_ruleOntological; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOntological"


    // $ANTLR start "ruleOntological"
    // InternalArg.g:72:1: ruleOntological returns [EObject current=null] : (otherlv_0= 'Game' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'elements' otherlv_4= '{' ( (lv_classes_5_0= ruleClass ) ) ( (lv_classes_6_0= ruleClass ) )* otherlv_7= '}' otherlv_8= '}' ( (lv_graphic_9_0= ruleGraphic ) ) ( (lv_physic_10_0= rulePhysic ) ) ( (lv_game_11_0= ruleGame ) ) ) ;
    public final EObject ruleOntological() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_classes_5_0 = null;

        EObject lv_classes_6_0 = null;

        EObject lv_graphic_9_0 = null;

        EObject lv_physic_10_0 = null;

        EObject lv_game_11_0 = null;



        	enterRule();

        try {
            // InternalArg.g:78:2: ( (otherlv_0= 'Game' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'elements' otherlv_4= '{' ( (lv_classes_5_0= ruleClass ) ) ( (lv_classes_6_0= ruleClass ) )* otherlv_7= '}' otherlv_8= '}' ( (lv_graphic_9_0= ruleGraphic ) ) ( (lv_physic_10_0= rulePhysic ) ) ( (lv_game_11_0= ruleGame ) ) ) )
            // InternalArg.g:79:2: (otherlv_0= 'Game' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'elements' otherlv_4= '{' ( (lv_classes_5_0= ruleClass ) ) ( (lv_classes_6_0= ruleClass ) )* otherlv_7= '}' otherlv_8= '}' ( (lv_graphic_9_0= ruleGraphic ) ) ( (lv_physic_10_0= rulePhysic ) ) ( (lv_game_11_0= ruleGame ) ) )
            {
            // InternalArg.g:79:2: (otherlv_0= 'Game' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'elements' otherlv_4= '{' ( (lv_classes_5_0= ruleClass ) ) ( (lv_classes_6_0= ruleClass ) )* otherlv_7= '}' otherlv_8= '}' ( (lv_graphic_9_0= ruleGraphic ) ) ( (lv_physic_10_0= rulePhysic ) ) ( (lv_game_11_0= ruleGame ) ) )
            // InternalArg.g:80:3: otherlv_0= 'Game' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'elements' otherlv_4= '{' ( (lv_classes_5_0= ruleClass ) ) ( (lv_classes_6_0= ruleClass ) )* otherlv_7= '}' otherlv_8= '}' ( (lv_graphic_9_0= ruleGraphic ) ) ( (lv_physic_10_0= rulePhysic ) ) ( (lv_game_11_0= ruleGame ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getOntologicalAccess().getGameKeyword_0());
            		
            // InternalArg.g:84:3: ( (lv_name_1_0= ruleEString ) )
            // InternalArg.g:85:4: (lv_name_1_0= ruleEString )
            {
            // InternalArg.g:85:4: (lv_name_1_0= ruleEString )
            // InternalArg.g:86:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getOntologicalAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getOntologicalAccess().getElementsKeyword_3());
            		
            otherlv_4=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getOntologicalAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalArg.g:115:3: ( (lv_classes_5_0= ruleClass ) )
            // InternalArg.g:116:4: (lv_classes_5_0= ruleClass )
            {
            // InternalArg.g:116:4: (lv_classes_5_0= ruleClass )
            // InternalArg.g:117:5: lv_classes_5_0= ruleClass
            {

            					newCompositeNode(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_6);
            lv_classes_5_0=ruleClass();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            					}
            					add(
            						current,
            						"classes",
            						lv_classes_5_0,
            						"arg.Arg.Class");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:134:3: ( (lv_classes_6_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalArg.g:135:4: (lv_classes_6_0= ruleClass )
            	    {
            	    // InternalArg.g:135:4: (lv_classes_6_0= ruleClass )
            	    // InternalArg.g:136:5: lv_classes_6_0= ruleClass
            	    {

            	    					newCompositeNode(grammarAccess.getOntologicalAccess().getClassesClassParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_classes_6_0=ruleClass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"classes",
            	    						lv_classes_6_0,
            	    						"arg.Arg.Class");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getOntologicalAccess().getRightCurlyBracketKeyword_8());
            		
            // InternalArg.g:161:3: ( (lv_graphic_9_0= ruleGraphic ) )
            // InternalArg.g:162:4: (lv_graphic_9_0= ruleGraphic )
            {
            // InternalArg.g:162:4: (lv_graphic_9_0= ruleGraphic )
            // InternalArg.g:163:5: lv_graphic_9_0= ruleGraphic
            {

            					newCompositeNode(grammarAccess.getOntologicalAccess().getGraphicGraphicParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_9);
            lv_graphic_9_0=ruleGraphic();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            					}
            					set(
            						current,
            						"graphic",
            						lv_graphic_9_0,
            						"arg.Arg.Graphic");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:180:3: ( (lv_physic_10_0= rulePhysic ) )
            // InternalArg.g:181:4: (lv_physic_10_0= rulePhysic )
            {
            // InternalArg.g:181:4: (lv_physic_10_0= rulePhysic )
            // InternalArg.g:182:5: lv_physic_10_0= rulePhysic
            {

            					newCompositeNode(grammarAccess.getOntologicalAccess().getPhysicPhysicParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_10);
            lv_physic_10_0=rulePhysic();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            					}
            					set(
            						current,
            						"physic",
            						lv_physic_10_0,
            						"arg.Arg.Physic");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:199:3: ( (lv_game_11_0= ruleGame ) )
            // InternalArg.g:200:4: (lv_game_11_0= ruleGame )
            {
            // InternalArg.g:200:4: (lv_game_11_0= ruleGame )
            // InternalArg.g:201:5: lv_game_11_0= ruleGame
            {

            					newCompositeNode(grammarAccess.getOntologicalAccess().getGameGameParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_2);
            lv_game_11_0=ruleGame();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOntologicalRule());
            					}
            					set(
            						current,
            						"game",
            						lv_game_11_0,
            						"arg.Arg.Game");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOntological"


    // $ANTLR start "entryRuleCondition"
    // InternalArg.g:222:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalArg.g:222:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalArg.g:223:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalArg.g:229:1: ruleCondition returns [EObject current=null] : (this_Not_0= ruleNot | this_Binary_1= ruleBinary | this_Arithmetic_2= ruleArithmetic ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;

        EObject this_Binary_1 = null;

        EObject this_Arithmetic_2 = null;



        	enterRule();

        try {
            // InternalArg.g:235:2: ( (this_Not_0= ruleNot | this_Binary_1= ruleBinary | this_Arithmetic_2= ruleArithmetic ) )
            // InternalArg.g:236:2: (this_Not_0= ruleNot | this_Binary_1= ruleBinary | this_Arithmetic_2= ruleArithmetic )
            {
            // InternalArg.g:236:2: (this_Not_0= ruleNot | this_Binary_1= ruleBinary | this_Arithmetic_2= ruleArithmetic )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt2=1;
                }
                break;
            case 97:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 44:
            case 98:
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
                    // InternalArg.g:237:3: this_Not_0= ruleNot
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getNotParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Not_0=ruleNot();

                    state._fsp--;


                    			current = this_Not_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:246:3: this_Binary_1= ruleBinary
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getBinaryParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Binary_1=ruleBinary();

                    state._fsp--;


                    			current = this_Binary_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalArg.g:255:3: this_Arithmetic_2= ruleArithmetic
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getArithmeticParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Arithmetic_2=ruleArithmetic();

                    state._fsp--;


                    			current = this_Arithmetic_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleValue"
    // InternalArg.g:267:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalArg.g:267:46: (iv_ruleValue= ruleValue EOF )
            // InternalArg.g:268:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalArg.g:274:1: ruleValue returns [EObject current=null] : (this_AttributeValue_0= ruleAttributeValue | this_ConstantValue_1= ruleConstantValue | this_AllInstances_2= ruleAllInstances ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeValue_0 = null;

        EObject this_ConstantValue_1 = null;

        EObject this_AllInstances_2 = null;



        	enterRule();

        try {
            // InternalArg.g:280:2: ( (this_AttributeValue_0= ruleAttributeValue | this_ConstantValue_1= ruleConstantValue | this_AllInstances_2= ruleAllInstances ) )
            // InternalArg.g:281:2: (this_AttributeValue_0= ruleAttributeValue | this_ConstantValue_1= ruleConstantValue | this_AllInstances_2= ruleAllInstances )
            {
            // InternalArg.g:281:2: (this_AttributeValue_0= ruleAttributeValue | this_ConstantValue_1= ruleConstantValue | this_AllInstances_2= ruleAllInstances )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==56) ) {
                    alt3=1;
                }
                else if ( (LA3_1==EOF||LA3_1==34||LA3_1==95||(LA3_1>=118 && LA3_1<=121)) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==56) ) {
                    alt3=1;
                }
                else if ( (LA3_2==EOF||LA3_2==34||LA3_2==95||(LA3_2>=118 && LA3_2<=121)) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case 44:
                {
                alt3=2;
                }
                break;
            case 98:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalArg.g:282:3: this_AttributeValue_0= ruleAttributeValue
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getAttributeValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeValue_0=ruleAttributeValue();

                    state._fsp--;


                    			current = this_AttributeValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:291:3: this_ConstantValue_1= ruleConstantValue
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getConstantValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstantValue_1=ruleConstantValue();

                    state._fsp--;


                    			current = this_ConstantValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalArg.g:300:3: this_AllInstances_2= ruleAllInstances
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getAllInstancesParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllInstances_2=ruleAllInstances();

                    state._fsp--;


                    			current = this_AllInstances_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleEString"
    // InternalArg.g:312:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalArg.g:312:47: (iv_ruleEString= ruleEString EOF )
            // InternalArg.g:313:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalArg.g:319:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalArg.g:325:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalArg.g:326:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalArg.g:326:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalArg.g:327:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:335:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleClass"
    // InternalArg.g:346:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalArg.g:346:46: (iv_ruleClass= ruleClass EOF )
            // InternalArg.g:347:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalArg.g:353:1: ruleClass returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )? (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )? otherlv_9= '}' ( (lv_abstract_10_0= 'abstract' ) )? ( (lv_noSCN_11_0= 'invisible' ) )? ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_abstract_10_0=null;
        Token lv_noSCN_11_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_attributes_2_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_references_6_0 = null;

        EObject lv_references_7_0 = null;



        	enterRule();

        try {
            // InternalArg.g:359:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )? (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )? otherlv_9= '}' ( (lv_abstract_10_0= 'abstract' ) )? ( (lv_noSCN_11_0= 'invisible' ) )? ) )
            // InternalArg.g:360:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )? (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )? otherlv_9= '}' ( (lv_abstract_10_0= 'abstract' ) )? ( (lv_noSCN_11_0= 'invisible' ) )? )
            {
            // InternalArg.g:360:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )? (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )? otherlv_9= '}' ( (lv_abstract_10_0= 'abstract' ) )? ( (lv_noSCN_11_0= 'invisible' ) )? )
            // InternalArg.g:361:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )? (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )? otherlv_9= '}' ( (lv_abstract_10_0= 'abstract' ) )? ( (lv_noSCN_11_0= 'invisible' ) )?
            {
            // InternalArg.g:361:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:362:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:362:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:363:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getClassAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalArg.g:384:3: ( ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalArg.g:385:4: ( (lv_attributes_2_0= ruleAttribute ) ) ( (lv_attributes_3_0= ruleAttribute ) )*
                    {
                    // InternalArg.g:385:4: ( (lv_attributes_2_0= ruleAttribute ) )
                    // InternalArg.g:386:5: (lv_attributes_2_0= ruleAttribute )
                    {
                    // InternalArg.g:386:5: (lv_attributes_2_0= ruleAttribute )
                    // InternalArg.g:387:6: lv_attributes_2_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_attributes_2_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_2_0,
                    							"arg.Arg.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:404:4: ( (lv_attributes_3_0= ruleAttribute ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalArg.g:405:5: (lv_attributes_3_0= ruleAttribute )
                    	    {
                    	    // InternalArg.g:405:5: (lv_attributes_3_0= ruleAttribute )
                    	    // InternalArg.g:406:6: lv_attributes_3_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_attributes_3_0=ruleAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_3_0,
                    	    							"arg.Arg.Attribute");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalArg.g:424:3: (otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalArg.g:425:4: otherlv_4= 'dependences' otherlv_5= '{' ( (lv_references_6_0= ruleReference ) ) ( (lv_references_7_0= ruleReference ) )* otherlv_8= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getClassAccess().getDependencesKeyword_3_0());
                    			
                    otherlv_5=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalArg.g:433:4: ( (lv_references_6_0= ruleReference ) )
                    // InternalArg.g:434:5: (lv_references_6_0= ruleReference )
                    {
                    // InternalArg.g:434:5: (lv_references_6_0= ruleReference )
                    // InternalArg.g:435:6: lv_references_6_0= ruleReference
                    {

                    						newCompositeNode(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_references_6_0=ruleReference();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassRule());
                    						}
                    						add(
                    							current,
                    							"references",
                    							lv_references_6_0,
                    							"arg.Arg.Reference");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:452:4: ( (lv_references_7_0= ruleReference ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalArg.g:453:5: (lv_references_7_0= ruleReference )
                    	    {
                    	    // InternalArg.g:453:5: (lv_references_7_0= ruleReference )
                    	    // InternalArg.g:454:6: lv_references_7_0= ruleReference
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassAccess().getReferencesReferenceParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_references_7_0=ruleReference();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"references",
                    	    							lv_references_7_0,
                    	    							"arg.Arg.Reference");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_12); 

            			newLeafNode(otherlv_9, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalArg.g:480:3: ( (lv_abstract_10_0= 'abstract' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalArg.g:481:4: (lv_abstract_10_0= 'abstract' )
                    {
                    // InternalArg.g:481:4: (lv_abstract_10_0= 'abstract' )
                    // InternalArg.g:482:5: lv_abstract_10_0= 'abstract'
                    {
                    lv_abstract_10_0=(Token)match(input,16,FOLLOW_13); 

                    					newLeafNode(lv_abstract_10_0, grammarAccess.getClassAccess().getAbstractAbstractKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassRule());
                    					}
                    					setWithLastConsumed(current, "abstract", lv_abstract_10_0 != null, "abstract");
                    				

                    }


                    }
                    break;

            }

            // InternalArg.g:494:3: ( (lv_noSCN_11_0= 'invisible' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalArg.g:495:4: (lv_noSCN_11_0= 'invisible' )
                    {
                    // InternalArg.g:495:4: (lv_noSCN_11_0= 'invisible' )
                    // InternalArg.g:496:5: lv_noSCN_11_0= 'invisible'
                    {
                    lv_noSCN_11_0=(Token)match(input,17,FOLLOW_2); 

                    					newLeafNode(lv_noSCN_11_0, grammarAccess.getClassAccess().getNoSCNInvisibleKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassRule());
                    					}
                    					setWithLastConsumed(current, "noSCN", lv_noSCN_11_0 != null, "invisible");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleGraphic"
    // InternalArg.g:512:1: entryRuleGraphic returns [EObject current=null] : iv_ruleGraphic= ruleGraphic EOF ;
    public final EObject entryRuleGraphic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGraphic = null;


        try {
            // InternalArg.g:512:48: (iv_ruleGraphic= ruleGraphic EOF )
            // InternalArg.g:513:2: iv_ruleGraphic= ruleGraphic EOF
            {
             newCompositeNode(grammarAccess.getGraphicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGraphic=ruleGraphic();

            state._fsp--;

             current =iv_ruleGraphic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphic"


    // $ANTLR start "ruleGraphic"
    // InternalArg.g:519:1: ruleGraphic returns [EObject current=null] : (otherlv_0= 'Graphic' otherlv_1= '{' ( (lv_classes_2_0= ruleGraphicClass ) ) ( (lv_classes_3_0= ruleGraphicClass ) )* otherlv_4= '}' ) ;
    public final EObject ruleGraphic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_classes_2_0 = null;

        EObject lv_classes_3_0 = null;



        	enterRule();

        try {
            // InternalArg.g:525:2: ( (otherlv_0= 'Graphic' otherlv_1= '{' ( (lv_classes_2_0= ruleGraphicClass ) ) ( (lv_classes_3_0= ruleGraphicClass ) )* otherlv_4= '}' ) )
            // InternalArg.g:526:2: (otherlv_0= 'Graphic' otherlv_1= '{' ( (lv_classes_2_0= ruleGraphicClass ) ) ( (lv_classes_3_0= ruleGraphicClass ) )* otherlv_4= '}' )
            {
            // InternalArg.g:526:2: (otherlv_0= 'Graphic' otherlv_1= '{' ( (lv_classes_2_0= ruleGraphicClass ) ) ( (lv_classes_3_0= ruleGraphicClass ) )* otherlv_4= '}' )
            // InternalArg.g:527:3: otherlv_0= 'Graphic' otherlv_1= '{' ( (lv_classes_2_0= ruleGraphicClass ) ) ( (lv_classes_3_0= ruleGraphicClass ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getGraphicAccess().getGraphicKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getGraphicAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalArg.g:535:3: ( (lv_classes_2_0= ruleGraphicClass ) )
            // InternalArg.g:536:4: (lv_classes_2_0= ruleGraphicClass )
            {
            // InternalArg.g:536:4: (lv_classes_2_0= ruleGraphicClass )
            // InternalArg.g:537:5: lv_classes_2_0= ruleGraphicClass
            {

            					newCompositeNode(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_classes_2_0=ruleGraphicClass();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGraphicRule());
            					}
            					add(
            						current,
            						"classes",
            						lv_classes_2_0,
            						"arg.Arg.GraphicClass");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:554:3: ( (lv_classes_3_0= ruleGraphicClass ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==45) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalArg.g:555:4: (lv_classes_3_0= ruleGraphicClass )
            	    {
            	    // InternalArg.g:555:4: (lv_classes_3_0= ruleGraphicClass )
            	    // InternalArg.g:556:5: lv_classes_3_0= ruleGraphicClass
            	    {

            	    					newCompositeNode(grammarAccess.getGraphicAccess().getClassesGraphicClassParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_classes_3_0=ruleGraphicClass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGraphicRule());
            	    					}
            	    					add(
            	    						current,
            	    						"classes",
            	    						lv_classes_3_0,
            	    						"arg.Arg.GraphicClass");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGraphicAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphic"


    // $ANTLR start "entryRulePhysic"
    // InternalArg.g:581:1: entryRulePhysic returns [EObject current=null] : iv_rulePhysic= rulePhysic EOF ;
    public final EObject entryRulePhysic() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysic = null;


        try {
            // InternalArg.g:581:47: (iv_rulePhysic= rulePhysic EOF )
            // InternalArg.g:582:2: iv_rulePhysic= rulePhysic EOF
            {
             newCompositeNode(grammarAccess.getPhysicRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysic=rulePhysic();

            state._fsp--;

             current =iv_rulePhysic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysic"


    // $ANTLR start "rulePhysic"
    // InternalArg.g:588:1: rulePhysic returns [EObject current=null] : (otherlv_0= 'Physics' otherlv_1= '{' ( (lv_classes_2_0= rulePhysicClass ) ) ( (lv_classes_3_0= rulePhysicClass ) )* otherlv_4= '}' ) ;
    public final EObject rulePhysic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_classes_2_0 = null;

        EObject lv_classes_3_0 = null;



        	enterRule();

        try {
            // InternalArg.g:594:2: ( (otherlv_0= 'Physics' otherlv_1= '{' ( (lv_classes_2_0= rulePhysicClass ) ) ( (lv_classes_3_0= rulePhysicClass ) )* otherlv_4= '}' ) )
            // InternalArg.g:595:2: (otherlv_0= 'Physics' otherlv_1= '{' ( (lv_classes_2_0= rulePhysicClass ) ) ( (lv_classes_3_0= rulePhysicClass ) )* otherlv_4= '}' )
            {
            // InternalArg.g:595:2: (otherlv_0= 'Physics' otherlv_1= '{' ( (lv_classes_2_0= rulePhysicClass ) ) ( (lv_classes_3_0= rulePhysicClass ) )* otherlv_4= '}' )
            // InternalArg.g:596:3: otherlv_0= 'Physics' otherlv_1= '{' ( (lv_classes_2_0= rulePhysicClass ) ) ( (lv_classes_3_0= rulePhysicClass ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPhysicAccess().getPhysicsKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getPhysicAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalArg.g:604:3: ( (lv_classes_2_0= rulePhysicClass ) )
            // InternalArg.g:605:4: (lv_classes_2_0= rulePhysicClass )
            {
            // InternalArg.g:605:4: (lv_classes_2_0= rulePhysicClass )
            // InternalArg.g:606:5: lv_classes_2_0= rulePhysicClass
            {

            					newCompositeNode(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_classes_2_0=rulePhysicClass();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicRule());
            					}
            					add(
            						current,
            						"classes",
            						lv_classes_2_0,
            						"arg.Arg.PhysicClass");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:623:3: ( (lv_classes_3_0= rulePhysicClass ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==45) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalArg.g:624:4: (lv_classes_3_0= rulePhysicClass )
            	    {
            	    // InternalArg.g:624:4: (lv_classes_3_0= rulePhysicClass )
            	    // InternalArg.g:625:5: lv_classes_3_0= rulePhysicClass
            	    {

            	    					newCompositeNode(grammarAccess.getPhysicAccess().getClassesPhysicClassParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_classes_3_0=rulePhysicClass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPhysicRule());
            	    					}
            	    					add(
            	    						current,
            	    						"classes",
            	    						lv_classes_3_0,
            	    						"arg.Arg.PhysicClass");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPhysicAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysic"


    // $ANTLR start "entryRuleGame"
    // InternalArg.g:650:1: entryRuleGame returns [EObject current=null] : iv_ruleGame= ruleGame EOF ;
    public final EObject entryRuleGame() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGame = null;


        try {
            // InternalArg.g:650:45: (iv_ruleGame= ruleGame EOF )
            // InternalArg.g:651:2: iv_ruleGame= ruleGame EOF
            {
             newCompositeNode(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGame=ruleGame();

            state._fsp--;

             current =iv_ruleGame; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalArg.g:657:1: ruleGame returns [EObject current=null] : (otherlv_0= 'Gamelogic' otherlv_1= '{' otherlv_2= 'Display' otherlv_3= '{' otherlv_4= 'start' ( (lv_start_5_0= ruleEString ) ) otherlv_6= 'win' ( (lv_win_7_0= ruleEString ) ) otherlv_8= 'lose' ( (lv_lose_9_0= ruleEString ) ) otherlv_10= 'score' otherlv_11= '{' ( (lv_score_12_0= ruleScoreSystem ) ) otherlv_13= '}' otherlv_14= '}' (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )? (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )? (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )? (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )? otherlv_35= '}' ) ;
    public final EObject ruleGame() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        AntlrDatatypeRuleToken lv_start_5_0 = null;

        AntlrDatatypeRuleToken lv_win_7_0 = null;

        AntlrDatatypeRuleToken lv_lose_9_0 = null;

        EObject lv_score_12_0 = null;

        EObject lv_actionsTriggers_17_0 = null;

        EObject lv_actionsTriggers_18_0 = null;

        EObject lv_collisions_22_0 = null;

        EObject lv_collisions_23_0 = null;

        EObject lv_gamepad_27_0 = null;

        EObject lv_gamepad_28_0 = null;

        EObject lv_objInit_32_0 = null;

        EObject lv_objInit_33_0 = null;



        	enterRule();

        try {
            // InternalArg.g:663:2: ( (otherlv_0= 'Gamelogic' otherlv_1= '{' otherlv_2= 'Display' otherlv_3= '{' otherlv_4= 'start' ( (lv_start_5_0= ruleEString ) ) otherlv_6= 'win' ( (lv_win_7_0= ruleEString ) ) otherlv_8= 'lose' ( (lv_lose_9_0= ruleEString ) ) otherlv_10= 'score' otherlv_11= '{' ( (lv_score_12_0= ruleScoreSystem ) ) otherlv_13= '}' otherlv_14= '}' (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )? (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )? (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )? (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )? otherlv_35= '}' ) )
            // InternalArg.g:664:2: (otherlv_0= 'Gamelogic' otherlv_1= '{' otherlv_2= 'Display' otherlv_3= '{' otherlv_4= 'start' ( (lv_start_5_0= ruleEString ) ) otherlv_6= 'win' ( (lv_win_7_0= ruleEString ) ) otherlv_8= 'lose' ( (lv_lose_9_0= ruleEString ) ) otherlv_10= 'score' otherlv_11= '{' ( (lv_score_12_0= ruleScoreSystem ) ) otherlv_13= '}' otherlv_14= '}' (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )? (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )? (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )? (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )? otherlv_35= '}' )
            {
            // InternalArg.g:664:2: (otherlv_0= 'Gamelogic' otherlv_1= '{' otherlv_2= 'Display' otherlv_3= '{' otherlv_4= 'start' ( (lv_start_5_0= ruleEString ) ) otherlv_6= 'win' ( (lv_win_7_0= ruleEString ) ) otherlv_8= 'lose' ( (lv_lose_9_0= ruleEString ) ) otherlv_10= 'score' otherlv_11= '{' ( (lv_score_12_0= ruleScoreSystem ) ) otherlv_13= '}' otherlv_14= '}' (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )? (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )? (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )? (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )? otherlv_35= '}' )
            // InternalArg.g:665:3: otherlv_0= 'Gamelogic' otherlv_1= '{' otherlv_2= 'Display' otherlv_3= '{' otherlv_4= 'start' ( (lv_start_5_0= ruleEString ) ) otherlv_6= 'win' ( (lv_win_7_0= ruleEString ) ) otherlv_8= 'lose' ( (lv_lose_9_0= ruleEString ) ) otherlv_10= 'score' otherlv_11= '{' ( (lv_score_12_0= ruleScoreSystem ) ) otherlv_13= '}' otherlv_14= '}' (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )? (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )? (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )? (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )? otherlv_35= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getGameAccess().getGamelogicKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getGameAccess().getDisplayKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getGameAccess().getStartKeyword_4());
            		
            // InternalArg.g:685:3: ( (lv_start_5_0= ruleEString ) )
            // InternalArg.g:686:4: (lv_start_5_0= ruleEString )
            {
            // InternalArg.g:686:4: (lv_start_5_0= ruleEString )
            // InternalArg.g:687:5: lv_start_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGameAccess().getStartEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_18);
            lv_start_5_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_5_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getGameAccess().getWinKeyword_6());
            		
            // InternalArg.g:708:3: ( (lv_win_7_0= ruleEString ) )
            // InternalArg.g:709:4: (lv_win_7_0= ruleEString )
            {
            // InternalArg.g:709:4: (lv_win_7_0= ruleEString )
            // InternalArg.g:710:5: lv_win_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGameAccess().getWinEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_19);
            lv_win_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"win",
            						lv_win_7_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getGameAccess().getLoseKeyword_8());
            		
            // InternalArg.g:731:3: ( (lv_lose_9_0= ruleEString ) )
            // InternalArg.g:732:4: (lv_lose_9_0= ruleEString )
            {
            // InternalArg.g:732:4: (lv_lose_9_0= ruleEString )
            // InternalArg.g:733:5: lv_lose_9_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGameAccess().getLoseEStringParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_20);
            lv_lose_9_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"lose",
            						lv_lose_9_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getGameAccess().getScoreKeyword_10());
            		
            otherlv_11=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_11, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_11());
            		
            // InternalArg.g:758:3: ( (lv_score_12_0= ruleScoreSystem ) )
            // InternalArg.g:759:4: (lv_score_12_0= ruleScoreSystem )
            {
            // InternalArg.g:759:4: (lv_score_12_0= ruleScoreSystem )
            // InternalArg.g:760:5: lv_score_12_0= ruleScoreSystem
            {

            					newCompositeNode(grammarAccess.getGameAccess().getScoreScoreSystemParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_7);
            lv_score_12_0=ruleScoreSystem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"score",
            						lv_score_12_0,
            						"arg.Arg.ScoreSystem");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_13, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_13());
            		
            otherlv_14=(Token)match(input,14,FOLLOW_21); 

            			newLeafNode(otherlv_14, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_14());
            		
            // InternalArg.g:785:3: (otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalArg.g:786:4: otherlv_15= 'Actions' otherlv_16= '{' ( (lv_actionsTriggers_17_0= ruleTrigger ) ) ( (lv_actionsTriggers_18_0= ruleTrigger ) )* otherlv_19= '}'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getGameAccess().getActionsKeyword_15_0());
                    			
                    otherlv_16=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalArg.g:794:4: ( (lv_actionsTriggers_17_0= ruleTrigger ) )
                    // InternalArg.g:795:5: (lv_actionsTriggers_17_0= ruleTrigger )
                    {
                    // InternalArg.g:795:5: (lv_actionsTriggers_17_0= ruleTrigger )
                    // InternalArg.g:796:6: lv_actionsTriggers_17_0= ruleTrigger
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_actionsTriggers_17_0=ruleTrigger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"actionsTriggers",
                    							lv_actionsTriggers_17_0,
                    							"arg.Arg.Trigger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:813:4: ( (lv_actionsTriggers_18_0= ruleTrigger ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_ID)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalArg.g:814:5: (lv_actionsTriggers_18_0= ruleTrigger )
                    	    {
                    	    // InternalArg.g:814:5: (lv_actionsTriggers_18_0= ruleTrigger )
                    	    // InternalArg.g:815:6: lv_actionsTriggers_18_0= ruleTrigger
                    	    {

                    	    						newCompositeNode(grammarAccess.getGameAccess().getActionsTriggersTriggerParserRuleCall_15_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_actionsTriggers_18_0=ruleTrigger();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGameRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actionsTriggers",
                    	    							lv_actionsTriggers_18_0,
                    	    							"arg.Arg.Trigger");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,14,FOLLOW_22); 

                    				newLeafNode(otherlv_19, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_15_4());
                    			

                    }
                    break;

            }

            // InternalArg.g:837:3: (otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalArg.g:838:4: otherlv_20= 'Collisions' otherlv_21= '{' ( (lv_collisions_22_0= ruleCollision ) ) ( (lv_collisions_23_0= ruleCollision ) )* otherlv_24= '}'
                    {
                    otherlv_20=(Token)match(input,27,FOLLOW_4); 

                    				newLeafNode(otherlv_20, grammarAccess.getGameAccess().getCollisionsKeyword_16_0());
                    			
                    otherlv_21=(Token)match(input,12,FOLLOW_14); 

                    				newLeafNode(otherlv_21, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalArg.g:846:4: ( (lv_collisions_22_0= ruleCollision ) )
                    // InternalArg.g:847:5: (lv_collisions_22_0= ruleCollision )
                    {
                    // InternalArg.g:847:5: (lv_collisions_22_0= ruleCollision )
                    // InternalArg.g:848:6: lv_collisions_22_0= ruleCollision
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_collisions_22_0=ruleCollision();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"collisions",
                    							lv_collisions_22_0,
                    							"arg.Arg.Collision");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:865:4: ( (lv_collisions_23_0= ruleCollision ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalArg.g:866:5: (lv_collisions_23_0= ruleCollision )
                    	    {
                    	    // InternalArg.g:866:5: (lv_collisions_23_0= ruleCollision )
                    	    // InternalArg.g:867:6: lv_collisions_23_0= ruleCollision
                    	    {

                    	    						newCompositeNode(grammarAccess.getGameAccess().getCollisionsCollisionParserRuleCall_16_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_collisions_23_0=ruleCollision();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGameRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"collisions",
                    	    							lv_collisions_23_0,
                    	    							"arg.Arg.Collision");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,14,FOLLOW_23); 

                    				newLeafNode(otherlv_24, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_16_4());
                    			

                    }
                    break;

            }

            // InternalArg.g:889:3: (otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalArg.g:890:4: otherlv_25= 'Buttons' otherlv_26= '{' ( (lv_gamepad_27_0= ruleGamePad ) ) ( (lv_gamepad_28_0= ruleGamePad ) )* otherlv_29= '}'
                    {
                    otherlv_25=(Token)match(input,28,FOLLOW_4); 

                    				newLeafNode(otherlv_25, grammarAccess.getGameAccess().getButtonsKeyword_17_0());
                    			
                    otherlv_26=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_26, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_17_1());
                    			
                    // InternalArg.g:898:4: ( (lv_gamepad_27_0= ruleGamePad ) )
                    // InternalArg.g:899:5: (lv_gamepad_27_0= ruleGamePad )
                    {
                    // InternalArg.g:899:5: (lv_gamepad_27_0= ruleGamePad )
                    // InternalArg.g:900:6: lv_gamepad_27_0= ruleGamePad
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_gamepad_27_0=ruleGamePad();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"gamepad",
                    							lv_gamepad_27_0,
                    							"arg.Arg.GamePad");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:917:4: ( (lv_gamepad_28_0= ruleGamePad ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_ID)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalArg.g:918:5: (lv_gamepad_28_0= ruleGamePad )
                    	    {
                    	    // InternalArg.g:918:5: (lv_gamepad_28_0= ruleGamePad )
                    	    // InternalArg.g:919:6: lv_gamepad_28_0= ruleGamePad
                    	    {

                    	    						newCompositeNode(grammarAccess.getGameAccess().getGamepadGamePadParserRuleCall_17_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_gamepad_28_0=ruleGamePad();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGameRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"gamepad",
                    	    							lv_gamepad_28_0,
                    	    							"arg.Arg.GamePad");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,14,FOLLOW_24); 

                    				newLeafNode(otherlv_29, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_17_4());
                    			

                    }
                    break;

            }

            // InternalArg.g:941:3: (otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalArg.g:942:4: otherlv_30= 'Elements' otherlv_31= '{' ( (lv_objInit_32_0= ruleObjInit ) ) ( (lv_objInit_33_0= ruleObjInit ) )* otherlv_34= '}'
                    {
                    otherlv_30=(Token)match(input,29,FOLLOW_4); 

                    				newLeafNode(otherlv_30, grammarAccess.getGameAccess().getElementsKeyword_18_0());
                    			
                    otherlv_31=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_31, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_18_1());
                    			
                    // InternalArg.g:950:4: ( (lv_objInit_32_0= ruleObjInit ) )
                    // InternalArg.g:951:5: (lv_objInit_32_0= ruleObjInit )
                    {
                    // InternalArg.g:951:5: (lv_objInit_32_0= ruleObjInit )
                    // InternalArg.g:952:6: lv_objInit_32_0= ruleObjInit
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_objInit_32_0=ruleObjInit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"objInit",
                    							lv_objInit_32_0,
                    							"arg.Arg.ObjInit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:969:4: ( (lv_objInit_33_0= ruleObjInit ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalArg.g:970:5: (lv_objInit_33_0= ruleObjInit )
                    	    {
                    	    // InternalArg.g:970:5: (lv_objInit_33_0= ruleObjInit )
                    	    // InternalArg.g:971:6: lv_objInit_33_0= ruleObjInit
                    	    {

                    	    						newCompositeNode(grammarAccess.getGameAccess().getObjInitObjInitParserRuleCall_18_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_objInit_33_0=ruleObjInit();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGameRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"objInit",
                    	    							lv_objInit_33_0,
                    	    							"arg.Arg.ObjInit");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_34=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_34, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_18_4());
                    			

                    }
                    break;

            }

            otherlv_35=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_35, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_19());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleAttribute"
    // InternalArg.g:1001:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalArg.g:1001:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalArg.g:1002:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalArg.g:1008:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEString ) ) otherlv_3= '[' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' ( (lv_max_6_0= ruleAttributeMax ) ) otherlv_7= ']' otherlv_8= '=' ( (lv_default_9_0= ruleConstant ) ) ( (lv_isParam_10_0= 'isParam' ) )? ( (lv_isKey_11_0= 'isKey' ) )? ( (lv_readOnly_12_0= 'readOnly' ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_isParam_10_0=null;
        Token lv_isKey_11_0=null;
        Token lv_readOnly_12_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;

        AntlrDatatypeRuleToken lv_default_9_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1014:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEString ) ) otherlv_3= '[' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' ( (lv_max_6_0= ruleAttributeMax ) ) otherlv_7= ']' otherlv_8= '=' ( (lv_default_9_0= ruleConstant ) ) ( (lv_isParam_10_0= 'isParam' ) )? ( (lv_isKey_11_0= 'isKey' ) )? ( (lv_readOnly_12_0= 'readOnly' ) )? ) )
            // InternalArg.g:1015:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEString ) ) otherlv_3= '[' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' ( (lv_max_6_0= ruleAttributeMax ) ) otherlv_7= ']' otherlv_8= '=' ( (lv_default_9_0= ruleConstant ) ) ( (lv_isParam_10_0= 'isParam' ) )? ( (lv_isKey_11_0= 'isKey' ) )? ( (lv_readOnly_12_0= 'readOnly' ) )? )
            {
            // InternalArg.g:1015:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEString ) ) otherlv_3= '[' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' ( (lv_max_6_0= ruleAttributeMax ) ) otherlv_7= ']' otherlv_8= '=' ( (lv_default_9_0= ruleConstant ) ) ( (lv_isParam_10_0= 'isParam' ) )? ( (lv_isKey_11_0= 'isKey' ) )? ( (lv_readOnly_12_0= 'readOnly' ) )? )
            // InternalArg.g:1016:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEString ) ) otherlv_3= '[' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' ( (lv_max_6_0= ruleAttributeMax ) ) otherlv_7= ']' otherlv_8= '=' ( (lv_default_9_0= ruleConstant ) ) ( (lv_isParam_10_0= 'isParam' ) )? ( (lv_isKey_11_0= 'isKey' ) )? ( (lv_readOnly_12_0= 'readOnly' ) )?
            {
            // InternalArg.g:1016:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:1017:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:1017:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:1018:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
            		
            // InternalArg.g:1039:3: ( (lv_type_2_0= ruleEString ) )
            // InternalArg.g:1040:4: (lv_type_2_0= ruleEString )
            {
            // InternalArg.g:1040:4: (lv_type_2_0= ruleEString )
            // InternalArg.g:1041:5: lv_type_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getTypeEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_type_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalArg.g:1062:3: ( (lv_min_4_0= ruleEInt ) )
            // InternalArg.g:1063:4: (lv_min_4_0= ruleEInt )
            {
            // InternalArg.g:1063:4: (lv_min_4_0= ruleEInt )
            // InternalArg.g:1064:5: lv_min_4_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getMinEIntParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_28);
            lv_min_4_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_4_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_29); 

            			newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getFullStopFullStopKeyword_5());
            		
            // InternalArg.g:1085:3: ( (lv_max_6_0= ruleAttributeMax ) )
            // InternalArg.g:1086:4: (lv_max_6_0= ruleAttributeMax )
            {
            // InternalArg.g:1086:4: (lv_max_6_0= ruleAttributeMax )
            // InternalArg.g:1087:5: lv_max_6_0= ruleAttributeMax
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getMaxAttributeMaxParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_30);
            lv_max_6_0=ruleAttributeMax();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"max",
            						lv_max_6_0,
            						"arg.Arg.AttributeMax");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,33,FOLLOW_31); 

            			newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,34,FOLLOW_32); 

            			newLeafNode(otherlv_8, grammarAccess.getAttributeAccess().getEqualsSignKeyword_8());
            		
            // InternalArg.g:1112:3: ( (lv_default_9_0= ruleConstant ) )
            // InternalArg.g:1113:4: (lv_default_9_0= ruleConstant )
            {
            // InternalArg.g:1113:4: (lv_default_9_0= ruleConstant )
            // InternalArg.g:1114:5: lv_default_9_0= ruleConstant
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getDefaultConstantParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_33);
            lv_default_9_0=ruleConstant();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"default",
            						lv_default_9_0,
            						"arg.Arg.Constant");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:1131:3: ( (lv_isParam_10_0= 'isParam' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==35) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalArg.g:1132:4: (lv_isParam_10_0= 'isParam' )
                    {
                    // InternalArg.g:1132:4: (lv_isParam_10_0= 'isParam' )
                    // InternalArg.g:1133:5: lv_isParam_10_0= 'isParam'
                    {
                    lv_isParam_10_0=(Token)match(input,35,FOLLOW_34); 

                    					newLeafNode(lv_isParam_10_0, grammarAccess.getAttributeAccess().getIsParamIsParamKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "isParam", lv_isParam_10_0 != null, "isParam");
                    				

                    }


                    }
                    break;

            }

            // InternalArg.g:1145:3: ( (lv_isKey_11_0= 'isKey' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalArg.g:1146:4: (lv_isKey_11_0= 'isKey' )
                    {
                    // InternalArg.g:1146:4: (lv_isKey_11_0= 'isKey' )
                    // InternalArg.g:1147:5: lv_isKey_11_0= 'isKey'
                    {
                    lv_isKey_11_0=(Token)match(input,36,FOLLOW_35); 

                    					newLeafNode(lv_isKey_11_0, grammarAccess.getAttributeAccess().getIsKeyIsKeyKeyword_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "isKey", lv_isKey_11_0 != null, "isKey");
                    				

                    }


                    }
                    break;

            }

            // InternalArg.g:1159:3: ( (lv_readOnly_12_0= 'readOnly' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalArg.g:1160:4: (lv_readOnly_12_0= 'readOnly' )
                    {
                    // InternalArg.g:1160:4: (lv_readOnly_12_0= 'readOnly' )
                    // InternalArg.g:1161:5: lv_readOnly_12_0= 'readOnly'
                    {
                    lv_readOnly_12_0=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_readOnly_12_0, grammarAccess.getAttributeAccess().getReadOnlyReadOnlyKeyword_12_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "readOnly", lv_readOnly_12_0 != null, "readOnly");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeMax"
    // InternalArg.g:1177:1: entryRuleAttributeMax returns [String current=null] : iv_ruleAttributeMax= ruleAttributeMax EOF ;
    public final String entryRuleAttributeMax() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAttributeMax = null;


        try {
            // InternalArg.g:1177:52: (iv_ruleAttributeMax= ruleAttributeMax EOF )
            // InternalArg.g:1178:2: iv_ruleAttributeMax= ruleAttributeMax EOF
            {
             newCompositeNode(grammarAccess.getAttributeMaxRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeMax=ruleAttributeMax();

            state._fsp--;

             current =iv_ruleAttributeMax.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeMax"


    // $ANTLR start "ruleAttributeMax"
    // InternalArg.g:1184:1: ruleAttributeMax returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleAttributeMax() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalArg.g:1190:2: ( (kw= '*' | this_INT_1= RULE_INT ) )
            // InternalArg.g:1191:2: (kw= '*' | this_INT_1= RULE_INT )
            {
            // InternalArg.g:1191:2: (kw= '*' | this_INT_1= RULE_INT )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_INT) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalArg.g:1192:3: kw= '*'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAttributeMaxAccess().getAsteriskKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:1198:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getAttributeMaxAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeMax"


    // $ANTLR start "entryRuleReference"
    // InternalArg.g:1209:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalArg.g:1209:50: (iv_ruleReference= ruleReference EOF )
            // InternalArg.g:1210:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalArg.g:1216:1: ruleReference returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )? otherlv_3= 'min' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= 'max' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= 'target' ( (lv_target_8_0= ruleEString ) ) (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_containtment_2_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;

        AntlrDatatypeRuleToken lv_target_8_0 = null;

        AntlrDatatypeRuleToken lv_opposite_10_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1222:2: ( ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )? otherlv_3= 'min' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= 'max' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= 'target' ( (lv_target_8_0= ruleEString ) ) (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )? ) )
            // InternalArg.g:1223:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )? otherlv_3= 'min' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= 'max' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= 'target' ( (lv_target_8_0= ruleEString ) ) (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )? )
            {
            // InternalArg.g:1223:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )? otherlv_3= 'min' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= 'max' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= 'target' ( (lv_target_8_0= ruleEString ) ) (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )? )
            // InternalArg.g:1224:3: ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )? otherlv_3= 'min' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= 'max' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= 'target' ( (lv_target_8_0= ruleEString ) ) (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )?
            {
            // InternalArg.g:1224:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:1225:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:1225:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:1226:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getReferenceAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_36);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:1243:3: (otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalArg.g:1244:4: otherlv_1= 'containtment' ( (lv_containtment_2_0= ruleEString ) )
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getContaintmentKeyword_1_0());
                    			
                    // InternalArg.g:1248:4: ( (lv_containtment_2_0= ruleEString ) )
                    // InternalArg.g:1249:5: (lv_containtment_2_0= ruleEString )
                    {
                    // InternalArg.g:1249:5: (lv_containtment_2_0= ruleEString )
                    // InternalArg.g:1250:6: lv_containtment_2_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getReferenceAccess().getContaintmentEStringParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_containtment_2_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferenceRule());
                    						}
                    						set(
                    							current,
                    							"containtment",
                    							lv_containtment_2_0,
                    							"arg.Arg.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,40,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getMinKeyword_2());
            		
            // InternalArg.g:1272:3: ( (lv_min_4_0= ruleEInt ) )
            // InternalArg.g:1273:4: (lv_min_4_0= ruleEInt )
            {
            // InternalArg.g:1273:4: (lv_min_4_0= ruleEInt )
            // InternalArg.g:1274:5: lv_min_4_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getReferenceAccess().getMinEIntParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_38);
            lv_min_4_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_4_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_27); 

            			newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getMaxKeyword_4());
            		
            // InternalArg.g:1295:3: ( (lv_max_6_0= ruleEInt ) )
            // InternalArg.g:1296:4: (lv_max_6_0= ruleEInt )
            {
            // InternalArg.g:1296:4: (lv_max_6_0= ruleEInt )
            // InternalArg.g:1297:5: lv_max_6_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getReferenceAccess().getMaxEIntParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_39);
            lv_max_6_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceRule());
            					}
            					set(
            						current,
            						"max",
            						lv_max_6_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getReferenceAccess().getTargetKeyword_6());
            		
            // InternalArg.g:1318:3: ( (lv_target_8_0= ruleEString ) )
            // InternalArg.g:1319:4: (lv_target_8_0= ruleEString )
            {
            // InternalArg.g:1319:4: (lv_target_8_0= ruleEString )
            // InternalArg.g:1320:5: lv_target_8_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getReferenceAccess().getTargetEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_40);
            lv_target_8_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceRule());
            					}
            					set(
            						current,
            						"target",
            						lv_target_8_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:1337:3: (otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==43) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalArg.g:1338:4: otherlv_9= 'opposite' ( (lv_opposite_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,43,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getOppositeKeyword_8_0());
                    			
                    // InternalArg.g:1342:4: ( (lv_opposite_10_0= ruleEString ) )
                    // InternalArg.g:1343:5: (lv_opposite_10_0= ruleEString )
                    {
                    // InternalArg.g:1343:5: (lv_opposite_10_0= ruleEString )
                    // InternalArg.g:1344:6: lv_opposite_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getReferenceAccess().getOppositeEStringParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_opposite_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferenceRule());
                    						}
                    						set(
                    							current,
                    							"opposite",
                    							lv_opposite_10_0,
                    							"arg.Arg.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleEInt"
    // InternalArg.g:1366:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalArg.g:1366:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalArg.g:1367:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalArg.g:1373:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalArg.g:1379:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalArg.g:1380:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalArg.g:1380:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalArg.g:1381:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalArg.g:1381:3: (kw= '-' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalArg.g:1382:4: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_41); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleGraphicClass"
    // InternalArg.g:1399:1: entryRuleGraphicClass returns [EObject current=null] : iv_ruleGraphicClass= ruleGraphicClass EOF ;
    public final EObject entryRuleGraphicClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGraphicClass = null;


        try {
            // InternalArg.g:1399:53: (iv_ruleGraphicClass= ruleGraphicClass EOF )
            // InternalArg.g:1400:2: iv_ruleGraphicClass= ruleGraphicClass EOF
            {
             newCompositeNode(grammarAccess.getGraphicClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGraphicClass=ruleGraphicClass();

            state._fsp--;

             current =iv_ruleGraphicClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphicClass"


    // $ANTLR start "ruleGraphicClass"
    // InternalArg.g:1406:1: ruleGraphicClass returns [EObject current=null] : (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'versions' otherlv_3= '{' ( (lv_versions_4_0= ruleVersions ) ) ( (lv_versions_5_0= ruleVersions ) )* otherlv_6= '}' otherlv_7= 'constraints' otherlv_8= '{' ( (lv_constraints_9_0= ruleConstraints ) ) otherlv_10= '}' ) ;
    public final EObject ruleGraphicClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_versions_4_0 = null;

        EObject lv_versions_5_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1412:2: ( (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'versions' otherlv_3= '{' ( (lv_versions_4_0= ruleVersions ) ) ( (lv_versions_5_0= ruleVersions ) )* otherlv_6= '}' otherlv_7= 'constraints' otherlv_8= '{' ( (lv_constraints_9_0= ruleConstraints ) ) otherlv_10= '}' ) )
            // InternalArg.g:1413:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'versions' otherlv_3= '{' ( (lv_versions_4_0= ruleVersions ) ) ( (lv_versions_5_0= ruleVersions ) )* otherlv_6= '}' otherlv_7= 'constraints' otherlv_8= '{' ( (lv_constraints_9_0= ruleConstraints ) ) otherlv_10= '}' )
            {
            // InternalArg.g:1413:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'versions' otherlv_3= '{' ( (lv_versions_4_0= ruleVersions ) ) ( (lv_versions_5_0= ruleVersions ) )* otherlv_6= '}' otherlv_7= 'constraints' otherlv_8= '{' ( (lv_constraints_9_0= ruleConstraints ) ) otherlv_10= '}' )
            // InternalArg.g:1414:3: otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'versions' otherlv_3= '{' ( (lv_versions_4_0= ruleVersions ) ) ( (lv_versions_5_0= ruleVersions ) )* otherlv_6= '}' otherlv_7= 'constraints' otherlv_8= '{' ( (lv_constraints_9_0= ruleConstraints ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGraphicClassAccess().getElementKeyword_0());
            		
            // InternalArg.g:1418:3: ( ( ruleEString ) )
            // InternalArg.g:1419:4: ( ruleEString )
            {
            // InternalArg.g:1419:4: ( ruleEString )
            // InternalArg.g:1420:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGraphicClassRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGraphicClassAccess().getOntoClassClassCrossReference_1_0());
            				
            pushFollow(FOLLOW_42);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getGraphicClassAccess().getVersionsKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalArg.g:1442:3: ( (lv_versions_4_0= ruleVersions ) )
            // InternalArg.g:1443:4: (lv_versions_4_0= ruleVersions )
            {
            // InternalArg.g:1443:4: (lv_versions_4_0= ruleVersions )
            // InternalArg.g:1444:5: lv_versions_4_0= ruleVersions
            {

            					newCompositeNode(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_versions_4_0=ruleVersions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGraphicClassRule());
            					}
            					add(
            						current,
            						"versions",
            						lv_versions_4_0,
            						"arg.Arg.Versions");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:1461:3: ( (lv_versions_5_0= ruleVersions ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_ID)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalArg.g:1462:4: (lv_versions_5_0= ruleVersions )
            	    {
            	    // InternalArg.g:1462:4: (lv_versions_5_0= ruleVersions )
            	    // InternalArg.g:1463:5: lv_versions_5_0= ruleVersions
            	    {

            	    					newCompositeNode(grammarAccess.getGraphicClassAccess().getVersionsVersionsParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_versions_5_0=ruleVersions();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGraphicClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"versions",
            	    						lv_versions_5_0,
            	    						"arg.Arg.Versions");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_43); 

            			newLeafNode(otherlv_6, grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_7=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getGraphicClassAccess().getConstraintsKeyword_7());
            		
            otherlv_8=(Token)match(input,12,FOLLOW_44); 

            			newLeafNode(otherlv_8, grammarAccess.getGraphicClassAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalArg.g:1492:3: ( (lv_constraints_9_0= ruleConstraints ) )
            // InternalArg.g:1493:4: (lv_constraints_9_0= ruleConstraints )
            {
            // InternalArg.g:1493:4: (lv_constraints_9_0= ruleConstraints )
            // InternalArg.g:1494:5: lv_constraints_9_0= ruleConstraints
            {

            					newCompositeNode(grammarAccess.getGraphicClassAccess().getConstraintsConstraintsParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_7);
            lv_constraints_9_0=ruleConstraints();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGraphicClassRule());
            					}
            					set(
            						current,
            						"constraints",
            						lv_constraints_9_0,
            						"arg.Arg.Constraints");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getGraphicClassAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphicClass"


    // $ANTLR start "entryRuleConstraints"
    // InternalArg.g:1519:1: entryRuleConstraints returns [EObject current=null] : iv_ruleConstraints= ruleConstraints EOF ;
    public final EObject entryRuleConstraints() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraints = null;


        try {
            // InternalArg.g:1519:52: (iv_ruleConstraints= ruleConstraints EOF )
            // InternalArg.g:1520:2: iv_ruleConstraints= ruleConstraints EOF
            {
             newCompositeNode(grammarAccess.getConstraintsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraints=ruleConstraints();

            state._fsp--;

             current =iv_ruleConstraints; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraints"


    // $ANTLR start "ruleConstraints"
    // InternalArg.g:1526:1: ruleConstraints returns [EObject current=null] : (otherlv_0= 'plane' ( (lv_planes_1_0= rulePlanes ) ) ( (lv_overlapping_2_0= 'overlaps' ) ) otherlv_3= 'sizeMin' ( (lv_sizeMin_4_0= ruleEDouble ) ) otherlv_5= 'sizeMax' ( (lv_sizeMax_6_0= ruleEDouble ) ) otherlv_7= 'xVariation' ( (lv_xToOriginPos_8_0= ruleEDouble ) ) otherlv_9= 'yVariation' ( (lv_yToOriginPos_10_0= ruleEDouble ) ) otherlv_11= 'zVariation' ( (lv_zToOriginPos_12_0= ruleEDouble ) ) otherlv_13= 'rotation' ( (lv_rotation_14_0= ruleEInt ) ) ) ;
    public final EObject ruleConstraints() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_overlapping_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Enumerator lv_planes_1_0 = null;

        AntlrDatatypeRuleToken lv_sizeMin_4_0 = null;

        AntlrDatatypeRuleToken lv_sizeMax_6_0 = null;

        AntlrDatatypeRuleToken lv_xToOriginPos_8_0 = null;

        AntlrDatatypeRuleToken lv_yToOriginPos_10_0 = null;

        AntlrDatatypeRuleToken lv_zToOriginPos_12_0 = null;

        AntlrDatatypeRuleToken lv_rotation_14_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1532:2: ( (otherlv_0= 'plane' ( (lv_planes_1_0= rulePlanes ) ) ( (lv_overlapping_2_0= 'overlaps' ) ) otherlv_3= 'sizeMin' ( (lv_sizeMin_4_0= ruleEDouble ) ) otherlv_5= 'sizeMax' ( (lv_sizeMax_6_0= ruleEDouble ) ) otherlv_7= 'xVariation' ( (lv_xToOriginPos_8_0= ruleEDouble ) ) otherlv_9= 'yVariation' ( (lv_yToOriginPos_10_0= ruleEDouble ) ) otherlv_11= 'zVariation' ( (lv_zToOriginPos_12_0= ruleEDouble ) ) otherlv_13= 'rotation' ( (lv_rotation_14_0= ruleEInt ) ) ) )
            // InternalArg.g:1533:2: (otherlv_0= 'plane' ( (lv_planes_1_0= rulePlanes ) ) ( (lv_overlapping_2_0= 'overlaps' ) ) otherlv_3= 'sizeMin' ( (lv_sizeMin_4_0= ruleEDouble ) ) otherlv_5= 'sizeMax' ( (lv_sizeMax_6_0= ruleEDouble ) ) otherlv_7= 'xVariation' ( (lv_xToOriginPos_8_0= ruleEDouble ) ) otherlv_9= 'yVariation' ( (lv_yToOriginPos_10_0= ruleEDouble ) ) otherlv_11= 'zVariation' ( (lv_zToOriginPos_12_0= ruleEDouble ) ) otherlv_13= 'rotation' ( (lv_rotation_14_0= ruleEInt ) ) )
            {
            // InternalArg.g:1533:2: (otherlv_0= 'plane' ( (lv_planes_1_0= rulePlanes ) ) ( (lv_overlapping_2_0= 'overlaps' ) ) otherlv_3= 'sizeMin' ( (lv_sizeMin_4_0= ruleEDouble ) ) otherlv_5= 'sizeMax' ( (lv_sizeMax_6_0= ruleEDouble ) ) otherlv_7= 'xVariation' ( (lv_xToOriginPos_8_0= ruleEDouble ) ) otherlv_9= 'yVariation' ( (lv_yToOriginPos_10_0= ruleEDouble ) ) otherlv_11= 'zVariation' ( (lv_zToOriginPos_12_0= ruleEDouble ) ) otherlv_13= 'rotation' ( (lv_rotation_14_0= ruleEInt ) ) )
            // InternalArg.g:1534:3: otherlv_0= 'plane' ( (lv_planes_1_0= rulePlanes ) ) ( (lv_overlapping_2_0= 'overlaps' ) ) otherlv_3= 'sizeMin' ( (lv_sizeMin_4_0= ruleEDouble ) ) otherlv_5= 'sizeMax' ( (lv_sizeMax_6_0= ruleEDouble ) ) otherlv_7= 'xVariation' ( (lv_xToOriginPos_8_0= ruleEDouble ) ) otherlv_9= 'yVariation' ( (lv_yToOriginPos_10_0= ruleEDouble ) ) otherlv_11= 'zVariation' ( (lv_zToOriginPos_12_0= ruleEDouble ) ) otherlv_13= 'rotation' ( (lv_rotation_14_0= ruleEInt ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintsAccess().getPlaneKeyword_0());
            		
            // InternalArg.g:1538:3: ( (lv_planes_1_0= rulePlanes ) )
            // InternalArg.g:1539:4: (lv_planes_1_0= rulePlanes )
            {
            // InternalArg.g:1539:4: (lv_planes_1_0= rulePlanes )
            // InternalArg.g:1540:5: lv_planes_1_0= rulePlanes
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getPlanesPlanesEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_46);
            lv_planes_1_0=rulePlanes();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"planes",
            						lv_planes_1_0,
            						"arg.Arg.Planes");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:1557:3: ( (lv_overlapping_2_0= 'overlaps' ) )
            // InternalArg.g:1558:4: (lv_overlapping_2_0= 'overlaps' )
            {
            // InternalArg.g:1558:4: (lv_overlapping_2_0= 'overlaps' )
            // InternalArg.g:1559:5: lv_overlapping_2_0= 'overlaps'
            {
            lv_overlapping_2_0=(Token)match(input,49,FOLLOW_47); 

            					newLeafNode(lv_overlapping_2_0, grammarAccess.getConstraintsAccess().getOverlappingOverlapsKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintsRule());
            					}
            					setWithLastConsumed(current, "overlapping", lv_overlapping_2_0 != null, "overlaps");
            				

            }


            }

            otherlv_3=(Token)match(input,50,FOLLOW_48); 

            			newLeafNode(otherlv_3, grammarAccess.getConstraintsAccess().getSizeMinKeyword_3());
            		
            // InternalArg.g:1575:3: ( (lv_sizeMin_4_0= ruleEDouble ) )
            // InternalArg.g:1576:4: (lv_sizeMin_4_0= ruleEDouble )
            {
            // InternalArg.g:1576:4: (lv_sizeMin_4_0= ruleEDouble )
            // InternalArg.g:1577:5: lv_sizeMin_4_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getSizeMinEDoubleParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_49);
            lv_sizeMin_4_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"sizeMin",
            						lv_sizeMin_4_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,51,FOLLOW_48); 

            			newLeafNode(otherlv_5, grammarAccess.getConstraintsAccess().getSizeMaxKeyword_5());
            		
            // InternalArg.g:1598:3: ( (lv_sizeMax_6_0= ruleEDouble ) )
            // InternalArg.g:1599:4: (lv_sizeMax_6_0= ruleEDouble )
            {
            // InternalArg.g:1599:4: (lv_sizeMax_6_0= ruleEDouble )
            // InternalArg.g:1600:5: lv_sizeMax_6_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getSizeMaxEDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_50);
            lv_sizeMax_6_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"sizeMax",
            						lv_sizeMax_6_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,52,FOLLOW_48); 

            			newLeafNode(otherlv_7, grammarAccess.getConstraintsAccess().getXVariationKeyword_7());
            		
            // InternalArg.g:1621:3: ( (lv_xToOriginPos_8_0= ruleEDouble ) )
            // InternalArg.g:1622:4: (lv_xToOriginPos_8_0= ruleEDouble )
            {
            // InternalArg.g:1622:4: (lv_xToOriginPos_8_0= ruleEDouble )
            // InternalArg.g:1623:5: lv_xToOriginPos_8_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getXToOriginPosEDoubleParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_51);
            lv_xToOriginPos_8_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"xToOriginPos",
            						lv_xToOriginPos_8_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,53,FOLLOW_48); 

            			newLeafNode(otherlv_9, grammarAccess.getConstraintsAccess().getYVariationKeyword_9());
            		
            // InternalArg.g:1644:3: ( (lv_yToOriginPos_10_0= ruleEDouble ) )
            // InternalArg.g:1645:4: (lv_yToOriginPos_10_0= ruleEDouble )
            {
            // InternalArg.g:1645:4: (lv_yToOriginPos_10_0= ruleEDouble )
            // InternalArg.g:1646:5: lv_yToOriginPos_10_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getYToOriginPosEDoubleParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_52);
            lv_yToOriginPos_10_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"yToOriginPos",
            						lv_yToOriginPos_10_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,54,FOLLOW_48); 

            			newLeafNode(otherlv_11, grammarAccess.getConstraintsAccess().getZVariationKeyword_11());
            		
            // InternalArg.g:1667:3: ( (lv_zToOriginPos_12_0= ruleEDouble ) )
            // InternalArg.g:1668:4: (lv_zToOriginPos_12_0= ruleEDouble )
            {
            // InternalArg.g:1668:4: (lv_zToOriginPos_12_0= ruleEDouble )
            // InternalArg.g:1669:5: lv_zToOriginPos_12_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getZToOriginPosEDoubleParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_53);
            lv_zToOriginPos_12_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"zToOriginPos",
            						lv_zToOriginPos_12_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,55,FOLLOW_27); 

            			newLeafNode(otherlv_13, grammarAccess.getConstraintsAccess().getRotationKeyword_13());
            		
            // InternalArg.g:1690:3: ( (lv_rotation_14_0= ruleEInt ) )
            // InternalArg.g:1691:4: (lv_rotation_14_0= ruleEInt )
            {
            // InternalArg.g:1691:4: (lv_rotation_14_0= ruleEInt )
            // InternalArg.g:1692:5: lv_rotation_14_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getConstraintsAccess().getRotationEIntParserRuleCall_14_0());
            				
            pushFollow(FOLLOW_2);
            lv_rotation_14_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintsRule());
            					}
            					set(
            						current,
            						"rotation",
            						lv_rotation_14_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraints"


    // $ANTLR start "entryRuleVersions"
    // InternalArg.g:1713:1: entryRuleVersions returns [EObject current=null] : iv_ruleVersions= ruleVersions EOF ;
    public final EObject entryRuleVersions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersions = null;


        try {
            // InternalArg.g:1713:49: (iv_ruleVersions= ruleVersions EOF )
            // InternalArg.g:1714:2: iv_ruleVersions= ruleVersions EOF
            {
             newCompositeNode(grammarAccess.getVersionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersions=ruleVersions();

            state._fsp--;

             current =iv_ruleVersions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersions"


    // $ANTLR start "ruleVersions"
    // InternalArg.g:1720:1: ruleVersions returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' ( (lv_URL_2_0= ruleEString ) ) ) ;
    public final EObject ruleVersions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_URL_2_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1726:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' ( (lv_URL_2_0= ruleEString ) ) ) )
            // InternalArg.g:1727:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' ( (lv_URL_2_0= ruleEString ) ) )
            {
            // InternalArg.g:1727:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' ( (lv_URL_2_0= ruleEString ) ) )
            // InternalArg.g:1728:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' ( (lv_URL_2_0= ruleEString ) )
            {
            // InternalArg.g:1728:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:1729:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:1729:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:1730:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getVersionsAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVersionsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getVersionsAccess().getEqualsSignKeyword_1());
            		
            // InternalArg.g:1751:3: ( (lv_URL_2_0= ruleEString ) )
            // InternalArg.g:1752:4: (lv_URL_2_0= ruleEString )
            {
            // InternalArg.g:1752:4: (lv_URL_2_0= ruleEString )
            // InternalArg.g:1753:5: lv_URL_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getVersionsAccess().getURLEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_URL_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVersionsRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_2_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersions"


    // $ANTLR start "entryRuleEDouble"
    // InternalArg.g:1774:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalArg.g:1774:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalArg.g:1775:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalArg.g:1781:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalArg.g:1787:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalArg.g:1788:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalArg.g:1788:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalArg.g:1789:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalArg.g:1789:3: (kw= '-' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalArg.g:1790:4: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalArg.g:1796:3: (this_INT_1= RULE_INT )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalArg.g:1797:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_55); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,56,FOLLOW_41); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_56); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalArg.g:1817:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=57 && LA33_0<=58)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalArg.g:1818:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalArg.g:1818:4: (kw= 'E' | kw= 'e' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==57) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==58) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalArg.g:1819:5: kw= 'E'
                            {
                            kw=(Token)match(input,57,FOLLOW_27); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalArg.g:1825:5: kw= 'e'
                            {
                            kw=(Token)match(input,58,FOLLOW_27); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalArg.g:1831:4: (kw= '-' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==44) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalArg.g:1832:5: kw= '-'
                            {
                            kw=(Token)match(input,44,FOLLOW_41); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_7);
                    			

                    				newLeafNode(this_INT_7, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRulePhysicClass"
    // InternalArg.g:1850:1: entryRulePhysicClass returns [EObject current=null] : iv_rulePhysicClass= rulePhysicClass EOF ;
    public final EObject entryRulePhysicClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicClass = null;


        try {
            // InternalArg.g:1850:52: (iv_rulePhysicClass= rulePhysicClass EOF )
            // InternalArg.g:1851:2: iv_rulePhysicClass= rulePhysicClass EOF
            {
             newCompositeNode(grammarAccess.getPhysicClassRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicClass=rulePhysicClass();

            state._fsp--;

             current =iv_rulePhysicClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicClass"


    // $ANTLR start "rulePhysicClass"
    // InternalArg.g:1857:1: rulePhysicClass returns [EObject current=null] : (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'body' otherlv_3= '{' ( (lv_physicBody_4_0= rulePhysicBody ) ) otherlv_5= '}' (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )? (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )? ) ;
    public final EObject rulePhysicClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_physicBody_4_0 = null;

        EObject lv_forces_8_0 = null;

        EObject lv_forces_9_0 = null;

        EObject lv_bitMasks_13_0 = null;



        	enterRule();

        try {
            // InternalArg.g:1863:2: ( (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'body' otherlv_3= '{' ( (lv_physicBody_4_0= rulePhysicBody ) ) otherlv_5= '}' (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )? (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )? ) )
            // InternalArg.g:1864:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'body' otherlv_3= '{' ( (lv_physicBody_4_0= rulePhysicBody ) ) otherlv_5= '}' (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )? (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )? )
            {
            // InternalArg.g:1864:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'body' otherlv_3= '{' ( (lv_physicBody_4_0= rulePhysicBody ) ) otherlv_5= '}' (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )? (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )? )
            // InternalArg.g:1865:3: otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'body' otherlv_3= '{' ( (lv_physicBody_4_0= rulePhysicBody ) ) otherlv_5= '}' (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )? (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPhysicClassAccess().getElementKeyword_0());
            		
            // InternalArg.g:1869:3: ( ( ruleEString ) )
            // InternalArg.g:1870:4: ( ruleEString )
            {
            // InternalArg.g:1870:4: ( ruleEString )
            // InternalArg.g:1871:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPhysicClassRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPhysicClassAccess().getOntoClassClassCrossReference_1_0());
            				
            pushFollow(FOLLOW_57);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,59,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPhysicClassAccess().getBodyKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalArg.g:1893:3: ( (lv_physicBody_4_0= rulePhysicBody ) )
            // InternalArg.g:1894:4: (lv_physicBody_4_0= rulePhysicBody )
            {
            // InternalArg.g:1894:4: (lv_physicBody_4_0= rulePhysicBody )
            // InternalArg.g:1895:5: lv_physicBody_4_0= rulePhysicBody
            {

            					newCompositeNode(grammarAccess.getPhysicClassAccess().getPhysicBodyPhysicBodyParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_physicBody_4_0=rulePhysicBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicClassRule());
            					}
            					set(
            						current,
            						"physicBody",
            						lv_physicBody_4_0,
            						"arg.Arg.PhysicBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_59); 

            			newLeafNode(otherlv_5, grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_5());
            		
            // InternalArg.g:1916:3: (otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalArg.g:1917:4: otherlv_6= 'forces' otherlv_7= '{' ( (lv_forces_8_0= ruleForce ) ) ( (lv_forces_9_0= ruleForce ) )* otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,60,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getPhysicClassAccess().getForcesKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalArg.g:1925:4: ( (lv_forces_8_0= ruleForce ) )
                    // InternalArg.g:1926:5: (lv_forces_8_0= ruleForce )
                    {
                    // InternalArg.g:1926:5: (lv_forces_8_0= ruleForce )
                    // InternalArg.g:1927:6: lv_forces_8_0= ruleForce
                    {

                    						newCompositeNode(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_forces_8_0=ruleForce();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicClassRule());
                    						}
                    						add(
                    							current,
                    							"forces",
                    							lv_forces_8_0,
                    							"arg.Arg.Force");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:1944:4: ( (lv_forces_9_0= ruleForce ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_ID)) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalArg.g:1945:5: (lv_forces_9_0= ruleForce )
                    	    {
                    	    // InternalArg.g:1945:5: (lv_forces_9_0= ruleForce )
                    	    // InternalArg.g:1946:6: lv_forces_9_0= ruleForce
                    	    {

                    	    						newCompositeNode(grammarAccess.getPhysicClassAccess().getForcesForceParserRuleCall_6_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_forces_9_0=ruleForce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPhysicClassRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"forces",
                    	    							lv_forces_9_0,
                    	    							"arg.Arg.Force");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,14,FOLLOW_60); 

                    				newLeafNode(otherlv_10, grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalArg.g:1968:3: (otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==61) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalArg.g:1969:4: otherlv_11= 'contacts' otherlv_12= '{' ( (lv_bitMasks_13_0= ruleBitMasks ) ) otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,61,FOLLOW_4); 

                    				newLeafNode(otherlv_11, grammarAccess.getPhysicClassAccess().getContactsKeyword_7_0());
                    			
                    otherlv_12=(Token)match(input,12,FOLLOW_61); 

                    				newLeafNode(otherlv_12, grammarAccess.getPhysicClassAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalArg.g:1977:4: ( (lv_bitMasks_13_0= ruleBitMasks ) )
                    // InternalArg.g:1978:5: (lv_bitMasks_13_0= ruleBitMasks )
                    {
                    // InternalArg.g:1978:5: (lv_bitMasks_13_0= ruleBitMasks )
                    // InternalArg.g:1979:6: lv_bitMasks_13_0= ruleBitMasks
                    {

                    						newCompositeNode(grammarAccess.getPhysicClassAccess().getBitMasksBitMasksParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_bitMasks_13_0=ruleBitMasks();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicClassRule());
                    						}
                    						set(
                    							current,
                    							"bitMasks",
                    							lv_bitMasks_13_0,
                    							"arg.Arg.BitMasks");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getPhysicClassAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicClass"


    // $ANTLR start "entryRulePhysicBody"
    // InternalArg.g:2005:1: entryRulePhysicBody returns [EObject current=null] : iv_rulePhysicBody= rulePhysicBody EOF ;
    public final EObject entryRulePhysicBody() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicBody = null;


        try {
            // InternalArg.g:2005:51: (iv_rulePhysicBody= rulePhysicBody EOF )
            // InternalArg.g:2006:2: iv_rulePhysicBody= rulePhysicBody EOF
            {
             newCompositeNode(grammarAccess.getPhysicBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicBody=rulePhysicBody();

            state._fsp--;

             current =iv_rulePhysicBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicBody"


    // $ANTLR start "rulePhysicBody"
    // InternalArg.g:2012:1: rulePhysicBody returns [EObject current=null] : (otherlv_0= 'mass' ( (lv_mass_1_0= ruleEDouble ) ) otherlv_2= 'bodyType' ( (lv_bodyType_3_0= ruleBodyType ) ) otherlv_4= 'charge' ( (lv_charge_5_0= ruleEDouble ) ) otherlv_6= 'friction' ( (lv_friction_7_0= ruleEDouble ) ) otherlv_8= 'rollingFriction' ( (lv_rollingFriction_9_0= ruleEDouble ) ) otherlv_10= 'restitution' ( (lv_restitution_11_0= ruleEDouble ) ) otherlv_12= 'damping' ( (lv_damping_13_0= ruleEDouble ) ) otherlv_14= 'angularDamping' ( (lv_angularDamping_15_0= ruleEDouble ) ) ) ;
    public final EObject rulePhysicBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_mass_1_0 = null;

        Enumerator lv_bodyType_3_0 = null;

        AntlrDatatypeRuleToken lv_charge_5_0 = null;

        AntlrDatatypeRuleToken lv_friction_7_0 = null;

        AntlrDatatypeRuleToken lv_rollingFriction_9_0 = null;

        AntlrDatatypeRuleToken lv_restitution_11_0 = null;

        AntlrDatatypeRuleToken lv_damping_13_0 = null;

        AntlrDatatypeRuleToken lv_angularDamping_15_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2018:2: ( (otherlv_0= 'mass' ( (lv_mass_1_0= ruleEDouble ) ) otherlv_2= 'bodyType' ( (lv_bodyType_3_0= ruleBodyType ) ) otherlv_4= 'charge' ( (lv_charge_5_0= ruleEDouble ) ) otherlv_6= 'friction' ( (lv_friction_7_0= ruleEDouble ) ) otherlv_8= 'rollingFriction' ( (lv_rollingFriction_9_0= ruleEDouble ) ) otherlv_10= 'restitution' ( (lv_restitution_11_0= ruleEDouble ) ) otherlv_12= 'damping' ( (lv_damping_13_0= ruleEDouble ) ) otherlv_14= 'angularDamping' ( (lv_angularDamping_15_0= ruleEDouble ) ) ) )
            // InternalArg.g:2019:2: (otherlv_0= 'mass' ( (lv_mass_1_0= ruleEDouble ) ) otherlv_2= 'bodyType' ( (lv_bodyType_3_0= ruleBodyType ) ) otherlv_4= 'charge' ( (lv_charge_5_0= ruleEDouble ) ) otherlv_6= 'friction' ( (lv_friction_7_0= ruleEDouble ) ) otherlv_8= 'rollingFriction' ( (lv_rollingFriction_9_0= ruleEDouble ) ) otherlv_10= 'restitution' ( (lv_restitution_11_0= ruleEDouble ) ) otherlv_12= 'damping' ( (lv_damping_13_0= ruleEDouble ) ) otherlv_14= 'angularDamping' ( (lv_angularDamping_15_0= ruleEDouble ) ) )
            {
            // InternalArg.g:2019:2: (otherlv_0= 'mass' ( (lv_mass_1_0= ruleEDouble ) ) otherlv_2= 'bodyType' ( (lv_bodyType_3_0= ruleBodyType ) ) otherlv_4= 'charge' ( (lv_charge_5_0= ruleEDouble ) ) otherlv_6= 'friction' ( (lv_friction_7_0= ruleEDouble ) ) otherlv_8= 'rollingFriction' ( (lv_rollingFriction_9_0= ruleEDouble ) ) otherlv_10= 'restitution' ( (lv_restitution_11_0= ruleEDouble ) ) otherlv_12= 'damping' ( (lv_damping_13_0= ruleEDouble ) ) otherlv_14= 'angularDamping' ( (lv_angularDamping_15_0= ruleEDouble ) ) )
            // InternalArg.g:2020:3: otherlv_0= 'mass' ( (lv_mass_1_0= ruleEDouble ) ) otherlv_2= 'bodyType' ( (lv_bodyType_3_0= ruleBodyType ) ) otherlv_4= 'charge' ( (lv_charge_5_0= ruleEDouble ) ) otherlv_6= 'friction' ( (lv_friction_7_0= ruleEDouble ) ) otherlv_8= 'rollingFriction' ( (lv_rollingFriction_9_0= ruleEDouble ) ) otherlv_10= 'restitution' ( (lv_restitution_11_0= ruleEDouble ) ) otherlv_12= 'damping' ( (lv_damping_13_0= ruleEDouble ) ) otherlv_14= 'angularDamping' ( (lv_angularDamping_15_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getPhysicBodyAccess().getMassKeyword_0());
            		
            // InternalArg.g:2024:3: ( (lv_mass_1_0= ruleEDouble ) )
            // InternalArg.g:2025:4: (lv_mass_1_0= ruleEDouble )
            {
            // InternalArg.g:2025:4: (lv_mass_1_0= ruleEDouble )
            // InternalArg.g:2026:5: lv_mass_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getMassEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_62);
            lv_mass_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"mass",
            						lv_mass_1_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_63); 

            			newLeafNode(otherlv_2, grammarAccess.getPhysicBodyAccess().getBodyTypeKeyword_2());
            		
            // InternalArg.g:2047:3: ( (lv_bodyType_3_0= ruleBodyType ) )
            // InternalArg.g:2048:4: (lv_bodyType_3_0= ruleBodyType )
            {
            // InternalArg.g:2048:4: (lv_bodyType_3_0= ruleBodyType )
            // InternalArg.g:2049:5: lv_bodyType_3_0= ruleBodyType
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getBodyTypeBodyTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_bodyType_3_0=ruleBodyType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"bodyType",
            						lv_bodyType_3_0,
            						"arg.Arg.BodyType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,64,FOLLOW_48); 

            			newLeafNode(otherlv_4, grammarAccess.getPhysicBodyAccess().getChargeKeyword_4());
            		
            // InternalArg.g:2070:3: ( (lv_charge_5_0= ruleEDouble ) )
            // InternalArg.g:2071:4: (lv_charge_5_0= ruleEDouble )
            {
            // InternalArg.g:2071:4: (lv_charge_5_0= ruleEDouble )
            // InternalArg.g:2072:5: lv_charge_5_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getChargeEDoubleParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_65);
            lv_charge_5_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"charge",
            						lv_charge_5_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,65,FOLLOW_48); 

            			newLeafNode(otherlv_6, grammarAccess.getPhysicBodyAccess().getFrictionKeyword_6());
            		
            // InternalArg.g:2093:3: ( (lv_friction_7_0= ruleEDouble ) )
            // InternalArg.g:2094:4: (lv_friction_7_0= ruleEDouble )
            {
            // InternalArg.g:2094:4: (lv_friction_7_0= ruleEDouble )
            // InternalArg.g:2095:5: lv_friction_7_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getFrictionEDoubleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_66);
            lv_friction_7_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"friction",
            						lv_friction_7_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,66,FOLLOW_48); 

            			newLeafNode(otherlv_8, grammarAccess.getPhysicBodyAccess().getRollingFrictionKeyword_8());
            		
            // InternalArg.g:2116:3: ( (lv_rollingFriction_9_0= ruleEDouble ) )
            // InternalArg.g:2117:4: (lv_rollingFriction_9_0= ruleEDouble )
            {
            // InternalArg.g:2117:4: (lv_rollingFriction_9_0= ruleEDouble )
            // InternalArg.g:2118:5: lv_rollingFriction_9_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getRollingFrictionEDoubleParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_67);
            lv_rollingFriction_9_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"rollingFriction",
            						lv_rollingFriction_9_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,67,FOLLOW_48); 

            			newLeafNode(otherlv_10, grammarAccess.getPhysicBodyAccess().getRestitutionKeyword_10());
            		
            // InternalArg.g:2139:3: ( (lv_restitution_11_0= ruleEDouble ) )
            // InternalArg.g:2140:4: (lv_restitution_11_0= ruleEDouble )
            {
            // InternalArg.g:2140:4: (lv_restitution_11_0= ruleEDouble )
            // InternalArg.g:2141:5: lv_restitution_11_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getRestitutionEDoubleParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_68);
            lv_restitution_11_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"restitution",
            						lv_restitution_11_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,68,FOLLOW_48); 

            			newLeafNode(otherlv_12, grammarAccess.getPhysicBodyAccess().getDampingKeyword_12());
            		
            // InternalArg.g:2162:3: ( (lv_damping_13_0= ruleEDouble ) )
            // InternalArg.g:2163:4: (lv_damping_13_0= ruleEDouble )
            {
            // InternalArg.g:2163:4: (lv_damping_13_0= ruleEDouble )
            // InternalArg.g:2164:5: lv_damping_13_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getDampingEDoubleParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_69);
            lv_damping_13_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"damping",
            						lv_damping_13_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,69,FOLLOW_48); 

            			newLeafNode(otherlv_14, grammarAccess.getPhysicBodyAccess().getAngularDampingKeyword_14());
            		
            // InternalArg.g:2185:3: ( (lv_angularDamping_15_0= ruleEDouble ) )
            // InternalArg.g:2186:4: (lv_angularDamping_15_0= ruleEDouble )
            {
            // InternalArg.g:2186:4: (lv_angularDamping_15_0= ruleEDouble )
            // InternalArg.g:2187:5: lv_angularDamping_15_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPhysicBodyAccess().getAngularDampingEDoubleParserRuleCall_15_0());
            				
            pushFollow(FOLLOW_2);
            lv_angularDamping_15_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicBodyRule());
            					}
            					set(
            						current,
            						"angularDamping",
            						lv_angularDamping_15_0,
            						"arg.Arg.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicBody"


    // $ANTLR start "entryRuleBitMasks"
    // InternalArg.g:2208:1: entryRuleBitMasks returns [EObject current=null] : iv_ruleBitMasks= ruleBitMasks EOF ;
    public final EObject entryRuleBitMasks() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitMasks = null;


        try {
            // InternalArg.g:2208:49: (iv_ruleBitMasks= ruleBitMasks EOF )
            // InternalArg.g:2209:2: iv_ruleBitMasks= ruleBitMasks EOF
            {
             newCompositeNode(grammarAccess.getBitMasksRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBitMasks=ruleBitMasks();

            state._fsp--;

             current =iv_ruleBitMasks; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitMasks"


    // $ANTLR start "ruleBitMasks"
    // InternalArg.g:2215:1: ruleBitMasks returns [EObject current=null] : (otherlv_0= 'collision' ( ( ruleEString ) ) ( ( ruleEString ) )* otherlv_3= 'contact' ( ( ruleEString ) ) ( ( ruleEString ) )* ) ;
    public final EObject ruleBitMasks() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalArg.g:2221:2: ( (otherlv_0= 'collision' ( ( ruleEString ) ) ( ( ruleEString ) )* otherlv_3= 'contact' ( ( ruleEString ) ) ( ( ruleEString ) )* ) )
            // InternalArg.g:2222:2: (otherlv_0= 'collision' ( ( ruleEString ) ) ( ( ruleEString ) )* otherlv_3= 'contact' ( ( ruleEString ) ) ( ( ruleEString ) )* )
            {
            // InternalArg.g:2222:2: (otherlv_0= 'collision' ( ( ruleEString ) ) ( ( ruleEString ) )* otherlv_3= 'contact' ( ( ruleEString ) ) ( ( ruleEString ) )* )
            // InternalArg.g:2223:3: otherlv_0= 'collision' ( ( ruleEString ) ) ( ( ruleEString ) )* otherlv_3= 'contact' ( ( ruleEString ) ) ( ( ruleEString ) )*
            {
            otherlv_0=(Token)match(input,70,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBitMasksAccess().getCollisionKeyword_0());
            		
            // InternalArg.g:2227:3: ( ( ruleEString ) )
            // InternalArg.g:2228:4: ( ruleEString )
            {
            // InternalArg.g:2228:4: ( ruleEString )
            // InternalArg.g:2229:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBitMasksRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_1_0());
            				
            pushFollow(FOLLOW_70);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:2243:3: ( ( ruleEString ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalArg.g:2244:4: ( ruleEString )
            	    {
            	    // InternalArg.g:2244:4: ( ruleEString )
            	    // InternalArg.g:2245:5: ruleEString
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getBitMasksRule());
            	    					}
            	    				

            	    					newCompositeNode(grammarAccess.getBitMasksAccess().getCollisionClassCrossReference_2_0());
            	    				
            	    pushFollow(FOLLOW_70);
            	    ruleEString();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_3=(Token)match(input,71,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getBitMasksAccess().getContactKeyword_3());
            		
            // InternalArg.g:2263:3: ( ( ruleEString ) )
            // InternalArg.g:2264:4: ( ruleEString )
            {
            // InternalArg.g:2264:4: ( ruleEString )
            // InternalArg.g:2265:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBitMasksRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBitMasksAccess().getContactClassCrossReference_4_0());
            				
            pushFollow(FOLLOW_71);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:2279:3: ( ( ruleEString ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalArg.g:2280:4: ( ruleEString )
            	    {
            	    // InternalArg.g:2280:4: ( ruleEString )
            	    // InternalArg.g:2281:5: ruleEString
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getBitMasksRule());
            	    					}
            	    				

            	    					newCompositeNode(grammarAccess.getBitMasksAccess().getContactClassCrossReference_5_0());
            	    				
            	    pushFollow(FOLLOW_71);
            	    ruleEString();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitMasks"


    // $ANTLR start "entryRuleForce"
    // InternalArg.g:2299:1: entryRuleForce returns [EObject current=null] : iv_ruleForce= ruleForce EOF ;
    public final EObject entryRuleForce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForce = null;


        try {
            // InternalArg.g:2299:46: (iv_ruleForce= ruleForce EOF )
            // InternalArg.g:2300:2: iv_ruleForce= ruleForce EOF
            {
             newCompositeNode(grammarAccess.getForceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForce=ruleForce();

            state._fsp--;

             current =iv_ruleForce; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForce"


    // $ANTLR start "ruleForce"
    // InternalArg.g:2306:1: ruleForce returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'gesture' ( (lv_gesture_3_0= ruleGesture ) ) (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )? ) ;
    public final EObject ruleForce() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_gesture_3_0 = null;

        AntlrDatatypeRuleToken lv_xVector_5_0 = null;

        AntlrDatatypeRuleToken lv_yVector_7_0 = null;

        AntlrDatatypeRuleToken lv_zVector_9_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2312:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'gesture' ( (lv_gesture_3_0= ruleGesture ) ) (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )? ) )
            // InternalArg.g:2313:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'gesture' ( (lv_gesture_3_0= ruleGesture ) ) (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )? )
            {
            // InternalArg.g:2313:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'gesture' ( (lv_gesture_3_0= ruleGesture ) ) (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )? )
            // InternalArg.g:2314:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'gesture' ( (lv_gesture_3_0= ruleGesture ) ) (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )?
            {
            // InternalArg.g:2314:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:2315:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:2315:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:2316:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getForceAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_72); 

            			newLeafNode(otherlv_1, grammarAccess.getForceAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,72,FOLLOW_73); 

            			newLeafNode(otherlv_2, grammarAccess.getForceAccess().getGestureKeyword_2());
            		
            // InternalArg.g:2341:3: ( (lv_gesture_3_0= ruleGesture ) )
            // InternalArg.g:2342:4: (lv_gesture_3_0= ruleGesture )
            {
            // InternalArg.g:2342:4: (lv_gesture_3_0= ruleGesture )
            // InternalArg.g:2343:5: lv_gesture_3_0= ruleGesture
            {

            					newCompositeNode(grammarAccess.getForceAccess().getGestureGestureEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_74);
            lv_gesture_3_0=ruleGesture();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForceRule());
            					}
            					set(
            						current,
            						"gesture",
            						lv_gesture_3_0,
            						"arg.Arg.Gesture");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:2360:3: (otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalArg.g:2361:4: otherlv_4= '[' ( (lv_xVector_5_0= ruleEDouble ) ) otherlv_6= ',' ( (lv_yVector_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_zVector_9_0= ruleEDouble ) ) otherlv_10= ']'
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getForceAccess().getLeftSquareBracketKeyword_4_0());
                    			
                    // InternalArg.g:2365:4: ( (lv_xVector_5_0= ruleEDouble ) )
                    // InternalArg.g:2366:5: (lv_xVector_5_0= ruleEDouble )
                    {
                    // InternalArg.g:2366:5: (lv_xVector_5_0= ruleEDouble )
                    // InternalArg.g:2367:6: lv_xVector_5_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getForceAccess().getXVectorEDoubleParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_75);
                    lv_xVector_5_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getForceRule());
                    						}
                    						set(
                    							current,
                    							"xVector",
                    							lv_xVector_5_0,
                    							"arg.Arg.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,73,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getForceAccess().getCommaKeyword_4_2());
                    			
                    // InternalArg.g:2388:4: ( (lv_yVector_7_0= ruleEDouble ) )
                    // InternalArg.g:2389:5: (lv_yVector_7_0= ruleEDouble )
                    {
                    // InternalArg.g:2389:5: (lv_yVector_7_0= ruleEDouble )
                    // InternalArg.g:2390:6: lv_yVector_7_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getForceAccess().getYVectorEDoubleParserRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_75);
                    lv_yVector_7_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getForceRule());
                    						}
                    						set(
                    							current,
                    							"yVector",
                    							lv_yVector_7_0,
                    							"arg.Arg.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,73,FOLLOW_48); 

                    				newLeafNode(otherlv_8, grammarAccess.getForceAccess().getCommaKeyword_4_4());
                    			
                    // InternalArg.g:2411:4: ( (lv_zVector_9_0= ruleEDouble ) )
                    // InternalArg.g:2412:5: (lv_zVector_9_0= ruleEDouble )
                    {
                    // InternalArg.g:2412:5: (lv_zVector_9_0= ruleEDouble )
                    // InternalArg.g:2413:6: lv_zVector_9_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getForceAccess().getZVectorEDoubleParserRuleCall_4_5_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_zVector_9_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getForceRule());
                    						}
                    						set(
                    							current,
                    							"zVector",
                    							lv_zVector_9_0,
                    							"arg.Arg.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,33,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getForceAccess().getRightSquareBracketKeyword_4_6());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForce"


    // $ANTLR start "entryRuleGamePad"
    // InternalArg.g:2439:1: entryRuleGamePad returns [EObject current=null] : iv_ruleGamePad= ruleGamePad EOF ;
    public final EObject entryRuleGamePad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGamePad = null;


        try {
            // InternalArg.g:2439:48: (iv_ruleGamePad= ruleGamePad EOF )
            // InternalArg.g:2440:2: iv_ruleGamePad= ruleGamePad EOF
            {
             newCompositeNode(grammarAccess.getGamePadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGamePad=ruleGamePad();

            state._fsp--;

             current =iv_ruleGamePad; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGamePad"


    // $ANTLR start "ruleGamePad"
    // InternalArg.g:2446:1: ruleGamePad returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '->' ( ( ruleEString ) ) ) ;
    public final EObject ruleGamePad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2452:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '->' ( ( ruleEString ) ) ) )
            // InternalArg.g:2453:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '->' ( ( ruleEString ) ) )
            {
            // InternalArg.g:2453:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '->' ( ( ruleEString ) ) )
            // InternalArg.g:2454:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '->' ( ( ruleEString ) )
            {
            // InternalArg.g:2454:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:2455:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:2455:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:2456:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGamePadAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_76);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGamePadRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getGamePadAccess().getHyphenMinusGreaterThanSignKeyword_1());
            		
            // InternalArg.g:2477:3: ( ( ruleEString ) )
            // InternalArg.g:2478:4: ( ruleEString )
            {
            // InternalArg.g:2478:4: ( ruleEString )
            // InternalArg.g:2479:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGamePadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGamePadAccess().getTriggerTriggerCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGamePad"


    // $ANTLR start "entryRuleScoreSystem"
    // InternalArg.g:2497:1: entryRuleScoreSystem returns [EObject current=null] : iv_ruleScoreSystem= ruleScoreSystem EOF ;
    public final EObject entryRuleScoreSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScoreSystem = null;


        try {
            // InternalArg.g:2497:52: (iv_ruleScoreSystem= ruleScoreSystem EOF )
            // InternalArg.g:2498:2: iv_ruleScoreSystem= ruleScoreSystem EOF
            {
             newCompositeNode(grammarAccess.getScoreSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScoreSystem=ruleScoreSystem();

            state._fsp--;

             current =iv_ruleScoreSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScoreSystem"


    // $ANTLR start "ruleScoreSystem"
    // InternalArg.g:2504:1: ruleScoreSystem returns [EObject current=null] : (otherlv_0= 'start' ( (lv_start_1_0= ruleEInt ) ) otherlv_2= 'finish' ( (lv_finish_3_0= ruleNoLimit ) ) otherlv_4= 'lives' ( (lv_lives_5_0= ruleEInt ) ) ) ;
    public final EObject ruleScoreSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_start_1_0 = null;

        AntlrDatatypeRuleToken lv_finish_3_0 = null;

        AntlrDatatypeRuleToken lv_lives_5_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2510:2: ( (otherlv_0= 'start' ( (lv_start_1_0= ruleEInt ) ) otherlv_2= 'finish' ( (lv_finish_3_0= ruleNoLimit ) ) otherlv_4= 'lives' ( (lv_lives_5_0= ruleEInt ) ) ) )
            // InternalArg.g:2511:2: (otherlv_0= 'start' ( (lv_start_1_0= ruleEInt ) ) otherlv_2= 'finish' ( (lv_finish_3_0= ruleNoLimit ) ) otherlv_4= 'lives' ( (lv_lives_5_0= ruleEInt ) ) )
            {
            // InternalArg.g:2511:2: (otherlv_0= 'start' ( (lv_start_1_0= ruleEInt ) ) otherlv_2= 'finish' ( (lv_finish_3_0= ruleNoLimit ) ) otherlv_4= 'lives' ( (lv_lives_5_0= ruleEInt ) ) )
            // InternalArg.g:2512:3: otherlv_0= 'start' ( (lv_start_1_0= ruleEInt ) ) otherlv_2= 'finish' ( (lv_finish_3_0= ruleNoLimit ) ) otherlv_4= 'lives' ( (lv_lives_5_0= ruleEInt ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getScoreSystemAccess().getStartKeyword_0());
            		
            // InternalArg.g:2516:3: ( (lv_start_1_0= ruleEInt ) )
            // InternalArg.g:2517:4: (lv_start_1_0= ruleEInt )
            {
            // InternalArg.g:2517:4: (lv_start_1_0= ruleEInt )
            // InternalArg.g:2518:5: lv_start_1_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getScoreSystemAccess().getStartEIntParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_77);
            lv_start_1_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScoreSystemRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_1_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,75,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getScoreSystemAccess().getFinishKeyword_2());
            		
            // InternalArg.g:2539:3: ( (lv_finish_3_0= ruleNoLimit ) )
            // InternalArg.g:2540:4: (lv_finish_3_0= ruleNoLimit )
            {
            // InternalArg.g:2540:4: (lv_finish_3_0= ruleNoLimit )
            // InternalArg.g:2541:5: lv_finish_3_0= ruleNoLimit
            {

            					newCompositeNode(grammarAccess.getScoreSystemAccess().getFinishNoLimitParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_78);
            lv_finish_3_0=ruleNoLimit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScoreSystemRule());
            					}
            					set(
            						current,
            						"finish",
            						lv_finish_3_0,
            						"arg.Arg.NoLimit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,76,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getScoreSystemAccess().getLivesKeyword_4());
            		
            // InternalArg.g:2562:3: ( (lv_lives_5_0= ruleEInt ) )
            // InternalArg.g:2563:4: (lv_lives_5_0= ruleEInt )
            {
            // InternalArg.g:2563:4: (lv_lives_5_0= ruleEInt )
            // InternalArg.g:2564:5: lv_lives_5_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getScoreSystemAccess().getLivesEIntParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_lives_5_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScoreSystemRule());
            					}
            					set(
            						current,
            						"lives",
            						lv_lives_5_0,
            						"arg.Arg.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScoreSystem"


    // $ANTLR start "entryRuleNoLimit"
    // InternalArg.g:2585:1: entryRuleNoLimit returns [String current=null] : iv_ruleNoLimit= ruleNoLimit EOF ;
    public final String entryRuleNoLimit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoLimit = null;


        try {
            // InternalArg.g:2585:47: (iv_ruleNoLimit= ruleNoLimit EOF )
            // InternalArg.g:2586:2: iv_ruleNoLimit= ruleNoLimit EOF
            {
             newCompositeNode(grammarAccess.getNoLimitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNoLimit=ruleNoLimit();

            state._fsp--;

             current =iv_ruleNoLimit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoLimit"


    // $ANTLR start "ruleNoLimit"
    // InternalArg.g:2592:1: ruleNoLimit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleNoLimit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalArg.g:2598:2: ( (kw= '*' | this_INT_1= RULE_INT ) )
            // InternalArg.g:2599:2: (kw= '*' | this_INT_1= RULE_INT )
            {
            // InternalArg.g:2599:2: (kw= '*' | this_INT_1= RULE_INT )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==38) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_INT) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalArg.g:2600:3: kw= '*'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNoLimitAccess().getAsteriskKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:2606:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getNoLimitAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoLimit"


    // $ANTLR start "entryRuleTrigger"
    // InternalArg.g:2617:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalArg.g:2617:48: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalArg.g:2618:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // InternalArg.g:2624:1: ruleTrigger returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )? (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )? (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )? (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )? (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )? otherlv_15= '}' ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_action_3_0 = null;

        AntlrDatatypeRuleToken lv_message_5_0 = null;

        AntlrDatatypeRuleToken lv_scoreChange_7_0 = null;

        AntlrDatatypeRuleToken lv_timeTrigger_9_0 = null;

        EObject lv_physicChanges_12_0 = null;

        EObject lv_physicChanges_13_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2630:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )? (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )? (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )? (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )? (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalArg.g:2631:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )? (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )? (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )? (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )? (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalArg.g:2631:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )? (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )? (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )? (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )? (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )? otherlv_15= '}' )
            // InternalArg.g:2632:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )? (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )? (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )? (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )? (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )? otherlv_15= '}'
            {
            // InternalArg.g:2632:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:2633:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:2633:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:2634:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTriggerAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_79); 

            			newLeafNode(otherlv_1, grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalArg.g:2655:3: (otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==77) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalArg.g:2656:4: otherlv_2= 'action' ( (lv_action_3_0= ruleBasicActions ) )
                    {
                    otherlv_2=(Token)match(input,77,FOLLOW_80); 

                    				newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getActionKeyword_2_0());
                    			
                    // InternalArg.g:2660:4: ( (lv_action_3_0= ruleBasicActions ) )
                    // InternalArg.g:2661:5: (lv_action_3_0= ruleBasicActions )
                    {
                    // InternalArg.g:2661:5: (lv_action_3_0= ruleBasicActions )
                    // InternalArg.g:2662:6: lv_action_3_0= ruleBasicActions
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getActionBasicActionsEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_81);
                    lv_action_3_0=ruleBasicActions();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_3_0,
                    							"arg.Arg.BasicActions");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:2680:3: (otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==78) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalArg.g:2681:4: otherlv_4= 'message' ( (lv_message_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,78,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getTriggerAccess().getMessageKeyword_3_0());
                    			
                    // InternalArg.g:2685:4: ( (lv_message_5_0= ruleEString ) )
                    // InternalArg.g:2686:5: (lv_message_5_0= ruleEString )
                    {
                    // InternalArg.g:2686:5: (lv_message_5_0= ruleEString )
                    // InternalArg.g:2687:6: lv_message_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getMessageEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_message_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"message",
                    							lv_message_5_0,
                    							"arg.Arg.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:2705:3: (otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==25) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalArg.g:2706:4: otherlv_6= 'score' ( (lv_scoreChange_7_0= ruleEInt ) )
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_27); 

                    				newLeafNode(otherlv_6, grammarAccess.getTriggerAccess().getScoreKeyword_4_0());
                    			
                    // InternalArg.g:2710:4: ( (lv_scoreChange_7_0= ruleEInt ) )
                    // InternalArg.g:2711:5: (lv_scoreChange_7_0= ruleEInt )
                    {
                    // InternalArg.g:2711:5: (lv_scoreChange_7_0= ruleEInt )
                    // InternalArg.g:2712:6: lv_scoreChange_7_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getScoreChangeEIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_83);
                    lv_scoreChange_7_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"scoreChange",
                    							lv_scoreChange_7_0,
                    							"arg.Arg.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:2730:3: (otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==79) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalArg.g:2731:4: otherlv_8= 'timeEach' ( (lv_timeTrigger_9_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,79,FOLLOW_27); 

                    				newLeafNode(otherlv_8, grammarAccess.getTriggerAccess().getTimeEachKeyword_5_0());
                    			
                    // InternalArg.g:2735:4: ( (lv_timeTrigger_9_0= ruleEInt ) )
                    // InternalArg.g:2736:5: (lv_timeTrigger_9_0= ruleEInt )
                    {
                    // InternalArg.g:2736:5: (lv_timeTrigger_9_0= ruleEInt )
                    // InternalArg.g:2737:6: lv_timeTrigger_9_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getTimeTriggerEIntParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_84);
                    lv_timeTrigger_9_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"timeTrigger",
                    							lv_timeTrigger_9_0,
                    							"arg.Arg.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:2755:3: (otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==80) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalArg.g:2756:4: otherlv_10= 'changes' otherlv_11= '{' ( (lv_physicChanges_12_0= rulePhysicChange ) ) ( (lv_physicChanges_13_0= rulePhysicChange ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,80,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getTriggerAccess().getChangesKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,12,FOLLOW_85); 

                    				newLeafNode(otherlv_11, grammarAccess.getTriggerAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalArg.g:2764:4: ( (lv_physicChanges_12_0= rulePhysicChange ) )
                    // InternalArg.g:2765:5: (lv_physicChanges_12_0= rulePhysicChange )
                    {
                    // InternalArg.g:2765:5: (lv_physicChanges_12_0= rulePhysicChange )
                    // InternalArg.g:2766:6: lv_physicChanges_12_0= rulePhysicChange
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_86);
                    lv_physicChanges_12_0=rulePhysicChange();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						add(
                    							current,
                    							"physicChanges",
                    							lv_physicChanges_12_0,
                    							"arg.Arg.PhysicChange");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:2783:4: ( (lv_physicChanges_13_0= rulePhysicChange ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==85) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalArg.g:2784:5: (lv_physicChanges_13_0= rulePhysicChange )
                    	    {
                    	    // InternalArg.g:2784:5: (lv_physicChanges_13_0= rulePhysicChange )
                    	    // InternalArg.g:2785:6: lv_physicChanges_13_0= rulePhysicChange
                    	    {

                    	    						newCompositeNode(grammarAccess.getTriggerAccess().getPhysicChangesPhysicChangeParserRuleCall_6_3_0());
                    	    					
                    	    pushFollow(FOLLOW_86);
                    	    lv_physicChanges_13_0=rulePhysicChange();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"physicChanges",
                    	    							lv_physicChanges_13_0,
                    	    							"arg.Arg.PhysicChange");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getTriggerAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleCollision"
    // InternalArg.g:2815:1: entryRuleCollision returns [EObject current=null] : iv_ruleCollision= ruleCollision EOF ;
    public final EObject entryRuleCollision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollision = null;


        try {
            // InternalArg.g:2815:50: (iv_ruleCollision= ruleCollision EOF )
            // InternalArg.g:2816:2: iv_ruleCollision= ruleCollision EOF
            {
             newCompositeNode(grammarAccess.getCollisionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollision=ruleCollision();

            state._fsp--;

             current =iv_ruleCollision; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollision"


    // $ANTLR start "ruleCollision"
    // InternalArg.g:2822:1: ruleCollision returns [EObject current=null] : (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= '->' ( ( ruleEString ) ) ) ;
    public final EObject ruleCollision() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalArg.g:2828:2: ( (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= '->' ( ( ruleEString ) ) ) )
            // InternalArg.g:2829:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= '->' ( ( ruleEString ) ) )
            {
            // InternalArg.g:2829:2: (otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= '->' ( ( ruleEString ) ) )
            // InternalArg.g:2830:3: otherlv_0= 'element' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= '->' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCollisionAccess().getElementKeyword_0());
            		
            // InternalArg.g:2834:3: ( ( ruleEString ) )
            // InternalArg.g:2835:4: ( ruleEString )
            {
            // InternalArg.g:2835:4: ( ruleEString )
            // InternalArg.g:2836:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCollisionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCollisionAccess().getClassAClassCrossReference_1_0());
            				
            pushFollow(FOLLOW_87);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,81,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCollisionAccess().getToKeyword_2());
            		
            // InternalArg.g:2854:3: ( ( ruleEString ) )
            // InternalArg.g:2855:4: ( ruleEString )
            {
            // InternalArg.g:2855:4: ( ruleEString )
            // InternalArg.g:2856:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCollisionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCollisionAccess().getClassBClassCrossReference_3_0());
            				
            pushFollow(FOLLOW_76);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getCollisionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalArg.g:2874:3: ( ( ruleEString ) )
            // InternalArg.g:2875:4: ( ruleEString )
            {
            // InternalArg.g:2875:4: ( ruleEString )
            // InternalArg.g:2876:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCollisionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCollisionAccess().getActionTriggerCrossReference_5_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollision"


    // $ANTLR start "entryRuleObjInit"
    // InternalArg.g:2894:1: entryRuleObjInit returns [EObject current=null] : iv_ruleObjInit= ruleObjInit EOF ;
    public final EObject entryRuleObjInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjInit = null;


        try {
            // InternalArg.g:2894:48: (iv_ruleObjInit= ruleObjInit EOF )
            // InternalArg.g:2895:2: iv_ruleObjInit= ruleObjInit EOF
            {
             newCompositeNode(grammarAccess.getObjInitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjInit=ruleObjInit();

            state._fsp--;

             current =iv_ruleObjInit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjInit"


    // $ANTLR start "ruleObjInit"
    // InternalArg.g:2901:1: ruleObjInit returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( ( ruleEString ) ) otherlv_3= '[' ( (lv_posX_4_0= rulePosOrCamera ) ) otherlv_5= ',' ( (lv_posY_6_0= rulePosOrCamera ) ) otherlv_7= ',' ( (lv_posZ_8_0= rulePosOrCamera ) ) (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )? otherlv_11= ']' (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )? (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )? ) ;
    public final EObject ruleObjInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_posX_4_0 = null;

        AntlrDatatypeRuleToken lv_posY_6_0 = null;

        AntlrDatatypeRuleToken lv_posZ_8_0 = null;

        AntlrDatatypeRuleToken lv_rotation_10_0 = null;

        EObject lv_attribute_14_0 = null;

        EObject lv_attribute_16_0 = null;

        EObject lv_rules_20_0 = null;

        EObject lv_rules_22_0 = null;



        	enterRule();

        try {
            // InternalArg.g:2907:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( ( ruleEString ) ) otherlv_3= '[' ( (lv_posX_4_0= rulePosOrCamera ) ) otherlv_5= ',' ( (lv_posY_6_0= rulePosOrCamera ) ) otherlv_7= ',' ( (lv_posZ_8_0= rulePosOrCamera ) ) (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )? otherlv_11= ']' (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )? (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )? ) )
            // InternalArg.g:2908:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( ( ruleEString ) ) otherlv_3= '[' ( (lv_posX_4_0= rulePosOrCamera ) ) otherlv_5= ',' ( (lv_posY_6_0= rulePosOrCamera ) ) otherlv_7= ',' ( (lv_posZ_8_0= rulePosOrCamera ) ) (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )? otherlv_11= ']' (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )? (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )? )
            {
            // InternalArg.g:2908:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( ( ruleEString ) ) otherlv_3= '[' ( (lv_posX_4_0= rulePosOrCamera ) ) otherlv_5= ',' ( (lv_posY_6_0= rulePosOrCamera ) ) otherlv_7= ',' ( (lv_posZ_8_0= rulePosOrCamera ) ) (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )? otherlv_11= ']' (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )? (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )? )
            // InternalArg.g:2909:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( ( ruleEString ) ) otherlv_3= '[' ( (lv_posX_4_0= rulePosOrCamera ) ) otherlv_5= ',' ( (lv_posY_6_0= rulePosOrCamera ) ) otherlv_7= ',' ( (lv_posZ_8_0= rulePosOrCamera ) ) (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )? otherlv_11= ']' (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )? (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )?
            {
            // InternalArg.g:2909:3: ( (lv_name_0_0= ruleEString ) )
            // InternalArg.g:2910:4: (lv_name_0_0= ruleEString )
            {
            // InternalArg.g:2910:4: (lv_name_0_0= ruleEString )
            // InternalArg.g:2911:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getObjInitAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjInitRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getObjInitAccess().getColonKeyword_1());
            		
            // InternalArg.g:2932:3: ( ( ruleEString ) )
            // InternalArg.g:2933:4: ( ruleEString )
            {
            // InternalArg.g:2933:4: ( ruleEString )
            // InternalArg.g:2934:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjInitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getObjInitAccess().getClassClassCrossReference_2_0());
            				
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_88); 

            			newLeafNode(otherlv_3, grammarAccess.getObjInitAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalArg.g:2952:3: ( (lv_posX_4_0= rulePosOrCamera ) )
            // InternalArg.g:2953:4: (lv_posX_4_0= rulePosOrCamera )
            {
            // InternalArg.g:2953:4: (lv_posX_4_0= rulePosOrCamera )
            // InternalArg.g:2954:5: lv_posX_4_0= rulePosOrCamera
            {

            					newCompositeNode(grammarAccess.getObjInitAccess().getPosXPosOrCameraParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_75);
            lv_posX_4_0=rulePosOrCamera();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjInitRule());
            					}
            					set(
            						current,
            						"posX",
            						lv_posX_4_0,
            						"arg.Arg.PosOrCamera");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,73,FOLLOW_88); 

            			newLeafNode(otherlv_5, grammarAccess.getObjInitAccess().getCommaKeyword_5());
            		
            // InternalArg.g:2975:3: ( (lv_posY_6_0= rulePosOrCamera ) )
            // InternalArg.g:2976:4: (lv_posY_6_0= rulePosOrCamera )
            {
            // InternalArg.g:2976:4: (lv_posY_6_0= rulePosOrCamera )
            // InternalArg.g:2977:5: lv_posY_6_0= rulePosOrCamera
            {

            					newCompositeNode(grammarAccess.getObjInitAccess().getPosYPosOrCameraParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_75);
            lv_posY_6_0=rulePosOrCamera();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjInitRule());
            					}
            					set(
            						current,
            						"posY",
            						lv_posY_6_0,
            						"arg.Arg.PosOrCamera");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,73,FOLLOW_88); 

            			newLeafNode(otherlv_7, grammarAccess.getObjInitAccess().getCommaKeyword_7());
            		
            // InternalArg.g:2998:3: ( (lv_posZ_8_0= rulePosOrCamera ) )
            // InternalArg.g:2999:4: (lv_posZ_8_0= rulePosOrCamera )
            {
            // InternalArg.g:2999:4: (lv_posZ_8_0= rulePosOrCamera )
            // InternalArg.g:3000:5: lv_posZ_8_0= rulePosOrCamera
            {

            					newCompositeNode(grammarAccess.getObjInitAccess().getPosZPosOrCameraParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_89);
            lv_posZ_8_0=rulePosOrCamera();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjInitRule());
            					}
            					set(
            						current,
            						"posZ",
            						lv_posZ_8_0,
            						"arg.Arg.PosOrCamera");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:3017:3: (otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==73) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalArg.g:3018:4: otherlv_9= ',' ( (lv_rotation_10_0= ruleEInt ) )
                    {
                    otherlv_9=(Token)match(input,73,FOLLOW_27); 

                    				newLeafNode(otherlv_9, grammarAccess.getObjInitAccess().getCommaKeyword_9_0());
                    			
                    // InternalArg.g:3022:4: ( (lv_rotation_10_0= ruleEInt ) )
                    // InternalArg.g:3023:5: (lv_rotation_10_0= ruleEInt )
                    {
                    // InternalArg.g:3023:5: (lv_rotation_10_0= ruleEInt )
                    // InternalArg.g:3024:6: lv_rotation_10_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getObjInitAccess().getRotationEIntParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_rotation_10_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjInitRule());
                    						}
                    						set(
                    							current,
                    							"rotation",
                    							lv_rotation_10_0,
                    							"arg.Arg.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,33,FOLLOW_90); 

            			newLeafNode(otherlv_11, grammarAccess.getObjInitAccess().getRightSquareBracketKeyword_10());
            		
            // InternalArg.g:3046:3: (otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==82) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalArg.g:3047:4: otherlv_12= 'attributes' otherlv_13= '{' ( (lv_attribute_14_0= ruleObjAttribute ) ) (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )* otherlv_17= '}'
                    {
                    otherlv_12=(Token)match(input,82,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getObjInitAccess().getAttributesKeyword_11_0());
                    			
                    otherlv_13=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalArg.g:3055:4: ( (lv_attribute_14_0= ruleObjAttribute ) )
                    // InternalArg.g:3056:5: (lv_attribute_14_0= ruleObjAttribute )
                    {
                    // InternalArg.g:3056:5: (lv_attribute_14_0= ruleObjAttribute )
                    // InternalArg.g:3057:6: lv_attribute_14_0= ruleObjAttribute
                    {

                    						newCompositeNode(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_91);
                    lv_attribute_14_0=ruleObjAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjInitRule());
                    						}
                    						add(
                    							current,
                    							"attribute",
                    							lv_attribute_14_0,
                    							"arg.Arg.ObjAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:3074:4: (otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==73) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalArg.g:3075:5: otherlv_15= ',' ( (lv_attribute_16_0= ruleObjAttribute ) )
                    	    {
                    	    otherlv_15=(Token)match(input,73,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getObjInitAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalArg.g:3079:5: ( (lv_attribute_16_0= ruleObjAttribute ) )
                    	    // InternalArg.g:3080:6: (lv_attribute_16_0= ruleObjAttribute )
                    	    {
                    	    // InternalArg.g:3080:6: (lv_attribute_16_0= ruleObjAttribute )
                    	    // InternalArg.g:3081:7: lv_attribute_16_0= ruleObjAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getObjInitAccess().getAttributeObjAttributeParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_91);
                    	    lv_attribute_16_0=ruleObjAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getObjInitRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attribute",
                    	    								lv_attribute_16_0,
                    	    								"arg.Arg.ObjAttribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,14,FOLLOW_92); 

                    				newLeafNode(otherlv_17, grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_11_4());
                    			

                    }
                    break;

            }

            // InternalArg.g:3104:3: (otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==83) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalArg.g:3105:4: otherlv_18= 'rules' otherlv_19= '{' ( (lv_rules_20_0= ruleRule ) ) (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )* otherlv_23= '}'
                    {
                    otherlv_18=(Token)match(input,83,FOLLOW_4); 

                    				newLeafNode(otherlv_18, grammarAccess.getObjInitAccess().getRulesKeyword_12_0());
                    			
                    otherlv_19=(Token)match(input,12,FOLLOW_85); 

                    				newLeafNode(otherlv_19, grammarAccess.getObjInitAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalArg.g:3113:4: ( (lv_rules_20_0= ruleRule ) )
                    // InternalArg.g:3114:5: (lv_rules_20_0= ruleRule )
                    {
                    // InternalArg.g:3114:5: (lv_rules_20_0= ruleRule )
                    // InternalArg.g:3115:6: lv_rules_20_0= ruleRule
                    {

                    						newCompositeNode(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_2_0());
                    					
                    pushFollow(FOLLOW_91);
                    lv_rules_20_0=ruleRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjInitRule());
                    						}
                    						add(
                    							current,
                    							"rules",
                    							lv_rules_20_0,
                    							"arg.Arg.Rule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalArg.g:3132:4: (otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==73) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalArg.g:3133:5: otherlv_21= ',' ( (lv_rules_22_0= ruleRule ) )
                    	    {
                    	    otherlv_21=(Token)match(input,73,FOLLOW_85); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getObjInitAccess().getCommaKeyword_12_3_0());
                    	    				
                    	    // InternalArg.g:3137:5: ( (lv_rules_22_0= ruleRule ) )
                    	    // InternalArg.g:3138:6: (lv_rules_22_0= ruleRule )
                    	    {
                    	    // InternalArg.g:3138:6: (lv_rules_22_0= ruleRule )
                    	    // InternalArg.g:3139:7: lv_rules_22_0= ruleRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getObjInitAccess().getRulesRuleParserRuleCall_12_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_91);
                    	    lv_rules_22_0=ruleRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getObjInitRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"rules",
                    	    								lv_rules_22_0,
                    	    								"arg.Arg.Rule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getObjInitAccess().getRightCurlyBracketKeyword_12_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjInit"


    // $ANTLR start "entryRulePosOrCamera"
    // InternalArg.g:3166:1: entryRulePosOrCamera returns [String current=null] : iv_rulePosOrCamera= rulePosOrCamera EOF ;
    public final String entryRulePosOrCamera() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePosOrCamera = null;


        try {
            // InternalArg.g:3166:51: (iv_rulePosOrCamera= rulePosOrCamera EOF )
            // InternalArg.g:3167:2: iv_rulePosOrCamera= rulePosOrCamera EOF
            {
             newCompositeNode(grammarAccess.getPosOrCameraRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePosOrCamera=rulePosOrCamera();

            state._fsp--;

             current =iv_rulePosOrCamera.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePosOrCamera"


    // $ANTLR start "rulePosOrCamera"
    // InternalArg.g:3173:1: rulePosOrCamera returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'camera' | this_EDouble_1= ruleEDouble ) ;
    public final AntlrDatatypeRuleToken rulePosOrCamera() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EDouble_1 = null;



        	enterRule();

        try {
            // InternalArg.g:3179:2: ( (kw= 'camera' | this_EDouble_1= ruleEDouble ) )
            // InternalArg.g:3180:2: (kw= 'camera' | this_EDouble_1= ruleEDouble )
            {
            // InternalArg.g:3180:2: (kw= 'camera' | this_EDouble_1= ruleEDouble )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==84) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_INT||LA52_0==44||LA52_0==56) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalArg.g:3181:3: kw= 'camera'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPosOrCameraAccess().getCameraKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:3187:3: this_EDouble_1= ruleEDouble
                    {

                    			newCompositeNode(grammarAccess.getPosOrCameraAccess().getEDoubleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EDouble_1=ruleEDouble();

                    state._fsp--;


                    			current.merge(this_EDouble_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosOrCamera"


    // $ANTLR start "entryRulePhysicChange"
    // InternalArg.g:3201:1: entryRulePhysicChange returns [EObject current=null] : iv_rulePhysicChange= rulePhysicChange EOF ;
    public final EObject entryRulePhysicChange() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicChange = null;


        try {
            // InternalArg.g:3201:53: (iv_rulePhysicChange= rulePhysicChange EOF )
            // InternalArg.g:3202:2: iv_rulePhysicChange= rulePhysicChange EOF
            {
             newCompositeNode(grammarAccess.getPhysicChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicChange=rulePhysicChange();

            state._fsp--;

             current =iv_rulePhysicChange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicChange"


    // $ANTLR start "rulePhysicChange"
    // InternalArg.g:3208:1: rulePhysicChange returns [EObject current=null] : (otherlv_0= 'do' ( (lv_action_1_0= ruleAction ) ) ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )? (otherlv_4= 'named' )? ( (lv_object_5_0= ruleEString ) ) (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )? (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )? (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )? (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )? (otherlv_14= 'force' ( ( ruleEString ) ) )? ) ;
    public final EObject rulePhysicChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Enumerator lv_action_1_0 = null;

        AntlrDatatypeRuleToken lv_object_5_0 = null;

        Enumerator lv_position_7_0 = null;

        AntlrDatatypeRuleToken lv_scale_9_0 = null;

        AntlrDatatypeRuleToken lv_attribute_11_0 = null;

        AntlrDatatypeRuleToken lv_changeValue_13_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3214:2: ( (otherlv_0= 'do' ( (lv_action_1_0= ruleAction ) ) ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )? (otherlv_4= 'named' )? ( (lv_object_5_0= ruleEString ) ) (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )? (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )? (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )? (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )? (otherlv_14= 'force' ( ( ruleEString ) ) )? ) )
            // InternalArg.g:3215:2: (otherlv_0= 'do' ( (lv_action_1_0= ruleAction ) ) ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )? (otherlv_4= 'named' )? ( (lv_object_5_0= ruleEString ) ) (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )? (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )? (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )? (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )? (otherlv_14= 'force' ( ( ruleEString ) ) )? )
            {
            // InternalArg.g:3215:2: (otherlv_0= 'do' ( (lv_action_1_0= ruleAction ) ) ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )? (otherlv_4= 'named' )? ( (lv_object_5_0= ruleEString ) ) (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )? (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )? (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )? (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )? (otherlv_14= 'force' ( ( ruleEString ) ) )? )
            // InternalArg.g:3216:3: otherlv_0= 'do' ( (lv_action_1_0= ruleAction ) ) ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )? (otherlv_4= 'named' )? ( (lv_object_5_0= ruleEString ) ) (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )? (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )? (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )? (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )? (otherlv_14= 'force' ( ( ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,85,FOLLOW_93); 

            			newLeafNode(otherlv_0, grammarAccess.getPhysicChangeAccess().getDoKeyword_0());
            		
            // InternalArg.g:3220:3: ( (lv_action_1_0= ruleAction ) )
            // InternalArg.g:3221:4: (lv_action_1_0= ruleAction )
            {
            // InternalArg.g:3221:4: (lv_action_1_0= ruleAction )
            // InternalArg.g:3222:5: lv_action_1_0= ruleAction
            {

            					newCompositeNode(grammarAccess.getPhysicChangeAccess().getActionActionEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_94);
            lv_action_1_0=ruleAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_1_0,
            						"arg.Arg.Action");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:3239:3: ( (otherlv_2= 'in' )? ( ( ruleEString ) ) )?
            int alt54=2;
            switch ( input.LA(1) ) {
                case 86:
                    {
                    alt54=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    int LA54_2 = input.LA(2);

                    if ( ((LA54_2>=RULE_STRING && LA54_2<=RULE_ID)||LA54_2==87) ) {
                        alt54=1;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA54_3 = input.LA(2);

                    if ( ((LA54_3>=RULE_STRING && LA54_3<=RULE_ID)||LA54_3==87) ) {
                        alt54=1;
                    }
                    }
                    break;
            }

            switch (alt54) {
                case 1 :
                    // InternalArg.g:3240:4: (otherlv_2= 'in' )? ( ( ruleEString ) )
                    {
                    // InternalArg.g:3240:4: (otherlv_2= 'in' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==86) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalArg.g:3241:5: otherlv_2= 'in'
                            {
                            otherlv_2=(Token)match(input,86,FOLLOW_3); 

                            					newLeafNode(otherlv_2, grammarAccess.getPhysicChangeAccess().getInKeyword_2_0());
                            				

                            }
                            break;

                    }

                    // InternalArg.g:3246:4: ( ( ruleEString ) )
                    // InternalArg.g:3247:5: ( ruleEString )
                    {
                    // InternalArg.g:3247:5: ( ruleEString )
                    // InternalArg.g:3248:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPhysicChangeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getClassClassCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_95);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:3263:3: (otherlv_4= 'named' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==87) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalArg.g:3264:4: otherlv_4= 'named'
                    {
                    otherlv_4=(Token)match(input,87,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPhysicChangeAccess().getNamedKeyword_3());
                    			

                    }
                    break;

            }

            // InternalArg.g:3269:3: ( (lv_object_5_0= ruleEString ) )
            // InternalArg.g:3270:4: (lv_object_5_0= ruleEString )
            {
            // InternalArg.g:3270:4: (lv_object_5_0= ruleEString )
            // InternalArg.g:3271:5: lv_object_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPhysicChangeAccess().getObjectEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_96);
            lv_object_5_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_5_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:3288:3: (otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==88) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalArg.g:3289:4: otherlv_6= 'at' ( (lv_position_7_0= rulePosition ) )
                    {
                    otherlv_6=(Token)match(input,88,FOLLOW_97); 

                    				newLeafNode(otherlv_6, grammarAccess.getPhysicChangeAccess().getAtKeyword_5_0());
                    			
                    // InternalArg.g:3293:4: ( (lv_position_7_0= rulePosition ) )
                    // InternalArg.g:3294:5: (lv_position_7_0= rulePosition )
                    {
                    // InternalArg.g:3294:5: (lv_position_7_0= rulePosition )
                    // InternalArg.g:3295:6: lv_position_7_0= rulePosition
                    {

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getPositionPositionEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_position_7_0=rulePosition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
                    						}
                    						set(
                    							current,
                    							"position",
                    							lv_position_7_0,
                    							"arg.Arg.Position");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:3313:3: (otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==89) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalArg.g:3314:4: otherlv_8= 'scale' ( (lv_scale_9_0= ruleEDouble ) )
                    {
                    otherlv_8=(Token)match(input,89,FOLLOW_48); 

                    				newLeafNode(otherlv_8, grammarAccess.getPhysicChangeAccess().getScaleKeyword_6_0());
                    			
                    // InternalArg.g:3318:4: ( (lv_scale_9_0= ruleEDouble ) )
                    // InternalArg.g:3319:5: (lv_scale_9_0= ruleEDouble )
                    {
                    // InternalArg.g:3319:5: (lv_scale_9_0= ruleEDouble )
                    // InternalArg.g:3320:6: lv_scale_9_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getScaleEDoubleParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_99);
                    lv_scale_9_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
                    						}
                    						set(
                    							current,
                    							"scale",
                    							lv_scale_9_0,
                    							"arg.Arg.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:3338:3: (otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==90) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalArg.g:3339:4: otherlv_10= 'stat' ( (lv_attribute_11_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,90,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getPhysicChangeAccess().getStatKeyword_7_0());
                    			
                    // InternalArg.g:3343:4: ( (lv_attribute_11_0= ruleEString ) )
                    // InternalArg.g:3344:5: (lv_attribute_11_0= ruleEString )
                    {
                    // InternalArg.g:3344:5: (lv_attribute_11_0= ruleEString )
                    // InternalArg.g:3345:6: lv_attribute_11_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getAttributeEStringParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_100);
                    lv_attribute_11_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
                    						}
                    						set(
                    							current,
                    							"attribute",
                    							lv_attribute_11_0,
                    							"arg.Arg.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:3363:3: (otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==91) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalArg.g:3364:4: otherlv_12= 'changeStat' ( (lv_changeValue_13_0= ruleEInt ) )
                    {
                    otherlv_12=(Token)match(input,91,FOLLOW_27); 

                    				newLeafNode(otherlv_12, grammarAccess.getPhysicChangeAccess().getChangeStatKeyword_8_0());
                    			
                    // InternalArg.g:3368:4: ( (lv_changeValue_13_0= ruleEInt ) )
                    // InternalArg.g:3369:5: (lv_changeValue_13_0= ruleEInt )
                    {
                    // InternalArg.g:3369:5: (lv_changeValue_13_0= ruleEInt )
                    // InternalArg.g:3370:6: lv_changeValue_13_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getChangeValueEIntParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_101);
                    lv_changeValue_13_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPhysicChangeRule());
                    						}
                    						set(
                    							current,
                    							"changeValue",
                    							lv_changeValue_13_0,
                    							"arg.Arg.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalArg.g:3388:3: (otherlv_14= 'force' ( ( ruleEString ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==92) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalArg.g:3389:4: otherlv_14= 'force' ( ( ruleEString ) )
                    {
                    otherlv_14=(Token)match(input,92,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getPhysicChangeAccess().getForceKeyword_9_0());
                    			
                    // InternalArg.g:3393:4: ( ( ruleEString ) )
                    // InternalArg.g:3394:5: ( ruleEString )
                    {
                    // InternalArg.g:3394:5: ( ruleEString )
                    // InternalArg.g:3395:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPhysicChangeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPhysicChangeAccess().getForceForceCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicChange"


    // $ANTLR start "entryRuleObjAttribute"
    // InternalArg.g:3414:1: entryRuleObjAttribute returns [EObject current=null] : iv_ruleObjAttribute= ruleObjAttribute EOF ;
    public final EObject entryRuleObjAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjAttribute = null;


        try {
            // InternalArg.g:3414:53: (iv_ruleObjAttribute= ruleObjAttribute EOF )
            // InternalArg.g:3415:2: iv_ruleObjAttribute= ruleObjAttribute EOF
            {
             newCompositeNode(grammarAccess.getObjAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjAttribute=ruleObjAttribute();

            state._fsp--;

             current =iv_ruleObjAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjAttribute"


    // $ANTLR start "ruleObjAttribute"
    // InternalArg.g:3421:1: ruleObjAttribute returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= 'value' ( (lv_value_2_0= ruleEString ) ) ) ;
    public final EObject ruleObjAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3427:2: ( ( ( ( ruleEString ) ) otherlv_1= 'value' ( (lv_value_2_0= ruleEString ) ) ) )
            // InternalArg.g:3428:2: ( ( ( ruleEString ) ) otherlv_1= 'value' ( (lv_value_2_0= ruleEString ) ) )
            {
            // InternalArg.g:3428:2: ( ( ( ruleEString ) ) otherlv_1= 'value' ( (lv_value_2_0= ruleEString ) ) )
            // InternalArg.g:3429:3: ( ( ruleEString ) ) otherlv_1= 'value' ( (lv_value_2_0= ruleEString ) )
            {
            // InternalArg.g:3429:3: ( ( ruleEString ) )
            // InternalArg.g:3430:4: ( ruleEString )
            {
            // InternalArg.g:3430:4: ( ruleEString )
            // InternalArg.g:3431:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjAttributeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getObjAttributeAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_102);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,93,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getObjAttributeAccess().getValueKeyword_1());
            		
            // InternalArg.g:3449:3: ( (lv_value_2_0= ruleEString ) )
            // InternalArg.g:3450:4: (lv_value_2_0= ruleEString )
            {
            // InternalArg.g:3450:4: (lv_value_2_0= ruleEString )
            // InternalArg.g:3451:5: lv_value_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getObjAttributeAccess().getValueEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjAttributeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjAttribute"


    // $ANTLR start "entryRuleRule"
    // InternalArg.g:3472:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalArg.g:3472:45: (iv_ruleRule= ruleRule EOF )
            // InternalArg.g:3473:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalArg.g:3479:1: ruleRule returns [EObject current=null] : (otherlv_0= 'do' ( ( ruleEString ) ) otherlv_2= 'if(' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= ')' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3485:2: ( (otherlv_0= 'do' ( ( ruleEString ) ) otherlv_2= 'if(' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= ')' ) )
            // InternalArg.g:3486:2: (otherlv_0= 'do' ( ( ruleEString ) ) otherlv_2= 'if(' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= ')' )
            {
            // InternalArg.g:3486:2: (otherlv_0= 'do' ( ( ruleEString ) ) otherlv_2= 'if(' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= ')' )
            // InternalArg.g:3487:3: otherlv_0= 'do' ( ( ruleEString ) ) otherlv_2= 'if(' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getDoKeyword_0());
            		
            // InternalArg.g:3491:3: ( ( ruleEString ) )
            // InternalArg.g:3492:4: ( ruleEString )
            {
            // InternalArg.g:3492:4: ( ruleEString )
            // InternalArg.g:3493:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRuleAccess().getActionTriggerCrossReference_1_0());
            				
            pushFollow(FOLLOW_103);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,94,FOLLOW_104); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getIfKeyword_2());
            		
            // InternalArg.g:3511:3: ( (lv_condition_3_0= ruleCondition ) )
            // InternalArg.g:3512:4: (lv_condition_3_0= ruleCondition )
            {
            // InternalArg.g:3512:4: (lv_condition_3_0= ruleCondition )
            // InternalArg.g:3513:5: lv_condition_3_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getConditionConditionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_105);
            lv_condition_3_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"arg.Arg.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,95,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleNot"
    // InternalArg.g:3538:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalArg.g:3538:44: (iv_ruleNot= ruleNot EOF )
            // InternalArg.g:3539:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalArg.g:3545:1: ruleNot returns [EObject current=null] : (otherlv_0= '!' ( (lv_left_1_0= ruleCondition ) ) ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_left_1_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3551:2: ( (otherlv_0= '!' ( (lv_left_1_0= ruleCondition ) ) ) )
            // InternalArg.g:3552:2: (otherlv_0= '!' ( (lv_left_1_0= ruleCondition ) ) )
            {
            // InternalArg.g:3552:2: (otherlv_0= '!' ( (lv_left_1_0= ruleCondition ) ) )
            // InternalArg.g:3553:3: otherlv_0= '!' ( (lv_left_1_0= ruleCondition ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_104); 

            			newLeafNode(otherlv_0, grammarAccess.getNotAccess().getExclamationMarkKeyword_0());
            		
            // InternalArg.g:3557:3: ( (lv_left_1_0= ruleCondition ) )
            // InternalArg.g:3558:4: (lv_left_1_0= ruleCondition )
            {
            // InternalArg.g:3558:4: (lv_left_1_0= ruleCondition )
            // InternalArg.g:3559:5: lv_left_1_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getNotAccess().getLeftConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_left_1_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"arg.Arg.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleBinary"
    // InternalArg.g:3580:1: entryRuleBinary returns [EObject current=null] : iv_ruleBinary= ruleBinary EOF ;
    public final EObject entryRuleBinary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinary = null;


        try {
            // InternalArg.g:3580:47: (iv_ruleBinary= ruleBinary EOF )
            // InternalArg.g:3581:2: iv_ruleBinary= ruleBinary EOF
            {
             newCompositeNode(grammarAccess.getBinaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinary=ruleBinary();

            state._fsp--;

             current =iv_ruleBinary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinary"


    // $ANTLR start "ruleBinary"
    // InternalArg.g:3587:1: ruleBinary returns [EObject current=null] : (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( (lv_op_3_0= ruleLogicOps ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' ) ;
    public final EObject ruleBinary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_left_1_0 = null;

        Enumerator lv_op_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3593:2: ( (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( (lv_op_3_0= ruleLogicOps ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' ) )
            // InternalArg.g:3594:2: (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( (lv_op_3_0= ruleLogicOps ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' )
            {
            // InternalArg.g:3594:2: (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( (lv_op_3_0= ruleLogicOps ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' )
            // InternalArg.g:3595:3: otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( (lv_op_3_0= ruleLogicOps ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_104); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_0());
            		
            // InternalArg.g:3599:3: ( (lv_left_1_0= ruleCondition ) )
            // InternalArg.g:3600:4: (lv_left_1_0= ruleCondition )
            {
            // InternalArg.g:3600:4: (lv_left_1_0= ruleCondition )
            // InternalArg.g:3601:5: lv_left_1_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getLeftConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_105);
            lv_left_1_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"arg.Arg.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,95,FOLLOW_106); 

            			newLeafNode(otherlv_2, grammarAccess.getBinaryAccess().getRightParenthesisKeyword_2());
            		
            // InternalArg.g:3622:3: ( (lv_op_3_0= ruleLogicOps ) )
            // InternalArg.g:3623:4: (lv_op_3_0= ruleLogicOps )
            {
            // InternalArg.g:3623:4: (lv_op_3_0= ruleLogicOps )
            // InternalArg.g:3624:5: lv_op_3_0= ruleLogicOps
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getOpLogicOpsEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_107);
            lv_op_3_0=ruleLogicOps();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_3_0,
            						"arg.Arg.LogicOps");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,97,FOLLOW_104); 

            			newLeafNode(otherlv_4, grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_4());
            		
            // InternalArg.g:3645:3: ( (lv_right_5_0= ruleCondition ) )
            // InternalArg.g:3646:4: (lv_right_5_0= ruleCondition )
            {
            // InternalArg.g:3646:4: (lv_right_5_0= ruleCondition )
            // InternalArg.g:3647:5: lv_right_5_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getRightConditionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_105);
            lv_right_5_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_5_0,
            						"arg.Arg.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,95,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBinaryAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinary"


    // $ANTLR start "entryRuleArithmetic"
    // InternalArg.g:3672:1: entryRuleArithmetic returns [EObject current=null] : iv_ruleArithmetic= ruleArithmetic EOF ;
    public final EObject entryRuleArithmetic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmetic = null;


        try {
            // InternalArg.g:3672:51: (iv_ruleArithmetic= ruleArithmetic EOF )
            // InternalArg.g:3673:2: iv_ruleArithmetic= ruleArithmetic EOF
            {
             newCompositeNode(grammarAccess.getArithmeticRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithmetic=ruleArithmetic();

            state._fsp--;

             current =iv_ruleArithmetic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmetic"


    // $ANTLR start "ruleArithmetic"
    // InternalArg.g:3679:1: ruleArithmetic returns [EObject current=null] : ( ( (lv_left_0_0= ruleValue ) ) ( (lv_op_1_0= ruleArithmOps ) ) ( (lv_right_2_0= ruleValue ) ) ) ;
    public final EObject ruleArithmetic() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_op_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3685:2: ( ( ( (lv_left_0_0= ruleValue ) ) ( (lv_op_1_0= ruleArithmOps ) ) ( (lv_right_2_0= ruleValue ) ) ) )
            // InternalArg.g:3686:2: ( ( (lv_left_0_0= ruleValue ) ) ( (lv_op_1_0= ruleArithmOps ) ) ( (lv_right_2_0= ruleValue ) ) )
            {
            // InternalArg.g:3686:2: ( ( (lv_left_0_0= ruleValue ) ) ( (lv_op_1_0= ruleArithmOps ) ) ( (lv_right_2_0= ruleValue ) ) )
            // InternalArg.g:3687:3: ( (lv_left_0_0= ruleValue ) ) ( (lv_op_1_0= ruleArithmOps ) ) ( (lv_right_2_0= ruleValue ) )
            {
            // InternalArg.g:3687:3: ( (lv_left_0_0= ruleValue ) )
            // InternalArg.g:3688:4: (lv_left_0_0= ruleValue )
            {
            // InternalArg.g:3688:4: (lv_left_0_0= ruleValue )
            // InternalArg.g:3689:5: lv_left_0_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getArithmeticAccess().getLeftValueParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_108);
            lv_left_0_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithmeticRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"arg.Arg.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:3706:3: ( (lv_op_1_0= ruleArithmOps ) )
            // InternalArg.g:3707:4: (lv_op_1_0= ruleArithmOps )
            {
            // InternalArg.g:3707:4: (lv_op_1_0= ruleArithmOps )
            // InternalArg.g:3708:5: lv_op_1_0= ruleArithmOps
            {

            					newCompositeNode(grammarAccess.getArithmeticAccess().getOpArithmOpsEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_104);
            lv_op_1_0=ruleArithmOps();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithmeticRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_1_0,
            						"arg.Arg.ArithmOps");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArg.g:3725:3: ( (lv_right_2_0= ruleValue ) )
            // InternalArg.g:3726:4: (lv_right_2_0= ruleValue )
            {
            // InternalArg.g:3726:4: (lv_right_2_0= ruleValue )
            // InternalArg.g:3727:5: lv_right_2_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getArithmeticAccess().getRightValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_2_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithmeticRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_2_0,
            						"arg.Arg.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmetic"


    // $ANTLR start "entryRuleAttributeValue"
    // InternalArg.g:3748:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // InternalArg.g:3748:55: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // InternalArg.g:3749:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // InternalArg.g:3755:1: ruleAttributeValue returns [EObject current=null] : ( ( (lv_class_0_0= ruleEString ) ) otherlv_1= '.' ( (lv_attribute_2_0= ruleEString ) ) ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_class_0_0 = null;

        AntlrDatatypeRuleToken lv_attribute_2_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3761:2: ( ( ( (lv_class_0_0= ruleEString ) ) otherlv_1= '.' ( (lv_attribute_2_0= ruleEString ) ) ) )
            // InternalArg.g:3762:2: ( ( (lv_class_0_0= ruleEString ) ) otherlv_1= '.' ( (lv_attribute_2_0= ruleEString ) ) )
            {
            // InternalArg.g:3762:2: ( ( (lv_class_0_0= ruleEString ) ) otherlv_1= '.' ( (lv_attribute_2_0= ruleEString ) ) )
            // InternalArg.g:3763:3: ( (lv_class_0_0= ruleEString ) ) otherlv_1= '.' ( (lv_attribute_2_0= ruleEString ) )
            {
            // InternalArg.g:3763:3: ( (lv_class_0_0= ruleEString ) )
            // InternalArg.g:3764:4: (lv_class_0_0= ruleEString )
            {
            // InternalArg.g:3764:4: (lv_class_0_0= ruleEString )
            // InternalArg.g:3765:5: lv_class_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAttributeValueAccess().getClassEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_55);
            lv_class_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeValueRule());
            					}
            					set(
            						current,
            						"class",
            						lv_class_0_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeValueAccess().getFullStopKeyword_1());
            		
            // InternalArg.g:3786:3: ( (lv_attribute_2_0= ruleEString ) )
            // InternalArg.g:3787:4: (lv_attribute_2_0= ruleEString )
            {
            // InternalArg.g:3787:4: (lv_attribute_2_0= ruleEString )
            // InternalArg.g:3788:5: lv_attribute_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAttributeValueAccess().getAttributeEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_attribute_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeValueRule());
            					}
            					set(
            						current,
            						"attribute",
            						lv_attribute_2_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleConstantValue"
    // InternalArg.g:3809:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalArg.g:3809:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalArg.g:3810:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalArg.g:3816:1: ruleConstantValue returns [EObject current=null] : ( (lv_value_0_0= ruleConstant ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3822:2: ( ( (lv_value_0_0= ruleConstant ) ) )
            // InternalArg.g:3823:2: ( (lv_value_0_0= ruleConstant ) )
            {
            // InternalArg.g:3823:2: ( (lv_value_0_0= ruleConstant ) )
            // InternalArg.g:3824:3: (lv_value_0_0= ruleConstant )
            {
            // InternalArg.g:3824:3: (lv_value_0_0= ruleConstant )
            // InternalArg.g:3825:4: lv_value_0_0= ruleConstant
            {

            				newCompositeNode(grammarAccess.getConstantValueAccess().getValueConstantParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleConstant();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getConstantValueRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"arg.Arg.Constant");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleConstant"
    // InternalArg.g:3845:1: entryRuleConstant returns [String current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final String entryRuleConstant() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant = null;


        try {
            // InternalArg.g:3845:48: (iv_ruleConstant= ruleConstant EOF )
            // InternalArg.g:3846:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalArg.g:3852:1: ruleConstant returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | this_EString_1= ruleEString ) ;
    public final AntlrDatatypeRuleToken ruleConstant() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EInt_0 = null;

        AntlrDatatypeRuleToken this_EString_1 = null;



        	enterRule();

        try {
            // InternalArg.g:3858:2: ( (this_EInt_0= ruleEInt | this_EString_1= ruleEString ) )
            // InternalArg.g:3859:2: (this_EInt_0= ruleEInt | this_EString_1= ruleEString )
            {
            // InternalArg.g:3859:2: (this_EInt_0= ruleEInt | this_EString_1= ruleEString )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_INT||LA61_0==44) ) {
                alt61=1;
            }
            else if ( ((LA61_0>=RULE_STRING && LA61_0<=RULE_ID)) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalArg.g:3860:3: this_EInt_0= ruleEInt
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getEIntParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    			current.merge(this_EInt_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalArg.g:3871:3: this_EString_1= ruleEString
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getEStringParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EString_1=ruleEString();

                    state._fsp--;


                    			current.merge(this_EString_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleAllInstances"
    // InternalArg.g:3885:1: entryRuleAllInstances returns [EObject current=null] : iv_ruleAllInstances= ruleAllInstances EOF ;
    public final EObject entryRuleAllInstances() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllInstances = null;


        try {
            // InternalArg.g:3885:53: (iv_ruleAllInstances= ruleAllInstances EOF )
            // InternalArg.g:3886:2: iv_ruleAllInstances= ruleAllInstances EOF
            {
             newCompositeNode(grammarAccess.getAllInstancesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllInstances=ruleAllInstances();

            state._fsp--;

             current =iv_ruleAllInstances; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAllInstances"


    // $ANTLR start "ruleAllInstances"
    // InternalArg.g:3892:1: ruleAllInstances returns [EObject current=null] : (otherlv_0= 'Number' ( (lv_type_1_0= ruleEString ) ) ) ;
    public final EObject ruleAllInstances() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalArg.g:3898:2: ( (otherlv_0= 'Number' ( (lv_type_1_0= ruleEString ) ) ) )
            // InternalArg.g:3899:2: (otherlv_0= 'Number' ( (lv_type_1_0= ruleEString ) ) )
            {
            // InternalArg.g:3899:2: (otherlv_0= 'Number' ( (lv_type_1_0= ruleEString ) ) )
            // InternalArg.g:3900:3: otherlv_0= 'Number' ( (lv_type_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAllInstancesAccess().getNumberKeyword_0());
            		
            // InternalArg.g:3904:3: ( (lv_type_1_0= ruleEString ) )
            // InternalArg.g:3905:4: (lv_type_1_0= ruleEString )
            {
            // InternalArg.g:3905:4: (lv_type_1_0= ruleEString )
            // InternalArg.g:3906:5: lv_type_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAllInstancesAccess().getTypeEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAllInstancesRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"arg.Arg.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAllInstances"


    // $ANTLR start "ruleGesture"
    // InternalArg.g:3927:1: ruleGesture returns [Enumerator current=null] : ( (enumLiteral_0= 'drag' ) | (enumLiteral_1= 'tilt' ) | (enumLiteral_2= 'touch' ) ) ;
    public final Enumerator ruleGesture() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalArg.g:3933:2: ( ( (enumLiteral_0= 'drag' ) | (enumLiteral_1= 'tilt' ) | (enumLiteral_2= 'touch' ) ) )
            // InternalArg.g:3934:2: ( (enumLiteral_0= 'drag' ) | (enumLiteral_1= 'tilt' ) | (enumLiteral_2= 'touch' ) )
            {
            // InternalArg.g:3934:2: ( (enumLiteral_0= 'drag' ) | (enumLiteral_1= 'tilt' ) | (enumLiteral_2= 'touch' ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt62=1;
                }
                break;
            case 100:
                {
                alt62=2;
                }
                break;
            case 101:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalArg.g:3935:3: (enumLiteral_0= 'drag' )
                    {
                    // InternalArg.g:3935:3: (enumLiteral_0= 'drag' )
                    // InternalArg.g:3936:4: enumLiteral_0= 'drag'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getGestureAccess().getDragEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getGestureAccess().getDragEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:3943:3: (enumLiteral_1= 'tilt' )
                    {
                    // InternalArg.g:3943:3: (enumLiteral_1= 'tilt' )
                    // InternalArg.g:3944:4: enumLiteral_1= 'tilt'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getGestureAccess().getTiltEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getGestureAccess().getTiltEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:3951:3: (enumLiteral_2= 'touch' )
                    {
                    // InternalArg.g:3951:3: (enumLiteral_2= 'touch' )
                    // InternalArg.g:3952:4: enumLiteral_2= 'touch'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getGestureAccess().getTouchEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getGestureAccess().getTouchEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGesture"


    // $ANTLR start "rulePlanes"
    // InternalArg.g:3962:1: rulePlanes returns [Enumerator current=null] : ( (enumLiteral_0= 'any' ) | (enumLiteral_1= 'horizontal' ) | (enumLiteral_2= 'vertical' ) ) ;
    public final Enumerator rulePlanes() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalArg.g:3968:2: ( ( (enumLiteral_0= 'any' ) | (enumLiteral_1= 'horizontal' ) | (enumLiteral_2= 'vertical' ) ) )
            // InternalArg.g:3969:2: ( (enumLiteral_0= 'any' ) | (enumLiteral_1= 'horizontal' ) | (enumLiteral_2= 'vertical' ) )
            {
            // InternalArg.g:3969:2: ( (enumLiteral_0= 'any' ) | (enumLiteral_1= 'horizontal' ) | (enumLiteral_2= 'vertical' ) )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt63=1;
                }
                break;
            case 103:
                {
                alt63=2;
                }
                break;
            case 104:
                {
                alt63=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalArg.g:3970:3: (enumLiteral_0= 'any' )
                    {
                    // InternalArg.g:3970:3: (enumLiteral_0= 'any' )
                    // InternalArg.g:3971:4: enumLiteral_0= 'any'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getPlanesAccess().getAnyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPlanesAccess().getAnyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:3978:3: (enumLiteral_1= 'horizontal' )
                    {
                    // InternalArg.g:3978:3: (enumLiteral_1= 'horizontal' )
                    // InternalArg.g:3979:4: enumLiteral_1= 'horizontal'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getPlanesAccess().getHorizontalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPlanesAccess().getHorizontalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:3986:3: (enumLiteral_2= 'vertical' )
                    {
                    // InternalArg.g:3986:3: (enumLiteral_2= 'vertical' )
                    // InternalArg.g:3987:4: enumLiteral_2= 'vertical'
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getPlanesAccess().getVerticalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPlanesAccess().getVerticalEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlanes"


    // $ANTLR start "ruleBodyType"
    // InternalArg.g:3997:1: ruleBodyType returns [Enumerator current=null] : ( (enumLiteral_0= 'static' ) | (enumLiteral_1= 'dynamic' ) | (enumLiteral_2= 'kinematic' ) ) ;
    public final Enumerator ruleBodyType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalArg.g:4003:2: ( ( (enumLiteral_0= 'static' ) | (enumLiteral_1= 'dynamic' ) | (enumLiteral_2= 'kinematic' ) ) )
            // InternalArg.g:4004:2: ( (enumLiteral_0= 'static' ) | (enumLiteral_1= 'dynamic' ) | (enumLiteral_2= 'kinematic' ) )
            {
            // InternalArg.g:4004:2: ( (enumLiteral_0= 'static' ) | (enumLiteral_1= 'dynamic' ) | (enumLiteral_2= 'kinematic' ) )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt64=1;
                }
                break;
            case 106:
                {
                alt64=2;
                }
                break;
            case 107:
                {
                alt64=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalArg.g:4005:3: (enumLiteral_0= 'static' )
                    {
                    // InternalArg.g:4005:3: (enumLiteral_0= 'static' )
                    // InternalArg.g:4006:4: enumLiteral_0= 'static'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getBodyTypeAccess().getStaticEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBodyTypeAccess().getStaticEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4013:3: (enumLiteral_1= 'dynamic' )
                    {
                    // InternalArg.g:4013:3: (enumLiteral_1= 'dynamic' )
                    // InternalArg.g:4014:4: enumLiteral_1= 'dynamic'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getBodyTypeAccess().getDynamicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBodyTypeAccess().getDynamicEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:4021:3: (enumLiteral_2= 'kinematic' )
                    {
                    // InternalArg.g:4021:3: (enumLiteral_2= 'kinematic' )
                    // InternalArg.g:4022:4: enumLiteral_2= 'kinematic'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getBodyTypeAccess().getKinematicEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBodyTypeAccess().getKinematicEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBodyType"


    // $ANTLR start "ruleBasicActions"
    // InternalArg.g:4032:1: ruleBasicActions returns [Enumerator current=null] : ( (enumLiteral_0= 'start' ) | (enumLiteral_1= 'win' ) | (enumLiteral_2= 'lose' ) | (enumLiteral_3= 'none' ) | (enumLiteral_4= 'restart' ) ) ;
    public final Enumerator ruleBasicActions() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalArg.g:4038:2: ( ( (enumLiteral_0= 'start' ) | (enumLiteral_1= 'win' ) | (enumLiteral_2= 'lose' ) | (enumLiteral_3= 'none' ) | (enumLiteral_4= 'restart' ) ) )
            // InternalArg.g:4039:2: ( (enumLiteral_0= 'start' ) | (enumLiteral_1= 'win' ) | (enumLiteral_2= 'lose' ) | (enumLiteral_3= 'none' ) | (enumLiteral_4= 'restart' ) )
            {
            // InternalArg.g:4039:2: ( (enumLiteral_0= 'start' ) | (enumLiteral_1= 'win' ) | (enumLiteral_2= 'lose' ) | (enumLiteral_3= 'none' ) | (enumLiteral_4= 'restart' ) )
            int alt65=5;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt65=1;
                }
                break;
            case 23:
                {
                alt65=2;
                }
                break;
            case 24:
                {
                alt65=3;
                }
                break;
            case 108:
                {
                alt65=4;
                }
                break;
            case 109:
                {
                alt65=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalArg.g:4040:3: (enumLiteral_0= 'start' )
                    {
                    // InternalArg.g:4040:3: (enumLiteral_0= 'start' )
                    // InternalArg.g:4041:4: enumLiteral_0= 'start'
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getBasicActionsAccess().getStartEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBasicActionsAccess().getStartEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4048:3: (enumLiteral_1= 'win' )
                    {
                    // InternalArg.g:4048:3: (enumLiteral_1= 'win' )
                    // InternalArg.g:4049:4: enumLiteral_1= 'win'
                    {
                    enumLiteral_1=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getBasicActionsAccess().getWinEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBasicActionsAccess().getWinEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:4056:3: (enumLiteral_2= 'lose' )
                    {
                    // InternalArg.g:4056:3: (enumLiteral_2= 'lose' )
                    // InternalArg.g:4057:4: enumLiteral_2= 'lose'
                    {
                    enumLiteral_2=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getBasicActionsAccess().getLoseEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBasicActionsAccess().getLoseEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalArg.g:4064:3: (enumLiteral_3= 'none' )
                    {
                    // InternalArg.g:4064:3: (enumLiteral_3= 'none' )
                    // InternalArg.g:4065:4: enumLiteral_3= 'none'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getBasicActionsAccess().getNoneEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBasicActionsAccess().getNoneEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalArg.g:4072:3: (enumLiteral_4= 'restart' )
                    {
                    // InternalArg.g:4072:3: (enumLiteral_4= 'restart' )
                    // InternalArg.g:4073:4: enumLiteral_4= 'restart'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getBasicActionsAccess().getRestartEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBasicActionsAccess().getRestartEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicActions"


    // $ANTLR start "ruleAction"
    // InternalArg.g:4083:1: ruleAction returns [Enumerator current=null] : ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'edit' ) | (enumLiteral_2= 'delete' ) ) ;
    public final Enumerator ruleAction() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalArg.g:4089:2: ( ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'edit' ) | (enumLiteral_2= 'delete' ) ) )
            // InternalArg.g:4090:2: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'edit' ) | (enumLiteral_2= 'delete' ) )
            {
            // InternalArg.g:4090:2: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'edit' ) | (enumLiteral_2= 'delete' ) )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt66=1;
                }
                break;
            case 111:
                {
                alt66=2;
                }
                break;
            case 112:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalArg.g:4091:3: (enumLiteral_0= 'create' )
                    {
                    // InternalArg.g:4091:3: (enumLiteral_0= 'create' )
                    // InternalArg.g:4092:4: enumLiteral_0= 'create'
                    {
                    enumLiteral_0=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getCreateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActionAccess().getCreateEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4099:3: (enumLiteral_1= 'edit' )
                    {
                    // InternalArg.g:4099:3: (enumLiteral_1= 'edit' )
                    // InternalArg.g:4100:4: enumLiteral_1= 'edit'
                    {
                    enumLiteral_1=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getEditEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActionAccess().getEditEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:4107:3: (enumLiteral_2= 'delete' )
                    {
                    // InternalArg.g:4107:3: (enumLiteral_2= 'delete' )
                    // InternalArg.g:4108:4: enumLiteral_2= 'delete'
                    {
                    enumLiteral_2=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getDeleteEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActionAccess().getDeleteEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "rulePosition"
    // InternalArg.g:4118:1: rulePosition returns [Enumerator current=null] : ( (enumLiteral_0= 'front' ) | (enumLiteral_1= 'default' ) | (enumLiteral_2= 'back' ) ) ;
    public final Enumerator rulePosition() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalArg.g:4124:2: ( ( (enumLiteral_0= 'front' ) | (enumLiteral_1= 'default' ) | (enumLiteral_2= 'back' ) ) )
            // InternalArg.g:4125:2: ( (enumLiteral_0= 'front' ) | (enumLiteral_1= 'default' ) | (enumLiteral_2= 'back' ) )
            {
            // InternalArg.g:4125:2: ( (enumLiteral_0= 'front' ) | (enumLiteral_1= 'default' ) | (enumLiteral_2= 'back' ) )
            int alt67=3;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt67=1;
                }
                break;
            case 114:
                {
                alt67=2;
                }
                break;
            case 115:
                {
                alt67=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalArg.g:4126:3: (enumLiteral_0= 'front' )
                    {
                    // InternalArg.g:4126:3: (enumLiteral_0= 'front' )
                    // InternalArg.g:4127:4: enumLiteral_0= 'front'
                    {
                    enumLiteral_0=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getPositionAccess().getFrontEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPositionAccess().getFrontEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4134:3: (enumLiteral_1= 'default' )
                    {
                    // InternalArg.g:4134:3: (enumLiteral_1= 'default' )
                    // InternalArg.g:4135:4: enumLiteral_1= 'default'
                    {
                    enumLiteral_1=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getPositionAccess().getDefaultEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPositionAccess().getDefaultEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:4142:3: (enumLiteral_2= 'back' )
                    {
                    // InternalArg.g:4142:3: (enumLiteral_2= 'back' )
                    // InternalArg.g:4143:4: enumLiteral_2= 'back'
                    {
                    enumLiteral_2=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getPositionAccess().getBackEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPositionAccess().getBackEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "ruleLogicOps"
    // InternalArg.g:4153:1: ruleLogicOps returns [Enumerator current=null] : ( (enumLiteral_0= '&' ) | (enumLiteral_1= '|' ) ) ;
    public final Enumerator ruleLogicOps() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalArg.g:4159:2: ( ( (enumLiteral_0= '&' ) | (enumLiteral_1= '|' ) ) )
            // InternalArg.g:4160:2: ( (enumLiteral_0= '&' ) | (enumLiteral_1= '|' ) )
            {
            // InternalArg.g:4160:2: ( (enumLiteral_0= '&' ) | (enumLiteral_1= '|' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==116) ) {
                alt68=1;
            }
            else if ( (LA68_0==117) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalArg.g:4161:3: (enumLiteral_0= '&' )
                    {
                    // InternalArg.g:4161:3: (enumLiteral_0= '&' )
                    // InternalArg.g:4162:4: enumLiteral_0= '&'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getLogicOpsAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLogicOpsAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4169:3: (enumLiteral_1= '|' )
                    {
                    // InternalArg.g:4169:3: (enumLiteral_1= '|' )
                    // InternalArg.g:4170:4: enumLiteral_1= '|'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getLogicOpsAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLogicOpsAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicOps"


    // $ANTLR start "ruleArithmOps"
    // InternalArg.g:4180:1: ruleArithmOps returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '<=' ) ) ;
    public final Enumerator ruleArithmOps() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalArg.g:4186:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '<=' ) ) )
            // InternalArg.g:4187:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '<=' ) )
            {
            // InternalArg.g:4187:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '<=' ) )
            int alt69=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt69=1;
                }
                break;
            case 118:
                {
                alt69=2;
                }
                break;
            case 119:
                {
                alt69=3;
                }
                break;
            case 120:
                {
                alt69=4;
                }
                break;
            case 121:
                {
                alt69=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalArg.g:4188:3: (enumLiteral_0= '=' )
                    {
                    // InternalArg.g:4188:3: (enumLiteral_0= '=' )
                    // InternalArg.g:4189:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getArithmOpsAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getArithmOpsAccess().getEqualEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArg.g:4196:3: (enumLiteral_1= '>' )
                    {
                    // InternalArg.g:4196:3: (enumLiteral_1= '>' )
                    // InternalArg.g:4197:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getArithmOpsAccess().getGreaterEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getArithmOpsAccess().getGreaterEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalArg.g:4204:3: (enumLiteral_2= '>=' )
                    {
                    // InternalArg.g:4204:3: (enumLiteral_2= '>=' )
                    // InternalArg.g:4205:4: enumLiteral_2= '>='
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getArithmOpsAccess().getGreaterEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getArithmOpsAccess().getGreaterEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalArg.g:4212:3: (enumLiteral_3= '<' )
                    {
                    // InternalArg.g:4212:3: (enumLiteral_3= '<' )
                    // InternalArg.g:4213:4: enumLiteral_3= '<'
                    {
                    enumLiteral_3=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getArithmOpsAccess().getLowerEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getArithmOpsAccess().getLowerEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalArg.g:4220:3: (enumLiteral_4= '<=' )
                    {
                    // InternalArg.g:4220:3: (enumLiteral_4= '<=' )
                    // InternalArg.g:4221:4: enumLiteral_4= '<='
                    {
                    enumLiteral_4=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getArithmOpsAccess().getLowerEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getArithmOpsAccess().getLowerEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmOps"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000000C030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000200000004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000003C004000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000038004000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000030004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020004000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000000070L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x000001C000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0100100000000040L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x00000E0000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000080L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000003800000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000002004000L,0x000000000001E000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000001C00000L,0x0000300000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000002004000L,0x000000000001C000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000002004000L,0x0000000000018000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000004000L,0x0000000000018000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000004000L,0x0000000000010000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000004000L,0x0000000000200000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0100100000000040L,0x0000000000100000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000200L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0001C00000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000030L,0x0000000000C00000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000030L,0x0000000000800000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x000000001F000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x000E000000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000002L,0x000000001E000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000002L,0x000000001C000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000100000000070L,0x0000000700000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0030000000000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000400000000L,0x03C0000000000000L});

}