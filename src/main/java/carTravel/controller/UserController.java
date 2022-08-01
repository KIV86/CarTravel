package carTravel.controller;

import carTravel.dto.users.UsersDto;
import carTravel.dto.users.UsersGetDto;
import carTravel.service.userService.UsersRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<UsersGetDto> findById(@PathVariable Integer id) {
        return service.get(id);
    }

}
