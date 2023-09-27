/**
 */
package Ardsl.util;

import Ardsl.AllInstances;
import Ardsl.ArdslPackage;
import Ardsl.Arithmetic;
import Ardsl.Attribute;
import Ardsl.AttributeValue;
import Ardsl.Binary;
import Ardsl.BitMasks;
import Ardsl.Collision;
import Ardsl.Condition;
import Ardsl.Connection;
import Ardsl.ConstantValue;
import Ardsl.Constraints;
import Ardsl.Force;
import Ardsl.Game;
import Ardsl.GamePad;
import Ardsl.Graphic;
import Ardsl.GraphicClass;
import Ardsl.LogicOp;
import Ardsl.Not;
import Ardsl.ObjAttribute;
import Ardsl.ObjInit;
import Ardsl.Ontological;
import Ardsl.Physic;
import Ardsl.PhysicBody;
import Ardsl.PhysicChange;
import Ardsl.PhysicClass;
import Ardsl.Reference;
import Ardsl.Rule;
import Ardsl.ScoreSystem;
import Ardsl.Trigger;
import Ardsl.Value;
import Ardsl.Versions;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Ardsl.ArdslPackage
 * @generated
 */
public class ArdslAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ArdslPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArdslAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ArdslPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArdslSwitch<Adapter> modelSwitch =
		new ArdslSwitch<Adapter>() {
			@Override
			public Adapter caseOntological(Ontological object) {
				return createOntologicalAdapter();
			}
			@Override
			public Adapter caseGraphic(Graphic object) {
				return createGraphicAdapter();
			}
			@Override
			public Adapter casePhysic(Physic object) {
				return createPhysicAdapter();
			}
			@Override
			public Adapter caseGame(Game object) {
				return createGameAdapter();
			}
			@Override
			public Adapter caseGamePad(GamePad object) {
				return createGamePadAdapter();
			}
			@Override
			public Adapter caseClass(Ardsl.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseReference(Reference object) {
				return createReferenceAdapter();
			}
			@Override
			public Adapter caseGraphicClass(GraphicClass object) {
				return createGraphicClassAdapter();
			}
			@Override
			public Adapter caseVersions(Versions object) {
				return createVersionsAdapter();
			}
			@Override
			public Adapter caseConstraints(Constraints object) {
				return createConstraintsAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter casePhysicClass(PhysicClass object) {
				return createPhysicClassAdapter();
			}
			@Override
			public Adapter casePhysicBody(PhysicBody object) {
				return createPhysicBodyAdapter();
			}
			@Override
			public Adapter caseBitMasks(BitMasks object) {
				return createBitMasksAdapter();
			}
			@Override
			public Adapter caseForce(Force object) {
				return createForceAdapter();
			}
			@Override
			public Adapter caseScoreSystem(ScoreSystem object) {
				return createScoreSystemAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
			}
			@Override
			public Adapter casePhysicChange(PhysicChange object) {
				return createPhysicChangeAdapter();
			}
			@Override
			public Adapter caseCollision(Collision object) {
				return createCollisionAdapter();
			}
			@Override
			public Adapter caseObjInit(ObjInit object) {
				return createObjInitAdapter();
			}
			@Override
			public Adapter caseObjAttribute(ObjAttribute object) {
				return createObjAttributeAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseLogicOp(LogicOp object) {
				return createLogicOpAdapter();
			}
			@Override
			public Adapter caseNot(Not object) {
				return createNotAdapter();
			}
			@Override
			public Adapter caseBinary(Binary object) {
				return createBinaryAdapter();
			}
			@Override
			public Adapter caseArithmetic(Arithmetic object) {
				return createArithmeticAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseAttributeValue(AttributeValue object) {
				return createAttributeValueAdapter();
			}
			@Override
			public Adapter caseConstantValue(ConstantValue object) {
				return createConstantValueAdapter();
			}
			@Override
			public Adapter caseAllInstances(AllInstances object) {
				return createAllInstancesAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Ontological <em>Ontological</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Ontological
	 * @generated
	 */
	public Adapter createOntologicalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Graphic <em>Graphic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Graphic
	 * @generated
	 */
	public Adapter createGraphicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Physic <em>Physic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Physic
	 * @generated
	 */
	public Adapter createPhysicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Game
	 * @generated
	 */
	public Adapter createGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.GamePad <em>Game Pad</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.GamePad
	 * @generated
	 */
	public Adapter createGamePadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.GraphicClass <em>Graphic Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.GraphicClass
	 * @generated
	 */
	public Adapter createGraphicClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Versions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Versions
	 * @generated
	 */
	public Adapter createVersionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Constraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Constraints
	 * @generated
	 */
	public Adapter createConstraintsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.PhysicClass <em>Physic Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.PhysicClass
	 * @generated
	 */
	public Adapter createPhysicClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.PhysicBody <em>Physic Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.PhysicBody
	 * @generated
	 */
	public Adapter createPhysicBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.BitMasks <em>Bit Masks</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.BitMasks
	 * @generated
	 */
	public Adapter createBitMasksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Force <em>Force</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Force
	 * @generated
	 */
	public Adapter createForceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.ScoreSystem <em>Score System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.ScoreSystem
	 * @generated
	 */
	public Adapter createScoreSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Trigger
	 * @generated
	 */
	public Adapter createTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.PhysicChange <em>Physic Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.PhysicChange
	 * @generated
	 */
	public Adapter createPhysicChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Collision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Collision
	 * @generated
	 */
	public Adapter createCollisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.ObjInit <em>Obj Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.ObjInit
	 * @generated
	 */
	public Adapter createObjInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.ObjAttribute <em>Obj Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.ObjAttribute
	 * @generated
	 */
	public Adapter createObjAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.LogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.LogicOp
	 * @generated
	 */
	public Adapter createLogicOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Not
	 * @generated
	 */
	public Adapter createNotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Binary
	 * @generated
	 */
	public Adapter createBinaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Arithmetic <em>Arithmetic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Arithmetic
	 * @generated
	 */
	public Adapter createArithmeticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.AttributeValue <em>Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.AttributeValue
	 * @generated
	 */
	public Adapter createAttributeValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.ConstantValue
	 * @generated
	 */
	public Adapter createConstantValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Ardsl.AllInstances <em>All Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Ardsl.AllInstances
	 * @generated
	 */
	public Adapter createAllInstancesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ArdslAdapterFactory
