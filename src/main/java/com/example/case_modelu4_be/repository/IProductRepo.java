package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM product where name like concat('%',:name,'%')")
    List<Product> findByName(@Param("name") String name);

}
