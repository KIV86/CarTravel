package carTravel.controller;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import carTravel.repository.car.CarRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {
    CarRepositoryImpl CarRepositoryImpl;

    @PostMapping
    public void create(@RequestBody CarDto entity) {
        CarRepositoryImpl.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id) {
        CarRepositoryImpl.delete(id);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id) {
        return CarRepositoryImpl.get(id);
    }
}
