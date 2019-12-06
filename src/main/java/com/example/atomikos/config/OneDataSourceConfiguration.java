package com.example.atomikos.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Administrator
 * @data 2019/12/6
 * @time 11:25
 */
@Configuration
//这里要指明这个数据适用于哪些mapper，和这个数据源的sqlsessionFactory
@MapperScan(basePackages = "com.example.atomikos.db1.dao", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class OneDataSourceConfiguration {
    @Autowired
    public OneDataSourceProperties oneDataSourceProperties;

    //配置第一个数据源
    @Primary
    @Bean(name = "oneDataSource")
    public DataSource oneDataSource() {
        // 这里datasource要使用阿里的支持XA的DruidXADataSource
        DruidXADataSource datasource = new DruidXADataSource();
        BeanUtils.copyProperties(oneDataSourceProperties,datasource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(datasource);
        xaDataSource.setUniqueResourceName("oneDataSource");
        return xaDataSource;
    }

    //配置第一个sqlsessionFactory
    @Primary
    @Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(oneDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:mapper/user/*.xml"));
        return bean.getObject();
    }
}
