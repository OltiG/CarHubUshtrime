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

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private String zip;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Email cannot be null")
    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;

    @Column(nullable = true, length = 50)
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone format")
    private String phone;

    @Column(length = 1000)
    @Size(max = 1000)
    private String documentUrl ="Anonymous";

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserRole userRole = UserRole.CUSTOMER;
}
