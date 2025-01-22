package dev.oltijanuzi.carhubushtrime.mappers;

import dev.oltijanuzi.carhubushtrime.dto.CarDto;
import dev.oltijanuzi.carhubushtrime.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CarMapper extends SimpleMapper<Car, CarDto>{
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Override
    @Mapping(source = "gearType", target = "gearType")
    @Mapping(target = "imageUrl", ignore = true) // Exclude image URL in this case
    Car toModel(CarDto dto);

    @Override
    @Mapping(source = "gearType", target = "gearType")
    @Mapping(source = "imageUrl", target = "imageUrl")
    CarDto toDto(Car car);
}
