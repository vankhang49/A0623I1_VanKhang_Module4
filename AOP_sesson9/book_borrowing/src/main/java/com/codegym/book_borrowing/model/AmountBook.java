package com.codegym.book_borrowing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "amount_book")
public class AmountBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "amount_id")
    private Integer id;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "book_id")
    private Book book;
    private Integer amount;

    public AmountBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
