package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product,Long> {
    // câu 11
}
