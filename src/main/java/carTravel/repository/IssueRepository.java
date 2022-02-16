package carTravel.repository;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    IssueDto findIssueByIsDoneFalseOrderByDateDoneDesc();
    IssueDto findIssueByIsDoneTrueOrderByDateDoneDesc();
    IssueDto findIssueByExecutorId(Long id);
    void deleteAllByPlanDateEndBefore(Instant dateTime);
  }
