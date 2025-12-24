package com.getian.springboot3.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@Component
public class User {
    @Value("${my.name}")
    private String name;
}
