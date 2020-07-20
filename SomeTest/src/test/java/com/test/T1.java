package com.test;

import org.junit.Test;

import java.util.Random;

public class T1 {

    @Test
    public void test1() {
        int a;
        Integer b;
        int c = 1;
        Integer d = 2;
        Integer e = null;
        Random r = new Random();
        a = r.nextBoolean() ? c : d;
//        a = r.nextBoolean() ? c : e;   // 可能报错
        b = r.nextBoolean() ? c : d;
        b = r.nextBoolean() ? c : e;
    }

}
