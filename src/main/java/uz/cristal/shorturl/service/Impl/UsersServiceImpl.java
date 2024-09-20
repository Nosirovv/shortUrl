package uz.cristal.shorturl.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.entity.Users;
import uz.cristal.shorturl.mapper.UsersMapper;
import uz.cristal.shorturl.repository.UsersRepository;
import uz.cristal.shorturl.service.UsersService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    @Override
    public ResponseDto<UsersDto> addUser(UsersDto usersDto) {

        try {
            Users users = usersMapper.toEntity(usersDto);
            usersRepository.save(users);

            return ResponseDto.<UsersDto>builder()
                    .code(1)
                    .success(true)
                    .message("OK")
                    .data(usersMapper.toDto(users))
                    .build();
        }catch (Exception e){
           return ResponseDto.<UsersDto>builder()
                    .code(2)
                    .success(false)
                    .message("Database eror")
                    .data(null)
                    .build();
        }
    }

    @Override
    public ResponseDto<UsersDto> updateuser(UsersDto usersDto) {
        if (usersDto.getId() == null){
            return ResponseDto.<UsersDto>builder()
                    .code(2)
                    .success(false)
                    .message("user id is null")
                    .data(usersDto)
                    .build();
        }

        Optional<Users> usersOptional = usersRepository.findById(usersDto.getId());

        if (!usersOptional.isPresent()){
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .success(false)
                    .message("User not found")
                    .data(usersDto)
                    .build();
        }

        if (!usersOptional.get().getIsActive()){
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .success(false)
                    .message("User is not active")
                    .data(usersDto)
                    .build();
        }

        Users users = usersOptional.get();

        if (usersDto.getPassword() != null){
            users.setPassword(usersDto.getPassword());
        }
        if (usersDto.getEmail() != null){
            users.setEmail(usersDto.getEmail());
        }


        try{
            usersRepository.save(users);

            return ResponseDto.<UsersDto>builder()
                    .code(1)
                    .success(true)
                    .message("OK")
                    .data(usersDto)
                    .build();
        }catch (Exception e){
            return ResponseDto.<UsersDto>builder()
                    .code(2)
                    .success(false)
                    .message("Eror while saving user"+e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<List<UsersDto>>  getAllActiveUsers() {
          List<UsersDto> usersDtoList = usersRepository.findByIsActiveTrue()
                  .stream()
                  .map(usersMapper::toDto)
                  .collect(Collectors.toList());
        return ResponseDto.<List<UsersDto>>builder()
                .code(1)
                .success(true)
                .message("OK")
                .data(usersDtoList)
                .build();
    }

    @Override
    public ResponseDto<UsersDto> getUserById(Integer id) {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()){
            return ResponseDto.<UsersDto>builder()
                    .code(1)
                    .success(true)
                    .message("OK")
                    .data(usersMapper.toDto(usersOptional.get()))
                    .build();
        }else
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .success(false)
                    .message("User not found")
                    .build();
    }

    @Override
    public ResponseDto<UsersDto> deleteUser(Integer id) {
        if(id == null){
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .success(false)
                    .message("User id is null")
                    .build();
        }

        Users users = usersRepository.findById(id).orElse(null);

        if (users == null){
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .success(false)
                    .message("User not found")
                    .build();
        }

        users.setIsActive(false);

        try {
            usersRepository.save(users);

            return ResponseDto.<UsersDto>builder()
                    .code(1)
                    .success(true)
                    .message("OK")
                    .data(usersMapper.toDto(users))
                    .build();
        }catch (Exception e){
            return ResponseDto.<UsersDto>builder()
                    .code(2)
                    .success(false)
                    .message("Eror while saving user"+e.getMessage())
                    .build();
        }
    }

}
