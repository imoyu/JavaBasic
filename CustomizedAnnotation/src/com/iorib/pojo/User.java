package com.iorib.pojo;

import com.iorib.anno.Value;

public class User {

    @Value("李白")
    private String name;

    private Integer age;

    @Value
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Value("15")
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
