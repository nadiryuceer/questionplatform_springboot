package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.AnswerSaveDTO;

import java.util.Map;

public interface AnswerService {
    public Map<String,Integer> save(AnswerSaveDTO answerDTO);
    public Map<String,Integer> vote(int id);
    public Map<String,Boolean> update(int id, String txt);
}
