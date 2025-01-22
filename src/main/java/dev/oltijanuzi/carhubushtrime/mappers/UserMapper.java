package dev.oltijanuzi.carhubushtrime.mappers;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
import dev.oltijanuzi.carhubushtrime.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toModel(UserDto userDto);


}
