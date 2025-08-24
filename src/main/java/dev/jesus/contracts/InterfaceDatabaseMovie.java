package dev.jesus.contracts;

import java.util.List;

import dev.jesus.models.Movie;

public interface InterfaceDatabaseMovie {

    public void store(Movie movie);

    List<Movie> getAllMovie();

    public void deleteMoment(String imdbid);
}
