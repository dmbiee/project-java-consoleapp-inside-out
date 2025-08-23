package dev.jesus.views;

import dev.jesus.controllers.MainMenuController;

public class HomeView extends View {

  public static void printMainMenu() {

    String mainMenu = """
        My diary:
        1. Add moment
        2. See all available times
        3. Delete a moment
        4. Filter the moments
        5. Add movie
        6. Export to CSV

        7. Exit

        Select an option:  """;

    System.out.print(mainMenu + " ");

    int option = SCANNER.nextInt();

    MainMenuController.mainMenuController(option);
  }

}
