package com.getian.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class HealthController {
    @Autowired
    private Date date;
    @GetMapping("/health")
    public String health(){
        return date.toString();
    }
}
