package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
public class BannerRequest {

    @Schema(description = "Banner title", example = "Welcome to our website")
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @Schema(description = "Banner subtitle", example = "Best services for your business")
    @Size(max = 150, message = "Subtitle too long")
    private String subtitle;

    @Schema(description = "Image URL", example = "https://example.com/banner.jpg")
    private String imageUrl;

    @Schema(description = "Button text", example = "Learn More")
    @Size(max = 50)
    private String buttonText;

    @Schema(description = "Button link", example = "https://example.com/services")
    private String buttonLink;

    @Schema(description = "Banner active status", example = "true")
    private boolean isActive;

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getButtonText() { return buttonText; }
    public void setButtonText(String buttonText) { this.buttonText = buttonText; }

    public String getButtonLink() { return buttonLink; }
    public void setButtonLink(String buttonLink) { this.buttonLink = buttonLink; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}