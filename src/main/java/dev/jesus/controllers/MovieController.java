package dev.jesus.controllers;

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

    /*
     * 
     * 
     * Перенести То Все
     * в Сервіс!!!
     * в контроллері тільки перенаправлення,
     * мінімум логіки.
     * 
     * 
     */

    public void StoreMovie() {

    }

}