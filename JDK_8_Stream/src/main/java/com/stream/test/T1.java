package com.stream.test;

import com.stream.pojo.Student.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T1 {

    static List<Student> students = null;

    static {
        students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
    }

    public static void main(String[] args) {

//     Guava Joiner 实现
//        Joiner.on('-').join(array);
//        Joiner.on(' ').skipNulls().join(1, null, 3); //1 3
//        Joiner.on(' ').useForNull("None").join(1, null, 3); //1 None 3

        Stream<String> nums1 = Stream.of("1", "2", "3", null, "4", "5", "6");
        Stream<String> nums2 = Stream.of("1", "2", "3", null, "4", "5", "6");
        Stream<String> nums3 = Stream.of("1", "2", "3", null, "4", "5", "6");

        String s1 = nums1.reduce((a, b) -> a + "," + b).get();
        String s2 = nums2.filter(n -> n != null).reduce((a, b) -> a + "," + b).get();
        String s3 = nums3.map(n -> n == null ? "null" : n).reduce((a, b) -> a + "," + b).get();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // 2. 分组
        // 按学校分组
        Map<String, List<Student>> group_school = students.stream()
                .collect(Collectors.groupingBy(Student::getSchool));
        System.out.println(group_school);

        // 多级分组
        Map<String, Map<String, List<Student>>> group_school_major = students.stream().collect(
                Collectors.groupingBy(Student::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(Student::getMajor)));  // 二级分组，按专业
        System.out.println(group_school_major);

        // flapMap
        String[] citys = new String[] {"Hubei", "Beijing", "Ningbo", "Shanghai"};
        List<String> list = Arrays.stream(citys)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(list);

    }

}
