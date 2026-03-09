package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.NewsRequest;
import guru.springframework.corporate.dto.response.NewsResponse;
import guru.springframework.corporate.entity.Banner;
import guru.springframework.corporate.entity.News;
import guru.springframework.corporate.mapper.BannerMapper;
import guru.springframework.corporate.mapper.NewsMapper;
import guru.springframework.corporate.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/news")
@Tag(name = "News", description = "News management API")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // ================= USER =================
    @Operation(summary = "Get all published news with pagination")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Page<NewsResponse> getAllPublishedNews(
            @Parameter(description = "Page number", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "10")
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<News> newsPage = newsService.getAllPublishedNews(page, size);
        return newsPage.map(NewsMapper::toResponse);
    }

    @Operation(summary = "Get news by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public NewsResponse getNewsById(@PathVariable Long id) {
        return NewsMapper.toResponse(newsService.getNewsById(id));
    }

    // ================= ADMIN =================
    @Operation(summary = "Get all news for admin")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public List<NewsResponse> getAllNewsForAdmin() {
        return newsService.getAllNewsForAdmin()
                .stream()
                .map(NewsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Create news (Admin only)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<NewsResponse> createNews(
            @Valid @RequestBody NewsRequest request) {
        News news = newsService.createNews(NewsMapper.toEntity(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(NewsMapper.toResponse(news));
    }

    @Operation(summary = "Update news (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public NewsResponse updateNews(
            @PathVariable Long id,
            @Valid @RequestBody NewsRequest request) {

        News existing = newsService.getNewsById(id);
        NewsMapper.updateEntity(existing, request);
        return NewsMapper.toResponse(newsService.updateNews(id, existing));
    }

    @Operation(summary = "Delete news (Admin only)")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}