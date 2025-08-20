package dev.jesus.models;

import java.time.LocalDate;

public class Moment {

  private String title;
  private LocalDate date;
  private String description;
  private EmotionEnum emotion;
  private boolean isPositive;

  public Moment(String title, LocalDate date, String description, EmotionEnum emotion, boolean isPositive) {
    this.title = title;
    this.date = date;
    this.description = description;
    this.emotion = emotion;
    this.isPositive = isPositive;
  }

  public boolean isPositive() {
    return isPositive;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public EmotionEnum getEmotion() {
    return emotion;
  }
}
