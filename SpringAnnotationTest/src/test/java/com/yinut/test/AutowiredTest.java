package com.yinut.test;

import com.yinut.pojo.Zoo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Zoo zoo = (Zoo) context.getBean("zoo");
        System.out.println(zoo.toString());
    }

}
