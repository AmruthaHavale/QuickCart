package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController
{
    User user = new User("Anjali", "abcd", "anjali@gmail.com", "123456789");

    @RequestMapping("/")
    @ResponseBody
    public String userHome()
    {
        return "<strong><center>Welcome to User page.</center></strong><hr>";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String userRegister()
    {
        String display = "<strong><center>This is Registration Page for Users.</center></strong><hr>";

        display += "User Name: " + user.getName();
        display += "<br>Password: " + user.getPassword();
        display += "<br>Email: " + user.getEmail();
        display += "<br>Mobile Number: " + user.getMobile();
        return display;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin()
    {
        String display = "<Strong><center>This is Login Page for Users.</center></strong><hr>";
        display += "User Name: " + user.getName();
        display += "<br>Password: " + user.getPassword();

        return display;
    }

}
