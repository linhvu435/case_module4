package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAdminRepo extends CrudRepository<Account,Long> {
    @Query(nativeQuery = true,value = "select * from account where id_role = 2; ")
    List<Account> findUser();
    @Query(nativeQuery = true,value = "select * from account where id_role = 3; ")
    List<Account> findShop();
    @Query(nativeQuery = true,value = "UPDATE account SET status = 0 WHERE id = :id;")
    void setStatus(long id);

}
