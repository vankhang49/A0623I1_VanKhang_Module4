package com.codegym.book_borrowing.service;

import com.codegym.book_borrowing.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGeneralService<Book> {
    Page<Book> searchAllByName(String name, Pageable pageable);
}
