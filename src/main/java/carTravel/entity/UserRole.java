package carTravel.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user_role", schema = "cartravel")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Наименование пользовательской роли задачи не моджет быть пыстым")
    @Size(min = 3, message = "Больше букв плиз, необходимо минимум 3 символов")
    @Column(name = "name")
    private String name;
}