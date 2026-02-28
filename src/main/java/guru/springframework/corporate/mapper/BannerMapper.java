package guru.springframework.corporate.mapper;

import guru.springframework.corporate.dto.request.BannerRequest;
import guru.springframework.corporate.dto.response.BannerResponse;
import guru.springframework.corporate.entity.Banner;

public class BannerMapper {

    public static BannerResponse toResponse(Banner banner) {
        BannerResponse response = new BannerResponse();
        response.setId(banner.getId());
        response.setTitle(banner.getTitle());
        response.setSubtitle(banner.getSubtitle());
        response.setImageUrl(banner.getImageUrl());
        response.setButtonText(banner.getButtonText());
        response.setButtonLink(banner.getButtonLink());
        response.setActive(banner.isActive());
        response.setCreatedAt(banner.getCreatedAt());
        response.setUpdatedAt(banner.getUpdatedAt());
        return response;
    }

    public static Banner toEntity(BannerRequest request) {
        Banner banner = new Banner();
        banner.setTitle(request.getTitle());
        banner.setSubtitle(request.getSubtitle());
        banner.setImageUrl(request.getImageUrl());
        banner.setButtonText(request.getButtonText());
        banner.setButtonLink(request.getButtonLink());
        banner.setActive(request.isActive());
        return banner;
    }

    public static void updateEntity(Banner banner, BannerRequest request) {
        banner.setTitle(request.getTitle());
        banner.setSubtitle(request.getSubtitle());
        banner.setImageUrl(request.getImageUrl());
        banner.setButtonText(request.getButtonText());
        banner.setButtonLink(request.getButtonLink());
        banner.setActive(request.isActive());
    }
}