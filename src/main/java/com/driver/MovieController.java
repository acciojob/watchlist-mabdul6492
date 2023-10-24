package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return ResponseEntity.ok("success");
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie, director);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovie(name);
        return ResponseEntity.ok(movie);
    }

    @GetMapping(" /movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirector(name);
        return ResponseEntity.ok(director);
    }

    @GetMapping(" /movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> allMoviesByDirector = movieService.getMoviesByDirectorName(director);
        return ResponseEntity.ok(allMoviesByDirector);
    }

    @GetMapping(" /movies/get-all-movies")
    public ResponseEntity<Set<String>> findAllMovies(){
        Set<String> allMovies = movieService.getAllMovies();
        return ResponseEntity.ok(allMovies);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return ResponseEntity.ok("success");
    }

}
