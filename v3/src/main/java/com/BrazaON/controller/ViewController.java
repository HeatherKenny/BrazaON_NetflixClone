package com.BrazaON.controller;

import com.BrazaON.service.TmdbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final TmdbService tmdbService;

    public ViewController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("top10Movies", tmdbService.getTop10Movies());
        model.addAttribute("premiadosMovies", tmdbService.getPremiadosMovies());
        model.addAttribute("recemMovies", tmdbService.getRecemAdicionadosMovies());
        return "index";
    }

    @GetMapping("/filmes")
    public String filmes(Model model) {
        model.addAttribute("tipo", "Filmes");
        model.addAttribute("top10", tmdbService.getTop10Movies());
        model.addAttribute("premiados", tmdbService.getPremiadosMovies());
        model.addAttribute("recem", tmdbService.getRecemAdicionadosMovies());
        return "catalogo";
    }

    @GetMapping("/series")
    public String series(Model model) {
        model.addAttribute("tipo", "Séries");
        model.addAttribute("top10", tmdbService.getTop10Series());
        model.addAttribute("premiados", tmdbService.getPremiadosSeries());
        model.addAttribute("recem", tmdbService.getRecemAdicionadosSeries());
        return "catalogo";
    }

    @GetMapping("/busca")
    public String busca(@RequestParam String q, Model model) {
        model.addAttribute("searchQuery", q);
        model.addAttribute("results", tmdbService.searchAll(q));
        return "busca";
    }
}
