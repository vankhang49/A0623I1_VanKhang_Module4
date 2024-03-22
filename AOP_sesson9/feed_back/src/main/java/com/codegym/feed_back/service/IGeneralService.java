package com.codegym.feed_back.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t) throws BadWordFeedbackException;

    void remove(Long id);

}
