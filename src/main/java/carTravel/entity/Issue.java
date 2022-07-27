package carTravel.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "tasks", schema = "cartravel")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "plan_date_start")
    private Time planDateStart;

    @Column(name = "plan_date_end")
    private Time planDateEnd;

    @Column(name = "is_done")
    private Boolean isDone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = " task_writer_id")
    private Users taskWriterId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = " executor_id")
    private Users executorId;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private Tasks tasks;
}
