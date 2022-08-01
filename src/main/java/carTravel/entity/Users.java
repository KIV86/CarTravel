package carTravel.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users", schema = "carTravel")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", unique = true)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;
}