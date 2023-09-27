/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Ardsl.ArdslFactory
 * @model kind="package"
 * @generated
 */
public interface ArdslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Ardsl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ardsl/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Ardsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArdslPackage eINSTANCE = Ardsl.impl.ArdslPackageImpl.init();

	/**
	 * The meta object id for the '{@link Ardsl.impl.OntologicalImpl <em>Ontological</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.OntologicalImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getOntological()
	 * @generated
	 */
	int ONTOLOGICAL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL__CLASSES = 1;

	/**
	 * The feature id for the '<em><b>Graphic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL__GRAPHIC = 2;

	/**
	 * The feature id for the '<em><b>Physic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL__PHYSIC = 3;

	/**
	 * The feature id for the '<em><b>Game</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL__GAME = 4;

	/**
	 * The number of structural features of the '<em>Ontological</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Ontological</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGICAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.GraphicImpl <em>Graphic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.GraphicImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getGraphic()
	 * @generated
	 */
	int GRAPHIC = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC__CLASSES = 0;

	/**
	 * The number of structural features of the '<em>Graphic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Graphic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.PhysicImpl <em>Physic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.PhysicImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getPhysic()
	 * @generated
	 */
	int PHYSIC = 2;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC__CLASSES = 0;

	/**
	 * The number of structural features of the '<em>Physic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Physic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.GameImpl <em>Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.GameImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getGame()
	 * @generated
	 */
	int GAME = 3;

	/**
	 * The feature id for the '<em><b>Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__WIN = 0;

	/**
	 * The feature id for the '<em><b>Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__LOSE = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__START = 2;

	/**
	 * The feature id for the '<em><b>Gamepad</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__GAMEPAD = 3;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__SCORE = 4;

	/**
	 * The feature id for the '<em><b>Actions Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__ACTIONS_TRIGGERS = 5;

	/**
	 * The feature id for the '<em><b>Collisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__COLLISIONS = 6;

	/**
	 * The feature id for the '<em><b>Obj Init</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__OBJ_INIT = 7;

	/**
	 * The number of structural features of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.GamePadImpl <em>Game Pad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.GamePadImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getGamePad()
	 * @generated
	 */
	int GAME_PAD = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_PAD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_PAD__TRIGGER = 1;

	/**
	 * The number of structural features of the '<em>Game Pad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_PAD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Game Pad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_PAD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ClassImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ABSTRACT = 1;

	/**
	 * The feature id for the '<em><b>No SCN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NO_SCN = 2;

	/**
	 * The feature id for the '<em><b>Superclass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERCLASS = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = 4;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFERENCES = 5;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.AttributeImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MIN = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MAX = 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFAULT = 4;

	/**
	 * The feature id for the '<em><b>Is Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_PARAM = 5;

	/**
	 * The feature id for the '<em><b>Is Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_KEY = 6;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__READ_ONLY = 7;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ReferenceImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Containtment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONTAINTMENT = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MIN = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MAX = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TARGET = 4;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__OPPOSITE = 5;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.GraphicClassImpl <em>Graphic Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.GraphicClassImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getGraphicClass()
	 * @generated
	 */
	int GRAPHIC_CLASS = 8;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS__CONSTRAINTS = 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS__CONNECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Onto Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS__ONTO_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS__VERSIONS = 3;

	/**
	 * The number of structural features of the '<em>Graphic Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Graphic Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.VersionsImpl <em>Versions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.VersionsImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getVersions()
	 * @generated
	 */
	int VERSIONS = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS__NAME = 0;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS__URL = 1;

	/**
	 * The number of structural features of the '<em>Versions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Versions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ConstraintsImpl <em>Constraints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ConstraintsImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getConstraints()
	 * @generated
	 */
	int CONSTRAINTS = 10;

	/**
	 * The feature id for the '<em><b>Planes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__PLANES = 0;

	/**
	 * The feature id for the '<em><b>Ilumination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__ILUMINATION = 1;

	/**
	 * The feature id for the '<em><b>Size Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__SIZE_MIN = 2;

	/**
	 * The feature id for the '<em><b>Size Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__SIZE_MAX = 3;

	/**
	 * The feature id for the '<em><b>Size Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__SIZE_INIT = 4;

	/**
	 * The feature id for the '<em><b>Overlapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__OVERLAPPING = 5;

	/**
	 * The feature id for the '<em><b>XTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__XTO_ORIGIN_POS = 6;

	/**
	 * The feature id for the '<em><b>YTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__YTO_ORIGIN_POS = 7;

	/**
	 * The feature id for the '<em><b>ZTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__ZTO_ORIGIN_POS = 8;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__ROTATION = 9;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__TEXT = 10;

	/**
	 * The feature id for the '<em><b>Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__TEXT_COLOR = 11;

	/**
	 * The number of structural features of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ConnectionImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__COLOR = 2;

	/**
	 * The feature id for the '<em><b>Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TEXT_COLOR = 3;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DECORATOR = 4;

	/**
	 * The feature id for the '<em><b>Decorator Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DECORATOR_POS = 5;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PATTERN = 6;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__WIDTH = 7;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__POSITION = 8;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.PhysicClassImpl <em>Physic Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.PhysicClassImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getPhysicClass()
	 * @generated
	 */
	int PHYSIC_CLASS = 12;

	/**
	 * The feature id for the '<em><b>Physic Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS__PHYSIC_BODY = 0;

	/**
	 * The feature id for the '<em><b>Bit Masks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS__BIT_MASKS = 1;

	/**
	 * The feature id for the '<em><b>Onto Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS__ONTO_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Forces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS__FORCES = 3;

	/**
	 * The number of structural features of the '<em>Physic Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Physic Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.PhysicBodyImpl <em>Physic Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.PhysicBodyImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getPhysicBody()
	 * @generated
	 */
	int PHYSIC_BODY = 13;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__MASS = 0;

	/**
	 * The feature id for the '<em><b>Body Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__BODY_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Charge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__CHARGE = 2;

	/**
	 * The feature id for the '<em><b>Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__FRICTION = 3;

	/**
	 * The feature id for the '<em><b>Rolling Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__ROLLING_FRICTION = 4;

	/**
	 * The feature id for the '<em><b>Restitution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__RESTITUTION = 5;

	/**
	 * The feature id for the '<em><b>Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__DAMPING = 6;

	/**
	 * The feature id for the '<em><b>Angular Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY__ANGULAR_DAMPING = 7;

	/**
	 * The number of structural features of the '<em>Physic Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Physic Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_BODY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.BitMasksImpl <em>Bit Masks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.BitMasksImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getBitMasks()
	 * @generated
	 */
	int BIT_MASKS = 14;

	/**
	 * The feature id for the '<em><b>Collision</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_MASKS__COLLISION = 0;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_MASKS__CONTACT = 1;

	/**
	 * The number of structural features of the '<em>Bit Masks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_MASKS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Bit Masks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_MASKS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ForceImpl <em>Force</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ForceImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getForce()
	 * @generated
	 */
	int FORCE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Gesture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE__GESTURE = 1;

	/**
	 * The feature id for the '<em><b>XVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE__XVECTOR = 2;

	/**
	 * The feature id for the '<em><b>YVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE__YVECTOR = 3;

	/**
	 * The feature id for the '<em><b>ZVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE__ZVECTOR = 4;

	/**
	 * The number of structural features of the '<em>Force</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Force</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ScoreSystemImpl <em>Score System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ScoreSystemImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getScoreSystem()
	 * @generated
	 */
	int SCORE_SYSTEM = 16;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_SYSTEM__START = 0;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_SYSTEM__FINISH = 1;

	/**
	 * The feature id for the '<em><b>Lives</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_SYSTEM__LIVES = 2;

	/**
	 * The number of structural features of the '<em>Score System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Score System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.TriggerImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Time Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__TIME_TRIGGER = 2;

	/**
	 * The feature id for the '<em><b>Score Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__SCORE_CHANGE = 3;

	/**
	 * The feature id for the '<em><b>Physic Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PHYSIC_CHANGES = 4;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__ACTION = 5;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.PhysicChangeImpl <em>Physic Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.PhysicChangeImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getPhysicChange()
	 * @generated
	 */
	int PHYSIC_CHANGE = 18;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__ACTION = 1;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__CLASS = 2;

	/**
	 * The feature id for the '<em><b>Force</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__FORCE = 3;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__POSITION = 4;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__SCALE = 6;

	/**
	 * The feature id for the '<em><b>Change Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE__CHANGE_VALUE = 7;

	/**
	 * The number of structural features of the '<em>Physic Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Physic Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSIC_CHANGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.CollisionImpl <em>Collision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.CollisionImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getCollision()
	 * @generated
	 */
	int COLLISION = 19;

	/**
	 * The feature id for the '<em><b>Class A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__CLASS_A = 0;

	/**
	 * The feature id for the '<em><b>Class B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__CLASS_B = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__ACTION = 2;

	/**
	 * The number of structural features of the '<em>Collision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Collision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ObjInitImpl <em>Obj Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ObjInitImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getObjInit()
	 * @generated
	 */
	int OBJ_INIT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Pos X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__POS_X = 1;

	/**
	 * The feature id for the '<em><b>Pos Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__POS_Y = 2;

	/**
	 * The feature id for the '<em><b>Pos Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__POS_Z = 3;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__CLASS = 4;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__RULES = 6;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT__ROTATION = 7;

	/**
	 * The number of structural features of the '<em>Obj Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Obj Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_INIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ObjAttributeImpl <em>Obj Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ObjAttributeImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getObjAttribute()
	 * @generated
	 */
	int OBJ_ATTRIBUTE = 21;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_ATTRIBUTE__ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Obj Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Obj Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.RuleImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 22;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ConditionImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 23;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.LogicOpImpl <em>Logic Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.LogicOpImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getLogicOp()
	 * @generated
	 */
	int LOGIC_OP = 24;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_OP__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Logic Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_OP_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Logic Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_OP_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.NotImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 25;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__LEFT = LOGIC_OP__LEFT;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = LOGIC_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = LOGIC_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.BinaryImpl <em>Binary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.BinaryImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getBinary()
	 * @generated
	 */
	int BINARY = 26;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__LEFT = LOGIC_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__RIGHT = LOGIC_OP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__OP = LOGIC_OP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_COUNT = LOGIC_OP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION_COUNT = LOGIC_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ArithmeticImpl <em>Arithmetic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ArithmeticImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getArithmetic()
	 * @generated
	 */
	int ARITHMETIC = 27;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC__OP = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC__RIGHT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC__LEFT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Arithmetic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Arithmetic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ValueImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 28;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.AttributeValueImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getAttributeValue()
	 * @generated
	 */
	int ATTRIBUTE_VALUE = 29;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__CLASS = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__ATTRIBUTE = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.ConstantValueImpl <em>Constant Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.ConstantValueImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getConstantValue()
	 * @generated
	 */
	int CONSTANT_VALUE = 30;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.impl.AllInstancesImpl <em>All Instances</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.impl.AllInstancesImpl
	 * @see Ardsl.impl.ArdslPackageImpl#getAllInstances()
	 * @generated
	 */
	int ALL_INSTANCES = 31;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCES__TYPE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>All Instances</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCES_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>All Instances</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCES_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Ardsl.Planes <em>Planes</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.Planes
	 * @see Ardsl.impl.ArdslPackageImpl#getPlanes()
	 * @generated
	 */
	int PLANES = 32;

	/**
	 * The meta object id for the '{@link Ardsl.BodyType <em>Body Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.BodyType
	 * @see Ardsl.impl.ArdslPackageImpl#getBodyType()
	 * @generated
	 */
	int BODY_TYPE = 33;

	/**
	 * The meta object id for the '{@link Ardsl.Gesture <em>Gesture</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.Gesture
	 * @see Ardsl.impl.ArdslPackageImpl#getGesture()
	 * @generated
	 */
	int GESTURE = 34;

	/**
	 * The meta object id for the '{@link Ardsl.BasicActions <em>Basic Actions</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.BasicActions
	 * @see Ardsl.impl.ArdslPackageImpl#getBasicActions()
	 * @generated
	 */
	int BASIC_ACTIONS = 35;

	/**
	 * The meta object id for the '{@link Ardsl.Action <em>Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.Action
	 * @see Ardsl.impl.ArdslPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 36;

	/**
	 * The meta object id for the '{@link Ardsl.Position <em>Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.Position
	 * @see Ardsl.impl.ArdslPackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 37;

	/**
	 * The meta object id for the '{@link Ardsl.LogicOps <em>Logic Ops</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.LogicOps
	 * @see Ardsl.impl.ArdslPackageImpl#getLogicOps()
	 * @generated
	 */
	int LOGIC_OPS = 38;

	/**
	 * The meta object id for the '{@link Ardsl.ArithmOps <em>Arithm Ops</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Ardsl.ArithmOps
	 * @see Ardsl.impl.ArdslPackageImpl#getArithmOps()
	 * @generated
	 */
	int ARITHM_OPS = 39;


	/**
	 * Returns the meta object for class '{@link Ardsl.Ontological <em>Ontological</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ontological</em>'.
	 * @see Ardsl.Ontological
	 * @generated
	 */
	EClass getOntological();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Ontological#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Ontological#getName()
	 * @see #getOntological()
	 * @generated
	 */
	EAttribute getOntological_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Ontological#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see Ardsl.Ontological#getClasses()
	 * @see #getOntological()
	 * @generated
	 */
	EReference getOntological_Classes();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Ontological#getGraphic <em>Graphic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graphic</em>'.
	 * @see Ardsl.Ontological#getGraphic()
	 * @see #getOntological()
	 * @generated
	 */
	EReference getOntological_Graphic();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Ontological#getPhysic <em>Physic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Physic</em>'.
	 * @see Ardsl.Ontological#getPhysic()
	 * @see #getOntological()
	 * @generated
	 */
	EReference getOntological_Physic();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Ontological#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Game</em>'.
	 * @see Ardsl.Ontological#getGame()
	 * @see #getOntological()
	 * @generated
	 */
	EReference getOntological_Game();

	/**
	 * Returns the meta object for class '{@link Ardsl.Graphic <em>Graphic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic</em>'.
	 * @see Ardsl.Graphic
	 * @generated
	 */
	EClass getGraphic();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Graphic#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see Ardsl.Graphic#getClasses()
	 * @see #getGraphic()
	 * @generated
	 */
	EReference getGraphic_Classes();

	/**
	 * Returns the meta object for class '{@link Ardsl.Physic <em>Physic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physic</em>'.
	 * @see Ardsl.Physic
	 * @generated
	 */
	EClass getPhysic();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Physic#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see Ardsl.Physic#getClasses()
	 * @see #getPhysic()
	 * @generated
	 */
	EReference getPhysic_Classes();

	/**
	 * Returns the meta object for class '{@link Ardsl.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game</em>'.
	 * @see Ardsl.Game
	 * @generated
	 */
	EClass getGame();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Game#getWin <em>Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Win</em>'.
	 * @see Ardsl.Game#getWin()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Win();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Game#getLose <em>Lose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lose</em>'.
	 * @see Ardsl.Game#getLose()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Lose();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Game#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see Ardsl.Game#getStart()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Start();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Game#getGamepad <em>Gamepad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gamepad</em>'.
	 * @see Ardsl.Game#getGamepad()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Gamepad();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Game#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Score</em>'.
	 * @see Ardsl.Game#getScore()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Score();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Game#getActionsTriggers <em>Actions Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Triggers</em>'.
	 * @see Ardsl.Game#getActionsTriggers()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_ActionsTriggers();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Game#getCollisions <em>Collisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collisions</em>'.
	 * @see Ardsl.Game#getCollisions()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Collisions();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Game#getObjInit <em>Obj Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Obj Init</em>'.
	 * @see Ardsl.Game#getObjInit()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_ObjInit();

	/**
	 * Returns the meta object for class '{@link Ardsl.GamePad <em>Game Pad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game Pad</em>'.
	 * @see Ardsl.GamePad
	 * @generated
	 */
	EClass getGamePad();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.GamePad#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.GamePad#getName()
	 * @see #getGamePad()
	 * @generated
	 */
	EAttribute getGamePad_Name();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.GamePad#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigger</em>'.
	 * @see Ardsl.GamePad#getTrigger()
	 * @see #getGamePad()
	 * @generated
	 */
	EReference getGamePad_Trigger();

	/**
	 * Returns the meta object for class '{@link Ardsl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see Ardsl.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Class#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Class#getName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Class#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see Ardsl.Class#isAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Class#isNoSCN <em>No SCN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No SCN</em>'.
	 * @see Ardsl.Class#isNoSCN()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_NoSCN();

	/**
	 * Returns the meta object for the reference list '{@link Ardsl.Class#getSuperclass <em>Superclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Superclass</em>'.
	 * @see Ardsl.Class#getSuperclass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Superclass();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see Ardsl.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see Ardsl.Class#getReferences()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_References();

	/**
	 * Returns the meta object for class '{@link Ardsl.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see Ardsl.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Ardsl.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see Ardsl.Attribute#getMin()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Min();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see Ardsl.Attribute#getMax()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Max();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see Ardsl.Attribute#getDefault()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Default();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#isIsParam <em>Is Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Param</em>'.
	 * @see Ardsl.Attribute#isIsParam()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsParam();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#isIsKey <em>Is Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Key</em>'.
	 * @see Ardsl.Attribute#isIsKey()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsKey();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Attribute#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see Ardsl.Attribute#isReadOnly()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_ReadOnly();

	/**
	 * Returns the meta object for class '{@link Ardsl.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see Ardsl.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Reference#getName()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getContaintment <em>Containtment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Containtment</em>'.
	 * @see Ardsl.Reference#getContaintment()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Containtment();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see Ardsl.Reference#getMin()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Min();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see Ardsl.Reference#getMax()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Max();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see Ardsl.Reference#getTarget()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Target();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Reference#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite</em>'.
	 * @see Ardsl.Reference#getOpposite()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Opposite();

	/**
	 * Returns the meta object for class '{@link Ardsl.GraphicClass <em>Graphic Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Class</em>'.
	 * @see Ardsl.GraphicClass
	 * @generated
	 */
	EClass getGraphicClass();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.GraphicClass#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see Ardsl.GraphicClass#getConstraints()
	 * @see #getGraphicClass()
	 * @generated
	 */
	EReference getGraphicClass_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.GraphicClass#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see Ardsl.GraphicClass#getConnections()
	 * @see #getGraphicClass()
	 * @generated
	 */
	EReference getGraphicClass_Connections();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.GraphicClass#getOntoClass <em>Onto Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Onto Class</em>'.
	 * @see Ardsl.GraphicClass#getOntoClass()
	 * @see #getGraphicClass()
	 * @generated
	 */
	EReference getGraphicClass_OntoClass();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.GraphicClass#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see Ardsl.GraphicClass#getVersions()
	 * @see #getGraphicClass()
	 * @generated
	 */
	EReference getGraphicClass_Versions();

	/**
	 * Returns the meta object for class '{@link Ardsl.Versions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versions</em>'.
	 * @see Ardsl.Versions
	 * @generated
	 */
	EClass getVersions();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Versions#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Versions#getName()
	 * @see #getVersions()
	 * @generated
	 */
	EAttribute getVersions_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Versions#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see Ardsl.Versions#getURL()
	 * @see #getVersions()
	 * @generated
	 */
	EAttribute getVersions_URL();

	/**
	 * Returns the meta object for class '{@link Ardsl.Constraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraints</em>'.
	 * @see Ardsl.Constraints
	 * @generated
	 */
	EClass getConstraints();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getPlanes <em>Planes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Planes</em>'.
	 * @see Ardsl.Constraints#getPlanes()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_Planes();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getIlumination <em>Ilumination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ilumination</em>'.
	 * @see Ardsl.Constraints#getIlumination()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_Ilumination();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getSizeMin <em>Size Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Min</em>'.
	 * @see Ardsl.Constraints#getSizeMin()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_SizeMin();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getSizeMax <em>Size Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Max</em>'.
	 * @see Ardsl.Constraints#getSizeMax()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_SizeMax();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getSizeInit <em>Size Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Init</em>'.
	 * @see Ardsl.Constraints#getSizeInit()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_SizeInit();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#isOverlapping <em>Overlapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overlapping</em>'.
	 * @see Ardsl.Constraints#isOverlapping()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_Overlapping();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getXToOriginPos <em>XTo Origin Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XTo Origin Pos</em>'.
	 * @see Ardsl.Constraints#getXToOriginPos()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_XToOriginPos();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getYToOriginPos <em>YTo Origin Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YTo Origin Pos</em>'.
	 * @see Ardsl.Constraints#getYToOriginPos()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_YToOriginPos();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getZToOriginPos <em>ZTo Origin Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZTo Origin Pos</em>'.
	 * @see Ardsl.Constraints#getZToOriginPos()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_ZToOriginPos();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see Ardsl.Constraints#getRotation()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_Rotation();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see Ardsl.Constraints#getText()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_Text();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Constraints#getTextColor <em>Text Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Color</em>'.
	 * @see Ardsl.Constraints#getTextColor()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_TextColor();

	/**
	 * Returns the meta object for class '{@link Ardsl.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see Ardsl.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Connection#getName()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Ardsl.Connection#getType()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Type();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see Ardsl.Connection#getColor()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Color();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getTextColor <em>Text Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Color</em>'.
	 * @see Ardsl.Connection#getTextColor()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_TextColor();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getDecorator <em>Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator</em>'.
	 * @see Ardsl.Connection#getDecorator()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Decorator();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getDecoratorPos <em>Decorator Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator Pos</em>'.
	 * @see Ardsl.Connection#getDecoratorPos()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_DecoratorPos();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see Ardsl.Connection#getPattern()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see Ardsl.Connection#getWidth()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Width();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Connection#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see Ardsl.Connection#getPosition()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Position();

	/**
	 * Returns the meta object for class '{@link Ardsl.PhysicClass <em>Physic Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physic Class</em>'.
	 * @see Ardsl.PhysicClass
	 * @generated
	 */
	EClass getPhysicClass();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.PhysicClass#getPhysicBody <em>Physic Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Physic Body</em>'.
	 * @see Ardsl.PhysicClass#getPhysicBody()
	 * @see #getPhysicClass()
	 * @generated
	 */
	EReference getPhysicClass_PhysicBody();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.PhysicClass#getBitMasks <em>Bit Masks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bit Masks</em>'.
	 * @see Ardsl.PhysicClass#getBitMasks()
	 * @see #getPhysicClass()
	 * @generated
	 */
	EReference getPhysicClass_BitMasks();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.PhysicClass#getOntoClass <em>Onto Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Onto Class</em>'.
	 * @see Ardsl.PhysicClass#getOntoClass()
	 * @see #getPhysicClass()
	 * @generated
	 */
	EReference getPhysicClass_OntoClass();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.PhysicClass#getForces <em>Forces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forces</em>'.
	 * @see Ardsl.PhysicClass#getForces()
	 * @see #getPhysicClass()
	 * @generated
	 */
	EReference getPhysicClass_Forces();

	/**
	 * Returns the meta object for class '{@link Ardsl.PhysicBody <em>Physic Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physic Body</em>'.
	 * @see Ardsl.PhysicBody
	 * @generated
	 */
	EClass getPhysicBody();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getMass <em>Mass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mass</em>'.
	 * @see Ardsl.PhysicBody#getMass()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_Mass();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getBodyType <em>Body Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body Type</em>'.
	 * @see Ardsl.PhysicBody#getBodyType()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_BodyType();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getCharge <em>Charge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Charge</em>'.
	 * @see Ardsl.PhysicBody#getCharge()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_Charge();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getFriction <em>Friction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Friction</em>'.
	 * @see Ardsl.PhysicBody#getFriction()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_Friction();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getRollingFriction <em>Rolling Friction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rolling Friction</em>'.
	 * @see Ardsl.PhysicBody#getRollingFriction()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_RollingFriction();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getRestitution <em>Restitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restitution</em>'.
	 * @see Ardsl.PhysicBody#getRestitution()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_Restitution();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getDamping <em>Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damping</em>'.
	 * @see Ardsl.PhysicBody#getDamping()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_Damping();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicBody#getAngularDamping <em>Angular Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Angular Damping</em>'.
	 * @see Ardsl.PhysicBody#getAngularDamping()
	 * @see #getPhysicBody()
	 * @generated
	 */
	EAttribute getPhysicBody_AngularDamping();

	/**
	 * Returns the meta object for class '{@link Ardsl.BitMasks <em>Bit Masks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bit Masks</em>'.
	 * @see Ardsl.BitMasks
	 * @generated
	 */
	EClass getBitMasks();

	/**
	 * Returns the meta object for the reference list '{@link Ardsl.BitMasks#getCollision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collision</em>'.
	 * @see Ardsl.BitMasks#getCollision()
	 * @see #getBitMasks()
	 * @generated
	 */
	EReference getBitMasks_Collision();

	/**
	 * Returns the meta object for the reference list '{@link Ardsl.BitMasks#getContact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contact</em>'.
	 * @see Ardsl.BitMasks#getContact()
	 * @see #getBitMasks()
	 * @generated
	 */
	EReference getBitMasks_Contact();

	/**
	 * Returns the meta object for class '{@link Ardsl.Force <em>Force</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Force</em>'.
	 * @see Ardsl.Force
	 * @generated
	 */
	EClass getForce();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Force#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Force#getName()
	 * @see #getForce()
	 * @generated
	 */
	EAttribute getForce_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Force#getGesture <em>Gesture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gesture</em>'.
	 * @see Ardsl.Force#getGesture()
	 * @see #getForce()
	 * @generated
	 */
	EAttribute getForce_Gesture();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Force#getXVector <em>XVector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XVector</em>'.
	 * @see Ardsl.Force#getXVector()
	 * @see #getForce()
	 * @generated
	 */
	EAttribute getForce_XVector();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Force#getYVector <em>YVector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YVector</em>'.
	 * @see Ardsl.Force#getYVector()
	 * @see #getForce()
	 * @generated
	 */
	EAttribute getForce_YVector();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Force#getZVector <em>ZVector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZVector</em>'.
	 * @see Ardsl.Force#getZVector()
	 * @see #getForce()
	 * @generated
	 */
	EAttribute getForce_ZVector();

	/**
	 * Returns the meta object for class '{@link Ardsl.ScoreSystem <em>Score System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score System</em>'.
	 * @see Ardsl.ScoreSystem
	 * @generated
	 */
	EClass getScoreSystem();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ScoreSystem#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see Ardsl.ScoreSystem#getStart()
	 * @see #getScoreSystem()
	 * @generated
	 */
	EAttribute getScoreSystem_Start();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ScoreSystem#getFinish <em>Finish</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Finish</em>'.
	 * @see Ardsl.ScoreSystem#getFinish()
	 * @see #getScoreSystem()
	 * @generated
	 */
	EAttribute getScoreSystem_Finish();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ScoreSystem#getLives <em>Lives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lives</em>'.
	 * @see Ardsl.ScoreSystem#getLives()
	 * @see #getScoreSystem()
	 * @generated
	 */
	EAttribute getScoreSystem_Lives();

	/**
	 * Returns the meta object for class '{@link Ardsl.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see Ardsl.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Trigger#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.Trigger#getName()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Trigger#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see Ardsl.Trigger#getMessage()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_Message();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Trigger#getTimeTrigger <em>Time Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Trigger</em>'.
	 * @see Ardsl.Trigger#getTimeTrigger()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_TimeTrigger();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Trigger#getScoreChange <em>Score Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score Change</em>'.
	 * @see Ardsl.Trigger#getScoreChange()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_ScoreChange();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.Trigger#getPhysicChanges <em>Physic Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Physic Changes</em>'.
	 * @see Ardsl.Trigger#getPhysicChanges()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_PhysicChanges();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Trigger#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see Ardsl.Trigger#getAction()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_Action();

	/**
	 * Returns the meta object for class '{@link Ardsl.PhysicChange <em>Physic Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physic Change</em>'.
	 * @see Ardsl.PhysicChange
	 * @generated
	 */
	EClass getPhysicChange();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see Ardsl.PhysicChange#getObject()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_Object();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see Ardsl.PhysicChange#getAction()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_Action();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.PhysicChange#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see Ardsl.PhysicChange#getClass_()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EReference getPhysicChange_Class();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.PhysicChange#getForce <em>Force</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Force</em>'.
	 * @see Ardsl.PhysicChange#getForce()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EReference getPhysicChange_Force();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see Ardsl.PhysicChange#getPosition()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_Position();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see Ardsl.PhysicChange#getAttribute()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see Ardsl.PhysicChange#getScale()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_Scale();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.PhysicChange#getChangeValue <em>Change Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Value</em>'.
	 * @see Ardsl.PhysicChange#getChangeValue()
	 * @see #getPhysicChange()
	 * @generated
	 */
	EAttribute getPhysicChange_ChangeValue();

	/**
	 * Returns the meta object for class '{@link Ardsl.Collision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collision</em>'.
	 * @see Ardsl.Collision
	 * @generated
	 */
	EClass getCollision();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.Collision#getClassA <em>Class A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class A</em>'.
	 * @see Ardsl.Collision#getClassA()
	 * @see #getCollision()
	 * @generated
	 */
	EReference getCollision_ClassA();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.Collision#getClassB <em>Class B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class B</em>'.
	 * @see Ardsl.Collision#getClassB()
	 * @see #getCollision()
	 * @generated
	 */
	EReference getCollision_ClassB();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.Collision#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see Ardsl.Collision#getAction()
	 * @see #getCollision()
	 * @generated
	 */
	EReference getCollision_Action();

	/**
	 * Returns the meta object for class '{@link Ardsl.ObjInit <em>Obj Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Obj Init</em>'.
	 * @see Ardsl.ObjInit
	 * @generated
	 */
	EClass getObjInit();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjInit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Ardsl.ObjInit#getName()
	 * @see #getObjInit()
	 * @generated
	 */
	EAttribute getObjInit_Name();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjInit#getPosX <em>Pos X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos X</em>'.
	 * @see Ardsl.ObjInit#getPosX()
	 * @see #getObjInit()
	 * @generated
	 */
	EAttribute getObjInit_PosX();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjInit#getPosY <em>Pos Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos Y</em>'.
	 * @see Ardsl.ObjInit#getPosY()
	 * @see #getObjInit()
	 * @generated
	 */
	EAttribute getObjInit_PosY();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjInit#getPosZ <em>Pos Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos Z</em>'.
	 * @see Ardsl.ObjInit#getPosZ()
	 * @see #getObjInit()
	 * @generated
	 */
	EAttribute getObjInit_PosZ();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.ObjInit#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see Ardsl.ObjInit#getClass_()
	 * @see #getObjInit()
	 * @generated
	 */
	EReference getObjInit_Class();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.ObjInit#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see Ardsl.ObjInit#getAttribute()
	 * @see #getObjInit()
	 * @generated
	 */
	EReference getObjInit_Attribute();

	/**
	 * Returns the meta object for the containment reference list '{@link Ardsl.ObjInit#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see Ardsl.ObjInit#getRules()
	 * @see #getObjInit()
	 * @generated
	 */
	EReference getObjInit_Rules();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjInit#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see Ardsl.ObjInit#getRotation()
	 * @see #getObjInit()
	 * @generated
	 */
	EAttribute getObjInit_Rotation();

	/**
	 * Returns the meta object for class '{@link Ardsl.ObjAttribute <em>Obj Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Obj Attribute</em>'.
	 * @see Ardsl.ObjAttribute
	 * @generated
	 */
	EClass getObjAttribute();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.ObjAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see Ardsl.ObjAttribute#getAttribute()
	 * @see #getObjAttribute()
	 * @generated
	 */
	EReference getObjAttribute_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ObjAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Ardsl.ObjAttribute#getValue()
	 * @see #getObjAttribute()
	 * @generated
	 */
	EAttribute getObjAttribute_Value();

	/**
	 * Returns the meta object for class '{@link Ardsl.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see Ardsl.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the reference '{@link Ardsl.Rule#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see Ardsl.Rule#getAction()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Action();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Rule#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see Ardsl.Rule#getCondition()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Condition();

	/**
	 * Returns the meta object for class '{@link Ardsl.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see Ardsl.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link Ardsl.LogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logic Op</em>'.
	 * @see Ardsl.LogicOp
	 * @generated
	 */
	EClass getLogicOp();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.LogicOp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see Ardsl.LogicOp#getLeft()
	 * @see #getLogicOp()
	 * @generated
	 */
	EReference getLogicOp_Left();

	/**
	 * Returns the meta object for class '{@link Ardsl.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see Ardsl.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link Ardsl.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary</em>'.
	 * @see Ardsl.Binary
	 * @generated
	 */
	EClass getBinary();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Binary#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see Ardsl.Binary#getRight()
	 * @see #getBinary()
	 * @generated
	 */
	EReference getBinary_Right();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Binary#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see Ardsl.Binary#getOp()
	 * @see #getBinary()
	 * @generated
	 */
	EAttribute getBinary_Op();

	/**
	 * Returns the meta object for class '{@link Ardsl.Arithmetic <em>Arithmetic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic</em>'.
	 * @see Ardsl.Arithmetic
	 * @generated
	 */
	EClass getArithmetic();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.Arithmetic#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see Ardsl.Arithmetic#getOp()
	 * @see #getArithmetic()
	 * @generated
	 */
	EAttribute getArithmetic_Op();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Arithmetic#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see Ardsl.Arithmetic#getRight()
	 * @see #getArithmetic()
	 * @generated
	 */
	EReference getArithmetic_Right();

	/**
	 * Returns the meta object for the containment reference '{@link Ardsl.Arithmetic#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see Ardsl.Arithmetic#getLeft()
	 * @see #getArithmetic()
	 * @generated
	 */
	EReference getArithmetic_Left();

	/**
	 * Returns the meta object for class '{@link Ardsl.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see Ardsl.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link Ardsl.AttributeValue <em>Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value</em>'.
	 * @see Ardsl.AttributeValue
	 * @generated
	 */
	EClass getAttributeValue();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.AttributeValue#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see Ardsl.AttributeValue#getClass_()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EAttribute getAttributeValue_Class();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.AttributeValue#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see Ardsl.AttributeValue#getAttribute()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EAttribute getAttributeValue_Attribute();

	/**
	 * Returns the meta object for class '{@link Ardsl.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Value</em>'.
	 * @see Ardsl.ConstantValue
	 * @generated
	 */
	EClass getConstantValue();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.ConstantValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Ardsl.ConstantValue#getValue()
	 * @see #getConstantValue()
	 * @generated
	 */
	EAttribute getConstantValue_Value();

	/**
	 * Returns the meta object for class '{@link Ardsl.AllInstances <em>All Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Instances</em>'.
	 * @see Ardsl.AllInstances
	 * @generated
	 */
	EClass getAllInstances();

	/**
	 * Returns the meta object for the attribute '{@link Ardsl.AllInstances#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Ardsl.AllInstances#getType()
	 * @see #getAllInstances()
	 * @generated
	 */
	EAttribute getAllInstances_Type();

	/**
	 * Returns the meta object for enum '{@link Ardsl.Planes <em>Planes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Planes</em>'.
	 * @see Ardsl.Planes
	 * @generated
	 */
	EEnum getPlanes();

	/**
	 * Returns the meta object for enum '{@link Ardsl.BodyType <em>Body Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Body Type</em>'.
	 * @see Ardsl.BodyType
	 * @generated
	 */
	EEnum getBodyType();

	/**
	 * Returns the meta object for enum '{@link Ardsl.Gesture <em>Gesture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gesture</em>'.
	 * @see Ardsl.Gesture
	 * @generated
	 */
	EEnum getGesture();

	/**
	 * Returns the meta object for enum '{@link Ardsl.BasicActions <em>Basic Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Basic Actions</em>'.
	 * @see Ardsl.BasicActions
	 * @generated
	 */
	EEnum getBasicActions();

	/**
	 * Returns the meta object for enum '{@link Ardsl.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action</em>'.
	 * @see Ardsl.Action
	 * @generated
	 */
	EEnum getAction();

	/**
	 * Returns the meta object for enum '{@link Ardsl.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Position</em>'.
	 * @see Ardsl.Position
	 * @generated
	 */
	EEnum getPosition();

	/**
	 * Returns the meta object for enum '{@link Ardsl.LogicOps <em>Logic Ops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logic Ops</em>'.
	 * @see Ardsl.LogicOps
	 * @generated
	 */
	EEnum getLogicOps();

	/**
	 * Returns the meta object for enum '{@link Ardsl.ArithmOps <em>Arithm Ops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Arithm Ops</em>'.
	 * @see Ardsl.ArithmOps
	 * @generated
	 */
	EEnum getArithmOps();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArdslFactory getArdslFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Ardsl.impl.OntologicalImpl <em>Ontological</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.OntologicalImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getOntological()
		 * @generated
		 */
		EClass ONTOLOGICAL = eINSTANCE.getOntological();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGICAL__NAME = eINSTANCE.getOntological_Name();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGICAL__CLASSES = eINSTANCE.getOntological_Classes();

		/**
		 * The meta object literal for the '<em><b>Graphic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGICAL__GRAPHIC = eINSTANCE.getOntological_Graphic();

		/**
		 * The meta object literal for the '<em><b>Physic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGICAL__PHYSIC = eINSTANCE.getOntological_Physic();

		/**
		 * The meta object literal for the '<em><b>Game</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGICAL__GAME = eINSTANCE.getOntological_Game();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.GraphicImpl <em>Graphic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.GraphicImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getGraphic()
		 * @generated
		 */
		EClass GRAPHIC = eINSTANCE.getGraphic();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC__CLASSES = eINSTANCE.getGraphic_Classes();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.PhysicImpl <em>Physic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.PhysicImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getPhysic()
		 * @generated
		 */
		EClass PHYSIC = eINSTANCE.getPhysic();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC__CLASSES = eINSTANCE.getPhysic_Classes();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.GameImpl <em>Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.GameImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getGame()
		 * @generated
		 */
		EClass GAME = eINSTANCE.getGame();

		/**
		 * The meta object literal for the '<em><b>Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__WIN = eINSTANCE.getGame_Win();

		/**
		 * The meta object literal for the '<em><b>Lose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__LOSE = eINSTANCE.getGame_Lose();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__START = eINSTANCE.getGame_Start();

		/**
		 * The meta object literal for the '<em><b>Gamepad</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__GAMEPAD = eINSTANCE.getGame_Gamepad();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__SCORE = eINSTANCE.getGame_Score();

		/**
		 * The meta object literal for the '<em><b>Actions Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__ACTIONS_TRIGGERS = eINSTANCE.getGame_ActionsTriggers();

		/**
		 * The meta object literal for the '<em><b>Collisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__COLLISIONS = eINSTANCE.getGame_Collisions();

		/**
		 * The meta object literal for the '<em><b>Obj Init</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__OBJ_INIT = eINSTANCE.getGame_ObjInit();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.GamePadImpl <em>Game Pad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.GamePadImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getGamePad()
		 * @generated
		 */
		EClass GAME_PAD = eINSTANCE.getGamePad();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_PAD__NAME = eINSTANCE.getGamePad_Name();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_PAD__TRIGGER = eINSTANCE.getGamePad_Trigger();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ClassImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__ABSTRACT = eINSTANCE.getClass_Abstract();

		/**
		 * The meta object literal for the '<em><b>No SCN</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NO_SCN = eINSTANCE.getClass_NoSCN();

		/**
		 * The meta object literal for the '<em><b>Superclass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPERCLASS = eINSTANCE.getClass_Superclass();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REFERENCES = eINSTANCE.getClass_References();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.AttributeImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MIN = eINSTANCE.getAttribute_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MAX = eINSTANCE.getAttribute_Max();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DEFAULT = eINSTANCE.getAttribute_Default();

		/**
		 * The meta object literal for the '<em><b>Is Param</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IS_PARAM = eINSTANCE.getAttribute_IsParam();

		/**
		 * The meta object literal for the '<em><b>Is Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IS_KEY = eINSTANCE.getAttribute_IsKey();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__READ_ONLY = eINSTANCE.getAttribute_ReadOnly();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ReferenceImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__NAME = eINSTANCE.getReference_Name();

		/**
		 * The meta object literal for the '<em><b>Containtment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__CONTAINTMENT = eINSTANCE.getReference_Containtment();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__MIN = eINSTANCE.getReference_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__MAX = eINSTANCE.getReference_Max();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__TARGET = eINSTANCE.getReference_Target();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__OPPOSITE = eINSTANCE.getReference_Opposite();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.GraphicClassImpl <em>Graphic Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.GraphicClassImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getGraphicClass()
		 * @generated
		 */
		EClass GRAPHIC_CLASS = eINSTANCE.getGraphicClass();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CLASS__CONSTRAINTS = eINSTANCE.getGraphicClass_Constraints();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CLASS__CONNECTIONS = eINSTANCE.getGraphicClass_Connections();

		/**
		 * The meta object literal for the '<em><b>Onto Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CLASS__ONTO_CLASS = eINSTANCE.getGraphicClass_OntoClass();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CLASS__VERSIONS = eINSTANCE.getGraphicClass_Versions();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.VersionsImpl <em>Versions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.VersionsImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getVersions()
		 * @generated
		 */
		EClass VERSIONS = eINSTANCE.getVersions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONS__NAME = eINSTANCE.getVersions_Name();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONS__URL = eINSTANCE.getVersions_URL();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ConstraintsImpl <em>Constraints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ConstraintsImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getConstraints()
		 * @generated
		 */
		EClass CONSTRAINTS = eINSTANCE.getConstraints();

		/**
		 * The meta object literal for the '<em><b>Planes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__PLANES = eINSTANCE.getConstraints_Planes();

		/**
		 * The meta object literal for the '<em><b>Ilumination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__ILUMINATION = eINSTANCE.getConstraints_Ilumination();

		/**
		 * The meta object literal for the '<em><b>Size Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__SIZE_MIN = eINSTANCE.getConstraints_SizeMin();

		/**
		 * The meta object literal for the '<em><b>Size Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__SIZE_MAX = eINSTANCE.getConstraints_SizeMax();

		/**
		 * The meta object literal for the '<em><b>Size Init</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__SIZE_INIT = eINSTANCE.getConstraints_SizeInit();

		/**
		 * The meta object literal for the '<em><b>Overlapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__OVERLAPPING = eINSTANCE.getConstraints_Overlapping();

		/**
		 * The meta object literal for the '<em><b>XTo Origin Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__XTO_ORIGIN_POS = eINSTANCE.getConstraints_XToOriginPos();

		/**
		 * The meta object literal for the '<em><b>YTo Origin Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__YTO_ORIGIN_POS = eINSTANCE.getConstraints_YToOriginPos();

		/**
		 * The meta object literal for the '<em><b>ZTo Origin Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__ZTO_ORIGIN_POS = eINSTANCE.getConstraints_ZToOriginPos();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__ROTATION = eINSTANCE.getConstraints_Rotation();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__TEXT = eINSTANCE.getConstraints_Text();

		/**
		 * The meta object literal for the '<em><b>Text Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__TEXT_COLOR = eINSTANCE.getConstraints_TextColor();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ConnectionImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__NAME = eINSTANCE.getConnection_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__TYPE = eINSTANCE.getConnection_Type();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__COLOR = eINSTANCE.getConnection_Color();

		/**
		 * The meta object literal for the '<em><b>Text Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__TEXT_COLOR = eINSTANCE.getConnection_TextColor();

		/**
		 * The meta object literal for the '<em><b>Decorator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DECORATOR = eINSTANCE.getConnection_Decorator();

		/**
		 * The meta object literal for the '<em><b>Decorator Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DECORATOR_POS = eINSTANCE.getConnection_DecoratorPos();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__PATTERN = eINSTANCE.getConnection_Pattern();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__WIDTH = eINSTANCE.getConnection_Width();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__POSITION = eINSTANCE.getConnection_Position();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.PhysicClassImpl <em>Physic Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.PhysicClassImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getPhysicClass()
		 * @generated
		 */
		EClass PHYSIC_CLASS = eINSTANCE.getPhysicClass();

		/**
		 * The meta object literal for the '<em><b>Physic Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CLASS__PHYSIC_BODY = eINSTANCE.getPhysicClass_PhysicBody();

		/**
		 * The meta object literal for the '<em><b>Bit Masks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CLASS__BIT_MASKS = eINSTANCE.getPhysicClass_BitMasks();

		/**
		 * The meta object literal for the '<em><b>Onto Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CLASS__ONTO_CLASS = eINSTANCE.getPhysicClass_OntoClass();

		/**
		 * The meta object literal for the '<em><b>Forces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CLASS__FORCES = eINSTANCE.getPhysicClass_Forces();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.PhysicBodyImpl <em>Physic Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.PhysicBodyImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getPhysicBody()
		 * @generated
		 */
		EClass PHYSIC_BODY = eINSTANCE.getPhysicBody();

		/**
		 * The meta object literal for the '<em><b>Mass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__MASS = eINSTANCE.getPhysicBody_Mass();

		/**
		 * The meta object literal for the '<em><b>Body Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__BODY_TYPE = eINSTANCE.getPhysicBody_BodyType();

		/**
		 * The meta object literal for the '<em><b>Charge</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__CHARGE = eINSTANCE.getPhysicBody_Charge();

		/**
		 * The meta object literal for the '<em><b>Friction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__FRICTION = eINSTANCE.getPhysicBody_Friction();

		/**
		 * The meta object literal for the '<em><b>Rolling Friction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__ROLLING_FRICTION = eINSTANCE.getPhysicBody_RollingFriction();

		/**
		 * The meta object literal for the '<em><b>Restitution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__RESTITUTION = eINSTANCE.getPhysicBody_Restitution();

		/**
		 * The meta object literal for the '<em><b>Damping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__DAMPING = eINSTANCE.getPhysicBody_Damping();

		/**
		 * The meta object literal for the '<em><b>Angular Damping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_BODY__ANGULAR_DAMPING = eINSTANCE.getPhysicBody_AngularDamping();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.BitMasksImpl <em>Bit Masks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.BitMasksImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getBitMasks()
		 * @generated
		 */
		EClass BIT_MASKS = eINSTANCE.getBitMasks();

		/**
		 * The meta object literal for the '<em><b>Collision</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIT_MASKS__COLLISION = eINSTANCE.getBitMasks_Collision();

		/**
		 * The meta object literal for the '<em><b>Contact</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIT_MASKS__CONTACT = eINSTANCE.getBitMasks_Contact();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ForceImpl <em>Force</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ForceImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getForce()
		 * @generated
		 */
		EClass FORCE = eINSTANCE.getForce();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCE__NAME = eINSTANCE.getForce_Name();

		/**
		 * The meta object literal for the '<em><b>Gesture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCE__GESTURE = eINSTANCE.getForce_Gesture();

		/**
		 * The meta object literal for the '<em><b>XVector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCE__XVECTOR = eINSTANCE.getForce_XVector();

		/**
		 * The meta object literal for the '<em><b>YVector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCE__YVECTOR = eINSTANCE.getForce_YVector();

		/**
		 * The meta object literal for the '<em><b>ZVector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCE__ZVECTOR = eINSTANCE.getForce_ZVector();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ScoreSystemImpl <em>Score System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ScoreSystemImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getScoreSystem()
		 * @generated
		 */
		EClass SCORE_SYSTEM = eINSTANCE.getScoreSystem();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE_SYSTEM__START = eINSTANCE.getScoreSystem_Start();

		/**
		 * The meta object literal for the '<em><b>Finish</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE_SYSTEM__FINISH = eINSTANCE.getScoreSystem_Finish();

		/**
		 * The meta object literal for the '<em><b>Lives</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE_SYSTEM__LIVES = eINSTANCE.getScoreSystem_Lives();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.TriggerImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__NAME = eINSTANCE.getTrigger_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__MESSAGE = eINSTANCE.getTrigger_Message();

		/**
		 * The meta object literal for the '<em><b>Time Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__TIME_TRIGGER = eINSTANCE.getTrigger_TimeTrigger();

		/**
		 * The meta object literal for the '<em><b>Score Change</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__SCORE_CHANGE = eINSTANCE.getTrigger_ScoreChange();

		/**
		 * The meta object literal for the '<em><b>Physic Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__PHYSIC_CHANGES = eINSTANCE.getTrigger_PhysicChanges();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__ACTION = eINSTANCE.getTrigger_Action();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.PhysicChangeImpl <em>Physic Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.PhysicChangeImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getPhysicChange()
		 * @generated
		 */
		EClass PHYSIC_CHANGE = eINSTANCE.getPhysicChange();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__OBJECT = eINSTANCE.getPhysicChange_Object();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__ACTION = eINSTANCE.getPhysicChange_Action();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CHANGE__CLASS = eINSTANCE.getPhysicChange_Class();

		/**
		 * The meta object literal for the '<em><b>Force</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSIC_CHANGE__FORCE = eINSTANCE.getPhysicChange_Force();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__POSITION = eINSTANCE.getPhysicChange_Position();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__ATTRIBUTE = eINSTANCE.getPhysicChange_Attribute();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__SCALE = eINSTANCE.getPhysicChange_Scale();

		/**
		 * The meta object literal for the '<em><b>Change Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSIC_CHANGE__CHANGE_VALUE = eINSTANCE.getPhysicChange_ChangeValue();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.CollisionImpl <em>Collision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.CollisionImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getCollision()
		 * @generated
		 */
		EClass COLLISION = eINSTANCE.getCollision();

		/**
		 * The meta object literal for the '<em><b>Class A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLISION__CLASS_A = eINSTANCE.getCollision_ClassA();

		/**
		 * The meta object literal for the '<em><b>Class B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLISION__CLASS_B = eINSTANCE.getCollision_ClassB();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLISION__ACTION = eINSTANCE.getCollision_Action();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ObjInitImpl <em>Obj Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ObjInitImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getObjInit()
		 * @generated
		 */
		EClass OBJ_INIT = eINSTANCE.getObjInit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_INIT__NAME = eINSTANCE.getObjInit_Name();

		/**
		 * The meta object literal for the '<em><b>Pos X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_INIT__POS_X = eINSTANCE.getObjInit_PosX();

		/**
		 * The meta object literal for the '<em><b>Pos Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_INIT__POS_Y = eINSTANCE.getObjInit_PosY();

		/**
		 * The meta object literal for the '<em><b>Pos Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_INIT__POS_Z = eINSTANCE.getObjInit_PosZ();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJ_INIT__CLASS = eINSTANCE.getObjInit_Class();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJ_INIT__ATTRIBUTE = eINSTANCE.getObjInit_Attribute();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJ_INIT__RULES = eINSTANCE.getObjInit_Rules();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_INIT__ROTATION = eINSTANCE.getObjInit_Rotation();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ObjAttributeImpl <em>Obj Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ObjAttributeImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getObjAttribute()
		 * @generated
		 */
		EClass OBJ_ATTRIBUTE = eINSTANCE.getObjAttribute();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJ_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getObjAttribute_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJ_ATTRIBUTE__VALUE = eINSTANCE.getObjAttribute_Value();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.RuleImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ACTION = eINSTANCE.getRule_Action();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__CONDITION = eINSTANCE.getRule_Condition();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ConditionImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.LogicOpImpl <em>Logic Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.LogicOpImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getLogicOp()
		 * @generated
		 */
		EClass LOGIC_OP = eINSTANCE.getLogicOp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIC_OP__LEFT = eINSTANCE.getLogicOp_Left();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.NotImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.BinaryImpl <em>Binary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.BinaryImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getBinary()
		 * @generated
		 */
		EClass BINARY = eINSTANCE.getBinary();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY__RIGHT = eINSTANCE.getBinary_Right();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY__OP = eINSTANCE.getBinary_Op();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ArithmeticImpl <em>Arithmetic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ArithmeticImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getArithmetic()
		 * @generated
		 */
		EClass ARITHMETIC = eINSTANCE.getArithmetic();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARITHMETIC__OP = eINSTANCE.getArithmetic_Op();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITHMETIC__RIGHT = eINSTANCE.getArithmetic_Right();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITHMETIC__LEFT = eINSTANCE.getArithmetic_Left();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ValueImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.AttributeValueImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getAttributeValue()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE__CLASS = eINSTANCE.getAttributeValue_Class();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE__ATTRIBUTE = eINSTANCE.getAttributeValue_Attribute();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.ConstantValueImpl <em>Constant Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.ConstantValueImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getConstantValue()
		 * @generated
		 */
		EClass CONSTANT_VALUE = eINSTANCE.getConstantValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_VALUE__VALUE = eINSTANCE.getConstantValue_Value();

		/**
		 * The meta object literal for the '{@link Ardsl.impl.AllInstancesImpl <em>All Instances</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.impl.AllInstancesImpl
		 * @see Ardsl.impl.ArdslPackageImpl#getAllInstances()
		 * @generated
		 */
		EClass ALL_INSTANCES = eINSTANCE.getAllInstances();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_INSTANCES__TYPE = eINSTANCE.getAllInstances_Type();

		/**
		 * The meta object literal for the '{@link Ardsl.Planes <em>Planes</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.Planes
		 * @see Ardsl.impl.ArdslPackageImpl#getPlanes()
		 * @generated
		 */
		EEnum PLANES = eINSTANCE.getPlanes();

		/**
		 * The meta object literal for the '{@link Ardsl.BodyType <em>Body Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.BodyType
		 * @see Ardsl.impl.ArdslPackageImpl#getBodyType()
		 * @generated
		 */
		EEnum BODY_TYPE = eINSTANCE.getBodyType();

		/**
		 * The meta object literal for the '{@link Ardsl.Gesture <em>Gesture</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.Gesture
		 * @see Ardsl.impl.ArdslPackageImpl#getGesture()
		 * @generated
		 */
		EEnum GESTURE = eINSTANCE.getGesture();

		/**
		 * The meta object literal for the '{@link Ardsl.BasicActions <em>Basic Actions</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.BasicActions
		 * @see Ardsl.impl.ArdslPackageImpl#getBasicActions()
		 * @generated
		 */
		EEnum BASIC_ACTIONS = eINSTANCE.getBasicActions();

		/**
		 * The meta object literal for the '{@link Ardsl.Action <em>Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.Action
		 * @see Ardsl.impl.ArdslPackageImpl#getAction()
		 * @generated
		 */
		EEnum ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link Ardsl.Position <em>Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.Position
		 * @see Ardsl.impl.ArdslPackageImpl#getPosition()
		 * @generated
		 */
		EEnum POSITION = eINSTANCE.getPosition();

		/**
		 * The meta object literal for the '{@link Ardsl.LogicOps <em>Logic Ops</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.LogicOps
		 * @see Ardsl.impl.ArdslPackageImpl#getLogicOps()
		 * @generated
		 */
		EEnum LOGIC_OPS = eINSTANCE.getLogicOps();

		/**
		 * The meta object literal for the '{@link Ardsl.ArithmOps <em>Arithm Ops</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Ardsl.ArithmOps
		 * @see Ardsl.impl.ArdslPackageImpl#getArithmOps()
		 * @generated
		 */
		EEnum ARITHM_OPS = eINSTANCE.getArithmOps();

	}

} //ArdslPackage
