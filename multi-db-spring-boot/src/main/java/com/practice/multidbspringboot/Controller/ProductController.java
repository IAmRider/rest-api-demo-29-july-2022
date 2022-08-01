package com.practice.multidbspringboot.Controller;

import com.practice.multidbspringboot.dao.product.ProductRepository;
import com.practice.multidbspringboot.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productService;

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, savedProduct != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}