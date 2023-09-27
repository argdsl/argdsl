/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Game#getWin <em>Win</em>}</li>
 *   <li>{@link Ardsl.Game#getLose <em>Lose</em>}</li>
 *   <li>{@link Ardsl.Game#getStart <em>Start</em>}</li>
 *   <li>{@link Ardsl.Game#getGamepad <em>Gamepad</em>}</li>
 *   <li>{@link Ardsl.Game#getScore <em>Score</em>}</li>
 *   <li>{@link Ardsl.Game#getActionsTriggers <em>Actions Triggers</em>}</li>
 *   <li>{@link Ardsl.Game#getCollisions <em>Collisions</em>}</li>
 *   <li>{@link Ardsl.Game#getObjInit <em>Obj Init</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getGame()
 * @model
 * @generated
 */
public interface Game extends EObject {
	/**
	 * Returns the value of the '<em><b>Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Win</em>' attribute.
	 * @see #setWin(String)
	 * @see Ardsl.ArdslPackage#getGame_Win()
	 * @model required="true"
	 * @generated
	 */
	String getWin();

	/**
	 * Sets the value of the '{@link Ardsl.Game#getWin <em>Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Win</em>' attribute.
	 * @see #getWin()
	 * @generated
	 */
	void setWin(String value);

	/**
	 * Returns the value of the '<em><b>Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lose</em>' attribute.
	 * @see #setLose(String)
	 * @see Ardsl.ArdslPackage#getGame_Lose()
	 * @model required="true"
	 * @generated
	 */
	String getLose();

	/**
	 * Sets the value of the '{@link Ardsl.Game#getLose <em>Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lose</em>' attribute.
	 * @see #getLose()
	 * @generated
	 */
	void setLose(String value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(String)
	 * @see Ardsl.ArdslPackage#getGame_Start()
	 * @model required="true"
	 * @generated
	 */
	String getStart();

	/**
	 * Sets the value of the '{@link Ardsl.Game#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(String value);

	/**
	 * Returns the value of the '<em><b>Gamepad</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.GamePad}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gamepad</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGame_Gamepad()
	 * @model containment="true"
	 * @generated
	 */
	EList<GamePad> getGamepad();

	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference.
	 * @see #setScore(ScoreSystem)
	 * @see Ardsl.ArdslPackage#getGame_Score()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ScoreSystem getScore();

	/**
	 * Sets the value of the '{@link Ardsl.Game#getScore <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' containment reference.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(ScoreSystem value);

	/**
	 * Returns the value of the '<em><b>Actions Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Trigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Triggers</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGame_ActionsTriggers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Trigger> getActionsTriggers();

	/**
	 * Returns the value of the '<em><b>Collisions</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Collision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collisions</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGame_Collisions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Collision> getCollisions();

	/**
	 * Returns the value of the '<em><b>Obj Init</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.ObjInit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Init</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getGame_ObjInit()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjInit> getObjInit();

} // Game
