package carTravel.controller;

import carTravel.dto.TasksDto;
import carTravel.entity.Tasks;
import carTravel.repository.task.TasksRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TasksRepositoryImpl tasksRepository;

    @PostMapping
    public void saveOrUpdate(@RequestBody TasksDto entity) {
        tasksRepository.saveOrUpdate(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Integer id) {
        tasksRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Tasks findById(@PathVariable Integer id) {
        return tasksRepository.get(id);
    }
}
