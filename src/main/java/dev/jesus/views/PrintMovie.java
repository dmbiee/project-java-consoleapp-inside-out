package dev.jesus.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import dev.jesus.dtos.MovieDTO;
import dev.jesus.models.EmotionEnum;

public class PrintMovie {

    public static void printMovie(MovieDTO movie) {

        String imdbid = movie.imdbid();
        String title = movie.title();
        int realiseYear = movie.releaseMovieDate().getYear();

        LocalDate date = movie.createMovieNoteDate();
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String formattedDate = date.format(pattern);

        EmotionEnum emotion = movie.emocion();

        System.out.println("""
                %s | you watched the movie %s %d - %s. it evoked the emotion %s.
                        """.formatted(imdbid, title, realiseYear, formattedDate, emotion));
    }

}
