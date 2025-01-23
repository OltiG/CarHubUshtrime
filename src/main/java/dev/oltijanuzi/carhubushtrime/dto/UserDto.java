package dev.oltijanuzi.carhubushtrime.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Surname cannot be empty")
    private String surname;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "Phone cannot be empty")
    private String phone;

    @NotNull(message = "Location cannot be null")
    @NotBlank(message = "Location cannot be empty")
    private String location;
}