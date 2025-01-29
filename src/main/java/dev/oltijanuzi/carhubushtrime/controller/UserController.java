package dev.oltijanuzi.carhubushtrime.controller;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
import dev.oltijanuzi.carhubushtrime.dto.UserRegisterDto;
import dev.oltijanuzi.carhubushtrime.enums.UserRole;
import dev.oltijanuzi.carhubushtrime.exceptions.*;
import dev.oltijanuzi.carhubushtrime.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserDto registerUser(@Valid @RequestBody UserRegisterDto registerDto,
//                                BindingResult bindingResult) throws EmailExistsException {
//        if (bindingResult.hasErrors()) {
//            throw new InvalidUserDataException("Invalid registration data");
//        }
//        return userService.registerUser(registerDto);
//    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDto getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (#id == principal.id || hasRole('ADMIN'))")
    public UserDto updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto)
            throws UserNotFoundException {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{userId}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto assignUserRole(@PathVariable Long userId, @RequestParam UserRole role)
            throws UserNotFoundException, UnauthorizedRoleChangeException {
        return userService.assignUserRole(userId, role);
    }
}