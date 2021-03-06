package carTravel.dto;

import carTravel.entity.UserRole;
import lombok.Data;
import lombok.NonNull;
@Data
public class UsersDto {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String account;

    @NonNull
    private UserRole userRole;
}
