package dev.oltijanuzi.carhubushtrime.dto;

import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long id;

    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotNull(message = "Model cannot be null")
    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Positive(message = "Produced year must be a positive number")
    private int producedYear;

    private String color;

    @Positive(message = "Price must be a positive number")
    private double price;

    private String imageOfVehicle;

    private boolean isAvailable;

    private int horsePower;

    private int seats;

    private String gearType;

    private int speed;

    private FuelType fuelType;

    private double mileage;
}