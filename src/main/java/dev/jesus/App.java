package dev.jesus;

import dev.jesus.controllers.HomeController;
import dev.jesus.controllers.MovieController;
import dev.jesus.singletons.MovieControllerSingleton;

public final class App {

    public static void main(String[] args) {

        // new HomeController();

        MovieController mc = MovieControllerSingleton.getInstance();

        // mc.getIDMovieFromApiByTitle("Spiderman");
        mc.getJsonStringFromApiByImdbid("tt2250912");

    }
}
