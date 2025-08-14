package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.EmotionEnum;
import dev.jesus.singletons.MomentControllerSingleton;

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

    MomentResponseDTO momentDTO = new MomentResponseDTO(title, date, description, emotion);
    CONTROLLER.StoreMoment(momentDTO);

    HomeView.printMainMenu();
  }

}
