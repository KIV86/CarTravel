package carTravel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role", schema = "cartravel")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;
}