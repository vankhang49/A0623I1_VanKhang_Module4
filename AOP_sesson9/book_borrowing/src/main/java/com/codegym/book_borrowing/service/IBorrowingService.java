package com.codegym.book_borrowing.service;

import com.codegym.book_borrowing.model.Borrowing;

public interface IBorrowingService extends IGeneralService<Borrowing>{
    void checkAndeleteByBorrowedCode(String code);
}
