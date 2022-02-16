package carTravel.service.issue;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import carTravel.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private static final String OBJ_DESC = "Issue";
    private final IssueRepository repository;

    @Override
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

    @Override
    public IssueDto get(long id) {
        return new IssueDto(findByIdOrThrow(id));
    }

    private Issue findByIdOrThrow(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, OBJ_DESC));
    }

    @Override
    public void update(long id, IssueDto dto) {
        if (!dto.getTaskWriterId().equals(get(id).getTaskWriterId())) {
            System.out.println("Вам назначена новая задача от " + get(id).getName());
        }
        preUpdate(id, dto);
    }

    public void deleteAllByPlanDateEndBefore(Instant dateTime) {
        repository.deleteAllByPlanDateEndBefore(dateTime);
    }

    public Issue getActualIssue() {
        Issue issue = repository.findIssueByIsDoneFalseOrderByDateDoneDesc();
        return issue;
    }

    public Issue getClosedIssue() {
        return repository.findIssueByIsDoneTrueOrderByDateDoneDesc();
    }

    public Issue getIssueByExecutor(long id) {
        return repository.findIssueByExecutorId(id);

    }

    public void preUpdate(long id, IssueDto dto) {
        Issue issue = findByIdOrThrow(id);
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
