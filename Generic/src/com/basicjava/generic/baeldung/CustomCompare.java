package com.basicjava.generic.baeldung;

/**
 * 实例方法引用
 */
public class CustomCompare {

    public static void main(String[] args) {

        ComparatorByHelper<P, P> comparator2 = new ComparatorByHelper<P, P>() {
            @Override
            public int compare(P p, P p2, Helper helper) {
                return p.compare(p2, helper);
            }
        };
        ComparatorByHelper<P, P> comparator1 = (p, p2, helper) -> p.compare(p2, helper);

        ComparatorByHelper<P, P> comparator = P::compare;

        int byVal1 = comparator.compare(new P(2, 9), new P(4, 5), Helper.VAL1);
        int byVal2 = comparator.compare(new P(2, 9), new P(4, 5), Helper.VAL2);

        showRes(byVal1);
        showRes(byVal2);
    }

    static void showRes(int res) {
        if (res == 0) {
            System.out.println("P1 = P2");
        } else if (res > 0) {
            System.out.println("P1 > P2");
        } else {
            System.out.println("P1 < P2");
        }
    }
}

class Helper {

    public static final Helper VAL1 = new Helper(1);
    public static final Helper VAL2 = new Helper(2);

    private final int val;

    private Helper(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

class P {

    private int val1;
    private int val2;

    public int compare(P p, Helper helper) {
        if (helper.getVal() == 1)
            return Integer.compare(this.val1, p.val1);
        else
            return Integer.compare(this.val2, p.val2);
    }

    public P() {
    }

    public P(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
