package dev.jesus;

import dev.jesus.services.MovieService;
import dev.jesus.singletons.MovieServiceSingleton;

public final class App {

    public static void main(String[] args) {

        // new HomeController();

        MovieService ms = MovieServiceSingleton.getInstance();

        // mc.getIDMovieFromApiByTitle("Spiderman");
        String rs = ms.getJsonStringFromApiByImdbid("tt2250912");
        ms.getMovieDataFromJson(rs);

    }
}
