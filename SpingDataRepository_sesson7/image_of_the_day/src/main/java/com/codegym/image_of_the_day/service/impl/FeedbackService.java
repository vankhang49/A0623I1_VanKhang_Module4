package com.codegym.image_of_the_day.service.impl;

import com.codegym.image_of_the_day.model.Feedback;
import com.codegym.image_of_the_day.repository.IFeedbackRepository;
import com.codegym.image_of_the_day.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public Page<Feedback> findAllByAuthor(String author, Pageable pageable) {
        return feedbackRepository.searchAllByAuthorContaining(author, pageable);
    }

    @Override
    public Page<Feedback> findAllByAuthorAndDate(String author, LocalDate date, Pageable pageable) {

        return feedbackRepository.searchAllByAuthorContainingAndDate(author, date, pageable);
    }

    @Override
    public Iterable<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public void save(Feedback feedback) {
        feedback.setVotes(feedback.getVotes() + 1);
        feedbackRepository.save(feedback);
    }
    @Override
    public void remove(Long id) {
        feedbackRepository.deleteById(id);
    }
}
