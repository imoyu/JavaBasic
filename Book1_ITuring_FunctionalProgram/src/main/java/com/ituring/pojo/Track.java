package com.ituring.pojo;

import java.util.StringJoiner;

public class Track {

    private String name;

    public Track() {
    }

    public Track(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        return name != null ? name.equals(track.name) : track.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Track.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
