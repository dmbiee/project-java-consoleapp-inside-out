package dev.jesus.controllers;

import dev.jesus.views.ExitMenuView;

public class ExitMenuController {
    public static void exitFromTheProgramm() {
        ExitMenuView.exitMessage();
        System.exit(0);
    }
}
