package dev.jesus.singletons;

import dev.jesus.repositories.MovieRepository;

public class MovieRepositorySingleton {

    private static MovieRepository INSTANCE;

    private MovieRepositorySingleton() {
    }

    public static MovieRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieRepository();
        }
        return INSTANCE;
    }
}
