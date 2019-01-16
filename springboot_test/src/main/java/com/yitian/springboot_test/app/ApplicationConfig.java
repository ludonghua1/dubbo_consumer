package com.yitian.springboot_test.app;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.yitian")
@MapperScan("com.yitian.springboot_test.dao")
@EnableTransactionManagement
@Configuration
public class ApplicationConfig {
}
