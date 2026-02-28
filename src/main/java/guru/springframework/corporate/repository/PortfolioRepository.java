package guru.springframework.corporate.repository;

import guru.springframework.corporate.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    // Только опубликованные работы для USER
    List<Portfolio> findByIsPublishedTrueOrderByCreatedAtDesc();
}