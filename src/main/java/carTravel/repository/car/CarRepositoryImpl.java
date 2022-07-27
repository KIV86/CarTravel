package carTravel.repository.car;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CarRepositoryImpl {

    private final CarRepository repository;

    public CarRepositoryImpl(@Lazy CarRepository repository) {
        this.repository = repository;
    }

    public void create(CarDto dto) {
        Car car = new Car();
        car.setCarNumber(dto.getCarNumber());
        car.setModelName(dto.getModelName());
        car.setProducerName(dto.getProducerName());
        repository.save(car);
    }

    public Car get(int id) {
        Car car = null;
        final Optional<Car> optionalCar = repository.findById(id);
        if (optionalCar.isPresent()){
            car=optionalCar.get();
        }
            return car;

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
