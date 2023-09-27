/**
 */
package Ardsl.impl;

import Ardsl.Action;
import Ardsl.AllInstances;
import Ardsl.ArdslFactory;
import Ardsl.ArdslPackage;
import Ardsl.ArithmOps;
import Ardsl.Arithmetic;
import Ardsl.Attribute;
import Ardsl.AttributeValue;
import Ardsl.BasicActions;
import Ardsl.Binary;
import Ardsl.BitMasks;
import Ardsl.BodyType;
import Ardsl.Collision;
import Ardsl.Connection;
import Ardsl.ConstantValue;
import Ardsl.Constraints;
import Ardsl.Force;
import Ardsl.Game;
import Ardsl.GamePad;
import Ardsl.Gesture;
import Ardsl.Graphic;
import Ardsl.GraphicClass;
import Ardsl.LogicOps;
import Ardsl.Not;
import Ardsl.ObjAttribute;
import Ardsl.ObjInit;
import Ardsl.Ontological;
import Ardsl.Physic;
import Ardsl.PhysicBody;
import Ardsl.PhysicChange;
import Ardsl.PhysicClass;
import Ardsl.Planes;
import Ardsl.Position;
import Ardsl.Reference;
import Ardsl.Rule;
import Ardsl.ScoreSystem;
import Ardsl.Trigger;
import Ardsl.Versions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArdslFactoryImpl extends EFactoryImpl implements ArdslFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArdslFactory init() {
		try {
			ArdslFactory theArdslFactory = (ArdslFactory)EPackage.Registry.INSTANCE.getEFactory(ArdslPackage.eNS_URI);
			if (theArdslFactory != null) {
				return theArdslFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArdslFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArdslFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ArdslPackage.ONTOLOGICAL: return createOntological();
			case ArdslPackage.GRAPHIC: return createGraphic();
			case ArdslPackage.PHYSIC: return createPhysic();
			case ArdslPackage.GAME: return createGame();
			case ArdslPackage.GAME_PAD: return createGamePad();
			case ArdslPackage.CLASS: return createClass();
			case ArdslPackage.ATTRIBUTE: return createAttribute();
			case ArdslPackage.REFERENCE: return createReference();
			case ArdslPackage.GRAPHIC_CLASS: return createGraphicClass();
			case ArdslPackage.VERSIONS: return createVersions();
			case ArdslPackage.CONSTRAINTS: return createConstraints();
			case ArdslPackage.CONNECTION: return createConnection();
			case ArdslPackage.PHYSIC_CLASS: return createPhysicClass();
			case ArdslPackage.PHYSIC_BODY: return createPhysicBody();
			case ArdslPackage.BIT_MASKS: return createBitMasks();
			case ArdslPackage.FORCE: return createForce();
			case ArdslPackage.SCORE_SYSTEM: return createScoreSystem();
			case ArdslPackage.TRIGGER: return createTrigger();
			case ArdslPackage.PHYSIC_CHANGE: return createPhysicChange();
			case ArdslPackage.COLLISION: return createCollision();
			case ArdslPackage.OBJ_INIT: return createObjInit();
			case ArdslPackage.OBJ_ATTRIBUTE: return createObjAttribute();
			case ArdslPackage.RULE: return createRule();
			case ArdslPackage.NOT: return createNot();
			case ArdslPackage.BINARY: return createBinary();
			case ArdslPackage.ARITHMETIC: return createArithmetic();
			case ArdslPackage.ATTRIBUTE_VALUE: return createAttributeValue();
			case ArdslPackage.CONSTANT_VALUE: return createConstantValue();
			case ArdslPackage.ALL_INSTANCES: return createAllInstances();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ArdslPackage.PLANES:
				return createPlanesFromString(eDataType, initialValue);
			case ArdslPackage.BODY_TYPE:
				return createBodyTypeFromString(eDataType, initialValue);
			case ArdslPackage.GESTURE:
				return createGestureFromString(eDataType, initialValue);
			case ArdslPackage.BASIC_ACTIONS:
				return createBasicActionsFromString(eDataType, initialValue);
			case ArdslPackage.ACTION:
				return createActionFromString(eDataType, initialValue);
			case ArdslPackage.POSITION:
				return createPositionFromString(eDataType, initialValue);
			case ArdslPackage.LOGIC_OPS:
				return createLogicOpsFromString(eDataType, initialValue);
			case ArdslPackage.ARITHM_OPS:
				return createArithmOpsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ArdslPackage.PLANES:
				return convertPlanesToString(eDataType, instanceValue);
			case ArdslPackage.BODY_TYPE:
				return convertBodyTypeToString(eDataType, instanceValue);
			case ArdslPackage.GESTURE:
				return convertGestureToString(eDataType, instanceValue);
			case ArdslPackage.BASIC_ACTIONS:
				return convertBasicActionsToString(eDataType, instanceValue);
			case ArdslPackage.ACTION:
				return convertActionToString(eDataType, instanceValue);
			case ArdslPackage.POSITION:
				return convertPositionToString(eDataType, instanceValue);
			case ArdslPackage.LOGIC_OPS:
				return convertLogicOpsToString(eDataType, instanceValue);
			case ArdslPackage.ARITHM_OPS:
				return convertArithmOpsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ontological createOntological() {
		OntologicalImpl ontological = new OntologicalImpl();
		return ontological;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graphic createGraphic() {
		GraphicImpl graphic = new GraphicImpl();
		return graphic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Physic createPhysic() {
		PhysicImpl physic = new PhysicImpl();
		return physic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Game createGame() {
		GameImpl game = new GameImpl();
		return game;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GamePad createGamePad() {
		GamePadImpl gamePad = new GamePadImpl();
		return gamePad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicClass createGraphicClass() {
		GraphicClassImpl graphicClass = new GraphicClassImpl();
		return graphicClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Versions createVersions() {
		VersionsImpl versions = new VersionsImpl();
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraints createConstraints() {
		ConstraintsImpl constraints = new ConstraintsImpl();
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicClass createPhysicClass() {
		PhysicClassImpl physicClass = new PhysicClassImpl();
		return physicClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicBody createPhysicBody() {
		PhysicBodyImpl physicBody = new PhysicBodyImpl();
		return physicBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitMasks createBitMasks() {
		BitMasksImpl bitMasks = new BitMasksImpl();
		return bitMasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Force createForce() {
		ForceImpl force = new ForceImpl();
		return force;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScoreSystem createScoreSystem() {
		ScoreSystemImpl scoreSystem = new ScoreSystemImpl();
		return scoreSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger createTrigger() {
		TriggerImpl trigger = new TriggerImpl();
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicChange createPhysicChange() {
		PhysicChangeImpl physicChange = new PhysicChangeImpl();
		return physicChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision createCollision() {
		CollisionImpl collision = new CollisionImpl();
		return collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjInit createObjInit() {
		ObjInitImpl objInit = new ObjInitImpl();
		return objInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjAttribute createObjAttribute() {
		ObjAttributeImpl objAttribute = new ObjAttributeImpl();
		return objAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binary createBinary() {
		BinaryImpl binary = new BinaryImpl();
		return binary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arithmetic createArithmetic() {
		ArithmeticImpl arithmetic = new ArithmeticImpl();
		return arithmetic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValue createAttributeValue() {
		AttributeValueImpl attributeValue = new AttributeValueImpl();
		return attributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantValue createConstantValue() {
		ConstantValueImpl constantValue = new ConstantValueImpl();
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllInstances createAllInstances() {
		AllInstancesImpl allInstances = new AllInstancesImpl();
		return allInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Planes createPlanesFromString(EDataType eDataType, String initialValue) {
		Planes result = Planes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlanesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BodyType createBodyTypeFromString(EDataType eDataType, String initialValue) {
		BodyType result = BodyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBodyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gesture createGestureFromString(EDataType eDataType, String initialValue) {
		Gesture result = Gesture.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGestureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicActions createBasicActionsFromString(EDataType eDataType, String initialValue) {
		BasicActions result = BasicActions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBasicActionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createActionFromString(EDataType eDataType, String initialValue) {
		Action result = Action.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position createPositionFromString(EDataType eDataType, String initialValue) {
		Position result = Position.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicOps createLogicOpsFromString(EDataType eDataType, String initialValue) {
		LogicOps result = LogicOps.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicOpsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmOps createArithmOpsFromString(EDataType eDataType, String initialValue) {
		ArithmOps result = ArithmOps.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArithmOpsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArdslPackage getArdslPackage() {
		return (ArdslPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ArdslPackage getPackage() {
		return ArdslPackage.eINSTANCE;
	}

} //ArdslFactoryImpl
