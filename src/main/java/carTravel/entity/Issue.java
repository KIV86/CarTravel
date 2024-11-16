package carTravel.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @NotBlank(message = "Наименование задачи не моджет быть пыстым")
    @Size(min = 10, message = "Больше букв плиз, необходимо минимум 10 символов")
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
    private LocalDate  dateDone;

    @NotNull
    @Column(name = "is_done")
    private Boolean isDone;

    @OneToOne()
    @JoinColumn(name = "task_writer_id")
    private Users taskWriterId;

    @OneToOne()
    @JoinColumn(name = "executor_id")
    private Users executorId;

    @ManyToOne()
    @JoinColumn(name = "tasks_id")
    private Tasks tasks;

}
