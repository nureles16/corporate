package guru.springframework.corporate.mapper;

import guru.springframework.corporate.dto.request.AboutRequest;
import guru.springframework.corporate.dto.response.AboutResponse;
import guru.springframework.corporate.entity.About;

public class AboutMapper {

    public static AboutResponse toResponse(About about) {
        AboutResponse response = new AboutResponse();
        response.setId(about.getId());
        response.setContent(about.getContent());
        response.setUpdatedAt(about.getUpdatedAt());
        return response;
    }

    public static About toEntity(AboutRequest request) {
        About about = new About();
        about.setContent(request.getContent());
        return about;
    }

    public static void updateEntity(About about, AboutRequest request) {
        about.setContent(request.getContent());
    }
}