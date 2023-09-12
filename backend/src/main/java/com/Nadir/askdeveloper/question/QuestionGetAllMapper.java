package com.Nadir.askdeveloper.question;

import com.Nadir.askdeveloper.tag.Tag;
import com.Nadir.askdeveloper.question.dto.QuestionGetAllDTO;
import com.Nadir.askdeveloper.answer.Answer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface QuestionGetAllMapper {

    QuestionGetAllMapper INSTANCE = Mappers.getMapper( QuestionGetAllMapper.class );

    @Mapping(source = "tags", target = "tags", qualifiedByName = "getTagNames")
    @Mapping(source = "user.name", target = "askedby")
    @Mapping(source = "answers", target = "answercount", qualifiedByName = "countAnswers")
    @Mapping(source = "description", target = "description", qualifiedByName = "cropString")
    QuestionGetAllDTO GetCutDTO(Question question);
    @Named("getTagNames")
    default List<String> getTagNames(List<Tag> tags){
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
    @Named("cropString")
    default String getDesc100letters(String desc){
        return desc.length() >= 100 ? desc.substring(0,100) : desc;
    }
}
