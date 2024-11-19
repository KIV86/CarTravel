package carTravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@Table(name = "user_role", schema = "cartravel")
public class UserRole{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Наименование пользовательской роли задачи не моджет быть пыстым")
    @Size(min = 3, message = "Больше букв плиз, необходимо минимум 3 символов")
    @Column(name = "name")
    private String name;
}