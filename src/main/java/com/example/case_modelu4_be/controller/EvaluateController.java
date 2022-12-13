package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Evaluate;
import com.example.case_modelu4_be.repository.IEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/stars")
public class EvaluateController {
    @Autowired
    IEvaluate iEvaluate;
    @PostMapping
    public ResponseEntity save(@RequestBody Evaluate evaluate){
        iEvaluate.save(evaluate);
        return new ResponseEntity(HttpStatus.OK);
    }



}
