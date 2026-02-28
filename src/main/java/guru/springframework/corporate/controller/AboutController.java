package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.AboutRequest;
import guru.springframework.corporate.dto.response.AboutResponse;
import guru.springframework.corporate.entity.About;
import guru.springframework.corporate.mapper.AboutMapper;
import guru.springframework.corporate.service.AboutService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    // 🔹 Просмотр страницы (USER + ADMIN)
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public AboutResponse getAbout() {
        About about = aboutService.getAbout();
        return AboutMapper.toResponse(about);
    }

    // 🔹 Обновление страницы (ADMIN)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AboutResponse updateAbout(@PathVariable Long id,
                                     @Valid @RequestBody AboutRequest request) {
        About existing = aboutService.getAboutById(id);
        AboutMapper.updateEntity(existing, request);
        About updated = aboutService.updateAbout(existing);
        return AboutMapper.toResponse(updated);
    }
}