package dev.jesus.views;

import dev.jesus.controllers.MovieController;
import dev.jesus.singletons.MovieControllerSingleton;

public class DeleteMovieView extends View {

    static MovieController CONTROLLER = MovieControllerSingleton.getInstance();

    public static void deleteMovie() {

        System.out.print("\nEnter the identifier of the movie: ");

        String idMovie = SCANNER.next();

        CONTROLLER.deleteMovie(idMovie);

        System.out.println("Movie successfully deleted.\n");

        HomeView.printMainMenu();
    }
}
