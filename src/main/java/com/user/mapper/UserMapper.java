package com.user.mapper;

import com.user.dto.UserDto;
import com.user.entity.User;

public class UserMapper {

    //convert JPA Entity to UserDto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(), user.getName(),
                user.getEmail());
        return userDto;
    }

    //convert UserDto into JPA Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(userDto.getId(), userDto.getName(),
                userDto.getEmail());
        return user;
    }

}
