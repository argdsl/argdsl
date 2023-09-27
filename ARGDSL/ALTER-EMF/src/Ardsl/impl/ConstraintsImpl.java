/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Constraints;
import Ardsl.Planes;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraints</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getPlanes <em>Planes</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getIlumination <em>Ilumination</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getSizeMin <em>Size Min</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getSizeMax <em>Size Max</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getSizeInit <em>Size Init</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#isOverlapping <em>Overlapping</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getXToOriginPos <em>XTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getYToOriginPos <em>YTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getZToOriginPos <em>ZTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getRotation <em>Rotation</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getText <em>Text</em>}</li>
 *   <li>{@link Ardsl.impl.ConstraintsImpl#getTextColor <em>Text Color</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintsImpl extends MinimalEObjectImpl.Container implements Constraints {
	/**
	 * The default value of the '{@link #getPlanes() <em>Planes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlanes()
	 * @generated
	 * @ordered
	 */
	protected static final Planes PLANES_EDEFAULT = Planes.ANY;

	/**
	 * The cached value of the '{@link #getPlanes() <em>Planes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlanes()
	 * @generated
	 * @ordered
	 */
	protected Planes planes = PLANES_EDEFAULT;

	/**
	 * The default value of the '{@link #getIlumination() <em>Ilumination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIlumination()
	 * @generated
	 * @ordered
	 */
	protected static final String ILUMINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIlumination() <em>Ilumination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIlumination()
	 * @generated
	 * @ordered
	 */
	protected String ilumination = ILUMINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSizeMin() <em>Size Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeMin()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSizeMin() <em>Size Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeMin()
	 * @generated
	 * @ordered
	 */
	protected double sizeMin = SIZE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSizeMax() <em>Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeMax()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSizeMax() <em>Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeMax()
	 * @generated
	 * @ordered
	 */
	protected double sizeMax = SIZE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSizeInit() <em>Size Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeInit()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_INIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSizeInit() <em>Size Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeInit()
	 * @generated
	 * @ordered
	 */
	protected double sizeInit = SIZE_INIT_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverlapping() <em>Overlapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverlapping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERLAPPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverlapping() <em>Overlapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverlapping()
	 * @generated
	 * @ordered
	 */
	protected boolean overlapping = OVERLAPPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getXToOriginPos() <em>XTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected static final double XTO_ORIGIN_POS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getXToOriginPos() <em>XTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected double xToOriginPos = XTO_ORIGIN_POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getYToOriginPos() <em>YTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected static final double YTO_ORIGIN_POS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getYToOriginPos() <em>YTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected double yToOriginPos = YTO_ORIGIN_POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getZToOriginPos() <em>ZTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected static final double ZTO_ORIGIN_POS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZToOriginPos() <em>ZTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZToOriginPos()
	 * @generated
	 * @ordered
	 */
	protected double zToOriginPos = ZTO_ORIGIN_POS_EDEFAULT;

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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextColor() <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextColor()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextColor() <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextColor()
	 * @generated
	 * @ordered
	 */
	protected String textColor = TEXT_COLOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.CONSTRAINTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Planes getPlanes() {
		return planes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanes(Planes newPlanes) {
		Planes oldPlanes = planes;
		planes = newPlanes == null ? PLANES_EDEFAULT : newPlanes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__PLANES, oldPlanes, planes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIlumination() {
		return ilumination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIlumination(String newIlumination) {
		String oldIlumination = ilumination;
		ilumination = newIlumination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__ILUMINATION, oldIlumination, ilumination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSizeMin() {
		return sizeMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeMin(double newSizeMin) {
		double oldSizeMin = sizeMin;
		sizeMin = newSizeMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__SIZE_MIN, oldSizeMin, sizeMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSizeMax() {
		return sizeMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeMax(double newSizeMax) {
		double oldSizeMax = sizeMax;
		sizeMax = newSizeMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__SIZE_MAX, oldSizeMax, sizeMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSizeInit() {
		return sizeInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeInit(double newSizeInit) {
		double oldSizeInit = sizeInit;
		sizeInit = newSizeInit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__SIZE_INIT, oldSizeInit, sizeInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverlapping() {
		return overlapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverlapping(boolean newOverlapping) {
		boolean oldOverlapping = overlapping;
		overlapping = newOverlapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__OVERLAPPING, oldOverlapping, overlapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getXToOriginPos() {
		return xToOriginPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXToOriginPos(double newXToOriginPos) {
		double oldXToOriginPos = xToOriginPos;
		xToOriginPos = newXToOriginPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__XTO_ORIGIN_POS, oldXToOriginPos, xToOriginPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getYToOriginPos() {
		return yToOriginPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYToOriginPos(double newYToOriginPos) {
		double oldYToOriginPos = yToOriginPos;
		yToOriginPos = newYToOriginPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__YTO_ORIGIN_POS, oldYToOriginPos, yToOriginPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getZToOriginPos() {
		return zToOriginPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZToOriginPos(double newZToOriginPos) {
		double oldZToOriginPos = zToOriginPos;
		zToOriginPos = newZToOriginPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__ZTO_ORIGIN_POS, oldZToOriginPos, zToOriginPos));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__ROTATION, oldRotation, rotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextColor(String newTextColor) {
		String oldTextColor = textColor;
		textColor = newTextColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONSTRAINTS__TEXT_COLOR, oldTextColor, textColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.CONSTRAINTS__PLANES:
				return getPlanes();
			case ArdslPackage.CONSTRAINTS__ILUMINATION:
				return getIlumination();
			case ArdslPackage.CONSTRAINTS__SIZE_MIN:
				return getSizeMin();
			case ArdslPackage.CONSTRAINTS__SIZE_MAX:
				return getSizeMax();
			case ArdslPackage.CONSTRAINTS__SIZE_INIT:
				return getSizeInit();
			case ArdslPackage.CONSTRAINTS__OVERLAPPING:
				return isOverlapping();
			case ArdslPackage.CONSTRAINTS__XTO_ORIGIN_POS:
				return getXToOriginPos();
			case ArdslPackage.CONSTRAINTS__YTO_ORIGIN_POS:
				return getYToOriginPos();
			case ArdslPackage.CONSTRAINTS__ZTO_ORIGIN_POS:
				return getZToOriginPos();
			case ArdslPackage.CONSTRAINTS__ROTATION:
				return getRotation();
			case ArdslPackage.CONSTRAINTS__TEXT:
				return getText();
			case ArdslPackage.CONSTRAINTS__TEXT_COLOR:
				return getTextColor();
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
			case ArdslPackage.CONSTRAINTS__PLANES:
				setPlanes((Planes)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__ILUMINATION:
				setIlumination((String)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_MIN:
				setSizeMin((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_MAX:
				setSizeMax((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_INIT:
				setSizeInit((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__OVERLAPPING:
				setOverlapping((Boolean)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__XTO_ORIGIN_POS:
				setXToOriginPos((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__YTO_ORIGIN_POS:
				setYToOriginPos((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__ZTO_ORIGIN_POS:
				setZToOriginPos((Double)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__ROTATION:
				setRotation((Integer)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__TEXT:
				setText((String)newValue);
				return;
			case ArdslPackage.CONSTRAINTS__TEXT_COLOR:
				setTextColor((String)newValue);
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
			case ArdslPackage.CONSTRAINTS__PLANES:
				setPlanes(PLANES_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__ILUMINATION:
				setIlumination(ILUMINATION_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_MIN:
				setSizeMin(SIZE_MIN_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_MAX:
				setSizeMax(SIZE_MAX_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__SIZE_INIT:
				setSizeInit(SIZE_INIT_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__OVERLAPPING:
				setOverlapping(OVERLAPPING_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__XTO_ORIGIN_POS:
				setXToOriginPos(XTO_ORIGIN_POS_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__YTO_ORIGIN_POS:
				setYToOriginPos(YTO_ORIGIN_POS_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__ZTO_ORIGIN_POS:
				setZToOriginPos(ZTO_ORIGIN_POS_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__ROTATION:
				setRotation(ROTATION_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case ArdslPackage.CONSTRAINTS__TEXT_COLOR:
				setTextColor(TEXT_COLOR_EDEFAULT);
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
			case ArdslPackage.CONSTRAINTS__PLANES:
				return planes != PLANES_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__ILUMINATION:
				return ILUMINATION_EDEFAULT == null ? ilumination != null : !ILUMINATION_EDEFAULT.equals(ilumination);
			case ArdslPackage.CONSTRAINTS__SIZE_MIN:
				return sizeMin != SIZE_MIN_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__SIZE_MAX:
				return sizeMax != SIZE_MAX_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__SIZE_INIT:
				return sizeInit != SIZE_INIT_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__OVERLAPPING:
				return overlapping != OVERLAPPING_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__XTO_ORIGIN_POS:
				return xToOriginPos != XTO_ORIGIN_POS_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__YTO_ORIGIN_POS:
				return yToOriginPos != YTO_ORIGIN_POS_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__ZTO_ORIGIN_POS:
				return zToOriginPos != ZTO_ORIGIN_POS_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__ROTATION:
				return rotation != ROTATION_EDEFAULT;
			case ArdslPackage.CONSTRAINTS__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case ArdslPackage.CONSTRAINTS__TEXT_COLOR:
				return TEXT_COLOR_EDEFAULT == null ? textColor != null : !TEXT_COLOR_EDEFAULT.equals(textColor);
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
		result.append(" (planes: ");
		result.append(planes);
		result.append(", ilumination: ");
		result.append(ilumination);
		result.append(", sizeMin: ");
		result.append(sizeMin);
		result.append(", sizeMax: ");
		result.append(sizeMax);
		result.append(", sizeInit: ");
		result.append(sizeInit);
		result.append(", overlapping: ");
		result.append(overlapping);
		result.append(", xToOriginPos: ");
		result.append(xToOriginPos);
		result.append(", yToOriginPos: ");
		result.append(yToOriginPos);
		result.append(", zToOriginPos: ");
		result.append(zToOriginPos);
		result.append(", rotation: ");
		result.append(rotation);
		result.append(", text: ");
		result.append(text);
		result.append(", textColor: ");
		result.append(textColor);
		result.append(')');
		return result.toString();
	}

} //ConstraintsImpl
