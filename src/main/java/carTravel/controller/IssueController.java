package carTravel.controller;

import carTravel.dto.IssueDto;
import carTravel.entity.Issue;
import carTravel.entity.Users;
import carTravel.repository.issue.IssueRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issues")
public class IssueController {

    private final IssueRepositoryImpl issueRepository;

    @PostMapping
    public void create(@RequestBody IssueDto entity) {
        issueRepository.saveOrUpdate(entity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        issueRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Issue findById(@PathVariable Integer id) {

        return issueRepository.get(id);
    }

    @GetMapping("/get-by-executor/{id}")
    public List<Issue> findByExecutor(@PathVariable Users id) {
        return issueRepository.getIssueByExecutor(id);
    }

    @GetMapping("/actual-issues")
    public List<Issue> findActualIssue() {
        return issueRepository.getActualIssue();
    }

    @GetMapping("/closed-issues")
    public Issue findClosedIssue() {
        return issueRepository.getClosedIssue();
    }
}
