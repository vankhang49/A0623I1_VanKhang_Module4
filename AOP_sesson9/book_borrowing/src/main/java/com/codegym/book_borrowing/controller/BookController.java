package com.codegym.book_borrowing.controller;
import com.codegym.book_borrowing.model.Book;
import com.codegym.book_borrowing.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameBook){
        if (page < 0) {
            page = 0;
        }
        Page<Book> bookList = bookService.searchAllByName(nameBook, PageRequest.of(page, 5));
        if (bookList.isEmpty()) {
            model.addAttribute("message", "No Book found!");
        }
        model.addAttribute("page", page);
        model.addAttribute("nameSearch", nameBook);
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }
    @GetMapping("{id}/view")
    public String showInfo(@PathVariable("id") Integer id, Model model){
        Book book = bookService.findById(id).get();
        model.addAttribute("book", book);
        return "/book/view";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        Model book = model.addAttribute("book", new Book());
        return "/book/create";
    }
    @PostMapping("/create")
    public String createBook(@ModelAttribute(name = "book") Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Add new book successfully!");
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String showUpdate(Model model, @PathVariable("id") Integer id){
        Book book = bookService.findById(id).get();
        model.addAttribute("book", book);
        return "/book/edit";
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Update book successfully!");
        return "redirect:/books";
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        bookService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/books";
    }
}
