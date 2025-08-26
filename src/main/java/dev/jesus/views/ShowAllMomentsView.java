package dev.jesus.views;

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
      PrintMoment.printMoment(moment);
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}