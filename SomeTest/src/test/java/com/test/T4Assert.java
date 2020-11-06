package com.test;

import org.junit.Test;

public class T4Assert {

    @Test
    public void assertTest() {
        boolean isOpen = false;

        // 如果开启了断言，会将isOpen的值改为true
        assert isOpen = true;

        // 打印是否开启了断言，如果为false，则没有启用断言
        System.out.println(isOpen);
        // =======
    }

}
