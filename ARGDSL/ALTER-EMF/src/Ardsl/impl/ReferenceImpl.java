/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Reference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getContaintment <em>Containtment</em>}</li>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getMin <em>Min</em>}</li>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getMax <em>Max</em>}</li>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link Ardsl.impl.ReferenceImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends MinimalEObjectImpl.Container implements Reference {
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
	 * The default value of the '{@link #getContaintment() <em>Containtment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContaintment()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTAINTMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContaintment() <em>Containtment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContaintment()
	 * @generated
	 * @ordered
	 */
	protected String containtment = CONTAINTMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final String OPPOSITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected String opposite = OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.REFERENCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContaintment() {
		return containtment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContaintment(String newContaintment) {
		String oldContaintment = containtment;
		containtment = newContaintment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__CONTAINTMENT, oldContaintment, containtment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(String newOpposite) {
		String oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.REFERENCE__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.REFERENCE__NAME:
				return getName();
			case ArdslPackage.REFERENCE__CONTAINTMENT:
				return getContaintment();
			case ArdslPackage.REFERENCE__MIN:
				return getMin();
			case ArdslPackage.REFERENCE__MAX:
				return getMax();
			case ArdslPackage.REFERENCE__TARGET:
				return getTarget();
			case ArdslPackage.REFERENCE__OPPOSITE:
				return getOpposite();
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
			case ArdslPackage.REFERENCE__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.REFERENCE__CONTAINTMENT:
				setContaintment((String)newValue);
				return;
			case ArdslPackage.REFERENCE__MIN:
				setMin((Integer)newValue);
				return;
			case ArdslPackage.REFERENCE__MAX:
				setMax((Integer)newValue);
				return;
			case ArdslPackage.REFERENCE__TARGET:
				setTarget((String)newValue);
				return;
			case ArdslPackage.REFERENCE__OPPOSITE:
				setOpposite((String)newValue);
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
			case ArdslPackage.REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.REFERENCE__CONTAINTMENT:
				setContaintment(CONTAINTMENT_EDEFAULT);
				return;
			case ArdslPackage.REFERENCE__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case ArdslPackage.REFERENCE__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case ArdslPackage.REFERENCE__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case ArdslPackage.REFERENCE__OPPOSITE:
				setOpposite(OPPOSITE_EDEFAULT);
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
			case ArdslPackage.REFERENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.REFERENCE__CONTAINTMENT:
				return CONTAINTMENT_EDEFAULT == null ? containtment != null : !CONTAINTMENT_EDEFAULT.equals(containtment);
			case ArdslPackage.REFERENCE__MIN:
				return min != MIN_EDEFAULT;
			case ArdslPackage.REFERENCE__MAX:
				return max != MAX_EDEFAULT;
			case ArdslPackage.REFERENCE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case ArdslPackage.REFERENCE__OPPOSITE:
				return OPPOSITE_EDEFAULT == null ? opposite != null : !OPPOSITE_EDEFAULT.equals(opposite);
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
		result.append(", containtment: ");
		result.append(containtment);
		result.append(", min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(", target: ");
		result.append(target);
		result.append(", opposite: ");
		result.append(opposite);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
