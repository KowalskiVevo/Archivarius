package ru.hostco.archivarius.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
