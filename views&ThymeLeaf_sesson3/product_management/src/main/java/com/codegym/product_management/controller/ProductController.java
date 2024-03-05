package com.codegym.product_management.controller;

import com.codegym.product_management.model.Product;
import com.codegym.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("list", productList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(Product product, BindingResult bindingResult,
                                RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "create";
        }
        productService.save(product);
        redirect.addFlashAttribute("message", "Added successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirect){
        boolean flag = productService.remove(id);
        if (flag){
            redirect.addFlashAttribute("message", "Delete product successfully!");
        }
        return "redirect:/products";
    }
}
