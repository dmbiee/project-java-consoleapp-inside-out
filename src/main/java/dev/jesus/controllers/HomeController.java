package dev.jesus.controllers;

import dev.jesus.views.HomeView;

public class HomeController {

  public HomeController() {
    index();
  }

  public void index() {
    HomeView.printMainMenu();
  }
}
