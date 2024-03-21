package com.user.controller;

import com.user.dto.UserDto;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> user = userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDto> getUserbyId(@PathVariable int id) {
        UserDto user = userService.getUserbyId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<UserDto> updatedUser(@RequestBody UserDto userDto){
        UserDto updatedUser = userService.updatedUser(userDto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        String msg = "User deleted successfully !!!";
        userService.deleteUser(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
