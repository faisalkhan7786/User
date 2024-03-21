package com.user.service;

import com.user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserbyId(int id);
    UserDto updatedUser(UserDto userDto);
    void deleteUser(int id);

}
