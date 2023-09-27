/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit Masks</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.BitMasks#getCollision <em>Collision</em>}</li>
 *   <li>{@link Ardsl.BitMasks#getContact <em>Contact</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getBitMasks()
 * @model
 * @generated
 */
public interface BitMasks extends EObject {
	/**
	 * Returns the value of the '<em><b>Collision</b></em>' reference list.
	 * The list contents are of type {@link Ardsl.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collision</em>' reference list.
	 * @see Ardsl.ArdslPackage#getBitMasks_Collision()
	 * @model
	 * @generated
	 */
	EList<Ardsl.Class> getCollision();

	/**
	 * Returns the value of the '<em><b>Contact</b></em>' reference list.
	 * The list contents are of type {@link Ardsl.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact</em>' reference list.
	 * @see Ardsl.ArdslPackage#getBitMasks_Contact()
	 * @model
	 * @generated
	 */
	EList<Ardsl.Class> getContact();

} // BitMasks
