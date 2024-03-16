package com.codegym.web_app.model;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "song_id", columnDefinition = "INT")
    private Integer id;
    @Column(name = "name_song")
    private String name;
    @Column(name = "artist")
    private String artist;
    @Column(name = "kind_of_music")
    private String kindOfMusic;
    @Column(name = "song_path")
    private String songPath;

    public Song() {
    }

    public Song(String name, String artist, String kindOfMusic, String songPath) {
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.songPath = songPath;
    }

    public Song(Integer id, String name, String artist, String kindOfMusic, String songPath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.songPath = songPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
