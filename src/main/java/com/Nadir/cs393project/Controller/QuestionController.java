package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetailsDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/question")
    public List<QuestionGetAllDTO> getAll(@RequestBody(required = false) Map<String, String[]> tags){
        return (tags==null) ? questionService.getAll() : questionService.getWithTags(tags.get("tags"));
    }

    @GetMapping(value = "/question/{id}")
    public QuestionGetByIdWithDetailsDTO getByIdWithDetails(@PathVariable("id") int id){
        return questionService.getByIdWithDetails(id);
    }
    @PostMapping(value = "/question")
    public int save(@RequestBody QuestionSaveDTO data){
        return questionService.save(data);
    }
    @PutMapping(value = "/question/{id}/vote")
    public Map<String, Integer> voteQuestion(@PathVariable("id") int qid){
        return questionService.vote(qid);
    }
}
