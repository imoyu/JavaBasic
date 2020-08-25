package com.log.test;

public class InitCauseException {

    public static void main(String[] args) throws Exception{

        f1();

    }

    private static void f1() throws Exception{
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            Exception ex = new Exception();
            ex.initCause(e);
            throw e;
        }
    }

}
