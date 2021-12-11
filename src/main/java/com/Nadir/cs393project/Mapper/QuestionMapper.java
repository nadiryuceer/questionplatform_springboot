package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class );

    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "user.nickname", target = "askedby")
    @Mapping(source = "answers", target = "answercount", qualifiedByName = "countAnswers")
    @Mapping(source = "votes", target = "votecount")
    QuestionDTO QUESTION_DTO(Question question);
    default List<String> map(List<Tag> tags){
        if(tags == null) return null;
        List<String> tagnames = new ArrayList<>();
        for(Tag tag : tags) tagnames.add(tag.getName());
        return tagnames;
    }
    @Named("countAnswers")
    default int getNumAnswers(List<Answer> answers){
        if(answers==null) return 0;
        return answers.size();
    }
}
