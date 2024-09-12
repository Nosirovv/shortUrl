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
    private String email;
//    @NotNull
    private String password;
//    @NotNull
    private String role;
//    @NotNull
    private Boolean isActive=true;

}
