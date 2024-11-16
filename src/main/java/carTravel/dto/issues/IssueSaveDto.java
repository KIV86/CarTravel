package carTravel.dto.issues;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class IssueSaveDto {

    Integer id;

    @NotBlank(message = "Наименование задачи не моджет быть пыстым")
    @Size(min = 10, message = "Больше букв плиз, необходимо минимум 10 символов")
    private String name;

    @NonNull
    private LocalTime planDateStart;

    @NonNull
    private LocalTime planDateEnd;

    @NonNull
    private LocalDate dateDone;

    @NonNull
    private Boolean isDone;

    @NonNull
    private Integer taskWriterId;

    @NonNull
    private Integer executorId;

    @NonNull
    private Integer tasks;
}
