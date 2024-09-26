package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.cristal.shorturl.dto.JwtResponseDto;
import uz.cristal.shorturl.dto.LoginRequestDto;
import uz.cristal.shorturl.dto.RegisterRequestDto;
import uz.cristal.shorturl.entity.Role;
import uz.cristal.shorturl.entity.Users;
import uz.cristal.shorturl.repository.RoleRepository;
import uz.cristal.shorturl.repository.UsersRepository;
import uz.cristal.shorturl.security.JwtUtil;

import java.util.Collections;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequest) {
        if (usersRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Foydalanuvchi bu emaildan ro'yhatdan o'tgan");
        }

        Role userRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("User not found"));

        Users users = new Users();
        users.setEmail(registerRequest.getEmail());
        users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        users.setRoles(Collections.singleton(userRole));
        users.setIsActive(true);

        usersRepository.save(users);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getEmail();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequestDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
//            user = userService.findByUsername(username);
        } catch (AuthenticationException e) {
            return new ResponseEntity(e.getMessage(), BAD_REQUEST);
        }
        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }


}
