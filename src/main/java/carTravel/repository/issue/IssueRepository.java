package carTravel.repository.issue;

import carTravel.dto.IssueGetDto;
import carTravel.entity.Issue;
import carTravel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findIssueByIsDoneIsFalseOrderByPlanDateEndDesc();

    List<Issue> findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc();

    List<Issue> findIssuesByExecutorId(Users executorId);
}

