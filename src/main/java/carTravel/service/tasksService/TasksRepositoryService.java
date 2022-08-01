package carTravel.service.tasksService;

import carTravel.dto.tasks.TasksDto;
import carTravel.entity.Tasks;
import carTravel.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TasksRepositoryService {
    private final TaskRepository repository;
    private final MapperServiceTask mapper;

    public Tasks saveOrUpdate(TasksDto dto) {
        Tasks task = new Tasks();
        task.setName(dto.getName());
        return repository.save(task);
    }

    public Optional<TasksDto> get(Integer id) {
        Tasks task = null;
        Optional<TasksDto> dto = Optional.empty();
        final Optional<Tasks> optionalTasks = repository.findById(id);
        if (optionalTasks.isPresent()) {
            task = optionalTasks.get();
            final TasksDto value = mapper.mapperToDto(task);
            dto = Optional.ofNullable(value);
        }
        return dto;
    }

    public List<TasksDto> findAll() {
        return mapper.mapperToListDto(repository.findAll());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
