package dev.jesus.dtos;

import java.time.LocalDate;

import dev.jesus.models.EmotionEnum;

public record MomentResponseDTO(
                String id,
                String title,
                LocalDate date,
                String description,
                EmotionEnum emotion,
                boolean isPositive) {

}
