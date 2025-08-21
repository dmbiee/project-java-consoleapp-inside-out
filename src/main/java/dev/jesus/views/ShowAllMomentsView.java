package dev.jesus.views;

import java.time.LocalDate;
import java.util.List;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.singletons.MomentControllerSingleton;

public class ShowAllMomentsView {

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printAllMoments() {
    List<MomentResponseDTO> moments = CONTROLLER.GetDB();

    if (moments.isEmpty()) {
      System.out.println("There aren't saved moments. \n");
      HomeView.printMainMenu();
      return;
    }

    System.out.println("\nList of lived moments:");
    for (MomentResponseDTO moment : moments) {

      LocalDate date = moment.date();
      int year = date.getYear();
      int month = date.getMonthValue();
      int day = date.getDayOfMonth();

      System.out.print("""
          %s. It happened in: %d/%d/%d. Title: %s. Description: %s. Emotion: %s %s.
          """.formatted(
          moment.id(),
          day, month, year,
          moment.title(),
          moment.description(),
          moment.isPositive(),
          moment.emotion()));
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}