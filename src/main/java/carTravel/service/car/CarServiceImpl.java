package carTravel.service.car;

import carTravel.dto.CarDto;
import carTravel.dto.IssueDto;
import carTravel.entity.Car;
import carTravel.entity.Issue;
import carTravel.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    CarRepository repository;

    @Override
    public void create(CarDto dto) {
        Car car = new Car();
        car.setCarNumber(dto.getCarNumber());
        car.setModelName(dto.getModelName());
        car.setProducerName(dto.getProducerName());
        repository.save(car);
    }

    @Override
    public CarDto get(long id) {
        return null;
    }

    @Override
    public void update(long id, CarDto newData) {


    }

    @Override
    public void delete(long id) {
    }
}
