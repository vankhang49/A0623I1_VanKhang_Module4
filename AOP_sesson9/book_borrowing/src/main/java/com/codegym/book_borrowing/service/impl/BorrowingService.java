package com.codegym.book_borrowing.service.impl;

import com.codegym.book_borrowing.aspect.BookStatusChangeAspect;
import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.model.Book;
import com.codegym.book_borrowing.model.Borrowing;
import com.codegym.book_borrowing.repository.IBorrowingRepository;
import com.codegym.book_borrowing.service.BookBorrowingException;
import com.codegym.book_borrowing.service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService implements IBorrowingService {
    @Autowired
    private IBorrowingRepository borrowingRepository;
    @Override
    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }

    @Override
    public Optional<Borrowing> findById(Integer id) {
        return borrowingRepository.findById(id);
    }

    @Override
    public void save(Borrowing borrowing) throws BookBorrowingException {
        CheckDuplicateCode(borrowing);
        checkBookAmount(borrowing);
        borrowingRepository.save(borrowing);
    }

    @Override
    public void remove(Integer id) throws BookBorrowingException {
        borrowingRepository.deleteById(id);
    }

    @Override
    public void checkAndeleteByBorrowedCode(String code) {
        Borrowing borrowing = borrowingRepository.searchByBorrowedCode(code);
        if (borrowing == null){
            throw new BookBorrowingException("Mã mượn sách không tồn tại, vui lòng nhập đúng mã sách bạn đã mượn!");
        } else {
            Book book = borrowing.getBook();
            AmountBook amountBook = book.getAmountBook();
            Integer amount = amountBook.getAmount();
            amountBook.setAmount(amount + 1);
            borrowingRepository.deleteById(borrowing.getId());
        }
    }

//    ******************************** //
    public void CheckDuplicateCode(Borrowing borrowing){
        String code = borrowing.getBorrowedCode();
        Borrowing br = borrowingRepository.searchByBorrowedCode(code);
        if (br != null){
            throw new BookBorrowingException("Mã mượn sách đã tồn tại, vui lòng tạo mã mới!");
        }
    }

    public void checkBookAmount(Borrowing borrowing){
        Book book = borrowing.getBook();
        AmountBook amountBook = book.getAmountBook();
        Integer amount = amountBook.getAmount();
        if (amount == 0){
            throw new BookBorrowingException("Sách đã hết hàng, rất xin lỗi vì sự cố này!");
        } else {
            amountBook.setAmount(amount - 1);
        }
    }
}
