package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.model.CommentforAnswer;
import com.Nadir.cs393project.repo.AnswerRepo;
import com.Nadir.cs393project.repo.UserRepo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-14T13:07:07+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
public class AnswerCommentSaveMapperImpl implements AnswerCommentSaveMapper {

    @Override
    public CommentforAnswer createCommentfromDTO(AnswerCommentSaveDTO dto, int answerid, AnswerRepo answerRepo, UserRepo userRepo) {
        if ( dto == null ) {
            return null;
        }

        CommentforAnswer commentforAnswer = new CommentforAnswer();

        if ( dto != null ) {
            commentforAnswer.setTxt( dto.getTxt() );
        }

        after( dto, answerid, commentforAnswer, answerRepo, userRepo );

        return commentforAnswer;
    }
}
