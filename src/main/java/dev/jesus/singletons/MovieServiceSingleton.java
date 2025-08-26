package dev.jesus.singletons;

import dev.jesus.services.MovieService;

public class MovieServiceSingleton {

    private static final MovieService INSTANCE = new MovieService();

    private MovieServiceSingleton() {
    }

    public static MovieService getInstance() {
        return INSTANCE;
    }

}
