package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.PortfolioRequest;
import guru.springframework.corporate.dto.response.PortfolioResponse;
import guru.springframework.corporate.entity.Portfolio;
import guru.springframework.corporate.mapper.PortfolioMapper;
import guru.springframework.corporate.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Portfolio", description = "Portfolio management APIs")
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // 🔹 Просмотр всех опубликованных работ
    @Operation(summary = "Get all published portfolio items")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<PortfolioResponse> getAllPortfolios() {
        return portfolioService.getAllPublishedPortfolios()
                .stream()
                .map(PortfolioMapper::toResponse)
                .toList();
    }

    // 🔹 Просмотр работы по ID
    @Operation(summary = "Get portfolio item by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public PortfolioResponse getPortfolioById(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return PortfolioMapper.toResponse(portfolio);
    }

    // 🔹 Создать работу
    @Operation(summary = "Create new portfolio item (Admin only)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PortfolioResponse> createPortfolio(
            @Valid @RequestBody PortfolioRequest request) {
        Portfolio portfolio = PortfolioMapper.toEntity(request);
        Portfolio saved = portfolioService.createPortfolio(portfolio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PortfolioMapper.toResponse(saved));
    }

    // 🔹 Обновить работу
    @Operation(summary = "Update portfolio item (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PortfolioResponse updatePortfolio(
            @PathVariable Long id,
            @Valid @RequestBody PortfolioRequest request) {
        Portfolio existing = portfolioService.getPortfolioById(id);
        PortfolioMapper.updateEntity(existing, request);
        Portfolio updated = portfolioService.updatePortfolio(id, existing);
        return PortfolioMapper.toResponse(updated);
    }

    // 🔹 Удалить работу
    @Operation(summary = "Delete portfolio item (Admin only)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
    }
}