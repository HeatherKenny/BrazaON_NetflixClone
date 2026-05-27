package com.BrazaON.controller;

import com.BrazaON.model.Movie;
import com.BrazaON.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/popular")
    public List<Movie> getPopular() {
        return tmdbService.getPopularMovies();
    }
}
