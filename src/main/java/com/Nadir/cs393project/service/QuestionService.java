package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    public int save(QuestionSaveDTO data);
    public List<QuestionGetAllDTO> getAll();
    public Question getById(int id);
    public List<QuestionGetAllDTO> getWithTags(String[] tags);
}
