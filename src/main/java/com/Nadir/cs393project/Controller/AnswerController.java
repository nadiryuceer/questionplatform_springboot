package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Operation( summary = "AddAnswertoQuestion.",
            description = "Adds answer under a specific question.",
            tags = { "Answer" })
    @PostMapping(path = "/question/{id}/answer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "question with provided id does not exist")
    })
    public Map<String,Integer> addAnswertoQuestion(@PathVariable("id") int qid, @RequestBody AnswerSaveDTO answerSaveDTO){
        answerSaveDTO.setQid(qid);
        return answerService.save(answerSaveDTO);
    }
    @Operation( summary = "Vote answer.",
            description = "Votes a specific answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "answer with provided id does not exist")
    })
    @PutMapping(value = "/answer/{id}/vote")
    public Map<String, Integer> voteAnswer(@PathVariable("id") int aid){
        return answerService.vote(aid);
    }

    @Operation( summary = "UpdatetextofAnswer.",
            description = "Updates the text inside answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"), @ApiResponse(responseCode = "404", description = "answer with provided id does not exist")
    })
    @PutMapping(value = "/answer/{id}")
    public Map<String, Boolean> update(@PathVariable("id") int id, @RequestParam Map<String,String> txt){
        return answerService.update(id,txt.get("txt"));
    }
}
