package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Operation( summary = "Get all questions.",
            description = "Returns all questions.",
            tags = { "Question" })
    @GetMapping(value = "/question")
    public List<QuestionGetAllDTO> getAll(@RequestBody(required = false) Map<String, String[]> tags){
        return (tags==null) ? questionService.getAll() : questionService.getWithTags(tags.get("tags"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "question with provided id does not exist", content = @Content(schema = @Schema(hidden = true)))
    })
    @Operation( summary = "Get specified question with extended details.",
            description = "Returns the user, complete text, comments together with their users" +
                    "and answers of both question and its comments with their users.",
            tags = { "Question" })
    @GetMapping(value = "/question/{id}")
    public QuestionDTO getByIdWithDetails(@PathVariable("id") int id){
        return questionService.getByIdWithDetails(id);
    }

    @Operation( summary = "Save question.",
            description = "Saves a new question.",
            tags = { "Question" })
    @PostMapping(value = "/question")
    public int save(@RequestBody QuestionSaveDTO data){
        return questionService.save(data);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "question with provided id does not exist")
    })
    @Operation( summary = "Vote question.",
            description = "Votes a specific question.",
            tags = { "Question" })
    @PutMapping(value = "/question/{id}/vote")
    public Map<String, Integer> voteQuestion(@PathVariable("id") int qid){
        return questionService.vote(qid);
    }
}
