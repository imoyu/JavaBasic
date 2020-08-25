package com.log.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Out1 {

    private static final Logger logger = LoggerFactory.getLogger(Out1.class);

    public static void main(String[] args) {

        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");

        try {
            f1();
            throw new RuntimeException("");
        } catch (Exception e) {
            logger.error("算数错误：{}", e.getMessage(), e);
//            logger.error("-------------------------------- {}", e.getMessage());
        }
    }

    private static void f1() {
        f2();
    }

    private static void f2() {
        System.out.println(1 / 0);
    }
}
