package com.quickcart.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/")
    public String home() {
        // This will render src/main/resources/templates/home.html
        return "home";
    }
}

