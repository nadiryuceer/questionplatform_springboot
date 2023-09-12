package com.Nadir.askdeveloper.question;

import com.Nadir.askdeveloper.answer.Answer;
import com.Nadir.askdeveloper.comment.Comment;
import com.Nadir.askdeveloper.question.dto.QuestionGetByIdWithDetails.AnswerDTO;
import com.Nadir.askdeveloper.question.dto.QuestionGetByIdWithDetails.CommentDTO;
import com.Nadir.askdeveloper.question.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.tag.Tag;
import com.Nadir.askdeveloper.user.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionGetByIdWithDetailsMapper {
    QuestionGetByIdWithDetailsMapper INSTANCE = Mappers.getMapper(QuestionGetByIdWithDetailsMapper.class);

    @Mapping(source = "user", target = "username")
    QuestionDTO convertQuestiontoDTO(Question question);
    @Mapping(source = "user", target = "username")
    AnswerDTO answerToAnswerDTO(Answer answer);

    @Mapping(source = "user", target = "username")
    CommentDTO commentToCommentDTO(Comment comment);

    default String map(User user){
        return user.getName();
    }
    default String map(Tag tag){return tag.getName();}

}
