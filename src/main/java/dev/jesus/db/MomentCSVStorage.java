package dev.jesus.db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import dev.jesus.models.Moment;

public class MomentCSVStorage {

  private static final String DELIMITER = ";";
  private static final String NEW_LINE = "\n";
  private static final String HEADER = "ID;Title;Date;Description;Emotion;IsPositive;RecordDate;UpdateDate;";

  public void exportMomentsToCsv(List<Moment> moments, String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write(HEADER);
      writer.write(NEW_LINE);

      for (Moment moment : moments) {
        StringBuilder sb = new StringBuilder();
        sb.append(moment.getId()).append(DELIMITER)
            .append(moment.getTitle()).append(DELIMITER)
            .append(moment.getDate()).append(DELIMITER)
            .append(moment.getDescription()).append(DELIMITER)
            .append(moment.getEmotion()).append(DELIMITER)
            .append(moment.isPositive()).append(DELIMITER)
            .append(moment.getRecordDate()).append(DELIMITER)
            .append(moment.getUpdateDate());

        writer.write(sb.toString());
        writer.write(NEW_LINE);
      }

      System.out.println("CSV exported in: " + filePath);

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }
  }
}
