package carTravel.controller;

import carTravel.dto.users.UsersDto;
import carTravel.dto.users.UsersGetDto;
import carTravel.service.userService.UsersRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UsersRepositoryService service;

    @PostMapping
    public void create(@RequestBody UsersDto entity) {
        service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Integer id) {
        if (id != null) {
            service.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "--> НЕСУЖЕСТВУЮЩИЙ ID");
        }
    }

    @GetMapping("/{id}")
    public Optional<UsersGetDto> findById(@PathVariable Integer id) {
        return Optional.ofNullable(service.get(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "--> ПО ДАННОМУ ID НЕ НАЙДЕН ПОЛЬЗОВАТЕЛЬ"));
    }
}
