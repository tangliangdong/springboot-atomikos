package com.example.atomikos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @data 2019/12/6
 * @time 11:14
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid.two")
public class TwoDataSourceProperties {
    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private Integer initialSize;

    private Integer maxActive;

    private Integer minIdle;
    private Integer maxWait;
    private Integer timeBetweenEvictionRunsMillis;

    private Integer minEvictableIdleTimeMillis;

    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;

    private String filters;
}
