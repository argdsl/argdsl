/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Graphic#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getGraphic()
 * @model
 * @generated
 */
public interface Graphic extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.GraphicClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGraphic_Classes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<GraphicClass> getClasses();

} // Graphic
