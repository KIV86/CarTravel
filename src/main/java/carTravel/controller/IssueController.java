package carTravel.controller;

import carTravel.dto.issues.IssueGetDto;
import carTravel.dto.issues.IssueSaveDto;
import carTravel.service.issueServise.IssueRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issues")
public class IssueController {
    private final IssueRepositoryService issueRepository;

    @PostMapping
    public String create(@Valid @RequestBody IssueSaveDto entity, Errors error) {
        if (error.hasErrors()) {
            return "--> не корректно заполнены поля";
        }
        issueRepository.save(entity);
        return String.valueOf(ResponseEntity.ok());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (id != null) {
            issueRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "--> НЕСУЖЕСТВУЮЩИЙ ID");
        }
    }

    @GetMapping("/{id}")
    public Optional<IssueGetDto> findById(@PathVariable Integer id) {

                return Optional.ofNullable(issueRepository.get(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "--> ПО ДАННОМУ ID НЕ НАЙДЕНО ЗАДАЧ"));
    }

    @GetMapping("/get-by-executor/{id}")
    public List<IssueGetDto> findByExecutor(@PathVariable Integer id) {
        return Optional.ofNullable(issueRepository.getIssueByExecutor(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "--> ПО ДАННОМУ ID НЕ НАЙДЕН ИСПОЛНИТЕЛЬ"));
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
