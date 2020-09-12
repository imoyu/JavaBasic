package com.ituring.pojo;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Artist {

    private String name;
    private Stream<String> members;
    private String origin;
    private Track track;
    private Album album;

    public Artist() {
    }

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public Artist(String name, Stream<String> members, String origin, Track track, Album album) {
        this.name = name;
        this.members = members;
        this.origin = origin;
        this.track = track;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<String> getMembers() {
        return members;
    }

    public void setMembers(Stream<String> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        if (members != null ? !members.equals(artist.members) : artist.members != null) return false;
        if (origin != null ? !origin.equals(artist.origin) : artist.origin != null) return false;
        if (track != null ? !track.equals(artist.track) : artist.track != null) return false;
        return album != null ? album.equals(artist.album) : artist.album == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (members != null ? members.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Artist.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("members=" + members)
                .add("origin='" + origin + "'")
                .add("track=" + track)
                .add("album=" + album)
                .toString();
    }
}
