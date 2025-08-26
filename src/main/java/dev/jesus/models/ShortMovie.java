package dev.jesus.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ShortMovie {

    @SerializedName("name")
    public String title;

    @SerializedName("genre")
    public List<String> genre;

    @SerializedName("datePublished")
    public String releasedate;
}
