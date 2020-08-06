package com.test;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T2 {

    @Test
    public void stringFormatTest() {

        System.out.printf("%s %s %d%n", 21, 163232323232323L, 020);

    }

    @Test
    public void localDateTimeTest() {

        LocalDateTime estimatedTime = LocalDateTime.parse("2020-08-01 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.parse("2020-08-03 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Duration duration = Duration.between(now, estimatedTime); // 尾减头
        System.out.println(duration.toHours()); // -48

        String s = now.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
        System.out.println(s);

    }

    /**
     * 测试 Java 代码样式
     */
    @Test
    public void JavaCodeColorSchemeTest() {

        LinkedList<String> linkedList = new LinkedList<>();
        List<String> linkedList2 = new LinkedList<>();
        List<String> linkedList3 = new LinkedList<>();
        linkedList3 = null;
        if (linkedList3 == null) {

        }
        linkedList2.add("");
        LocalDateTime estimatedTime = LocalDateTime.parse("2020-08-01 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.parse("2020-08-03 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Duration duration = Duration.between(now, estimatedTime); // 尾减头
        System.out.println(duration.toHours()); // -48

        String s = now.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
        System.out.println(s);

        new T2().stringFormatTest();
        Map<String, String> map = new HashMap<>();
        map.put("", "");
    }

    public static String MESSAGE = "no message";
    public String MESSAGE2 = "no message";

    private static void func(int number, int j) {
        System.out.println(number);
        System.out.println(MESSAGE);
        System.out.println(new T2().MESSAGE2);
    }

    @Test
    public void nullStringTest() {

//        String s = null;
//        String s1 = "s".concat("");
//        System.out.println(s1);   空指针

//        String s = null;
//        String s1 = "->".concat(s);
//        System.out.println(s1);  // 空指针

        StringBuilder builder = new StringBuilder();
        String s = null;
        System.out.println(builder.append(s));

        // 以下为 Refactor 重构测试

        builder.append("q");
        builder.append("q");
        builder.append("q");

        boolean b = !new Random().nextBoolean();
        if (!b) {

        }

        ArrayList<String> list = new ArrayList<String>() {
            {
                add("");
            }
        };

        System.out.println("dasdsa" + "hh");

    }

    String src = "{\n" +
            "    \"Success\": 200,\n" +
            "    \"Request_id\": \"254225d23b3bf8bf20a25f83a1b641c9\",\n" +
            "    \"company\": \"\\u9e2d\\u5634\\u517d\",\n" +
            "    \"Log_id\": \"2332-232w-rtrt-2323\",\n" +
            "    \"Message\": \"\\u6210\\u529f\",\n" +
            "    \"Data\": {\n" +
            "        \"\\u9884\\u914d\\u4fe1\\u606f\": {\n" +
            "            \"\\u4e3b\\u63d0\\u5355\\u53f7\": \"SWHCCHQ20050006\",\n" +
            "            \"\\u63d0\\u5355\\u53f7\": \"CNUW015154\",\n" +
            "            \"\\u8239\\u516c\\u53f8\": \"\\u8fbe\\u98de\\u8f6e\\u8239(\\u4e2d\\u56fd)\\u6709\\u9650\\u516c\\u53f8\",\n" +
            "            \"\\u8239\\u540d\": \"OOCL TOKYO\",\n" +
            "            \"\\u822a\\u6b21\": \"102E\",\n" +
            "            \"\\u6e2f\\u533a\": \"\\u5916\\u6e2f\",\n" +
            "            \"\\u542f\\u8fd0\\u6e2f\": \"SHANGHAI\",\n" +
            "            \"\\u4e2d\\u8f6c\\u6e2f\": \"\",\n" +
            "            \"\\u76ee\\u7684\\u6e2f\": \"MESQUITE\\uff0c TX\",\n" +
            "            \"\\u5236\\u5355\\u7801\": \"\",\n" +
            "            \"\\u6821\\u9a8c\\u7801\": \"\",\n" +
            "            \"\\u4e1a\\u52a1\\u7f16\\u53f7\": \"20C-P431434\",\n" +
            "            \"\\u63a8\\u573a\": \"\"\n" +
            "        },\n" +
            "        \"\\u5730\\u5740\\u4fe1\\u606f\": {\n" +
            "            \"\\u95e8\\u70b9\\u5730\\u5740\": \"\\u82cf\\u5dde\\u65b0\\u533a\\u6d52\\u5173\\u5206\\u533a\\u6d0b\\u5e84\\u8def2\\u53f7\",\n" +
            "            \"\\u95e8\\u70b9\\u540d\\u79f0\": \"\",\n" +
            "            \"\\u8054\\u7cfb\\u4eba\": \"\",\n" +
            "            \"\\u8054\\u7cfb\\u7535\\u8bdd\": \"\",\n" +
            "            \"\\u7981\\u533a\\u4fe1\\u606f\": \"\"\n" +
            "        },\n" +
            "        \"\\u7bb1\\u4fe1\\u606f\": {\n" +
            "            \"\\u505a\\u7bb1\\u65f6\\u95f4\": \"\",\n" +
            "            \"\\u7bb1\\u578b\": \"40'HQX 8\",\n" +
            "            \"\\u5355\\u7bb1\\u4ef6\\u6570\": \"7632 CTNS\",\n" +
            "            \"\\u5355\\u7bb1\\u6bdb\\u91cd\": \"52508.16 KGS\",\n" +
            "            \"\\u5355\\u7bb1\\u4f53\\u79ef\": \"557.136 CBM\",\n" +
            "            \"\\u54c1\\u540d\": \" VACUUM CLEANER\",\n" +
            "            \"\\u9884\\u8ba1\\u5355\\u7bb1\\u8d27\\u91cd\": \"\",\n" +
            "            \"\\u526f\\u63d0\\u5355\": \"\",\n" +
            "            \"\\u551b\\u5934\": \"\",\n" +
            "            \"\\u5408\\u540c\\u53f7\": \"\",\n" +
            "            \"\\u7bb1\\u7f16\\u53f7\": \"\"\n" +
            "        },\n" +
            "        \"\\u505a\\u7bb1\\u8981\\u6c42\": {\n" +
            "            \"\\u63d0\\u7bb1\\u8981\\u6c42\": \"\",\n" +
            "            \"\\u505a\\u7bb1\\u8981\\u6c42\": \"\\u5730\\u5740\\uff1a\\u82cf\\u5dde\\u65b0\\u533a\\u6d0b\\u5e84\\u8def2\\u53f7\\u8303\\u6bbf\\u9ad817506171636  \\u8054\\u7cfb\\u4eba \\u8054\\u7cfb\\u4eba\\u7535\\u8bdd\",\n" +
            "            \"\\u5907\\u6ce8\": \" CMA\\u7ea6\\u53f7\\uff1a20-1323Rail+truck  \\u63d0\\u5355\\u4e0a\\u6ce8\\u660e\\uff1aFREIGHT COLLECT |\",\n" +
            "            \"\\u5c0f\\u7bb1\\u6446\\u653e\\u4f4d\\u7f6e\": \"\",\n" +
            "            \"\\u622a\\u5355\\u65f6\\u95f4\": \"\",\n" +
            "            \"\\u6700\\u665a\\u8fdb\\u6e2f\\u65f6\\u95f4\\u8981\\u6c42\": \"\",\n" +
            "            \"\\u9884\\u5b9a\\u9884\\u63d0\\u8981\\u6c42\": \"|1.\\u63d0\\u7bb1\\u65f6\\u8bf7\\u4ed4\\u7ec6\\u68c0\\u67e5\\u96c6\\u88c5\\u7bb1\\u5916\\u89c2\\u662f\\u5426\\u5b8c\\u597d\\uff1b\\u8bf7\\u63d0\\u65e0\\u6f6e\\u6e7f\\uff0c\\u65e0\\u5f02\\u5473\\uff0c\\u65e0\\u7834\\u635f\\uff0c\\u65e0\\u6c61\\u67d3\\u7684\\u96c6\\u88c5\\u7bb1\\u3002 \\u8f66\\u961f\\u6ce8\\u610f 2.\\u5982\\u8bbe\\u5907\\u4ea4\\u63a5\\u5355\\u4e0a\\u663e\\u793a\\u6d0b\\u5c71\\u63d0\\u7bb1\\uff0c\\u8bf7\\u53ca\\u65f6\\u544a\\u77e5\\u6211\\u53f8\\u3002 \\u4e0d\\u9700\\u8981 \\u4e8b\\u9879\\uff1a 3.\\u5982\\u6709\\u5176\\u4ed6\\u95ee\\u9898\\u8bf7\\u53ca\\u65f6\\u544a\\u77e5\\u6211\\u53f8\\uff0c\\u4ee5\\u907f\\u514d\\u4e0d\\u5fc5\\u8981\\u7684\\u8d39\\u7528\\u4ea7\\u751f\\uff0c\\u8c22\\u8c22!\",\n" +
            "            \"\\u8fc7\\u78c5\\u8981\\u6c42\": \"\",\n" +
            "            \"\\u7b49\\u901a\\u77e5\\u653e\\u5355\": \"\",\n" +
            "            \"\\u51fa\\u6570\\u636e\\u622a\\u5355\": \"\"\n" +
            "        }\n" +
            "    }\n" +
            "}\n";

    @Test
    public void StringtoUnicodeTest1() {

        int t =  src.length() / 6;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = src.substring(i * 6, (i + 1) * 6); // 每6位描述一个字节
            // 高位需要补上00再转
            String s1 = s.substring(2, 4) + "00";
            // 低位直接转
            String s2 = s.substring(4);
            // 将16进制的string转为int
            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
            // 将int转换为字符
            char[] chars = Character.toChars(n);
            str.append(new String(chars));
        }
        System.out.println(str);

    }

    @Test
    public void StringtoUnicodeTest2() {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(src);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            src = src.replace(group1, ch + "");
        }

        System.out.println(src);

    }
}
