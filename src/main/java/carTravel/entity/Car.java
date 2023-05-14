package carTravel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "car", schema = "cartravel")
@NoArgsConstructor
public class Car {
    public static Car createCar(String producerName, String modelName, String carNumber) {
        return new Car(producerName, modelName, carNumber);
    }

    private Car(String producerName, String modelName, String carNumber) {
        this.producerName = producerName;
        this.modelName = modelName;
        this.carNumber = carNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Производитель не моджет быть пыстым")
    @Size(min = 2, message = "Слишком короткое имя производителя, мин 2 символа")
    @Column(name = "producer_name", nullable = false)
    private String producerName;

    @NotBlank(message = "Модель не моджет быть пыстой")
    @Size(min = 2, message = "Слишком короткое имя модели, мин 2 символа")
    @Column(name = "model_name", nullable = false)
    private String modelName;

    @NotBlank(message = "Номер машины не моджет быть пыстым")
    @Size(min = 9, message = "слишком короткий номер машины, необходимо минимум 9 символов")
    @Column(name = "car_number", unique = true, length = 10)
    private String carNumber;

}