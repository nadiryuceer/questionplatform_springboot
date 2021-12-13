package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(path = "/question/{id}/comment")
    Map<String,Integer> addCommentforQuestion(@PathVariable("id") int qid, @RequestBody QuestionCommentSaveDTO comment){
        comment.setQuestionid(qid);
        return commentService.save(comment);
    }

    @PostMapping(path = "/answer/{id}/comment")
    Map<String,Integer> addCommentforAnswer(@PathVariable("id") int answerid, @RequestBody AnswerCommentSaveDTO comment){
        comment.setAnswerid(answerid);
        return commentService.save(comment);
    }
    @PutMapping(value = "/comment/{id}/vote")
    public Map<String, Integer> voteComment(@PathVariable("id") int cid){
        return commentService.vote(cid);
    }
    @DeleteMapping(value = "/comment/{id}")
    public Map<String,Boolean> delete(@PathVariable("id") int id){
        return commentService.delete(id);
    }
}
