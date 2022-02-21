package carTravel.repository.task;

import carTravel.dto.TasksDto;
import carTravel.entity.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TasksRepositoryImpl {
    TaskRepository repository;

    public void create(TasksDto dto) {
        Tasks task = new Tasks();
        task.setName(dto.getName());
        task.setIssues(dto.getIssues());
        repository.save(task);
    }

    public void update(Long id, TasksDto dto) {
        Tasks task = get(id);
        task.setName(dto.getName());
        task.setIssues(dto.getIssues());
        repository.save(task);
    }

    public Tasks get(long id) {
        Tasks task = null;
        final Optional<Tasks> optionalTasks = repository.findById(id);
        if (optionalTasks.isPresent()) {
            task = optionalTasks.get();
        }
        return task;

    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
