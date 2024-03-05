package com.codegym.image_of_the_day.service.impl;

import com.codegym.image_of_the_day.model.Feedback;
import com.codegym.image_of_the_day.repository.IFeedbackRepository;
import com.codegym.image_of_the_day.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public void save(Feedback feedBack) {
        feedbackRepository.save(feedBack);
    }

    @Override
    public Feedback findById(int id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
