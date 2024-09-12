package uz.cristal.shorturl.service;


import org.springframework.stereotype.Service;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;

import java.util.List;
@Service
public interface UsersService {
    ResponseDto<UsersDto> addUser(UsersDto usersDto);

    ResponseDto<UsersDto> updateuser(UsersDto usersDto);

    ResponseDto<List<UsersDto>> getAllActiveUsers();

    ResponseDto<UsersDto> getUserById(Integer id);

    ResponseDto<UsersDto> deleteUser(Integer id);
}
