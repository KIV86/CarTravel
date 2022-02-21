package carTravel.repository.issue;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import carTravel.entity.Users;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Optional;

@Transactional
public class IssueRepositoryImpl {

    private final IssueRepository repository;

    public IssueRepositoryImpl(@Lazy IssueRepository repository) {
        this.repository = repository;
    }

    public Issue create(final IssueDto dto) {
        repository.save(new Issue()
                .setIsDone(false)
                .setDescription(dto.getDescription())
                .setExecutorId(dto.getExecutorId())
                .setName(dto.getName())
                .setPlanDateStart(dto.getPlanDateStart())
                .setTasks(dto.getTasks())
                .setPlanDateEnd(dto.getPlanDateEnd())
                .setTaskWriterId(dto.getTaskWriterId()));
        System.out.println("Вам назначена задача");
        return new Issue();

    }

    public Issue get(long id) {
        Issue issue = null;
        final Optional<Issue> optional = repository.findById(id);
        if (optional.isPresent()) {
            issue = optional.get();
        }
        return issue;
    }

    public void update(long id, IssueDto dto) {
        if (!dto.getTaskWriterId().equals(get(id).getTaskWriterId())) {
            System.out.println("Вам назначена новая задача от " + get(id).getName());
            stepOneForUpdate(id, dto);
        }
        stepOneForUpdate(id, dto);
    }

    public void deleteAllByPlanDateEndBefore(Time dateTime) {
        repository.deleteAllByPlanDateEndBefore(dateTime);
    }

    public Issue getActualIssue() {
        Issue issue = repository.findIssuesByIsDoneIsFalseOrderByPlanDateEndDesc();
        return issue;
    }

    public Issue getClosedIssue() {
        return repository.findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc();
    }

    public Issue getIssueByExecutor(Users id) {
        return repository.findIssuesByExecutorId(id);

    }

    public void stepOneForUpdate(long id, IssueDto dto) {
        Issue issue = get(id);
        repository.save(issue);
        issue.setId(id);
        issue.setIsDone(false);
        issue.setDescription(dto.getDescription());
        issue.setExecutorId(dto.getExecutorId());
        issue.setName(dto.getName());
        issue.setPlanDateStart(dto.getPlanDateStart());
        issue.setTasks(dto.getTasks());
        issue.setPlanDateEnd(dto.getPlanDateEnd());
        issue.setTaskWriterId(dto.getTaskWriterId());
    }
}
