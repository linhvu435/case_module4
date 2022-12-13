package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Product;
import com.example.case_modelu4_be.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;

//    @Override
//    public List<Product> findAll1() {
//        return (List<Product>) iProductRepo.findAll();
//    }
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return (Page<Product>) iProductRepo.findAll(pageable);
    }
    @Override
    public void delete(long id) {
        iProductRepo.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return iProductRepo.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepo.findByName(name);
    }
}
