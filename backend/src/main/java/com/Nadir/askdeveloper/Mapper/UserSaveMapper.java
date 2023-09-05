package com.Nadir.askdeveloper.Mapper;

import com.Nadir.askdeveloper.dto.UserSaveDTO;
import com.Nadir.askdeveloper.model.User;
import com.Nadir.askdeveloper.repo.UserRepo;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserSaveMapper {
    UserSaveMapper INSTANCE = Mappers.getMapper(UserSaveMapper.class);

    User createFullObjectforSave(UserSaveDTO data, @Context UserRepo userRepo);

}
