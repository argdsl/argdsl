/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphic Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.GraphicClass#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link Ardsl.GraphicClass#getConnections <em>Connections</em>}</li>
 *   <li>{@link Ardsl.GraphicClass#getOntoClass <em>Onto Class</em>}</li>
 *   <li>{@link Ardsl.GraphicClass#getVersions <em>Versions</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getGraphicClass()
 * @model
 * @generated
 */
public interface GraphicClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(Constraints)
	 * @see Ardsl.ArdslPackage#getGraphicClass_Constraints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Constraints getConstraints();

	/**
	 * Sets the value of the '{@link Ardsl.GraphicClass#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(Constraints value);

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGraphicClass_Connections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Onto Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Onto Class</em>' reference.
	 * @see #setOntoClass(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getGraphicClass_OntoClass()
	 * @model required="true"
	 * @generated
	 */
	Ardsl.Class getOntoClass();

	/**
	 * Sets the value of the '{@link Ardsl.GraphicClass#getOntoClass <em>Onto Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Onto Class</em>' reference.
	 * @see #getOntoClass()
	 * @generated
	 */
	void setOntoClass(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Versions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGraphicClass_Versions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Versions> getVersions();

} // GraphicClass
