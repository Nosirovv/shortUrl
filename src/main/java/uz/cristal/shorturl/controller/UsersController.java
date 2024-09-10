package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.service.UsersService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {


    private final UsersService usersService;

    @PostMapping
    public ResponseDto<UsersDto> addUsers(@RequestBody @Valid UsersDto usersDto){
        return usersService.addUser(usersDto);
    }


//    @PatchMapping()
//    public ResponseDto<UsersDto> updateUsers(@RequestBody @Valid UsersDto usersDto){
//        return usersService.updateuser(usersDto);
//    }
//
//
//    @GetMapping("/all-users")
//    public ResponseDto<List<UsersDto>> getAllActiveUsers(){
//        return usersService.getAllActiveUsers();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseDto<UsersDto> getUserById(@RequestParam Integer id){
//        return usersService.getUserById(id);
//    }
}
