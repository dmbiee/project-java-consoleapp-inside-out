package dev.jesus.services;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;

import dev.jesus.controllers.MovieController;
import dev.jesus.dtos.MovieDTO;
import dev.jesus.models.EmotionEnum;
import dev.jesus.models.MovieDetailsApiResponse;
import dev.jesus.models.MovieShortFromApi;
import dev.jesus.models.SearchApiResponse;
import dev.jesus.models.ShortMovie;
import dev.jesus.singletons.MovieControllerSingleton;
import dev.jesus.views.AddMovieView;
import dev.jesus.views.EmotionListView;

public class MovieService {

    MovieController CONTROLLER = MovieControllerSingleton.getInstance();

    private String isCorrectMovie;

    public void setIsCorrectMovie(String isCorrectMovie) {
        this.isCorrectMovie = isCorrectMovie;
    }

    public void buildMovieDto() {

        String movieTitleFromUser = AddMovieView.printAddMovie();
        String imdbid = getIDMovieFromApiByTitle(movieTitleFromUser);
        ShortMovie movieDetails = getMovieDataFromJson(getJsonStringFromApiByImdbid(imdbid));

        String movieTitle = movieDetails.title;
        List<String> genre = movieDetails.genre;

        String patternCodeDate = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternCodeDate);
        LocalDate releaseDate = LocalDate.parse(movieDetails.releasedate, formatter);

        EmotionEnum emocion = EmotionListView.printEmotionList();

        LocalDate createMovieNoteDate = LocalDate.now();

        MovieDTO movieDTO = new MovieDTO(imdbid, movieTitle, genre, emocion, releaseDate, createMovieNoteDate);

        CONTROLLER.StoreMovie(movieDTO);

    }

    public ShortMovie getMovieDataFromJson(String jsonString) {

        Gson gson = new Gson();

        MovieDetailsApiResponse apiResponse = gson.fromJson(jsonString, MovieDetailsApiResponse.class);

        return apiResponse.shortMovie;
    }

    public String getIDMovieFromApiByTitle(String MovieTitle) {

        String jsonString = getJsonStringFromApiByTitle(MovieTitle);

        Gson gson = new Gson();

        SearchApiResponse apiResponse = gson.fromJson(jsonString, SearchApiResponse.class);

        for (MovieShortFromApi movie : apiResponse.description) {

            System.out.println("------------------");

            AddMovieView.isCorrectMovie(movie.title, movie.year, movie.actors);

            if (isCorrectMovie.equals("y")) {

                setIsCorrectMovie("");
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
        return response.body();
    }
}
