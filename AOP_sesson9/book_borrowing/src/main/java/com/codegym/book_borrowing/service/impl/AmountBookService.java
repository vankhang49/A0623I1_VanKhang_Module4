package com.codegym.book_borrowing.service.impl;

import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.repository.IAmountBookRepository;
import com.codegym.book_borrowing.service.IAmountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmountBookService implements IAmountBookService {
    @Autowired
    private IAmountBookRepository amountBookRepository;

    @Override
    public Page<AmountBook> searchAllByBookName(String name, Pageable pageable) {
        return amountBookRepository.searchAllByBookName(name, pageable);
    }

    @Override
    public List<AmountBook> findAll() {
        return amountBookRepository.findAll();
    }

    @Override
    public Optional<AmountBook> findById(Integer id) {
        return amountBookRepository.findById(id);
    }

    @Override
    public void save(AmountBook amountBook) {
        amountBookRepository.save(amountBook);
    }

    @Override
    public void remove(Integer id) {
        amountBookRepository.deleteById(id);
    }
}
