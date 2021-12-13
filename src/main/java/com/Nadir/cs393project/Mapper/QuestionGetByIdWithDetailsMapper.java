package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionGetByIdWithDetailsDTO;
import com.Nadir.cs393project.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface QuestionGetByIdWithDetailsMapper {
    QuestionGetByIdWithDetailsMapper INSTANCE = Mappers.getMapper(QuestionGetByIdWithDetailsMapper.class);

    QuestionGetByIdWithDetailsDTO convertQuestiontoDTO(Question question);

    @AfterMapping
    //Cleanup for avoiding stackoverflow
    default void clean(Question question, @MappingTarget QuestionGetByIdWithDetailsDTO dto){
        dto.setUser(cleanUser(dto.getUser()));
        List<CommentforQuestion> tempcomments = new ArrayList<>();
        for (CommentforQuestion comment : dto.getComments()){
            tempcomments.add(cleanQuestionComment(comment));
        }
        dto.setComments(tempcomments);
        List<Answer> tempanswers = new ArrayList<>();
        for(Answer answer : dto.getAnswers()){
            tempanswers.add(cleanAnswer(answer));
        }
        dto.setAnswers(tempanswers);
    }
    default User cleanUser(User user){
        user.setQuestions(null);
        user.setAnswers(null);
        user.setComments(null);
        return user;
    }
    default CommentforQuestion cleanQuestionComment(CommentforQuestion comment){
        comment.setQuestion(null);
        comment.setUser(cleanUser(comment.getUser()));
        return comment;
    }
    default CommentforAnswer cleanAnswerComment(CommentforAnswer comment){
        comment.setAnswer(null);
        comment.setUser(cleanUser(comment.getUser()));
        return comment;
    }
    default Answer cleanAnswer(Answer answer){
        answer.setQuestion(null);
        List<CommentforAnswer> tempcomments = new ArrayList<>();
        for(CommentforAnswer comment : answer.getComments()){
            tempcomments.add(cleanAnswerComment(comment));
        }
        answer.setComments(tempcomments);
        answer.setUser(cleanUser(answer.getUser()));
        return answer;
    }

}
