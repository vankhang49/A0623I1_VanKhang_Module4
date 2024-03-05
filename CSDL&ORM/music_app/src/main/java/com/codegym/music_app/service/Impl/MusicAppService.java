package com.codegym.music_app.service.Impl;

import com.codegym.music_app.model.Song;
import com.codegym.music_app.repository.IMusicAppRepository;
import com.codegym.music_app.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    private IMusicAppRepository musicAppRepository;
    @Override
    public List<Song> findAll() {
        return musicAppRepository.findAll();
    }

    @Override
    public void save(Song song) {
        musicAppRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return musicAppRepository.findById(id);
    }

    @Override
    public void update(int id, Song song) {
        musicAppRepository.update(id, song);
    }

    @Override
    public boolean remove(int id) {
       return musicAppRepository.remove(id);
    }
}
