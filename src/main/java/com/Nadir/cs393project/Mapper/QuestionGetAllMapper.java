package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionGetAllDTO;
import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface QuestionGetAllMapper {

    QuestionGetAllMapper INSTANCE = Mappers.getMapper( QuestionGetAllMapper.class );

    @Mapping(source = "tags", target = "tags", qualifiedByName = "getTagNames")
    @Mapping(source = "user.nickname", target = "askedby")
    @Mapping(source = "answers", target = "answercount", qualifiedByName = "countAnswers")
    @Mapping(source = "descript", target = "descript", qualifiedByName = "cropString")
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
