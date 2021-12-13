package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    public Map<String,Integer> save(AnswerSaveDTO answerDTO);
    public Map<String,Integer> vote(int id);
    //public Map<String,Boolean> update(Answer answer);
}
