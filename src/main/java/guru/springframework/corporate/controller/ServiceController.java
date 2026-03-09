package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.ServicesRequest;
import guru.springframework.corporate.dto.response.ServicesResponse;
import guru.springframework.corporate.entity.Services;
import guru.springframework.corporate.mapper.ServicesMapper;
import guru.springframework.corporate.service.ServicesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Services", description = "Services management API")
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServicesService servicesService;

    public ServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    // 🔹 Просмотр всех опубликованных услуг
    @Operation(summary = "Get all published services")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ServicesResponse> getAllServices() {
        return servicesService.getAllPublishedServices()
                .stream()
                .map(ServicesMapper::toResponse)
                .toList();
    }

    // 🔹 Просмотр услуги по ID
    @Operation(summary = "Get service by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ServicesResponse getServiceById(@PathVariable Long id) {
        Services service = servicesService.getServiceById(id);
        return ServicesMapper.toResponse(service);
    }

    // 🔹 Создать услугу
    @Operation(summary = "Create new service (Admin only)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ServicesResponse> createService(
            @Valid @RequestBody ServicesRequest request) {
        Services service = ServicesMapper.toEntity(request);
        Services saved = servicesService.createService(service);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ServicesMapper.toResponse(saved));
    }

    // 🔹 Обновить услугу
    @Operation(summary = "Update service (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ServicesResponse updateService(
            @PathVariable Long id,
            @Valid @RequestBody ServicesRequest request) {
        Services existing = servicesService.getServiceById(id);
        ServicesMapper.updateEntity(existing, request);
        Services updated = servicesService.updateService(id, existing);
        return ServicesMapper.toResponse(updated);
    }

    // 🔹 Удалить услугу
    @Operation(summary = "Delete service (Admin only)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }
}