package dev.jesus.controllers;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import dev.jesus.db.MovieCSVStorage;
import dev.jesus.repositories.MovieRepository;
import dev.jesus.singletons.MovieRepositorySingleton;

public class MovieController {

    private MovieRepository repository;
    private MovieCSVStorage csvStorage;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
        this.csvStorage = new MovieCSVStorage();
    }

    public String confirmMovie() {

        return null;
    }

    public String getIDMovieFromApiByTitle(String MovieTitle) {

        String encodedQuery = URLEncoder.encode(MovieTitle, StandardCharsets.UTF_8);
        String url = "https://imdb.iamidiotareyoutoo.com/search?q=" + encodedQuery;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Get ERROR when try make request to API", e);
        }
        Gson gson = new Gson();

        System.out.println(response.body());
        return null;
    }

    public void StoreMoment() {

    }

}