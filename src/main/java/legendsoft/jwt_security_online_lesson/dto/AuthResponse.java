package legendsoft.jwt_security_online_lesson.dto;

import legendsoft.jwt_security_online_lesson.enums.Role;

public record AuthResponse(
        String token,
        Role role
){

}
