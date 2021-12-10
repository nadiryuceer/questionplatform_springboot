package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Question;

import java.util.List;

public interface QuestionService {
    public boolean save(Question question);
    public List<Question> getAll();
    public Question getById(int id);
    public List<Question> getWithTags(List<String> tags);
}
