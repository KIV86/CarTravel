package carTravel.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UsersDto {

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String account;

    @NonNull
    private Integer userRole;
}
