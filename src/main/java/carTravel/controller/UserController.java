package carTravel.controller;

import carTravel.dto.UsersDto;
import carTravel.entity.Users;
import carTravel.repository.users.UsersRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    UsersRepositoryService usersRepository;

    @PostMapping
    public void create(@RequestBody UsersDto entity) {
        usersRepository.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Integer id) {
        usersRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable Integer id) {
        return usersRepository.get(id);
    }

/*    @PutMapping("/{id}/dto")
    public void update(@PathVariable Long id, @RequestBody CarDto dto) {
        return usersRepository.update(id, dto);
    }*/
}
