package com.codegym.music_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameSong;
    private String artist;
    private String kindOfMusic;
    private String path;

    public Song() {
    }

    public Song(Integer id, String nameSong, String artist, String kindOfMusic, String path) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", artist='" + artist + '\'' +
                ", kindOfMusic='" + kindOfMusic + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
