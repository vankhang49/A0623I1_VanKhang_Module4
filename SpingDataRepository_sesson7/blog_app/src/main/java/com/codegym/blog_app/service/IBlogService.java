package com.codegym.blog_app.service;


import com.codegym.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllByTitleAndCategory(String title, String categoryName, Pageable pageable);
    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
