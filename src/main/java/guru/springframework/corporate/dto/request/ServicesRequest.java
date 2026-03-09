package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
public class ServicesRequest {

    @Schema(description = "Service title", example = "Web Development")
    @NotBlank(message = "Title is required")
    private String title;

    @Schema(description = "Service description", example = "Full-stack web development using modern technologies")
    @NotBlank(message = "Description is required")
    private String description;

    @Schema(description = "Service icon URL", example = "https://example.com/icon.png")
    private String iconUrl;

    @Schema(description = "Service price", example = "500.00")
    @PositiveOrZero(message = "Price must be positive")
    private BigDecimal price;

    @Schema(description = "Publication status", example = "true")
    private boolean isPublished;

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public boolean isPublished() { return isPublished; }
    public void setPublished(boolean published) { isPublished = published; }
}