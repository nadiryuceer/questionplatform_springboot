package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.dto.TextUpdateDTO;
import com.Nadir.cs393project.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CommentController {
    public final String commentquestionreturnschema = "{\n    \"comment_id\": 0,\n    \"question_id\": 0\n}";
    public final String commentanswerreturnschema = "{\n    \"comment_id\": 0,\n    \"answer_id\": 0\n}";
    public final String votereturnschema = "{\n    \"votecount\": 0\n}";
    public final String successschema = "{\n    \"success\": true\n}";

    @Autowired
    CommentService commentService;

    @Operation( summary = "AddCommenttoQuestion.",
            description = "Adds comment under a specific question.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation" , content = @Content(examples = @ExampleObject(value = commentquestionreturnschema))),
            @ApiResponse(responseCode = "404", description = "question/user with provided id does not exist", content = @Content)
    })
    @PostMapping(path = "/questions/{qid}/comments")
    Map<String,Integer> addCommentforQuestion(@PathVariable("qid") int qid, @RequestBody QuestionCommentSaveDTO comment){
        return commentService.save(comment, qid);
    }

    @Operation( summary = "AddCommenttoAnswer.",
            description = "Adds comment under a specific answer.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation" , content = @Content(examples = @ExampleObject(value = commentanswerreturnschema))),
            @ApiResponse(responseCode = "404", description = "answer/user with provided id does not exist", content = @Content)
    })
    @PostMapping(path = "/answers/{answerid}/comments")
    Map<String,Integer> addCommentforAnswer(@PathVariable("answerid") int answerid, @RequestBody AnswerCommentSaveDTO comment){
        return commentService.save(comment, answerid);
    }

    @Operation( summary = "Upvote comment.",
            description = "Upvotes a specific comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation" , content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "comment with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/comments/{id}/upvote")
    public Map<String, Integer> upvoteComment(@PathVariable("id") int cid){
        return commentService.vote(cid, true);
    }

    @Operation( summary = "Downvote comment.",
            description = "Downvotes a specific comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation" , content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "comment with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/comments/{id}/downvote")
    public Map<String, Integer> downvoteComment(@PathVariable("id") int cid){
        return commentService.vote(cid, false);
    }

    @Operation( summary = "Delete comment.",
            description = "Deletes a specific comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = successschema))),
            @ApiResponse(responseCode = "404", description = "comment with provided id does not exist", content = @Content)
    })
    @DeleteMapping(value = "/comments/{id}")
    public Map<String,Boolean> delete(@PathVariable("id") int id){
        return commentService.delete(id);
    }

    @Operation( summary = "UpdatetextofComment.",
            description = "Updates the text inside comment.",
            tags = { "Comment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = successschema))),
            @ApiResponse(responseCode = "404", description = "comment with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/comments/{id}")
    public Map<String, Boolean> update(@PathVariable("id") int id, @RequestBody TextUpdateDTO txt){
        return commentService.update(id,txt.getTxt());
    }
}
