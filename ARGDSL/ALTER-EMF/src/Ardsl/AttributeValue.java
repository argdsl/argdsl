/**
 */
package Ardsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.AttributeValue#getClass_ <em>Class</em>}</li>
 *   <li>{@link Ardsl.AttributeValue#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getAttributeValue()
 * @model
 * @generated
 */
public interface AttributeValue extends Value {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see Ardsl.ArdslPackage#getAttributeValue_Class()
	 * @model required="true"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link Ardsl.AttributeValue#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see Ardsl.ArdslPackage#getAttributeValue_Attribute()
	 * @model required="true"
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link Ardsl.AttributeValue#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

} // AttributeValue
