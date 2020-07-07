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

    }

}
