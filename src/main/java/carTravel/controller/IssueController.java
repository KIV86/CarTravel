package carTravel.controller;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import carTravel.repository.issue.IssueRepositoryImpl;
import carTravel.repository.task.TaskRepository;
import carTravel.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issues")
public class IssueController {

    private final IssueRepositoryImpl issueRepository;

    @PostMapping
    public void create(@RequestBody IssueDto entity) {
        issueRepository.saveOrUpdate(entity);
    }

    @DeleteMapping("/")
    public void delete() {
        Time time = Time.valueOf(ZonedDateTime.now().toLocalTime());
        issueRepository.deleteAllByPlanDateEndBefore(time);
    }

    @GetMapping("/{id}")
    public Issue findById(@PathVariable Integer id) {

        return issueRepository.get(id);
    }

    @GetMapping("/get-by-executor/{id}")
    public Issue findByExecutor(@PathVariable Integer id) {
        return issueRepository.getIssueByExecutor(id);
    }

    @GetMapping("/actual-issues")
    public Issue finActualIssue() {
        return issueRepository.getActualIssue();
    }

    @GetMapping("/closed-issues")
    public Issue findClosedIssue() {
        return issueRepository.getClosedIssue();
    }
}
