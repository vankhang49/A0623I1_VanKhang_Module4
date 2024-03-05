package com.codegym.music_app.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class SongForm {
    private Integer id;
    private String nameSong;
    private String artist;
    private String kindOfMusic;
    private MultipartFile path;

    public SongForm() {
    }

    public SongForm(Integer id, String nameSong, String artist, String kindOfMusic, MultipartFile path) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
