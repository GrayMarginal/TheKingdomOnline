package ru.kingdom.online.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    Integer score = new Integer(100);
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("score_users", score.toString());
        return "pages\\index";
    }
}
