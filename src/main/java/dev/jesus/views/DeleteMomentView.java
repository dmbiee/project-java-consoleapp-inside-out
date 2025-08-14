package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.singletons.MomentControllerSingleton;

public class DeleteMomentView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printDeleteMoment() {
        System.out.print("\nEnter the identifier of the moment: ");

        int option = SCANNER.nextInt();
        int idMoment = option - 1;

        CONTROLLER.deleteMoment(idMoment);

        System.out.println("Moment successfully deleted.\n");

        HomeView.printMainMenu();
    }
}
