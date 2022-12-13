package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Evaluate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IEvaluate extends CrudRepository<Evaluate, Long> {

 @Query(nativeQuery = true, value = "SELECT avg(number_star) as 'rating' from evaluate where number_star > 0; Result: rating ")
    public Evaluate rating (@Param("rating") double rating );

}
