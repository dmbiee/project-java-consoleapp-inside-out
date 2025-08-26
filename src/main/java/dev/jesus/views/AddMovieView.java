package dev.jesus.views;

import dev.jesus.services.MovieService;
import dev.jesus.singletons.MovieServiceSingleton;

public class AddMovieView extends View {

    private static MovieService SERVICE = MovieServiceSingleton.getInstance();

    public static void addMovie() {
        SERVICE.buildMovieDto();
        HomeView.printMainMenu();
    }

    public static String printAddMovie() {

        String messageText = "What movie did you watch?";
        String inputText = "Enter the movie title: ";

        System.out.println("\n");
        System.out.println(messageText);
        System.out.print(inputText);

        String title = SCANNER.next();

        return title;

    }

    public static void isCorrectMovie(String titleMovie, int realiseYear, String actors) {

        String messageText = "Did you mean you watched the movie %s %d with actors %s?"
                .formatted(titleMovie, realiseYear, actors);

        String inputText = "Enter your answer (y/n): ";

        System.out.println("\n");
        System.out.println(messageText);
        System.out.print(inputText);

        String answer = SCANNER.next();

        SERVICE.setIsCorrectMovie(answer);

    }

}
