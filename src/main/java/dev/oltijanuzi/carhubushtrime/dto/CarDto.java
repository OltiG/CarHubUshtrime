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

    @Positive(message = "Id must be a positive number")
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
    @NotBlank(message = "Price cannot be empty")
    @NotNull(message = "Price cannot be null")
    private double price;

    @NotNull(message = "Image of vehicle cannot be null")
    @NotBlank(message = "Image of vehicle cannot be empty")
    private String imageOfVehicle;

    private String gearType;

    private FuelType fuelType;
}
