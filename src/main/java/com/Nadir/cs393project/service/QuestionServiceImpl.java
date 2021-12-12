package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Mapper.QuestionGetAllMapper;
import com.Nadir.cs393project.Mapper.QuestionSaveMapper;
import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    TagRepo tagRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public int save(QuestionSaveDTO data) {
        Question q = QuestionSaveMapper.INSTANCE.createFullObjectforSave(data, userRepo,tagRepo);
        for(Tag t : q.getTags()) t.addQuestion(q);
        questionRepo.save(q);
        return q.getId();
    }
    public List<QuestionGetAllDTO> converttoDTOList(List<Question> qs){
        List<QuestionGetAllDTO> dtos = new ArrayList<>();
        for(Question q : qs) {
            dtos.add(QuestionGetAllMapper.INSTANCE.GetCutDTO(q));
        }
        return dtos;
    }
    public List<QuestionGetAllDTO> getAll(){
        return converttoDTOList(questionRepo.getAll());
    }
    public List<QuestionGetAllDTO> getWithTags(String[] tags){
        return converttoDTOList(questionRepo.getAllWithTags(tags));
    }
    public Question getById(int id){
        return questionRepo.getById(id);
    }
    public Map<String, Integer> vote(int id){
        int votecount = getById(id).getVotes();
        questionRepo.vote(id, ++votecount);
        Map<String,Integer> votemap = new HashMap<>();
        votemap.put("votecount",votecount);
        return votemap;
    }

}
