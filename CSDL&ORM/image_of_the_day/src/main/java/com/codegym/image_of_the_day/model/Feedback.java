package com.codegym.image_of_the_day.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int point;
    private String author;
    private String comment;
    private LocalDate date;
    private int votes;

    public Feedback() {
    }

    public Feedback(Integer id, int point, String author, String comment, LocalDate date, int votes) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.comment = comment;
        this.date = date;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                ", like=" + votes +
                '}';
    }
}
