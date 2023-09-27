/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.BodyType;
import Ardsl.PhysicBody;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physic Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getMass <em>Mass</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getBodyType <em>Body Type</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getCharge <em>Charge</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getFriction <em>Friction</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getRollingFriction <em>Rolling Friction</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getRestitution <em>Restitution</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getDamping <em>Damping</em>}</li>
 *   <li>{@link Ardsl.impl.PhysicBodyImpl#getAngularDamping <em>Angular Damping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicBodyImpl extends MinimalEObjectImpl.Container implements PhysicBody {
	/**
	 * The default value of the '{@link #getMass() <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMass()
	 * @generated
	 * @ordered
	 */
	protected static final double MASS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMass() <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMass()
	 * @generated
	 * @ordered
	 */
	protected double mass = MASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBodyType() <em>Body Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyType()
	 * @generated
	 * @ordered
	 */
	protected static final BodyType BODY_TYPE_EDEFAULT = BodyType.STATIC;

	/**
	 * The cached value of the '{@link #getBodyType() <em>Body Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyType()
	 * @generated
	 * @ordered
	 */
	protected BodyType bodyType = BODY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharge() <em>Charge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharge()
	 * @generated
	 * @ordered
	 */
	protected static final double CHARGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCharge() <em>Charge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharge()
	 * @generated
	 * @ordered
	 */
	protected double charge = CHARGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFriction() <em>Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriction()
	 * @generated
	 * @ordered
	 */
	protected static final double FRICTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFriction() <em>Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriction()
	 * @generated
	 * @ordered
	 */
	protected double friction = FRICTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRollingFriction() <em>Rolling Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRollingFriction()
	 * @generated
	 * @ordered
	 */
	protected static final double ROLLING_FRICTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRollingFriction() <em>Rolling Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRollingFriction()
	 * @generated
	 * @ordered
	 */
	protected double rollingFriction = ROLLING_FRICTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRestitution() <em>Restitution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestitution()
	 * @generated
	 * @ordered
	 */
	protected static final double RESTITUTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRestitution() <em>Restitution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestitution()
	 * @generated
	 * @ordered
	 */
	protected double restitution = RESTITUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDamping() <em>Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamping()
	 * @generated
	 * @ordered
	 */
	protected static final double DAMPING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDamping() <em>Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamping()
	 * @generated
	 * @ordered
	 */
	protected double damping = DAMPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngularDamping() <em>Angular Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngularDamping()
	 * @generated
	 * @ordered
	 */
	protected static final double ANGULAR_DAMPING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAngularDamping() <em>Angular Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngularDamping()
	 * @generated
	 * @ordered
	 */
	protected double angularDamping = ANGULAR_DAMPING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.PHYSIC_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMass(double newMass) {
		double oldMass = mass;
		mass = newMass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__MASS, oldMass, mass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BodyType getBodyType() {
		return bodyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyType(BodyType newBodyType) {
		BodyType oldBodyType = bodyType;
		bodyType = newBodyType == null ? BODY_TYPE_EDEFAULT : newBodyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__BODY_TYPE, oldBodyType, bodyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharge(double newCharge) {
		double oldCharge = charge;
		charge = newCharge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__CHARGE, oldCharge, charge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFriction() {
		return friction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFriction(double newFriction) {
		double oldFriction = friction;
		friction = newFriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__FRICTION, oldFriction, friction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRollingFriction() {
		return rollingFriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRollingFriction(double newRollingFriction) {
		double oldRollingFriction = rollingFriction;
		rollingFriction = newRollingFriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__ROLLING_FRICTION, oldRollingFriction, rollingFriction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRestitution() {
		return restitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestitution(double newRestitution) {
		double oldRestitution = restitution;
		restitution = newRestitution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__RESTITUTION, oldRestitution, restitution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDamping() {
		return damping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDamping(double newDamping) {
		double oldDamping = damping;
		damping = newDamping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__DAMPING, oldDamping, damping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAngularDamping() {
		return angularDamping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngularDamping(double newAngularDamping) {
		double oldAngularDamping = angularDamping;
		angularDamping = newAngularDamping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.PHYSIC_BODY__ANGULAR_DAMPING, oldAngularDamping, angularDamping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.PHYSIC_BODY__MASS:
				return getMass();
			case ArdslPackage.PHYSIC_BODY__BODY_TYPE:
				return getBodyType();
			case ArdslPackage.PHYSIC_BODY__CHARGE:
				return getCharge();
			case ArdslPackage.PHYSIC_BODY__FRICTION:
				return getFriction();
			case ArdslPackage.PHYSIC_BODY__ROLLING_FRICTION:
				return getRollingFriction();
			case ArdslPackage.PHYSIC_BODY__RESTITUTION:
				return getRestitution();
			case ArdslPackage.PHYSIC_BODY__DAMPING:
				return getDamping();
			case ArdslPackage.PHYSIC_BODY__ANGULAR_DAMPING:
				return getAngularDamping();
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
			case ArdslPackage.PHYSIC_BODY__MASS:
				setMass((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__BODY_TYPE:
				setBodyType((BodyType)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__CHARGE:
				setCharge((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__FRICTION:
				setFriction((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__ROLLING_FRICTION:
				setRollingFriction((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__RESTITUTION:
				setRestitution((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__DAMPING:
				setDamping((Double)newValue);
				return;
			case ArdslPackage.PHYSIC_BODY__ANGULAR_DAMPING:
				setAngularDamping((Double)newValue);
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
			case ArdslPackage.PHYSIC_BODY__MASS:
				setMass(MASS_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__BODY_TYPE:
				setBodyType(BODY_TYPE_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__CHARGE:
				setCharge(CHARGE_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__FRICTION:
				setFriction(FRICTION_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__ROLLING_FRICTION:
				setRollingFriction(ROLLING_FRICTION_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__RESTITUTION:
				setRestitution(RESTITUTION_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__DAMPING:
				setDamping(DAMPING_EDEFAULT);
				return;
			case ArdslPackage.PHYSIC_BODY__ANGULAR_DAMPING:
				setAngularDamping(ANGULAR_DAMPING_EDEFAULT);
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
			case ArdslPackage.PHYSIC_BODY__MASS:
				return mass != MASS_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__BODY_TYPE:
				return bodyType != BODY_TYPE_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__CHARGE:
				return charge != CHARGE_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__FRICTION:
				return friction != FRICTION_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__ROLLING_FRICTION:
				return rollingFriction != ROLLING_FRICTION_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__RESTITUTION:
				return restitution != RESTITUTION_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__DAMPING:
				return damping != DAMPING_EDEFAULT;
			case ArdslPackage.PHYSIC_BODY__ANGULAR_DAMPING:
				return angularDamping != ANGULAR_DAMPING_EDEFAULT;
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
		result.append(" (mass: ");
		result.append(mass);
		result.append(", bodyType: ");
		result.append(bodyType);
		result.append(", charge: ");
		result.append(charge);
		result.append(", friction: ");
		result.append(friction);
		result.append(", rollingFriction: ");
		result.append(rollingFriction);
		result.append(", restitution: ");
		result.append(restitution);
		result.append(", damping: ");
		result.append(damping);
		result.append(", angularDamping: ");
		result.append(angularDamping);
		result.append(')');
		return result.toString();
	}

} //PhysicBodyImpl
