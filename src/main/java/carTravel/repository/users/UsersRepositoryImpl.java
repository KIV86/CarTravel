package carTravel.repository.users;

import carTravel.dto.UsersDto;
import carTravel.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersRepositoryImpl {
    UsersRepository repository;

    public void create(UsersDto dto) {
        Users users = new Users();
        users.setName(dto.getName());
        users.setUserRole(dto.getUserRole());
        users.setAccount(dto.getAccount());
        repository.save(users);
    }

    public Users get(long id) {
        Users users = null;
        final Optional<Users> optionalUsers = repository.findById(id);
        if (optionalUsers.isPresent()){
            users=optionalUsers.get();
        }
        return users;

    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
