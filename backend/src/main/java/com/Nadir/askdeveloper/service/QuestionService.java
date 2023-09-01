package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.dto.QuestionGetAllDTO;
import com.Nadir.askdeveloper.dto.QuestionSaveDTO;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    public int save(QuestionSaveDTO data);
    public List<QuestionGetAllDTO> getAll();
    public QuestionDTO getByIdWithDetails(int id);
    public List<QuestionGetAllDTO> getWithTags(String[] tags);
    public Map<String,Integer> vote(int id, boolean isupvote);
}
