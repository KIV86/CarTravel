package carTravel.controller;

import carTravel.dto.tasks.TasksDto;
import carTravel.service.tasksService.TasksRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TasksRepositoryService tasksRepository;

    @PostMapping
    public void saveOrUpdate(@Valid @RequestBody TasksDto entity, Errors errors) {
        if (!errors.hasErrors()) {
            tasksRepository.saveOrUpdate(entity);
        } else throw new ValidationException("--> НЕ КОРРЕКТНО ВВЕДЕННЫЕ ДАННЫЕ");
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Integer id) {
        if (id != null) {
            tasksRepository.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "--> НЕСУЖЕСТВУЮЩИЙ ID");
        }
    }

    @GetMapping("/{id}")
    public Optional<TasksDto> findById(@PathVariable Integer id) {
        return Optional.ofNullable(tasksRepository.get(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "--> ПО ДАННОМУ ID НЕ НАЙДЕНА ГЛОБАЛЬНАЯ ЗАДАЧА"));
    }

    @GetMapping("/find-all")
    public List<TasksDto> findAll() {
        return tasksRepository.findAll();
    }
}
