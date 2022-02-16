package carTravel.service.issue;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;

public interface IssueService {
    Issue create (IssueDto dto);
    IssueDto get(long id);
    void update(long id, IssueDto newData);
}
