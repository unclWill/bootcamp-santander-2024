package me.dio.mapper;

import me.dio.domain.model.Card;
import me.dio.dto.CardDTO;

/**
 * @author William
 * @date 29/07/2024
 */


public class CardMapper {
    public static CardDTO toDTO(Card card) {
        if (card == null) {
            return null;
        }

        CardDTO dto = new CardDTO();
        dto.setNumber(card.getNumber());
        dto.setLimit(card.getLimit());
        return dto;
    }

    public static Card toEntity(CardDTO dto) {
        if (dto == null) {
            return null;
        }

        Card card = new Card();
        card.setNumber(dto.getNumber());
        card.setLimit(dto.getLimit());
        return card;
    }
}
