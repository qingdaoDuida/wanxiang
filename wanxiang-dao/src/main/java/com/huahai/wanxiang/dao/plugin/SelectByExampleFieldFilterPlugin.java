package com.huahai.wanxiang.dao.plugin;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.*;

public class SelectByExampleFieldFilterPlugin extends PluginAdapter {
    private String securitySqlClass;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.securitySqlClass = properties.getProperty("securitySqlClass");
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        if (StringUtils.isBlank(securitySqlClass)) {
            return null;
        }
        List<GeneratedJavaFile> answer = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(securitySqlClass);
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(securitySqlClass);
        TopLevelClass topLevelClass = new TopLevelClass(type);
        topLevelClass.addJavaDocLine(PluginUtils.getJavaDocLine(type.getShortNameWithoutTypeArguments()));
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);

        StringBuilder column = new StringBuilder();
        column.append("if (slice == null) {").append("\n");
        column.append("            return null;").append("\n");
        column.append("        }").append("\n");
        column.append("        StringBuilder sb = new StringBuilder();").append("\n");
        column.append("        for (char c : slice.toCharArray()) {").append("\n");
        column.append("            if ((c >= 'a' && c <= 'z')) {").append("\n");
        column.append("                sb.append(c);").append("\n");
        column.append("            } else if ((c >= '0' && c <= '9')) {").append("\n");
        column.append("                sb.append(c);").append("\n");
        column.append("            } else if ((c >= 'A' && c <= 'Z')) {").append("\n");
        column.append("                sb.append(c);").append("\n");
        column.append("            } else if (c == '_' || c == '-' || c == '.' || c == ' ' || c == ',') {").append("\n");
        column.append("                sb.append(c);").append("\n");
        column.append("            } else if (c == '>' || c == '<' || c == '=' || c == '\\\"' || c == '\\'') {").append("\n");
        column.append("                sb.append(c);").append("\n");
        column.append("            }").append("\n");
        column.append("          }").append("\n");
        column.append("          return sb.toString();");

        Method method = new Method("trimSql");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setStatic(true);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "slice"));
        method.setReturnType(new FullyQualifiedJavaType("String"));
        method.addBodyLine(column.toString());
        topLevelClass.addMethod(method);
        CommentGenerator commentGenerator = context.getCommentGenerator();
        commentGenerator.addGeneralMethodComment(method, introspectedTable);

        GeneratedJavaFile gjf = new GeneratedJavaFile(topLevelClass,
                context.getJavaClientGeneratorConfiguration().getTargetProject(),
                context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING),
                context.getJavaFormatter());

        answer.add(gjf);
        return answer;
    }

    @Override
    public boolean validate(List<String> list) {
        return false;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            addFieldFiltersInExampleClass(topLevelClass, introspectedTable);
        }
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            addFieldFiltersInSqlMap(element, introspectedTable, false);
            replaceUnsafeSlice(element);
        }
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            addFieldFiltersInSqlMap(element, introspectedTable, false);
            replaceUnsafeSlice(element);
        }
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            addFieldFiltersInSqlMap(element, introspectedTable, true);
            replaceUnsafeSlice(element);
        }
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();
        List<Element> elementList = parentElement.getElements();
        int index = 0;
        for (Iterator<Element> iterator = elementList.iterator(); ; iterator.hasNext()) {
            Element item = iterator.next();
            if (item instanceof XmlElement && "sql".equalsIgnoreCase(((XmlElement) item).getName())) {
                elementList.add(index + 1, getSelectiveColumnsListElement());
                break;
            }
            index++;
        }
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private XmlElement getSelectiveColumnsListElement() {
        XmlElement selectiveColumnsListElement = new XmlElement("sql");
        selectiveColumnsListElement.addAttribute(new Attribute("id", "Selective_Column_List"));
        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "fieldFilters"));
        foreachElement.addAttribute(new Attribute("item", "listItem"));
        foreachElement.addAttribute(new Attribute("separator", ","));
        if (StringUtils.isNotBlank(securitySqlClass)) {
            foreachElement.addElement(new TextElement("${@" + securitySqlClass + "@trimSql(listItem)}"));
        } else {
            foreachElement.addElement(new TextElement("${listItem}"));
        }
        selectiveColumnsListElement.addElement(foreachElement);
        return selectiveColumnsListElement;
    }

    private void addFieldFiltersInSqlMap(XmlElement element, IntrospectedTable introspectedTable, boolean withBlob) {
        List<Element> elements = element.getElements();
        int index = 0;
        for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext(); ) {
            Element item = iterator.next();
            if (item instanceof XmlElement) {
                XmlElement xmlElement = XmlElement.class.cast(item);
                if ("include".equals(xmlElement.getName())) {
                    iterator.remove();
                    index--;
                }
            }
            if (item instanceof TextElement) {
                TextElement textElement = TextElement.class.cast(item);
                if (",".equals(textElement.getContent())) {
                    iterator.remove();
                    index--;
                }
                if (StringUtils.startsWith(textElement.getContent(), "from")) {
                    int curIndex = index;
                    XmlElement ifElement = new XmlElement("if");
                    ifElement.addAttribute(new Attribute("test", "fieldFilters != null"));
                    ifElement.addElement(getSelectiveColumnListElement());
                    elements.add(curIndex, ifElement);

                    ifElement = new XmlElement("if");
                    ifElement.addAttribute(new Attribute("test", "fieldFilters == null"));
                    ifElement.addElement(getBaseColumnListElement(introspectedTable));
                    if (withBlob && introspectedTable.hasBLOBColumns()) {
                        ifElement.addElement(new TextElement(","));
                        ifElement.addElement(getBlobColumnListElement(introspectedTable));
                    }
                    elements.add(curIndex + 1, ifElement);
                    break;
                }
            }
            index++;
        }
    }

    private XmlElement getSelectiveColumnListElement() {
        XmlElement answer = new XmlElement("include");
        answer.addAttribute(new Attribute("refid", "Selective_Column_List"));
        return answer;
    }

    private XmlElement getBaseColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement answer = new XmlElement("include");
        answer.addAttribute(new Attribute("refid", introspectedTable.getBaseColumnListId()));
        return answer;
    }

    private XmlElement getBlobColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement answer = new XmlElement("include");
        answer.addAttribute(new Attribute("refid", introspectedTable.getBlobColumnListId()));
        return answer;
    }

    private void addFieldFiltersInExampleClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String name = "fieldFilters";
        String type = "java.util.List<String>";
        CommentGenerator commentGenerator = context.getCommentGenerator();

        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType(type));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(type), name));
        method.addBodyLine("this." + name + " = " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(type));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }


    private void replaceUnsafeSlice(XmlElement parentElement) {
        List<Element> elements = parentElement.getElements();
        if (Objects.nonNull(elements) && !elements.isEmpty()) {
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                if (element instanceof TextElement) {
                    TextElement textElement = (TextElement) element;
                    String content = textElement.getContent();
                    if (StringUtils.isNotBlank(content)) {
                        if (content.indexOf("${orderByClause}") > 0) {
                            if (StringUtils.isNotBlank(securitySqlClass)) {
                                content = content.replace("${orderByClause}", "${@" + securitySqlClass + "@trimSql(orderByClause)}");
                            } else {
                                content = content.replace("${orderByClause}", "$orderByClause:METADATA$");
                            }
                            elements.set(i, new TextElement(content));
                        }
                        if (content.indexOf("${criterion.condition}") > 0) {
                            if (StringUtils.isNotBlank(securitySqlClass)) {
                                content = content.replace("${criterion.condition}", "${@" + securitySqlClass + "@trimSql(criterion.condition)}");
                            } else {
                                content = content.replace("${orderByClause}", "$orderByClause:METADATA$");
                            }
                            elements.set(i, new TextElement(content));
                        }
                    }
                }
                if (element instanceof XmlElement) {
                    replaceUnsafeSlice((XmlElement) element);
                }
            }
        }
    }
}
