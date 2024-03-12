package com.codegym.blog_app.controller;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.model.BlogForm;
import com.codegym.blog_app.model.Category;
import com.codegym.blog_app.service.IBlogService;
import com.codegym.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @Value("${file-upload}")
    private String fileUpload;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){ return categoryService.findAll(); }
    @GetMapping("")
    public String showList(Model model) {
        Iterable<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "/blog/test";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blogForm",new BlogForm());
        return "/blog/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(name = "blogForm")BlogForm blogForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File destFile = new File(fileUpload + "images\\" + fileName);
            multipartFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setUser(blogForm.getUser());
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());
        blog.setCategory(blogForm.getCategory());
        blog.setImage(fileName);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        Blog b = blog.get();
        BlogForm blogForm = new BlogForm(b.getId(), b.getUser(), b.getCategory(), b.getTitle(), b.getContent());
        model.addAttribute("blogForm",blogForm);
        return "/blog/edit";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute(name = "blogForm")BlogForm blogForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File destFile = new File(fileUpload + fileName);
            if (!destFile.exists()){
                multipartFile.transferTo(destFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setId(blog.getId());
        blog.setUser(blogForm.getUser());
        blog.setCategory(blogForm.getCategory());
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());
        blog.setImage(fileName);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/view")
    public String showView(@PathVariable(name = "id") Long id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/view";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id,RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete successfully!");
        return "redirect:/blogs";
    }
}
