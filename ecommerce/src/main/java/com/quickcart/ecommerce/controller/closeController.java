package com.quickcart.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class closeController
{
    @GetMapping("/close")
    public String close()
    {
        return "closing";
    }
}
