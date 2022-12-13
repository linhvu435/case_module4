package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepo extends CrudRepository<Comment, Long> {
}
