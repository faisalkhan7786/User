package com.user.service;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.mapper.MapStrict;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto addUser(UserDto userDto) {
        //convert UserDto into User JPA entity
       // User user = UserMapper.mapToUser(userDto);
        // Using ModelMapper
       // User user = modelMapper.map(userDto,User.class);
        //Using MapStrict
        User user = MapStrict.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        //Convert User JPA entity into UserDto
       // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        //UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = MapStrict.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        //return users.stream().map((user -> modelMapper.map(user,UserDto.class))).collect(Collectors.toList());  By using ModelMapper
        //By Using MapStrict
        return users.stream().map((user -> MapStrict.MAPPER.mapToUserDto(user))).collect(Collectors.toList());

    }
    @Override
    public UserDto getUserbyId(int id) {
        User user = userRepository.findById(id);
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user,UserDto.class);
        //By Using MapStrict
        return MapStrict.MAPPER.mapToUserDto(user);
    }
    @Override
    public UserDto updatedUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId());
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser,UserDto.class);
        //By Using MapStrict
        return MapStrict.MAPPER.mapToUserDto(updatedUser);
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
