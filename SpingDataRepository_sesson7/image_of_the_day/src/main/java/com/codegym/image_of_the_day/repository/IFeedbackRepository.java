package com.codegym.image_of_the_day.repository;

import com.codegym.image_of_the_day.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
    Page<Feedback> searchAllByAuthorContaining(String author, Pageable pageable);
    Page<Feedback> searchAllByAuthorContainingAndDate(String author, LocalDate date, Pageable pageable);

}
