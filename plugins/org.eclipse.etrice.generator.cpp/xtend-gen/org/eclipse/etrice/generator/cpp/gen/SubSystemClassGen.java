/**
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.cpp.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Peter Karlitschek
 */
@Singleton
@SuppressWarnings("all")
public class SubSystemClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ConfigGenAddon configGenAddon;
  
  @Inject
  private ConfigGenAddon configAddon;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance ssi : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
        String _path = this._roomExtensions.getPath(_subSystemClass_1);
        String path = (_generationTargetPath + _path);
        SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
        String file = this._cppExtensions.getCppHeaderFileName(_subSystemClass_2);
        String _plus = ("generating SubSystemClass declaration: \'" + file);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, ssi, _subSystemClass_3);
        this.fileAccess.generateFile(file, _generateHeaderFile);
        SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
        String _cppSourceFileName = this._cppExtensions.getCppSourceFileName(_subSystemClass_4);
        file = _cppSourceFileName;
        String _plus_4 = ("generating SubSystemClass implementation: \'" + file);
        String _plus_5 = (_plus_4 + "\' in \'");
        String _plus_6 = (_plus_5 + path);
        String _plus_7 = (_plus_6 + "\'");
        this.logger.logInfo(_plus_7);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_5 = ssi.getSubSystemClass();
        CharSequence _generateSourceFile = this.generateSourceFile(root, ssi, _subSystemClass_5);
        this.fileAccess.generateFile(file, _generateSourceFile);
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Header File of SubSystemClass ");
    String _name = cc.getName();
    _builder.append(_name, "	 ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    String _name_1 = cc.getName();
    CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(_name_1);
    _builder.append(_generateIncludeGuardBegin, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"platforms/generic/etDatatypes.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/IRTObject.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/PortBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/ActorClassBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/SubSystemClassBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/Address.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/IMessageReceiver.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/debugging/DebuggingService.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include <string>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include <vector>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<RoomModel> _referencedModels = root.getReferencedModels(cc);
      for(final RoomModel model : _referencedModels) {
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _userCode = this._procedureHelpers.userCode(cc, 1, false);
    _builder.append(_userCode, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class ");
    String _name_2 = cc.getName();
    _builder.append(_name_2, "	");
    _builder.append(" : public etRuntime::SubSystemClassBase{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _userCode_1 = this._procedureHelpers.userCode(cc, 2, false);
    _builder.append(_userCode_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _name_3 = cc.getName();
    _builder.append(_name_3, "			");
    _builder.append("(IRTObject* parent, std::string name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append(": etRuntime::SubSystemClassBase(parent, name)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("virtual void instantiateMessageServices();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("virtual void instantiateActors();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("std::vector<etRuntime::MessageService*> m_msgServices;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _name_4 = cc.getName();
    CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(_name_4);
    _builder.append(_generateIncludeGuardEnd, "	");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Source File of SubsystemClass ");
    String _name = cc.getName();
    _builder.append(_name, "	 ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"");
    String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(cc);
    _builder.append(_cppHeaderFileName, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#include \"common/debugging/DebuggingService.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/RTSystemServicesProtocol.h\"");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
      for(final ActorInstance ai : _allContainedInstances) {
        _builder.append("\t");
        _builder.append("#include \"");
        ActorClass _actorClass = ai.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass);
        _builder.append(_path, "	");
        ActorClass _actorClass_1 = ai.getActorClass();
        String _name_1 = _actorClass_1.getName();
        _builder.append(_name_1, "	");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("#include <iostream>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("using namespace etRuntime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void ");
    String _name_2 = cc.getName();
    _builder.append(_name_2, "	");
    _builder.append("::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void ");
    String _name_3 = cc.getName();
    _builder.append(_name_3, "	");
    _builder.append("::instantiateMessageServices(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m_msgServices.push_back( new MessageService(this, Address(0, 0, 0),\"MessageService_Main\") );");
    _builder.newLine();
    {
      EList<LogicalThread> _threads = cc.getThreads();
      for(final LogicalThread thread : _threads) {
        _builder.append("\t\t");
        _builder.append("m_msgServices.push_back(new MessageService(this, Address(0, ");
        EList<LogicalThread> _threads_1 = cc.getThreads();
        int _indexOf = _threads_1.indexOf(thread);
        int _plus = (_indexOf + 1);
        _builder.append(_plus, "		");
        _builder.append(", 0),\"MessageService_");
        String _name_4 = thread.getName();
        _builder.append(_name_4, "		");
        _builder.append("\", /* threadprio */ 0));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("for (std::vector<MessageService*>::iterator it=m_msgServices.begin(); it != m_msgServices.end(); ++it) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("RTServices::getInstance().getMsgSvcCtrl().addMsgSvc( *(*it));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void ");
    String _name_5 = cc.getName();
    _builder.append(_name_5, "	");
    _builder.append("::instantiateActors(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("// all addresses");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Addresses for the Subsystem Systemport");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_1 = comp.getAllContainedInstances();
      int _maxObjId = comp.getMaxObjId();
      Iterable<Indexed<ActorInstance>> _indexed = Indexed.<ActorInstance>indexed(_allContainedInstances_1, _maxObjId);
      for(final Indexed<ActorInstance> ai_1 : _indexed) {
        _builder.append("\t");
        _builder.append("Address addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_2 = comp.getAllContainedInstances();
        ActorInstance _value = ai_1.getValue();
        int _indexOf_1 = _allContainedInstances_2.indexOf(_value);
        _builder.append(_indexOf_1, "	");
        _builder.append("(0,0,");
        int _index1 = ai_1.getIndex1();
        _builder.append(_index1, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_3 = comp.getAllContainedInstances();
      for(final ActorInstance ai_2 : _allContainedInstances_3) {
        _builder.append("\t");
        _builder.append("// actor instance ");
        String _path_1 = ai_2.getPath();
        _builder.append(_path_1, "	");
        _builder.append(" itself => Systemport Address");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Address addr_item_");
        String _path_2 = ai_2.getPath();
        String _pathName = this._roomExtensions.getPathName(_path_2);
        _builder.append(_pathName, "	");
        _builder.append("(0,");
        int _threadId = ai_2.getThreadId();
        _builder.append(_threadId, "	");
        _builder.append(",");
        int _objId = ai_2.getObjId();
        _builder.append(_objId, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// interface items of ");
        String _path_3 = ai_2.getPath();
        _builder.append(_path_3, "	");
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances = ai_2.getOrderedIfItemInstances();
          for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
            {
              boolean _isReplicated = pi.isReplicated();
              if (_isReplicated) {
                {
                  EList<InterfaceItemInstance> _peers = pi.getPeers();
                  for(final InterfaceItemInstance peer : _peers) {
                    _builder.append("\t");
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    int i = _peers_1.indexOf(peer);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("Address addr_item_");
                    String _path_4 = pi.getPath();
                    String _pathName_1 = this._roomExtensions.getPathName(_path_4);
                    _builder.append(_pathName_1, "	");
                    _builder.append("_");
                    _builder.append(i, "	");
                    _builder.append("(0,");
                    int _threadId_1 = pi.getThreadId();
                    _builder.append(_threadId_1, "	");
                    _builder.append(",");
                    int _objId_1 = pi.getObjId();
                    int _plus_1 = (_objId_1 + i);
                    _builder.append(_plus_1, "	");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t");
                _builder.append("Address addr_item_");
                String _path_5 = pi.getPath();
                String _pathName_2 = this._roomExtensions.getPathName(_path_5);
                _builder.append(_pathName_2, "	");
                _builder.append("(0,");
                int _threadId_2 = ai_2.getThreadId();
                _builder.append(_threadId_2, "	");
                _builder.append(",");
                int _objId_2 = pi.getObjId();
                _builder.append(_objId_2, "	");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// instantiate all actor instances");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("m_instances.reserve(");
    EList<ActorInstance> _allContainedInstances_4 = comp.getAllContainedInstances();
    int _size = _allContainedInstances_4.size();
    _builder.append(_size, "	");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_5 = comp.getAllContainedInstances();
      for(final ActorInstance ai_3 : _allContainedInstances_5) {
        _builder.append("\t");
        _builder.append("//----------------------------------------------------------------------------------------------");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// addresses for actor instance: ");
        String _name_6 = ai_3.getName();
        _builder.append(_name_6, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//----------------------------------------------------------------------------------------------");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generateOwnInterfaceItemAddresses = this.generateOwnInterfaceItemAddresses(ai_3);
        _builder.append(_generateOwnInterfaceItemAddresses, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generatePeerInterfaceItemAddresses = this.generatePeerInterfaceItemAddresses(ai_3, comp);
        _builder.append(_generatePeerInterfaceItemAddresses, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("m_instances[");
        EList<ActorInstance> _allContainedInstances_6 = comp.getAllContainedInstances();
        int _indexOf_2 = _allContainedInstances_6.indexOf(ai_3);
        _builder.append(_indexOf_2, "	");
        _builder.append("] = new ");
        ActorClass _actorClass_2 = ai_3.getActorClass();
        String _name_7 = _actorClass_2.getName();
        _builder.append(_name_7, "	");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          EObject _eContainer = ai_3.eContainer();
          if ((_eContainer instanceof SubSystemInstance)) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this,");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("m_instances[");
            EList<ActorInstance> _allContainedInstances_7 = comp.getAllContainedInstances();
            EObject _eContainer_1 = ai_3.eContainer();
            int _indexOf_3 = _allContainedInstances_7.indexOf(_eContainer_1);
            _builder.append(_indexOf_3, "		");
            _builder.append("],");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("\"");
        String _name_8 = ai_3.getName();
        _builder.append(_name_8, "		");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _name_9 = ai_3.getName();
        _builder.append(_name_9, "		");
        _builder.append("_ownInterfaceItemAddresses,");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _name_10 = ai_3.getName();
        _builder.append(_name_10, "		");
        _builder.append("_peerInterfaceItemAddresses");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("); ");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// apply instance attribute configurations");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_8 = comp.getAllContainedInstances();
      for(final ActorInstance ai_4 : _allContainedInstances_8) {
        final CharSequence cfg = this.configGenAddon.genActorInstanceConfig(ai_4, "inst");
        _builder.newLineIfNotEmpty();
        {
          int _length = cfg.length();
          boolean _greaterThan = (_length > 0);
          if (_greaterThan) {
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            ActorClass _actorClass_3 = ai_4.getActorClass();
            String _name_11 = _actorClass_3.getName();
            _builder.append(_name_11, "	");
            _builder.append(" inst = (");
            ActorClass _actorClass_4 = ai_4.getActorClass();
            String _name_12 = _actorClass_4.getName();
            _builder.append(_name_12, "	");
            _builder.append(") instances[");
            EList<ActorInstance> _allContainedInstances_9 = comp.getAllContainedInstances();
            int _indexOf_4 = _allContainedInstances_9.indexOf(ai_4);
            _builder.append(_indexOf_4, "	");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(cfg, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//----------------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// addresses for the subsystem system port");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//----------------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("std::vector<Address> ownAddresses(");
    EList<ActorInstance> _allContainedInstances_10 = comp.getAllContainedInstances();
    int _size_1 = _allContainedInstances_10.size();
    _builder.append(_size_1, "	");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_11 = comp.getAllContainedInstances();
      for(final ActorInstance ai_5 : _allContainedInstances_11) {
        _builder.append("\t");
        _builder.append("ownAddresses[");
        EList<ActorInstance> _allContainedInstances_12 = comp.getAllContainedInstances();
        int _indexOf_5 = _allContainedInstances_12.indexOf(ai_5);
        _builder.append(_indexOf_5, "	");
        _builder.append("] = addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_13 = comp.getAllContainedInstances();
        int _indexOf_6 = _allContainedInstances_13.indexOf(ai_5);
        _builder.append(_indexOf_6, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("std::vector<Address> peerAddresses(");
    EList<ActorInstance> _allContainedInstances_14 = comp.getAllContainedInstances();
    int _size_2 = _allContainedInstances_14.size();
    _builder.append(_size_2, "	");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_15 = comp.getAllContainedInstances();
      for(final ActorInstance ai_6 : _allContainedInstances_15) {
        _builder.append("\t");
        _builder.append("peerAddresses[");
        EList<ActorInstance> _allContainedInstances_16 = comp.getAllContainedInstances();
        int _indexOf_7 = _allContainedInstances_16.indexOf(ai_6);
        _builder.append(_indexOf_7, "	");
        _builder.append("] = addr_item_");
        String _path_6 = ai_6.getPath();
        String _pathName_3 = this._roomExtensions.getPathName(_path_6);
        _builder.append(_pathName_3, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// create the subsystem system port\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("m_RTSystemPort = new RTSystemServicesProtocolConjPortRepl(*this, this, \"RTSystemPort\",");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("0, //local ID");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ownAddresses,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("peerAddresses);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateOwnInterfaceItemAddresses(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("std::vector<std::vector<Address> > ");
    String _name = ai.getName();
    _builder.append(_name, "");
    _builder.append("_ownInterfaceItemAddresses;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("std::vector<Address> ");
    String _name_1 = ai.getName();
    _builder.append(_name_1, "");
    _builder.append("_actorInstanceAddresses(1);");
    _builder.newLineIfNotEmpty();
    String _name_2 = ai.getName();
    _builder.append(_name_2, "");
    _builder.append("_actorInstanceAddresses[0] = addr_item_");
    String _path = ai.getPath();
    String _pathName = this._roomExtensions.getPathName(_path);
    _builder.append(_pathName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_3 = ai.getName();
    _builder.append(_name_3, "");
    _builder.append("_ownInterfaceItemAddresses.push_back(");
    String _name_4 = ai.getName();
    _builder.append(_name_4, "");
    _builder.append("_actorInstanceAddresses);");
    _builder.newLineIfNotEmpty();
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
        {
          boolean _isReplicated = pi.isReplicated();
          if (_isReplicated) {
            {
              EList<InterfaceItemInstance> _peers = pi.getPeers();
              boolean _isEmpty = _peers.isEmpty();
              if (_isEmpty) {
                _builder.append("std::vector<Address>  ");
                String _name_5 = ai.getName();
                _builder.append(_name_5, "");
                _builder.append("_");
                String _name_6 = pi.getName();
                _builder.append(_name_6, "");
                _builder.append("Addresses;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("std::vector<Address>  ");
                String _name_7 = ai.getName();
                _builder.append(_name_7, "");
                _builder.append("_");
                String _name_8 = pi.getName();
                _builder.append(_name_8, "");
                _builder.append("Addresses(");
                EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                int _size = _peers_1.size();
                _builder.append(_size, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
                  for(final InterfaceItemInstance peer : _peers_2) {
                    String _name_9 = ai.getName();
                    _builder.append(_name_9, "");
                    _builder.append("_");
                    String _name_10 = pi.getName();
                    _builder.append(_name_10, "");
                    _builder.append("Addresses[");
                    EList<InterfaceItemInstance> _peers_3 = pi.getPeers();
                    int _indexOf = _peers_3.indexOf(peer);
                    _builder.append(_indexOf, "");
                    _builder.append("] = addr_item_");
                    String _path_1 = pi.getPath();
                    String _pathName_1 = this._roomExtensions.getPathName(_path_1);
                    _builder.append(_pathName_1, "");
                    _builder.append("_");
                    EList<InterfaceItemInstance> _peers_4 = pi.getPeers();
                    int _indexOf_1 = _peers_4.indexOf(peer);
                    _builder.append(_indexOf_1, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          } else {
            _builder.append("std::vector<Address>  ");
            String _name_11 = ai.getName();
            _builder.append(_name_11, "");
            _builder.append("_");
            String _name_12 = pi.getName();
            _builder.append(_name_12, "");
            _builder.append("Addresses(1);");
            _builder.newLineIfNotEmpty();
            String _name_13 = ai.getName();
            _builder.append(_name_13, "");
            _builder.append("_");
            String _name_14 = pi.getName();
            _builder.append(_name_14, "");
            _builder.append("Addresses[0] = addr_item_");
            String _path_2 = pi.getPath();
            String _pathName_2 = this._roomExtensions.getPathName(_path_2);
            _builder.append(_pathName_2, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        String _name_15 = ai.getName();
        _builder.append(_name_15, "");
        _builder.append("_ownInterfaceItemAddresses.push_back(");
        String _name_16 = ai.getName();
        _builder.append(_name_16, "");
        _builder.append("_");
        String _name_17 = pi.getName();
        _builder.append(_name_17, "");
        _builder.append("Addresses);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence generatePeerInterfaceItemAddresses(final ActorInstance ai, final SubSystemInstance comp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("std::vector<std::vector<Address> > ");
    String _name = ai.getName();
    _builder.append(_name, "");
    _builder.append("_peerInterfaceItemAddresses;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("std::vector<Address> ");
    String _name_1 = ai.getName();
    _builder.append(_name_1, "");
    _builder.append("_systemPortAddresses(1);");
    _builder.newLineIfNotEmpty();
    String _name_2 = ai.getName();
    _builder.append(_name_2, "");
    _builder.append("_systemPortAddresses[0] = addr_item_SystemPort_");
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    int _indexOf = _allContainedInstances.indexOf(ai);
    _builder.append(_indexOf, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_3 = ai.getName();
    _builder.append(_name_3, "");
    _builder.append("_peerInterfaceItemAddresses.push_back(");
    String _name_4 = ai.getName();
    _builder.append(_name_4, "");
    _builder.append("_systemPortAddresses);");
    _builder.newLineIfNotEmpty();
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
        {
          boolean _and = false;
          boolean _isReplicated = pi.isReplicated();
          if (!_isReplicated) {
            _and = false;
          } else {
            EList<InterfaceItemInstance> _peers = pi.getPeers();
            boolean _isEmpty = _peers.isEmpty();
            _and = (_isReplicated && _isEmpty);
          }
          if (_and) {
          } else {
            {
              EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
              boolean _isEmpty_1 = _peers_1.isEmpty();
              if (_isEmpty_1) {
                _builder.append("std::vector<Address>  ");
                String _name_5 = ai.getName();
                _builder.append(_name_5, "");
                _builder.append("_");
                String _name_6 = pi.getName();
                _builder.append(_name_6, "");
                _builder.append("PeerAddresses;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("std::vector<Address>  ");
                String _name_7 = ai.getName();
                _builder.append(_name_7, "");
                _builder.append("_");
                String _name_8 = pi.getName();
                _builder.append(_name_8, "");
                _builder.append("PeerAddresses(");
                EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
                int _size = _peers_2.size();
                _builder.append(_size, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InterfaceItemInstance> _peers_3 = pi.getPeers();
                  for(final InterfaceItemInstance pp : _peers_3) {
                    {
                      boolean _isReplicated_1 = pp.isReplicated();
                      if (_isReplicated_1) {
                        String _name_9 = ai.getName();
                        _builder.append(_name_9, "");
                        _builder.append("_");
                        String _name_10 = pi.getName();
                        _builder.append(_name_10, "");
                        _builder.append("PeerAddresses[");
                        EList<InterfaceItemInstance> _peers_4 = pi.getPeers();
                        int _indexOf_1 = _peers_4.indexOf(pp);
                        _builder.append(_indexOf_1, "");
                        _builder.append("] = addr_item_");
                        String _path = pp.getPath();
                        String _pathName = this._roomExtensions.getPathName(_path);
                        _builder.append(_pathName, "");
                        _builder.append("_");
                        EList<InterfaceItemInstance> _peers_5 = pp.getPeers();
                        int _indexOf_2 = _peers_5.indexOf(pi);
                        _builder.append(_indexOf_2, "");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      } else {
                        String _name_11 = ai.getName();
                        _builder.append(_name_11, "");
                        _builder.append("_");
                        String _name_12 = pi.getName();
                        _builder.append(_name_12, "");
                        _builder.append("PeerAddresses[");
                        EList<InterfaceItemInstance> _peers_6 = pi.getPeers();
                        int _indexOf_3 = _peers_6.indexOf(pp);
                        _builder.append(_indexOf_3, "");
                        _builder.append("] = addr_item_");
                        String _path_1 = pp.getPath();
                        String _pathName_1 = this._roomExtensions.getPathName(_path_1);
                        _builder.append(_pathName_1, "");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            String _name_13 = ai.getName();
            _builder.append(_name_13, "");
            _builder.append("_peerInterfaceItemAddresses.push_back(");
            String _name_14 = ai.getName();
            _builder.append(_name_14, "");
            _builder.append("_");
            String _name_15 = pi.getName();
            _builder.append(_name_15, "");
            _builder.append("PeerAddresses);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
