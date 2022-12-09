package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Comment;
import com.example.case_modelu4_be.model.Evaluate;
import com.example.case_modelu4_be.repository.ICommentRepo;
import com.example.case_modelu4_be.repository.IEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentRepo iCommentRepo;
    @PostMapping
    public ResponseEntity save(@RequestBody Comment comment){
        iCommentRepo.save(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
