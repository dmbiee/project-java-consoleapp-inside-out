package dev.jesus.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.jesus.contracts.InterfaceDatabase;
import dev.jesus.models.Movie;

public class MovieDatabase implements InterfaceDatabase<Movie> {

    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    @Override
    public void store(Movie movie) {

        movie.setCreateMovieNoteDate(LocalDate.now());
        movies.add(movie);
    }

    @Override
    public List<Movie> getAllItems() {
        return movies;
    }

    @Override
    public void deleteItemByID(String imdbid) {
        movies.removeIf(movie -> movie.getImdbid().equals(imdbid));
    }
}
