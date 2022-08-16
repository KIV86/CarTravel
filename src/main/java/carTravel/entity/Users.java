package carTravel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users", schema = "carTravel")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Имя пользователя не моджет быть пыстым")
    @Size(min = 4, message = "Больше букв плиз, необходимо минимум 4 символов")
    @Column(name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @NotBlank(message = "аккаунт пользователя не моджет быть пыстым")
    @Size(min = 4, message = "Больше букв плиз, необходимо минимум 4 символов")
    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @OneToOne()
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;
}