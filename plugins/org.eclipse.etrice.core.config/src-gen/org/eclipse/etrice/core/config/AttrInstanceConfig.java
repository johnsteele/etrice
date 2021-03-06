/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Instance Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.Attribute attribute}.
 * The configuration defines values for this attribute instance and overrides the default values from the corresponding class config.
 * The values are applied at generation time.
 * <br>If the type of the given {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is
 * <ul>
 * 	<li>primitive, then a {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} might exist and {@link #getAttributes attributes} is empty</li>
 * 	<li>compound attribute (e.g. {@link org.eclipse.etrice.core.room.DataClass data class}), then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is null and configurations for children {@link #getAttributes attributes} might exist</li>
 * </ul>				
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig <em>Dyn Config</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig()
 * @model
 * @generated
 */
public interface AttrInstanceConfig extends AttrConfig
{
  /**
   * Returns the value of the '<em><b>Dyn Config</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>If the dynamic configuration options is activated for this attribute, then the values are set at runtime by the means of the {@link DynamicConfig dynamic config}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Dyn Config</em>' attribute.
   * @see #setDynConfig(boolean)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_DynConfig()
   * @model
   * @generated
   */
  boolean isDynConfig();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig <em>Dyn Config</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dyn Config</em>' attribute.
   * @see #isDynConfig()
   * @generated
   */
  void setDynConfig(boolean value);

  /**
   * Returns the value of the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Controls the behavior of the dynamic configuration. If set to false, then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is updated (overwritten) if changes occur in the external configuration, 
   * otherwise set to true, then changes in {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} (that occur from within the system) are recorded to the external configuration.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Read Only</em>' attribute.
   * @see #setReadOnly(boolean)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_ReadOnly()
   * @model
   * @generated
   */
  boolean isReadOnly();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Read Only</em>' attribute.
   * @see #isReadOnly()
   * @generated
   */
  void setReadOnly(boolean value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrInstanceConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of attribute configurations of children attributes, in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is compound.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrInstanceConfig> getAttributes();

} // AttrInstanceConfig
