package carTravel.service.carServise;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class MapperServiceCar {
    public List<CarDto> mapperListEntityToListDto(List<Car> entities) {

        return entities.stream()
                .map(this::mapperEntitnyToDto)
                .collect(Collectors.toList());
    }

    public CarDto mapperEntitnyToDto(Car entity) {
        return new CarDto(
                entity.getId(),
                entity.getProducerName(),
                entity.getModelName(),
                entity.getCarNumber()
        );
    }

    public Car mapperDtoToEntity(CarDto dto) {
        return Car.createCar(dto.getCarNumber(), dto.getModelName(), dto.getProducerName());
    }
}
