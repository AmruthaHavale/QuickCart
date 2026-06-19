package com.quickcart.ecommerce.Model;

public class User
{
    private String name;
    private String password;
    private String email;
    private String mobile;

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
