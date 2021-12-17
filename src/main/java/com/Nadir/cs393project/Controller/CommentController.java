package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Operation( summary = "AddCommenttoQuestion.",
            description = "Adds comment under a specific question.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "question with provided id does not exist")
    })
    @PostMapping(path = "/question/{id}/comment")
    Map<String,Integer> addCommentforQuestion(@PathVariable("id") int qid, @RequestBody QuestionCommentSaveDTO comment){
        comment.setQuestionid(qid);
        return commentService.save(comment);
    }

    @Operation( summary = "AddCommenttoAnswer.",
            description = "Adds comment under a specific answer.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "comment with provided id does not exist")
    })
    @PostMapping(path = "/answer/{id}/comment")
    Map<String,Integer> addCommentforAnswer(@PathVariable("id") int answerid, @RequestBody AnswerCommentSaveDTO comment){
        comment.setAnswerid(answerid);
        return commentService.save(comment);
    }

    @Operation( summary = "Vote comment.",
            description = "Votes a specific comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "comment with provided id does not exist")
    })
    @PutMapping(value = "/comment/{id}/vote")
    public Map<String, Integer> voteComment(@PathVariable("id") int cid){
        return commentService.vote(cid);
    }

    @Operation( summary = "Delete comment.",
            description = "Deletes a specific comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "comment with provided id does not exist")
    })
    @DeleteMapping(value = "/comment/{id}")
    public Map<String,Boolean> delete(@PathVariable("id") int id){
        return commentService.delete(id);
    }

    @Operation( summary = "UpdatetextofComment.",
            description = "Updates the text inside comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "comment with provided id does not exist")
    })
    @PutMapping(value = "/comment/{id}")
    public Map<String, Boolean> update(@PathVariable("id") int id, @RequestBody Map<String,String> txt){
        return commentService.update(id,txt.get("txt"));
    }
}
