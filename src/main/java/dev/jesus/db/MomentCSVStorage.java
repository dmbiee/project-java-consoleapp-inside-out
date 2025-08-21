package dev.jesus.db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import dev.jesus.models.Moment;

public class MomentCSVStorage {

  private static final String DELIMETER = ";";
  private static final String NEW_LINE = "\n";
  private static final String HEADER = "ID;Title;Date;Description;Emotion;IsPositive";

  public void exportMomentsToCsv(List<Moment> moments, String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write(HEADER);
      writer.write(NEW_LINE);

      for (Moment moment : moments) {
        StringBuilder sb = new StringBuilder();
        sb.append(moment.getId()).append(DELIMETER)
            .append(moment.getTitle()).append(DELIMETER)
            .append(moment.getDate()).append(DELIMETER)
            .append(moment.getDescription()).append(DELIMETER)
            .append(moment.getEmotion()).append(DELIMETER)
            .append(moment.isPositive()).append(DELIMETER);

        writer.write(sb.toString());
        writer.write(NEW_LINE);
      }

      System.out.println("CSV exported in: " + filePath);

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }
  }
}
