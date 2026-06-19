package com.quickcart.ecommerce.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User
{
    @NotNull(message = "User name is required.")
    @Size(min = 2, max = 50, message = "User name must be within 2-50 characters")
    private String name;

    @NotNull(message = "Password field is required")
    @Size(min=5, max=15, message = "Password must be within 5-15 characters")
    private String password;

    private String email;
    private String mobile;

    public User()
    {}

    public User(String name, String password, String email, String mobile) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
