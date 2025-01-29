package dev.oltijanuzi.carhubushtrime.service.impls;

import dev.oltijanuzi.carhubushtrime.dto.UserDto;
import dev.oltijanuzi.carhubushtrime.dto.UserLoginDto;
import dev.oltijanuzi.carhubushtrime.dto.UserRegisterDto;
import dev.oltijanuzi.carhubushtrime.enums.UserRole;
import dev.oltijanuzi.carhubushtrime.exceptions.EmailExistsException;
import dev.oltijanuzi.carhubushtrime.exceptions.UnauthorizedRoleChangeException;
import dev.oltijanuzi.carhubushtrime.exceptions.UserNotFoundException;
import dev.oltijanuzi.carhubushtrime.mappers.UserMapper;
import dev.oltijanuzi.carhubushtrime.model.User;
import dev.oltijanuzi.carhubushtrime.repository.UserRepository;
import dev.oltijanuzi.carhubushtrime.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    //    public UserDto registerUser(UserRegisterDto userRegisterDto) throws EmailExistsException{
//        if (userRepository.findCustomerByEmail(userRegisterDto.getEmail()).isPresent()){
//            throw new EmailExistsException();
//        }
//        User user = userMapper.toEntity(userRegisterDto);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userMapper.toDto(userRepository.save(user));
//    }

    //deepseek version
    public UserDto registerUser(UserRegisterDto registerDto) throws EmailExistsException {
        if (userRepository.findCustomerByEmail(registerDto.getEmail()).isPresent()) {
            throw new EmailExistsException("Email already registered");
        }
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        User user = userMapper.registerDtoToUser(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto assignUserRole(Long userId, UserRole role)
            throws UserNotFoundException, UnauthorizedRoleChangeException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (role == UserRole.ADMIN) {
            throw new UnauthorizedRoleChangeException("Admin role assignment requires special privileges");
        }

        user.setUserRole(role);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserLoginDto login(String email, String password) {
        User user = userRepository.findCustomerByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return userMapper.toLoginDto(user);
    }

    @Override
    // UserServiceImplementation.java
    public boolean register(UserRegisterDto userRegisterDto) throws EmailExistsException {
        User user = userMapper.registerDtoToUser(userRegisterDto);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);

        // Set default values for nullable fields
        user.setAddress("Not provided");
        user.setCity("Not provided");
        user.setState("Not provided");
        user.setZip("Not provided");

        userRepository.save(user);
        return true;
    }





}
