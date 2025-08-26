package dev.jesus.mappers;

import java.util.List;
import java.util.stream.Collectors;

import dev.jesus.dtos.MovieDTO;
import dev.jesus.models.Movie;

public class MovieToDtoMapper {

    public static MovieDTO toDto(Movie movie) {
        return new MovieDTO(
                movie.getImdbid(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getEmocion(),
                movie.getReleaseMovieDate(),
                movie.getCreateMovieNoteDate());

    }

    public static List<MovieDTO> toDtoList(List<Movie> movies) {
        return movies.stream()
                .map(MovieToDtoMapper::toDto) // equals to .map(moment -> MomentToDtoMapper.toDto(moment))
                .collect(Collectors.toList());
    }
}
