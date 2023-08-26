package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-14T13:07:07+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class QuestionSaveMapperImpl implements QuestionSaveMapper {

    @Override
    public Question createFullObjectforSave(QuestionSaveDTO data, UserRepo userRepo, TagRepo tagRepo) {
        if ( data == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( data.getTitle() );
        question.setDescript( data.getDescript() );

        after( data, question, userRepo, tagRepo );

        return question;
    }
}
