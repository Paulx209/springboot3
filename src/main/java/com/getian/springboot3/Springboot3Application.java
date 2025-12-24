package com.getian.springboot3;

import com.getian.springboot3.entity.User;
import com.getian.springboot3.service.UserService;
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
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
        context.close();
//        UserService userService = (UserService) context.getBean("userService");
//        userService.save();
    }

}