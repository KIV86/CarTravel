package carTravel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks", schema = "carTravel")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

/*    @OneToMany(mappedBy = "tasks", orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();*/

    public Tasks() {
    }
}