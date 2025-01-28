package dev.oltijanuzi.carhubushtrime.service.impls;

import dev.oltijanuzi.carhubushtrime.dto.CarDto;
import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import dev.oltijanuzi.carhubushtrime.exceptions.CarExistsException;
import dev.oltijanuzi.carhubushtrime.exceptions.CarNotFoundException;
import dev.oltijanuzi.carhubushtrime.mappers.CarMapper;
import dev.oltijanuzi.carhubushtrime.model.Car;
import dev.oltijanuzi.carhubushtrime.repository.CarRepository;
import dev.oltijanuzi.carhubushtrime.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImplementation implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto createCar(CarDto carDto) throws CarExistsException {
        if (carRepository.existsByBrandAndModelAndProducedYear(
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getProducedYear())) {
            throw new CarExistsException();
        }
        Car car = carMapper.toEntity(carDto);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) throws CarNotFoundException {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));

        existingCar.setColor(carDto.getColor());
        existingCar.setPrice(carDto.getPrice());
        existingCar.setMileage(carDto.getMileage());
        existingCar.setAvailable(carDto.isAvailable());

        return carMapper.toDto(carRepository.save(existingCar));
    }

    @Override
    public void deleteCar(Long id) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
        carRepository.delete(car);
    }

    @Override
    public CarDto getCarById(Long id) throws CarNotFoundException {
        return carRepository.findById(id)
                .map(carMapper::toDto)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
    }

    @Override
    public List<CarDto> getAllCars() {
        return carMapper.toDtos(carRepository.findAll());
    }

    @Override
    public void updateCarAvailability(Long id, boolean isAvailable) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
        car.setAvailable(isAvailable);
        carRepository.save(car);
    }

    @Override
    public List<CarDto> getFeaturedCars(int count) {
        Pageable pageable = PageRequest.of(0, count); // Fetch the first 'count' results
        List<Car> featuredCars = carRepository.findByIsAvailableTrueOrderByCreatedAtDesc(pageable);
        return carMapper.toDtos(featuredCars);
    }


}