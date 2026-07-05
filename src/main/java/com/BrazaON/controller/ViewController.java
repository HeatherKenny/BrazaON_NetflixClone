package com.BrazaON.controller;

import com.BrazaON.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", tmdbService.getPopularMovies());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        model.addAttribute("movies", tmdbService.searchMovies(query));
        model.addAttribute("searchQuery", query);
        return "index";
    }
}
