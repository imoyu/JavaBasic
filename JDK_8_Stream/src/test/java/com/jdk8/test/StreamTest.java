package com.jdk8.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    @Test
    public void Test() {

        List<String> list = new ArrayList<>();
        String s = list.stream().reduce((s1, s2) -> s1 + ";" + s2).orElse("null");
        System.out.println(s);

    }

}
