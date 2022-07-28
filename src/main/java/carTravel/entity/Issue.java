package carTravel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "issue", schema = "cartravel")
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
    private LocalDateTime planDateStart;

    @Column(name = "plan_date_end")
    private LocalDateTime planDateEnd;

    @Column(name = "is_done")
    private Boolean isDone;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "task_writer_id")
    private Users taskWriterId;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "executor_id")
    private Users executorId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "tasks_id")
    private Tasks tasks;

}
