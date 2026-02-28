package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AboutRequest {

    @NotBlank(message = "Content is required")
    private String content;

    // Getter & Setter
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}