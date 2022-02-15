package carTravel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "carTravel.user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;
}