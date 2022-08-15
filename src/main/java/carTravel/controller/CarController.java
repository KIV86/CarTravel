package carTravel.controller;

import carTravel.dto.CarDto;
import carTravel.service.carServise.CarRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {

    private final CarRepositoryService carRepositoryService;

    @PostMapping
    public String create( @Valid @RequestBody CarDto entity, Errors error) {
        if (error.hasErrors()) {
            return "--> не корректно заполнены поля";
        }
        carRepositoryService.create(entity);
        return String.valueOf(ResponseEntity.ok());
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
}
