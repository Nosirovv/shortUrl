package uz.cristal.shorturl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Foydalanuvchilar", description = "Foydalanuvchilar bilan bog'liq API")
public class UsersController {
    private final UsersService usersService;


    @PostMapping
    @PreAuthorize("hasAuthority('user:create')")
    @Operation(summary = "Yangi foydalanuvchi qo'shish", description = "Yangi foydalanuvchi qo'shish uchun API")
    public ResponseDto<UsersDto> addUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.addUser(usersDto);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    @Operation(summary = "Foydalnuvchini IDsi bo'yicha ko'rish", description = "Foydalanuvchi ID bo'yicha malumotlarini qaytaradi")
    public ResponseDto<UsersDto> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }



    @PatchMapping()
    @PreAuthorize("hasAuthority('user:update')")
    @Operation(summary = "Foydalanuvchi malumotlari yangilash", description = "Berilgan malumot bo'yicha foydalanuchi malumotlarini yangilaydi")
    public ResponseDto<UsersDto> updateUsers(@Valid @RequestBody UsersDto usersDto) {
        return usersService.updateuser(usersDto);
    }


    @PreAuthorize("hasAuthority('user:readAll')")
    @GetMapping("/all-users")
    @Operation(summary = "Barcha foydalanuvchilarni ko'rish", description = "Barcha foydalanuvchilar ro'yxatini qaytaradi")
    public ResponseDto<List<UsersDto>> getAllActiveUsers() {
        return usersService.getAllActiveUsers();
    }


    @PreAuthorize("hasAuthority('user:delete')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Foydalanuchini o'chirish", description = "Berilgan ID bo'yicha foydalnuchi malumotlarni o'chirish")
    public ResponseDto<UsersDto> deleteUserByID(@PathVariable Integer id) {
        return usersService.deleteUser(id);
    }


}
