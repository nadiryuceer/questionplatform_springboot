package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
