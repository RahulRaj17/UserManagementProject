package com.learning.usermanagementproject.controller;

import com.learning.usermanagementproject.dto.UserDto;
import com.learning.usermanagementproject.entity.User;
import com.learning.usermanagementproject.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                                           @RequestBody UserDto userDto){
        userDto.setId(id);
        UserDto savedUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
