package com.codegym.book_borrowing.repository;

import com.codegym.book_borrowing.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowingRepository extends JpaRepository<Borrowing, Integer> {
    Borrowing searchByBorrowedCode(String code);
}
