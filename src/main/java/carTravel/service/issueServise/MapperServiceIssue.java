package carTravel.service.issueServise;

import carTravel.dto.issues.IssueGetDto;
import carTravel.dto.issues.IssueSaveDto;
import carTravel.entity.Issue;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class MapperServiceIssue {
    public List<IssueGetDto> mapperToListDto(List<Issue> entities) {
        return entities.stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    public IssueGetDto mapperToDto(Issue entity) {
        return new IssueGetDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPlanDateStart(),
                entity.getPlanDateEnd(),
                entity.getIsDone(),
                entity.getTaskWriterId().getName(),
                entity.getExecutorId().getName(),
                entity.getTasks().getName()
        );
    }
}
