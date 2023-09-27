/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Trigger#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.Trigger#getMessage <em>Message</em>}</li>
 *   <li>{@link Ardsl.Trigger#getTimeTrigger <em>Time Trigger</em>}</li>
 *   <li>{@link Ardsl.Trigger#getScoreChange <em>Score Change</em>}</li>
 *   <li>{@link Ardsl.Trigger#getPhysicChanges <em>Physic Changes</em>}</li>
 *   <li>{@link Ardsl.Trigger#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getTrigger_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.Trigger#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see Ardsl.ArdslPackage#getTrigger_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link Ardsl.Trigger#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Time Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Trigger</em>' attribute.
	 * @see #setTimeTrigger(int)
	 * @see Ardsl.ArdslPackage#getTrigger_TimeTrigger()
	 * @model
	 * @generated
	 */
	int getTimeTrigger();

	/**
	 * Sets the value of the '{@link Ardsl.Trigger#getTimeTrigger <em>Time Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Trigger</em>' attribute.
	 * @see #getTimeTrigger()
	 * @generated
	 */
	void setTimeTrigger(int value);

	/**
	 * Returns the value of the '<em><b>Score Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score Change</em>' attribute.
	 * @see #setScoreChange(int)
	 * @see Ardsl.ArdslPackage#getTrigger_ScoreChange()
	 * @model
	 * @generated
	 */
	int getScoreChange();

	/**
	 * Sets the value of the '{@link Ardsl.Trigger#getScoreChange <em>Score Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score Change</em>' attribute.
	 * @see #getScoreChange()
	 * @generated
	 */
	void setScoreChange(int value);

	/**
	 * Returns the value of the '<em><b>Physic Changes</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.PhysicChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physic Changes</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getTrigger_PhysicChanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<PhysicChange> getPhysicChanges();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.BasicActions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see Ardsl.BasicActions
	 * @see #setAction(BasicActions)
	 * @see Ardsl.ArdslPackage#getTrigger_Action()
	 * @model
	 * @generated
	 */
	BasicActions getAction();

	/**
	 * Sets the value of the '{@link Ardsl.Trigger#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see Ardsl.BasicActions
	 * @see #getAction()
	 * @generated
	 */
	void setAction(BasicActions value);

} // Trigger
