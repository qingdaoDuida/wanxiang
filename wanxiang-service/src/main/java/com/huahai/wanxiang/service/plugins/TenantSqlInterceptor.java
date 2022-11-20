package com.huahai.wanxiang.service.plugins;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.huahai.wanxiang.dao.domain.TenantInfoDO;
import com.huahai.wanxiang.service.context.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

@Slf4j
@Component
@Intercepts(@Signature(type = StatementHandler.class ,method = "prepare", args = {Connection.class,Integer.class}))
public class TenantSqlInterceptor implements Interceptor {

    private static Field sqlField;

    static {
        try {
            sqlField = BoundSql.class.getDeclaredField("sql");
            ReflectionUtils.makeAccessible(sqlField);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        String newSql = this.curbedProjectType(sql);
        ReflectionUtils.setField(sqlField,boundSql,newSql);
        return invocation.proceed();
    }

    private String curbedProjectType(String sql) {
        MySqlStatementParser sqlStatementParser = new MySqlStatementParser(sql);
        SQLStatement sqlStatement = sqlStatementParser.parseStatement();
        if (!(sqlStatement instanceof SQLSelectStatement)) {
            return sql;
        }

        SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
        SQLSelect sqlSelect = sqlSelectStatement.getSelect();
        if (Objects.isNull(sqlSelect) || Objects.isNull(sqlSelect.getQuery()) ||
                !(sqlSelect.getQuery() instanceof SQLSelectQueryBlock)) {
            return sql;
        }
        SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelect.getQuery();
        SQLTableSource tableSource = sqlSelectQueryBlock.getFrom();

        if ((tableSource instanceof SQLExprTableSource)) {
            return this.generateSqlString(sql,tableSource);
        }
        if (tableSource instanceof SQLJoinTableSource) {
            sql = this.generateSqlString(sql,((SQLJoinTableSource) tableSource).getLeft());
            sql = this.generateSqlString(sql,((SQLJoinTableSource) tableSource).getRight());
        }
        return sql;
    }

    private String generateSqlString(String sql, SQLTableSource tableSource) {
        SQLExpr sqlExpr = null;
        if ((tableSource instanceof SQLExprTableSource)) {
            sqlExpr = ((SQLExprTableSource) tableSource).getExpr();
        }
        if ((tableSource instanceof SQLJoinTableSource)) {
            sqlExpr = ((SQLJoinTableSource) tableSource).getCondition();
        }
        if (Objects.isNull(sqlExpr) || !(sqlExpr instanceof SQLIdentifierExpr)) {
            return sql;
        }
        SQLIdentifierExpr sqlIdentifierExpr = (SQLIdentifierExpr) sqlExpr;
        String tableName = sqlIdentifierExpr.getName();
        String lowerSql = sql.toLowerCase();
        int tableNameIndex = sql.indexOf(tableName);
        int index = lowerSql.indexOf("where") + 5;
        if (index <= tableNameIndex) {
            index = tableNameIndex + tableName.length();
        }
        String queryFieldSql = sql.substring(0,index);
        String conditionSql = sql.substring(index);
        StringBuilder addSql = new StringBuilder(" ");
        if (!lowerSql.contains("where")) {
            addSql.append("where ");
        }
        StringBuilder alias = new StringBuilder();
        if (StringUtils.isNotEmpty(tableSource.getAlias())) {
            alias.append(tableSource.getAlias()).append(".");
        }
        if ("article_info".equals(tableName)) {
            TenantInfoDO tenantInfoDO = TenantContext.get();
            Long currentTenantId = -1L;
            if (Objects.nonNull(tenantInfoDO)) {
                currentTenantId = tenantInfoDO.getId();
            }
            StringBuilder fieldName = new StringBuilder(alias);
            fieldName.append("tenant_id");
            addSql.append(fieldName).append("=").append(currentTenantId);
            if (!StringUtils.isEmpty(conditionSql)) {
                if (conditionSql.toLowerCase().trim().indexOf("limit") != 0) {
                    addSql.append(" and ");
                }
            }
        }
        return queryFieldSql + addSql + conditionSql;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
