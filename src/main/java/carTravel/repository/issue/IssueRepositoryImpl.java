package carTravel.repository.issue;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import carTravel.repository.task.TaskRepository;
import carTravel.repository.users.UsersRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Optional;

@Transactional
public class IssueRepositoryImpl {

    private final IssueRepository repository;
    private final UsersRepository usersRepository;
    private final TaskRepository taskRepository;

    public IssueRepositoryImpl(@Lazy IssueRepository repository, UsersRepository user, TaskRepository taskRepository) {
        this.repository = repository;
        this.usersRepository = user;
        this.taskRepository = taskRepository;
    }

    public Issue saveOrUpdate(final IssueDto dto) {
        final Integer executorId = dto.getExecutorId();
        final Integer taskWriterId = dto.getTaskWriterId();
        final Integer taskId = dto.getTasks();
        final var executorUser = usersRepository.findById(executorId).orElse(null);
        final var taskWriterUser = usersRepository.findById(taskWriterId).orElse(null);
        final var task = taskRepository.findById(taskId).orElse(null);
        repository.save(new Issue()
                .setIsDone(false)
                .setDescription(dto.getDescription())
               .setExecutorId(executorUser)
                .setName(dto.getName())
                .setPlanDateStart(dto.getPlanDateStart())
                .setTasks(task)
                .setPlanDateEnd(dto.getPlanDateEnd())
                .setTaskWriterId(taskWriterUser));
        System.out.println("Вам назначена задача");
        return new Issue();

    }

    public Issue get(Integer id) {
        Issue issue = null;
        final Optional<Issue> optional = repository.findById(id);
        if (optional.isPresent()) {
            issue = optional.get();
        }
        return issue;
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

    public Issue getIssueByExecutor(Integer id) {
        return repository.findIssuesByExecutorId(id);

    }

}
