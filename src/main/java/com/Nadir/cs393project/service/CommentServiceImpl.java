package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.repo.CommentRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    public boolean save(Comment comment){
        try {
            commentRepo.save(comment);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }
}
