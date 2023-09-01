package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.Exception.QuestionNotFoundException;
import com.Nadir.askdeveloper.Exception.UserNotFoundException;
import com.Nadir.askdeveloper.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.Mapper.QuestionGetAllMapper;
import com.Nadir.askdeveloper.Mapper.QuestionGetByIdWithDetailsMapper;
import com.Nadir.askdeveloper.Mapper.QuestionSaveMapper;
import com.Nadir.askdeveloper.dto.QuestionGetAllDTO;
import com.Nadir.askdeveloper.dto.QuestionSaveDTO;
import com.Nadir.askdeveloper.model.Question;
import com.Nadir.askdeveloper.model.Tag;
import com.Nadir.askdeveloper.repo.QuestionRepo;
import com.Nadir.askdeveloper.repo.TagRepo;
import com.Nadir.askdeveloper.repo.UserRepo;
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
        userRepo.findByUserName(data.getUsername()).orElseThrow(UserNotFoundException::new);
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
