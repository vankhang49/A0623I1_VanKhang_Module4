package com.codegym.upload_music.service;

import com.codegym.upload_music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(String name, Music music);

    void remove(String name);
}
