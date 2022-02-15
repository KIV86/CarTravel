package carTravel.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "carTravel.tasks")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "plan_date_start")
    private Time planDateStart;

    @Column(name = "plan_date_end")
    private Time planDateEnd;

    @Column(name = "date_done")
    private Time dateDone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = " task_writer_id")
    private Users task_writer_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = " executor_id")
    private Users executor_id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private Tasks tasks;
}
