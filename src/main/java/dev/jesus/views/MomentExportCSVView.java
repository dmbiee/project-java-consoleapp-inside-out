package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.controllers.MovieController;
import dev.jesus.singletons.MomentControllerSingleton;
import dev.jesus.singletons.MovieControllerSingleton;

public class MomentExportCSVView {

  private static final String CSV_FILE_PATH = "src/main/java/dev/jesus/db/csv/moments.csv";
  private static final String CSV_FILE_PATH_MOVIE = "src/main/java/dev/jesus/db/csv/movies.csv";

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
  private static MovieController CONTROLLER_MOVIE = MovieControllerSingleton.getInstance();

  public static void printCSVinfo() {
    System.out.println("Exporting moments to: " + CSV_FILE_PATH);
    System.out.println("Exporting movies to: " + CSV_FILE_PATH_MOVIE);

    try {
      CONTROLLER.exportMomentsToCSV(CSV_FILE_PATH);
      System.out.println("Moment exported.");

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }
    try {
      CONTROLLER_MOVIE.exportMomentsToCSV(CSV_FILE_PATH_MOVIE);
      System.out.println("Movie exported.");

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}
