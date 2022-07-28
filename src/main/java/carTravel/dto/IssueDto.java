package carTravel.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor

public class IssueDto {

    Integer id;

    @NonNull
    private String name;

    private String description;

    private LocalDateTime planDateStart;

    private LocalDateTime planDateEnd;

    @NonNull
    private Boolean isDone;

    @NonNull
    private Integer taskWriterId;

    @NonNull
    private Integer executorId;

    @NonNull
    private Integer tasks;
}
