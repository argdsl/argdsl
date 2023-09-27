/**
 */
package Ardsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arithmetic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Arithmetic#getOp <em>Op</em>}</li>
 *   <li>{@link Ardsl.Arithmetic#getRight <em>Right</em>}</li>
 *   <li>{@link Ardsl.Arithmetic#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getArithmetic()
 * @model
 * @generated
 */
public interface Arithmetic extends Condition {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.ArithmOps}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see Ardsl.ArithmOps
	 * @see #setOp(ArithmOps)
	 * @see Ardsl.ArdslPackage#getArithmetic_Op()
	 * @model required="true"
	 * @generated
	 */
	ArithmOps getOp();

	/**
	 * Sets the value of the '{@link Ardsl.Arithmetic#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see Ardsl.ArithmOps
	 * @see #getOp()
	 * @generated
	 */
	void setOp(ArithmOps value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Value)
	 * @see Ardsl.ArdslPackage#getArithmetic_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Value getRight();

	/**
	 * Sets the value of the '{@link Ardsl.Arithmetic#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Value value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Value)
	 * @see Ardsl.ArdslPackage#getArithmetic_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Value getLeft();

	/**
	 * Sets the value of the '{@link Ardsl.Arithmetic#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Value value);

} // Arithmetic
