package dev.oltijanuzi.carhubushtrime.mappers;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
import dev.oltijanuzi.carhubushtrime.dto.UserLoginDto;
import dev.oltijanuzi.carhubushtrime.dto.UserRegisterDto;
import dev.oltijanuzi.carhubushtrime.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);


    User toEntity(UserDto userDto);

    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);

    @Mapping(target = "address", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "zip", ignore = true)
    @Mapping(target = "documentUrl", ignore = true)
    @Mapping(target = "userRole", constant = "CUSTOMER")
    User registerDtoToUser(UserRegisterDto registerDto);

    UserLoginDto toLoginDto(User user);
}
