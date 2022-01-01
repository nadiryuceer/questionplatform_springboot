package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Exception.AnswerNotFoundException;
import com.Nadir.cs393project.Exception.CommentNotFoundException;
import com.Nadir.cs393project.Exception.QuestionNotFoundException;
import com.Nadir.cs393project.Exception.UserNotFoundException;
import com.Nadir.cs393project.Mapper.AnswerCommentSaveMapper;
import com.Nadir.cs393project.Mapper.QuestionCommentSaveMapper;
import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.CommentRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    AnswerRepo answerRepo;

    public Map<String,Integer> save(QuestionCommentSaveDTO dto, int qid){
        questionRepo.findById(qid).orElseThrow(QuestionNotFoundException::new);
        userRepo.findById(dto.getUserid()).orElseThrow(UserNotFoundException::new);
        CommentforQuestion comment = QuestionCommentSaveMapper.INSTANCE.createCommentfromDTO(dto,qid,questionRepo,userRepo);
        comment.getQuestion().addComment(comment);
        comment.getUser().addComment(comment);
        commentRepo.save(comment);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("comment_id",comment.getId());
        ids.put("question_id", comment.getQuestion().getId());
        return ids;
    }
    public Map<String,Integer> save(AnswerCommentSaveDTO dto, int answerid){
        answerRepo.findById(answerid).orElseThrow(AnswerNotFoundException::new);
        userRepo.findById(dto.getUserid()).orElseThrow(UserNotFoundException::new);
        CommentforAnswer comment = AnswerCommentSaveMapper.INSTANCE.createCommentfromDTO(dto, answerid,answerRepo,userRepo);
        comment.getAnswer().addComment(comment);
        comment.getUser().addComment(comment);
        commentRepo.save(comment);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("comment_id",comment.getId());
        ids.put("answer_id", comment.getAnswer().getId());
        return ids;
    }
    public Map<String, Integer> vote(int id, boolean isupvote){
        int votecount;
        try{
            votecount = commentRepo.getById(id).getVotes();
        } catch(Exception e){
            throw new CommentNotFoundException();
        }
        if (isupvote) {
            commentRepo.vote(id, ++votecount);
        } else {
            commentRepo.vote(id, --votecount);
        }
        return Collections.singletonMap("votecount",votecount);
    }

    public Map<String,Boolean> delete(int id){
        try{
            commentRepo.deleteById(id);
        } catch(Exception e){
            throw new CommentNotFoundException();
        }
        return Collections.singletonMap("success", true);
    }
    public Map<String,Boolean> update(int id, String txt){
        commentRepo.findById(id).orElseThrow(CommentNotFoundException::new);
        commentRepo.update(id,txt);
        return Collections.singletonMap("success",true);
    }
}
