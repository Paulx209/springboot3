package com.getian.springboot3.config;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        Set<ApplicationListener<?>> listeners = application.getListeners();
        System.out.println("此时注入的监听器数量为:" + listeners.size());
        System.out.println(">>> [1. 构造阶段] MyDemoRunListener 实例化成功！");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println(">>> [2. Starting] MySpringApplicationRunListener ---- starting ");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        MutablePropertySources propertySources = environment.getPropertySources();
        int index = 0;
        for(PropertySource<?> source : propertySources){
            System.out.printf("优先级 [%d] -> 名称: %s (%s)%n",
                    index++, source.getName(), source.getClass().getSimpleName());
            if (source instanceof EnumerablePropertySource) {
                String[] propertyNames = ((EnumerablePropertySource<?>) source).getPropertyNames();
                if(propertyNames.length == 10){
                    System.out.println(((EnumerablePropertySource<?>) source).getProperty("my.name"));
                }
                System.out.println("   └─ 包含 Key 数量: " + propertyNames.length);
            }
        }
        // 4. 验证具体某个属性的来源（看看它是从哪层被“提取”出来的）
        String targetKey = "spring.datasource.username"; // 换成你配置文件里有的 key
        if (environment.containsProperty(targetKey)) {
            System.out.println(">>> 验证属性 [" + targetKey + "] = " + environment.getProperty(targetKey));
        }
        System.out.println(">>> [3. Starting] MySpringApplicationRunListener ---- environmentPrepared ");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println(">>> [4. Starting] MySpringApplicationRunListener ---- contextPrepared ");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println(">>> [5. Starting] MySpringApplicationRunListener ---- contextLoaded ");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println(">>> [6. Starting] MySpringApplicationRunListener ---- started ");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println(">>> [7. Starting] MySpringApplicationRunListener ---- ready ");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println(">>> [8. Starting] MySpringApplicationRunListener ---- failed ");
    }
}
