package com.enumm.manual;

public final class SeasonManual {

    public static final SeasonManual SPRING = new SeasonManual("春天", 1);
    public static final SeasonManual SUMMER = new SeasonManual("夏天", 2);
    public static final SeasonManual AUTUMN = new SeasonManual("秋天", 3);
    public static final SeasonManual WINTER = new SeasonManual("冬天", 4);

    private final String desc;
    private final int code;

    private SeasonManual(String desc, int code) {
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
