package com.learning.usermanagementproject.mapper;

import com.learning.usermanagementproject.dto.UserDto;
import com.learning.usermanagementproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
