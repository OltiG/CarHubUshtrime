package dev.oltijanuzi.carhubushtrime.mappers;

import dev.oltijanuzi.carhubushtrime.dto.CarDto;
import dev.oltijanuzi.carhubushtrime.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    // Map Car to CarDto
    CarDto toDto(Car car);

    // Map CarDto to Car
    Car toEntity(CarDto carDto);

    // Optional: Batch mapping for lists
    List<CarDto> toDtos(List<Car> cars);
    List<Car> toEntities(List<CarDto> carDtos);
}
