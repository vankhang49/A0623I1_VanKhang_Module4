package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.BlogForm;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String showList(Model model)
    {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model)
    {
        model.addAttribute("blogForm",new BlogForm());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(name = "blogForm")BlogForm blogForm, RedirectAttributes redirectAttributes)
    {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());
        blog.setImage(fileName);
        blogService.save(blog);
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model)
    {
        Blog blog = blogService.findById(id);
        BlogForm blogForm = new BlogForm(blog.getId(), blog.getTitle(), blog.getContent());
        model.addAttribute("blogForm",blogForm);
        return "/edit";
    }
    @GetMapping("/{id}/view")
    public String showView(@PathVariable(name = "id") Long id, Model model)
    {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/view";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id,RedirectAttributes redirectAttributes)
    {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("success","you have successfully deleted a product !!!");
        return "redirect:/blogs";
    }



}
