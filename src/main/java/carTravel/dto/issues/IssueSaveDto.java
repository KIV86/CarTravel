package carTravel.dto.issues;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class IssueSaveDto {

    Integer id;

    @NotEmpty
    private String name;

    private LocalDateTime planDateStart;

    private LocalDateTime planDateEnd;

    private LocalDateTime dateDone;

    @NonNull
    private Boolean isDone;

    @NonNull
    private Integer taskWriterId;

    @NonNull
    private Integer executorId;

    @NonNull
    private Integer tasks;
}
