package com.codegym.user_management.repository;

import com.codegym.user_management.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> searchAllByFirstnameContains(String firstname, Pageable pageable);
}
