package com.codegym.book_borrowing.service;

import com.codegym.book_borrowing.model.AmountBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAmountBookService extends IGeneralService<AmountBook>{
    Page<AmountBook> searchAllByBookName(String name, Pageable pageable);
}
