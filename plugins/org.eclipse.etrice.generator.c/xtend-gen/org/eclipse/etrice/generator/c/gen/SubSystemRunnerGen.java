/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class SubSystemRunnerGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance sc : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = sc.getSubSystemClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = sc.getSubSystemClass();
        String _path = this.roomExt.getPath(_subSystemClass_1);
        String _plus = (_generationTargetPath + _path);
        this.fileAccess.setOutputPath(_plus);
        SubSystemClass _subSystemClass_2 = sc.getSubSystemClass();
        String _name = _subSystemClass_2.getName();
        String _plus_1 = (_name + "_Runner.c");
        CharSequence _generateSourceFile = this.generateSourceFile(root, sc);
        this.fileAccess.generateFile(_plus_1, _generateSourceFile);
      }
    }
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance ssi) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass ssc = ssi.getSubSystemClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* this class contains the main function running component ");
      String _name = ssi.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* it instantiates ");
      String _name_1 = ssi.getName();
      _builder.append(_name_1, " ");
      _builder.append(" and starts and ends the lifecycle");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _name_2 = ssc.getName();
      _builder.append(_name_2, "");
      _builder.append(".h\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"debugging/etLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etMSCLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"platform/etPlatform.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* main function");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* creates component and starts and stops the lifecycle");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("int main(void) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserEntry(); /* platform specific */");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etLogger_logInfo(\"***   T H E   B E G I N   ***\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_OPEN(\"main\");");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* startup sequence  of lifecycle */");
      _builder.newLine();
      _builder.append("\t");
      String _name_3 = ssc.getName();
      _builder.append(_name_3, "	");
      _builder.append("_init(); \t\t/* lifecycle init */");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _name_4 = ssc.getName();
      _builder.append(_name_4, "	");
      _builder.append("_start(); \t/* lifecycle start */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserPreRun(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* run Scheduler */");
      _builder.newLine();
      _builder.append("\t");
      String _name_5 = ssc.getName();
      _builder.append(_name_5, "	");
      _builder.append("_run();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserPostRun(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* shutdown sequence of lifecycle */");
      _builder.newLine();
      _builder.append("\t");
      String _name_6 = ssc.getName();
      _builder.append(_name_6, "	");
      _builder.append("_stop(); \t\t/* lifecycle stop */");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _name_7 = ssc.getName();
      _builder.append(_name_7, "	");
      _builder.append("_destroy(); \t/* lifecycle destroy */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_CLOSE");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etLogger_logInfo(\"***   T H E   E N D   ***\");");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserExit(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 0;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
