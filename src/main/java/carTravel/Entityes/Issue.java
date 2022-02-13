package carTravel.Entityes;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
    @JoinColumn(name = "boss_id")
    private User boss;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private User employee;
}
