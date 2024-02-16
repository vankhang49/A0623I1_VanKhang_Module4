package com.codegym.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private static final String[] engWord = {"product", "amount", "price", "status", "description"};
    private static final String[] vnWord = {"sản phẩm", "số lượng", "giá cả", "trạng thái", "mô tả"};
    @GetMapping("") // Phương thức này sẽ xử lý yêu cầu GET
    public String showForm(){
        return "dictionary";
    }

    @PostMapping("")
    public String checkWord(@RequestParam(name = "engWord") String inEngWord, Model model){
        for (int i = 0; i < engWord.length; i++){
            if (inEngWord.toLowerCase().equals(engWord[i])){
                String outVnWord = vnWord[i];
                model.addAttribute("engWord", inEngWord);
                model.addAttribute("vnWord", outVnWord);
            }
        }
        return "dictionary";
    }

}
