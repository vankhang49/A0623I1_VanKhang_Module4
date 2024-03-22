package com.codegym.book_borrowing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer id;
    @Column(name = "book_name")
    private String name;
    private String author;
    @Column(name = "book_des")
    private String bookDescription;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private AmountBook amountBook;

    public Book() {
    }

    public Book(String name, String author, String bookDescription) {
        this.name = name;
        this.author = author;
        this.bookDescription = bookDescription;
    }

    public Book(Integer id, String name, String author, String bookDescription) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.bookDescription = bookDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public AmountBook getAmountBook() {
        return amountBook;
    }

    public void setAmountBook(AmountBook amountBook) {
        this.amountBook = amountBook;
    }
}
