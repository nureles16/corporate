package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.News;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // Получить все опубликованные новости с пагинацией
    public Page<News> getAllPublishedNews(int page, int size) {
        return newsRepository.findByIsPublishedTrueOrderByCreatedAtDesc(PageRequest.of(page, size));
    }

    // Получить по id
    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("News not found with id: " + id));
    }

    // Создать новость
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    // Обновить новость
    public News updateNews(Long id, News news) {
        news.setId(id);
        return newsRepository.save(news);
    }

    // Удалить новость
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    // Получить все новости без фильтра (для ADMIN)
    public List<News> getAllNewsForAdmin() {
        return newsRepository.findAll();
    }
}