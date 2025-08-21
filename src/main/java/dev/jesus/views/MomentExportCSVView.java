package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.singletons.MomentControllerSingleton;

public class MomentExportCSVView {

  private static final String CSV_FILE_PATH = "src/main/java/dev/jesus/db/csv/moments.csv";
  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printCSVinfo() {
    System.out.println("Exporting moments to: " + CSV_FILE_PATH);

    try {
      CONTROLLER.exportMomentsToCSV(CSV_FILE_PATH);
      System.out.println("Moment exported.");

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}
