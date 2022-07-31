package carTravel.service.issueServise;

import carTravel.dto.issues.IssueGetDto;
import carTravel.entity.Issue;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class MapperService {
    public List<IssueGetDto> mapperToListDto(List<Issue> entities) {
        return entities.stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    public IssueGetDto mapperToDto(Issue entity) {
        return new IssueGetDto(
                entity.getId(),
                entity.getName(),
                entity.getIsDone(),
                entity.getTaskWriterId().getName(),
                entity.getExecutorId().getName(),
                entity.getTasks().getName()
        );
    }
}
