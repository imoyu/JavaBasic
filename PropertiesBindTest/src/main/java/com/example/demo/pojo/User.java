package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

// 这样写绑定不到配置文件
// @PropertySource 要和 注册进容器的注解在一起，目前绑定不到
@PropertySource(value = {"classpath:user.properties"})
@ConfigurationProperties(prefix = "user")
public class User {

    private String no;
    private String name;
    private Integer age;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
