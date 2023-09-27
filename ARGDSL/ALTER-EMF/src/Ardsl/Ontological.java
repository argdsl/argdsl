/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ontological</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Ontological#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.Ontological#getClasses <em>Classes</em>}</li>
 *   <li>{@link Ardsl.Ontological#getGraphic <em>Graphic</em>}</li>
 *   <li>{@link Ardsl.Ontological#getPhysic <em>Physic</em>}</li>
 *   <li>{@link Ardsl.Ontological#getGame <em>Game</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getOntological()
 * @model
 * @generated
 */
public interface Ontological extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getOntological_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.Ontological#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getOntological_Classes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Ardsl.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Graphic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphic</em>' containment reference.
	 * @see #setGraphic(Graphic)
	 * @see Ardsl.ArdslPackage#getOntological_Graphic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graphic getGraphic();

	/**
	 * Sets the value of the '{@link Ardsl.Ontological#getGraphic <em>Graphic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphic</em>' containment reference.
	 * @see #getGraphic()
	 * @generated
	 */
	void setGraphic(Graphic value);

	/**
	 * Returns the value of the '<em><b>Physic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physic</em>' containment reference.
	 * @see #setPhysic(Physic)
	 * @see Ardsl.ArdslPackage#getOntological_Physic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Physic getPhysic();

	/**
	 * Sets the value of the '{@link Ardsl.Ontological#getPhysic <em>Physic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physic</em>' containment reference.
	 * @see #getPhysic()
	 * @generated
	 */
	void setPhysic(Physic value);

	/**
	 * Returns the value of the '<em><b>Game</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game</em>' containment reference.
	 * @see #setGame(Game)
	 * @see Ardsl.ArdslPackage#getOntological_Game()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Game getGame();

	/**
	 * Sets the value of the '{@link Ardsl.Ontological#getGame <em>Game</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game</em>' containment reference.
	 * @see #getGame()
	 * @generated
	 */
	void setGame(Game value);

} // Ontological
