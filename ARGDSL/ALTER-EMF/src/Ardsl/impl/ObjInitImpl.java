/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.ObjAttribute;
import Ardsl.ObjInit;
import Ardsl.Rule;

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
 * An implementation of the model object '<em><b>Obj Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getPosX <em>Pos X</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getPosY <em>Pos Y</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getPosZ <em>Pos Z</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link Ardsl.impl.ObjInitImpl#getRotation <em>Rotation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjInitImpl extends MinimalEObjectImpl.Container implements ObjInit {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosX() <em>Pos X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosX()
	 * @generated
	 * @ordered
	 */
	protected static final double POS_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPosX() <em>Pos X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosX()
	 * @generated
	 * @ordered
	 */
	protected double posX = POS_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosY() <em>Pos Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosY()
	 * @generated
	 * @ordered
	 */
	protected static final double POS_Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPosY() <em>Pos Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosY()
	 * @generated
	 * @ordered
	 */
	protected double posY = POS_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosZ() <em>Pos Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosZ()
	 * @generated
	 * @ordered
	 */
	protected static final double POS_Z_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPosZ() <em>Pos Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosZ()
	 * @generated
	 * @ordered
	 */
	protected double posZ = POS_Z_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected Ardsl.Class class_;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjAttribute> attribute;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The default value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected static final int ROTATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected int rotation = ROTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjInitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.OBJ_INIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosX(double newPosX) {
		double oldPosX = posX;
		posX = newPosX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__POS_X, oldPosX, posX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPosY() {
		return posY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosY(double newPosY) {
		double oldPosY = posY;
		posY = newPosY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__POS_Y, oldPosY, posY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPosZ() {
		return posZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosZ(double newPosZ) {
		double oldPosZ = posZ;
		posZ = newPosZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__POS_Z, oldPosZ, posZ));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (Ardsl.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.OBJ_INIT__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Ardsl.Class newClass) {
		Ardsl.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjAttribute> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<ObjAttribute>(ObjAttribute.class, this, ArdslPackage.OBJ_INIT__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, ArdslPackage.OBJ_INIT__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRotation() {
		return rotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotation(int newRotation) {
		int oldRotation = rotation;
		rotation = newRotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.OBJ_INIT__ROTATION, oldRotation, rotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArdslPackage.OBJ_INIT__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case ArdslPackage.OBJ_INIT__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case ArdslPackage.OBJ_INIT__NAME:
				return getName();
			case ArdslPackage.OBJ_INIT__POS_X:
				return getPosX();
			case ArdslPackage.OBJ_INIT__POS_Y:
				return getPosY();
			case ArdslPackage.OBJ_INIT__POS_Z:
				return getPosZ();
			case ArdslPackage.OBJ_INIT__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case ArdslPackage.OBJ_INIT__ATTRIBUTE:
				return getAttribute();
			case ArdslPackage.OBJ_INIT__RULES:
				return getRules();
			case ArdslPackage.OBJ_INIT__ROTATION:
				return getRotation();
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
			case ArdslPackage.OBJ_INIT__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.OBJ_INIT__POS_X:
				setPosX((Double)newValue);
				return;
			case ArdslPackage.OBJ_INIT__POS_Y:
				setPosY((Double)newValue);
				return;
			case ArdslPackage.OBJ_INIT__POS_Z:
				setPosZ((Double)newValue);
				return;
			case ArdslPackage.OBJ_INIT__CLASS:
				setClass((Ardsl.Class)newValue);
				return;
			case ArdslPackage.OBJ_INIT__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends ObjAttribute>)newValue);
				return;
			case ArdslPackage.OBJ_INIT__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case ArdslPackage.OBJ_INIT__ROTATION:
				setRotation((Integer)newValue);
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
			case ArdslPackage.OBJ_INIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.OBJ_INIT__POS_X:
				setPosX(POS_X_EDEFAULT);
				return;
			case ArdslPackage.OBJ_INIT__POS_Y:
				setPosY(POS_Y_EDEFAULT);
				return;
			case ArdslPackage.OBJ_INIT__POS_Z:
				setPosZ(POS_Z_EDEFAULT);
				return;
			case ArdslPackage.OBJ_INIT__CLASS:
				setClass((Ardsl.Class)null);
				return;
			case ArdslPackage.OBJ_INIT__ATTRIBUTE:
				getAttribute().clear();
				return;
			case ArdslPackage.OBJ_INIT__RULES:
				getRules().clear();
				return;
			case ArdslPackage.OBJ_INIT__ROTATION:
				setRotation(ROTATION_EDEFAULT);
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
			case ArdslPackage.OBJ_INIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.OBJ_INIT__POS_X:
				return posX != POS_X_EDEFAULT;
			case ArdslPackage.OBJ_INIT__POS_Y:
				return posY != POS_Y_EDEFAULT;
			case ArdslPackage.OBJ_INIT__POS_Z:
				return posZ != POS_Z_EDEFAULT;
			case ArdslPackage.OBJ_INIT__CLASS:
				return class_ != null;
			case ArdslPackage.OBJ_INIT__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case ArdslPackage.OBJ_INIT__RULES:
				return rules != null && !rules.isEmpty();
			case ArdslPackage.OBJ_INIT__ROTATION:
				return rotation != ROTATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", posX: ");
		result.append(posX);
		result.append(", posY: ");
		result.append(posY);
		result.append(", posZ: ");
		result.append(posZ);
		result.append(", rotation: ");
		result.append(rotation);
		result.append(')');
		return result.toString();
	}

} //ObjInitImpl
