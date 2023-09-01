package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.cs393project.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionGetByIdWithDetailsMapper {
    QuestionGetByIdWithDetailsMapper INSTANCE = Mappers.getMapper(QuestionGetByIdWithDetailsMapper.class);

    QuestionDTO convertQuestiontoDTO(Question question);

    default String map(User user){
        return user.getNickname();
    }
    default String map(Tag tag){return tag.getName();}

}
