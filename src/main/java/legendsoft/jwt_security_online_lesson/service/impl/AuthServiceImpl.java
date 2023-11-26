package legendsoft.jwt_security_online_lesson.service.impl;

import legendsoft.jwt_security_online_lesson.config.security.JwtService;
import legendsoft.jwt_security_online_lesson.dto.AuthResponse;
import legendsoft.jwt_security_online_lesson.dto.AuthenticateRequest;
import legendsoft.jwt_security_online_lesson.dto.RegisterRequest;
import legendsoft.jwt_security_online_lesson.model.User;
import legendsoft.jwt_security_online_lesson.repository.UserRepository;
import legendsoft.jwt_security_online_lesson.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(request.password())
                .role(request.role())
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getRole());
    }

    @Override
    public AuthResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByUsername(request.username()).orElseThrow();
        return new AuthResponse(
                jwtService.generateToken(user),
                user.getRole()
        );
    }
}
