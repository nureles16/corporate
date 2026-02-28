package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.ServicesRequest;
import guru.springframework.corporate.dto.response.ServicesResponse;
import guru.springframework.corporate.entity.Services;
import guru.springframework.corporate.mapper.NewsMapper;
import guru.springframework.corporate.mapper.ServicesMapper;
import guru.springframework.corporate.service.ServicesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServicesService servicesService;

    public ServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    // 🔹 Просмотр всех опубликованных услуг (USER + ADMIN)
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ServicesResponse> getAllServices() {
        return servicesService.getAllPublishedServices()
                .stream()
                .map(ServicesMapper::toResponse)
                .collect(Collectors.toList());
    }

    // 🔹 Просмотр услуги по ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ServicesResponse getServiceById(@PathVariable Long id) {
        Services service = servicesService.getServiceById(id);
        return ServicesMapper.toResponse(service);
    }

    // 🔹 Создать услугу (ADMIN)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ServicesResponse createService(@Valid @RequestBody ServicesRequest request) {
        Services service = ServicesMapper.toEntity(request);
        Services saved = servicesService.createService(service);
//        return ServicesMapper.toResponse(saved);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ServicesMapper.toResponse(saved)).getBody();
    }

    // 🔹 Обновить услугу (ADMIN)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ServicesResponse updateService(@PathVariable Long id,
                                          @Valid @RequestBody ServicesRequest request) {
        Services existing = servicesService.getServiceById(id);
        ServicesMapper.updateEntity(existing, request);
        Services updated = servicesService.updateService(id, existing);
        return ServicesMapper.toResponse(updated);
    }

    // 🔹 Удалить услугу (ADMIN)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }
}