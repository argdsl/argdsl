/**
 */
package Ardsl.impl;

import Ardsl.ArdslPackage;
import Ardsl.Connection;
import Ardsl.Constraints;
import Ardsl.GraphicClass;
import Ardsl.Versions;

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
 * An implementation of the model object '<em><b>Graphic Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.impl.GraphicClassImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link Ardsl.impl.GraphicClassImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link Ardsl.impl.GraphicClassImpl#getOntoClass <em>Onto Class</em>}</li>
 *   <li>{@link Ardsl.impl.GraphicClassImpl#getVersions <em>Versions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicClassImpl extends MinimalEObjectImpl.Container implements GraphicClass {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected Constraints constraints;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * The cached value of the '{@link #getOntoClass() <em>Onto Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntoClass()
	 * @generated
	 * @ordered
	 */
	protected Ardsl.Class ontoClass;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Versions> versions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArdslPackage.Literals.GRAPHIC_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraints getConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraints(Constraints newConstraints, NotificationChain msgs) {
		Constraints oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS, oldConstraints, newConstraints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraints(Constraints newConstraints) {
		if (newConstraints != constraints) {
			NotificationChain msgs = null;
			if (constraints != null)
				msgs = ((InternalEObject)constraints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS, null, msgs);
			if (newConstraints != null)
				msgs = ((InternalEObject)newConstraints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS, null, msgs);
			msgs = basicSetConstraints(newConstraints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS, newConstraints, newConstraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList<Connection>(Connection.class, this, ArdslPackage.GRAPHIC_CLASS__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class getOntoClass() {
		if (ontoClass != null && ontoClass.eIsProxy()) {
			InternalEObject oldOntoClass = (InternalEObject)ontoClass;
			ontoClass = (Ardsl.Class)eResolveProxy(oldOntoClass);
			if (ontoClass != oldOntoClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS, oldOntoClass, ontoClass));
			}
		}
		return ontoClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ardsl.Class basicGetOntoClass() {
		return ontoClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOntoClass(Ardsl.Class newOntoClass) {
		Ardsl.Class oldOntoClass = ontoClass;
		ontoClass = newOntoClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS, oldOntoClass, ontoClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Versions> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList<Versions>(Versions.class, this, ArdslPackage.GRAPHIC_CLASS__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS:
				return basicSetConstraints(null, msgs);
			case ArdslPackage.GRAPHIC_CLASS__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
			case ArdslPackage.GRAPHIC_CLASS__VERSIONS:
				return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
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
			case ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS:
				return getConstraints();
			case ArdslPackage.GRAPHIC_CLASS__CONNECTIONS:
				return getConnections();
			case ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS:
				if (resolve) return getOntoClass();
				return basicGetOntoClass();
			case ArdslPackage.GRAPHIC_CLASS__VERSIONS:
				return getVersions();
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
			case ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS:
				setConstraints((Constraints)newValue);
				return;
			case ArdslPackage.GRAPHIC_CLASS__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS:
				setOntoClass((Ardsl.Class)newValue);
				return;
			case ArdslPackage.GRAPHIC_CLASS__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends Versions>)newValue);
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
			case ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS:
				setConstraints((Constraints)null);
				return;
			case ArdslPackage.GRAPHIC_CLASS__CONNECTIONS:
				getConnections().clear();
				return;
			case ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS:
				setOntoClass((Ardsl.Class)null);
				return;
			case ArdslPackage.GRAPHIC_CLASS__VERSIONS:
				getVersions().clear();
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
			case ArdslPackage.GRAPHIC_CLASS__CONSTRAINTS:
				return constraints != null;
			case ArdslPackage.GRAPHIC_CLASS__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case ArdslPackage.GRAPHIC_CLASS__ONTO_CLASS:
				return ontoClass != null;
			case ArdslPackage.GRAPHIC_CLASS__VERSIONS:
				return versions != null && !versions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphicClassImpl
