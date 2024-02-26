package com.codegym.upload_music.service.serviceImpl;

import com.codegym.upload_music.model.Music;
import com.codegym.upload_music.service.IMusicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicService implements IMusicService {
    private List<Music> musics = new ArrayList<>();
    @Override
    public List<Music> findAll() {
        return musics;
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public Music findById(int id) {
        return null;
    }

    @Override
    public void update(String name, Music music) {
        for (Music m: musics) {
            if (Objects.equals(m.getName(), name)) {
                m = music;
                break;
            }
        }
    }

    @Override
    public void remove(String name) {
        for (int i = 0; i < musics.size(); i++) {
            if (Objects.equals(musics.get(i).getName(), name)) {
                musics.remove(i);
                break;
            }
        }
    }
}
