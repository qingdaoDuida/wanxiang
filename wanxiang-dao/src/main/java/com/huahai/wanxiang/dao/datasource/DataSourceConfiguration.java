package com.huahai.wanxiang.dao.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DataSourceConfiguration {

    @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriver());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUserName());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(dataSourceProperties.getValidationQurery());
        dataSource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(dataSourceProperties.isTestOnReturn());
        dataSource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());

        dataSource.setRemoveAbandoned(dataSource.isRemoveAbandoned());
        dataSource.setRemoveAbandonedTimeout(dataSourceProperties.getRemoveAbandonedTimeout());
        dataSource.setLogAbandoned(dataSourceProperties.isLogAbandoned());

        try {
            dataSource.setFilters(dataSourceProperties.getFilters());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
