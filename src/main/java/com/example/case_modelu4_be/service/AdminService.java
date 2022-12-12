package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;
    public List<Account> findUser()
    {
        return iAdminRepo.findUser();
    }
    public List<Account> findShop(){
        return iAdminRepo.findShop();
    }
    public void deleteAccount(long id){
        iAdminRepo.setStatus(id);
    }
}
