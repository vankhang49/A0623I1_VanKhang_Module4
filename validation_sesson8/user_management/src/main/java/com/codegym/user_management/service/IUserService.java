package com.codegym.user_management.service;

import com.codegym.user_management.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    Page<User> findAllByFirstname(String firstname, Pageable pageable);

    void deleteById(Integer id);
    Optional<User> findById(Integer id);
}
