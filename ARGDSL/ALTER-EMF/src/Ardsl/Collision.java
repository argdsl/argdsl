/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Collision#getClassA <em>Class A</em>}</li>
 *   <li>{@link Ardsl.Collision#getClassB <em>Class B</em>}</li>
 *   <li>{@link Ardsl.Collision#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getCollision()
 * @model
 * @generated
 */
public interface Collision extends EObject {
	/**
	 * Returns the value of the '<em><b>Class A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class A</em>' reference.
	 * @see #setClassA(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getCollision_ClassA()
	 * @model required="true"
	 * @generated
	 */
	Ardsl.Class getClassA();

	/**
	 * Sets the value of the '{@link Ardsl.Collision#getClassA <em>Class A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class A</em>' reference.
	 * @see #getClassA()
	 * @generated
	 */
	void setClassA(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Class B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class B</em>' reference.
	 * @see #setClassB(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getCollision_ClassB()
	 * @model required="true"
	 * @generated
	 */
	Ardsl.Class getClassB();

	/**
	 * Sets the value of the '{@link Ardsl.Collision#getClassB <em>Class B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class B</em>' reference.
	 * @see #getClassB()
	 * @generated
	 */
	void setClassB(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Trigger)
	 * @see Ardsl.ArdslPackage#getCollision_Action()
	 * @model required="true"
	 * @generated
	 */
	Trigger getAction();

	/**
	 * Sets the value of the '{@link Ardsl.Collision#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Trigger value);

} // Collision
