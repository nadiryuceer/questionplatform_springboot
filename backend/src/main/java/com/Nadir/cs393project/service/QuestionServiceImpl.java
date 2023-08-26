package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Exception.QuestionNotFoundException;
import com.Nadir.cs393project.Exception.UserNotFoundException;
import com.Nadir.cs393project.Mapper.QuestionGetAllMapper;
import com.Nadir.cs393project.Mapper.QuestionGetByIdWithDetailsMapper;
import com.Nadir.cs393project.Mapper.QuestionSaveMapper;
import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
        userRepo.findById(data.getUid()).orElseThrow(UserNotFoundException::new);
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
    public QuestionDTO getByIdWithDetails(int id){
        try{
            return QuestionGetByIdWithDetailsMapper.INSTANCE.convertQuestiontoDTO(questionRepo.getById(id));
        } catch (Exception e){
            throw new QuestionNotFoundException();
        }
    }
    @Transactional
    public Map<String, Integer> vote(int id, boolean isupvote){
        int votecount;
        try {
            votecount = questionRepo.getById(id).getVotes();
        } catch(Exception e){
            throw new QuestionNotFoundException();
        }
        if (isupvote) {
            questionRepo.vote(id, ++votecount);
        } else {
            questionRepo.vote(id, --votecount);
        }
        return Collections.singletonMap("votecount",votecount);
    }

}