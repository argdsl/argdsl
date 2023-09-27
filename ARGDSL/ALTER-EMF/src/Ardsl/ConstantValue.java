/**
 */
package Ardsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.ConstantValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getConstantValue()
 * @model
 * @generated
 */
public interface ConstantValue extends Value {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see Ardsl.ArdslPackage#getConstantValue_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link Ardsl.ConstantValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ConstantValue
