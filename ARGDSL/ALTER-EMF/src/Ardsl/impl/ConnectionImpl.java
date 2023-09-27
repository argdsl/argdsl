/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Connection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getType <em>Type</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getColor <em>Color</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getTextColor <em>Text Color</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getDecorator <em>Decorator</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getDecoratorPos <em>Decorator Pos</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link Ardsl.impl.ConnectionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends MinimalEObjectImpl.Container implements Connection {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

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
	 * The default value of the '{@link #getDecorator() <em>Decorator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecorator()
	 * @generated
	 * @ordered
	 */
	protected static final String DECORATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecorator() <em>Decorator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecorator()
	 * @generated
	 * @ordered
	 */
	protected String decorator = DECORATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecoratorPos() <em>Decorator Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoratorPos()
	 * @generated
	 * @ordered
	 */
	protected static final String DECORATOR_POS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecoratorPos() <em>Decorator Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoratorPos()
	 * @generated
	 * @ordered
	 */
	protected String decoratorPos = DECORATOR_POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final double WIDTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected double width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected String position = POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.CONNECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__COLOR, oldColor, color));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__TEXT_COLOR, oldTextColor, textColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecorator() {
		return decorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecorator(String newDecorator) {
		String oldDecorator = decorator;
		decorator = newDecorator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__DECORATOR, oldDecorator, decorator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecoratorPos() {
		return decoratorPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoratorPos(String newDecoratorPos) {
		String oldDecoratorPos = decoratorPos;
		decoratorPos = newDecoratorPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__DECORATOR_POS, oldDecoratorPos, decoratorPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(double newWidth) {
		double oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(String newPosition) {
		String oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.CONNECTION__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.CONNECTION__NAME:
				return getName();
			case ArdslPackage.CONNECTION__TYPE:
				return getType();
			case ArdslPackage.CONNECTION__COLOR:
				return getColor();
			case ArdslPackage.CONNECTION__TEXT_COLOR:
				return getTextColor();
			case ArdslPackage.CONNECTION__DECORATOR:
				return getDecorator();
			case ArdslPackage.CONNECTION__DECORATOR_POS:
				return getDecoratorPos();
			case ArdslPackage.CONNECTION__PATTERN:
				return getPattern();
			case ArdslPackage.CONNECTION__WIDTH:
				return getWidth();
			case ArdslPackage.CONNECTION__POSITION:
				return getPosition();
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
			case ArdslPackage.CONNECTION__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.CONNECTION__TYPE:
				setType((String)newValue);
				return;
			case ArdslPackage.CONNECTION__COLOR:
				setColor((String)newValue);
				return;
			case ArdslPackage.CONNECTION__TEXT_COLOR:
				setTextColor((String)newValue);
				return;
			case ArdslPackage.CONNECTION__DECORATOR:
				setDecorator((String)newValue);
				return;
			case ArdslPackage.CONNECTION__DECORATOR_POS:
				setDecoratorPos((String)newValue);
				return;
			case ArdslPackage.CONNECTION__PATTERN:
				setPattern((String)newValue);
				return;
			case ArdslPackage.CONNECTION__WIDTH:
				setWidth((Double)newValue);
				return;
			case ArdslPackage.CONNECTION__POSITION:
				setPosition((String)newValue);
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
			case ArdslPackage.CONNECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__TEXT_COLOR:
				setTextColor(TEXT_COLOR_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__DECORATOR:
				setDecorator(DECORATOR_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__DECORATOR_POS:
				setDecoratorPos(DECORATOR_POS_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ArdslPackage.CONNECTION__POSITION:
				setPosition(POSITION_EDEFAULT);
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
			case ArdslPackage.CONNECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.CONNECTION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ArdslPackage.CONNECTION__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case ArdslPackage.CONNECTION__TEXT_COLOR:
				return TEXT_COLOR_EDEFAULT == null ? textColor != null : !TEXT_COLOR_EDEFAULT.equals(textColor);
			case ArdslPackage.CONNECTION__DECORATOR:
				return DECORATOR_EDEFAULT == null ? decorator != null : !DECORATOR_EDEFAULT.equals(decorator);
			case ArdslPackage.CONNECTION__DECORATOR_POS:
				return DECORATOR_POS_EDEFAULT == null ? decoratorPos != null : !DECORATOR_POS_EDEFAULT.equals(decoratorPos);
			case ArdslPackage.CONNECTION__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case ArdslPackage.CONNECTION__WIDTH:
				return width != WIDTH_EDEFAULT;
			case ArdslPackage.CONNECTION__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
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
		result.append(", type: ");
		result.append(type);
		result.append(", color: ");
		result.append(color);
		result.append(", textColor: ");
		result.append(textColor);
		result.append(", decorator: ");
		result.append(decorator);
		result.append(", decoratorPos: ");
		result.append(decoratorPos);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(", width: ");
		result.append(width);
		result.append(", position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
