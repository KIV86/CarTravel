package carTravel.service.carServise;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import carTravel.repository.car.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarRepositoryService {

    private final CarRepository repository;
    private final MapperServiceCar mapper;

    public void create(CarDto dto) {
        mapper.mapperDtoToEntity(dto);
    }

    public Optional<CarDto> get(int id) {
        Car car = null;
        Optional<CarDto> dto = Optional.empty();
        final Optional<Car> optionalCar = repository.findById(id);
        if (optionalCar.isPresent()) {
            car = optionalCar.get();
            final CarDto value = mapper.mapperEntitnyToDto(car);
            dto = Optional.ofNullable(value);
        }
        return dto;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<CarDto> findAll() {
        return mapper
                .mapperListEntityToListDto(
                        repository.findAll());
    }
}
