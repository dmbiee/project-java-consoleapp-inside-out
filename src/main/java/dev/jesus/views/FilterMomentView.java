package dev.jesus.views;

import java.time.LocalDate;
import java.util.List;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.EmotionEnum;
import dev.jesus.singletons.MomentControllerSingleton;

public class FilterMomentView extends View {

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printFilteredList(EmotionEnum emotion) {
    int momentIndex = 1;
    List<MomentResponseDTO> moments = CONTROLLER.filterByEmotion(emotion);

    if (moments.isEmpty()) {
      System.out.println("There aren't saved moments. \n");
      HomeView.printMainMenu();
      return;
    }

    System.out.println("\nList of lived moments filtered by %s emotion: ".formatted(emotion));
    for (MomentResponseDTO moment : moments) {

      LocalDate date = moment.date();
      int year = date.getYear();
      int month = date.getMonthValue();
      int day = date.getDayOfMonth();

      System.out.print("""
          %s. It happened in: %d/%d/%d. Title: %s. Description: %s. Emotion: %s.
          """.formatted(
          momentIndex,
          day, month, year,
          moment.title(),
          moment.description(),
          moment.emotion()));

      momentIndex++;
    }

    System.out.println("");
    HomeView.printMainMenu();
  }

  public static void printFilteredList(LocalDate localDate) {
    int momentIndex = 1;
    List<MomentResponseDTO> moments = CONTROLLER.filterByDate(localDate);

    if (moments.isEmpty()) {
      System.out.println("There aren't saved moments. \n");
      HomeView.printMainMenu();
      return;
    }

    System.out.println("\nList of lived moments filtered by %s day: ".formatted(localDate));
    for (MomentResponseDTO moment : moments) {

      LocalDate date = moment.date();
      int year = date.getYear();
      int month = date.getMonthValue();
      int day = date.getDayOfMonth();

      System.out.print("""
          %s. It happened in: %d/%d/%d. Title: %s. Description: %s. Emotion: %s.
          """.formatted(
          momentIndex,
          day, month, year,
          moment.title(),
          moment.description(),
          moment.emotion()));

      momentIndex++;
    }

    System.out.println("");
    HomeView.printMainMenu();
  }
}
