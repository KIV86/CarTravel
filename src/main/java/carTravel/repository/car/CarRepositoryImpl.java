package carTravel.repository.car;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarRepositoryImpl {
    CarRepository repository;

    public void create(CarDto dto) {
        Car car = new Car();
        car.setCarNumber(dto.getCarNumber());
        car.setModelName(dto.getModelName());
        car.setProducerName(dto.getProducerName());
        repository.save(car);
    }

    public Car get(long id) {
        Car car = null;
        final Optional<Car> optionalCar = repository.findById(id);
        if (optionalCar.isPresent()){
            car=optionalCar.get();
        }
            return car;

    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
