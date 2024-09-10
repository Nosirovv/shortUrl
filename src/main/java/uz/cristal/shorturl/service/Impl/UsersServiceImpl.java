package uz.cristal.shorturl.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.mapper.UsersMapper;
import uz.cristal.shorturl.service.UsersService;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersMapper usersMapper;

    public ResponseDto<UsersDto> addUser(UsersDto usersDto){
        return ResponseDto.<UsersDto>builder()
                    .code(1)
                    .success(true)
                    .message("OK")
                    .data(usersDto)
                    .build();
    }


//    @Autowired
//    private UsersRepository usersRepository;
//    @Autowired
//    private UsersMapper usersMapper;
//
//    @Override
//    public ResponseDto<UsersDto> addUser(UsersDto usersDto) {
//        try {
//            usersRepository.save(usersMapper.toEntity(usersDto));
//
//            return ResponseDto.<UsersDto>builder()
//                    .code(1)
//                    .success(true)
//                    .message("OK")
//                    .data(usersDto)
//                    .build();
//        }catch (Exception e){
//            ResponseDto.<UsersDto>builder()
//                    .code(2)
//                    .success(false)
//                    .message("Database eror")
//                    .data(null)
//                    .build();
//        }
//
//        return null;
//    }

//    @Override
//    public ResponseDto<UsersDto> updateuser(UsersDto usersDto) {
//        if (usersDto.getId() == null){
//            return ResponseDto.<UsersDto>builder()
//                    .code(2)
//                    .success(false)
//                    .message("user id is null")
//                    .data(usersDto)
//                    .build();
//        }
//
//        Optional<Users> usersOptional = usersRepository.findById(usersDto.getId());
//
//        if (!usersDto.isActive()){
//            return ResponseDto.<UsersDto>builder()
//                    .code(0)
//                    .success(false)
//                    .message("User id:"+usersDto.getId()+"is not found")
//                    .data(usersDto)
//                    .build();
//        }
//
//        try{
//            usersRepository.save(usersOptional.get());
//
//            return ResponseDto.<UsersDto>builder()
//                    .code(1)
//                    .success(true)
//                    .message("OK")
//                    .build();
//        }catch (Exception e){
//            return ResponseDto.<UsersDto>builder()
//                    .code(2)
//                    .success(false)
//                    .message("Eror while saving user"+e.getMessage())
//                    .build();
//        }
//
//    }
//
//    @Override
//    public ResponseDto<List<UsersDto>> getAllActiveUsers() {
//        return null;
//    }
//
//    @Override
//    public ResponseDto<UsersDto> getUserById(Integer id) {
//        Optional<Users> usersOptional = usersRepository.findById(id);
//        if (usersOptional.isPresent()){
//            return ResponseDto.<UsersDto>builder()
//                    .code(1)
//                    .success(true)
//                    .message("OK")
//                    .data(usersMapper.toDto(usersOptional.get()))
//                    .build();
//        }else
//            return ResponseDto.<UsersDto>builder()
//                    .code(0)
//                    .success(false)
//                    .message("User not found")
//                    .build();
//    }
}
