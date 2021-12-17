package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    public int save(QuestionSaveDTO data);
    public List<QuestionGetAllDTO> getAll();
    public QuestionDTO getByIdWithDetails(int id);
    public List<QuestionGetAllDTO> getWithTags(String[] tags);
    public Map<String,Integer> vote(int id);
}
