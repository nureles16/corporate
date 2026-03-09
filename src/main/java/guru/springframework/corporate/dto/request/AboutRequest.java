package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
public class AboutRequest {

    @Schema(description = "Content of the About page", example = "Our company was founded in 2020...")
    @NotBlank(message = "Content is required")
    private String content;

    // Getter & Setter
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}