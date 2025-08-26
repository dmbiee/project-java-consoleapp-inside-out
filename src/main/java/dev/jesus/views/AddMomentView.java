package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.models.EmotionEnum;
import dev.jesus.singletons.MomentControllerSingleton;

public class AddMomentView extends View {

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printAddMoment() {

    String titleText = "Enter the title: ";
    String dateText = "Enter the date (dd/mm/year): ";
    String descriptionText = "Enter the description: ";
    String isPositiveText = "Moment was Positive (Y/N): ";

    System.out.print(titleText);
    String title = SCANNER.next();

    System.out.print(dateText);
    String date = SCANNER.next();

    System.out.print(descriptionText);
    String description = SCANNER.next();

    System.out.print(isPositiveText);
    String isPositive = SCANNER.next();

    EmotionEnum emotion = EmotionListView.printEmotionList();

    MomentRequestDTO momentDTO = new MomentRequestDTO(title, date, description, emotion, isPositive);
    CONTROLLER.StoreMoment(momentDTO);
    System.out.println("\nMoment lived added correctly.\n");

    HomeView.printMainMenu();
  }

}
