package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Exception.AnswerNotFoundException;
import com.Nadir.cs393project.Exception.CommentNotFoundException;
import com.Nadir.cs393project.Exception.QuestionNotFoundException;
import com.Nadir.cs393project.Exception.UserNotFoundException;
import com.Nadir.cs393project.Mapper.AnswerSaveMapper;
import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    UserRepo userRepo;

    public Map<String,Integer> save(AnswerSaveDTO answerDTO){
        questionRepo.findById(answerDTO.getQid()).orElseThrow(QuestionNotFoundException::new);
        userRepo.findById(answerDTO.getUid()).orElseThrow(UserNotFoundException::new);
        Answer answer = AnswerSaveMapper.INSTANCE.createAnswerfromDTO(answerDTO, questionRepo,userRepo);
        answer.getQuestion().addAnswer(answer);
        answer.getUser().addAnswer(answer);
        answerRepo.save(answer);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("answer_id", answer.getId());
        ids.put("question_id",answer.getQuestion().getId());
        return ids;
    }
    public Map<String, Integer> vote(int id){
        int votecount;
        try{
            votecount = answerRepo.getById(id).getVotes();
        }catch (Exception e){
            throw new AnswerNotFoundException();
        }
        answerRepo.vote(id, ++votecount);
        return Collections.singletonMap("votecount",votecount);
    }
    public Map<String,Boolean> update(int id, String txt){
        try{
            answerRepo.getById(id);
        }catch (Exception e){
            throw new AnswerNotFoundException();
        }
        answerRepo.update(id,txt);
        return Collections.singletonMap("success",true);
    }
}
