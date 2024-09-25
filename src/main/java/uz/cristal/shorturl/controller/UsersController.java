package uz.cristal.shorturl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.service.UsersService;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;


    @PostMapping
    public ResponseDto<UsersDto> addUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.addUser(usersDto);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseDto<UsersDto> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }



    @PatchMapping()
    public ResponseDto<UsersDto> updateUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.updateuser(usersDto);
    }


    @GetMapping("/all-users")
    public ResponseDto<List<UsersDto>> getAllActiveUsers() {
        return usersService.getAllActiveUsers();
    }


    @DeleteMapping("/{id}")
    public ResponseDto<UsersDto> deleteUserByID(@PathVariable Integer id) {
        return usersService.deleteUser(id);
    }


}
