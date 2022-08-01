package carTravel.dto.issues;

import ch.qos.logback.core.util.Loader;
import lombok.NonNull;

import java.time.LocalDateTime;

public class IssueUpdateDto {

    String name;

    @NonNull
    Boolean isDone;

    @NonNull
    LocalDateTime dateDone;

}
