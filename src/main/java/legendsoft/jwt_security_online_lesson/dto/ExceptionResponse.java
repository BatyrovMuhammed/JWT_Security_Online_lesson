package legendsoft.jwt_security_online_lesson.dto;

public record ExceptionResponse(
        String exceptionClassname,
        String message
) {
}
