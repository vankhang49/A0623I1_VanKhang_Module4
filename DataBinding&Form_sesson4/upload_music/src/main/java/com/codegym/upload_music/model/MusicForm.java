package com.codegym.upload_music.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private String name;
    private String artist;
    private String type;

    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(String name, String artist, String type, MultipartFile path) {
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

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
