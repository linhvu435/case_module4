package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface IBillRepo extends CrudRepository<Bill,Long> {
    @Query(nativeQuery = true,value = "insert into Bill (date,total_price) values (?1,?2)")
    void pushToBill(Date date,double price);
    @Query(nativeQuery = true,value = "SELECT MAX(id)\n" + "FROM bill")
    long maxId();
}
