package com.BrazaON.controller;

import com.BrazaON.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", tmdbService.getPopularMovies());
        return "index";
    }
}
