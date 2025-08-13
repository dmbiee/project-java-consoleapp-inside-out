package dev.jesus.controllers;

import dev.jesus.views.AddMomentView;

public class MainMenuController {

  public static void mainMenuController(int option) {

    if (option == 1)
      AddMomentView.printAddMoment();
  }

}
