package carTravel.dto.issues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class IssueGetDto {

    private Integer id;

    @NotEmpty
    private String name;

    private LocalDateTime planDateStart;

    private LocalDateTime planDateEnd;

    private LocalDateTime dateDone;

    @NonNull
    private Boolean isDone;

    @NonNull
    private String taskWriterId;

    @NonNull
    private String executorId;

    @NonNull
    private String tasks;
}
