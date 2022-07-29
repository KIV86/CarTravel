package carTravel.controller;

import carTravel.dto.tasks.TasksDto;
import carTravel.repository.task.TasksRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<TasksDto> findById(@PathVariable Integer id) {
        return tasksRepository.get(id);

    }  @GetMapping("/find-all")
    public List<TasksDto> findAll() {
        return tasksRepository.findAll();
    }
}
