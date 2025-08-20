package dev.jesus.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.jesus.controllers.FilterMenuController;
import dev.jesus.models.EmotionEnum;

public class FilterMomentMenuView extends View {
  public static void printFilterMenu() {
    String filterMenu = """
        Filter by ...:
        1. Emotion
        2. Date
        Enter an option: """;

    System.out.print(filterMenu + " ");

    int option = SCANNER.nextInt();

    FilterMenuController.filterMenuController(option);
  }

  public static LocalDate askForDay() {
    LocalDate localDate;
    String dateText = "Enter the date (dd/mm/year): ";
    String patternCodeDate = "dd/MM/yyyy";

    System.out.println(dateText);
    String date = SCANNER.next();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternCodeDate);
    localDate = LocalDate.parse(date, formatter);

    return localDate;
  }
}
