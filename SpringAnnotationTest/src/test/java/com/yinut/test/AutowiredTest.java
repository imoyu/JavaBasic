package com.yinut.test;

import com.yinut.component.Compon;
import com.yinut.component.ComponentWithLayer3;
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

        Compon compon = (Compon) context.getBean("compon");
        System.out.println(compon.getName());

        ComponentWithLayer3 lay3 = (ComponentWithLayer3) context.getBean("componentWithLayer3");
        System.out.println(lay3.getName());
    }

}
