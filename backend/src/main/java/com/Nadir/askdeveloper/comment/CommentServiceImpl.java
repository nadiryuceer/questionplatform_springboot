package com.Nadir.askdeveloper.comment;

import com.Nadir.askdeveloper.Exception.AnswerNotFoundException;
import com.Nadir.askdeveloper.Exception.CommentNotFoundException;
import com.Nadir.askdeveloper.Exception.QuestionNotFoundException;
import com.Nadir.askdeveloper.Exception.UserNotFoundException;
import com.Nadir.askdeveloper.comment.dto.AnswerCommentSaveDTO;
import com.Nadir.askdeveloper.comment.dto.QuestionCommentSaveDTO;
import com.Nadir.askdeveloper.answer.AnswerRepo;
import com.Nadir.askdeveloper.question.QuestionRepo;
import com.Nadir.askdeveloper.user.UserRepo;
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

    public Map<String,Integer> save(QuestionCommentSaveDTO dto){
        questionRepo.findById(dto.getQuestionid()).orElseThrow(QuestionNotFoundException::new);
        userRepo.findByUserName(dto.getUsername()).orElseThrow(UserNotFoundException::new);
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
        answerRepo.findById(dto.getAnswerid()).orElseThrow(AnswerNotFoundException::new);
        userRepo.findByUserName(dto.getUsername()).orElseThrow(UserNotFoundException::new);
        CommentforAnswer comment = AnswerCommentSaveMapper.INSTANCE.createCommentfromDTO(dto, answerRepo,userRepo);
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
    public Map<String,Boolean> update(int id, String text){
        commentRepo.findById(id).orElseThrow(CommentNotFoundException::new);
        commentRepo.update(id,text);
        return Collections.singletonMap("success",true);
    }
}
