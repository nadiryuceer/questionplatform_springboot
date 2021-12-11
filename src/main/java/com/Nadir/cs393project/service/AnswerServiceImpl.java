package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;
    public boolean save(Answer answer) {
        try {
            answerRepo.save(answer);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }
}
