package dev.jesus.views;

import dev.jesus.dtos.MomentDTO;
import dev.jesus.models.EmotionEnum;

public class AddMomentView extends View {

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

    MomentDTO momentDTO = new MomentDTO(title, date, description, emotion);
  }

}
