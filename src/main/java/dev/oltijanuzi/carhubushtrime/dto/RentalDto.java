package dev.oltijanuzi.carhubushtrime.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    @Positive(message = "Id must be a positive number")
    private Long id;

    @Positive(message = "Price must be a positive number")
    @NotNull(message = "Price cannot be null")
    @NotBlank(message = "Price cannot be empty")
    private int price;

    @NotNull(message = "Model cannot be null")
    @NotBlank(message = "Model cannot be empty")
    private String model;

    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotNull(message = "Image of vehicle cannot be null")
    @NotBlank(message = "Image of vehicle cannot be empty")
    private String imageOfVehicle;
}
