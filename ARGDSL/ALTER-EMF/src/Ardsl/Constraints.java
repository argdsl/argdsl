/**
 */
package Ardsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraints</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Ardsl.Constraints#getPlanes <em>Planes</em>}</li>
 *   <li>{@link Ardsl.Constraints#getIlumination <em>Ilumination</em>}</li>
 *   <li>{@link Ardsl.Constraints#getSizeMin <em>Size Min</em>}</li>
 *   <li>{@link Ardsl.Constraints#getSizeMax <em>Size Max</em>}</li>
 *   <li>{@link Ardsl.Constraints#getSizeInit <em>Size Init</em>}</li>
 *   <li>{@link Ardsl.Constraints#isOverlapping <em>Overlapping</em>}</li>
 *   <li>{@link Ardsl.Constraints#getXToOriginPos <em>XTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.Constraints#getYToOriginPos <em>YTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.Constraints#getZToOriginPos <em>ZTo Origin Pos</em>}</li>
 *   <li>{@link Ardsl.Constraints#getRotation <em>Rotation</em>}</li>
 *   <li>{@link Ardsl.Constraints#getText <em>Text</em>}</li>
 *   <li>{@link Ardsl.Constraints#getTextColor <em>Text Color</em>}</li>
 * </ul>
 *
 * @see Ardsl.ArdslPackage#getConstraints()
 * @model
 * @generated
 */
public interface Constraints extends EObject {
	/**
	 * Returns the value of the '<em><b>Planes</b></em>' attribute.
	 * The literals are from the enumeration {@link Ardsl.Planes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planes</em>' attribute.
	 * @see Ardsl.Planes
	 * @see #setPlanes(Planes)
	 * @see Ardsl.ArdslPackage#getConstraints_Planes()
	 * @model required="true"
	 * @generated
	 */
	Planes getPlanes();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getPlanes <em>Planes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planes</em>' attribute.
	 * @see Ardsl.Planes
	 * @see #getPlanes()
	 * @generated
	 */
	void setPlanes(Planes value);

	/**
	 * Returns the value of the '<em><b>Ilumination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ilumination</em>' attribute.
	 * @see #setIlumination(String)
	 * @see Ardsl.ArdslPackage#getConstraints_Ilumination()
	 * @model
	 * @generated
	 */
	String getIlumination();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getIlumination <em>Ilumination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ilumination</em>' attribute.
	 * @see #getIlumination()
	 * @generated
	 */
	void setIlumination(String value);

	/**
	 * Returns the value of the '<em><b>Size Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Min</em>' attribute.
	 * @see #setSizeMin(double)
	 * @see Ardsl.ArdslPackage#getConstraints_SizeMin()
	 * @model required="true"
	 * @generated
	 */
	double getSizeMin();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getSizeMin <em>Size Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Min</em>' attribute.
	 * @see #getSizeMin()
	 * @generated
	 */
	void setSizeMin(double value);

	/**
	 * Returns the value of the '<em><b>Size Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Max</em>' attribute.
	 * @see #setSizeMax(double)
	 * @see Ardsl.ArdslPackage#getConstraints_SizeMax()
	 * @model required="true"
	 * @generated
	 */
	double getSizeMax();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getSizeMax <em>Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Max</em>' attribute.
	 * @see #getSizeMax()
	 * @generated
	 */
	void setSizeMax(double value);

	/**
	 * Returns the value of the '<em><b>Size Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Init</em>' attribute.
	 * @see #setSizeInit(double)
	 * @see Ardsl.ArdslPackage#getConstraints_SizeInit()
	 * @model
	 * @generated
	 */
	double getSizeInit();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getSizeInit <em>Size Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Init</em>' attribute.
	 * @see #getSizeInit()
	 * @generated
	 */
	void setSizeInit(double value);

	/**
	 * Returns the value of the '<em><b>Overlapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overlapping</em>' attribute.
	 * @see #setOverlapping(boolean)
	 * @see Ardsl.ArdslPackage#getConstraints_Overlapping()
	 * @model required="true"
	 * @generated
	 */
	boolean isOverlapping();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#isOverlapping <em>Overlapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overlapping</em>' attribute.
	 * @see #isOverlapping()
	 * @generated
	 */
	void setOverlapping(boolean value);

	/**
	 * Returns the value of the '<em><b>XTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XTo Origin Pos</em>' attribute.
	 * @see #setXToOriginPos(double)
	 * @see Ardsl.ArdslPackage#getConstraints_XToOriginPos()
	 * @model required="true"
	 * @generated
	 */
	double getXToOriginPos();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getXToOriginPos <em>XTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XTo Origin Pos</em>' attribute.
	 * @see #getXToOriginPos()
	 * @generated
	 */
	void setXToOriginPos(double value);

	/**
	 * Returns the value of the '<em><b>YTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YTo Origin Pos</em>' attribute.
	 * @see #setYToOriginPos(double)
	 * @see Ardsl.ArdslPackage#getConstraints_YToOriginPos()
	 * @model required="true"
	 * @generated
	 */
	double getYToOriginPos();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getYToOriginPos <em>YTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YTo Origin Pos</em>' attribute.
	 * @see #getYToOriginPos()
	 * @generated
	 */
	void setYToOriginPos(double value);

	/**
	 * Returns the value of the '<em><b>ZTo Origin Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZTo Origin Pos</em>' attribute.
	 * @see #setZToOriginPos(double)
	 * @see Ardsl.ArdslPackage#getConstraints_ZToOriginPos()
	 * @model required="true"
	 * @generated
	 */
	double getZToOriginPos();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getZToOriginPos <em>ZTo Origin Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZTo Origin Pos</em>' attribute.
	 * @see #getZToOriginPos()
	 * @generated
	 */
	void setZToOriginPos(double value);

	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(int)
	 * @see Ardsl.ArdslPackage#getConstraints_Rotation()
	 * @model required="true"
	 * @generated
	 */
	int getRotation();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see Ardsl.ArdslPackage#getConstraints_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Color</em>' attribute.
	 * @see #setTextColor(String)
	 * @see Ardsl.ArdslPackage#getConstraints_TextColor()
	 * @model
	 * @generated
	 */
	String getTextColor();

	/**
	 * Sets the value of the '{@link Ardsl.Constraints#getTextColor <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Color</em>' attribute.
	 * @see #getTextColor()
	 * @generated
	 */
	void setTextColor(String value);

} // Constraints
