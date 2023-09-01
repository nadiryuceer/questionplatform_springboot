package com.Nadir.askdeveloper.Controller;

import com.Nadir.askdeveloper.dto.AnswerSaveDTO;
import com.Nadir.askdeveloper.dto.TextUpdateDTO;
import com.Nadir.askdeveloper.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AnswerController {
    public final String answerquestionreturnschema = "{\n    \"answer_id\": 0,\n    \"question_id\": 0\n}";
    public final String votereturnschema = "{\n    \"votecount\": 0\n}";
    public final String successschema = "{\n    \"success\": true\n}";

    @Autowired
    AnswerService answerService;

    @Operation( summary = "AddAnswertoQuestion.",
            description = "Adds answer under a specific question.",
            tags = { "Answer" })
    @PostMapping(path = "/questions/{qid}/answers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful save", content = @Content(examples = @ExampleObject(value = answerquestionreturnschema))),
            @ApiResponse(responseCode = "404", description = "question/user with provided id does not exist", content = @Content)
    })
    public Map<String,Integer> addAnswertoQuestion(@PathVariable("qid") int qid, @RequestBody AnswerSaveDTO answerSaveDTO){
        return answerService.save(answerSaveDTO, qid);
    }
    @Operation( summary = "Upvote answer.",
            description = "Upvotes a specific answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "answer with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/answers/{id}/upvote")
    public Map<String, Integer> upvoteAnswer(@PathVariable("id") int aid){
        return answerService.vote(aid,true);
    }

    @Operation( summary = "Downvote answer.",
            description = "Downvotes a specific answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "answer with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/answers/{id}/downvote")
    public Map<String, Integer> downvoteAnswer(@PathVariable("id") int aid){
        return answerService.vote(aid,false);
    }

    @Operation( summary = "UpdatetextofAnswer.",
            description = "Updates the text inside answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = successschema))),
            @ApiResponse(responseCode = "404", description = "answer with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/answers/{id}")
    public Map<String, Boolean> update(@PathVariable("id") int id, @RequestBody TextUpdateDTO txt){
        return answerService.update(id,txt.getTxt());
    }
}
