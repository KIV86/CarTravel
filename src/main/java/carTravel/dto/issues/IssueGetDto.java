package carTravel.dto.issues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class IssueGetDto {

    private Integer id;

    @NotEmpty
    private String name;

    private LocalTime planDateStart;

    private LocalTime planDateEnd;

    private LocalDate dateDone;

    @NonNull
    private Boolean isDone;

    @NonNull
    private String taskWriterId;

    @NonNull
    private String executorId;

    @NonNull
    private String tasks;
}
