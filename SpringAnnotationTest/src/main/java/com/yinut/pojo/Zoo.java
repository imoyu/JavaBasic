package com.yinut.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class Zoo {

    @Autowired
    private Tiger tiger;

    @Override
    public String toString() {
        return "Zoo{" +
                "tiger=" + tiger +
                '}';
    }
}
