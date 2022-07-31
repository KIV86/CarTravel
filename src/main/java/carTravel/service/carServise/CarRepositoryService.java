package carTravel.repository.car;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import carTravel.service.carServise.MapperEntityToDtoCar;
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
    private final MapperEntityToDtoCar mapper;

//    public CarRepositoryImpl(CarRepository repository, MapperEntityToDtoCar mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }


    public void create(CarDto dto) {
        Car car = new Car();
        car.setCarNumber(dto.getCarNumber());
        car.setModelName(dto.getModelName());
        car.setProducerName(dto.getProducerName());
        repository.save(car);
    }

    public Optional<CarDto> get(int id) {
        Car car = null;
        Optional<CarDto> dto = Optional.empty();
        final Optional<Car> optionalCar = repository.findById(id);
        if (optionalCar.isPresent()) {
            car = optionalCar.get();
            final CarDto value = mapper.mapperToDto(car);
            dto = Optional.ofNullable(value);
        }
        return dto;

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<CarDto> findAll() {
        return mapper
                .mapperToListDto(
                repository.findAll());
    }

}
