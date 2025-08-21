package dev.jesus.dtos;

import dev.jesus.models.EmotionEnum;

public record MomentRequestDTO(
        String title,
        String date,
        String description,
        EmotionEnum emotion,
        String isPositive) {
}
