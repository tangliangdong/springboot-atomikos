package com.example.atomikos;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"com.example.atomikos.db1.dao","com.example.atomikos.db2.dao"})
public class AtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtomikosApplication.class, args);
    }

}
