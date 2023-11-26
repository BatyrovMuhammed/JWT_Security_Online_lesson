package legendsoft.jwt_security_online_lesson.api;

import legendsoft.jwt_security_online_lesson.dto.AuthResponse;
import legendsoft.jwt_security_online_lesson.dto.AuthenticateRequest;
import legendsoft.jwt_security_online_lesson.dto.RegisterRequest;
import legendsoft.jwt_security_online_lesson.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthenticateRequest request) {
        return authService.authenticate(request);
    }
}
