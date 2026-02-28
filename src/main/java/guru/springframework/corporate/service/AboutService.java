package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.About;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.AboutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AboutService {

    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    // 🔹 Получить About (берём первую запись)
    public About getAbout() {
        return aboutRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("About section not found"));
    }

    // 🔹 Получить About по ID (для обновления)
    public About getAboutById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("About section not found"+ id));
    }

    // 🔹 Обновление About
    public About updateAbout(About about) {
        about.setUpdatedAt(LocalDateTime.now());
        return aboutRepository.save(about);
    }
}