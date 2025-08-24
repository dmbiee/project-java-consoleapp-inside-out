package dev.jesus.models;

import com.google.gson.annotations.SerializedName;

public class MovieFromApi {
    @SerializedName("#TITLE")
    public String title;

    @SerializedName("#YEAR")
    public int year;

    @SerializedName("#IMDB_ID")
    public String imdbId;

    @SerializedName("#ACTORS")
    public String actors;
}
