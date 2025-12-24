package com.getian.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Springboot3Application {

    @Bean
    public Date getDate(){
        return new Date();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot3Application.class, args);
        Object bean = context.getBean("sqlSessionFactory");
        System.out.println(bean);
    }

}