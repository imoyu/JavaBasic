package com.ituring.ex.cap3;

import com.ituring.pojo.Album;

import java.util.List;
import java.util.stream.Collectors;

public class No3_9_1_c {

    private static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() <= 3)
                .collect(Collectors.toList());
    }

}
