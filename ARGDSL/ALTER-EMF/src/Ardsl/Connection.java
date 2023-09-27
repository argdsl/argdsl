/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Connection#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.Connection#getType <em>Type</em>}</li>
 *   <li>{@link Ardsl.Connection#getColor <em>Color</em>}</li>
 *   <li>{@link Ardsl.Connection#getTextColor <em>Text Color</em>}</li>
 *   <li>{@link Ardsl.Connection#getDecorator <em>Decorator</em>}</li>
 *   <li>{@link Ardsl.Connection#getDecoratorPos <em>Decorator Pos</em>}</li>
 *   <li>{@link Ardsl.Connection#getPattern <em>Pattern</em>}</li>
 *   <li>{@link Ardsl.Connection#getWidth <em>Width</em>}</li>
 *   <li>{@link Ardsl.Connection#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getConnection_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see Ardsl.ArdslPackage#getConnection_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see Ardsl.ArdslPackage#getConnection_Color()
	 * @model required="true"
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Color</em>' attribute.
	 * @see #setTextColor(String)
	 * @see Ardsl.ArdslPackage#getConnection_TextColor()
	 * @model required="true"
	 * @generated
	 */
	String getTextColor();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getTextColor <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Color</em>' attribute.
	 * @see #getTextColor()
	 * @generated
	 */
	void setTextColor(String value);

	/**
	 * Returns the value of the '<em><b>Decorator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator</em>' attribute.
	 * @see #setDecorator(String)
	 * @see Ardsl.ArdslPackage#getConnection_Decorator()
	 * @model required="true"
	 * @generated
	 */
	String getDecorator();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getDecorator <em>Decorator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator</em>' attribute.
	 * @see #getDecorator()
	 * @generated
	 */
	void setDecorator(String value);

	/**
	 * Returns the value of the '<em><b>Decorator Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator Pos</em>' attribute.
	 * @see #setDecoratorPos(String)
	 * @see Ardsl.ArdslPackage#getConnection_DecoratorPos()
	 * @model required="true"
	 * @generated
	 */
	String getDecoratorPos();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getDecoratorPos <em>Decorator Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator Pos</em>' attribute.
	 * @see #getDecoratorPos()
	 * @generated
	 */
	void setDecoratorPos(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see Ardsl.ArdslPackage#getConnection_Pattern()
	 * @model required="true"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(double)
	 * @see Ardsl.ArdslPackage#getConnection_Width()
	 * @model required="true"
	 * @generated
	 */
	double getWidth();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(double value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(String)
	 * @see Ardsl.ArdslPackage#getConnection_Position()
	 * @model required="true"
	 * @generated
	 */
	String getPosition();

	/**
	 * Sets the value of the '{@link Ardsl.Connection#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(String value);

} // Connection
