/**
 */
package Ardsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logic Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.LogicOp#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getLogicOp()
 * @model abstract="true"
 * @generated
 */
public interface LogicOp extends Condition {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Condition)
	 * @see Ardsl.ArdslPackage#getLogicOp_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Condition getLeft();

	/**
	 * Sets the value of the '{@link Ardsl.LogicOp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Condition value);

} // LogicOp
