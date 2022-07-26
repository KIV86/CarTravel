package carTravel.controller;

import carTravel.dto.UsersDto;
import carTravel.entity.Users;
import carTravel.repository.users.UsersRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
   UsersRepositoryImpl usersRepository;

    @PostMapping
    public void create(@RequestBody UsersDto entity) {
        usersRepository.create(entity);
    }
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id) {
        usersRepository.delete(id);
    }
    @GetMapping("/{id}")
    public Users findById(@PathVariable Long id) {
        return usersRepository.get(id);
    }

/*    @PutMapping("/{id}/dto")
    public void update(@PathVariable Long id, @RequestBody CarDto dto) {
        return usersRepository.update(id, dto);
    }*/
}
