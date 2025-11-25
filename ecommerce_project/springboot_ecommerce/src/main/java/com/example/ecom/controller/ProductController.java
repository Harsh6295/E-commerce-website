package com.example.ecom.controller;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }
    @GetMapping({"/", "/products"})
    public String list(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}
