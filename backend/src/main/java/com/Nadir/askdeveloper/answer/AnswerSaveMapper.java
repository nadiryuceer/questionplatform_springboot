package com.Nadir.askdeveloper.answer;

import com.Nadir.askdeveloper.question.QuestionRepo;
import com.Nadir.askdeveloper.user.UserRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerSaveMapper {

    AnswerSaveMapper INSTANCE = Mappers.getMapper( AnswerSaveMapper.class );

    Answer createAnswerfromDTO(AnswerSaveDTO dto, @Context QuestionRepo questionRepo, @Context UserRepo userRepo);

    @AfterMapping
    default void addUserandQuestion(AnswerSaveDTO dto, @MappingTarget Answer answer, @Context QuestionRepo questionRepo, @Context UserRepo userRepo){
        answer.setQuestion(questionRepo.getById(dto.getQuestionid()));
        answer.setUser(userRepo.getByUserName(dto.getUsername()));
    }
}
