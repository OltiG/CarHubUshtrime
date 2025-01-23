package dev.oltijanuzi.carhubushtrime.model;

import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Size(max = 50)
    @NotNull(message="Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull(message="Model cannot be null")
    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Column(nullable = false, length = 4)
    @Size(max = 4)
    private int producedYear;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String color;

    @Column(nullable = false, length = 10)
    @Size(max = 10)
    private double price;

    @Column(nullable = false , length = 500)
    @Size(max = 500)
    private String imageOfVehicle;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false, length = 100)
    @Size(max = 100)
    private int horsePower;

    @Column(nullable = false, length = 10)
    @Size(max = 10)
    private int seats;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String gearType;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private int speed;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private double mileage;
}
