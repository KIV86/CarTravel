package carTravel.repository.issue;

import carTravel.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;

public  interface  IssueRepository extends JpaRepository<Issue, Long> {
    Issue findIssuesByIsDoneIsFalseOrderByPlanDateEndDesc();
    Issue findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc();
    Issue findIssuesByExecutorId(Long executorId);
    void deleteAllByPlanDateEndBefore(Time dateTime);

  }
