package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.service.AnswerService;
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
public class AnswerController {
    public final String answerquestionreturnschema = "{\n    \"answer_id\": 0,\n    \"question_id\": 0\n}";
    public final String votereturnschema = "{\n    \"votecount\": 0\n}";
    public final String successschema = "{\n    \"success\": true\n}";
    public final String textupdateschema = "{\n    \"txt\": \"string\"\n}";

    @Autowired
    AnswerService answerService;

    @Operation( summary = "AddAnswertoQuestion.",
            description = "Adds answer under a specific question.",
            tags = { "Answer" })
    @PostMapping(path = "/questions/{id}/answers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful save", content = @Content(examples = @ExampleObject(value = answerquestionreturnschema))),
            @ApiResponse(responseCode = "404", description = "question/user with provided id does not exist", content = @Content)
    })
    public Map<String,Integer> addAnswertoQuestion(@PathVariable("id") int qid, @RequestBody AnswerSaveDTO answerSaveDTO){
        answerSaveDTO.setQid(qid);
        return answerService.save(answerSaveDTO);
    }
    @Operation( summary = "Vote answer.",
            description = "Votes a specific answer.",
            tags = { "Answer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "answer with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/answers/{id}/vote")
    public Map<String, Integer> voteAnswer(@PathVariable("id") int aid){
        return answerService.vote(aid);
    }

    @Operation( summary = "UpdatetextofAnswer.",
            description = "Updates the text inside answer.",
            tags = { "Answer" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(example = textupdateschema)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(examples = @ExampleObject(value = successschema))),
            @ApiResponse(responseCode = "404", description = "answer with provided id does not exist", content = @Content)
    })
    @PutMapping(value = "/answers/{id}")
    public Map<String, Boolean> update(@PathVariable("id") int id, @RequestBody Map<String,String> txt){
        return answerService.update(id,txt.get("txt"));
    }
}
