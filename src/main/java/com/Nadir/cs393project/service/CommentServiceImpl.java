package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Exception.CommentNotFoundException;
import com.Nadir.cs393project.Mapper.AnswerCommentSaveMapper;
import com.Nadir.cs393project.Mapper.QuestionCommentSaveMapper;
import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.CommentRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    @Autowired
    AnswerRepo answerRepo;

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
    public Map<String,Integer> save(AnswerCommentSaveDTO dto){
        CommentforAnswer comment = AnswerCommentSaveMapper.INSTANCE.createCommentfromDTO(dto,answerRepo,userRepo);
        comment.getAnswer().addComment(comment);
        comment.getUser().addComment(comment);
        commentRepo.save(comment);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("comment_id",comment.getId());
        ids.put("answer_id", comment.getAnswer().getId());
        return ids;
    }
    public Map<String, Integer> vote(int id){
        int votecount;
        try{
            votecount = commentRepo.getById(id).getVotes();
        } catch(Exception e){
            throw new CommentNotFoundException();
        }
        commentRepo.vote(id, ++votecount);
        return Collections.singletonMap("votecount",votecount);
    }

    public Map<String,Boolean> delete(int id){
        try{
            commentRepo.getById(id);
        } catch(Exception e){
            throw new CommentNotFoundException();
        }
        commentRepo.deleteById(id);
        return Collections.singletonMap("success", true);
    }
    public Map<String,Boolean> update(int id, String txt){
        try{
            commentRepo.getById(id);
        }catch (Exception e){
            throw new CommentNotFoundException();
        }
        commentRepo.update(id,txt);
        return Collections.singletonMap("success",true);
    }
}
