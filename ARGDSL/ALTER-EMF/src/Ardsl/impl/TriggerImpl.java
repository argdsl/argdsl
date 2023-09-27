/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.BasicActions;
import Ardsl.PhysicChange;
import Ardsl.Trigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.TriggerImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.TriggerImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link Ardsl.impl.TriggerImpl#getTimeTrigger <em>Time Trigger</em>}</li>
 *   <li>{@link Ardsl.impl.TriggerImpl#getScoreChange <em>Score Change</em>}</li>
 *   <li>{@link Ardsl.impl.TriggerImpl#getPhysicChanges <em>Physic Changes</em>}</li>
 *   <li>{@link Ardsl.impl.TriggerImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggerImpl extends MinimalEObjectImpl.Container implements Trigger {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeTrigger() <em>Time Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeTrigger()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_TRIGGER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimeTrigger() <em>Time Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeTrigger()
	 * @generated
	 * @ordered
	 */
	protected int timeTrigger = TIME_TRIGGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getScoreChange() <em>Score Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreChange()
	 * @generated
	 * @ordered
	 */
	protected static final int SCORE_CHANGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScoreChange() <em>Score Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreChange()
	 * @generated
	 * @ordered
	 */
	protected int scoreChange = SCORE_CHANGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPhysicChanges() <em>Physic Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<PhysicChange> physicChanges;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final BasicActions ACTION_EDEFAULT = BasicActions.NONE;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected BasicActions action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.TRIGGER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.TRIGGER__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeTrigger() {
		return timeTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeTrigger(int newTimeTrigger) {
		int oldTimeTrigger = timeTrigger;
		timeTrigger = newTimeTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.TRIGGER__TIME_TRIGGER, oldTimeTrigger, timeTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScoreChange() {
		return scoreChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScoreChange(int newScoreChange) {
		int oldScoreChange = scoreChange;
		scoreChange = newScoreChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.TRIGGER__SCORE_CHANGE, oldScoreChange, scoreChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PhysicChange> getPhysicChanges() {
		if (physicChanges == null) {
			physicChanges = new EObjectContainmentEList<PhysicChange>(PhysicChange.class, this, ArdslPackage.TRIGGER__PHYSIC_CHANGES);
		}
		return physicChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicActions getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(BasicActions newAction) {
		BasicActions oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.TRIGGER__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArdslPackage.TRIGGER__PHYSIC_CHANGES:
				return ((InternalEList<?>)getPhysicChanges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArdslPackage.TRIGGER__NAME:
				return getName();
			case ArdslPackage.TRIGGER__MESSAGE:
				return getMessage();
			case ArdslPackage.TRIGGER__TIME_TRIGGER:
				return getTimeTrigger();
			case ArdslPackage.TRIGGER__SCORE_CHANGE:
				return getScoreChange();
			case ArdslPackage.TRIGGER__PHYSIC_CHANGES:
				return getPhysicChanges();
			case ArdslPackage.TRIGGER__ACTION:
				return getAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArdslPackage.TRIGGER__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.TRIGGER__MESSAGE:
				setMessage((String)newValue);
				return;
			case ArdslPackage.TRIGGER__TIME_TRIGGER:
				setTimeTrigger((Integer)newValue);
				return;
			case ArdslPackage.TRIGGER__SCORE_CHANGE:
				setScoreChange((Integer)newValue);
				return;
			case ArdslPackage.TRIGGER__PHYSIC_CHANGES:
				getPhysicChanges().clear();
				getPhysicChanges().addAll((Collection<? extends PhysicChange>)newValue);
				return;
			case ArdslPackage.TRIGGER__ACTION:
				setAction((BasicActions)newValue);
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
			case ArdslPackage.TRIGGER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.TRIGGER__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ArdslPackage.TRIGGER__TIME_TRIGGER:
				setTimeTrigger(TIME_TRIGGER_EDEFAULT);
				return;
			case ArdslPackage.TRIGGER__SCORE_CHANGE:
				setScoreChange(SCORE_CHANGE_EDEFAULT);
				return;
			case ArdslPackage.TRIGGER__PHYSIC_CHANGES:
				getPhysicChanges().clear();
				return;
			case ArdslPackage.TRIGGER__ACTION:
				setAction(ACTION_EDEFAULT);
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
			case ArdslPackage.TRIGGER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.TRIGGER__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ArdslPackage.TRIGGER__TIME_TRIGGER:
				return timeTrigger != TIME_TRIGGER_EDEFAULT;
			case ArdslPackage.TRIGGER__SCORE_CHANGE:
				return scoreChange != SCORE_CHANGE_EDEFAULT;
			case ArdslPackage.TRIGGER__PHYSIC_CHANGES:
				return physicChanges != null && !physicChanges.isEmpty();
			case ArdslPackage.TRIGGER__ACTION:
				return action != ACTION_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", timeTrigger: ");
		result.append(timeTrigger);
		result.append(", scoreChange: ");
		result.append(scoreChange);
		result.append(", action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //TriggerImpl
