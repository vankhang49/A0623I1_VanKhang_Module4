package com.codegym.web_app.service.impl;

import com.codegym.web_app.model.Song;
import com.codegym.web_app.repository.ISongRepository;
import com.codegym.web_app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Page<Song> findAllByName(String name, Pageable pageable) {
        return songRepository.searchAllByNameContaining(name, pageable);
    }

    @Override
    public void deleteById(Integer id) {
        songRepository.deleteById(id);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }
}
