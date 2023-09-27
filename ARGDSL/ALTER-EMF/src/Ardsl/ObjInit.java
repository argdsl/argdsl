/**
 */
package Ardsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Obj Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.ObjInit#getName <em>Name</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getPosX <em>Pos X</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getPosY <em>Pos Y</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getPosZ <em>Pos Z</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getClass_ <em>Class</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getRules <em>Rules</em>}</li>
 *   <li>{@link Ardsl.ObjInit#getRotation <em>Rotation</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getObjInit()
 * @model
 * @generated
 */
public interface ObjInit extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Ardsl.ArdslPackage#getObjInit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pos X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos X</em>' attribute.
	 * @see #setPosX(double)
	 * @see Ardsl.ArdslPackage#getObjInit_PosX()
	 * @model required="true"
	 * @generated
	 */
	double getPosX();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getPosX <em>Pos X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos X</em>' attribute.
	 * @see #getPosX()
	 * @generated
	 */
	void setPosX(double value);

	/**
	 * Returns the value of the '<em><b>Pos Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Y</em>' attribute.
	 * @see #setPosY(double)
	 * @see Ardsl.ArdslPackage#getObjInit_PosY()
	 * @model required="true"
	 * @generated
	 */
	double getPosY();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getPosY <em>Pos Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos Y</em>' attribute.
	 * @see #getPosY()
	 * @generated
	 */
	void setPosY(double value);

	/**
	 * Returns the value of the '<em><b>Pos Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Z</em>' attribute.
	 * @see #setPosZ(double)
	 * @see Ardsl.ArdslPackage#getObjInit_PosZ()
	 * @model required="true"
	 * @generated
	 */
	double getPosZ();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getPosZ <em>Pos Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos Z</em>' attribute.
	 * @see #getPosZ()
	 * @generated
	 */
	void setPosZ(double value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(Ardsl.Class)
	 * @see Ardsl.ArdslPackage#getObjInit_Class()
	 * @model required="true"
	 * @generated
	 */
	Ardsl.Class getClass_();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(Ardsl.Class value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.ObjAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getObjInit_Attribute()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjAttribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link Ardsl.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see Ardsl.ArdslPackage#getObjInit_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(int)
	 * @see Ardsl.ArdslPackage#getObjInit_Rotation()
	 * @model
	 * @generated
	 */
	int getRotation();

	/**
	 * Sets the value of the '{@link Ardsl.ObjInit#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(int value);

} // ObjInit
