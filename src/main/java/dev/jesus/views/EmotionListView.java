package dev.jesus.views;

import dev.jesus.models.EmotionEnum;

public class EmotionListView extends View {

  public static EmotionEnum printEmotionList() {
    int orderNum = 1;

    System.out.println("Select an emotion:");

    for (EmotionEnum emotion : EmotionEnum.values()) {
      System.out.println(orderNum + ". " + emotion);
      orderNum++;
    }

    System.out.print("\nEnter your option: ");
    int option = SCANNER.nextInt();

    if (option < 1 || option > EmotionEnum.values().length) {
      System.out.println("Emoción inválida");
      printEmotionList();
    }

    return EmotionEnum.values()[option - 1];
  }

}
