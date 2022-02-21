package carTravel.dto;

import carTravel.entity.Issue;
import carTravel.entity.Tasks;
import carTravel.entity.Users;
import lombok.*;

import java.sql.Time;

@Data
public class IssueDto {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private Time planDateStart;

    @NonNull
    private Time planDateEnd;

    @NonNull
    private Boolean dateDone;

    @NonNull
    private Users taskWriterId;

    @NonNull
    private Users executorId;

    @NonNull
    private Tasks tasks;

    public IssueDto(@NonNull Integer id, @NonNull String name, String description, @NonNull Time planDateStart, @NonNull Time planDateEnd, @NonNull Boolean dateDone, @NonNull Users taskWriterId, @NonNull Users executorId, @NonNull Tasks tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.planDateStart = planDateStart;
        this.planDateEnd = planDateEnd;
        this.dateDone = dateDone;
        this.taskWriterId = taskWriterId;
        this.executorId = executorId;
        this.tasks = tasks;
    }

    public IssueDto(Issue byIdOrThrow) {

    }
}
