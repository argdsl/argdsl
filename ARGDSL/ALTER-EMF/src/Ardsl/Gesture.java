/**
 */
package Ardsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Gesture</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see Ardsl.ArdslPackage#getGesture()
 * @model
 * @generated
 */
public enum Gesture implements Enumerator {
	/**
	 * The '<em><b>Touch</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOUCH_VALUE
	 * @generated
	 * @ordered
	 */
	TOUCH(0, "touch", "touch"),

	/**
	 * The '<em><b>Drag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAG_VALUE
	 * @generated
	 * @ordered
	 */
	DRAG(1, "drag", "drag"),

	/**
	 * The '<em><b>Tilt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILT_VALUE
	 * @generated
	 * @ordered
	 */
	TILT(2, "tilt", "tilt");

	/**
	 * The '<em><b>Touch</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOUCH
	 * @model name="touch"
	 * @generated
	 * @ordered
	 */
	public static final int TOUCH_VALUE = 0;

	/**
	 * The '<em><b>Drag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAG
	 * @model name="drag"
	 * @generated
	 * @ordered
	 */
	public static final int DRAG_VALUE = 1;

	/**
	 * The '<em><b>Tilt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILT
	 * @model name="tilt"
	 * @generated
	 * @ordered
	 */
	public static final int TILT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Gesture</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Gesture[] VALUES_ARRAY =
		new Gesture[] {
			TOUCH,
			DRAG,
			TILT,
		};

	/**
	 * A public read-only list of all the '<em><b>Gesture</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Gesture> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gesture</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Gesture get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Gesture result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gesture</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Gesture getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Gesture result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gesture</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Gesture get(int value) {
		switch (value) {
			case TOUCH_VALUE: return TOUCH;
			case DRAG_VALUE: return DRAG;
			case TILT_VALUE: return TILT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Gesture(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Gesture
