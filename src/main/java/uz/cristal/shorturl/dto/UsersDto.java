package uz.cristal.shorturl.dto;

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
//    @NotNull
    private String username;
//    @NotNull
    private String password;
//    @NotNull
    private String email;
//    @NotNull
    private String role;
//    @NotNull
    private boolean isActive=true;

}
