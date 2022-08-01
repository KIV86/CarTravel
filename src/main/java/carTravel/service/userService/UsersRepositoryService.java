package carTravel.service.userService;

import carTravel.dto.users.UsersDto;
import carTravel.dto.users.UsersGetDto;
import carTravel.entity.Users;
import carTravel.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersRepositoryService {
    private final UsersRepository repository;

    private final MapperUserService mapperUserService;

    public void create(UsersDto dto) {
        repository.save(mapperUserService.mapperToEntity(dto));
    }

    public Optional<UsersGetDto> get(Integer id) {
        Users users = null;
        Optional<UsersGetDto> dto = Optional.empty();
        final Optional<Users> optionalUsers = repository.findById(id);
        if (optionalUsers.isPresent()) {
            users = optionalUsers.get();
            final var value = mapperUserService.mapperToDto(users);
            dto = Optional.ofNullable(value);
        }
        return dto;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
