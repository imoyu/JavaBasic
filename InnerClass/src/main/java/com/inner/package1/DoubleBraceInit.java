package com.inner.package1;

import java.util.ArrayList;

public class DoubleBraceInit {

    private void test() {
        Face face = new Face() {};
        ArrayList<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                this.add(2);
            }
        };
    }

}

interface Face {
}