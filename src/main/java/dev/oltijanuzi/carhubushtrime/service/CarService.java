package dev.oltijanuzi.carhubushtrime.service;

import dev.oltijanuzi.carhubushtrime.dto.CarDto;
import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import dev.oltijanuzi.carhubushtrime.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    CarDto createCar(CarDto carDto);

    CarDto updateCar(Long id, CarDto carDto);

    void deleteCar(Long id);

    CarDto getCarById(Long id);

    List<CarDto> getAllCars();

    void updateCarAvailability(Long id, boolean isAvailable);


}

