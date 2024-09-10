package uz.cristal.shorturl.mapper;
import org.mapstruct.Mapper;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDto toDto(Users users);

    Users toEntity(UsersDto usersDto);
}
