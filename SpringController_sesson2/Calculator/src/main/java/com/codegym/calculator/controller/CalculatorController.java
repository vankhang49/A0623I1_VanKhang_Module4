package com.codegym.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("")
    public String showForm(){
        return "index";
    }
    @RequestMapping("calculate")
    public String calculate(@RequestParam("operand1") double op1,
                            @RequestParam("operand2") double op2,
                            @RequestParam("operator") String operator,
                            Model model){
        double result = 0;
        String message = null;
        switch (operator){
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if (op2 == 0){
                    message = "Division by 0 error!";
                } else {
                    result = op1 / op2;
                }
                break;
        }
        if (message != null){
            model.addAttribute("message", message);
        }
        model.addAttribute("operand1", op1);
        model.addAttribute("operand2", op2);
        model.addAttribute("result", result);
        return "index";
    }
}
