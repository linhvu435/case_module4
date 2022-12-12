package com.example.case_modelu4_be.controller;
import com.example.case_modelu4_be.model.Product;
import com.example.case_modelu4_be.service.CartService;
import com.example.case_modelu4_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class APICart {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;
    @GetMapping
    public ResponseEntity<Iterable<Product>> show() {
        return new ResponseEntity<>(productService.showAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveCart(@RequestBody List<Product> cart){
        cartService.savePrice(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
