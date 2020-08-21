package com.inner.package2;

public class SuperKeywordTest {
}

class SuperBase {

    public String var1 = "v1";
    protected String var2 = "v2";
    String var3 = "v3";
    private String var4 = "v4";

}

class SuperSub extends SuperBase {

    public void getParentVar() {
        System.out.println(super.var1);
        System.out.println(super.var2);
        System.out.println(super.var3);
//        System.out.println(super.var4); // 无法访问
    }

}