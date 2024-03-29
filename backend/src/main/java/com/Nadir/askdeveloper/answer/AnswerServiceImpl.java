package com.Nadir.askdeveloper.answer;

import com.Nadir.askdeveloper.Exception.AnswerNotFoundException;
import com.Nadir.askdeveloper.Exception.QuestionNotFoundException;
import com.Nadir.askdeveloper.Exception.UserNotFoundException;
import com.Nadir.askdeveloper.question.QuestionRepo;
import com.Nadir.askdeveloper.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
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

    public Map<String,Integer> save(AnswerSaveDTO answerDTO){
        questionRepo.findById(answerDTO.getQuestionid()).orElseThrow(QuestionNotFoundException::new);
        userRepo.findByUserName(answerDTO.getUsername()).orElseThrow(UserNotFoundException::new);
        Answer answer = AnswerSaveMapper.INSTANCE.createAnswerfromDTO(answerDTO, questionRepo,userRepo);
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
    public Map<String,Boolean> update(int id, String text){
        answerRepo.findById(id).orElseThrow(AnswerNotFoundException::new);
        answerRepo.update(id,text);
        return Collections.singletonMap("success",true);
    }
}
