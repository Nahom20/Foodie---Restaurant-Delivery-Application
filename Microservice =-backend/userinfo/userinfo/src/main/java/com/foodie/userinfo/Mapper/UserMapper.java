package com.foodie.userinfo.Mapper;

import com.foodie.userinfo.Dto.UserDto;
import com.foodie.userinfo.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserdtoToUser(UserDto userDto);

    UserDto mapUserToUserDto(User user);
}
