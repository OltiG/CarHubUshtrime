package dev.oltijanuzi.carhubushtrime.model;

import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Model cannot be null")
    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Column(nullable = false)
    @Min(1886) @Max(2025)
    private int producedYear;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false)
    @Positive(message = "Price must be a positive number")
    private double price;

    @Column(nullable = false , length = 500)
    private String imageOfVehicle;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    @Positive(message = "Horsepower must be a positive number")
    private int horsePower;

    @Column(nullable = false)
    @Positive(message = "Seats must be a positive number")
    private int seats;

    @Column(nullable = false, length = 50)
    private String gearType;

    @Column(nullable = false)
    @Positive(message = "Speed must be a positive number")
    private int speed;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(nullable = false)
    @Positive(message = "Mileage must be a positive number")
    private double mileage;


}
