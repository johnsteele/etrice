/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refined State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A refined state can be used only in a derived {@link ActorClass}.
 * It refers to a {@link State} in the inherited state machine
 * which is refined by adding detail code and/or
 * {@link StateGRaphItem}s in the sub state graph.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefinedState#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedState()
 * @model
 * @generated
 */
public interface RefinedState extends State
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the referenced state in the base class state machine.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(State)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedState_Target()
   * @model
   * @generated
   */
  State getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefinedState#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(State value);

} // RefinedState
