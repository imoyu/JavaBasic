package com.inner.package2;

import com.inner.package1.Circle;

import java.lang.reflect.Field;

/**
 * 测试内部类的内存泄漏
 */
public class MemoryLeakTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Circle circle = new Circle(1.1);
        Circle.Draw draw = circle.getDraw();
        Field field = draw.getClass().getDeclaredField("this$0");
        field.setAccessible(true);
        Circle reflectCircle = (Circle) field.get(draw);
        System.out.println(reflectCircle.getClass());
    }

}
