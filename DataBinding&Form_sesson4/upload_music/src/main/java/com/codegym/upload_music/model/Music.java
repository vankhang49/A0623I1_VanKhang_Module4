package com.codegym.upload_music.model;

public class Music {
    private String name;
    private String artist;
    private String type;

    private String path;

    public Music() {
    }

    public Music(String name, String artist, String type, String path) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
