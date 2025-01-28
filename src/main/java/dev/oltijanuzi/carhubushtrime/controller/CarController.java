package dev.oltijanuzi.carhubushtrime.controller;

import dev.oltijanuzi.carhubushtrime.dto.CarDto;
import dev.oltijanuzi.carhubushtrime.exceptions.CarExistsException;
import dev.oltijanuzi.carhubushtrime.exceptions.CarNotFoundException;
import dev.oltijanuzi.carhubushtrime.exceptions.InvalidCarDataException;
import dev.oltijanuzi.carhubushtrime.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id) throws CarNotFoundException {
        return carService.getCarById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DEALER')")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto createCar(@Valid @RequestBody CarDto carDto, BindingResult bindingResult)
            throws CarExistsException {
        if (bindingResult.hasErrors()) {
            throw new InvalidCarDataException("Invalid car data");
        }
        return carService.createCar(carDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'DEALER')")
    public CarDto updateCar(@PathVariable Long id, @Valid @RequestBody CarDto carDto)
            throws CarNotFoundException {
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) throws CarNotFoundException {
        carService.deleteCar(id);
    }

    @PatchMapping("/{id}/availability")
    @PreAuthorize("hasAnyRole('ADMIN', 'DEALER')")
    public void updateAvailability(@PathVariable Long id, @RequestParam boolean available)
            throws CarNotFoundException {
        carService.updateCarAvailability(id, available);
    }
}