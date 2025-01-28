package dev.oltijanuzi.carhubushtrime.mappers;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
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
    // Map User to UserDto, ignoring sensitive or unnecessary fields

    UserDto toDto(User user);

    // Map UserDto to User, ignoring fields that should not be mapped back

    User toEntity(UserDto userDto);

    // Optional: Batch mapping for lists
    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);

    User registerDtoToUser(UserRegisterDto registerDto);
}
