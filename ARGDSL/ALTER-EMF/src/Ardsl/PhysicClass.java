/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physic Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.PhysicClass#getPhysicBody <em>Physic Body</em>}</li>
 *   <li>{@link Ardsl.PhysicClass#getBitMasks <em>Bit Masks</em>}</li>
 *   <li>{@link Ardsl.PhysicClass#getOntoClass <em>Onto Class</em>}</li>
 *   <li>{@link Ardsl.PhysicClass#getForces <em>Forces</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getPhysicClass()
 * @model
 * @generated
 */
public interface PhysicClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Physic Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physic Body</em>' containment reference.
	 * @see #setPhysicBody(PhysicBody)
	 * @see Ardsl.ArdslPackage#getPhysicClass_PhysicBody()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PhysicBody getPhysicBody();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicClass#getPhysicBody <em>Physic Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physic Body</em>' containment reference.
	 * @see #getPhysicBody()
	 * @generated
	 */
	void setPhysicBody(PhysicBody value);

	/**
	 * Returns the value of the '<em><b>Bit Masks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bit Masks</em>' containment reference.
	 * @see #setBitMasks(BitMasks)
	 * @see Ardsl.ArdslPackage#getPhysicClass_BitMasks()
	 * @model containment="true"
	 * @generated
	 */
	BitMasks getBitMasks();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicClass#getBitMasks <em>Bit Masks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bit Masks</em>' containment reference.
	 * @see #getBitMasks()
	 * @generated
	 */
	void setBitMasks(BitMasks value);

	/**
	 * Returns the value of the '<em><b>Onto Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Onto Class</em>' reference.
	 * @see #setOntoClass(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getPhysicClass_OntoClass()
	 * @model required="true"
	 * @generated
	 */
	Ardsl.Class getOntoClass();

	/**
	 * Sets the value of the '{@link Ardsl.PhysicClass#getOntoClass <em>Onto Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Onto Class</em>' reference.
	 * @see #getOntoClass()
	 * @generated
	 */
	void setOntoClass(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Forces</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Force}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forces</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getPhysicClass_Forces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Force> getForces();

} // PhysicClass
