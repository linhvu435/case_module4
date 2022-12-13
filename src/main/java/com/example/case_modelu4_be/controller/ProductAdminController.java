package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Product;
import com.example.case_modelu4_be.model.Shop;
import com.example.case_modelu4_be.repository.IProductRepo;
import com.example.case_modelu4_be.service.IProductService;
import com.example.case_modelu4_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/products")
public class ProductAdminController {

    @Autowired
    IProductService iProductService;

//    @Value("${uploadPart}")
//    String uploadPart;

//    @GetMapping
//    public ResponseEntity<List<Product>> products() {
//        return new ResponseEntity<>(iProductService.findAll(), HttpStatus.OK);
//    }

    @GetMapping
    public Page<Product> getAll(@RequestParam(defaultValue = "0") int page) {
        return iProductService.getAll(PageRequest.of(page, 12));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
//        String name = upImg.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(upImg.getBytes(), new File(uploadPart + name));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        product.setImg("/img/" + name);

        iProductService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iProductService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        iProductService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit( @RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        iProductService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<Iterable<Product>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iProductService.findByName(name), HttpStatus.OK);
    }
}

