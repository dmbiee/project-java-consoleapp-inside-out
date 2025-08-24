package dev.jesus;

import dev.jesus.controllers.HomeController;
import dev.jesus.controllers.MovieController;

public final class App {

    public static void main(String[] args) {

        // new HomeController();

        MovieController mc = new MovieController();

        mc.getIDMovieFromApiByTitle("Spiderman");

    }
}
