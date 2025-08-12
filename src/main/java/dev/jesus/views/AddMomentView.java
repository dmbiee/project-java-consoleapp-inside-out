package dev.jesus.views;

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

        int emotionNumber = EmotionListView.printEmotionList();
    }
}
