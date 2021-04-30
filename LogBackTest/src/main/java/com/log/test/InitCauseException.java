package com.log.test;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;

public class InitCauseException {

    public static void main(String[] args) {

        try {
            f2();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getSuppressed());
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

    }

    private static void f1() {
        try {
            throw new IOException("IO 异常");
        } catch (IOException e) {
            throw new RuntimeException("包装异常", e);
        }
    }

    private static void f2() {
        f1();
    }
    private static void f3() {
        throw new RuntimeException("f3 发生异常");
    }
    private static void f4() {
        f3();
    }
    private static void f5() {
        f4();
    }


}
