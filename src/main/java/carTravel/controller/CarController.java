package carTravel.controller;

import carTravel.dto.CarDto;
import carTravel.entity.Car;
import carTravel.repository.car.CarRepository;
import carTravel.service.carServise.CarRepositoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {

    private final CarRepositoryService carRepositoryService;
    private final CarRepository carRepository;

    @PostMapping
    public String create(@Valid @RequestBody CarDto entity, Errors error) {
        if (error.hasErrors()) {
            return "--> не корректно заполнены поля";
        }
        carRepositoryService.create(entity);
        return ResponseEntity.ok().toString();
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Integer id) {
        if (id != null) {
            carRepositoryService.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "--> НЕСУЖЕСТВУЮЩИЙ ID");
        }
    }

    @GetMapping("/{id}")
    public Optional<CarDto> findById(@PathVariable int id) {
        return Optional.ofNullable(carRepositoryService.get(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "--> ПО  ДАННОМУ ID НЕ НАЙДЕНО МАШИНЫ"));
    }

    @GetMapping("/find-all")
    public List<CarDto> findAll() {
        return carRepositoryService.findAll();
    }

    @PutMapping()
    public void findAll( @Valid @RequestBody CarDto entity) {
        carRepositoryService.update(entity);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody CarDto updatedEntity, Errors error) {
        if (error.hasErrors()) {
            return ResponseEntity.badRequest().body("Не корректно заполнены поля");
        }

        Optional<Car> optionalCar = carRepository.findById(id);
        if (!optionalCar.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Car existingCar = optionalCar.get();

        // Обновляем только те поля, которые присутствуют в запросе
        if (updatedEntity.getProducerName() != null) {
            existingCar.setProducerName(updatedEntity.getProducerName());
        }
        if (updatedEntity.getModelName() != null) {
            existingCar.setModelName(updatedEntity.getModelName());
        }
        if (updatedEntity.getCarNumber() != null) {
            existingCar.setCarNumber(updatedEntity.getCarNumber());
        }

        // Сохраняем обновленную сущность в репозиторий
        carRepository.save(existingCar);

        return ResponseEntity.ok().build();
    }

}
