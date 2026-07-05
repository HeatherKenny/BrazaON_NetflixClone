package com.BrazaON.model;

import lombok.Data;
import java.util.Locale;

@Data
public class Movie {
    private Long id;
    private String title;
    private String name;
    private String overview;
    private String poster_path;
    private Double vote_average;
    private String release_date;
    private String first_air_date;

    public String getDisplayName() {
        return title != null ? title : name;
    }

    public String getDisplayDate() {
        String date = release_date != null ? release_date : first_air_date;
        if (date != null && date.length() >= 4) {
            return date.substring(0, 4);
        }
        return "N/A";
    }

    public String getDisplayRating() {
        if (vote_average == null) return "0,0";
        return String.format(Locale.GERMAN, "%.1f", vote_average);
    }
}
