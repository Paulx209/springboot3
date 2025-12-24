package com.getian.springboot3;

import com.getian.springboot3.entity.Student;
import com.getian.springboot3.entity.User;
import com.getian.springboot3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot3ApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private Student student;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
