package com.codegym.web_app.repository;

import com.codegym.web_app.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> searchAllByNameContaining(String name, Pageable pageable);
}
