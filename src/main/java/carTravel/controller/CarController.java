package carTravel.controller;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import carTravel.repository.car.CarRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {

    private final CarRepositoryImpl CarRepositoryImpl;

    @PostMapping
    public void   create(@RequestBody CarDto entity) {
        CarRepositoryImpl.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") int id) {
        CarRepositoryImpl.delete(id);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable int id) {
        return CarRepositoryImpl.get(id);
    }
}
