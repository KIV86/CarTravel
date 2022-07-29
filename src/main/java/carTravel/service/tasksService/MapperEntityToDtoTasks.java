package carTravel.service.tasksService;

import carTravel.dto.issues.IssueGetDto;
import carTravel.dto.tasks.TasksDto;
import carTravel.entity.Issue;
import carTravel.entity.Tasks;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Transactional
public class MapperEntityToDtoTasks {

    public TasksDto mapperToDto(Tasks entity) {
        return new TasksDto(
                entity.getId(),
                entity.getName());
    }

    public List<TasksDto> mapperToListDto(List<Tasks> entities) {
        List<TasksDto> list = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            list.add(i,
                    new TasksDto(
                            entities.get(i).getId(),
                            entities.get(i).getName()
                    ));
        }
        return list;
    }
}