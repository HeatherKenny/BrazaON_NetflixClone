package com.BrazaON.model;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String overview;
    private String poster_path;
    private Double vote_average;
    private String release_date;
}
