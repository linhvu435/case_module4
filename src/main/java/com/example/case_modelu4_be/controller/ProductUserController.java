package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Product;
import com.example.case_modelu4_be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/products")
public class ProductUserController {
    @Autowired
    IProductService iProductService;

    @GetMapping
    public Page<Product> getAll(@RequestParam(defaultValue = "0") int page) {
        return iProductService.getAll(PageRequest.of(page, 12));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Iterable<Product>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iProductService.findByName(name), HttpStatus.OK);
    }
}

