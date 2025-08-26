package dev.jesus.controllers;

import dev.jesus.views.AddMomentView;
import dev.jesus.views.AddMovieView;
import dev.jesus.views.DeleteMomentView;
import dev.jesus.views.DeleteMovieView;
import dev.jesus.views.FilterMomentMenuView;
import dev.jesus.views.MomentExportCSVView;
import dev.jesus.views.ShowAllMomentsView;
import dev.jesus.views.ShowAllMoviesView;

public class MainMenuController {

  public static void mainMenuController(int option) {

    if (option == 1)
      AddMomentView.printAddMoment();

    if (option == 2)
      ShowAllMomentsView.printAllMoments();

    if (option == 3)
      DeleteMomentView.printDeleteMoment();

    if (option == 4)
      FilterMomentMenuView.printFilterMenu();

    if (option == 5)
      AddMovieView.addMovie();

    if (option == 6)
      ShowAllMoviesView.printAllMoments();

    if (option == 7)
      DeleteMovieView.deleteMovie();

    if (option == 8)
      MomentExportCSVView.printCSVinfo();

    if (option == 9)
      ExitMenuController.exitFromTheProgram();
  }
}
