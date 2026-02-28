package guru.springframework.corporate.mapper;

import guru.springframework.corporate.dto.request.NewsRequest;
import guru.springframework.corporate.dto.response.NewsResponse;
import guru.springframework.corporate.entity.News;

public class NewsMapper {

    public static NewsResponse toResponse(News news) {
        NewsResponse response = new NewsResponse();
        response.setId(news.getId());
        response.setTitle(news.getTitle());
        response.setDescription(news.getDescription());
        response.setContent(news.getContent());
        response.setImageUrl(news.getImageUrl());
        response.setCreatedAt(news.getCreatedAt());
        response.setUpdatedAt(news.getUpdatedAt());
        response.setPublished(news.isPublished());
        return response;
    }

    public static News toEntity(NewsRequest request) {
        News news = new News();
        news.setTitle(request.getTitle());
        news.setDescription(request.getDescription());
        news.setContent(request.getContent());
        news.setImageUrl(request.getImageUrl());
        news.setPublished(request.isPublished());
        return news;
    }

    public static void updateEntity(News news, NewsRequest request) {
        news.setTitle(request.getTitle());
        news.setDescription(request.getDescription());
        news.setContent(request.getContent());
        news.setImageUrl(request.getImageUrl());
        news.setPublished(request.isPublished());
    }
}