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
   private final TaskRepository repository;

    public Tasks saveOrUpdate(TasksDto dto) {
       Tasks task = new Tasks();
        task.setName(dto.getName());
       return repository.save(task);
    }


    public Tasks get(Integer id) {
        Tasks task = null;
        final Optional<Tasks> optionalTasks = repository.findById(id);
        if (optionalTasks.isPresent()) {
            task = optionalTasks.get();
        }
        return task;

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
