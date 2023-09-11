package com.Nadir.askdeveloper.user;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserSaveMapper {
    UserSaveMapper INSTANCE = Mappers.getMapper(UserSaveMapper.class);

    User createFullObjectforSave(UserSaveDTO data, @Context UserRepo userRepo);

}
