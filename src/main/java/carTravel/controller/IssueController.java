package carTravel.controller;

import carTravel.dto.IssueDto;
import carTravel.dto.TasksDto;
import carTravel.entity.Issue;
import carTravel.entity.Tasks;
import carTravel.repository.issue.IssueRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issues")
public class IssueController {

    IssueRepositoryImpl issueRepository;

    @PostMapping
    public void create(@RequestBody IssueDto entity) {
        issueRepository.create(entity);
    }

    @DeleteMapping("/")
    public void delete() {
        Time time = Time.valueOf(ZonedDateTime.now().toLocalTime());
        issueRepository.deleteAllByPlanDateEndBefore(time);
    }
    @PutMapping("/{id}/dto")
    public void update(@PathVariable Long id, @RequestBody IssueDto dto) {
        issueRepository.update(id, dto);
    }
    @GetMapping("/{id}")
    public Issue findById(@PathVariable Long id) {
        return issueRepository.get(id);
    }
    @GetMapping("/{executor-id}")
        public Issue findByExecutor(@PathVariable Long id) {
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
