package com.codegym.music_app.repository.Impl;

import com.codegym.music_app.model.Song;
import com.codegym.music_app.repository.IMusicAppRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.sql.SQLInput;
import java.util.List;
@Repository
public class MusicAppRepository implements IMusicAppRepository {
    private static List<Song> songList;
    @Override
    public List<Song> findAll() {
        songList = BaseRepository.entityManager.createQuery("select s from  Song s", Song.class).getResultList();
        return songList;
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        return BaseRepository.entityManager.createQuery("select s from  Song s where id = :id", Song.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void update(int id, Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public boolean remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
        return entityTransaction.isActive();
    }
}
