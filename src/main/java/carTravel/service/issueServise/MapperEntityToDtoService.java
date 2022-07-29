package carTravel.service.issueServise;

import carTravel.dto.IssueGetDto;
import carTravel.entity.Issue;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Transactional
public class MapperEntityToDtoService {
    public List<IssueGetDto> mapperToListDto(List<Issue> entities) {
        List<IssueGetDto> list = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            list.add(i,
                    new IssueGetDto(
                            entities.get(i).getName(),
                            entities.get(i).getIsDone(),
                            entities.get(i).getTaskWriterId().getName(),
                            entities.get(i).getExecutorId().getName(),
                            entities.get(i).getTasks().getName()
                    ));
        }
        return list;
    }

    public IssueGetDto mapperToDto(Issue entity) {
        return new IssueGetDto(
                entity.getName(),
                entity.getIsDone(),
                entity.getTaskWriterId().getName(),
                entity.getExecutorId().getName(),
                entity.getTasks().getName()
        );
    }
}
