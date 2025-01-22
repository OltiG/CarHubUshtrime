package dev.oltijanuzi.carhubushtrime.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    @NotBlank(message = "Email cannot be null")
    @Size(min = 3, max = 50, message = "Email must be between 3 and 50 characters")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be null")
    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "Password must contain at least one digit, one uppercase letter, and one lowercase letter")
    private String password;
}
