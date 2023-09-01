package com.Nadir.askdeveloper.Mapper;

import com.Nadir.askdeveloper.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.model.Question;
import com.Nadir.askdeveloper.model.Tag;
import com.Nadir.askdeveloper.model.User;
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
