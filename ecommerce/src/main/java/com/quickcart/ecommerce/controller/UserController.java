package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.Model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
            new User("Anjali", "abcd","anjali@gmail.com","1234567890")
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
    public String userregister(@Valid User user, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "register";
        }
        userList.add(user);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String userLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/user/login")
    public String userLogin(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        return "redirect:/home";
    }


}
