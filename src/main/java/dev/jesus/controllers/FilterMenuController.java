package dev.jesus.controllers;

import java.time.LocalDate;

import dev.jesus.models.EmotionEnum;
import dev.jesus.views.EmotionListView;
import dev.jesus.views.FilterMomentMenuView;
import dev.jesus.views.FilterMomentView;

public class FilterMenuController {

  public static void filterMenuController(int option) {

    if (option == 1) {
      EmotionEnum emotion = EmotionListView.printEmotionList();
      FilterMomentView.printFilteredList(emotion);
    }

    if (option == 2) {
      LocalDate localDate = FilterMomentMenuView.askForDay();
      FilterMomentView.printFilteredList(localDate);
    }
    if (option == 3) {
      FilterMomentView.printFilteredList(true); // Positivos
    }

    if (option == 4) {
      FilterMomentView.printFilteredList(false); // Negativos
    }
  }

}
