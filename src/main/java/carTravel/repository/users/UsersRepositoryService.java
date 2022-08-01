package carTravel.repository.users;

import carTravel.dto.UsersDto;
import carTravel.entity.UserRole;
import carTravel.entity.Users;
import carTravel.repository.userRole.UserRoleRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsersRepositoryService {
    private final UsersRepository repository;
    public final UserRoleRepository userRoleRepository;

    public UsersRepositoryService(@Lazy UsersRepository repository, UserRoleRepository userRoleRepository) {
        this.repository = repository;
        this.userRoleRepository = userRoleRepository;
    }

    public void create(UsersDto dto) {
        final UserRole role = userRoleRepository.findById(dto.getId()).orElse(null);
        Users users = new Users();
        users.setName(dto.getName());
        users.setUserRole(role);
        users.setAccount(dto.getAccount());
        repository.save(users);
    }

    public Users get(Integer id) {
        Users users = null;
        final Optional<Users> optionalUsers = repository.findById(id);
        if (optionalUsers.isPresent()) {
            users = optionalUsers.get();
        }
        return users;

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
