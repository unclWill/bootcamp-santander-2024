package me.dio.mapper;

import me.dio.domain.model.User;
import me.dio.dto.UserDTO;

import java.util.stream.Collectors;

/**
 * @author William
 * @date 29/07/2024
 */

public class UserMapper {
    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setAccount(AccountMapper.toDTO(user.getAccount()));
        dto.setCard(CardMapper.toDTO(user.getCard()));
        dto.setFeatures(user.getFeatures().stream()
                .map(FeatureMapper::toDTO)
                .collect(Collectors.toList()));
        dto.setNews(user.getNews().stream()
                .map(NewsMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setName(dto.getName());
        user.setAccount(AccountMapper.toEntity(dto.getAccount()));
        user.setCard(CardMapper.toEntity(dto.getCard()));
        user.setFeatures(dto.getFeatures().stream()
                .map(FeatureMapper::toEntity)
                .collect(Collectors.toList()));
        user.setNews(dto.getNews().stream()
                .map(NewsMapper::toEntity)
                .collect(Collectors.toList()));
        return user;
    }
}