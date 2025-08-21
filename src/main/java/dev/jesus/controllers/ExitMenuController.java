package dev.jesus.controllers;

import dev.jesus.views.ExitMenuView;

public class ExitMenuController {
  public static void exitFromTheProgram() {
    ExitMenuView.printExitMessage();
    System.exit(0);
  }
}
