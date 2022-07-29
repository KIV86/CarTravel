package carTravel.controller;

import carTravel.dto.issues.IssueGetDto;
import carTravel.dto.issues.IssueSaveDto;
import carTravel.entity.Users;
import carTravel.repository.issue.IssueRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issues")
public class IssueController {

    private final IssueRepositoryImpl issueRepository;

    @PostMapping
    public void create(@RequestBody IssueSaveDto entity) {
        issueRepository.saveOrUpdate(entity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        issueRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<IssueGetDto> findById(@PathVariable Integer id) {
        return issueRepository.get(id);
    }

    @GetMapping("/get-by-executor/{id}")
    public List<IssueGetDto> findByExecutor(@PathVariable Users id) {
        return issueRepository.getIssueByExecutor(id);
    }

    @GetMapping("/actual-issues")
    public List<IssueGetDto> findActualIssue() {
        return issueRepository.getActualIssue();
    }

    @GetMapping("/closed-issues")
    public List<IssueGetDto> findClosedIssue() {
        return issueRepository.getClosedIssue();
    }
}
