package com.codegym.customer_management.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
