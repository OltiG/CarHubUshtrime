package dev.oltijanuzi.carhubushtrime.service;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
import dev.oltijanuzi.carhubushtrime.dto.UserLoginDto;
import dev.oltijanuzi.carhubushtrime.dto.UserRegisterDto;
import dev.oltijanuzi.carhubushtrime.enums.UserRole;
import dev.oltijanuzi.carhubushtrime.exceptions.EmailExistsException;
import dev.oltijanuzi.carhubushtrime.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserRegisterDto registerDto) throws EmailExistsException;

    UserDto getUserById(Long id) throws UserNotFoundException;

    UserDto updateUser(Long id, UserDto userDto) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;

    List<UserDto> getAllUsers();

    UserDto assignUserRole(Long userId, UserRole role);

    
}
