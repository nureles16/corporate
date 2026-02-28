package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.Portfolio;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    // 🔹 Получить все опубликованные работы
    public List<Portfolio> getAllPublishedPortfolios() {
        return portfolioRepository.findByIsPublishedTrueOrderByCreatedAtDesc();
    }

    // 🔹 Получить работу по ID
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Portfolio not found with id: " + id));
    }

    // 🔹 Создать работу (ADMIN)
    public Portfolio createPortfolio(Portfolio portfolio) {
        portfolio.setCreatedAt(LocalDateTime.now());
        return portfolioRepository.save(portfolio);
    }

    // 🔹 Обновить работу (ADMIN)
    public Portfolio updatePortfolio(Long id, Portfolio updatedPortfolio) {
        Portfolio portfolio = getPortfolioById(id);

        portfolio.setTitle(updatedPortfolio.getTitle());
        portfolio.setDescription(updatedPortfolio.getDescription());
        portfolio.setImageUrl(updatedPortfolio.getImageUrl());
        portfolio.setProjectUrl(updatedPortfolio.getProjectUrl());
        portfolio.setPublished(updatedPortfolio.isPublished());

        return portfolioRepository.save(portfolio);
    }

    // 🔹 Удалить работу (ADMIN)
    public void deletePortfolio(Long id) {
        Portfolio portfolio = getPortfolioById(id);
        portfolioRepository.delete(portfolio);
    }
}