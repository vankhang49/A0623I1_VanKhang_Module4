package com.codegym.book_borrowing.controller;

import com.codegym.book_borrowing.aspect.BookStatusChangeAspect;
import com.codegym.book_borrowing.model.AmountBook;
import com.codegym.book_borrowing.model.Book;
import com.codegym.book_borrowing.model.Borrowing;
import com.codegym.book_borrowing.service.BookBorrowingException;
import com.codegym.book_borrowing.service.IBookService;
import com.codegym.book_borrowing.service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/borrowing")
public class BorrowingController {
    @Autowired
    private IBorrowingService borrowingService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private BookStatusChangeAspect bookStatusChangeAspect;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("borrowList", borrowingService.findAll());
        return "/borrowing/list";
    }
    @PostMapping("/create")
    public String borrowBook(@RequestParam(name = "id") Integer id, @RequestParam(name = "code") String code,
                             RedirectAttributes redirectAttributes)  throws BookBorrowingException  {
        Book book = bookService.findById(id).get();
        LocalDateTime date = LocalDateTime.now();
        Borrowing borrowing = new Borrowing(code, book, date);
        borrowingService.save(borrowing);
        redirectAttributes.addFlashAttribute("message", "Mượn thành công!");
        return "redirect:/books";
    }
    @GetMapping("/delete")
    public String showGiveBack(){
        return "/borrowing/giveBack";
    }
    @PostMapping("/delete")
    public String giveBookBack(@RequestParam(name = "code") String code) throws BookBorrowingException {
        borrowingService.checkAndeleteByBorrowedCode(code);
        return "redirect:/books";
    }
    @ExceptionHandler(BookBorrowingException.class)
    public String handleException(){
        return "/error";
    }
}
