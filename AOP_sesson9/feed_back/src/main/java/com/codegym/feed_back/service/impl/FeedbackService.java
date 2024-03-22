package com.codegym.feed_back.service.impl;

import com.codegym.feed_back.aspect.FeedbackAspect;
import com.codegym.feed_back.model.Feedback;
import com.codegym.feed_back.repository.IFeedbackRepository;
import com.codegym.feed_back.service.BadWordFeedbackException;
import com.codegym.feed_back.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackAspect feedbackAspect;

    @Override
    public Page<Feedback> findAllByAuthor(String author, Pageable pageable) {
        return feedbackRepository.searchAllByAuthorContaining(author, pageable);
    }

    @Override
    public Page<Feedback> findAllByAuthorAndDate(String author, LocalDateTime date, Pageable pageable) {
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
    public void save(Feedback feedback) throws BadWordFeedbackException {
        feedbackAspect.checkBadWord(feedback);
        feedbackRepository.save(feedback);
    }
    @Override
    public void remove(Long id) {
        feedbackRepository.deleteById(id);
    }
}
