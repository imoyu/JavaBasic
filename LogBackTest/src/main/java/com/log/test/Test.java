package com.log.test;

import java.io.IOException;

class Test {
    public Test() throws IOException {}
    void test() throws IOException {}
}

class SubTest extends Test implements I1 {
    public SubTest() throws Exception,NullPointerException, NoSuchMethodException {}
    public void test() throws IOException {}

}