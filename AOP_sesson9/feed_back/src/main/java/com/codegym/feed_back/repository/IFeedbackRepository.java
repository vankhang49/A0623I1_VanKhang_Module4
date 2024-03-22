package com.codegym.feed_back.repository;

import com.codegym.feed_back.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
    Page<Feedback> searchAllByAuthorContaining(String author, Pageable pageable);
    Page<Feedback> searchAllByAuthorContainingAndDate(String author, LocalDateTime date, Pageable pageable);

}
