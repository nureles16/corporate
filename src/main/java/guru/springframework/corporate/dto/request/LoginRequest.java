package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginRequest {

    @Schema(description = "Username", example = "nureles")
    @NotBlank(message = "Username is required")
    private String username;

    @Schema(description = "Password", example = "password123")
    @NotBlank(message = "Password is required")
    private String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}