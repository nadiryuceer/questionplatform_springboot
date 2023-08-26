package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Exception.AnswerNotFoundException;
import com.Nadir.cs393project.Exception.QuestionNotFoundException;
import com.Nadir.cs393project.Exception.UserNotFoundException;
import com.Nadir.cs393project.Mapper.AnswerSaveMapper;
import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    UserRepo userRepo;

    public Map<String,Integer> save(AnswerSaveDTO answerDTO, int qid){
        questionRepo.findById(qid).orElseThrow(QuestionNotFoundException::new);
        userRepo.findById(answerDTO.getUid()).orElseThrow(UserNotFoundException::new);
        Answer answer = AnswerSaveMapper.INSTANCE.createAnswerfromDTO(answerDTO, qid, questionRepo,userRepo);
        answer.getQuestion().addAnswer(answer);
        answer.getUser().addAnswer(answer);
        answerRepo.save(answer);
        Map<String,Integer> ids = new HashMap<>();
        ids.put("answer_id", answer.getId());
        ids.put("question_id",answer.getQuestion().getId());
        return ids;
    }
    public Map<String, Integer> vote(int id, boolean isupvote){
        int votecount;
        try{
            votecount = answerRepo.getById(id).getVotes();
        }catch (Exception e){
            throw new AnswerNotFoundException();
        }
        if (isupvote) {
            answerRepo.vote(id, ++votecount);
        } else {
            answerRepo.vote(id, --votecount);
        }
        return Collections.singletonMap("votecount",votecount);
    }
    public Map<String,Boolean> update(int id, String txt){
        answerRepo.findById(id).orElseThrow(AnswerNotFoundException::new);
        answerRepo.update(id,txt);
        return Collections.singletonMap("success",true);
    }
}