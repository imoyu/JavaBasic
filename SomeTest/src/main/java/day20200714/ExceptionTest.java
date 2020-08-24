package day20200714;

import java.io.IOException;

public class ExceptionTest {

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Caught  Exception");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e.toString());
            System.out.println("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }

    private static void f() {
        System.out.println("Throws SimpleException from f()");
        throw new RuntimeException("Crash");
    }

}
