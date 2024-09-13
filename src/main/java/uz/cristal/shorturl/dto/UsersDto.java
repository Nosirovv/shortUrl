package uz.cristal.shorturl.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    private String role="user";
    private Boolean isActive=true;

}
