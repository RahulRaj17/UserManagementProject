package com.learning.usermanagementproject.service.impl;

import com.learning.usermanagementproject.dto.UserDto;
import com.learning.usermanagementproject.entity.User;
import com.learning.usermanagementproject.mapper.UserMapper;
import com.learning.usermanagementproject.repository.UserRepository;
import com.learning.usermanagementproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User JPA Entity
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //Convert User JPA Entity to User DTO
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
