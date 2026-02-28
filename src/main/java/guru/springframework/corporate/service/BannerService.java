package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.Banner;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.BannerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BannerService {

    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    // 🔹 Получить все активные баннеры
    public List<Banner> getAllActiveBanners() {
        return bannerRepository.findByIsActiveTrue();
    }

    // 🔹 Получить баннер по ID
    public Banner getBannerById(Long id) {
        return bannerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contacts not found with id: " + id));
    }

    // 🔹 Создать баннер
    public Banner createBanner(Banner banner) {
        banner.setCreatedAt(LocalDateTime.now());
        banner.setUpdatedAt(LocalDateTime.now());
        return bannerRepository.save(banner);
    }

    // 🔹 Обновить баннер
    public Banner updateBanner(Banner banner) {
        banner.setUpdatedAt(LocalDateTime.now());
        return bannerRepository.save(banner);
    }

    // 🔹 Удалить баннер
    public void deleteBanner(Long id) {
        Banner banner = getBannerById(id);
        bannerRepository.delete(banner);
    }
}