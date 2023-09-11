package com.Nadir.askdeveloper.comment;

import com.Nadir.askdeveloper.comment.dto.QuestionCommentSaveDTO;
import com.Nadir.askdeveloper.question.QuestionRepo;
import com.Nadir.askdeveloper.user.UserRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionCommentSaveMapper {

    QuestionCommentSaveMapper INSTANCE = Mappers.getMapper( QuestionCommentSaveMapper.class );

    CommentforQuestion createCommentfromDTO(QuestionCommentSaveDTO dto, @Context QuestionRepo questionRepo, @Context UserRepo userRepo);

    @AfterMapping
    default void after(QuestionCommentSaveDTO data, @MappingTarget CommentforQuestion comment, @Context QuestionRepo questionRepo ,@Context UserRepo userRepo){
        comment.setUser(userRepo.getByUserName(data.getUsername()));
        comment.setQuestion(questionRepo.getById(data.getQuestionid()));
    }

}
