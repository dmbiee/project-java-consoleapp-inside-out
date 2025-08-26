package dev.jesus.views;

import java.util.List;

import dev.jesus.controllers.MovieController;
import dev.jesus.dtos.MovieDTO;
import dev.jesus.singletons.MovieControllerSingleton;

public class ShowAllMoviesView extends View {

    private static MovieController CONTROLLER = MovieControllerSingleton.getInstance();

    public static void printAllMoments() {
        List<MovieDTO> movies = CONTROLLER.getDB();

        if (movies.isEmpty()) {
            System.out.println("There aren't saved movies. \n");
            HomeView.printMainMenu();
            return;
        }

        System.out.println("\nList of lived movies:");
        for (MovieDTO movie : movies) {
            PrintMovie.printMovie(movie);
        }

        System.out.println("");
        HomeView.printMainMenu();
    }

}
