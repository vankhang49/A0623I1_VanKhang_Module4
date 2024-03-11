package com.codegym.image_of_the_day.service;

import com.codegym.image_of_the_day.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;


public interface IFeedbackService extends IGeneralService<Feedback>{
    Page<Feedback> findAllByAuthor(String province, Pageable pageable);
    Page<Feedback> findAllByAuthorAndDate(String province, LocalDate date, Pageable pageable);
}
