package dev.oltijanuzi.carhubushtrime.model;

import dev.oltijanuzi.carhubushtrime.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Surname cannot be null")
    @NotBlank(message = "Surname cannot be empty")
    private String surname;

    @Column(nullable = false)
    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    @NotNull(message="Password cannot be null")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(nullable = false, length = 500)
    @Size(max = 500)
    private String address;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "City has to be less than 100 characters")
    private String city;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "State has to be less than 100 characters")
    private String state;

    @Column(nullable = false, length = 10)
    @Size(min = 5, max = 10, message = "Zip code has to be between 5 and 10 characters")
    private String zip;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Email cannot be null")
    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Phone cannot be null")
    @NotBlank(message = "Phone cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number format")
    private String phone;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Location cannot be null")
    @NotBlank(message = "Location cannot be empty")
    private String location;

    @Column(length = 1000)
    @Size(max = 1000)
    private String documentUrl;

    @Column(length = 1000)
    @Size(max = 1000)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
