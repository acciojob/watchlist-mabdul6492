package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Repository
public class MovieRepository {

    HashMap<String, Movie> movies = new HashMap<>();
    HashMap<String, Director> directors = new HashMap<>();
    HashMap<String, List<String>> directorMovies = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        String directorName = director.getName();
        directors.put(directorName, director);

        if(!directorMovies.containsKey(directorName))
            directorMovies.put(directorName, new ArrayList<>());
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        directorMovies.get(directorName).add(movieName);
    }

    public Movie getMovie(String movieName) {
        return movies.get(movieName);
    }

    public Director getDirector(String directorName) {
        return directors.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return directorMovies.get(directorName);
    }

    public Set<String> getAllMovies() {
        return movies.keySet();
    }

    public void deleteDirectorByName(String directorName) {
        directors.remove(directorName);
        List<String> allMovies = directorMovies.remove(directorName);
        for(String movie: allMovies){
            movies.remove(movie);
        }
    }

    public void deleteAllDirectors() {
        Set<String> allDirectors = directorMovies.keySet();
        for(String director: allDirectors){
            deleteDirectorByName(director);
        }
    }
}
