package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.*;
import com.example.case_modelu4_be.repository.IAccountRepo;
import com.example.case_modelu4_be.repository.IBillDetailRepo;
import com.example.case_modelu4_be.repository.IBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartService {
    @Autowired
    IBillDetailRepo iBillDetailRepo;

    @Autowired
    IBillRepo iBillRepo;
    @Autowired
    IAccountRepo iAccountRepo;

    public void savePrice(List<Product> products){
        double sum = 0;

        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getAmount()*products.get(i).getPrice();
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Date date = new Date();
        Account account = iAccountRepo.findByUserName(userDetails.getUsername());
        Bill bill = new Bill(sum, date, account);
        iBillRepo.save(bill);
        for (Product i : products) {
            save(i, bill);

        }
    }
    public void save(Product product, Bill bill){
        BillDetail b = new BillDetail(product.getAmount(), product, bill);
        iBillDetailRepo.save(b);
    }

}
