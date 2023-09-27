/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Class#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.Class#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link Ardsl.Class#isNoSCN <em>No SCN</em>}</li>
 *   <li>{@link Ardsl.Class#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link Ardsl.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link Ardsl.Class#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getClass_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.Class#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see Ardsl.ArdslPackage#getClass_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link Ardsl.Class#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>No SCN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No SCN</em>' attribute.
	 * @see #setNoSCN(boolean)
	 * @see Ardsl.ArdslPackage#getClass_NoSCN()
	 * @model
	 * @generated
	 */
	boolean isNoSCN();

	/**
	 * Sets the value of the '{@link Ardsl.Class#isNoSCN <em>No SCN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No SCN</em>' attribute.
	 * @see #isNoSCN()
	 * @generated
	 */
	void setNoSCN(boolean value);

	/**
	 * Returns the value of the '<em><b>Superclass</b></em>' reference list.
	 * The list contents are of type {@link Ardsl.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superclass</em>' reference list.
	 * @see Ardsl.ArdslPackage#getClass_Superclass()
	 * @model
	 * @generated
	 */
	EList<Class> getSuperclass();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Reference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getClass_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference> getReferences();

} // Class
