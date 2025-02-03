package org.sooperbill.controller;

import java.util.List;

import org.sooperbill.model.Product;
import org.sooperbill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")

public class ProductController {
	
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
    	System.out.println(product);
        return productService.saveProduct(product);
    }
    
    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
