package com.ituring.pojo;

import java.util.List;
import java.util.StringJoiner;

public class Album {

    private String name;
    private List<Track> tracks;
    private List<String> musicians;

    public Album() {
    }

    public Album(String name) {
        this.name = name;
    }

    public Album(String name, List<Track> tracks, List<String> musicians) {
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (tracks != null ? !tracks.equals(album.tracks) : album.tracks != null) return false;
        return musicians != null ? musicians.equals(album.musicians) : album.musicians == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        result = 31 * result + (musicians != null ? musicians.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Album.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("tracks=" + tracks)
                .add("musicians=" + musicians)
                .toString();
    }
}
