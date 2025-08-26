package dev.jesus.mappers;

import dev.jesus.dtos.MovieDTO;
import dev.jesus.models.Movie;

public class DtoToMovieMapper {

    public static Movie toEntity(MovieDTO dto) {
        Movie movie = new Movie(dto.imdbid(), dto.title(), dto.genre(), dto.emocion(), dto.releaseMovieDate(),
                dto.createMovieNoteDate());
        return movie;
    }
}
