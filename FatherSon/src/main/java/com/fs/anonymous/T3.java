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

        System.out.println(list1);
        System.out.println(list2);

    }
    // 相当于：
    private static class ArrayListSon<T> extends ArrayList<T> {

    }
    private static List<String> list2 = new ArrayListSon<>();
    static {
        list2.add("a");
        list2.add("b");
    }

}
