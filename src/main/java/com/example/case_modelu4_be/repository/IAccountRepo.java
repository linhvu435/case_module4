package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IAccountRepo extends CrudRepository<Account , Long> {
    Account findByUserName(String userName);
    Account findByEmail(String email);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "insert into roles values (:id,2)")
    void saveRole(@Param("id") long id);
    @Query(nativeQuery = true,value = "select roles.name from roles join account_roles on roles.id = account_roles.roles_id join account on account_roles.account_id_account = account.id_account where account.username =:username")
    List<String> findRoleByUsername(@Param("username") String username);

}
