package dev.jesus.models;

import java.time.LocalDate;
import java.util.List;

public class Movie {

    private String imdbid;
    private String title;
    private List<String> genre;
    private EmotionEnum emocion;
    private LocalDate releaseMovieDate;
    private LocalDate createMovieNoteDate;

    public Movie(String imdbid, String title, List<String> genre, EmotionEnum emocion, LocalDate releaseMovieDate,
            LocalDate createMovieNoteDate) {
        this.imdbid = imdbid;
        this.title = title;
        this.genre = genre;
        this.emocion = emocion;
        this.releaseMovieDate = releaseMovieDate;
        this.createMovieNoteDate = createMovieNoteDate;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public void setEmocion(EmotionEnum emocion) {
        this.emocion = emocion;
    }

    public void setReleaseMovieDate(LocalDate releaseMovieDate) {
        this.releaseMovieDate = releaseMovieDate;
    }

    public void setCreateMovieNoteDate(LocalDate createMovieNoteDate) {
        this.createMovieNoteDate = createMovieNoteDate;
    }

    public String getImdbid() {
        return imdbid;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public EmotionEnum getEmocion() {
        return emocion;
    }

    public LocalDate getReleaseMovieDate() {
        return releaseMovieDate;
    }

    public LocalDate getCreateMovieNoteDate() {
        return createMovieNoteDate;
    }

}