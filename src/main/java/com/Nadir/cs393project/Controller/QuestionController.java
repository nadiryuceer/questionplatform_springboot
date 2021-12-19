package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    public final String idreturnschema = "{\n    \"id\": 0\n}";
    public final String votereturnschema = "{\n    \"votecount\": 0\n}";
    public final String tagschema = "{\n    \"tags\":[\"string\"]\n}";
    @Autowired
    QuestionService questionService;

    @Operation( summary = "Get all questions.",
            description = "Returns all questions.",
            tags = { "Question" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(example = tagschema)))
    @GetMapping(value = "/questions")
    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = QuestionGetAllDTO.class))))
    public List<QuestionGetAllDTO> getAll(@RequestBody(required = false) Map<String, String[]> tags){
        return (tags==null) ? questionService.getAll() : questionService.getWithTags(tags.get("tags"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "question with provided id does not exist", content = @Content)
    })
    @Operation( summary = "Get specified question with extended details.",
            description = "Returns the user, complete text, comments together with their users" +
                    "and answers of both question and its comments with their users.",
            tags = { "Question" })
    @GetMapping(value = "/questions/{id}")
    public QuestionDTO getByIdWithDetails(@PathVariable("id") int id){
        return questionService.getByIdWithDetails(id);
    }

    @Operation( summary = "Save question.",
            description = "Saves a new question.",
            tags = { "Question" })
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "successful save", content = @Content(examples = @ExampleObject(value = idreturnschema))),
            @ApiResponse(responseCode = "404", description = "user with provided id does not exist", content = @Content)
            })
    @PostMapping(value = "/questions")
    public int save(@RequestBody QuestionSaveDTO data){
        return questionService.save(data);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful save", content = @Content(examples = @ExampleObject(value = votereturnschema))),
            @ApiResponse(responseCode = "404", description = "question with provided id does not exist", content = @Content)
    })
    @Operation( summary = "Vote question.",
            description = "Votes a specific question.",
            tags = { "Question" })
    @PutMapping(value = "/questions/{id}/vote")
    public Map<String, Integer> voteQuestion(@PathVariable("id") int qid){
        return questionService.vote(qid);
    }
}
