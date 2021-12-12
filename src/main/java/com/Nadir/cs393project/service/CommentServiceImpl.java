package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Mapper.QuestionCommentSaveMapper;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.repo.CommentRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    QuestionRepo questionRepo;
    public Map<String,Integer> save(QuestionCommentSaveDTO dto){
        CommentforQuestion comment = QuestionCommentSaveMapper.INSTANCE.createCommentfromDTO(dto,questionRepo,userRepo);
        comment.getQuestion().addComment(comment);
        comment.getUser().addComment(comment);
        commentRepo.save(comment);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("comment_id",comment.getId());
        ids.put("question_id", comment.getQuestion().getId());
        return ids;
    }
}
