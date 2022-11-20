package com.huahai.wanxiang.dao.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.Date;
import java.util.List;

public class WanXiangPlugin extends PluginAdapter {

    public WanXiangPlugin() {
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addAnnotation("@Mapper");
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
        Date date = new Date();
        interfaze.addJavaDocLine("/**\n * @author haofuwei\n * @date " + date + "\n */");
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Date date = new Date();
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        topLevelClass.addJavaDocLine("/**\n * query for table " + tableName + "\n * @author haofuwei\n * @date " + date + "\n */");
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Date date = new Date();
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        topLevelClass.addJavaDocLine("/**\n * query for table " + tableName + "\n * @author haofuwei\n * @date " + date + "\n */");
        return true;
    }
}
