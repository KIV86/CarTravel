package carTravel.dto.issues;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class IssueGetDto {
    Integer id;

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
