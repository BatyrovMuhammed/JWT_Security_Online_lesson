package legendsoft.jwt_security_online_lesson.dto;

public record AuthenticateRequest(
        String username,
        String password
) {
}
