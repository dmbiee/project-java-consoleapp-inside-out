package dev.jesus.dtos;

import java.time.LocalDate;
import java.util.List;

import dev.jesus.models.EmotionEnum;

public record MovieDTO(
                String imdbid,
                String title,
                List<String> genre,
                EmotionEnum emocion,
                LocalDate releaseMovieDate,
                LocalDate createMovieNoteDate) {
}
