package uz.cristal.shorturl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(generator = "UsersIDseq")
    @SequenceGenerator(name = "UsersIDseq",sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;
    private String email;
    private String password;
    private String role="user";
    private Boolean isActive = true;

}
