package carTravel.dto.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TasksDto {

    private Integer id;

    @NonNull
    private String name;
}
