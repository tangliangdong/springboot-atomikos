package com.example.atomikos;

import com.gonghui.pay.code.generator.rapid.RapidGenerator;
import com.gonghui.pay.code.generator.rapid.model.DBConfig;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/8.
 */

public class RapidGeneratorTest {
    @Test
    public void testGeneratorOneTable() throws Exception {
        RapidGenerator rapidGenerator = new RapidGenerator();
        rapidGenerator.setAuthor("tangliangdong");
        DBConfig dbConfig = new DBConfig();
        dbConfig.setUrl("jdbc:mysql://localhost:3306/db_user?characterEncoding=UTF-8");
        dbConfig.setUserName("root");
        dbConfig.setPwd("971011");
        dbConfig.setDriver("com.mysql.jdbc.Driver");
        rapidGenerator.initDbConfig(dbConfig);
        rapidGenerator.initOutRootPathConfig("E:\\idea\\atomikos");
        rapidGenerator.initPackage("com.example.atomikos.db1");
        rapidGenerator.initModelName("user");
        rapidGenerator.generatorOneTable("movie");
    }
}