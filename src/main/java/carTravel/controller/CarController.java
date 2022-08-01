package carTravel.controller;

import carTravel.dto.CarDto;
import carTravel.service.carServise.CarRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {

    private final CarRepositoryService carRepositoryService;

    @PostMapping
    public void create(@RequestBody CarDto entity) {
        carRepositoryService.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") int id) {
        carRepositoryService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<CarDto> findById(@PathVariable int id) {
        return carRepositoryService.get(id);
    }

    @GetMapping("/find-all")
    public List<CarDto> findAll() {
        return carRepositoryService.findAll();
    }
}
