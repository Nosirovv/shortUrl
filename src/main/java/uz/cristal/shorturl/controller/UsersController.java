package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;
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
    public ResponseDto<UsersDto> addUsers(@RequestBody @Valid UsersDto usersDto) {
        return usersService.addUser(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<UsersDto> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }


    @PatchMapping()
    public ResponseDto<UsersDto> updateUsers(@RequestBody @Valid UsersDto usersDto){
        return usersService.updateuser(usersDto);
    }


    @GetMapping("/all-users")
    public ResponseDto<List<UsersDto>> getAllActiveUsers(){
        return usersService.getAllActiveUsers();
    }


    @DeleteMapping("/{id}")
    public ResponseDto<UsersDto> deleteUserByID(@PathVariable Integer id){
        return usersService.deleteUser(id);     
    }


}
