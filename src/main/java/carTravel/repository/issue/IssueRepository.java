package carTravel.repository.issue;

import carTravel.entity.Issue;
import carTravel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findIssueByIsDoneIsFalseOrderByPlanDateEndDesc();

    List<Issue> findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc();

    List<Issue> findIssuesByExecutorId(Users executorId);
}

