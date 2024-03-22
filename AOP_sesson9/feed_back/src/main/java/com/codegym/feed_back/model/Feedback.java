package com.codegym.feed_back.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feedback_id")
    private Long id;
    private int point;
    private String author;
    private String comment;

    private LocalDateTime date;
    private int votes;

    public Feedback() {
    }

    public Feedback(Long id, int point, String author, String comment, LocalDateTime date, int votes) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.comment = comment;
        this.date = date;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", point=" + point +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", votes=" + votes +
                '}';
    }
}
