package com.codegym.currency_conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/conversion")
public class conversionController {
    @GetMapping("") // Phương thức này sẽ xử lý yêu cầu GET
    public String showForm() {
        return "conversion"; // Trả về trang chứa form để hiển thị
    }
    @PostMapping("")
    public String conversion (@RequestParam(name = "usd") String inputUsd, @RequestParam(name = "rate") String inputRate, Model model){
        double rate = Double.parseDouble(inputRate);
        double usd = Double.parseDouble(inputUsd);
        double vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
