package com.getian.springboot3.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("my.group")
@PropertySource(value = "classpath:/b/myProperties.properties")
@Data
public class Group {
    private String name;
    private Integer numberCount;
}
