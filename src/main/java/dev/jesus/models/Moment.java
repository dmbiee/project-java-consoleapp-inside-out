package dev.jesus.models;

import java.security.MessageDigest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {

  private String id;
  private String title;
  private LocalDate date;
  private String description;
  private EmotionEnum emotion;
  private boolean isPositive;
  private LocalDateTime recordDate;
  private LocalDateTime updateDate;

  public Moment(String title, LocalDate date, String description, EmotionEnum emotion, boolean isPositive) {
    this.title = title;
    this.date = date;
    this.description = description;
    this.emotion = emotion;
    this.isPositive = isPositive;
    this.setId();
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
  }

  public LocalDateTime getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(LocalDateTime recordDate) {
    this.recordDate = recordDate;
  }

  public String getId() {
    return id;
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

  private void setId() {

    long utcMillis = Instant.now().toEpochMilli();
    String data = utcMillis + "|" + title + "|" + date.toString() + "|" + description + "|" + emotion + "|"
        + isPositive;

    try {

      byte[] dataBytes = data.getBytes();
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] hashBytes = messageDigest.digest(dataBytes);

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 4; i++) {
        sb.append(String.format("%02x", hashBytes[i]));
      }

      String id = sb.toString();
      System.out.println(id);

      this.id = id;

    } catch (Exception e) {
      throw new RuntimeException("Failed to generate ID", e);
    }
    // this.id = "M-" + UUID.randomUUID();
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEmotion(EmotionEnum emotion) {
    this.emotion = emotion;
  }

  public void setPositive(boolean isPositive) {
    this.isPositive = isPositive;
  }
}
