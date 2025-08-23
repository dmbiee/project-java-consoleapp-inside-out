package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.singletons.MomentControllerSingleton;

public class AddMovieView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printAddMovie() {

        String messageText = "What movie did you watch?";
        String inputText = "Enter the movie title: ";

        System.out.println("\n");
        System.out.println(messageText);
        System.out.print(inputText);

        String title = SCANNER.next();

        System.out.println(title);

    }
}
