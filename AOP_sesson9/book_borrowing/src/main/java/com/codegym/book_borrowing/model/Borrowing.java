package com.codegym.book_borrowing.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "borrowings")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrowing_id")
    private Integer id;
    @Column(name = "borrowed_code", unique = true)
    private String borrowedCode;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "borrowed_date")
    private LocalDateTime date;

    public Borrowing() {
    }

    public Borrowing(String borrowedCode, Book book, LocalDateTime date) {
        this.borrowedCode = borrowedCode;
        this.book = book;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowedCode() {
        return borrowedCode;
    }

    public void setBorrowedCode(String borrowedCode) {
        this.borrowedCode = borrowedCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book books) {
        this.book = book;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
