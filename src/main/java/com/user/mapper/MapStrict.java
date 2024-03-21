package com.user.mapper;

import com.user.dto.UserDto;
import com.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStrict {

    MapStrict MAPPER = Mappers.getMapper(MapStrict.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
