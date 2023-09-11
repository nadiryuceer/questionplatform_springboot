package com.Nadir.askdeveloper.question;

import com.Nadir.askdeveloper.question.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.tag.Tag;
import com.Nadir.askdeveloper.user.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionGetByIdWithDetailsMapper {
    QuestionGetByIdWithDetailsMapper INSTANCE = Mappers.getMapper(QuestionGetByIdWithDetailsMapper.class);

    QuestionDTO convertQuestiontoDTO(Question question);

    default String map(User user){
        return user.getUsername();
    }
    default String map(Tag tag){return tag.getName();}

}
