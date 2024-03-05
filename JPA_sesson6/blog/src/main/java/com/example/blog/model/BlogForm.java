package com.example.blog.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;
    private String title;
    private MultipartFile image;
    private String content;

    public BlogForm() {
    }

    public BlogForm(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public BlogForm(Long id, String title, MultipartFile image, String content) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
