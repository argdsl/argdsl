/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.ScoreSystem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Score System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.ScoreSystemImpl#getStart <em>Start</em>}</li>
 *   <li>{@link Ardsl.impl.ScoreSystemImpl#getFinish <em>Finish</em>}</li>
 *   <li>{@link Ardsl.impl.ScoreSystemImpl#getLives <em>Lives</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScoreSystemImpl extends MinimalEObjectImpl.Container implements ScoreSystem {
	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinish() <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinish()
	 * @generated
	 * @ordered
	 */
	protected static final int FINISH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFinish() <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinish()
	 * @generated
	 * @ordered
	 */
	protected int finish = FINISH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLives() <em>Lives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLives()
	 * @generated
	 * @ordered
	 */
	protected static final int LIVES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLives() <em>Lives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLives()
	 * @generated
	 * @ordered
	 */
	protected int lives = LIVES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoreSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.SCORE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.SCORE_SYSTEM__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFinish() {
		return finish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinish(int newFinish) {
		int oldFinish = finish;
		finish = newFinish;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.SCORE_SYSTEM__FINISH, oldFinish, finish));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLives(int newLives) {
		int oldLives = lives;
		lives = newLives;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.SCORE_SYSTEM__LIVES, oldLives, lives));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.SCORE_SYSTEM__START:
				return getStart();
			case ArdslPackage.SCORE_SYSTEM__FINISH:
				return getFinish();
			case ArdslPackage.SCORE_SYSTEM__LIVES:
				return getLives();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArdslPackage.SCORE_SYSTEM__START:
				setStart((Integer)newValue);
				return;
			case ArdslPackage.SCORE_SYSTEM__FINISH:
				setFinish((Integer)newValue);
				return;
			case ArdslPackage.SCORE_SYSTEM__LIVES:
				setLives((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArdslPackage.SCORE_SYSTEM__START:
				setStart(START_EDEFAULT);
				return;
			case ArdslPackage.SCORE_SYSTEM__FINISH:
				setFinish(FINISH_EDEFAULT);
				return;
			case ArdslPackage.SCORE_SYSTEM__LIVES:
				setLives(LIVES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArdslPackage.SCORE_SYSTEM__START:
				return start != START_EDEFAULT;
			case ArdslPackage.SCORE_SYSTEM__FINISH:
				return finish != FINISH_EDEFAULT;
			case ArdslPackage.SCORE_SYSTEM__LIVES:
				return lives != LIVES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (start: ");
		result.append(start);
		result.append(", finish: ");
		result.append(finish);
		result.append(", lives: ");
		result.append(lives);
		result.append(')');
		return result.toString();
	}

} //ScoreSystemImpl
