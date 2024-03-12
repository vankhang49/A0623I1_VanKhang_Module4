package com.codegym.blog_app.controller;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.model.BlogForm;
import com.codegym.blog_app.model.Category;
import com.codegym.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "/category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(name = "category")Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create new category successfully!");
        return "redirect:/categories";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        Optional<Category> c = categoryService.findById(id);
        Category category = c.get();
        model.addAttribute("category",category);
        return "/category/edit";
    }
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes rd){
        categoryService.save(category);
        rd.addFlashAttribute("message", "Update successfully!");
        return "redirect:/categories";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id,RedirectAttributes redirectAttributes) {
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete successfully!");
        return "redirect:/categories";
    }
}
