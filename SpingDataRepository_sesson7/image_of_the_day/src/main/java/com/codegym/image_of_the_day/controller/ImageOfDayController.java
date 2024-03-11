package com.codegym.image_of_the_day.controller;

import com.codegym.image_of_the_day.model.Feedback;
import com.codegym.image_of_the_day.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/image")
public class ImageOfDayController {
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping("")
    public String showFormFeedBack(Model model){
        model.addAttribute("feedback", new Feedback());
        return "/feedback";
    }
    @PostMapping("/create")
    public String createNewFeedback(@ModelAttribute(name = "feedback") Feedback feedback, Model model){
        feedback.setDate(LocalDate.now());
        feedbackService.save(feedback);
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("message", "Add new comment");
        return "/feedback";
    }
    @GetMapping("/list")
    public String showListFeedback(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "authorSearch", defaultValue = "") String author){
        if (page < 0) {
            page = 0;
        }
        Page<Feedback> feedbackList = feedbackService.findAllByAuthorAndDate(author, LocalDate.now(), PageRequest.of(page, 5));
        if (feedbackList.isEmpty()) {
            model.addAttribute("message", "No customers found!");
        }
        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("authorSearch", author);
        return "/list";
    }

    @PostMapping("/{id}/update")
    public String updateFeedback(@PathVariable Long id, @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "authorSearch", defaultValue = "") String author,
                                 Model model) {
        if (page < 0) {
            page = 0;
        }
        Page<Feedback> feedbackList = feedbackService.findAllByAuthorAndDate(author, LocalDate.now(), PageRequest.of(page, 5));
        Optional<Feedback> f = feedbackService.findById(id);
        if (f.isPresent()) {
            Feedback feedback = f.get();
            feedbackService.save(feedback);
        }
        if (feedbackList.isEmpty()) {
            model.addAttribute("message", "No customers found!");
        }
        model.addAttribute("authorSearch", author);
        model.addAttribute("feedbackList", feedbackList);
        return "/list";
    }
}
