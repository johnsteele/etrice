/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorRefImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorRefImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorRefImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorRefImpl extends ActorContainerRefImpl implements ActorRef
{
  /**
   * The default value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected static final ReferenceType REF_TYPE_EDEFAULT = ReferenceType.FIXED;

  /**
   * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected ReferenceType refType = REF_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected static final int MULTIPLICITY_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected int multiplicity = MULTIPLICITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ActorClass type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorRefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RoomPackage.Literals.ACTOR_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceType getRefType()
  {
    return refType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefType(ReferenceType newRefType)
  {
    ReferenceType oldRefType = refType;
    refType = newRefType == null ? REF_TYPE_EDEFAULT : newRefType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_REF__REF_TYPE, oldRefType, refType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(int newMultiplicity)
  {
    int oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_REF__MULTIPLICITY, oldMultiplicity, multiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (ActorClass)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.ACTOR_REF__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(ActorClass newType)
  {
    ActorClass oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_REF__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_REF__REF_TYPE:
        return getRefType();
      case RoomPackage.ACTOR_REF__MULTIPLICITY:
        return getMultiplicity();
      case RoomPackage.ACTOR_REF__TYPE:
        if (resolve) return getType();
        return basicGetType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_REF__REF_TYPE:
        setRefType((ReferenceType)newValue);
        return;
      case RoomPackage.ACTOR_REF__MULTIPLICITY:
        setMultiplicity((Integer)newValue);
        return;
      case RoomPackage.ACTOR_REF__TYPE:
        setType((ActorClass)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_REF__REF_TYPE:
        setRefType(REF_TYPE_EDEFAULT);
        return;
      case RoomPackage.ACTOR_REF__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case RoomPackage.ACTOR_REF__TYPE:
        setType((ActorClass)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_REF__REF_TYPE:
        return refType != REF_TYPE_EDEFAULT;
      case RoomPackage.ACTOR_REF__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case RoomPackage.ACTOR_REF__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (refType: ");
    result.append(refType);
    result.append(", multiplicity: ");
    result.append(multiplicity);
    result.append(')');
    return result.toString();
  }

} //ActorRefImpl
