package com.enumm.enumclass;

public enum  SeansonEnum {

    SPRING("春天", 1),
    SUMMER("夏天", 2),
    AUTUMN("秋天", 3),
    WINTER("冬天", 4);

    private final String desc;
    private final int code;

    private SeansonEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

}
