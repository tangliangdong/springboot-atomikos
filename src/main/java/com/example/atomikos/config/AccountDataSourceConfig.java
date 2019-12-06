//package com.example.atomikos.config;
//import com.alibaba.druid.pool.xa.DruidXADataSource;
//import com.atomikos.icatch.jta.UserTransactionImp;
//import com.atomikos.icatch.jta.UserTransactionManager;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.sql.DataSource;
//import javax.transaction.UserTransaction;
//
///**
// * @author Administrator
// * @data 2019/12/5
// * @time 16:17
// */
//@Configuration
//// // 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages ="com.example.atomikos.db1" ,sqlSessionFactoryRef = "accountSqlSessionFactory")
//public class AccountDataSourceConfig {
//
//    @Bean(name = "accountDataSource")
//    @Primary
//    public DataSource masterDataSource() {
//        DruidXADataSource druidXADataSource = new DruidXADataSource();
//        druidXADataSource.setUrl("jdbc:mysql://localhost:3306/db_account?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC");
//        druidXADataSource.setUsername("root");
//        druidXADataSource.setPassword("971011");
//        druidXADataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//
//        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
//        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
//        atomikosDataSourceBean.setUniqueResourceName("accountDataSource");
//        atomikosDataSourceBean.setPoolSize(5);
//
//        return atomikosDataSourceBean;
//    }
//
//    /*
//     * 使用这个来做总事务 后面的数据源就不用设置事务了
//     * */
//    @Bean(name = "transactionManager")
//    @Primary
//    public JtaTransactionManager regTransactionManager () {
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        UserTransaction userTransaction = new UserTransactionImp();
//        return new JtaTransactionManager(userTransaction, userTransactionManager);
//    }
//
//    @Bean(name = "accountSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("accountDataSource") DataSource masterDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(masterDataSource);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));
//        return sessionFactory.getObject();
//    }
//
//}
