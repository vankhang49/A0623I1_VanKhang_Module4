package com.codegym.image_of_the_day.repository;

import com.codegym.image_of_the_day.model.Feedback;

import java.util.List;

public interface IFeedbackRepository {
    List<Feedback> findAll();

    void save(Feedback feedBack);

    Feedback findById(int id);

    boolean remove(int id);
}
