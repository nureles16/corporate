package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.BannerRequest;
import guru.springframework.corporate.dto.response.BannerResponse;
import guru.springframework.corporate.entity.Banner;
import guru.springframework.corporate.mapper.BannerMapper;
import guru.springframework.corporate.service.BannerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/banners")
@Tag(name = "Banners", description = "Banner management API")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    // 🔹 Получить все активные баннеры
    @Operation(summary = "Get all active banners")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<BannerResponse> getAllActiveBanners() {
        return bannerService.getAllActiveBanners()
                .stream()
                .map(BannerMapper::toResponse)
                .collect(Collectors.toList());
    }

    // 🔹 Получить баннер по ID
    @Operation(summary = "Get banner by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public BannerResponse getBannerById(@PathVariable Long id) {
        Banner banner = bannerService.getBannerById(id);
        return BannerMapper.toResponse(banner);
    }

    // 🔹 Создать баннер
    @Operation(summary = "Create new banner (Admin only)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BannerResponse> createBanner(
            @Valid @RequestBody BannerRequest request) {
        Banner banner = BannerMapper.toEntity(request);
        Banner saved = bannerService.createBanner(banner);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BannerMapper.toResponse(saved));
    }

    // 🔹 Обновить баннер
    @Operation(summary = "Update banner (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BannerResponse updateBanner(
            @PathVariable Long id,
            @Valid @RequestBody BannerRequest request) {
        Banner existing = bannerService.getBannerById(id);
        BannerMapper.updateEntity(existing, request);
        Banner updated = bannerService.updateBanner(existing);
        return BannerMapper.toResponse(updated);
    }

    // 🔹 Удалить баннер
    @Operation(summary = "Delete banner (Admin only)")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBanner(@PathVariable Long id) {
        bannerService.deleteBanner(id);
    }
}