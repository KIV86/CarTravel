package carTravel.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
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