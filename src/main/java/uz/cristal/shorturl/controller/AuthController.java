package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.cristal.shorturl.dto.JwtResponseDto;
import uz.cristal.shorturl.dto.LoginRequestDto;
import uz.cristal.shorturl.dto.RegisterRequestDto;
import uz.cristal.shorturl.dto.ResponseDto;
import uz.cristal.shorturl.entity.Role;
import uz.cristal.shorturl.entity.Users;
import uz.cristal.shorturl.repository.RoleRepository;
import uz.cristal.shorturl.repository.UsersRepository;
import uz.cristal.shorturl.security.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequest){
        if (usersRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Foydalanuvchi bu emaildan ro'yhatdan o'tgan");
        }

        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(()-> new RuntimeException("User not found"));

        Users users = new Users();
        users.setEmail(registerRequest.getEmail());
        users.setPassword(registerRequest.getPassword());
        users.setRoles(Collections.singleton(userRole));
        users.setIsActive(true);

        usersRepository.save(users);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully.");

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtUtil.generateToken((UserDetails) authentication);

        return ResponseEntity.ok(new JwtResponseDto(jwtToken));
    }

}
