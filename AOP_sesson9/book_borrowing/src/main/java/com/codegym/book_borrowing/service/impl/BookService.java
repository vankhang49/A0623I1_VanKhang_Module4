package com.codegym.book_borrowing.service.impl;

import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.model.Book;
import com.codegym.book_borrowing.repository.IAmountBookRepository;
import com.codegym.book_borrowing.repository.IBookRepository;
import com.codegym.book_borrowing.service.BookBorrowingException;
import com.codegym.book_borrowing.service.IAmountBookService;
import com.codegym.book_borrowing.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IAmountBookRepository amountBookRepository;
    @Override
    public Page<Book> searchAllByName(String name, Pageable pageable) {
        return bookRepository.searchAllByNameContaining(name, pageable);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        amountBookRepository.deleteById(id);
        bookRepository.deleteById(id);
    }
}
