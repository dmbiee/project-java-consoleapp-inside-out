package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.singletons.MomentControllerSingleton;
import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.models.EmotionEnum;

public class AddMomentView extends View {

  private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

  public static void printAddMoment() {

    String titleText = "Enter the title: ";
    String dateText = "Enter the date (dd/mm/year): ";
    String descriptionText = "Enter the description: ";

    System.out.print(titleText);
    String title = SCANNER.next();

    System.out.print(dateText);
    String date = SCANNER.next();

    System.out.print(descriptionText);
    String description = SCANNER.next();

    EmotionEnum emotion = EmotionListView.printEmotionList();

    MomentRequestDTO momentDTO = new MomentRequestDTO(title, date, description, emotion);
    CONTROLLER.StoreMoment(momentDTO);
    System.out.println("\nMoment lived added correctly.\n");

    HomeView.printMainMenu();
  }

}
