package dev.oltijanuzi.carhubushtrime.repository;

import dev.oltijanuzi.carhubushtrime.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    // Custom query method to find rentals by car ID
    List<Rental> findByCarId(Long carId);

    // Custom query method to find rentals within a date range
    List<Rental> findByPickUpDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom query method to find rentals by pick-up location
    List<Rental> findByPickUpLocation(String pickUpLocation);

    // Custom query method to find rentals by drop-off location
    List<Rental> findByDropOffLocation(String dropOffLocation);
}
