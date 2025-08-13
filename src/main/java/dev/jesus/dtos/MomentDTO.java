package dev.jesus.dtos;

import dev.jesus.models.EmotionEnum;

public record MomentDTO(
    String title,
    String date,
    String description,
    EmotionEnum emotion) {
}
