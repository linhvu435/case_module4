package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
//    List<Product> findAll();
    Page<Product> getAll (Pageable pageable);
    void delete(long id);
    Product findById(long id);
    Product save(Product product);
    List<Product> findByName(String name);
}
