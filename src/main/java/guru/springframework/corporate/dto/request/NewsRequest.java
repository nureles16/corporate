package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
public class NewsRequest {

    @Schema(description = "News title", example = "Company launches new product")
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200)
    private String title;

    @Schema(description = "Short description", example = "Short preview of the news")
    @NotBlank(message = "Description is required")
    @Size(max = 500)
    private String description;

    @Schema(description = "Full content of the news article")
    @NotBlank(message = "Content is required")
    private String content;

    @Schema(description = "Image URL", example = "https://example.com/news.jpg")
    private String imageUrl;

    @Schema(description = "Publication status", example = "true")
    private boolean isPublished;

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public boolean isPublished() { return isPublished; }
    public void setPublished(boolean published) { isPublished = published; }
}