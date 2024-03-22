package com.codegym.book_borrowing.aspect;

import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.model.Borrowing;
import com.codegym.book_borrowing.service.BookBorrowingException;
import com.codegym.book_borrowing.service.IBookService;
import com.codegym.book_borrowing.service.IBorrowingService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class BookStatusChangeAspect {
    private static final Logger logger = LoggerFactory.getLogger(BookStatusChangeAspect.class);
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowingService borrowingService;
    @AfterReturning("execution(* com.codegym.book_borrowing.controller.BookController.*(..)) ")
    public void logBookActions(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        switch (methodName) {
            case "createBook":
                logCreateBookAction();
                break;
            case "updateBook":
                logUpdateBookAction();
                break;
            case "deleteBook":
                logDeleteBookAction();
                break;
        }
    }
    private void logCreateBookAction() {
        logger.info("Tạo mới sách");
    }
    private void logUpdateBookAction(){
        logger.info("Cập nhật thông tin sách");
    }
    private void logDeleteBookAction(){
        logger.info("Xoá sách ra khỏi thư viện");
    }
    @AfterReturning("execution(* com.codegym.book_borrowing.controller.BookController.*(..)) ")
    public void logBorrowActions(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        switch (methodName) {
            case "borrowBook":
                logBorrowBookAction(args);
                break;
            case "giveBookBack":
                logGiveBookBackAction(args);
                break;
        }
    }
    private void logBorrowBookAction(Object[] args) {
        Integer id = (Integer) args[0];
        String code = (String) args[1];
        AmountBook amountBook = bookService.findById(id).get().getAmountBook();
        if (amountBook.getAmount() == 0) {
            logger.error("Bạn không thể mượn cuốn sách này, sách đã hết hàng!");
        } else {
            logger.info("Mã sách " + id + " được mượn thành công!");
        }
    }
    private void logGiveBookBackAction(Object[] args) {
        String code = (String) args[0];
        logger.info("Mã sách: " + code);
    }

}
