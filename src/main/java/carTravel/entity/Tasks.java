package carTravel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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