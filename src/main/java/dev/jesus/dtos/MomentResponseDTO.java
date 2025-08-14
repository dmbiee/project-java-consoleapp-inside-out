package dev.jesus.dtos;

import dev.jesus.models.EmotionEnum;

public record MomentResponseDTO(
                String title,
                String date,
                String description,
                EmotionEnum emotion) {
}
