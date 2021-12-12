package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
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
        answer.setQuestion(questionRepo.getById(dto.getQid()));
        answer.setUser(userRepo.getById(dto.getUid()));
    }
}
