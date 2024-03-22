package com.codegym.feed_back.controller;

import com.codegym.feed_back.model.Feedback;
import com.codegym.feed_back.service.BadWordFeedbackException;
import com.codegym.feed_back.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping("")
    public String showFormFeedBack(Model model){
        model.addAttribute("feedback", new Feedback());
        return "/feedback";
    }
    @PostMapping("/create")
    public String createNewFeedback(@ModelAttribute(name = "feedback") Feedback feedback, Model model) throws BadWordFeedbackException {
        feedback.setDate(LocalDateTime.now());
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
        Page<Feedback> feedbackList = feedbackService.findAllByAuthorAndDate(author, LocalDateTime.now(), PageRequest.of(page, 5));
        if (feedbackList.isEmpty()) {
            model.addAttribute("message", "No customers found!");
        }
        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("authorSearch", author);
        model.addAttribute("page", page);
        return "/list";
    }

    @PostMapping("/{id}/update")
    public String updateFeedback(@PathVariable Long id, @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "authorSearch", defaultValue = "") String author,
                                 Model model) throws BadWordFeedbackException {
        if (page < 0) {
            page = 0;
        }
        Page<Feedback> feedbackList = feedbackService.findAllByAuthorAndDate(author, LocalDateTime.now(), PageRequest.of(page, 5));
        Optional<Feedback> f = feedbackService.findById(id);
        if (f.isPresent()) {
            Feedback feedback = f.get();
            feedback.setVotes(feedback.getVotes() + 1);
            feedbackService.save(feedback);
        }
        if (feedbackList.isEmpty()) {
            model.addAttribute("message", "No customers found!");
        }
        model.addAttribute("authorSearch", author);
        model.addAttribute("feedbackList", feedbackList);
        return "redirect:/feedbacks/list?page=" + page + "&authorSearch=" + author;
    }
    @ExceptionHandler(BadWordFeedbackException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/error");
    }
}
