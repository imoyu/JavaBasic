package com.inner.package2;

/**
 * 局部内部类测试
 */
public class LocalInnerTest {

    private static int num;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + num + "---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(5000);
        System.out.println("主线程修改 num");
        num = 9;
    }

}
