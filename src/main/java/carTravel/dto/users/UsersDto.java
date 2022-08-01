package carTravel.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class UsersDto {

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String account;

    @NonNull
    private Integer userRole;
}
