package com.codegym.blog_app.service.impl;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.repository.IBlogRepository;
import com.codegym.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTitleAndCategory(String title, String categoryName, Pageable pageable) {
        return blogRepository.searchAllByTitleContainingAndCategoryCategoryNameContaining(title, categoryName, pageable);
    }

    @Override
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return blogRepository.searchAllByTitleContaining(title, pageable);
    }
}
