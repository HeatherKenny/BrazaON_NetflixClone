package com.BrazaON.controller;

import com.BrazaON.model.Movie;
import com.BrazaON.service.TmdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final TmdbService tmdbService;

    public MovieController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/popular")
    public List<Movie> getPopular() {
        return tmdbService.getTop10Movies();
    }

    @GetMapping("/search")
    public List<Movie> search(@RequestParam String q) {
        return tmdbService.searchAll(q);
    }
}
