package com.codegym.book_borrowing.repository;

import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAmountBookRepository extends JpaRepository<AmountBook, Integer> {
    Page<AmountBook> searchAllByBookName(String name, Pageable pageable);
}
