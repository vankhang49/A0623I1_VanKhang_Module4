package com.codegym.image_of_the_day.repository.Impl;

import com.codegym.image_of_the_day.model.Feedback;
import com.codegym.image_of_the_day.repository.IFeedbackRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Transactional
@Repository
public class FeedbackRepository implements IFeedbackRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Feedback> findAll() {
        LocalDate today = LocalDate.now();
        TypedQuery<Feedback> query = em.createQuery("SELECT f FROM Feedback f WHERE f.date = :date", Feedback.class)
                .setParameter("date", today);
        return query.getResultList();
    }

    @Override
    public Feedback findById(int id) {
        TypedQuery<Feedback> query = em.createQuery("select f from  Feedback f where id = :id", Feedback.class)
                .setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public void save(Feedback feedBack) {
        if (feedBack.getId() != null){
            feedBack.setVotes(feedBack.getVotes()+1);
            em.merge(feedBack);
        } else {
            em.persist(feedBack);
        }
    }

    @Override
    public boolean remove(int id) {
        Feedback feedback = findById(id);
        if (feedback != null){
            em.remove(feedback);
            return true;
        }
        return false;
    }
}
