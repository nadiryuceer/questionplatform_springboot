package com.Nadir.askdeveloper.Mapper;

import com.Nadir.askdeveloper.dto.AnswerSaveDTO;
import com.Nadir.askdeveloper.model.Answer;
import com.Nadir.askdeveloper.repo.QuestionRepo;
import com.Nadir.askdeveloper.repo.UserRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerSaveMapper {

    AnswerSaveMapper INSTANCE = Mappers.getMapper( AnswerSaveMapper.class );

    Answer createAnswerfromDTO(AnswerSaveDTO dto, int qid, @Context QuestionRepo questionRepo, @Context UserRepo userRepo);

    @AfterMapping
    default void addUserandQuestion(AnswerSaveDTO dto, int qid, @MappingTarget Answer answer, @Context QuestionRepo questionRepo, @Context UserRepo userRepo){
        answer.setQuestion(questionRepo.getById(qid));
        answer.setUser(userRepo.getByUserName(dto.getUsername()));
    }
}
