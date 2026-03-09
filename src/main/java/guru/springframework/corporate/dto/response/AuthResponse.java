package guru.springframework.corporate.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
public class AuthResponse {

    @Schema(description = "JWT authentication token")
    private String token;

    @Schema(description = "Username of authenticated user", example = "nureles")
    private String username;

    @Schema(description = "User role", example = "ADMIN")
    private String role;

    public AuthResponse() {
    }

    public AuthResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}