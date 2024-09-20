package uz.cristal.shorturl.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import uz.cristal.shorturl.entity.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {
    private Integer id;
    @NotBlank(message = "email is null")
    private String email;
    @NotBlank(message = "password is null")
    private String password;
    private Set<Role> roles;
    private Boolean isActive=true;

}
