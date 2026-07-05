package com.BrazaON.service;

import com.BrazaON.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TmdbService {

    @Value("${tmdb.api.key:fc9bf6c0708add80d7a5305f176f78e8}")
    private String apiKey;

    private final String BASE_URL = "https://api.themoviedb.org/3";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getTop10Movies() {
        String url = String.format("%s/discover/movie?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=vote_average.desc&vote_count.gte=100", BASE_URL, apiKey);
        return fetchLimited(url, 10);
    }

    public List<Movie> getPremiadosMovies() {
        String url = String.format("%s/discover/movie?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=vote_average.desc&vote_count.gte=500", BASE_URL, apiKey);
        return fetchLimited(url, 20);
    }

    public List<Movie> getRecemAdicionadosMovies() {
        String url = String.format("%s/discover/movie?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=release_date.desc", BASE_URL, apiKey);
        return fetchLimited(url, 20);
    }

    public List<Movie> getTop10Series() {
        String url = String.format("%s/discover/tv?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=vote_average.desc&vote_count.gte=50", BASE_URL, apiKey);
        return fetchLimited(url, 10);
    }

    public List<Movie> getPremiadosSeries() {
        String url = String.format("%s/discover/tv?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=vote_average.desc&vote_count.gte=100", BASE_URL, apiKey);
        return fetchLimited(url, 20);
    }

    public List<Movie> getRecemAdicionadosSeries() {
        String url = String.format("%s/discover/tv?api_key=%s&language=pt-BR&with_origin_country=BR&sort_by=first_air_date.desc", BASE_URL, apiKey);
        return fetchLimited(url, 20);
    }

    public List<Movie> searchAll(String query) {
        String url = String.format("%s/search/multi?api_key=%s&language=pt-BR&query=%s&region=BR", BASE_URL, apiKey, query);
        return fetchMovies(url);
    }

    private List<Movie> fetchLimited(String url, int limit) {
        List<Movie> movies = fetchMovies(url);
        return movies.stream().limit(limit).collect(Collectors.toList());
    }

    private List<Movie> fetchMovies(String url) {
        if (apiKey == null || apiKey.equals("YOUR_API_KEY_HERE") || apiKey.isEmpty()) {
            return Collections.emptyList();
        }
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response == null || !response.containsKey("results")) {
                return Collections.emptyList();
            }
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
            return results.stream().map(this::mapToMovie).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private Movie mapToMovie(Map<String, Object> map) {
        Movie movie = new Movie();
        movie.setId(map.get("id") != null ? Long.valueOf(map.get("id").toString()) : 0L);
        movie.setTitle((String) map.get("title"));
        movie.setName((String) map.get("name"));
        movie.setOverview((String) map.get("overview"));
        movie.setPoster_path((String) map.get("poster_path"));
        movie.setVote_average(map.get("vote_average") != null ? Double.valueOf(map.get("vote_average").toString()) : 0.0);
        movie.setRelease_date((String) map.get("release_date"));
        movie.setFirst_air_date((String) map.get("first_air_date"));
        return movie;
    }
}
