package com.ituring.ex.cap3;

import com.ituring.pojo.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No3_9_1_b {

    public static void main(String[] args) {

    }

    // 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍
    private static List<String> getNamesAndOrigins(List<Artist> artists) {

        if (artists == null) {
            return new ArrayList<>();
        }

        List<String> result = artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getOrigin()))
                .collect(Collectors.toList());

        return result;
    }
}
