package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.Services;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.ServicesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    // 🔹 Получить все опубликованные услуги
    public List<Services> getAllPublishedServices() {
        return servicesRepository.findByIsPublishedTrueOrderByCreatedAtDesc();
    }

    // 🔹 Получить услугу по ID
    public Services getServiceById(Long id) {
        return servicesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Service not found with id: " + id));
    }

    // 🔹 Создать услугу (ADMIN)
    public Services createService(Services service) {
        service.setCreatedAt(LocalDateTime.now());
        return servicesRepository.save(service);
    }

    // 🔹 Обновить услугу (ADMIN)
    public Services updateService(Long id, Services updatedService) {
        Services service = getServiceById(id);

        service.setTitle(updatedService.getTitle());
        service.setDescription(updatedService.getDescription());
        service.setIconUrl(updatedService.getIconUrl());
        service.setPrice(updatedService.getPrice());
        service.setPublished(updatedService.isPublished());

        return servicesRepository.save(service);
    }

    // 🔹 Удалить услугу (ADMIN)
    public void deleteService(Long id) {
        Services service = getServiceById(id);
        servicesRepository.delete(service);
    }
}