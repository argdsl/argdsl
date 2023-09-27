/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Force;

import Ardsl.Gesture;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ForceImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.ForceImpl#getGesture <em>Gesture</em>}</li>
 *   <li>{@link Ardsl.impl.ForceImpl#getXVector <em>XVector</em>}</li>
 *   <li>{@link Ardsl.impl.ForceImpl#getYVector <em>YVector</em>}</li>
 *   <li>{@link Ardsl.impl.ForceImpl#getZVector <em>ZVector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForceImpl extends MinimalEObjectImpl.Container implements Force {
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
	 * The default value of the '{@link #getGesture() <em>Gesture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGesture()
	 * @generated
	 * @ordered
	 */
	protected static final Gesture GESTURE_EDEFAULT = Gesture.TOUCH;

	/**
	 * The cached value of the '{@link #getGesture() <em>Gesture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGesture()
	 * @generated
	 * @ordered
	 */
	protected Gesture gesture = GESTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXVector() <em>XVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXVector()
	 * @generated
	 * @ordered
	 */
	protected static final double XVECTOR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getXVector() <em>XVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXVector()
	 * @generated
	 * @ordered
	 */
	protected double xVector = XVECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getYVector() <em>YVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYVector()
	 * @generated
	 * @ordered
	 */
	protected static final double YVECTOR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getYVector() <em>YVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYVector()
	 * @generated
	 * @ordered
	 */
	protected double yVector = YVECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getZVector() <em>ZVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZVector()
	 * @generated
	 * @ordered
	 */
	protected static final double ZVECTOR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZVector() <em>ZVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZVector()
	 * @generated
	 * @ordered
	 */
	protected double zVector = ZVECTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.FORCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.FORCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gesture getGesture() {
		return gesture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGesture(Gesture newGesture) {
		Gesture oldGesture = gesture;
		gesture = newGesture == null ? GESTURE_EDEFAULT : newGesture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.FORCE__GESTURE, oldGesture, gesture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getXVector() {
		return xVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXVector(double newXVector) {
		double oldXVector = xVector;
		xVector = newXVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.FORCE__XVECTOR, oldXVector, xVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getYVector() {
		return yVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYVector(double newYVector) {
		double oldYVector = yVector;
		yVector = newYVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.FORCE__YVECTOR, oldYVector, yVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getZVector() {
		return zVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZVector(double newZVector) {
		double oldZVector = zVector;
		zVector = newZVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.FORCE__ZVECTOR, oldZVector, zVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.FORCE__NAME:
				return getName();
			case ArdslPackage.FORCE__GESTURE:
				return getGesture();
			case ArdslPackage.FORCE__XVECTOR:
				return getXVector();
			case ArdslPackage.FORCE__YVECTOR:
				return getYVector();
			case ArdslPackage.FORCE__ZVECTOR:
				return getZVector();
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
			case ArdslPackage.FORCE__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.FORCE__GESTURE:
				setGesture((Gesture)newValue);
				return;
			case ArdslPackage.FORCE__XVECTOR:
				setXVector((Double)newValue);
				return;
			case ArdslPackage.FORCE__YVECTOR:
				setYVector((Double)newValue);
				return;
			case ArdslPackage.FORCE__ZVECTOR:
				setZVector((Double)newValue);
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
			case ArdslPackage.FORCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.FORCE__GESTURE:
				setGesture(GESTURE_EDEFAULT);
				return;
			case ArdslPackage.FORCE__XVECTOR:
				setXVector(XVECTOR_EDEFAULT);
				return;
			case ArdslPackage.FORCE__YVECTOR:
				setYVector(YVECTOR_EDEFAULT);
				return;
			case ArdslPackage.FORCE__ZVECTOR:
				setZVector(ZVECTOR_EDEFAULT);
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
			case ArdslPackage.FORCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.FORCE__GESTURE:
				return gesture != GESTURE_EDEFAULT;
			case ArdslPackage.FORCE__XVECTOR:
				return xVector != XVECTOR_EDEFAULT;
			case ArdslPackage.FORCE__YVECTOR:
				return yVector != YVECTOR_EDEFAULT;
			case ArdslPackage.FORCE__ZVECTOR:
				return zVector != ZVECTOR_EDEFAULT;
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
		result.append(", gesture: ");
		result.append(gesture);
		result.append(", xVector: ");
		result.append(xVector);
		result.append(", yVector: ");
		result.append(yVector);
		result.append(", zVector: ");
		result.append(zVector);
		result.append(')');
		return result.toString();
	}

} //ForceImpl
