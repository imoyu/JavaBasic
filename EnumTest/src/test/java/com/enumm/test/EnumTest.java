package com.enumm.test;

import com.enumm.enumclass.SeansonEnum;
import org.junit.Test;

public class EnumTest {

    @Test
    public void Test() {

        for (SeansonEnum value : SeansonEnum.values()) {
            System.out.println("(no." + value.ordinal() + ") " + value.getDesc() + " : " + value.getCode() + "  " + value.name());
//            (no.0) 春天 : 1  SPRING
//            (no.1) 夏天 : 2  SUMMER
//            (no.2) 秋天 : 3  AUTUMN
//            (no.3) 冬天 : 4  WINTER
        }

    }

}
