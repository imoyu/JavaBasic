package com.fs.anonymous;

import java.util.ArrayList;
import java.util.List;

public class T3 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>() {
            {
                add("a");
                add("b");
            }
        };


    }
    // 相当于：
    static class ArrayListSon<T> extends ArrayList<T> {

    }
    static List<String> list2 = new ArrayListSon<String>();
    static {
        list2.add("a");
        list2.add("b");
    }

}
