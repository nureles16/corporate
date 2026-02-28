package guru.springframework.corporate.mapper;


import guru.springframework.corporate.dto.request.ServicesRequest;
import guru.springframework.corporate.dto.response.ServicesResponse;
import guru.springframework.corporate.entity.Services;

public class ServicesMapper {

    public static ServicesResponse toResponse(Services service) {
        ServicesResponse response = new ServicesResponse();
        response.setId(service.getId());
        response.setTitle(service.getTitle());
        response.setDescription(service.getDescription());
        response.setIconUrl(service.getIconUrl());
        response.setPrice(service.getPrice());
        response.setPublished(service.isPublished());
        response.setCreatedAt(service.getCreatedAt());
        return response;
    }

    public static Services toEntity(ServicesRequest request) {
        Services service = new Services();
        service.setTitle(request.getTitle());
        service.setDescription(request.getDescription());
        service.setIconUrl(request.getIconUrl());
        service.setPrice(request.getPrice());
        service.setPublished(request.isPublished());
        return service;
    }

    public static void updateEntity(Services service, ServicesRequest request) {
        service.setTitle(request.getTitle());
        service.setDescription(request.getDescription());
        service.setIconUrl(request.getIconUrl());
        service.setPrice(request.getPrice());
        service.setPublished(request.isPublished());
    }
}