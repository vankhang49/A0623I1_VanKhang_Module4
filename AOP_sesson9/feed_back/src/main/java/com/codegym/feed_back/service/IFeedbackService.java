package com.codegym.feed_back.service;

import com.codegym.feed_back.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;


public interface IFeedbackService extends IGeneralService<Feedback>{
    Page<Feedback> findAllByAuthor(String province, Pageable pageable);
    Page<Feedback> findAllByAuthorAndDate(String province, LocalDateTime date, Pageable pageable);
}
