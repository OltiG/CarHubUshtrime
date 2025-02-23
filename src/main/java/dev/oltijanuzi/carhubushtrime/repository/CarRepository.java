package dev.oltijanuzi.carhubushtrime.repository;

import dev.oltijanuzi.carhubushtrime.enums.FuelType;
import dev.oltijanuzi.carhubushtrime.model.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findById(Long id);

    List<Car> findAllByModel(String model);

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByColor(String color);

    List<Car> findAllByHorsePower(int horsePower);


    List<Car> findAllBySeats(int seats);

    List<Car> findAllByGearType(String gearType);

    List<Car> findAllByPrice(double price);

    List<Car> findAllByFuelType(FuelType fuelType);

    List<Car> findAllByProducedYear(int producedYear);


    boolean existsByBrandAndModelAndProducedYear(String brand, String model, int producedYear);
}
