package com.codegym.book_borrowing.repository;

import com.codegym.book_borrowing.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> searchAllByNameContaining(String name, Pageable pageable);
}
