package carTravel.service.userService;

import carTravel.dto.users.UsersDto;
import carTravel.dto.users.UsersGetDto;
import carTravel.entity.Users;
import carTravel.repository.userRole.UserRoleRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
 class MapperUserService {

    @Autowired
    private final UserRoleRepository repository;

    public Users mapperToEntity(UsersDto dto) {
        Users users = new Users();
        users.setName(dto.getName());
        users.setAccount(dto.getAccount());
        users.setUserRole(repository.getById(dto.getUserRole()));
        return users;
    }

    public UsersGetDto mapperToDto(Users entity) {
        return new UsersGetDto(
                entity.getId(),
                entity.getName(),
                entity.getAccount(),
                entity.getUserRole().getName());
    }
}