package com.codegym.music_app.repository;

import com.codegym.music_app.model.Song;

import java.util.List;

public interface IMusicAppRepository {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(int id, Song song);

    boolean remove(int id);
}
