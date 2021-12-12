package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
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
        comment.setUser(userRepo.getById(data.getUserid()));
        comment.setQuestion(questionRepo.getById(data.getQuestionid()));
    }

}
