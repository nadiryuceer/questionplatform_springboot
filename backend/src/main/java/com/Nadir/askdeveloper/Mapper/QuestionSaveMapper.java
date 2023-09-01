package com.Nadir.cs393project.Mapper;

import com.Nadir.cs393project.dto.QuestionSaveDTO;
import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface QuestionSaveMapper {

    QuestionSaveMapper INSTANCE = Mappers.getMapper( QuestionSaveMapper.class );

    @Mapping(target = "tags", ignore = true)
    Question createFullObjectforSave(QuestionSaveDTO data, @Context UserRepo userRepo, @Context TagRepo tagRepo);

    @AfterMapping
    default void after(QuestionSaveDTO data,@MappingTarget Question question, @Context UserRepo userRepo, @Context TagRepo tagRepo){
        question.setUser(userRepo.getById(data.getUid()));
        List<Tag> tags = new ArrayList<>();
        for(String tagname : data.getTags()){
            Tag tag = tagRepo.getByName(tagname);
            if(tag==null){
                tag = new Tag();
                tag.setName(tagname);
                tagRepo.save(tag);
            }
            tags.add(tag);
        }
        question.setTags(tags);
    }
}
