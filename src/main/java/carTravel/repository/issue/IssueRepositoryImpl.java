package carTravel.repository.issue;

import carTravel.dto.IssueGetDto;
import carTravel.dto.IssueSaveDto;
import carTravel.entity.Issue;
import carTravel.entity.Users;
import carTravel.repository.task.TaskRepository;
import carTravel.repository.users.UsersRepository;
import carTravel.service.issueServise.MapperEntityToDtoService;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class IssueRepositoryImpl {

    private final IssueRepository repository;
    private final UsersRepository usersRepository;
    private final TaskRepository taskRepository;
    private final MapperEntityToDtoService mapper;

    public IssueRepositoryImpl(@Lazy IssueRepository repository, UsersRepository user, TaskRepository taskRepository, MapperEntityToDtoService mapper) {
        this.repository = repository;
        this.usersRepository = user;
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Issue saveOrUpdate(final IssueSaveDto dto) {
        final Integer executorId = dto.getExecutorId();
        final Integer taskWriterId = dto.getTaskWriterId();
        final Integer taskId = dto.getTasks();
        final var executorUser = usersRepository.findById(executorId).orElse(null);
        final var taskWriterUser = usersRepository.findById(taskWriterId).orElse(null);
        final var task = taskRepository.findById(taskId).orElse(null);
        return repository.save(new Issue()
                .setIsDone(false)
                .setDescription(dto.getDescription())
                .setExecutorId(executorUser)
                .setName(dto.getName())
                .setPlanDateStart(dto.getPlanDateStart())
                .setTasks(task)
                .setPlanDateEnd(dto.getPlanDateEnd())
                .setTaskWriterId(taskWriterUser));

    }

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

    public List<IssueGetDto> getIssueByExecutor(Users id) {
        final var issuesByExecutorId = repository.findIssuesByExecutorId(id);
        return mapper.mapperToListDto(issuesByExecutorId);

    }

}
