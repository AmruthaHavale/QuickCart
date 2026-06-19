package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController
{
    private List<User> userList = new ArrayList<>(List.of(
            new User("Anjali", "abcd","anjali@gmail.com",123456789)
            ));

    @RequestMapping("/user")
    public String userHome()
    {
        return "userHome";
    }

    @GetMapping("/user/register")
    public String userRegister(User user)
    {
        return "register";
    }

    @PostMapping("/user/register")
    public String userregister(User user)
    {
        userList.add(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin()
    {
        return "ADBS";
    }

}
