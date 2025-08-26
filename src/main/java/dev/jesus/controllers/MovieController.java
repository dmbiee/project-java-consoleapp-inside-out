package dev.jesus.controllers;

import java.util.List;

import dev.jesus.db.MovieCSVStorage;
import dev.jesus.dtos.MovieDTO;
import dev.jesus.mappers.DtoToMovieMapper;
import dev.jesus.mappers.MovieToDtoMapper;
import dev.jesus.models.Movie;
import dev.jesus.repositories.MovieRepository;
import dev.jesus.singletons.MovieRepositorySingleton;

public class MovieController {

    private MovieRepository repository;
    private MovieCSVStorage csvStorage;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
        this.csvStorage = new MovieCSVStorage();
    }

    public void StoreMovie(MovieDTO dto) {
        Movie movieToSave = DtoToMovieMapper.toEntity(dto);
        repository.StoreMovie(movieToSave);
    }

    public List<MovieDTO> getDB() {
        List<Movie> movies = repository.getAllMovies();
        return MovieToDtoMapper.toDtoList(movies);
    }

    public void deleteMovie(String imdbid) {
        repository.deleteMovie(imdbid);
    }

    public void exportMomentsToCSV(String filePath) {
        List<Movie> movies = repository.getAllMovies();
        csvStorage.exportMovieToCsv(movies, filePath);
    }

}