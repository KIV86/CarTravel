package carTravel.dto.issues;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
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
