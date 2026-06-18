package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.Products;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String products()
    {
        String display = "<Strong>Products List:</Strong><hr><br>";

        for (Products product:productsList)
        {
            display += "ID: " + product.getId() +" | Name: " + product.getName() + " | Price: " + product.getPrice() + "<br>";
        }

        return display;
    }

    @RequestMapping("/list/{id}")
    @ResponseBody
    public String productByID(@PathVariable int id)
    {
        String display = "<strong>Product By id</strong><hr><br>";

        for(Products products: productsList)
        {
            if(products.getId() == id) {
                display += "Product ID: " + id + "<br>Product Name: " + products.getName() + "<br>Product Price: " + products.getPrice();
                return display;
            }
        }
        display += "Product with ID " + id + " Not Found in Product List";
        return display;
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
