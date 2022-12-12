package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Product;
import com.example.case_modelu4_be.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public Iterable<Product> showAll() {
        return productRepo.findAll();
    }
    public Product findById(long id){
        return  productRepo.findById(id).get();
    }
}
