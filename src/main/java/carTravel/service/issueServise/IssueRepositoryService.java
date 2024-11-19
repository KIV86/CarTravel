package carTravel.service.issueServise;

import carTravel.dto.issues.IssueGetDto;
import carTravel.dto.issues.IssueSaveDto;
import carTravel.dto.issues.IssueUpdateDto;
import carTravel.entity.Issue;
import carTravel.entity.Users;
import carTravel.repository.issue.IssueRepository;
import carTravel.repository.task.TaskRepository;
import carTravel.repository.users.UsersRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssueRepositoryService {

    private final IssueRepository repository;
    private final UsersRepository usersRepository;
    private final TaskRepository taskRepository;
    private final MapperServiceIssue mapper;

    public IssueRepositoryService(@Lazy IssueRepository repository, UsersRepository user, TaskRepository taskRepository, MapperServiceIssue mapper) {
        this.repository = repository;
        this.usersRepository = user;
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    /**
     * Добавление нового автомобиля в базу
     * @param dto
     * @return
     */
    public Issue save(final IssueSaveDto dto) {
        final Integer executorId = dto.getExecutorId();
        final Integer taskWriterId = dto.getTaskWriterId();
        final Integer taskId = dto.getTasks();
        final var executorUser = usersRepository.findById(executorId).orElse(null);
        final var taskWriterUser = usersRepository.findById(taskWriterId).orElse(null);
        final var task = taskRepository.findById(taskId).orElse(null);
        return repository.save(new Issue()
                .setIsDone(false)
                .setExecutor(executorUser)
                .setName(dto.getName())
                .setPlanDateStart(LocalTime.now())
                .setDateDone(dto.getDateDone())
                .setTasks(task)
                .setPlanDateEnd(dto.getPlanDateEnd())
                .setTaskWriter(taskWriterUser));
    }

    public void update(IssueUpdateDto dto){}


    public Optional<IssueGetDto> get(Integer id) {
        Issue issue = null;
        Optional<IssueGetDto> dto = Optional.empty();
        final Optional<Issue> optional = repository.findById(id);
        if (optional.isPresent()) {
            issue = optional.get();
            final IssueGetDto value = mapper.mapperToDto(issue);
            dto = Optional.ofNullable(value);
        }
        return dto;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<IssueGetDto> getActualIssue() {
        return mapper.mapperToListDto(repository.findIssueByIsDoneIsFalseOrderByPlanDateEndDesc());
    }

    public List<IssueGetDto> getClosedIssue() {

        return mapper.mapperToListDto(repository.findIssuesByIsDoneIsTrueOrderByPlanDateEndDesc());
    }

    public List<IssueGetDto> getIssueByExecutor(Integer id) {
        final var issuesByExecutorId = repository.findIssuesByExecutorId(id);
        return mapper.mapperToListDto(issuesByExecutorId);
    }
}
