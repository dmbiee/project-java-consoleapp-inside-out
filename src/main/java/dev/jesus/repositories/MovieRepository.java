package dev.jesus.repositories;

import java.util.List;

import dev.jesus.db.MovieDatabase;
import dev.jesus.models.Movie;

public class MovieRepository {

    private MovieDatabase db;

    public MovieRepository() {
        this.db = new MovieDatabase();
    }

    public void StoreMovie(Movie movie) {
        db.store(movie);
    }

    public List<Movie> getAllMovies() {
        return db.getAllItems();
    }

    public void deleteMovie(String imdbid) {
        db.deleteItemByID(imdbid);
    }

}
