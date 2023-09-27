/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Game;
import Ardsl.Graphic;
import Ardsl.Ontological;
import Ardsl.Physic;

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
 * An implementation of the model object '<em><b>Ontological</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.OntologicalImpl#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.impl.OntologicalImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link Ardsl.impl.OntologicalImpl#getGraphic <em>Graphic</em>}</li>
 *   <li>{@link Ardsl.impl.OntologicalImpl#getPhysic <em>Physic</em>}</li>
 *   <li>{@link Ardsl.impl.OntologicalImpl#getGame <em>Game</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OntologicalImpl extends MinimalEObjectImpl.Container implements Ontological {
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
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<Ardsl.Class> classes;

	/**
	 * The cached value of the '{@link #getGraphic() <em>Graphic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphic()
	 * @generated
	 * @ordered
	 */
	protected Graphic graphic;

	/**
	 * The cached value of the '{@link #getPhysic() <em>Physic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysic()
	 * @generated
	 * @ordered
	 */
	protected Physic physic;

	/**
	 * The cached value of the '{@link #getGame() <em>Game</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGame()
	 * @generated
	 * @ordered
	 */
	protected Game game;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OntologicalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.ONTOLOGICAL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ardsl.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<Ardsl.Class>(Ardsl.Class.class, this, ArdslPackage.ONTOLOGICAL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graphic getGraphic() {
		return graphic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphic(Graphic newGraphic, NotificationChain msgs) {
		Graphic oldGraphic = graphic;
		graphic = newGraphic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__GRAPHIC, oldGraphic, newGraphic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphic(Graphic newGraphic) {
		if (newGraphic != graphic) {
			NotificationChain msgs = null;
			if (graphic != null)
				msgs = ((InternalEObject)graphic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__GRAPHIC, null, msgs);
			if (newGraphic != null)
				msgs = ((InternalEObject)newGraphic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__GRAPHIC, null, msgs);
			msgs = basicSetGraphic(newGraphic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__GRAPHIC, newGraphic, newGraphic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Physic getPhysic() {
		return physic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPhysic(Physic newPhysic, NotificationChain msgs) {
		Physic oldPhysic = physic;
		physic = newPhysic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__PHYSIC, oldPhysic, newPhysic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysic(Physic newPhysic) {
		if (newPhysic != physic) {
			NotificationChain msgs = null;
			if (physic != null)
				msgs = ((InternalEObject)physic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__PHYSIC, null, msgs);
			if (newPhysic != null)
				msgs = ((InternalEObject)newPhysic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__PHYSIC, null, msgs);
			msgs = basicSetPhysic(newPhysic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__PHYSIC, newPhysic, newPhysic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGame(Game newGame, NotificationChain msgs) {
		Game oldGame = game;
		game = newGame;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__GAME, oldGame, newGame);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGame(Game newGame) {
		if (newGame != game) {
			NotificationChain msgs = null;
			if (game != null)
				msgs = ((InternalEObject)game).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__GAME, null, msgs);
			if (newGame != null)
				msgs = ((InternalEObject)newGame).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.ONTOLOGICAL__GAME, null, msgs);
			msgs = basicSetGame(newGame, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.ONTOLOGICAL__GAME, newGame, newGame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArdslPackage.ONTOLOGICAL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ArdslPackage.ONTOLOGICAL__GRAPHIC:
				return basicSetGraphic(null, msgs);
			case ArdslPackage.ONTOLOGICAL__PHYSIC:
				return basicSetPhysic(null, msgs);
			case ArdslPackage.ONTOLOGICAL__GAME:
				return basicSetGame(null, msgs);
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
			case ArdslPackage.ONTOLOGICAL__NAME:
				return getName();
			case ArdslPackage.ONTOLOGICAL__CLASSES:
				return getClasses();
			case ArdslPackage.ONTOLOGICAL__GRAPHIC:
				return getGraphic();
			case ArdslPackage.ONTOLOGICAL__PHYSIC:
				return getPhysic();
			case ArdslPackage.ONTOLOGICAL__GAME:
				return getGame();
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
			case ArdslPackage.ONTOLOGICAL__NAME:
				setName((String)newValue);
				return;
			case ArdslPackage.ONTOLOGICAL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends Ardsl.Class>)newValue);
				return;
			case ArdslPackage.ONTOLOGICAL__GRAPHIC:
				setGraphic((Graphic)newValue);
				return;
			case ArdslPackage.ONTOLOGICAL__PHYSIC:
				setPhysic((Physic)newValue);
				return;
			case ArdslPackage.ONTOLOGICAL__GAME:
				setGame((Game)newValue);
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
			case ArdslPackage.ONTOLOGICAL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArdslPackage.ONTOLOGICAL__CLASSES:
				getClasses().clear();
				return;
			case ArdslPackage.ONTOLOGICAL__GRAPHIC:
				setGraphic((Graphic)null);
				return;
			case ArdslPackage.ONTOLOGICAL__PHYSIC:
				setPhysic((Physic)null);
				return;
			case ArdslPackage.ONTOLOGICAL__GAME:
				setGame((Game)null);
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
			case ArdslPackage.ONTOLOGICAL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArdslPackage.ONTOLOGICAL__CLASSES:
				return classes != null && !classes.isEmpty();
			case ArdslPackage.ONTOLOGICAL__GRAPHIC:
				return graphic != null;
			case ArdslPackage.ONTOLOGICAL__PHYSIC:
				return physic != null;
			case ArdslPackage.ONTOLOGICAL__GAME:
				return game != null;
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
		result.append(')');
		return result.toString();
	}

} //OntologicalImpl
