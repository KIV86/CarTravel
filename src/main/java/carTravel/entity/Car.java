package carTravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "carTravel.car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "producer_name", nullable = false)
    private String producerName;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "car_number", unique = true, length = 10)
    private String carNumber;
}