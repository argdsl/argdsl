/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Force</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Force#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.Force#getGesture <em>Gesture</em>}</li>
 *   <li>{@link Ardsl.Force#getXVector <em>XVector</em>}</li>
 *   <li>{@link Ardsl.Force#getYVector <em>YVector</em>}</li>
 *   <li>{@link Ardsl.Force#getZVector <em>ZVector</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getForce()
 * @model
 * @generated
 */
public interface Force extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getForce_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.Force#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Gesture</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.Gesture}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gesture</em>' attribute.
	 * @see Ardsl.Gesture
	 * @see #setGesture(Gesture)
	 * @see Ardsl.ArdslPackage#getForce_Gesture()
	 * @model required="true"
	 * @generated
	 */
	Gesture getGesture();

	/**
	 * Sets the value of the '{@link Ardsl.Force#getGesture <em>Gesture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gesture</em>' attribute.
	 * @see Ardsl.Gesture
	 * @see #getGesture()
	 * @generated
	 */
	void setGesture(Gesture value);

	/**
	 * Returns the value of the '<em><b>XVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XVector</em>' attribute.
	 * @see #setXVector(double)
	 * @see Ardsl.ArdslPackage#getForce_XVector()
	 * @model
	 * @generated
	 */
	double getXVector();

	/**
	 * Sets the value of the '{@link Ardsl.Force#getXVector <em>XVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XVector</em>' attribute.
	 * @see #getXVector()
	 * @generated
	 */
	void setXVector(double value);

	/**
	 * Returns the value of the '<em><b>YVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YVector</em>' attribute.
	 * @see #setYVector(double)
	 * @see Ardsl.ArdslPackage#getForce_YVector()
	 * @model
	 * @generated
	 */
	double getYVector();

	/**
	 * Sets the value of the '{@link Ardsl.Force#getYVector <em>YVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YVector</em>' attribute.
	 * @see #getYVector()
	 * @generated
	 */
	void setYVector(double value);

	/**
	 * Returns the value of the '<em><b>ZVector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZVector</em>' attribute.
	 * @see #setZVector(double)
	 * @see Ardsl.ArdslPackage#getForce_ZVector()
	 * @model
	 * @generated
	 */
	double getZVector();

	/**
	 * Sets the value of the '{@link Ardsl.Force#getZVector <em>ZVector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZVector</em>' attribute.
	 * @see #getZVector()
	 * @generated
	 */
	void setZVector(double value);

} // Force
