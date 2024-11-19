package carTravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tasks", schema = "carTravel")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Наименование глобальной задачи не моджет быть пыстым")
    @Size(min = 5, message = "Больше букв плиз, необходимо минимум 5 символов")
    @Column(name = "name", nullable = false)
    private String name;

/*    @OneToMany(mappedBy = "tasks", orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();*/
}