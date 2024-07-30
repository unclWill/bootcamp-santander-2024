package me.dio.mapper;

import me.dio.domain.model.Feature;
import me.dio.dto.FeatureDTO;

/**
 * @author William
 * @date 29/07/2024
 */

public class FeatureMapper {
    public static FeatureDTO toDTO(Feature feature) {
        if (feature == null) {
            return null;
        }

        FeatureDTO dto = new FeatureDTO();
        dto.setId(feature.getId());
        dto.setIcon(feature.getIcon());
        dto.setDescription(feature.getDescription());
        return dto;
    }

    public static Feature toEntity(FeatureDTO dto) {
        if (dto == null) {
            return null;
        }

        Feature feature = new Feature();
        feature.setId(dto.getId());
        feature.setIcon(dto.getIcon());
        feature.setDescription(dto.getDescription());
        return feature;
    }
}
