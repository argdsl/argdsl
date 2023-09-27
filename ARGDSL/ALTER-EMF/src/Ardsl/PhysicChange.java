/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physic Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.PhysicChange#getObject <em>Object</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getAction <em>Action</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getClass_ <em>Class</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getForce <em>Force</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getPosition <em>Position</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getScale <em>Scale</em>}</li>
 *   <li>{@link Ardsl.PhysicChange#getChangeValue <em>Change Value</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getPhysicChange()
 * @model
 * @generated
 */
public interface PhysicChange extends EObject {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(String)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Object()
	 * @model required="true"
	 * @generated
	 */
	String getObject();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see Ardsl.Action
	 * @see #setAction(Action)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Action()
	 * @model required="true"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see Ardsl.Action
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Class()
	 * @model
	 * @generated
	 */
	Ardsl.Class getClass_();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Force</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force</em>' reference.
	 * @see #setForce(Force)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Force()
	 * @model
	 * @generated
	 */
	Force getForce();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getForce <em>Force</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force</em>' reference.
	 * @see #getForce()
	 * @generated
	 */
	void setForce(Force value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.Position}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see Ardsl.Position
	 * @see #setPosition(Position)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Position()
	 * @model
	 * @generated
	 */
	Position getPosition();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see Ardsl.Position
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Position value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(double)
	 * @see Ardsl.ArdslPackage#getPhysicChange_Scale()
	 * @model
	 * @generated
	 */
	double getScale();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(double value);

	/**
	 * Returns the value of the '<em><b>Change Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Value</em>' attribute.
	 * @see #setChangeValue(int)
	 * @see Ardsl.ArdslPackage#getPhysicChange_ChangeValue()
	 * @model
	 * @generated
	 */
	int getChangeValue();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicChange#getChangeValue <em>Change Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Value</em>' attribute.
	 * @see #getChangeValue()
	 * @generated
	 */
	void setChangeValue(int value);

} // PhysicChange
