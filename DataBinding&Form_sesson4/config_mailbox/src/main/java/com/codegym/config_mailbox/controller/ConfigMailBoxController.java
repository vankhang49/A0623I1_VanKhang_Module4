package com.codegym.config_mailbox.controller;

import com.codegym.config_mailbox.model.MailboxConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/config-mailbox")
public class ConfigMailBoxController {
    private static final MailboxConfig mailboxConfig;
    private static final String [] languagesList = {"English", "Vietnamese", "Japanese", "Chinese"};
    private static final int[] pageSizeList = {5, 10, 15, 25, 50, 100};
    static {
        mailboxConfig = new MailboxConfig("English", 25, false, "Thor King, Asgard");
    }

    @GetMapping("")
    public String showDetailConfig(Model model){
        model.addAttribute("mailboxConfig", mailboxConfig);
        model.addAttribute("languageses", languagesList);
        model.addAttribute("pageSizes", pageSizeList);
        return "index";
    }
    @PostMapping("update")
    public String updateConfig(@ModelAttribute MailboxConfig config, Model model){
        model.addAttribute(config);
        model.addAttribute("languages", languagesList);
        model.addAttribute("pageSize", pageSizeList);
        return "index";
    }
}
