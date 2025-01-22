package dev.oltijanuzi.carhubushtrime.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    @Size(min = 3, max=50, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Size(min = 3, max=50, message = "Surname must be between 3 and 50 characters")
    @NotBlank(message = "Surname cannot be empty")
    @NotNull(message = "Surname cannot be null")
    private String surname;

    @NotBlank(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotBlank(message = "Phone cannot be empty")
    @NotNull(message = "Phone cannot be null")
    @Size(min = 9, max = 20, message = "Phone number must be between 9 and 20 digits")
    private String phone;

    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "Password must contain at least one digit, one uppercase letter, and one lowercase letter")
    private String password;

    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "Password must contain at least one digit, one uppercase letter, and one lowercase letter")
    private String confirmPassword;

}
