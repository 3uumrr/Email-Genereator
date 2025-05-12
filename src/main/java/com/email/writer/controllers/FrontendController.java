package com.email.writer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping("/")
    public String redirect() {
        return "forward:/index.html";
    }
}

