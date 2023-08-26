package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.AnswerDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.CommentDTO;
import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-14T13:07:07+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
public class QuestionGetByIdWithDetailsMapperImpl implements QuestionGetByIdWithDetailsMapper {

    @Override
    public QuestionDTO convertQuestiontoDTO(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId( question.getId() );
        questionDTO.setTitle( question.getTitle() );
        questionDTO.setDescript( question.getDescript() );
        questionDTO.setPublishdate( question.getPublishdate() );
        questionDTO.setViews( question.getViews() );
        questionDTO.setVotes( question.getVotes() );
        questionDTO.setComments( commentforQuestionListToCommentDTOList( question.getComments() ) );
        questionDTO.setAnswers( answerListToAnswerDTOList( question.getAnswers() ) );
        questionDTO.setUser( map( question.getUser() ) );
        questionDTO.setTags( tagListToStringList( question.getTags() ) );

        return questionDTO;
    }

    protected CommentDTO commentforQuestionToCommentDTO(CommentforQuestion commentforQuestion) {
        if ( commentforQuestion == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( commentforQuestion.getId() );
        commentDTO.setTxt( commentforQuestion.getTxt() );
        commentDTO.setPublishdate( commentforQuestion.getPublishdate() );
        commentDTO.setVotes( commentforQuestion.getVotes() );
        commentDTO.setUser( map( commentforQuestion.getUser() ) );

        return commentDTO;
    }

    protected List<CommentDTO> commentforQuestionListToCommentDTOList(List<CommentforQuestion> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDTO> list1 = new ArrayList<CommentDTO>( list.size() );
        for ( CommentforQuestion commentforQuestion : list ) {
            list1.add( commentforQuestionToCommentDTO( commentforQuestion ) );
        }

        return list1;
    }

    protected CommentDTO commentforAnswerToCommentDTO(CommentforAnswer commentforAnswer) {
        if ( commentforAnswer == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( commentforAnswer.getId() );
        commentDTO.setTxt( commentforAnswer.getTxt() );
        commentDTO.setPublishdate( commentforAnswer.getPublishdate() );
        commentDTO.setVotes( commentforAnswer.getVotes() );
        commentDTO.setUser( map( commentforAnswer.getUser() ) );

        return commentDTO;
    }

    protected List<CommentDTO> commentforAnswerListToCommentDTOList(List<CommentforAnswer> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDTO> list1 = new ArrayList<CommentDTO>( list.size() );
        for ( CommentforAnswer commentforAnswer : list ) {
            list1.add( commentforAnswerToCommentDTO( commentforAnswer ) );
        }

        return list1;
    }

    protected AnswerDTO answerToAnswerDTO(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setId( answer.getId() );
        answerDTO.setTxt( answer.getTxt() );
        answerDTO.setPublishdate( answer.getPublishdate() );
        answerDTO.setVotes( answer.getVotes() );
        answerDTO.setUser( map( answer.getUser() ) );
        answerDTO.setComments( commentforAnswerListToCommentDTOList( answer.getComments() ) );

        return answerDTO;
    }

    protected List<AnswerDTO> answerListToAnswerDTOList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerDTO> list1 = new ArrayList<AnswerDTO>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerToAnswerDTO( answer ) );
        }

        return list1;
    }

    protected List<String> tagListToStringList(List<Tag> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Tag tag : list ) {
            list1.add( map( tag ) );
        }

        return list1;
    }
}
