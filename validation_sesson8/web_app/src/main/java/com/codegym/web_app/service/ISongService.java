package com.codegym.web_app.service;

import com.codegym.web_app.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Page<Song> findAllByName(String name, Pageable pageable);

    void deleteById(Integer id);
    Optional<Song> findById(Integer id);
}
