package carTravel.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TasksDto {
    private Integer id;

    @NonNull
    private String name;
}
