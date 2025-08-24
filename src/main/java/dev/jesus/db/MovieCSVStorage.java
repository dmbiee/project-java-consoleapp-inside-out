package dev.jesus.db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import dev.jesus.models.Movie;

public class MovieCSVStorage {

  private final String DELIMITER = ";";
  private final String NEW_LINE = "\n";
  private final String HEADER = "ImdbID;Title;Genre;Emotion;ReleaseMovieDate;CreateMovieNoteDate;";

  public void exportMovieToCsv(List<Movie> movies, String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

      writer.write(HEADER);
      writer.write(NEW_LINE);

      for (Movie movie : movies) {
        StringBuilder sb = new StringBuilder();
        sb.append(movie.getImdbid()).append(DELIMITER)
            .append(movie.getTitle()).append(DELIMITER)
            .append(String.join(", ", movie.getGenre())).append(DELIMITER)
            .append(movie.getEmocion()).append(DELIMITER)
            .append(movie.getReleaseMovieDate()).append(DELIMITER)
            .append(movie.getCreateMovieNoteDate());

        writer.write(sb.toString());
        writer.write(NEW_LINE);
      }

      System.out.println("CSV exported in: " + filePath);

    } catch (Exception e) {
      throw new RuntimeException("Error exporting CSV", e);
    }
  }
}
