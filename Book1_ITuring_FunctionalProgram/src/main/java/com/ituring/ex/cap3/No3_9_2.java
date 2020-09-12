package com.ituring.ex.cap3;

import com.ituring.pojo.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class No3_9_2 {

    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>();
        long totalMembers = artists.stream()
                .map(Artist::getMembers)
                        .mapToLong(Stream::count)
                        .sum();
    }


}
