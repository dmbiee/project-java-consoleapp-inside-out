package dev.jesus.views;

import java.time.LocalDate;

import dev.jesus.dtos.MomentResponseDTO;

public class PrintMoment {

  public static void printMoment(MomentResponseDTO moment) {
    LocalDate date = moment.date();
    int year = date.getYear();
    int month = date.getMonthValue();
    int day = date.getDayOfMonth();

    System.out.print("""
        %s. It happened in: %d/%d/%d. Title: %s. Description: %s. Emotion: %s.
        """.formatted(
        moment.id(),
        day, month, year,
        moment.title(),
        moment.description(),
        moment.emotion()));
  }
}
