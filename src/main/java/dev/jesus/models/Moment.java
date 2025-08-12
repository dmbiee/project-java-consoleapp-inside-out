package dev.jesus.models;

public class Moment {

    private String title;
    private String date;
    private String description;
    private String emotion;

    public Moment(String title, String date, String description, String emotion) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.emotion = emotion;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getEmotion() {
        return emotion;
    }

}
