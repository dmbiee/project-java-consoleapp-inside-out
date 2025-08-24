package dev.jesus.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.jesus.contracts.InterfaceDatabaseMovie;
import dev.jesus.models.Movie;

public class MovieDatabase implements InterfaceDatabaseMovie {

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
    public List<Movie> getAllMovie() {
        return movies;
    }

    @Override
    public void deleteMoment(String imdbid) {
        movies.removeIf(movie -> movie.getImdbid().equals(imdbid));
    }
}
