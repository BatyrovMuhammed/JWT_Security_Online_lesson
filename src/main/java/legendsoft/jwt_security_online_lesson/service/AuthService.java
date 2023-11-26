package legendsoft.jwt_security_online_lesson.service;

import legendsoft.jwt_security_online_lesson.dto.AuthResponse;
import legendsoft.jwt_security_online_lesson.dto.AuthenticateRequest;
import legendsoft.jwt_security_online_lesson.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticateRequest request);
}
