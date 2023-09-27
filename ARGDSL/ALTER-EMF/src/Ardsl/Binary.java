/**
 */
package Ardsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Binary#getRight <em>Right</em>}</li>
 *   <li>{@link Ardsl.Binary#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getBinary()
 * @model
 * @generated
 */
public interface Binary extends LogicOp {
	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Condition)
	 * @see Ardsl.ArdslPackage#getBinary_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Condition getRight();

	/**
	 * Sets the value of the '{@link Ardsl.Binary#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Condition value);

	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.LogicOps}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see Ardsl.LogicOps
	 * @see #setOp(LogicOps)
	 * @see Ardsl.ArdslPackage#getBinary_Op()
	 * @model required="true"
	 * @generated
	 */
	LogicOps getOp();

	/**
	 * Sets the value of the '{@link Ardsl.Binary#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see Ardsl.LogicOps
	 * @see #getOp()
	 * @generated
	 */
	void setOp(LogicOps value);

} // Binary
