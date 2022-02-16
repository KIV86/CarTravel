package carTravel.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CarDto {

    @NonNull
    private Integer id;

    @NonNull
    private String producerName;

    @NonNull
    private String modelName;

    @NonNull
    private String carNumber;
}
