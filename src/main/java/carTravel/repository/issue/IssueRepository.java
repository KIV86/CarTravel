package carTravel.repository.issue;

import carTravel.entity.Issue;
import carTravel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findIssueByIsDoneIsFalseOrderByPlanDateEndDesc();

    Issue findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc();

    List<Issue> findIssuesByExecutorId(Users executorId);

    void deleteIssueById(Integer id);


}

