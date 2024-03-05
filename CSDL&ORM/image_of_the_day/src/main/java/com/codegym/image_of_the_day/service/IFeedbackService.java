package com.codegym.image_of_the_day.service;

import com.codegym.image_of_the_day.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();

    void save(Feedback feedBack);

    Feedback findById(int id);

    boolean remove(int id);
}
