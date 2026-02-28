package guru.springframework.corporate.mapper;

import guru.springframework.corporate.dto.request.PortfolioRequest;
import guru.springframework.corporate.dto.response.PortfolioResponse;
import guru.springframework.corporate.entity.Portfolio;

public class PortfolioMapper {

    public static PortfolioResponse toResponse(Portfolio portfolio) {
        PortfolioResponse response = new PortfolioResponse();
        response.setId(portfolio.getId());
        response.setTitle(portfolio.getTitle());
        response.setDescription(portfolio.getDescription());
        response.setImageUrl(portfolio.getImageUrl());
        response.setProjectUrl(portfolio.getProjectUrl());
        response.setCreatedAt(portfolio.getCreatedAt());
        response.setPublished(portfolio.isPublished());
        return response;
    }

    public static Portfolio toEntity(PortfolioRequest request) {
        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(request.getTitle());
        portfolio.setDescription(request.getDescription());
        portfolio.setImageUrl(request.getImageUrl());
        portfolio.setProjectUrl(request.getProjectUrl());
        portfolio.setPublished(request.isPublished());
        return portfolio;
    }

    public static void updateEntity(Portfolio portfolio, PortfolioRequest request) {
        portfolio.setTitle(request.getTitle());
        portfolio.setDescription(request.getDescription());
        portfolio.setImageUrl(request.getImageUrl());
        portfolio.setProjectUrl(request.getProjectUrl());
        portfolio.setPublished(request.isPublished());
    }
}