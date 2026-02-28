package guru.springframework.corporate.repository;

import guru.springframework.corporate.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    // Только опубликованные новости для USER
    List<News> findByIsPublishedTrueOrderByCreatedAtDesc();
    Page<News> findByIsPublishedTrue(Pageable pageable);
    Page<News> findByIsPublishedTrueOrderByCreatedAtDesc(Pageable pageable);
}