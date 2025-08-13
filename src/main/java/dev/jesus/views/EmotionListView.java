package dev.jesus.views;

public class EmotionListView extends View {

  public static int printEmotionList() {
    int orderNum = 1;

    System.out.println("Select an emotion:");

    for (EmotionEnum emotion : EmotionEnum.values()) {
      System.out.println(orderNum + ". " + emotion);
      orderNum++;
    }

    System.out.print("\nEnter your option: ");

    int option = SCANNER.nextInt();
    return option;
  }

}
