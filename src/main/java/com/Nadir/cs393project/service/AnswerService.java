package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.AnswerSaveDTO;

import java.util.Map;

public interface AnswerService {
    public Map<String,Integer> save(AnswerSaveDTO answerDTO, int qid);
    public Map<String,Integer> vote(int id, boolean isupvote);
    public Map<String,Boolean> update(int id, String txt);
}
