package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
