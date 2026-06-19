package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.Model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController
{
    private List<Products> productsList = List.of(
            new Products(1,"Milk", 20),
            new Products(2, "Bread", 40),
            new Products(3, "Cereals", 30),
            new Products(4,"Tomato", 30),
            new Products(5,"Onion", 30)
    );

    @RequestMapping("/list")
    public String products(Model model)
    {
        model.addAttribute("products", productsList);
        return "productsList";
    }

    @RequestMapping("/list/{id}")
    public String productByID(@PathVariable int id, Model model)
    {
        for(Products products: productsList)
        {
            if(products.getId() == id) {
                model.addAttribute("id", id);
                model.addAttribute("name", products.getName());
                model.addAttribute("price", products.getPrice());
                return "productByID";
            }
        }
        model.addAttribute("id", id);
        return "productNotFound";
    }

    @RequestMapping("/price/{name}")
    @ResponseBody
    public String priceOfProduct(@PathVariable String name)
    {
        String display = "<Strong>The Price of a Particular Product</strong><hr><br>";

        for(Products products : productsList)
        {
            if(products.getName().equalsIgnoreCase(name))
            {
                display += "The price of <strong>" + name + "</strong> is <strong>" + products.getPrice() + "</strong>";
                return display;
            }
        }
        display += "Product Named <strong>" + name + "</strong> not found.";
        return display;
    }
}
