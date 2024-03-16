package com.codegym.user_management.controller;

import com.codegym.user_management.model.User;
import com.codegym.user_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "firstnameSearch", defaultValue = "") String firstname,
                           @RequestParam(value = "page", defaultValue = "0") int page){
        Page<User> userList = userService.findAllByFirstname(firstname, PageRequest.of(page, 5));
        if (userList.isEmpty()) {

        }
        model.addAttribute("listUser", userList);
        model.addAttribute("firstnameSearch", firstname);
        return "/list";
    }

    @GetMapping("/create")
    public String showPageCreate(Model model) {
        User user = new User();

        model.addAttribute("user", user);
        return "/create";
    }

    @PostMapping("/create")
    public String addUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
                             RedirectAttributes redirect, Model model) {
//        new StudentValidation().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        userService.save(user);
        redirect.addFlashAttribute("message", "Add new successfully!");
//       Redirect chuyển về trang list
        return "redirect:/users";
    }

    @GetMapping("/{idUpdate}/update")
    public String showPageUpdate(Model model, @PathVariable(name = "idUpdate") Integer id) {
        Optional<User> u = userService.findById(id);
        User user = u.get();
        model.addAttribute("user", user);
        return "/edit";
    }

    @PostMapping("/update")
    public String updateUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
                             RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        userService.save(user);
        redirect.addFlashAttribute("message", "Update successfully!");
//       Redirect chuyển về trang list
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idUserDelete") Integer id) {
        userService.deleteById(id);
        return "redirect:/students";
    }
}
