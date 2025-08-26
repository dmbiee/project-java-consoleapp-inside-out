package dev.jesus.services;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import dev.jesus.models.MovieDetailsApiResponse;
import dev.jesus.models.MovieShortFromApi;
import dev.jesus.models.SearchApiResponse;
import dev.jesus.views.AddMovieView;

public class MovieService {

    private String isCorrectMovie;

    public void setIsCorrectMovie(String isCorrectMovie) {
        this.isCorrectMovie = isCorrectMovie;
    }

    public String getMovieDataFromJson(String jsonString) {

        Gson gson = new Gson();

        MovieDetailsApiResponse apiResponse = gson.fromJson(jsonString, MovieDetailsApiResponse.class);

        System.out.println(apiResponse);

        return null;
    }

    public String getIDMovieFromApiByTitle(String MovieTitle) {

        String jsonString = getJsonStringFromApiByTitle(MovieTitle);

        Gson gson = new Gson();

        SearchApiResponse apiResponse = gson.fromJson(jsonString, SearchApiResponse.class);

        for (MovieShortFromApi movie : apiResponse.description) {
            System.out.println("------------------");

            AddMovieView.isCorrectMovie(movie.title, movie.year, movie.actors);

            if (isCorrectMovie.equals("y")) {
                return movie.imdbId;
            }
        }

        return null;
    }

    public String getJsonStringFromApiByTitle(String movieTitle) {

        String encodedQuery = URLEncoder.encode(movieTitle, StandardCharsets.UTF_8);
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
        return response.body();
    }

    public String getJsonStringFromApiByImdbid(String imdbid) {

        String encodedQuery = URLEncoder.encode(imdbid, StandardCharsets.UTF_8);
        String url = "https://imdb.iamidiotareyoutoo.com/search?tt=" + encodedQuery;

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
        // System.out.println(response.body());
        return response.body();
    }
}
