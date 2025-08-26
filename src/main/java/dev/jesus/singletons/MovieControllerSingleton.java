package dev.jesus.singletons;

import dev.jesus.controllers.MovieController;

public class MovieControllerSingleton {

    private static final MovieController INSTANCE = new MovieController();

    private MovieControllerSingleton() {
    }

    public static MovieController getInstance() {
        return INSTANCE;
    }
}
