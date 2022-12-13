package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentRepo extends CrudRepository<Comment, Long> {

}
