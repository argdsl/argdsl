/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.BitMasks;
import Ardsl.Force;
import Ardsl.PhysicBody;
import Ardsl.PhysicClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physic Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.PhysicClassImpl#getPhysicBody <em>Physic Body</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicClassImpl#getBitMasks <em>Bit Masks</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicClassImpl#getOntoClass <em>Onto Class</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicClassImpl#getForces <em>Forces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicClassImpl extends MinimalEObjectImpl.Container implements PhysicClass {
	/**
	 * The cached value of the '{@link #getPhysicBody() <em>Physic Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicBody()
	 * @generated
	 * @ordered
	 */
	protected PhysicBody physicBody;

	/**
	 * The cached value of the '{@link #getBitMasks() <em>Bit Masks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitMasks()
	 * @generated
	 * @ordered
	 */
	protected BitMasks bitMasks;

	/**
	 * The cached value of the '{@link #getOntoClass() <em>Onto Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntoClass()
	 * @generated
	 * @ordered
	 */
	protected Ardsl.Class ontoClass;

	/**
	 * The cached value of the '{@link #getForces() <em>Forces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForces()
	 * @generated
	 * @ordered
	 */
	protected EList<Force> forces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.PHYSIC_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicBody getPhysicBody() {
		return physicBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPhysicBody(PhysicBody newPhysicBody, NotificationChain msgs) {
		PhysicBody oldPhysicBody = physicBody;
		physicBody = newPhysicBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY, oldPhysicBody, newPhysicBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicBody(PhysicBody newPhysicBody) {
		if (newPhysicBody != physicBody) {
			NotificationChain msgs = null;
			if (physicBody != null)
				msgs = ((InternalEObject)physicBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY, null, msgs);
			if (newPhysicBody != null)
				msgs = ((InternalEObject)newPhysicBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY, null, msgs);
			msgs = basicSetPhysicBody(newPhysicBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY, newPhysicBody, newPhysicBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitMasks getBitMasks() {
		return bitMasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBitMasks(BitMasks newBitMasks, NotificationChain msgs) {
		BitMasks oldBitMasks = bitMasks;
		bitMasks = newBitMasks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_CLASS__BIT_MASKS, oldBitMasks, newBitMasks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitMasks(BitMasks newBitMasks) {
		if (newBitMasks != bitMasks) {
			NotificationChain msgs = null;
			if (bitMasks != null)
				msgs = ((InternalEObject)bitMasks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.PHYSIC_CLASS__BIT_MASKS, null, msgs);
			if (newBitMasks != null)
				msgs = ((InternalEObject)newBitMasks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.PHYSIC_CLASS__BIT_MASKS, null, msgs);
			msgs = basicSetBitMasks(newBitMasks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_CLASS__BIT_MASKS, newBitMasks, newBitMasks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class getOntoClass() {
		if (ontoClass != null && ontoClass.eIsProxy()) {
			InternalEObject oldOntoClass = (InternalEObject)ontoClass;
			ontoClass = (Ardsl.Class)eResolveProxy(oldOntoClass);
			if (ontoClass != oldOntoClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.PHYSIC_CLASS__ONTO_CLASS, oldOntoClass, ontoClass));
			}
		}
		return ontoClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class basicGetOntoClass() {
		return ontoClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOntoClass(Ardsl.Class newOntoClass) {
		Ardsl.Class oldOntoClass = ontoClass;
		ontoClass = newOntoClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_CLASS__ONTO_CLASS, oldOntoClass, ontoClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Force> getForces() {
		if (forces == null) {
			forces = new EObjectContainmentEList<Force>(Force.class, this, ArdslPackage.PHYSIC_CLASS__FORCES);
		}
		return forces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY:
				return basicSetPhysicBody(null, msgs);
			case ArdslPackage.PHYSIC_CLASS__BIT_MASKS:
				return basicSetBitMasks(null, msgs);
			case ArdslPackage.PHYSIC_CLASS__FORCES:
				return ((InternalEList<?>)getForces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY:
				return getPhysicBody();
			case ArdslPackage.PHYSIC_CLASS__BIT_MASKS:
				return getBitMasks();
			case ArdslPackage.PHYSIC_CLASS__ONTO_CLASS:
				if (resolve) return getOntoClass();
				return basicGetOntoClass();
			case ArdslPackage.PHYSIC_CLASS__FORCES:
				return getForces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY:
				setPhysicBody((PhysicBody)newValue);
				return;
			case ArdslPackage.PHYSIC_CLASS__BIT_MASKS:
				setBitMasks((BitMasks)newValue);
				return;
			case ArdslPackage.PHYSIC_CLASS__ONTO_CLASS:
				setOntoClass((Ardsl.Class)newValue);
				return;
			case ArdslPackage.PHYSIC_CLASS__FORCES:
				getForces().clear();
				getForces().addAll((Collection<? extends Force>)newValue);
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
			case ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY:
				setPhysicBody((PhysicBody)null);
				return;
			case ArdslPackage.PHYSIC_CLASS__BIT_MASKS:
				setBitMasks((BitMasks)null);
				return;
			case ArdslPackage.PHYSIC_CLASS__ONTO_CLASS:
				setOntoClass((Ardsl.Class)null);
				return;
			case ArdslPackage.PHYSIC_CLASS__FORCES:
				getForces().clear();
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
			case ArdslPackage.PHYSIC_CLASS__PHYSIC_BODY:
				return physicBody != null;
			case ArdslPackage.PHYSIC_CLASS__BIT_MASKS:
				return bitMasks != null;
			case ArdslPackage.PHYSIC_CLASS__ONTO_CLASS:
				return ontoClass != null;
			case ArdslPackage.PHYSIC_CLASS__FORCES:
				return forces != null && !forces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PhysicClassImpl
