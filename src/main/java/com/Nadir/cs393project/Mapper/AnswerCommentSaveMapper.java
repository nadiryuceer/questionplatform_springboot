package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.Exception.AnswerNotFoundException;
import com.Nadir.cs393project.Exception.UserNotFoundException;
import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerCommentSaveMapper {
    AnswerCommentSaveMapper INSTANCE = Mappers.getMapper( AnswerCommentSaveMapper.class );

    CommentforAnswer createCommentfromDTO(AnswerCommentSaveDTO dto, @Context AnswerRepo answerRepo, @Context UserRepo userRepo);

    @AfterMapping
    default void after(AnswerCommentSaveDTO data, @MappingTarget CommentforAnswer comment, @Context AnswerRepo answerRepo, @Context UserRepo userRepo){
        try{
            comment.setUser(userRepo.getById(data.getUserid()));
        }catch (Exception e){
            throw new UserNotFoundException();
        }
        try{
            comment.setAnswer(answerRepo.getById(data.getAnswerid()));
        }catch (Exception e){
            throw new AnswerNotFoundException();
        }
    }
}
