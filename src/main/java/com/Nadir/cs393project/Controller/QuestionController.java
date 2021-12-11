package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.QuestionDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/question")
    public List<QuestionDTO> getAll(@RequestBody(required = false) Map<String, String[]> tags){
        return (tags==null) ? questionService.getAll() : questionService.getWithTags(tags.get("tags"));
    }

    @GetMapping(value = "/question/{id}")
    public Question getWithTags(@PathVariable("id") int id){
        return questionService.getById(id);
    }
    @PostMapping(value = "/question")
    public int save(@RequestBody Question question){
        questionService.save(question);
        return question.getId();
    }
}
