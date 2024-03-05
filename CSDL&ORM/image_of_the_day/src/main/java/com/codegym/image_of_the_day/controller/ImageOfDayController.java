package com.codegym.image_of_the_day.controller;

import com.codegym.image_of_the_day.model.Feedback;
import com.codegym.image_of_the_day.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        System.out.println(feedback);
        feedbackService.save(feedback);
        model.addAttribute("feedback", new Feedback());
        return "/feedback";
    }
    @GetMapping("/list")
    public String showListFeedback(Model model){
        List<Feedback> feedbackList = feedbackService.findAll();
        model.addAttribute("feedbackList", feedbackList);
        return "/list";
    }

    @GetMapping("/{id}/update")
    public String updateFeedback(@PathVariable int id){
        Feedback feedback = feedbackService.findById(id);
        feedbackService.save(feedback);
        return "redirect:/image/list";
    }
}
