package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping(path = "/question/{id}/answer")
    public Map<String,Integer> addAnswertoQuestion(@PathVariable("id") int qid, @RequestBody AnswerSaveDTO answerSaveDTO){
        answerSaveDTO.setQid(qid);
        return answerService.save(answerSaveDTO);
    }
    @PutMapping(value = "/answer/{id}/vote")
    public Map<String, Integer> voteAnswer(@PathVariable("id") int aid){
        return answerService.vote(aid);
    }

}
