package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.AnswerSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.QuestionRepo;
import com.Nadir.cs393project.repo.UserRepo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-14T13:07:07+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
public class AnswerSaveMapperImpl implements AnswerSaveMapper {

    @Override
    public Answer createAnswerfromDTO(AnswerSaveDTO dto, int qid, QuestionRepo questionRepo, UserRepo userRepo) {
        if ( dto == null ) {
            return null;
        }

        Answer answer = new Answer();

        if ( dto != null ) {
            answer.setTxt( dto.getTxt() );
        }

        addUserandQuestion( dto, qid, answer, questionRepo, userRepo );

        return answer;
    }
}
