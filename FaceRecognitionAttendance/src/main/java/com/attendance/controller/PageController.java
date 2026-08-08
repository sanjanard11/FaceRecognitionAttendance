package com.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/register-face")
    public String registerFacePage() {
        return "forward:/register-face.html";
    }
}