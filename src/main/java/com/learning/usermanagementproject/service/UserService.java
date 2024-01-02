package com.learning.usermanagementproject.service;

import com.learning.usermanagementproject.dto.UserDto;
import com.learning.usermanagementproject.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);

}
