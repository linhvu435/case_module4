package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.BillDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IBillDetailRepo extends CrudRepository<BillDetail,Long> {
    @Query(nativeQuery = true,value = "insert into bill_detail (amount,id_bill,id_product) values (?1,?2,?3)")
    void pushToBillDetail(int mount,long id_bill,long id_product);
}
