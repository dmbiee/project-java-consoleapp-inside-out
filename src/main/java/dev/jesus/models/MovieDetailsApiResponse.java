package dev.jesus.models;

import com.google.gson.annotations.SerializedName;

public class MovieDetailsApiResponse {

    @SerializedName("short")
    public ShortMovie shortMovie;

    @SerializedName("imdbid")
    public String imdbid;
}
