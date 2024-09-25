package org.moviesystem;

import java.util.List;

class Movie {
    private String title;
    private String genre;
    private List<Show> shows; // A movie has multiple shows

    public Movie(String title, String genre, List<Show> shows) {
        this.title = title;
        this.genre = genre;
        this.shows = shows;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Show getShowByTime(String showTime) {
        for (Show show : shows) {
            if (show.getShowTime().equals(showTime)) {
                return show;
            }
        }
        return null; // If no matching show is found
    }
    public List<Show> getShows()
    {
        return shows;
    }

    @Override
    public String toString() {
        return "Movie Title: " + title + ", Genre: " + genre + ", Shows: " + shows;
    }
}

