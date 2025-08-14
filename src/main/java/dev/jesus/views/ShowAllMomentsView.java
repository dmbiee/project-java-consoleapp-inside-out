package dev.jesus.views;

import java.util.List;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.singletons.MomentControllerSingleton;

public class ShowAllMomentsView {

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printAllMoments() {
    int momentIndex = 1;
    List<MomentRequestDTO> moments = CONTROLLER.GetDB();

    if (moments.isEmpty()) {
      System.out.println("There aren't saved moments.");
      HomeView.printMainMenu();
    }

    System.out.println("\nList of lived moments:");
    for (MomentRequestDTO moment : moments) {
      System.out.print("""
          %s. It happened in: %s. Title: %s. Description: %s. Emotion: %s.
          """.formatted(
          momentIndex,
          moment.date(),
          moment.title(),
          moment.description(),
          moment.emotion()));

      momentIndex++;
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}