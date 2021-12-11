package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Mapper.QuestionMapper;
import com.Nadir.cs393project.dto.QuestionDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    TagRepo tagRepo;

    @Override
    public boolean save(Question question) {
        try {
            questionRepo.save(question);
            return true;
        } catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }
    public List<QuestionDTO> getAll(){
        List<Question> allqs = questionRepo.getAll();
        List<QuestionDTO> dtos = new ArrayList<>();
        for(Question q : allqs) {
            dtos.add(QuestionMapper.INSTANCE.QUESTION_DTO(q));
        }
        return dtos;
    }
    public List<Question> getWithTags(List<String> tags){
        return tagRepo.getQsWithTags(tags);
    }
    public Question getById(int id){
        return questionRepo.getById(id);
    }
    /*public List<Question> findByText(String text){
        return addressRepo.findByText(text);
    }
    public List<Question> findByCity(String city){
        return addressRepo.findByCity(city);
    }
*/
}
