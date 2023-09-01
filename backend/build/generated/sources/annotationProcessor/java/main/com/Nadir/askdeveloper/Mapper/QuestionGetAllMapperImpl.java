package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-14T13:07:07+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
public class QuestionGetAllMapperImpl implements QuestionGetAllMapper {

    @Override
    public QuestionGetAllDTO GetCutDTO(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionGetAllDTO questionGetAllDTO = new QuestionGetAllDTO();

        questionGetAllDTO.setTags( getTagNames( question.getTags() ) );
        questionGetAllDTO.setAskedby( questionUserNickname( question ) );
        questionGetAllDTO.setAnswercount( getNumAnswers( question.getAnswers() ) );
        questionGetAllDTO.setDescript( getDesc100letters( question.getDescript() ) );
        questionGetAllDTO.setTitle( question.getTitle() );
        questionGetAllDTO.setPublishdate( question.getPublishdate() );
        questionGetAllDTO.setVotes( question.getVotes() );

        return questionGetAllDTO;
    }

    private String questionUserNickname(Question question) {
        if ( question == null ) {
            return null;
        }
        User user = question.getUser();
        if ( user == null ) {
            return null;
        }
        String nickname = user.getNickname();
        if ( nickname == null ) {
            return null;
        }
        return nickname;
    }
}
