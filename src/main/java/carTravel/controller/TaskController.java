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
    TasksRepositoryImpl tasksRepository;

    @PostMapping
    public void create(@RequestBody TasksDto entity) {
        tasksRepository.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id) {
        tasksRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Tasks findById(@PathVariable Long id) {
        return tasksRepository.get(id);
    }

    @PutMapping("/{id}/dto")
    public void update(@PathVariable Long id, @RequestBody TasksDto dto) {
        tasksRepository.update(id, dto);
    }
}
