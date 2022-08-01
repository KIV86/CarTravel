package carTravel.dto.issues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class IssueGetDto {

    private Integer id;

    @NonNull
    private String name;

    private String description;

    private LocalDateTime planDateStart;

    private LocalDateTime planDateEnd;

    @NonNull
    private Boolean isDone;

    @NonNull
    private String taskWriterId;

    @NonNull
    private String executorId;

    @NonNull
    private String tasks;
}
