package com.Nadir.askdeveloper.Mapper;

import com.Nadir.askdeveloper.Exception.AnswerNotFoundException;
import com.Nadir.askdeveloper.Exception.UserNotFoundException;
import com.Nadir.askdeveloper.dto.AnswerCommentSaveDTO;
import com.Nadir.askdeveloper.model.CommentforAnswer;
import com.Nadir.askdeveloper.repo.AnswerRepo;
import com.Nadir.askdeveloper.repo.UserRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerCommentSaveMapper {
    AnswerCommentSaveMapper INSTANCE = Mappers.getMapper( AnswerCommentSaveMapper.class );

    CommentforAnswer createCommentfromDTO(AnswerCommentSaveDTO dto, int answerid, @Context AnswerRepo answerRepo, @Context UserRepo userRepo);

    @AfterMapping
    default void after(AnswerCommentSaveDTO data, int answerid, @MappingTarget CommentforAnswer comment, @Context AnswerRepo answerRepo, @Context UserRepo userRepo){
        try{
            comment.setUser(userRepo.getById(data.getUserid()));
        }catch (Exception e){
            throw new UserNotFoundException();
        }
        try{
            comment.setAnswer(answerRepo.getById(answerid));
        }catch (Exception e){
            throw new AnswerNotFoundException();
        }
    }
}
