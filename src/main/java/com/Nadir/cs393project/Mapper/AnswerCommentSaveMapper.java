package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.QuestionRepo;
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
        comment.setUser(userRepo.getById(data.getUserid()));
        comment.setAnswer(answerRepo.getById(data.getAnswerid()));
    }
}
