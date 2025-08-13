package dev.jesus.controllers;

import dev.jesus.views.AddMomentView;
import dev.jesus.views.ShowAllMomentsView;

public class MainMenuController {

  public static void mainMenuController(int option) {

    if (option == 1)
      AddMomentView.printAddMoment();

    if (option == 2)
      ShowAllMomentsView.printAllMoments();
  }
}
