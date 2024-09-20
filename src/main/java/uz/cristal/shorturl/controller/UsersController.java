package uz.cristal.shorturl.controller;

import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.dto.UsersDto;
import uz.cristal.shorturl.service.UsersService;
import uz.cristal.shorturl.token.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final JwtUtil jwtUtil;

    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping
    public ResponseDto<UsersDto> addUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.addUser(usersDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseDto<UsersDto> getUserById(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
        Claims claims = jwtUtil.extractAllClaims(token.replaceAll("Bearer ", ""));
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return usersService.getUserById(id);
    }


    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PatchMapping()
    public ResponseDto<UsersDto> updateUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.updateuser(usersDto);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
    @GetMapping("/all-users")
    public ResponseDto<List<UsersDto>> getAllActiveUsers() {
        return usersService.getAllActiveUsers();
    }


    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseDto<UsersDto> deleteUserByID(@PathVariable Integer id) {
        return usersService.deleteUser(id);
    }


}
