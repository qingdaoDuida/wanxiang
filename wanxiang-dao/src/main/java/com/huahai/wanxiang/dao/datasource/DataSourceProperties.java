package com.huahai.wanxiang.dao.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = DataSourceProperties.MYSQL_PROPERTIES_PREFIX)
public class DataSourceProperties {

    public static final String MYSQL_PROPERTIES_PREFIX = "datasource";

    private String driver;
    private String url;
    private String userName;
    private String password;
    private int maxActive;
    private long maxWait;
    private int initialSize = 1;
    private int minIdle = 1;
    private int timeBetweenEvictionRunsMillis = 60000;
    private int minEvictableIdleTimeMillis = 25200000;
    private String validationQurery = "SELECT 'x'";
    private boolean testWhileIdle = true;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private String filters = "stat,slf4j,wall";
    private boolean removeAbandoned = true;
    private int removeAbandonedTimeout = 100;
    private boolean logAbandoned = true;
}
