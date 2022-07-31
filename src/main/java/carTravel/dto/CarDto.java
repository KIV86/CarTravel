package carTravel.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CarDto {

    private int id;

    @NonNull
    private String producerName;

    @NonNull
    private String modelName;

    @NonNull
    private String carNumber;
}
