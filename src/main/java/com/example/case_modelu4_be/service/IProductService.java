package com.example.case_modelu4_be.service;

<<<<<<< HEAD
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
=======
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IProductService extends UserDetailsService {
>>>>>>> 7c25e567ae131435791e71d22a3086238e2b297c
}
