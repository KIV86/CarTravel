package carTravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "issue", schema = "cartravel")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Наименование задачи не может быть пустым")
    @Size(min = 10, message = "Больше букв, пожалуйста. Необходимо минимум 10 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "plan_date_start")
    private LocalTime planDateStart;

    @NotNull
    @Column(name = "plan_date_end")
    private LocalTime planDateEnd;

    @NotNull
    @Column(name = "date_done")
    private LocalDate dateDone;

    @NotNull
    @Column(name = "is_done")
    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "task_writer_id")
    private Users taskWriter;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Users executor;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private Tasks tasks;
}
