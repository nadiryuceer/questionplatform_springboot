package com.Nadir.cs393project.service;

import com.Nadir.cs393project.Mapper.AnswerSaveMapper;
import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String,Integer> save(AnswerSaveDTO answerDTO) {
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
        int votecount = answerRepo.getById(id).getVotes();
        answerRepo.vote(id, ++votecount);
        Map<String,Integer> votemap = new HashMap<>();
        votemap.put("votecount",votecount);
        return votemap;
    }
}
