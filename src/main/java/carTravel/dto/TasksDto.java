package carTravel.dto;

import carTravel.entity.Issue;
import lombok.Data;

import java.util.List;

@Data
public class TasksDto {
    private Integer id;

    private String name;

    private List<Issue> issues;
}
