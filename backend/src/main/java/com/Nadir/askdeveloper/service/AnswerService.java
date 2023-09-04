package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.dto.AnswerSaveDTO;

import java.util.Map;

public interface AnswerService {
    public Map<String,Integer> save(AnswerSaveDTO answerDTO);
    public Map<String,Integer> vote(int id, boolean isupvote);
    public Map<String,Boolean> update(int id, String text);
}
