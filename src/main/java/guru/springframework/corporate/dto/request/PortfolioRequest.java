package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
public class PortfolioRequest {

    @Schema(description = "Project title", example = "Corporate Website Development")
    @NotBlank(message = "Title is required")
    @Size(max = 150)
    private String title;

    @Schema(description = "Project description", example = "Website developed using Spring Boot and Angular")
    @NotBlank(message = "Description is required")
    private String description;

    @Schema(description = "Project image URL", example = "https://example.com/project.jpg")
    @NotBlank(message = "Image is required")
    private String imageUrl;

    @Schema(description = "Project website link", example = "https://project-site.com")
    private String projectUrl;

    @Schema(description = "Publication status", example = "true")
    private boolean isPublished;

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getProjectUrl() { return projectUrl; }
    public void setProjectUrl(String projectUrl) { this.projectUrl = projectUrl; }

    public boolean isPublished() { return isPublished; }
    public void setPublished(boolean published) { isPublished = published; }
}