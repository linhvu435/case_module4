package com.example.case_modelu4_be.service;


import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.model.Roles;
import com.example.case_modelu4_be.repository.IAccountRepo;
import com.example.case_modelu4_be.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUserName(username);
        List<Roles>roles = new ArrayList();
        roles.add(account.getRoles());
        if (account != null) {
            return new User(account.getUserName(), account.getPassWord(), roles);
        }
        return null;
    }
   public List<Account>getAll(){
        return (List<Account>) iAccountRepo.findAll();
   }
   public Account findByName(String userNane){
        return iAccountRepo.findByUserName(userNane);


    }
    public void setRoleByID(long id) {
        iAccountRepo.saveRole(id);
    }
   public Account save(Account account){
        return iAccountRepo.save(account);
   }
   public Account findByEmail(String email){
        return iAccountRepo.findByEmail(email);

   }
    public List<String> findRoleByUsername(String username){
        return iAccountRepo.findRoleByUsername(username);
    }
   public Optional<Account> findById(long id){
        return iAccountRepo.findById(id);
   }
}