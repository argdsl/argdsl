/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Score System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.ScoreSystem#getStart <em>Start</em>}</li>
 *   <li>{@link Ardsl.ScoreSystem#getFinish <em>Finish</em>}</li>
 *   <li>{@link Ardsl.ScoreSystem#getLives <em>Lives</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getScoreSystem()
 * @model
 * @generated
 */
public interface ScoreSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see Ardsl.ArdslPackage#getScoreSystem_Start()
	 * @model required="true"
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link Ardsl.ScoreSystem#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish</em>' attribute.
	 * @see #setFinish(int)
	 * @see Ardsl.ArdslPackage#getScoreSystem_Finish()
	 * @model required="true"
	 * @generated
	 */
	int getFinish();

	/**
	 * Sets the value of the '{@link Ardsl.ScoreSystem#getFinish <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish</em>' attribute.
	 * @see #getFinish()
	 * @generated
	 */
	void setFinish(int value);

	/**
	 * Returns the value of the '<em><b>Lives</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lives</em>' attribute.
	 * @see #setLives(int)
	 * @see Ardsl.ArdslPackage#getScoreSystem_Lives()
	 * @model required="true"
	 * @generated
	 */
	int getLives();

	/**
	 * Sets the value of the '{@link Ardsl.ScoreSystem#getLives <em>Lives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lives</em>' attribute.
	 * @see #getLives()
	 * @generated
	 */
	void setLives(int value);

} // ScoreSystem
