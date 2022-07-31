package carTravel.service.carServise;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class MapperService {
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

    public Car mapperDtoToEntity(CarDto dto){
        Car car = new Car();
        car.setCarNumber(dto.getCarNumber());
        car.setModelName(dto.getModelName());
        car.setProducerName(dto.getProducerName());
        return car;
    }
}
