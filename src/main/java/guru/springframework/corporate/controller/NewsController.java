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

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // ================= USER =================
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Page<NewsResponse> getAllPublishedNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<News> newsPage = newsService.getAllPublishedNews(page, size);
        return newsPage.map(NewsMapper::toResponse);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public NewsResponse getNewsById(@PathVariable Long id) {
        return NewsMapper.toResponse(newsService.getNewsById(id));
    }

    // ================= ADMIN =================
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public List<NewsResponse> getAllNewsForAdmin() {
        return newsService.getAllNewsForAdmin()
                .stream()
                .map(NewsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public NewsResponse createNews(@Valid @RequestBody NewsRequest request) {
        News news = newsService.createNews(NewsMapper.toEntity(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(NewsMapper.toResponse(news)).getBody();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public NewsResponse updateNews(@PathVariable Long id, @Valid @RequestBody NewsRequest request) {
        News existing = newsService.getNewsById(id);
        NewsMapper.updateEntity(existing, request);
        return NewsMapper.toResponse(newsService.updateNews(id, existing));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}