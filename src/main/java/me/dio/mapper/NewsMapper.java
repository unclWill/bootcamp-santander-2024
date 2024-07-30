package me.dio.mapper;

import me.dio.domain.model.News;
import me.dio.dto.NewsDTO;

/**
 * @author William
 * @date 29/07/2024
 */

public class NewsMapper {
    public static NewsDTO toDTO(News news) {
        if (news == null) {
            return null;
        }

        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setIcon(news.getIcon());
        dto.setDescription(news.getDescription());
        return dto;
    }

    public static News toEntity(NewsDTO dto) {
        if (dto == null) {
            return null;
        }

        News news = new News();
        news.setId(dto.getId());
        news.setIcon(dto.getIcon());
        news.setDescription(dto.getDescription());
        return news;
    }
}
