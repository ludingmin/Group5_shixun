package com.group5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.group5.Mapper")
@EnableTransactionManagement
public class Group5Application {
    public static void main(String[] args) {
        SpringApplication.run(Group5Application.class, args);
    }

}
