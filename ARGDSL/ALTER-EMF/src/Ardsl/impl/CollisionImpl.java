/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Collision;
import Ardsl.Trigger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.CollisionImpl#getClassA <em>Class A</em>}</li>
 *   <li>{@link Ardsl.impl.CollisionImpl#getClassB <em>Class B</em>}</li>
 *   <li>{@link Ardsl.impl.CollisionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollisionImpl extends MinimalEObjectImpl.Container implements Collision {
	/**
	 * The cached value of the '{@link #getClassA() <em>Class A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassA()
	 * @generated
	 * @ordered
	 */
	protected Ardsl.Class classA;

	/**
	 * The cached value of the '{@link #getClassB() <em>Class B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassB()
	 * @generated
	 * @ordered
	 */
	protected Ardsl.Class classB;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Trigger action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.COLLISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class getClassA() {
		if (classA != null && classA.eIsProxy()) {
			InternalEObject oldClassA = (InternalEObject)classA;
			classA = (Ardsl.Class)eResolveProxy(oldClassA);
			if (classA != oldClassA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.COLLISION__CLASS_A, oldClassA, classA));
			}
		}
		return classA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class basicGetClassA() {
		return classA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassA(Ardsl.Class newClassA) {
		Ardsl.Class oldClassA = classA;
		classA = newClassA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.COLLISION__CLASS_A, oldClassA, classA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class getClassB() {
		if (classB != null && classB.eIsProxy()) {
			InternalEObject oldClassB = (InternalEObject)classB;
			classB = (Ardsl.Class)eResolveProxy(oldClassB);
			if (classB != oldClassB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.COLLISION__CLASS_B, oldClassB, classB));
			}
		}
		return classB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class basicGetClassB() {
		return classB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassB(Ardsl.Class newClassB) {
		Ardsl.Class oldClassB = classB;
		classB = newClassB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.COLLISION__CLASS_B, oldClassB, classB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Trigger)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.COLLISION__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Trigger newAction) {
		Trigger oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.COLLISION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.COLLISION__CLASS_A:
				if (resolve) return getClassA();
				return basicGetClassA();
			case ArdslPackage.COLLISION__CLASS_B:
				if (resolve) return getClassB();
				return basicGetClassB();
			case ArdslPackage.COLLISION__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArdslPackage.COLLISION__CLASS_A:
				setClassA((Ardsl.Class)newValue);
				return;
			case ArdslPackage.COLLISION__CLASS_B:
				setClassB((Ardsl.Class)newValue);
				return;
			case ArdslPackage.COLLISION__ACTION:
				setAction((Trigger)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArdslPackage.COLLISION__CLASS_A:
				setClassA((Ardsl.Class)null);
				return;
			case ArdslPackage.COLLISION__CLASS_B:
				setClassB((Ardsl.Class)null);
				return;
			case ArdslPackage.COLLISION__ACTION:
				setAction((Trigger)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArdslPackage.COLLISION__CLASS_A:
				return classA != null;
			case ArdslPackage.COLLISION__CLASS_B:
				return classB != null;
			case ArdslPackage.COLLISION__ACTION:
				return action != null;
		}
		return super.eIsSet(featureID);
	}

} //CollisionImpl
